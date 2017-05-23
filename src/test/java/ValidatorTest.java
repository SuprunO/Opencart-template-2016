import constantElements.CartPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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

    @BeforeMethod
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
    public void ValidatorForm2Test() {

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

        checkoutPage.lastNameFieldLocator().sendKeys("Kawalski");
        checkoutPage.clickOn_Step2_BillingContinueButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(checkoutPage.nameValidatorLocator(), checkoutPage.nameValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.emailValidatorLocator(), checkoutPage.emailValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.telephoneValidatorLocator(), checkoutPage.telephoneValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.passwordValidatorLocator(), checkoutPage.passwordValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.addressValidatorLocator(), checkoutPage.addressValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.cityValidatorLocator(), checkoutPage.cityValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.postCodeValidatorLocator(), checkoutPage.postCodeValidatorLocator(), "The name validator works wrong");
        Assert.assertEquals(checkoutPage.stateValidatorLocator(), checkoutPage.stateValidatorLocator(), "The name validator works wrong");




    }


    @AfterMethod
    public void cleanUp() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }

    }
}
