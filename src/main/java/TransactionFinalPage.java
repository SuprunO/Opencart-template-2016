import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */
public class TransactionFinalPage extends BasePage {

    public TransactionFinalPage(WebDriver driver) {
        super(driver);
    }


    // Locators
    private String PAYMENTISSUCCESSFUL = "div>h2";

    public WebElement checkTheTransactionIsSuccessful(){
        return driver.findElement(By.cssSelector(PAYMENTISSUCCESSFUL));

    }
}

