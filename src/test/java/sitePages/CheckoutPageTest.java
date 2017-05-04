package sitePages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 01.05.2017.
 */
public class CheckoutPageTest {
    ChromeDriver  driver;
    DeliveryPage deliveryPage;
    User userData;

    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        deliveryPage = new DeliveryPage(driver);
        userData = new User();
    }
    @Test
    public void step1CheckoutOptions(){

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
