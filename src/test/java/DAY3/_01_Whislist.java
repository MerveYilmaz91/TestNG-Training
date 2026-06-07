package DAY3;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _01_Whislist extends BaseDriver {

    @BeforeClass
    public void login() {
        loginOperation();
    }
    // bir item wishliste ekleyelim
    @Test
    public void addAnItemToWishList() {

        driver.get("https://opencart.abstracta.us/");
        driver.findElement(By.xpath("(//button[@data-original-title=\"Add to Wish List\"])[1]")).click();
        Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("Success"));

        System.out.println("item wishlist e eklendi");
    }

    // wishlistten bir item kaldırma
    @Test(dependsOnMethods = {"addAnItemToWishList"})
    public void deleteAnItemFromWishList() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/wishlist");
        driver.findElement(By.cssSelector("[data-original-title=\"Remove\"]")).click();

        checkSuccessMessage();

        System.out.println("item wish listten kaldırıldı");
    }

    public void checkSuccessMessage() {
        Assert.assertTrue(driver.findElement(By.className("alert-success")).getText().contains("Success"));

    }
}
