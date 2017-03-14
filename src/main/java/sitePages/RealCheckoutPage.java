package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 02.03.2017.
 */
public class RealCheckoutPage extends BasePage {

    public RealCheckoutPage(WebDriver driver) {
        super(driver);
    }

    public WebElement checkout_BTN_on_RealCheckout_Page() {
        return driver.findElement(By.linkText("Checkout"));
    }
}
