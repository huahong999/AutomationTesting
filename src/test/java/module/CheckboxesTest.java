package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxesTest {
    @Test
    public static void checkboxes(){
        // Step 1:
        WebDriverManager.chromedriver().setup();

        // Step 2:
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        // Step 3: Dùng hai phương thức check và isSelected

        // 3.1 Kiểm tra xem các dấu trong form có đúng chưa
        // ví dụ checkbox1 chưa đc check, checkbox2 đã check rồi

        Assert.assertTrue(!isSelected(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"))));
        Assert.assertTrue(isSelected(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"))));

        // 3.2 dùng phương thức check để check vào ô checkbox1, vì checkbox1 chưa đc check
        // ô checkbox2 đã đc check rồi, nên không click vào đánh dấu thêm đc nữa

         check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")));
         check(driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")));

        // 3.3 Cách 2
        // Nếu Checkbox1 chưa đánh dấu, thì đánh dấu
        // Nếu Checkbox2 chưa đánh dấu thì đánh dấu
        // Còn có dấu rồi thì không cần
//        if(!driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).isSelected()){
//            driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]")).click();
//        }
//        if (!driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).isSelected()){
//            driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]")).click();
//        }
    };
    private static void check(WebElement element){
        // Nếu như chưa đánh dấu, thì sẽ click vào cho có dấu
        // Có sẵn dấu rồi thì không click vào
        // Vì TH này là chỉ để đánh dấu chứ không bỏ đi
        if(!element.isSelected()){
            element.click();
        }
    }
    private static void uncheck(WebElement element){
        // Nếu như đã có dấu rồi, thì  vào lần nữa làm cho mất dấu check
        // Còn nếu ô chưa có dấu thì vẫn y vậy, vì TH này là chỉ để bỏ đi dấu, chứ không đánh dấu vô

        if(element.isSelected()){
            element.click();
        }
    }
    private static boolean isSelected(WebElement element){
        // Kiểm tra xem đã dấu chưa, đánh rồi thì trả về True, chưa thì False

        return element.isSelected();
    }
}
