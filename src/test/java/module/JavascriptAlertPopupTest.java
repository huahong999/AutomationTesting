package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JavascriptAlertPopupTest {
//    @Test
//    public void javaScriptAlert() {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//
//        // Accept the pop up
//        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
//        driver.switchTo().alert().accept();
//
//        // Reject the pop up
//        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//        driver.switchTo().alert().dismiss();
//
//        // Send keys into pop up
//        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
//        driver.switchTo().alert().sendKeys("Krystal");
//        driver.switchTo().alert().accept();
//    }
    // CACH 2:
    private static WebDriver driver;
    @BeforeMethod
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @Test
    static void clickForJSAlert(){
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        // todo : dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);
        driver.switchTo().alert().accept(); //click on Ok on alert p

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You successfully clicked an alert");
    }

    @Test
    static void clickForJSConfirm(){
        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

        // todo : dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);
        driver.switchTo().alert().dismiss();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You clicked: Cancel");
    }

    @Test
    static void clickForJSPrompt(){
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        // todo : dismiss alert via click OK button
        WebDriverWait wait = new WebDriverWait(driver,10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent())!=null);

        driver.switchTo().alert().sendKeys("Hello");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(result, "You entered: Hello");
    }

    @AfterMethod
    static void tearDown() {
        driver.quit();
    }

    // CACH 3:
//    private static WebDriver driver;
//    @BeforeMethod
//    static void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//    }
//    @DataProvider
//    static Object[][] confirmAction() {
//        return new Object[][]{
//                new Object[]{"Cancel"},
//                new Object[]{"Ok"}
//        };
//    }
//    @Test(dataProvider = "confirmActions")
//    static void clickForJSConfirm(String action) {
//        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
//
//        // todo : dismiss alert via click OK button
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent()) != null);
//
//        if (action.contains("Cancel")) {
//            driver.switchTo().alert().dismiss();
//        } else {
//            driver.switchTo().alert().accept();
//        }
//
//        String result = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(result, String.format("You clicked: %s", action));
//    }
//    @AfterMethod
//    static void tearDown() {
//        driver.quit();
//    }

}


