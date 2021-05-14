package pages;

import module.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BmiPage extends BasePage {
    /*
    rad --> radio button
    chk --> check box
    link --> Link Text
    lbl --> label
     */
    By clearbtn = By.className("clearbtn");
    By metricUnitTab = By.id("menuon");
    By ageTxt = By.id("cage");
    By maleRab = By.id("csex1");
    By femaleRab = By.id("csex2");
    By heightTxt = By.id("cheightmeter");
    By weightTxt = By.id("ckg");
    By caculateBtn = By.xpath("//input[@value='Calculate']");
    By resulttbl = By.className("bigtext");

    public BmiPage(WebDriver driver) {
        super(driver);
    } // lay tu abstract pagebase

    public void open() {
        driver.get("https://www.calculator.net/bmi-calculator.html");
    } // lay tu abstract pagebase

    public void openMetricTab() {
        driver.findElement(metricUnitTab).click();
    }

    public void fillForm(String age, String gender, String height, String weight) {
//        driver.findElement(By.className("clearbtn")).click();
        driver.findElement(clearbtn).click();  // By.className("clearbtn") --> clearbtn
//        driver.findElement(By.id("cage")).sendKeys(age);
        driver.findElement(ageTxt).sendKeys(age);
//        driver.findElement(By.id("csex1")).click();
        driver.findElement(femaleRab).click();
//        driver.findElement(By.id("cheightmeter")).sendKeys(height);
        driver.findElement(heightTxt).sendKeys(height);
//        driver.findElement(By.id("ckg")).sendKeys(weight);
        driver.findElement(weightTxt).sendKeys(weight);
//        driver.findElement(By.xpath("//input[@value='Calculate']")).click();
        driver.findElement(caculateBtn).click();
    }

    public String getResult() {
//        return driver.findElement(By.className("bigtext")).getText();
        return driver.findElement(resulttbl).getText();
    }
}

