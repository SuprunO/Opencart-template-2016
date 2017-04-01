import constantElements.TopPage_CartPopUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sitePages.*;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 21.02.2017.
 */
public class EndToEndTest {
    WebDriver driver;
    ProductPage productPage;
    User userData;
    RealCheckoutPage realCheckoutPage;
    CheckoutPage checkoutPage;
    PayPage payPage;
    CartPage cartPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    TopPage_CartPopUp topPage_cartPopUp;

    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        userData = new User();
        driver.get(SiteURL + "/index.php?route=product/product&path=59&product_id=82");
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        realCheckoutPage = new RealCheckoutPage(driver);
        checkoutPage = new CheckoutPage(driver);
        payPage = new PayPage(driver);
        homePage = new HomePage(driver);
        categoriesPage = new CategoriesPage(driver);
        topPage_cartPopUp = new TopPage_CartPopUp(driver);
        cartPage = new CartPage((driver));
    }


    @Test
    @Title("Product purchase E/E test")
    @Description("Purchase the product and assert the data is inputted correctly")
    @Severity(SeverityLevel.CRITICAL)
    public void endToEndTest() {
        productPage.chooseSize();
        Assert.assertEquals(productPage.currentSize(), "US6", "The size of is not matched");
        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor(), "white", "The color is wrong");
        productPage.inputProductsQuantity();
        productPage.pushAddToCartButton();

//        topPage_cartPopUp.hoverandClickCartIcon();
        // Зачем это делать?
        cartPage = topPage_cartPopUp.clickCartIcon();
        cartPage.getCartCheckoutButton().click();

        checkoutPage.clickOn_Step1_AccountContinueButton();
      // поменять на data provider
        checkoutPage.inputCredentials(userData);

        checkoutPage.chooseCountry();
        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
        checkoutPage.chooseState();
        Assert.assertEquals(checkoutPage.currentStateSelected(), "Arkansas", "The State name have to be United States");
        checkoutPage.clickPrivacyPolicyRadioButton();

        checkoutPage.clickOn_Step2_BillingContinueButton();

        checkoutPage.clickOn_Step3_DeliveryDetailsContinueButton();

        checkoutPage.clickOn_Step4_DeliveryMethodContinueButton();

        checkoutPage.clickOn_Step5_PaymentMethodContinueButton();

        checkoutPage.clickOn_Step6_ConfirmOrderButton();

        payPage.enterClientCredentialsPaypage(userData.FirstName, userData.Lastname, userData.Address, userData.City, userData.PostCode, userData.Country, userData.Telephone, userData.EMail, userData.IssuingBank, userData.CardNumber, userData.ExpirationMonth, userData.ExpirationYear, userData.CVV2);
        payPage.clickOnSubmitTransactionButton();
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











