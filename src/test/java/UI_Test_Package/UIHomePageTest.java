package UI_Test_Package;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sitePages.HomePage;
import technical.UserCredentialsProvider;

/**
 * Created by alex on 04.02.2017.
 */
public class UIHomePageTest {

    WebDriver driver = new FirefoxDriver();
    HomePage homePage = new HomePage(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();

    private String LOGIN = "Login";
    private String HOME = "Home";
    private String CONTACT_US = "Contact Us";

    @BeforeClass
    public void start_Up() {
        driver.get(userData.SiteURL);
        driver.manage().window().maximize();
    }


    @Test
    public void verify_Lnk_Login() {
        Assert.assertEquals(homePage.get_lnk_Login().getText(), LOGIN, "Login check failed");
    }

    @Test
    public void verify_Lnk_Home() {
        Assert.assertEquals(homePage.get_lnk_Home().getText(), HOME, "Home check failed");
    }

    @Test
    public void verify_Contact_Us() {
        Assert.assertEquals(homePage.get_lnk_ContactUs().getText(), CONTACT_US, " Contact us check failed");
    }


}
