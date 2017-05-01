package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 01.05.2017.
 */
public class CheckoutPageTest {
    WebDriver driver;
    DeliveryPage deliveryPage;
    User userData;

    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(SiteURL + "/index.php?route=information/information&information_id=6");
        driver.manage().window().maximize();
        deliveryPage = new DeliveryPage(driver);
        userData = new User();
    }
    @Test
    public void step1CheckpoutOptions(){

    }


}
