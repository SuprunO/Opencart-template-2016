package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 06.04.2017.
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
    public void clickOnProductName() {
        WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();
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
