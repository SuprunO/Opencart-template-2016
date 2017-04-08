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
 * Created by alex on 21.02.2017.
 */
public class EndToEndTest {
    WebDriver driver;
    ProductPage productPage;
    User userData;
    CheckoutPage checkoutPage;
    PayPage payPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    CartPopUp cartPopUp;

    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        userData = new User();
        driver.get(SiteURL);
        //"/index.php?route=product/product&product_id=86");
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
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor(), "Blue", "The color is wrong");
        productPage.chooseSize();
        Assert.assertEquals(productPage.currentSize(), "US6", "The size of US6 is not matched");

        productPage.inputProductsQuantity();
        productPage.pushAddToCartButton();

        cartPopUp = productPage.getLayout().hoverandClickCartIcon();
        checkoutPage = cartPopUp.getCartCheckoutButton();
        checkoutPage.clickOn_Step1_AccountContinueButton();
        checkoutPage.inputCredentials(userData);
        checkoutPage.chooseCountry();
        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
        checkoutPage.chooseState();
        Assert.assertEquals(checkoutPage.currentStateSelected(), "Arkansas", "The State name have to be Arkansas");
        checkoutPage.clickPrivacyPolicyRadioButton();
        checkoutPage.clickOn_Step2_BillingContinueButton();
        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();
        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();
        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();
        payPage = checkoutPage.clickOn_Step6_ConfirmOrderButton();

        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnSubmitTransactionButton();

    }

//    @AfterClass
//    public void cleanUp() {
//        try {
//            driver.close();
//            driver.quit();
//        } catch (Exception e) {
//            System.out.println("some errors occured during closing driver: \n" + e);
//        }
//    }
}











