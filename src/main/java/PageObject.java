import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Created by alex on 07.02.2017.
 */
public class PageObject {
    private WebDriver driver;

    public WebDriver getDriver() {
        driver = new FirefoxDriver();
        return driver;
    }

    private WebDriverWait wait;
    public WebDriverWait getWait(){
        wait = new WebDriverWait(driver,25);
        return wait;
    }
}


