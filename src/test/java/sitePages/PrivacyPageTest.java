package sitePages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 31.03.2017.
 */

@Title("Privacy Page tests")
public class PrivacyPageTest {
    ChromeDriver driver;
    PrivacyPage privacyPage;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL + "/index.php?route=information/information&information_id=3");
        privacyPage = new PrivacyPage(driver);
    }

    @Description("Checking the Privacy Policy page is with text")
    @Test
    public void checkThePrivacyIsNotEmpty() {
        Assert.assertFalse(privacyPage.privacyPageTextIsPresent(), "The Privacy Policy is empty, kindly put the Privacy Policy Text here");
    }


    @Test
    public void checkPrivacyFontsize() {
        Assert.assertEquals(privacyPage.getPrivacyPageFontsize(), Boolean.TRUE, "PrivacyPageFontsize is not 14px, kindly fix");
    }


    @AfterClass
    public void cleanUp() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }
    }
}
