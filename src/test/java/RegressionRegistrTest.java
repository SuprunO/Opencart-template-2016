import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 15.02.2017.
 */
public class RegressionRegistrTest {


    WebDriver driver = new FirefoxDriver();
    RegistrPageWithUserCredentials registrProcess = new RegistrPageWithUserCredentials(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();

    @BeforeTest
    public void startUp(){
        driver.get("http://kidsclotheslab.com/index.php?route=account/register");
    }

    @Test
    public void registrationTest () {
        registrProcess.verifyCredentials(dataProvider.FirstName,dataProvider.Lastname,dataProvider.EMail,dataProvider.Telephone,dataProvider.Address,dataProvider.City,dataProvider.State,dataProvider.Password);
    }

    }
