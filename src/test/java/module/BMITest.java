package module;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BmiPage;

public class BMITest  extends BaseTest {
    @Test
    static void tc01(){
        BmiPage bmiPage = new BmiPage(driver);
        bmiPage.open();

        bmiPage.openMetricTab();
        bmiPage.fillForm("18","female", "160", "40");
        System.out.println(bmiPage.getResult());
        Assert.assertEquals(bmiPage.getResult(), "BMI = 15.6 kg/m2   (-8%, Underweight)");
    }
}
