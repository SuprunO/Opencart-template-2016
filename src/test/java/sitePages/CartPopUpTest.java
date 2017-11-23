package sitePages;

import constantElements.CartPopUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 08.04.2017.
 */
public class CartPopUpTest {
    ChromeDriver driver;
    ProductPage productPage;
    User userData;
    HomePage homePage;
    CartPopUp cartPopUp;

    @BeforeClass
    public void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPopUp = new CartPopUp(driver);

    }

    //Locators
    @Title("Cart Pop up test")
    @Description("Purchase the product and validate all the product info is in the Pop up Correct")
    @Severity(SeverityLevel.CRITICAL)


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
