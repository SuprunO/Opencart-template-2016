import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by alex on 15.02.2017.
 */
public class RegressionRegistrTest {


    WebDriver driver = new FirefoxDriver();
    RegistrPageWithUserCredentials registrPageProcess = new RegistrPageWithUserCredentials(driver);
    UserCredentialsProvider dataProvider = new UserCredentialsProvider();

    @BeforeTest
    public void startUp() {
        driver.get(dataProvider.SiteURL +"/index.php?route=account/register");
        driver.manage().window().maximize();
    }

    @Test
    public void inputCredentialsRegistrationPageTest() {
        registrPageProcess.verifyCredentials(dataProvider.FirstName, dataProvider.Lastname, dataProvider.EMail, dataProvider.Telephone, dataProvider.Address, dataProvider.City, dataProvider.PostCode,dataProvider.State, dataProvider.Password);
    }





}
