import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }

    public WebElement getCartCheckoutButton(){
        waiterByLinkText("Checkout");
        return driver.findElement(By.linkText("Checkout"));
    }
}
