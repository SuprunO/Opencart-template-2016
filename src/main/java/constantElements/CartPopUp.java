package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import sitePages.CheckoutPage;
import technical.BasePage;

/**
 * Created by alex on 07.04.2017.
 */


public class CartPopUp extends BasePage {

    public CartPopUp(WebDriver driver) {
        super(driver);
    }
    private String CART_CHECKOUT_BUTTON = ".text-right>a:last-of-type";

    @Step
    public CheckoutPage getCartCheckoutButton() {
        waitCSSSelector(CART_CHECKOUT_BUTTON);
        driver.findElement(By.cssSelector(CART_CHECKOUT_BUTTON)).click();
        return new CheckoutPage(driver);

    }

}
