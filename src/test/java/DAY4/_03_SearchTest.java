package DAY4;

import Pages._03_SearchTestPage;
import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _03_SearchTest extends BaseDriver {

    //Case 1:
    //1- https://opencart.abstracta.us/  sayfasına gidelim
    //2- arama butonuna mac yazalım
    //3- sonuçların hepsinin başlığında mac olduğunu doğrulayalım

    //Case 2:
    //1- https://opencart.abstracta.us/  sayfasına gidelim
    //2- arama butonuna ipod yazalım
    //3- sonuçların hepsinin başlığında ipod olduğunu doğrulayalım

    _03_SearchTestPage stp;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://opencart.abstracta.us/");
        stp = new _03_SearchTestPage();
    }

    @Test
    public void searchMac() {

        stp.searchInput.sendKeys("mac");
        stp.searchButton.click();

        for (WebElement product : stp.productTitles) {
            Assert.assertTrue(product.getText().toLowerCase().contains("mac"),
                    "Mac içermeyen ürün bulundu: " + product.getText());
        }
    }

    @Test
    public void searchİpod() {

        stp.searchInput.sendKeys("ipod");
        stp.searchButton.click();

        for (WebElement product : stp.productTitles) {
            Assert.assertTrue(product.getText().toLowerCase().contains("ipod"),
                    "ipod içermeyen ürün bulundu: " + product.getText());
        }
    }
}