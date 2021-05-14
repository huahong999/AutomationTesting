package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SelectOptionsTest {
   @Test
    public static void selectOption() {
       // Step 1:
       WebDriverManager.chromedriver().setup();

       // Step 2:
       WebDriver driver = new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/dropdown");

       // Step 3:

       // Cach 1:
       WebElement selection1 = driver.findElement(By.xpath("//select[@id='dropdown']/option[2]"));
       selection1.click();
       Assert.assertTrue(isSelected(selection1));

       // Cach 2:(Có 3 cách)
//       Select selection1 = new Select(driver.findElement(By.id("dropdown")));
//       // 1:
//       selection1.selectByIndex(1);
         // 2:
//       selection1.selectByVisibleText("Option 1");
//       // 3:
//       selection1.selectByValue("1");
    }
    public static boolean isSelected(WebElement element){
       return element.isSelected();
    }
}
