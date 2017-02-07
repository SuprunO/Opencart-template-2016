import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.awt.SystemColor.text;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrationPage {



    public static WebElement NewCustomerHeader(WebDriver driver) {
        return driver.findElement(By.cssSelector("div.col-sm-6:first-child h2"));
    }

    public static WebElement RegisterAccountHeader(WebDriver driver) {
        return driver.findElement(By.cssSelector("div.col-sm-6:first-child strong"));
    }

    public static WebElement RegisterAccountText(WebDriver driver) {
        return driver.findElement(By.cssSelector(".well>p+p"));
    }

    public static WebElement RegisterAccountButton(WebDriver driver) {
        return driver.findElement(By.cssSelector("div.col-sm-6:first-child a"));
    }

}
