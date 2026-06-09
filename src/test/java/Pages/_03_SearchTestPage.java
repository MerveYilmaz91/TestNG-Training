package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Utility.BaseDriver.driver;

public class _03_SearchTestPage {

    public _03_SearchTestPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "search")
    public WebElement searchInput;

    @FindBy(css = ".btn.btn-default.btn-lg")
    public WebElement searchButton;

    @FindBy(css = ".product-thumb h4 a")
    public List<WebElement> productTitles;
}
