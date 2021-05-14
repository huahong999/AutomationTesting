package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BmiPage extends BasePage{
    By metricUnitTab = By.id("menuon");
    By ageTxt = By.id("cage");
    By maleRad = By.id("csex1");
    By femalerad = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By clearBtn = By.className("clearbtn");
    By caculateBtn = By.xpath("//input[@alt='Calculate']");
    By resultLbl = By.className("bigtext");
    public void openMetricTab(){
        driver.findElement(metricUnitTab).click();
    }
    public void fillForm(String age, String sex, String height, String weight){
        driver.findElement(clearBtn).click();
        driver.findElement(ageTxt).sendKeys(age);

        if(sex.equalsIgnoreCase("male")) driver.findElement(femalerad).click();
        else driver.findElement(maleRad).click();

        driver.findElement(heightTxt).sendKeys(height);
        driver.findElement(weightTxt).sendKeys(weight);
        driver.findElement(caculateBtn).click();
    }
    public String getResult(){
        return driver.findElement(resultLbl).getText();
    }
    public BmiPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
    }
}
