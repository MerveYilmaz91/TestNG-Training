package DAY3;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class _02_AddToCart extends BaseDriver {

    @BeforeClass
    public void login(){
        loginOperation();
    }

    // Anasayfadan bir item sepete ekleyelim
    @Test(priority = 1)
    public void addAnItemFromMainPage(){
        driver.get("https://opencart.abstracta.us/");
        driver.findElement(By.xpath("(//button[starts-with(@onclick, \"cart.add\")])[1]")).click();
        checkSuccessMessage();
        System.out.println("Item anasayfadan sepete eklendi");
    }

    // Ürün sayfasından bir item sepete ekleyelim
    @Test(priority = 1)
    public void addAnItemFromProductPage(){
        driver.get("https://opencart.abstracta.us/");
        driver.findElement(By.cssSelector("h4 a")).click();
        driver.findElement(By.id("button-cart")).click();

        checkSuccessMessage();
        System.out.println("Item ürün sayfasından sepete eklendi");
    }

    // Sepetteki tüm ürünleri kaldıralım
    @Test(priority = 2)
    public void deleteItemsInCart(){
        driver.get("https://opencart.abstracta.us/index.php?route=checkout/cart");
        driver.findElement(By.cssSelector("[data-original-title=\"Remove\"]")).click();

        wait.until(ExpectedConditions.textToBe(By.cssSelector("#content p"), "Your shopping cart is empty!"));

        WebElement cartMessage = driver.findElement(By.cssSelector("#content p"));
        String text = cartMessage.getText();

        Assert.assertEquals(text, "Your shopping cart is empty!", "Sepetten ürün kaldırılırken hata!");

        System.out.println("Tüm item lar sepetten kaldırıldı");
    }

    // Ürün miktarını değiştirerek sepete ekleyelim ve sepette kontrol edelim
    @Test(dependsOnMethods = {"deleteItemsInCart"})
    public void addToCartWithDifferentQuantityAndCheck(){
        driver.get("https://opencart.abstracta.us/index.php?route=product/product&product_id=40");

        Random random = new Random();
        String randomNumber = Integer.toString(random.nextInt(1, 7));
        driver.findElement(By.id("input-quantity")).clear();
        driver.findElement(By.id("input-quantity")).sendKeys(randomNumber);
        driver.findElement(By.id("button-cart")).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".alert-success a[href*='checkout/cart']")
        )).click();

        String itemsQuantityInCart = driver.findElement(By.cssSelector("[name^=\"quantity\"]")).getAttribute("value");
        Assert.assertEquals(randomNumber, itemsQuantityInCart);

        System.out.println("Miktar değiştirme testi başarılı.");
        driver.findElement(By.cssSelector("[data-original-title=\"Remove\"]")).click();
    }

    public void checkSuccessMessage(){
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert-success")).getText().contains("Success"));
    }
}
