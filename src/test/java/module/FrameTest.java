package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameTest {
    private static WebDriver driver;
    @BeforeMethod
    static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
    }
    @Test
    static void checkInnerText(){
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");

        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("LEFT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame(); // Tro ve top frame ban dau

        driver.switchTo().frame("frame-middle");
        Assert.assertTrue(driver.findElement(By.id("content")).getText().contains("MIDDLE")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame(); // Tro ve top frame ban dau

        driver.switchTo().frame("frame-right");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame();// Tro ve top frame ban dau

        driver.switchTo().parentFrame(); // Tro ve origin session

        driver.switchTo().frame("frame-bottom");
        Assert.assertTrue(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM")
                ,driver.findElement(By.xpath("html/body")).getText()
        );

        driver.switchTo().parentFrame(); // Tro ve origin session
        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(By.xpath("html/body")).getText().contains("LEFT"));
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText().contains("MIDDLE"));
        driver.switchTo().parentFrame();

        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(By.xpath("html/body")).getText().contains("RIGHT"));
        driver.switchTo().parentFrame();

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(By.xpath("html/body")).getText().contains("BOTTOM"));
    }
    @AfterMethod
    static void tearDown(){
        driver.quit();
    }
}
