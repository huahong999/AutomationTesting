package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
        WebDriver driver;
        public BasePage(WebDriver driver) {
            this.driver = driver;
        }
        public abstract void open();

        // chi viet code theo framework cho BIM va ToDoMVC
        // Tat ca cac class con lai la viet co ban, lay tung doi tuong ra test
}
