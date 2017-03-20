import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.DeliveryPage;
import technical.User;

/**
 * Created by alex on 20.03.2017.
 */
public class DeliveryPageConditionsCheck {
    WebDriver driver;
    DeliveryPage deliveryPage;
    User userData;





    @BeforeTest
    void StartUp(){
        driver = new FirefoxDriver();
        driver.get("http://kidsclothesmart.com/index.php?route=information/information&information_id=6");
        driver.manage().window().maximize();
        deliveryPage = new DeliveryPage(driver);
        userData = new User();
    }

    @Test
    public void checkDeliveryConditions(){
        Assert.assertTrue(deliveryPage.getDeliveryPageText().contains("shipping rate of $17 per order"),"Shipping rate have to be at $18 per order");
    }

}
