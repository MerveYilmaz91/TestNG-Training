package DAY2;

import Utility.BaseDriver;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _05_OdevCase extends BaseDriver {

    @BeforeClass
    public void login() { loginOperation();}

    @BeforeMethod
    public void beforeMethod(){ driver.get("https://opencart.abstracta.us/index.php?route=account/address"); }

    //Adres ekleme
    @Test()
    public void setAddress() {
        driver.findElement(By.cssSelector("[href=\"https://opencart.abstracta.us:443/index.php?route=account/address/add\"]")).click();

        driver.findElement(By.cssSelector("[id=\"input-firstname\"]")).sendKeys("merve");
        driver.findElement(By.cssSelector("[id=\"input-lastname\"]")).sendKeys("yılmaz");
        driver.findElement(By.cssSelector("[id=\"input-address-1\"]")).sendKeys("kartal");
        driver.findElement(By.cssSelector("[id=\"input-city\"]")).sendKeys("ist");
        driver.findElement(By.cssSelector("[id=\"input-postcode\"]")).sendKeys("33333");

        Select countryDropdown = new Select(driver.findElement(By.id("input-country")));
        Select regionDropdown = new Select(driver.findElement(By.id("input-zone")));

        countryDropdown.selectByVisibleText("Turkey");
        regionDropdown.selectByVisibleText("İstanbul");

        driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();

        checkSuccessMessage();

        System.out.println("Adress oluşturuldu");
    }

    // adres editleme
    @Test(dependsOnMethods = {"setAddress"})
    public void editAdress() {
        driver.findElement(By.xpath("(//a[text()=\"Edit\"])[1]")).click();

        WebElement firstName = driver.findElement(By.cssSelector("[id=\"input-firstname\"]"));
        WebElement lastName= driver.findElement(By.cssSelector("[id=\"input-lastname\"]"));
        WebElement adress1 = driver.findElement(By.cssSelector("[id=\"input-address-1\"]"));
        WebElement city = driver.findElement(By.cssSelector("[id=\"input-city\"]"));
        WebElement postCode = driver.findElement(By.cssSelector("[id=\"input-postcode\"]"));

        firstName.clear();
        firstName.sendKeys("Mehmet");
        lastName.clear();
        lastName.sendKeys("Yılmaz");
        adress1.clear();
        adress1.sendKeys("Pendik/İstanbul");
        city.clear();
        city.sendKeys("İstanbul");
        postCode.clear();
        postCode.sendKeys("34200");


        Select countryDropdown = new Select(driver.findElement(By.id("input-country")));
        Select regionDropdown = new Select(driver.findElement(By.id("input-zone")));

        countryDropdown.selectByVisibleText("Turkey");
        regionDropdown.selectByVisibleText("İstanbul");

        driver.findElement(By.cssSelector("[value='Continue']")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success"))
                .getText().contains("success"));

        checkSuccessMessage();

        System.out.println("Adress güncellendi");

    }

    //adres silme

    @Test(dependsOnMethods = {"editAdress"})
    public void deleteAdress() throws InterruptedException {
        driver.findElement(By.xpath("(//a[text()=\"Delete\"])[1]")).click();
        checkSuccessMessage();
        System.out.println("Adress silindi");

    }

    public void checkSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".alert-success"))));
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).getText().contains("success"));
    }

}



















