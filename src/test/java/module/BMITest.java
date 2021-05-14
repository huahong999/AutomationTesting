package module;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BmiPage;

public class BMITest extends BaseTest{

    @Test
    static void tc01() {

        BmiPage bmiPage = new BmiPage(driver);
        bmiPage.open();
        // Mo tab thu 2:
        bmiPage.openMetricTab();
        // Dien vao form:
        bmiPage.fillForm("20","female","160","40");
        // Kiem tra ket qua in ra
        Assert.assertEquals(bmiPage.getResult(), "BMI = 15.6 kg/m2   (-6%, Underweight)");
    }

}
