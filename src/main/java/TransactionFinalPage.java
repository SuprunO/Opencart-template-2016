import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex on 21.02.2017.
 */
public class TransactionFinalPage extends PageObject{

    public TransactionFinalPage(WebDriver driver) {
        super(driver);
    }


    // Locators
    private String PAYMENTISSUCCESSFUL = "div>h2";

    public WebElement checkTheTransactionIsSuccessful(){
        return driver.findElement(By.cssSelector(PAYMENTISSUCCESSFUL));

    }
}

