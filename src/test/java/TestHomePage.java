import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

/**
 * Created by alex on 04.02.2017.
 */
public class TestHomePage {
    WebDriver driver = new FirefoxDriver();

    private String LOGIN = "Login";
    private String HOME = "Home";
    private String CONTACT_US = "Contact Us";


    @BeforeClass
    public void startUp() {
        driver.get("http://kidsclotheslab.com");
    }


    @Test
    public void verifyLogin() {
        Assert.assertEquals(HomePage.lnk_Login(driver).getText(), LOGIN, "Login check failed");
    }

    @Test
    public void verifyHome() {
        Assert.assertEquals(HomePage.lnk_Home(driver).getText(), HOME, "Home check failed");
    }

    @Test
    public void verifyContactUs() {
        Assert.assertEquals(HomePage.lnk_ContactUs(driver).getText(), CONTACT_US, " Contact us check failed");
    }

    //Footer

    private String INFO = "Information";

    @Test
    public void verifyInfoHeader() {
        Assert.assertEquals(HomePage.InfoHeader(driver).getText(), INFO, "Information header is wrong or missing");
    }
}
