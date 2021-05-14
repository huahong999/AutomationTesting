package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test (description = " ")
    public static void validCredentials(){
        //Step 1:
        //System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriverManager.chromedriver().setup();

        //Step 2:
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        //Step 3: Fill in username with tomsnith

        // Lua chon ra cach co it code nhat :
        // BY ID
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // BY TAGNAME
//        driver.findElement(By.tagName("input")).sendKeys("tomsmith");
//        Chi duoc su dung khi tren trang do chi co mot input, hoac muon tuong tac voi doi tuong dau tien

        // BY NAME
//        driver.findElement(By.name("username")).sendKeys("tomsmith");

        // BY xpath
//        driver.findElement(By.xpath("//input")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
//        driver.findElement(By.xpath("//*[@name='username']")).sendKeys("tomsmith"); // dung tuong tu cho id
//        driver.findElement(By.xpath("//*[contains()@id='username'")).sendKeys("Tomsmith");


        // BY cssSelector
//        driver.findElement(By.cssSelector("input")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input[name=username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("[name=username]")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
//        driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");


        // Step 4 : Fill in password with SuperSecretPassword
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Step 5 : Click on Login button
        // Lua chon ra cach co it code nhat, tong quat nhat, de nhin nhat:
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

//        driver.findElement(By.className("radius")).click();

//        driver.findElement(By.xpath("//button[@class='radius']")).click();
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
 //        driver.findElement(By.xpath("//*[contains(@type, 'submit')]")).click();
//        driver.findElement(By.xpath("//*[.=' Login']")).click();
//        driver.findElement(By.xpath("//*[text()=' Login']")).click();

//        driver.findElement(By.cssSelector("button.radius")).click();
//        driver.findElement(By.cssSelector(".radius")).click();
//        driver.findElement(By.cssSelector("button[type=submit]")).click();

        // Step 6: And the honme page is appear
        String currentUrl = driver.getCurrentUrl();

        // Cach 1:
        // Assert.assertEquals(currentUrl, "https://the-internet.herokuapp.com/secure"); // so sanh chinh xac
        // Cach 2:
        Assert.assertTrue(currentUrl.contains("/secure")); // Tra ve dung sao, mang tinh may moc

        // Cach 3:
//        if(currentUrl.contains("/secure")) {
//            System.out.println("TEST PASSED");
//        }else {
//            System.out.println("TEST FAILED!!");
//        }
    }
    @Test
    public static void invalidCredentials(){
        //Step 1:
        WebDriverManager.chromedriver().setup();

        //Step 2:
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        //Step 3: Fill in username with tomsnith
        driver.findElement(By.id("username")).sendKeys("tomsmith");

        // Step 4 : Fill in password with aaaaaaSuperSecretPassword
        driver.findElement(By.id("password")).sendKeys("aaaaSuperSecretPassword!");

        // Step 5 : Click on Login button
        driver.findElement(By.xpath("//button[contains(.,'Login')]")).click();

        // Step 6:
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.contains("/secure"));
    }
}
