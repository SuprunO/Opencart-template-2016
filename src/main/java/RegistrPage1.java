import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static java.awt.SystemColor.text;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrPage1 extends BasePage{

    public RegistrPage1(WebDriver driver) {
        super(driver);
    }

    public WebElement NewCustomerHeader() {
        return this.driver.findElement(By.cssSelector("div.col-sm-6:first-child h2"));
    }

    public WebElement RegisterAccountHeader() {
        return this.driver.findElement(By.cssSelector("div.col-sm-6:first-child strong"));
    }

    public WebElement RegisterAccountText() {
        return this.driver.findElement(By.cssSelector(".well>p+p"));
    }

    public WebElement RegisterAccountButton() {
        return this.driver.findElement(By.cssSelector("div.col-sm-6:first-child a"));
    }

}
