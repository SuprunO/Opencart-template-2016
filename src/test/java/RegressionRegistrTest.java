import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 15.02.2017.
 */
public class RegressionRegistrTest {


    WebDriver driver = new FirefoxDriver();
    RegistrPageWithUserCredentials registrPageProcess = new RegistrPageWithUserCredentials(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();

    @BeforeTest
    public void startUp() {
        driver.get("http://weddingclothesnow.com/index.php?route=account/register");
    }

    @Test
    public void inputCredentialsRegistrationPageTest() {
        registrPageProcess.verifyCredentials(dataProvider.FirstName, dataProvider.Lastname, dataProvider.EMail, dataProvider.Telephone, dataProvider.Address, dataProvider.City, dataProvider.PostCode,dataProvider.State, dataProvider.Password);

    }

}
