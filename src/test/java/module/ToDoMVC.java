package module;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.ToDoMVCPage;

public class ToDoMVC extends BaseTest{
    @Test
    public static void addNew() {
        // Enter a new todo name
           /*
        Verify a todo added

        //label[contains(.,'Krystal')] ----> //div[@class='view']/label[1]

         */
        ToDoMVCPage toDoMVCPage = new ToDoMVCPage(driver);
        toDoMVCPage.open();

        int itemBF = toDoMVCPage.getItemLeft();

        toDoMVCPage.addNewName("Krystal");

        int itemAT = toDoMVCPage.getItemLeft();

        Assert.assertEquals(itemAT-itemBF,1 );
    }
    @Test
    public static void RemoveTodo() {
        ToDoMVCPage toDoMVCPage = new ToDoMVCPage(driver);
        toDoMVCPage.open();
        toDoMVCPage.addNewName("Krystal");
        int itemBF = toDoMVCPage.getItemLeft();  // =1

        toDoMVCPage.removeTodo("Krystal");

        int itemAT = toDoMVCPage.getItemLeft(); // = 0

        Assert.assertEquals(itemAT-itemBF,-1 ); // 0 - 1 = -1
    }

//    @Test
//    public static void markToComplete() {
//        ChromeDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://todomvc.com/examples/vanillajs/");
//        Actions actions = new Actions(driver);
//
//        driver.findElement(By.className("new-todo")).sendKeys("Krystal");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.className("new-todo")).sendKeys("Hua Hong");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[1]//input")).click();
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[2]//input")).click();
//    }
//    @Test
//    public static void markAllComplete() {
//        ChromeDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://todomvc.com/examples/vanillajs/");
//        Actions actions = new Actions(driver);
//
//        driver.findElement(By.className("new-todo")).sendKeys("Krystal");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.className("new-todo")).sendKeys("Hua Hong");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.xpath("//label[contains(.,'Mark')]")).click();
//    }
//    @Test
//    public static void clearCompleted() {
//        ChromeDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://todomvc.com/examples/vanillajs/");
//        Actions actions = new Actions(driver);
//
//        driver.findElement(By.className("new-todo")).sendKeys("Krystal");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.className("new-todo")).sendKeys("Hua Hong");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[1]//input")).click();
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[2]//input")).click();
////        driver.findElement(By.xpath("//label[contains(.,'Mark')]")).click();
//        driver.findElement(By.className("clear-completed")).click();
//    }
//    @Test
//    public static void destroyButton() {
//        ChromeDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://todomvc.com/examples/vanillajs/");
//        Actions actions = new Actions(driver);
//
//        driver.findElement(By.className("new-todo")).sendKeys("Krystal");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.className("new-todo")).sendKeys("Hua Hong");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        // click toggle truoc, sau do moi duoc phep click destroy????
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[1]//input")).click();
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[1]//button")).click();
//
//        // False???
////        driver.findElement(By.xpath("//ul[@class='todo-list']//li[2]//input")).click();
////        driver.findElement(By.xpath("//ul[@class='todo-list']//li[2]//button")).click();
//    }
//    @Test public void checkLink(){
//        ChromeDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://todomvc.com/examples/vanillajs/");
//        Actions actions = new Actions(driver);
//
//        driver.findElement(By.className("new-todo")).sendKeys("Krystal");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        driver.findElement(By.className("new-todo")).sendKeys("Hua Hong");
//        actions.sendKeys(Keys.RETURN).perform();
//
//        //ul[@class='filters']//li[index]//a
//        //a[contains(.,'Completed')]
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[1]//input")).click();
//        driver.findElement(By.xpath("//ul[@class='todo-list']//li[2]//input")).click();
//
//        driver.findElement(By.xpath("//a[contains(.,'All')]")).click();
//        Assert.assertEquals(driver.getCurrentUrl(),"https://todomvc.com/examples/vanillajs/#/");
//
//        driver.findElement(By.xpath("//a[contains(.,'Active')]")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("active"));
//
////        driver.findElement(By.xpath("//a[contains(.,'Completed')]")).click();
//        driver.findElement(By.linkText("Completed")).click();
//        Assert.assertTrue(driver.getCurrentUrl().contains("completed"));
//    }
////    @Test
////    public void checkHoverDestroyButton() {
////        ChromeDriverManager.chromedriver().setup();
////        ChromeDriver driver = new ChromeDriver();
////        driver.get("https://todomvc.com/examples/vanillajs/");
////        Actions actions = new Actions(driver);
////
////        driver.findElement(By.className("new-todo")).sendKeys("Krystal\n");
////        actions.sendKeys(Keys.RETURN).perform();
//
////        WebDriverWait wait = new WebDriverWait(driver, 10);
////        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='destroy']"))).click();
//////        WebElement destroyBtn = driver.findElement(By.xpath("//button[@class='destroy']"));
////        destroyBtn.click();
////        actions.moveToElement(destroyBtn)
////                .perform();
//
//
//  //  }
}
