package DAY1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class _02_Annotations {

    /*
    * priority = öncelik tanımlama
    * enable = true/false testi skip yapmamıza yarar
    */


    WebDriver driver = new ChromeDriver();

    @Test(priority = 1)
    public void firstTest() {
        driver.get("https://mvnrepository.com/");

    }
    @Test(priority = 3)
    public void secondTest(){
        driver.get("https://www.google.com/");
        driver.quit();
    }
    @Test(priority = 2, enabled = false)
    public void thirdTest(){
        System.out.println(driver.getTitle());
    }

}
