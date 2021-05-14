package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenChromeMobileMode {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
//        Map<String, Object> mobileEmulation = new HashMap<>();
//        mobileEmulation.put("deviceName", "iPad Pro");
//        ChromeOptions opts = new ChromeOptions();
//        opts.setExperimentalOption("mobileEmulation", mobileEmulation);
//        new ChromeDriver(opts);

        // cach khac:
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(375,812));
    }
}
