package DAY1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class _01_Intro {

    WebDriver driver = new ChromeDriver();

    @Test
    public void loginTest() {
        driver.get("https://mvnrepository.com/");
        System.out.println("login başarılı");
    }
    @Test
    public void logoutTest(){
        driver.get("https://www.google.com/");
        System.out.println("logout başarılı");
    }
    @Test
    public void addToCard(){
        System.out.println("sepete ekleme gerçekleşti");
    }

}
