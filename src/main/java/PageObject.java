import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex on 07.02.2017.
 */
public class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 25);
    }
}

