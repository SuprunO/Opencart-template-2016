package sitePages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 11.04.2017.
 */
public class HomePageTest {
    ChromeDriver driver;
    HomePage homePage;

    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }


    //реализовать мок товара
    @Test
    public void findPriceByProductName() {
        System.out.println(homePage.findPriceByProductName("Scoop Natural Zipper Knee-Length").getText());
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

