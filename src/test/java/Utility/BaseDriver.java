package Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    @BeforeClass
    public void initialOperations() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Driver Çalıştı");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        js = (JavascriptExecutor) driver;

    }
    @AfterClass
    public void finalOperations () throws InterruptedException{
        Thread.sleep(2000);
        driver.quit();
        System.out.println("Driver Kapatıldı");
    }

    public void loginOperation() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement emailInput = driver.findElement(By.cssSelector("[id=\"input-email\"]"));
        WebElement passwordInput = driver.findElement(By.cssSelector("[id=\"input-password\"]"));

        emailInput.sendKeys("alperteacher99@gmail.com");
        passwordInput.sendKeys("abc.123", Keys.ENTER);

        wait.until(ExpectedConditions.titleIs("My Account"));
        Assert.assertEquals(driver.getTitle(),"My Account", "giriş yapma hatası");
        System.out.println("Login başarı ile gerçekleşti");
    }
}
