package module;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import table.Person;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TableTest {
    private static WebDriver driver;
    @BeforeMethod
    static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");
    }
    @Test
    static void maximumDuePerson() {
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='table1']//tr/td[4]"));

        List<String> dues = cells
                .stream().map(WebElement::getText).collect(Collectors.toList());

        float max = Float.parseFloat(dues.get(0).replace("$", ""));
        int maxIndex = 0;

        for (int i = 1; i < dues.size(); i++) {
            if (Float.parseFloat(dues.get(i).replace("$", "")) > max) {
                max = Float.parseFloat(dues.get(i).replace("$", ""));
                maxIndex = i;
            }
        }

        String firstName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[2]", maxIndex + 1))).getText();
        String lastName = driver.findElement(By.xpath(String.format("//table[@id='table1']//tr[%s]/td[1]", maxIndex + 1))).getText();
        Assert.assertEquals(String.format("%s %s", firstName, lastName), "Jason Doe");

    }
    /**
     * element is a row in table
     *
     * @param element
     * @return
     */
    private Person toPerson(WebElement element) {
        String lastName = element.findElements(By.tagName("td")).get(0).getText();
        String firstname = element.findElements(By.tagName("td")).get(1).getText();
        String email = element.findElements(By.tagName("td")).get(2).getText();
        Float due = Float.valueOf(element.findElements(By.tagName("td")).get(3).getText().trim().replace("$", ""));
        String website = element.findElements(By.tagName("td")).get(4).getText();
        return new Person(firstname, lastName, email, website, due);
    }
}