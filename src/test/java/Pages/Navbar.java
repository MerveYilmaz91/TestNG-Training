package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Utility.BaseDriver.driver;

public class Navbar extends BaseDriver {

    public Navbar() { PageFactory.initElements(BaseDriver.driver, this); }

    @FindBy (xpath = "//a[text()='Desktops']")
    public WebElement dropdownItem;

    @FindBy(xpath = "//li[@class='dropdown']/a[text()='Desktops']/following-sibling::div/a")
    public WebElement seeAllButton;





}
