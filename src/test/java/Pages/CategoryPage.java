package Pages;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import java.util.List;

public class CategoryPage extends BaseDriver {

    public CategoryPage() { PageFactory.initElements(BaseDriver.driver, this); }

    @FindBy(id = "input-sort")
    public WebElement sortingDropdown;

    @FindBy(className = "price-tax")
    public List<WebElement> taxPrices;


}
