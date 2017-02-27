import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 22.02.2017.
 */
public class CheckoutPageTest {
    WebDriver driver = new FirefoxDriver();
    CheckoutPage TestCheckoutPage = new CheckoutPage(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();


    @BeforeTest
    public void startUp() {
        driver.get(dataProvider.SiteURL + "/index.php?route=checkout/checkout");
        driver.manage().window().maximize();
    }

//    @Test
//    public void buyProductsAndRegistrationTest() {
//
//        TestCheckoutPage.pushBillingContinueButton();
//        TestCheckoutPage.pushDeliveryDetailsContinueButton();
//        TestCheckoutPage.pushDeliveryMethodContinueButton();
//        TestCheckoutPage.pushPaymentMethodContinueButton();
//        TestCheckoutPage.pushConfirmOrderButton();
//    }

}