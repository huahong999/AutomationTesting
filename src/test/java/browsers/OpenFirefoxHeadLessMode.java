package browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OpenFirefoxHeadLessMode {
    public static void main(String[] args) {
        // System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        WebDriverManager.firefoxdriver().setup();

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
       // new FirefoxDriver(firefoxOptions);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
    }
}
