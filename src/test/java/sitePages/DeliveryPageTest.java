package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 01.04.2017.
 */
public class DeliveryPageTest {

    WebDriver driver;
    DeliveryPage deliveryPage;
    User userData;

    @BeforeTest
    void StartUp() {
        driver = new FirefoxDriver();
        driver.get(SiteURL + "/index.php?route=information/information&information_id=6");
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
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }
    }

}