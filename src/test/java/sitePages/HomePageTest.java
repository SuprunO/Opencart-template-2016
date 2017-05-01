package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @Test
    public void findPriceByProductName() {
        System.out.println(homePage.findPriceByProductName("Scoop Natural Zipper Knee-Length").getText());
    }
}

