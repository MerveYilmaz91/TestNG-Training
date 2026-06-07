package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdressOptimizationPage {

    public AdressOptimizationPage () {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[id=\"input-firstname\"]")
    public WebElement firstNameInput;

    @FindBy(css = "[id=\"input-lastname\"]")
    public WebElement lastNameInput;

    @FindBy(css = "[id=\"input-address-1\"]")
    public WebElement address1Input;

    @FindBy(css = "[id=\"input-city\"]")
    public WebElement cityInput;

    @FindBy(css = "[id=\"input-postcode\"]")
    public WebElement postcodeInput;

    @FindBy(xpath = "//input[@value='Continue']")
    public WebElement continueButton;

    @FindBy(id = "input-country")
    public Select countrySelect;

    @FindBy(id = "input-zone")
    public Select regionSelect;

    public void clearSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);

    }
}
