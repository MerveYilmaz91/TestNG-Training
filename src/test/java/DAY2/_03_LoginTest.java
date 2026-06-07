package DAY2;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_LoginTest extends BaseDriver {

    /*   Account Details :
         email: alperteacher99@gmail.com
         şifre : abc.123

        1- https://opencart.abstracta.us/index.php?route=account/login adresine git
        2- Username ve password alanlarını doldur
        3- Title ın "My Account" olmasını kontrol edelim.

    */

    @Test
    public void loginTest() {

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        driver.findElement(By.cssSelector("[id=\"input-email\"]")).
                sendKeys("alperteacher99@gmail.com");

        driver.findElement(By.cssSelector("[id=\"input-password\"]")).sendKeys("abc.123");

        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();

        wait.until(ExpectedConditions.titleIs("My Account"));

        Assert.assertEquals(driver.getTitle(),"My Account", "giriş yapma hatası");
        System.out.println("Login başarı ile gerçekleşti");
    }
}
