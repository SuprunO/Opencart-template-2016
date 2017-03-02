import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PayPageRegistrPageTest {

    WebDriver driver = new FirefoxDriver();
    PayPage payPageUserCredentialsInput = new PayPage(driver);
    UserCredentialsProvider userData = new UserCredentialsProvider();
    TransactionFinalPage paymentStatus = new TransactionFinalPage(driver);


    @BeforeTest
    public void startUp() {
        driver.get(userData.SiteURL + "/index.php?route=checkout/creditcard");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void paypageInputCredentialsTest() {
        payPageUserCredentialsInput.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
    }

    @Test(priority = 2)
    public void verifyThePaymentIsDone() {
        Assert.assertEquals(paymentStatus.checkTheTransactionIsSuccessful().getText(), "Transaction Success", "The payment test is successfull");
    }


}
