package Utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static Utility.BaseDriver.driver;

public class HelperFuncitons {
    public static Select returnSelect(WebElement element) {
        Select select = new Select(element);
        return select;
    }

    public static void clearSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }
    public static void hoverToElement(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }

    public static void log(String log){
        System.out.println(log);
    }
}
