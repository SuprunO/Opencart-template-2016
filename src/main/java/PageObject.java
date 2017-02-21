import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by alex on 07.02.2017.
 */
public class PageObject {

    public WebDriver driver;
    public WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PageObject(WebDriverWait driverWait){
        this.wait=driverWait;
    }

    public void clickOn(String CSSSelector) {
        driver.findElement(By.cssSelector(CSSSelector)).click();
    }

}



