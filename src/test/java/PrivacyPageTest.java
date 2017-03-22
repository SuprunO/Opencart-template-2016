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
    User userData;

    @BeforeTest
    public void StartUp() {
        driver = new FirefoxDriver();
        driver.get(userData.SiteURL + "/index.php?route=information/information&information_id=3");
        driver.manage().window().maximize();
        privacyPage = new PrivacyPage(driver);

    }

    @Test
    public void checkThePrivacyIsNotEmpty() {
        Assert.assertTrue(privacyPage.privacyPageTextIsPresent());
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }
}
