package DAY2;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Utility.BaseDriver.driver;

public class _04_EditAdress extends BaseDriver {

    @BeforeClass
    public void login() {
        loginOperation();
    }

    @Test
    public void setAdress() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/address");

        driver.findElement
                (By.cssSelector("[href=\"https://opencart.abstracta.us:443/index.php?route=account/address/add\"]")).click();

        System.out.println("adress oluşturuldu");

        //Assert.fail();
    }
    @Test(dependsOnMethods = {"setAdress"}, alwaysRun = true)
    public void editAdress() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/address");
        System.out.println("adress editlendi");
    }

    @Test(dependsOnMethods = {"setAdress"}, alwaysRun = true)
    public void deleteAdress() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/address");
        System.out.println("adress silindi");
    }
}
