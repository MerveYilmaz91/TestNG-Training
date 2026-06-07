package DAY3;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_Newsletters extends BaseDriver {
    @BeforeClass
    public void login() {
        loginOperation();
    }

    @Test
    public void setNewslettersAsYes() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/newsletter");
        driver.findElement(By.cssSelector("[value=\"1\"]")).click();
        driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();

        checkSuccessMessage();

        System.out.println("Newsletter başarı ile gerçekleşti");

    }

    @Test
    public void setNewslettersAsNo() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/newsletter");
        driver.findElement(By.cssSelector("[value=\"0\"]")).click();
        driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();

        checkSuccessMessage();

        System.out.println("Newsletter başarı ile gerçekleşti");

    }
    public void checkSuccessMessage() {
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).getText().contains("Success"));
    }
}
