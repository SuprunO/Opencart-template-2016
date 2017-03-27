package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 27.03.2017.
 */
public class RobotsTXTPageTest {
    RobotsTXTPage robotsTXTPage;

    WebDriver driver;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(SiteURL + "/robots.txt");
        robotsTXTPage = new RobotsTXTPage(driver);
    }

    @Test
    public void testGet_Notfound() {
        Assert.assertTrue(robotsTXTPage.get_Notfound(),"Robots.txt file not found, kindly insert it");
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