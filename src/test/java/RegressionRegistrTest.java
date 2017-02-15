import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 15.02.2017.
 */
public class RegressionRegistrTest {


    WebDriver driver=new FirefoxDriver();
    RegistrPageWithUserCredentials registrProcess= new RegistrPageWithUserCredentials(driver);

    @BeforeTest
    public void startUp(){
        driver.get("http://kidsclotheslab.com/index.php?route=account/register");
    }


    @Test
    public void registrationTest () {
    }
}
