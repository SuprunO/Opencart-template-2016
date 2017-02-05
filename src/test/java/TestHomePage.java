import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Driver;

/**
 * Created by alex on 04.02.2017.
 */
public class TestHomePage {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver,25);

    private String login="Login";


    @BeforeClass
    public void startUp(){
        driver.get("http://kidsclotheslab.com");
        }


    @Test
    public void verifyLogin() {
        Assert.assertEquals(HomePage.lnk_Login(driver).getText(), login, "Login check failed");
    }

    @Test
    public void verifyHome(){
        Assert.assertEquals(HomePage.lnk_Home(driver).getText(), "Home", "Home check failed");
    }

    @Test
    public void verifyContactUs(){
        Assert.assertEquals(HomePage.lnk_ContactUs(driver).getText(), "Contact Us"," Contact us check failed");
  }

}
