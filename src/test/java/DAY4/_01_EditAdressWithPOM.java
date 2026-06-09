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

        aop.clearSendKeys(aop.firstNameInput,"merve");
        aop.clearSendKeys(aop.lastNameInput,"yılmaz");
        aop.clearSendKeys(aop.address1Input,"kartal");
        aop.clearSendKeys(aop.cityInput,"ist");
        aop.clearSendKeys(aop.postcodeInput,"33333");

        aop.returnSelect(aop.countrySelect).selectByVisibleText("Turkey");
        aop.returnSelect(aop.regionSelect).selectByVisibleText("İzmir");

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

        aop.returnSelect(aop.countrySelect).selectByVisibleText("Turkey");
        aop.returnSelect(aop.regionSelect).selectByVisibleText("İstanbul");

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


}



















