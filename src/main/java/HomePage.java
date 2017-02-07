import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage {

    public static WebElement lnk_Login(WebDriver driver) {
        return driver.findElement(By.linkText("Login"));
    }


    public static WebElement lnk_Home(WebDriver driver) {
        return driver.findElement(By.linkText("Home"));
    }


    public static WebElement lnk_ContactUs(WebDriver driver) {
        return driver.findElement(By.linkText("Contact Us"));
    }


    //FOOTER
    //Headers
    private static String INFO = "div.col-sm-2:first-child h5";
    private static String My_Account = "div.col-sm-2:first-child h5";
    private static String Our_Offers = "div.col-sm-2:first-child h5";
    private static String Company_Info = "div.col-sm-2:first-child h5";
    private static String Contact_Us = "div.col-sm-2:first-child h5";


    public static WebElement InfoHeader(WebDriver driver){
        return driver.findElement(By.cssSelector(INFO));

    //Policies
    }
}
