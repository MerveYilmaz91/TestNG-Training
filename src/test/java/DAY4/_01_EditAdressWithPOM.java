package DAY4;

import Pages.AdressBookPage;
import Pages.AdressOptimizationPage;
import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _01_EditAdressWithPOM extends BaseDriver {

    @BeforeClass
    public void login() { loginOperation();}

    @BeforeMethod
    public void beforeMethod(){ driver.get(AdressBookPage.url); }

    //Adres ekleme
    @Test()
    public void setAddress() {
        AdressBookPage abp = new AdressBookPage();
        abp.newAdressButton.click();

        AdressOptimizationPage aop = new AdressOptimizationPage();

        aop.firstNameInput.sendKeys("merve");
        aop.lastNameInput.sendKeys("yılmaz");
        aop.address1Input.sendKeys("kartal");
        aop.cityInput.sendKeys("ist");
        aop.postcodeInput.sendKeys("33333");

        aop.countrySelect.selectByVisibleText("Turkey");
        aop.regionSelect.selectByVisibleText("Istanbul");

        aop.continueButton.click();
        abp.checkSuccessMessage();
        abp.log("Adress oluşturuldu");

    }

    // adres editleme
    @Test(dependsOnMethods = {"setAddress"})
    public void editAdress() {
        AdressBookPage abp = new AdressBookPage();
        abp.editAdressButton.click();

        AdressOptimizationPage aop = new AdressOptimizationPage();

        aop.clearSendKeys(aop.firstNameInput,"merve");
        aop.clearSendKeys(aop.lastNameInput,"yılmaz");
        aop.clearSendKeys(aop.address1Input,"Pendik/İstanbul");
        aop.clearSendKeys(aop.cityInput,"İstanbul");
        aop.clearSendKeys(aop.postcodeInput,"34200");

        aop.countrySelect.selectByVisibleText("Turkey");
        aop.regionSelect.selectByVisibleText("Istanbul");

        aop.continueButton.click();

        abp.checkSuccessMessage();
        abp.log("Adress editlendi");

    }

    //adres silme

    @Test(dependsOnMethods = {"editAdress"})
    public void deleteAdress(){

        AdressBookPage abp = new AdressBookPage();
        abp.deleteAdressButton.click();
        abp.checkSuccessMessage();
        abp.log("Adress silindi");

    }

    public void checkSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert-success"))));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).getText().contains("success"));
    }

}



















