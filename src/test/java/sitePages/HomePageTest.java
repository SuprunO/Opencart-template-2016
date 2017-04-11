package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 11.04.2017.
 */
public class HomePageTest {
    WebDriver driver;
    HomePage homePage;

    @BeforeTest
    void StartUp() {
        driver = new FirefoxDriver();
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void findPriceByProductName() {
        System.out.println(homePage.findPriceByProductName("Scoop Natural Zipper Knee-Length").getText());
    }
}

