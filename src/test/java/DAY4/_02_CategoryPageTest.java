package DAY4;

import Pages.CategoryPage;
import Pages.Navbar;
import Utility.BaseDriver;
import Utility.HelperFuncitons;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Utility.BaseDriver.driver;

public class _02_CategoryPageTest extends BaseDriver{

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://opencart.abstracta.us/");

        /*CASE1:
         1- https://opencart.abstracta.us/ sayfasına gidelim
         2- Bir kategoriye sayfasına gidelim
         3- Ürün sıralamasını price low dan high a değiştirelim
         4- 1. ürünün fiyatının 2. ürünün fiyatına eş yada az olduğunu doğrulayalım
         */
    }

    @Test
    public void case1 () {
        Navbar nb = new Navbar();
        HelperFuncitons.hoverToElement(nb.dropdownItem);

        nb.seeAllButton.click();

        CategoryPage cp = new CategoryPage();
        HelperFuncitons.returnSelect(cp.sortingDropdown).selectByVisibleText("Price (Low > High)");

        String firstPrice = cp.taxPrices.get(0).getText();
        String secondPrice = cp.taxPrices.get(1).getText();

        Double fp = Double.parseDouble(firstPrice.substring(firstPrice.indexOf('$') + 1));
        Double sp = Double.parseDouble(secondPrice.substring(secondPrice.indexOf('$') + 1));

        System.out.println("1. ürün fiyatı : " + fp);
        System.out.println("2. ürün fiyatı : " + sp);

        Assert.assertTrue(fp <= sp);
        HelperFuncitons.log("Fiyatlar doğrulandı, test başarılı.");
    }

    //CASE2:
    //1- https://opencart.abstracta.us/ sayfasına gidelim
    //2- Bir kategoriye sayfasına gidelim
    //3- Ürün sıralamasını high dan low a değiştirelim
    //4- 1. ürünün fiyatının 2. ürünün fiyatına eş yada fazla olduğunu doğrulayalım
    @Test
    public void case2() {
        Navbar nb = new Navbar();
        HelperFuncitons helperFuncitons = new HelperFuncitons();
        helperFuncitons.hoverToElement(nb.dropdownItem);
        nb.seeAllButton.click();

        CategoryPage cp = new CategoryPage();
        HelperFuncitons.returnSelect(cp.sortingDropdown).selectByVisibleText("Price (High > Low)");

        String firstPrice = cp.taxPrices.get(0).getText();
        String secondPrice = cp.taxPrices.get(1).getText();

        firstPrice = firstPrice.substring(0, firstPrice.length() - 3);
        secondPrice = secondPrice.substring(0, secondPrice.length() - 3);

        Double fp = Double.parseDouble(firstPrice.substring(firstPrice.indexOf('$') + 1).replace(',', '.'));
        Double sp = Double.parseDouble(secondPrice.substring(secondPrice.indexOf('$') + 1).replace(',', '.'));

        System.out.println("1. ürün fiyatı : " + fp);
        System.out.println("2. ürün fiyatı : " + sp);

        Assert.assertTrue(fp >= sp);
        HelperFuncitons.log("Fiyatlar doğrulandı, test başarılı.");
    }

}

