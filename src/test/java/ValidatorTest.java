import constantElements.CartPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sitePages.*;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alexei on 11.05.17.
 */
public class ValidatorTest {
    WebDriver driver;
    ProductPage productPage;
    User userData;
    PayPage payPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    CartPopUp cartPopUp;

    CheckoutPage checkoutPage;

    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.gecko.driver", "//home//alexei//geckodriver");
        driver = new FirefoxDriver();
        userData = new User();
        driver.get(SiteURL);
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
        payPage = new PayPage(driver);
        categoriesPage = new CategoriesPage(driver);
        cartPopUp = new CartPopUp(driver);
        checkoutPage = new CheckoutPage(driver);

    }

    //Locators

    @Title("Product purchase E/E test")
    @Description("Purchase the product and assert the data is inputted correctly")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void endToEndTest() {

        WebElement product = homePage.findProductByText("DOUBLE DRAGON TIGER SKULL");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor(), "Black", "The color is wrong");
        //productPage.chooseSize();
        // Assert.assertEquals(productPage.currentSize(), "US6", "The size of US6 is not matched");

        productPage.inputProductsQuantity();
        productPage.clickAddToCartButton();

        productPage.getLayout().clickOnСSSSelector("#cart");
        checkoutPage = cartPopUp.getCartCheckoutButton();
        checkoutPage.clickOn_Step1_AccountContinueButton();
        checkoutPage.clickOn_Step2_BillingContinueButton();
        Assert.assertEquals(checkoutPage.nameValidatorLocator(),"First Name must be between 1 and 32 characters!","The name validator works wrong");
//        Assert.assertEquals(,"First Name must be between 1 and 32 characters!","");
//        Assert.assertEquals(,"E-Mail address does not appear to be valid!","");
//        Assert.assertEquals(,"Telephone must be between 3 and 32 characters!","");
//        Assert.assertEquals(,"Password must be between 4 and 20 characters!","");
//        Assert.assertEquals(,"Address 1 must be between 3 and 128 characters!","");
//        Assert.assertEquals(,"City must be between 2 and 128 characters!","");
//        Assert.assertEquals(,"Postcode must be between 2 and 10 characters!","");
//        Assert.assertEquals(,"Please select a region / state!","");


    }
}
