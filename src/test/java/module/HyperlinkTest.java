package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HyperlinkTest {

    // CACH 1:
//    @Test
//    public static void linkText() {
//        // Step 1:
//        WebDriverManager.chromedriver().setup();
//        // Step 2:
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/status_codes");
//
//        // Step 3: Click on 200
////        driver.findElement(By.xpath("//a[contains(.,'200')]")).click();
//        driver.findElement(By.linkText("200")).click();
//
////        Assert.assertTrue(driver.getCurrentUrl().contains("200"));
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/200");
//
////        driver.findElement(By.xpath("//a[contains(.,'here')]")).click();
//        driver.findElement(By.linkText("here")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");
//
//        driver.findElement(By.xpath("//a[contains(.,'301')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/301");
//
//        driver.findElement(By.xpath("//a[contains(.,'here')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");
//
//        driver.findElement(By.xpath("//a[contains(.,'404')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/404");
//
//        driver.findElement(By.xpath("//a[contains(.,'here')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");
//
//        driver.findElement(By.xpath("//a[contains(.,'500')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes/500");
//
//        driver.navigate().back();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/status_codes");

//    }


     // CACH 2: (chay bi loi)
//    private static WebDriver driver;
//    @BeforeMethod
//    static void setup(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/status_codes");
//
//    }
//    // Cach 2:
//    @Test
//    static void linkText(){
//        validateSinglePage("200");
//        validateSinglePage("301");
//        validateSinglePage("404");
//        validateSinglePage("500");
//
//        driver.findElement(By.linkText("here")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
//    }
//
//    @AfterMethod
//    static void tearDown(){
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
//        driver.quit();
//    }
//
//    private static void validateSinglePage(String name){
//        driver.findElement(By.linkText(name)).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("status_codes/%s", name)));
//        driver.findElement(By.linkText("here")).click();
//
//    }


    // CACH 3:
//private static WebDriver driver;
//    @BeforeMethod
//    static void setup(){
//        // Step 1:
//        WebDriverManager.chromedriver().setup();
//        // Step 2:
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/status_codes");
//
//    }

 //    Cach 3: tách ra từng test case nhỏ chạy 4 lần:
//
//    @Test
//    static void navigateTo200(){
//
//        validateSinglePage("200");
//    }
//    @Test
//    static void navigateTo301(){
//        validateSinglePage("301");
//    }
//    @Test
//    static void navigateTo404(){
//
//        validateSinglePage("404");
//    }
//    @Test
//    static void navigateTo500(){
//
//        validateSinglePage("500");
//    }
//
//
//    @AfterMethod
//    static void tearDown(){
//        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
//        driver.quit();
//    }
//
//    private static void validateSinglePage(String name){
//        driver.findElement(By.linkText(name)).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains(String.format("status_codes/%s", name)));
//        driver.findElement(By.linkText("here")).click();
//
//    }

    // CACH 4:
    private static WebDriver driver;

    @BeforeMethod
    static void setup() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/status_codes");
    }

    @DataProvider
    static Object[][] pages(){
        return new Object[][]{
                new Object[]{"200","status_codes/200"} ,
                new Object[]{"301","status_codes/301"} ,
                new Object[]{"404","status_codes/404"} ,
                new Object[]{"500","status_codes/500"} ,
        };
    }
    @Test(dataProvider = "pages")
    static void navigateToPage(String name,String expected) {
        driver.findElement(By.linkText(name)).click();
        Assert.assertTrue(driver.getCurrentUrl().contains(expected));
        driver.findElement(By.linkText("here")).click();
    }
    @AfterMethod
    static void tearDown() {
        Assert.assertTrue(driver.getCurrentUrl().contains("status_codes"));
        driver.quit();
    }
}
