package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    public static WebDriver driver;
    @BeforeClass
    static void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        driver = new ChromeDriver(chromeOptions);
    }
    @AfterMethod
    public void captureScreen(ITestResult testResult) throws IOException {
        if(!testResult.isSuccess()){
            System.out.println("TEST FAILED!!!");
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File DestFile=new File("./target/screenshot/"+testResult.getMethod().getMethodName()+".png");

            //Copy file at destination

            FileUtils.copyFile(file, DestFile);
        }

    }

    @AfterClass
    static void tearDown() {
        driver.quit();
    }
}
