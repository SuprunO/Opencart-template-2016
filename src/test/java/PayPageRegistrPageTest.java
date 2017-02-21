import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PayPageRegistrPageTest {

    WebDriver driver = new FirefoxDriver();
    PayPage payPageProcess = new PayPage(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();

    @BeforeTest
    public void startUp() {
        driver.get("http://weddingclothesnow.com/index.php?route=checkout/creditcard");
    }

    @Test
    public void paypageInputCredentialsTest() {
        payPageProcess.enterClientCredentialsPaypage(dataProvider.FirstName, dataProvider.Lastname, dataProvider.Address, dataProvider.City, dataProvider.PostCode, dataProvider.Telephone, dataProvider.EMail, dataProvider.IssuingBank, dataProvider.CardNumber, dataProvider.CVV2);
    }
}
