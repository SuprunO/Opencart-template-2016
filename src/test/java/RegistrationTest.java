import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrationTest{






        @BeforeClass
        public void startUp () {
            Registration registration = new Registration();


            driver.get("http://kidsclotheslab.com/index.php?route=account/login");
        }


        @Test
        public void newCustomerHeader () {

            Assert.assertEquals(RegistrationPage.NewCustomerHeader(driver).getText(), "New Customer", "The NewCustomerHeader is wrong or missing");
        }

        @Test
        public void RegisterAccountHeader () {
            Assert.assertEquals(RegistrationPage.RegisterAccountHeader(driver).getText(), "Register Account", " Register Account header is wrong or missing");
        }

        @Test
        public void RegisterAccountText () {
            Assert.assertEquals(RegistrationPage.RegisterAccountText(driver).getText(), "By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made.", " Register Account text is wrong or missing");
        }

        @Test
        public void registerAccountButton () {
            Assert.assertEquals(RegistrationPage.RegisterAccountButton(driver).getText(), "Continue", " Continue Button text is wrong or missing");
        }

        @Test
        public void registrationTest () {
            driver.get("http://kidsclotheslab.com/index.php?route=account/register");


         //   user.FirstName ; user.Lastname, user.EMail, user.Telephone, user.Address, user.City, user.Country, user.State, user.Password);
        }
    }