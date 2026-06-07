package DAY2;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static java.sql.DriverManager.getDriver;

public class _02_BaseDriverIntro extends BaseDriver {

    @Test
    public void baseDriverSimpleMethod() {
        driver.get("https://www.google.com/");

        wait.until(ExpectedConditions.urlContains("google"));

    }
}
