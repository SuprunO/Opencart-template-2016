import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by alex on 05.02.2017.
 */
public class RegistrationTest extends TestHomePage{


    @Test
    public void RegistrVerifyText(){
        HomePage.lnk_Login(driver).click();
        Assert.assertEquals(RegistrationPage.NewCustomerHeader(driver).getText(),"New Customer","The NewCustomerHeader is wrong or missing");
        Assert.assertEquals(RegistrationPage.RegisterAccountHeader(driver).getText(),"Register Account"," Register Account header is wrong or missing");
        Assert.assertEquals(RegistrationPage.RegisterAccountText(driver).getText(),"By creating an account you will be able to shop faster, be up to date on an order's status, and keep track of the orders you have previously made."," Register Account text is wrong or missing");
    }
}
