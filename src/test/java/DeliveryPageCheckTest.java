import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sitePages.DeliveryPage;
import technical.User;

/**
 * Created by alex on 20.03.2017.
 */
public class DeliveryPageCheckTest {
    WebDriver driver;
    DeliveryPage deliveryPage;
    User userData;

    @BeforeTest
    void StartUp() {
        driver = new FirefoxDriver();
        driver.get("http://kidsclothesmart.com/index.php?route=information/information&information_id=6");
        driver.manage().window().maximize();
        deliveryPage = new DeliveryPage(driver);
        userData = new User();
    }

    @Test
    public void checkTimeOfOrderPreparation() {
        Assert.assertEquals(deliveryPage.getOrderHourConditions(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkShippingRate() {
        Assert.assertEquals(deliveryPage.getShipingRate(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkMaxDelivery() {
        Assert.assertEquals(deliveryPage.getMaximumDeliveryPeriod(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkPaymentDetails() {
        Assert.assertEquals(deliveryPage.PaymentDetails(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkStatusCheck() {
        Assert.assertEquals(deliveryPage.getMaximumStatusCheck(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkRefunds() {
        Assert.assertEquals(deliveryPage.getRefunds(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void checkMaxPeriodRefunds() {
        Assert.assertEquals(deliveryPage.getRefundsInCaseOfCancellation(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void getRefundsInCaseOfCancellation() {
        Assert.assertEquals(deliveryPage.getMaxPeriodOfRefundsInCaseOfCancellation(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Test
    public void getDeliveryFontsize() {
        Assert.assertEquals(deliveryPage.getDeliveryPageFontsize(), Boolean.TRUE);
    }

    @AfterClass
    public void cleanUp() {
        driver.close();
        driver.quit();
    }


}
