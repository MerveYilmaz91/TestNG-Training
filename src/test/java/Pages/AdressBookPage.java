package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utility.BaseDriver.driver;
import static Utility.BaseDriver.wait;

public class AdressBookPage {

    public static String url = "https://opencart.abstracta.us/index.php?route=account/address";

    public AdressBookPage () {
        PageFactory.initElements(driver,this);

    }
    @FindBy(css = "[href=\"https://opencart.abstracta.us:443/index.php?route=account/address/add\"]")
    public WebElement newAdressButton;

    @FindBy(xpath = "(//a[text()=\"Delete\"])[1]")
    public WebElement deleteAdressButton;

    @FindBy(xpath = "(//a[text()=\"Edit\"])[1]")
    public WebElement editAdressButton;

    public static void checkSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));

        String message = driver.findElement(By.cssSelector(".alert-success")).getText();
        System.out.println("GELEN MESAJ = " + message);

        Assert.assertTrue(message.contains("success"));
    }
    public static void log(String log) {
        System.out.println(log);
    }
}
