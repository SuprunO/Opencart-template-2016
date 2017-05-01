package sitePages;

import constantElements.CartPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
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

    WebDriver driver;
    ProductPage productPage;
    User userData;
    CheckoutPage checkoutPage;
    PayPage payPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    CartPopUp cartPopUp;


    public void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        userData = new User();
        driver.get(SiteURL);
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
        payPage = new PayPage(driver);
        categoriesPage = new CategoriesPage(driver);

    }

    //Locators
    @Title("Product purchase E/E test")
    @Description("Purchase the product and assert the data is inputted correctly")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void endToEndTest() {

        WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor(), "Blue", "The color is wrong");
        productPage.chooseSize();
        Assert.assertEquals(productPage.currentSize(), "US6", "The size of US6 is not matched");

        productPage.inputProductsQuantity();
        productPage.pushAddToCartButton();


    }
}
