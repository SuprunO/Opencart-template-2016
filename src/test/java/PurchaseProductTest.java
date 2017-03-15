import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.*;
import technical.UserCredentialsProvider;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {
    WebDriver driver;
    ProductPage purchaseProduct;
    UserCredentialsProvider userData;
    RealCheckoutPage realCheckoutPage;
    CheckoutPage checkoutPage;
    PayPage payPageUserCredentialsInput;
    CartPage cartPage;
    HomePage homePage;
    CategoriesPage categoriesPage;


    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        userData = new UserCredentialsProvider();
        driver.get(userData.SiteURL + "/index.php?route=product/product&product_id=229");
        driver.manage().window().maximize();
        purchaseProduct = new ProductPage(driver);
        realCheckoutPage = new RealCheckoutPage(driver);
        checkoutPage = new CheckoutPage(driver);
        payPageUserCredentialsInput = new PayPage(driver);
        cartPage = new CartPage(driver);
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
        Assert.assertEquals(purchaseProduct.currentQuantityInInput(), "5", "The quantity is not matched");
        purchaseProduct.pushAddToCartButton();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.get_Icon_Link_Cart().click();

        cartPage.getCartCheckoutButton().click();

        checkoutPage.clickOn_Step1_AccountContinueButton();
        checkoutPage.inputCredentials(userData.FirstName, userData.Lastname, userData.EMail, userData.Telephone, userData.Address, userData.City, userData.PostCode, userData.Password);

        Assert.assertEquals(checkoutPage.currentFirstNameInput(), userData.FirstName, "The First name have to be " + userData.FirstName);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The Last name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentEmailInput(), userData.EMail, "The Email name have to be " + userData.EMail);
        Assert.assertEquals(checkoutPage.currentPhoneInput(), userData.Telephone, "The Telephone name have to be " + userData.Telephone);
        Assert.assertEquals(checkoutPage.currentAddressInput(), userData.Address, "The Address name have to be " + userData.Address);
        Assert.assertEquals(checkoutPage.currentCityInput(), userData.City, "The City name have to be " + userData.City);
        Assert.assertEquals(checkoutPage.currentPostCodeInput(), userData.PostCode, "The Telephone name have to be " + userData.PostCode);
        Assert.assertEquals(checkoutPage.currentPasswordInput(), userData.Password, "The Password name have to be " + userData.Password);

        checkoutPage.chooseCountry();
        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
        checkoutPage.chooseState();
        Assert.assertEquals(checkoutPage.currentStateSelected(), "Alabama", "The State name have to be United States");
        checkoutPage.clickPrivacyPolicyRadioButton();

        checkoutPage.clickOn_Step2_BillingContinueButton();

        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();

        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();

        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();

        checkoutPage.clickOn_Step6_ConfirmOrderButton();

        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
//циклом?
        Assert.assertEquals(checkoutPage.currentFirstNameInput(), userData.FirstName, "The State name have to be " + userData.FirstName);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Address, "The Address name have to be " + userData.Address);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);
        Assert.assertEquals(checkoutPage.currentLastNameInput(), userData.Lastname, "The State name have to be " + userData.Lastname);

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











