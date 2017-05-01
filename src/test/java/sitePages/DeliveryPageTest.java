package sitePages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
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
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(SiteURL + "/index.php?route=information/information&information_id=6");
        driver.manage().window().maximize();
        deliveryPage = new DeliveryPage(driver);
        userData = new User();
    }


    @Title("Order preparation verify test")
    @Description("Order preparation to be 48 hours")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkTimeOfOrderPreparation() {
        Assert.assertEquals(deliveryPage.getOrderHourConditions(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Title("Shipping rate verify test")
    @Description("Shipping rate amount")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkShippingRate() {
        Assert.assertEquals(deliveryPage.getShipingRate(), Boolean.TRUE, "shipping rate of $15 for every order");
    }

    @Title("Maximum 20 working days condition")
    @Description("The delivery to be maximum 20 working days")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkMaxDelivery() {
        Assert.assertEquals(deliveryPage.getMaximumDeliveryPeriod(), Boolean.TRUE, "The delivery to be maximum 20 working days");
    }

    @Title("MasterCard and VISA")
    @Description("Payments can be done with MasterCard and VISA only")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkPaymentDetails() {
        Assert.assertEquals(deliveryPage.PaymentDetails(), Boolean.TRUE, "Add payments with MasterCard and VISA");
    }

    @Title("Maximum 20 working days condition")
    @Description("The delivery to be maximum 20 working days")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void checkStatusCheck() {
        Assert.assertEquals(deliveryPage.getMaximumStatusCheck(), Boolean.TRUE, "The purchase needs 48 hours to prepare it for shipping");
    }

    @Title("Delivery Status Check")
    @Description("You can check delivery in 36 hours")
    @Severity(SeverityLevel.NORMAL)
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
        Assert.assertEquals(deliveryPage.getMaxPeriodOfRefundsInCaseOfCancellation(), Boolean.TRUE, "10 working days");
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