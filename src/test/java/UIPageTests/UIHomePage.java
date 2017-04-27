package UIPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sitePages.HomePage;
import sitePages.RobotsTXTPage;

import static technical.BasePage.SiteURL;

/**
 * Created by alexei on 27.04.17.
 */
public class UIHomePage {

    WebDriver driver;
    HomePage homepage;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.gecko.driver", "//home//alexei//geckodriver");
        driver = new FirefoxDriver();
        driver.get(SiteURL);
        homepage = new HomePage(driver);

    }

    @Test
    public void homeLinkCheck(){
        Assert.assertEquals(homepage.get_lnk_Home().getText(),"Home");
    }





}
