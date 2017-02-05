import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage {

    private static WebElement LoginElement = null;
    public static WebElement lnk_Login(WebDriver driver) {
        LoginElement = driver.findElement(By.linkText("Login"));
        return LoginElement;

    }
    private static WebElement HomeLinkElement = null;
    public static WebElement lnk_Home(WebDriver driver) {
        HomeLinkElement = driver.findElement(By.linkText("Home"));
        return HomeLinkElement;
    }

    private static WebElement ContactUsElement = null;
    public static WebElement lnk_ContactUs(WebDriver driver) {
        ContactUsElement = driver.findElement(By.linkText("Contact Us"));
        return ContactUsElement;
    }
}
