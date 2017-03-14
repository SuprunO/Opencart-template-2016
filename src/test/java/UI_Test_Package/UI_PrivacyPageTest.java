
package UI_Test_Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sitePages.PrivacyPage;

/**
 * Created by alex on 09.03.2017.
 */
public class UI_PrivacyPageTest {
    WebDriver driver = new FirefoxDriver();
    PrivacyPage privacyPage = new PrivacyPage(driver);
    }


