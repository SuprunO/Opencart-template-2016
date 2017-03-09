import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

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


    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=62&product_id=246");
        driver.manage().window().maximize();
    }

    @Title("Purchase product")
    @Description("Chooses values of: size, color, quantity of products and clicks on Add to Cart button")

    @Test(priority = 0)
    public void buyProduct() {

        purchaseProduct.chooseSize();
        purchaseProduct.chooseColor();
        purchaseProduct.inputQTYofProducts();
        purchaseProduct.pushAddToCartButton();
    }

    @Step("User Registration")
    @Test(priority = 1)
    public void Step1_CheckoutOptions() {
        driver.get("http://kidsclotheslab.com/index.php?route=checkout/checkout");
        checkoutPage.clickOn_Step1_AccountContinueButton();
    }

    @Step("Input user Credentials")
    @Test(priority = 2)
    public void Step2_AccountBillingDetails() {
        checkoutPage.inputCredentials(userData.FirstName, userData.Lastname, userData.EMail, userData.Telephone, userData.Address, userData.City, userData.PostCode, userData.Password);
        checkoutPage.chooseCountry();
        checkoutPage.chooseState();
        checkoutPage.clickPrivacyPolicyRadioButton();
        checkoutPage.clickOn_Step2_BillingContinueButton();
    }


    @Step("Checking Delivery Details")
    @Test(priority = 3)
    public void step3_DeliveryDetails() {
        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();
    }



    @Step("Choosing Delivery Methods")
    @Test(priority = 4)
    public void step4_DeliveryMethod() {
        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();
    }



    @Step("Checking Payment Method")
    @Test(priority = 5)
    public void step5_PaymentMethod() {
        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();
    }


    @Step("Checking Delivery Details")
    @Test(priority = 6)
    public void step6_ConfirmOrder() {
        checkoutPage.clickOn_Step6_ConfirmOrderButton();
    }



    @Step("User Credentials Input into the PayPage")
    @Test(priority = 7)
    public void paypageUserCredentials() {
        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
        payPageUserCredentialsInput.clickOnSubmitTransactionButton();
    }


    @AfterClass
    public void cleanup() {

    }
}









