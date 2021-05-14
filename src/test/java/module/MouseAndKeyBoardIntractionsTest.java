package module;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseAndKeyBoardIntractionsTest  {
    @Test
    public static void dragAnddrop() {
        ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        Actions actions = new Actions(driver);
        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));
        actions.dragAndDrop(boxA,boxB).perform();
    }
    @Test
    public static void rightClick() {
        ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

        // kiem tra form co xh khong
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.alertIsPresent()) != null);

        // kiem tra text hien thi co dung khong
        String jsContext = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        Assert.assertEquals(jsContext, "You selected a context menu");
    }
    @Test
    public static void hover() {
        ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/hovers");

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement user1 = driver.findElement(By.xpath("//div[@class='figure'][1]"));
        actions.moveToElement(user1)
                .perform();

        // Ham visib... nghia la nhin thay dc tren ui, xuat hien o html
        // co the thay bang ham presenceOfElementLocated : chi xuat hien o html, ui khong nhin thay dc

        String caption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='figure'][1]/div/h5"))).getText();
        System.out.println(caption);
        Assert.assertEquals(caption,"name: user1");
    }
    @Test
    public static void pressKey() {
        ChromeDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses");

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.RETURN).perform();
    }
}
