package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCartCheckoutButton() {
        waiter(CART_CHECKOUT_BUTTON);

        return driver.findElement(By.cssSelector(CART_CHECKOUT_BUTTON));
    }

    private String CART_CHECKOUT_BUTTON = ".text-right a:nth-child(2)";
}
