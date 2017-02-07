import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.awt.SystemColor.text;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrationPage {

    public static WebElement NewCustomerHeader(WebDriver driver) {
        return driver.findElement(By.xpath("//h2[contains(text(), 'New Customer')]"));
    }

    public static WebElement RegisterAccountHeader(WebDriver driver) {
        return driver.findElement(By.xpath("//strong[contains(text(), 'Register Account')]"));
    }

    public static WebElement RegisterAccountText(WebDriver driver) {
        return driver.findElement(By.xpath("//p[2]"));
    }

    public static WebElement RegisterAccountButton(WebDriver driver) {
        return driver.findElement(By.xpath("//a[text()='Continue']"));
    }

}
