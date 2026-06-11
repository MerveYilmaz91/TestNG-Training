package DAY2;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class _03_LoginTest2 extends BaseDriver {

    /*
        1- https://opencart.abstracta.us/index.php?route=account/login adresine git
        2- Username ve password alanlarını doldur
        3- Title ın "My Account" olmasını kontrol edelim.
    */

    WebElement emailInput;
    WebElement passwordInput;

    private static final Logger logger= LogManager.getLogger(_03_LoginTest2.class);

    //Warning mesajının display olup olmadığını kontrol eder, test sonucunu belirler.
    public void warningMessageIsDisplay() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".fa.fa-exclamation-circle"))));
        Assert.assertTrue(driver.findElement(By.cssSelector(".fa.fa-exclamation-circle")).isDisplayed());

    }

    //Her case den önce çalışacak method
    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        logger.info("web sitesine giriş yapıldı");
        emailInput = driver.findElement(By.cssSelector("[id=\"input-email\"]"));
        passwordInput = driver.findElement(By.cssSelector("[id=\"input-password\"]"));
    }

    //başarılı login senaryosu
    @Parameters({"email","password"})
    @Test (priority = 2)
    public void loginCase1(String email, String password) {

        emailInput.sendKeys(email);
        passwordInput.sendKeys(password, Keys.ENTER);
        logger.info("doğru email ve şifre girildi");
        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertEquals(driver.getTitle(),"My Account", "giriş yapma hatası");
        logger.info("doğru email ve şifre girildi");
    }
    //Negatif login senaryosu
    @Test (priority = 1)
    public void loginCase2() {
        emailInput.sendKeys("alpertea99@gmail.com");
        passwordInput.sendKeys("abc.123", Keys.ENTER);
        logger.info("yanlış email ve şifre girildi");
        warningMessageIsDisplay();
        logger.info("yanlış email ve şifre girildi");
    }
    //Negatif login senaryosu
    @Test (priority = 1)
    public void loginCase3() {
        emailInput.sendKeys("alperteacher99@gmail.com");
        passwordInput.sendKeys("abc3", Keys.ENTER);
        logger.info("yanlış email ve şifre girildi");
        warningMessageIsDisplay();
        logger.info("yanlış email ve şifre girildi");
    }
    //Negatif login senaryosu
    @Test (priority = 1)
    public void loginCase4() {
        emailInput.sendKeys("alpteacher99@gmail.com");
        passwordInput.sendKeys("abc.1", Keys.ENTER);
        logger.info("yanlış email ve şifre girildi");
        warningMessageIsDisplay();
        logger.info("yanlış email ve şifre girildi");
    }
}
