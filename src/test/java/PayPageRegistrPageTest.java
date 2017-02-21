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
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();
    TransactionFinalPage paymentStatus = new TransactionFinalPage(driver);


    @BeforeTest
    public void startUp() {
        driver.get(dataProvider.SiteURL + "/index.php?route=checkout/creditcard");
    }

    @Test(priority = 1)
    public void paypageInputCredentialsTest() {
        payPageUserCredentialsInput.enterClientCredentialsPaypage(dataProvider.FirstName, dataProvider.Lastname, dataProvider.Address, dataProvider.City, dataProvider.PostCode, dataProvider.Country, dataProvider.Telephone, dataProvider.EMail, dataProvider.IssuingBank, dataProvider.CardNumber, dataProvider.ExpirationMonth, dataProvider.ExpirationYear, dataProvider.CVV2);
    }

    @Test(priority = 2)
    public void verifyThePaymentIsDone() {
        Assert.assertEquals(paymentStatus.checkTheTransactionIsSuccessful().getText(), "Transaction Success", "The payment test is successfull");
    }
}
