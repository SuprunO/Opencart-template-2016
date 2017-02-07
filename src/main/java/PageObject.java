import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex on 07.02.2017.
 */
public class PageObject {
    private static WebDriver driver;
    public static WebDriver getDriver(){
        driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriverWait wait;
    public static WebDriverWait getWait(){
        wait = new WebDriverWait(driver,25);
        return wait;

    }


}
