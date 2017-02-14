import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by alex on 15.02.2017.
 */
public class RegressionRegistrTest {


    WebDriver driver=new FirefoxDriver();
    RegistrationPage  registrationProcess= new RegistrationPage(driver);


    @Test
    public void registrationTest () {
        driver.get("http://kidsclotheslab.com/index.php?route=account/register");


        //   user.FirstName ; user.Lastname, user.EMail, user.Telephone, user.Address, user.City, user.Country, user.State, user.Password);
    }

}
