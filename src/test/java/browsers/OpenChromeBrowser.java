package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeBrowser {public static void main(String[] args) {
    // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    // driver.manage().window().maximize();
    // driver.manage().window().setSize(new Dimension(375,812));
    // driver.get("https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter2.html");
    driver.navigate().to("https://testautomationu.applitools.com/selenium-webdriver-tutorial-java/chapter2.html");
    driver.get("https://google.com");
    driver.navigate().back();
    driver.quit();
}
}
