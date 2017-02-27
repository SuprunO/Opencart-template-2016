import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {

@BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32");
    }

    WebDriver driver = new ChromeDriver();


    //WebDriver driver = new FirefoxDriver();
    ProductPage purchaseProduct = new ProductPage(driver);
    RegistrPageWithUserCredentials registrPageProcess = new RegistrPageWithUserCredentials(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();
    CheckoutPage TestCheckoutPage = new CheckoutPage(driver);

    @BeforeTest
    public void StartUp() {

        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=62&product_id=246");
        driver.manage().window().maximize();
    }

    @Test
    public void enterSize() {
        purchaseProduct.enterSize();
    }

//    public void buyProductAndRegistrationTest() {
//        TestCheckoutPage.pushBillingContinueButton();
//        TestCheckoutPage.pushDeliveryDetailsContinueButton();
//        TestCheckoutPage.pushDeliveryMethodContinueButton();
//        TestCheckoutPage.pushPaymentMethodContinueButton();
//        TestCheckoutPage.pushConfirmOrderButton();
//    }


    @AfterClass
    public void cleanup() {
        driver.quit();

    }
}





