import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.PrivacyPage;
import technical.User;

/**
 * Created by alex on 22.03.2017.
 */
public class PrivacyPageTest {

    WebDriver driver;
    PrivacyPage privacyPage;
    User user;


    @BeforeTest
    public void StartUp() {
        driver = new FirefoxDriver();
        user =new User();

        driver.get(user.SiteURL+"/index.php?route=information/information&information_id=3");
        driver.manage().window().maximize();
        privacyPage = new PrivacyPage(driver);
    }

    @Test
    public void checkThePrivacyIsNotEmpty() {
        Assert.assertFalse(privacyPage.privacyPageTextIsPresent(),"The Privacy Policy is empty, kindly put the Privacy Policy Text here");
    }

    @Test
    public void checkPrivacyFontsize(){
        Assert.assertEquals(privacyPage.getPrivacyPageFontsize(),Boolean.TRUE,"PrivacyPageFontsize is not 14px, kindly fix");
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
