import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.awt.SystemColor.text;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrationPage {
    private static WebElement NewCustomerHeader = null;
    public static WebElement NewCustomerHeader(WebDriver driver) {
        NewCustomerHeader = driver.findElement(By.xpath("//h2[contains(text(), 'New Customer')]"));
        return NewCustomerHeader;


    }
    private static WebElement RegisterAccountHeader = null;
    public static WebElement RegisterAccountHeader(WebDriver driver) {
        RegisterAccountHeader = driver.findElement(By.xpath("//strong[contains(text(), 'Register Account')]"));
        return RegisterAccountHeader;
    }

    private static WebElement RegisterAccountText = null;
    public static WebElement RegisterAccountText(WebDriver driver) {
        RegisterAccountText = driver.findElement(By.xpath("//p[2]"));
        return RegisterAccountText;
    }

    private static WebElement RegisterAccountButton = null;
    public static WebElement RegisterAccountButton(WebDriver driver) {
        RegisterAccountButton = driver.findElement(By.xpath("//a[text()='Continue']"));
        return RegisterAccountButton;
    }

}
