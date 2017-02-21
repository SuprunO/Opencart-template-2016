import com.sun.xml.bind.v2.TODO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage extends PageObject {


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public WebElement get_lnk_Login() {

        return driver.findElement(By.linkText("Login"));
    }

    public WebElement get_lnk_Home() {
        return driver.findElement(By.linkText("Home"));
    }


    public WebElement get_lnk_ContactUs() {
        return driver.findElement(By.linkText("Contact Us"));
    }

    //FOOTER
    //Headers
    private String INFO = ".col-sm-2:nth-child(1):first-child h4";
    private String EXTRAS = ".col-sm-2:nth-child(2) h4";
    private String MY_ACCOUNT = ".col-sm-2:nth-child(3) h4";

    // TODO: 21.02.2017 Разобраться с локаторами / попросить команду изменить ихменить их
    //private String COMPANY_INFO = "";
    // private String CONTACT_US = "";



//    private static String Company_Info = "div.col-sm-2:first-child h5";
//    private static String Contact_Us = "div.col-sm-2:first-child h5";
//
//
//    public WebElement InfoHeader(){
//        return driver.findElement(By.cssSelector(INFO));

    //Policies
}

