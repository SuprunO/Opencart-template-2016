import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {
    WebDriver driver = new FirefoxDriver();
    ProductPage PurchaseProduct = new ProductPage(driver);
    RegistrPageWithUserCredentials registrPageProcess = new RegistrPageWithUserCredentials(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();
    CheckoutPage TestCheckoutPage = new CheckoutPage(driver);

    @BeforeTest
    public void StartUp() {
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=62&product_id=246");
        driver.manage().window().maximize();
    }

    @Test
    public void MakePurchase() {
        try {
            PurchaseProduct.enterSize();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   //     PurchaseProduct.enterColor();
        PurchaseProduct.clickOnAddToCartButton();
    }


    public void inputCredentialsRegistrationPageTest() {
        registrPageProcess.verifyCredentials(userData.FirstName, userData.Lastname, userData.EMail, userData.Telephone, userData.Address, userData.City, userData.PostCode, userData.State, userData.Password);

    }

    public void buyProductAndRegistrationTest() {
        TestCheckoutPage.pushBillingContinueButton();
        TestCheckoutPage.pushDeliveryDetailsContinueButton();
        TestCheckoutPage.pushDeliveryMethodContinueButton();
        TestCheckoutPage.pushPaymentMethodContinueButton();
        TestCheckoutPage.pushConfirmOrderButton();
    }
}





