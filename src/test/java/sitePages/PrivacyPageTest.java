package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 31.03.2017.
 */
public class PrivacyPageTest {
    WebDriver driver;
    PrivacyPage privacyPage;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(SiteURL + "/index.php?route=information/information&information_id=3");
        privacyPage = new PrivacyPage(driver);
    }

    @Test
    public void checkThePrivacyIsNotEmpty() {
        Assert.assertFalse(privacyPage.privacyPageTextIsPresent(), "The Privacy Policy is empty, kindly put the Privacy Policy Text here");
    }

    @Test
    public void checkPrivacyFontsize() {
        Assert.assertEquals(privacyPage.getPrivacyPageFontsize(), Boolean.TRUE, "PrivacyPageFontsize is not 14px, kindly fix");
    }


}
