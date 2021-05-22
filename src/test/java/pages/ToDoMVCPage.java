package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToDoMVCPage extends BasePage{
    Actions actions = new Actions(driver);

    By todoList = By.cssSelector("ul.todo-list >li");
    By newTodoTxt = By.className("new-todo");


    public ToDoMVCPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://todomvc.com/examples/vanillajs/");
    }

    public int getItemLeft() {
        return driver.findElements(todoList).size();
    }

    public void addNewName(String todoListName) {
        driver.findElement(newTodoTxt).sendKeys(todoListName + "\n");
    }

    public By getTodo(String todoList){
        return By.xpath(String.format("//label[.='%s']",todoList));
    }

    public void removeTodo(String todoList){
        actions.moveToElement(driver.findElement(getTodo(todoList))).perform();
        By destroyBtn = By.xpath(String.format("//label[.='%s']/following-sibling::button",todoList));
        driver.findElement(destroyBtn).click();
    }
}
