import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.*;
import technical.User;

/**
 * Created by alex on 21.02.2017.
 */
public class EndToEndFunctionalTest {
    WebDriver driver;
    ProductPage purchaseProduct;
    User userData;
    RealCheckoutPage realCheckoutPage;
    CheckoutPage checkoutPage;
    PayPage payPageUserCredentialsInput;
    CartPage cartPage;
    HomePage homePage;
    CategoriesPage categoriesPage;

    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        userData = new User();
        driver.get(userData.SiteURL + "/index.php?route=product/product&product_id=229");
        driver.manage().window().maximize();
        purchaseProduct = new ProductPage(driver);
        realCheckoutPage = new RealCheckoutPage(driver);
        checkoutPage = new CheckoutPage(driver);
        payPageUserCredentialsInput = new PayPage(driver);
        homePage = new HomePage(driver);
        categoriesPage = new CategoriesPage(driver);
    }

    @Test
    public void endToEndTest() {
        purchaseProduct.chooseSize();
        Assert.assertEquals(purchaseProduct.currentSize(), "110", "The size of 110 is not matched");
        purchaseProduct.chooseColor();
        Assert.assertEquals(purchaseProduct.currentColor(), "pink", "The color is wrong");
        purchaseProduct.inputQTYofProducts();

        purchaseProduct.pushAddToCartButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cartPage = homePage.clickIconLinkCart();

        cartPage.getCartCheckoutButton().click();

        checkoutPage.clickOn_Step1_AccountContinueButton();

        // поменять методы
        checkoutPage.inputCredentials(userData);


        checkoutPage.chooseCountry();
        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
        checkoutPage.chooseState();
        Assert.assertEquals(checkoutPage.currentStateSelected(), "Arkansas", "The State name have to be United States");
        checkoutPage.clickPrivacyPolicyRadioButton();

        checkoutPage.clickOn_Step2_BillingContinueButton();

        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();

        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();

        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();

        checkoutPage.clickOn_Step6_ConfirmOrderButton();

        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
        payPageUserCredentialsInput.clickOnSubmitTransactionButton();
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











