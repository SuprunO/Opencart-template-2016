import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.CheckoutPage;
import sitePages.PayPage;
import sitePages.ProductPage;
import technical.UserCredentialsProvider;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {
    WebDriver driver = new FirefoxDriver();

    ProductPage purchaseProduct = new ProductPage(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();
    RealCheckoutPage realCheckoutPage = new RealCheckoutPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);
    PayPage payPageUserCredentialsInput = new PayPage(driver);
    CartPage cartPage=new CartPage(driver);


    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver.get(userData.SiteURL+"/index.php?route=product/product&path=62&product_id=247");
        driver.manage().window().maximize();
    }

    @Test
    public void endToEndTest() {

        purchaseProduct.chooseSize();
        purchaseProduct.chooseColor();
        purchaseProduct.inputQTYofProducts();
        purchaseProduct.pushAddToCartButton();

        //cartPage.getCartCheckoutButton().click();
        driver.navigate().to("http://kidsclothesmart.com/index.php?route=checkout/checkout");
        checkoutPage.clickOn_Step1_AccountContinueButton();

        checkoutPage.inputCredentials(userData.FirstName, userData.Lastname, userData.EMail, userData.Telephone, userData.Address, userData.City, userData.PostCode, userData.Password);
        checkoutPage.chooseCountry();
        checkoutPage.chooseState();
        checkoutPage.clickPrivacyPolicyRadioButton();
        checkoutPage.clickOn_Step2_BillingContinueButton();

        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();

        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();

        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();

        checkoutPage.clickOn_Step6_ConfirmOrderButton();

        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
        payPageUserCredentialsInput.clickOnSubmitTransactionButton();
    }
}









