import constantElements.CartPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sitePages.*;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alexei on 11.05.17.
 */
public class CheckoutPageDataProviderTest {

    WebDriver driver;
    ProductPage productPage;
    User userData;
    CheckoutPage checkoutPage;
    HomePage homePage;
    CartPopUp cartPopUp;

    @BeforeMethod
    public void StartUp() {
        System.setProperty("webdriver.gecko.driver", "//home//alexei//geckodriver");
        driver = new FirefoxDriver();
        userData = new User();
        driver.get(SiteURL);
        driver.manage().window().maximize();
        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
        cartPopUp = new CartPopUp(driver);
    }


    @Title("Product purchase E/E test")
    @Description("Purchase the product and assert the data is inputted correctly")
    @Severity(SeverityLevel.CRITICAL)


    @Test (dataProvider = "CredentialsData")
    public void PenForm(String name) {

        WebElement product = homePage.findProductByText("DOUBLE DRAGON TIGER SKULL");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor(), "Black", "The color is wrong");


        productPage.inputProductsQuantity();
        productPage.clickAddToCartButton();

        productPage.getLayout().clickOnСSSSelector("#cart");
        checkoutPage = cartPopUp.getCartCheckoutButton();
        checkoutPage.clickOn_Step1_AccountContinueButton();
        userData.FirstName = name;
        checkoutPage.inputCredentials(userData);

        checkoutPage.chooseCountry();
        checkoutPage.chooseState();
        checkoutPage.clickOn_Step2_BillingContinueButton();

    }

    @DataProvider(name = "CredentialsData")
    public java.lang.Object[][] passData(){
        return new Object[][]{
                {"Rob"},
                {"Test0"}
        };
    }



   @AfterMethod
    public void cleanUp() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }

    }
}
