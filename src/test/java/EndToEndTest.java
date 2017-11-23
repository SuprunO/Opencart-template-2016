import constantElements.CartPopUp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import sitePages.*;
import technical.User;

import static org.openqa.selenium.By.cssSelector;
import static technical.BasePage.SiteURL;

/**
 * Created by alex on 21.02.2017.
 */
public class EndToEndTest {
    ChromeDriver driver;
    ProductPage productPage;
    User userData;
    CheckoutPage checkoutPage;
    PayPage payPage;
    HomePage homePage;
    CategoriesPage categoriesPage;
    CartPopUp cartPopUp;
    TransactionFinalPage transactionFinalPage;


    @BeforeTest
    public void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://selenium/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        userData = new User();

        productPage = new ProductPage(driver);
        homePage = new HomePage(driver);
        payPage = new PayPage(driver);
        categoriesPage = new CategoriesPage(driver);
        transactionFinalPage = new TransactionFinalPage(driver);

    }


    @DataProvider(name = "url-data-provider")
    public Object[][] urlDataProvider() {
        return new Object[][]{{"http://yourgiftshome.com"},
                {"http://weddingdev.com"},
              //  {"http://weddingstuffhub.com"},
               // {"http:/bestaccessoriesnow.com"},
              //  {"http:/bestwatchesweb.com"}
        };
    }

    @Test(dataProvider = "url-data-provider")
    public void endToEndTest(String url) {
        driver.get(url);
        driver.manage().window().maximize();
//        homePage.clickOnСSSSelector("#col-sm-35>div>div:nth-of-type(2)>div");

        if (homePage.isElementPresent(HomePage.ListOfProducts1) == true) {
            WebElement product = homePage.findProductByText("Marvelous Tulle Bateau Neckline Sheath", "h4>a");
            Assert.assertNotEquals(product, null, "Product not found!");
            product.click();
        } else if (homePage.isElementPresent(HomePage.ListOfProducts2) == true) {
            WebElement product = homePage.findProductByText("Feather Wedding Fur Wrap Shawl", ".product-content>a");
            Assert.assertNotEquals(product, null, "Product not found!");
            product.click();
        }

        else if (homePage.isElementPresent(HomePage.ListOfProducts3) == true) {
            WebElement product = homePage.findProductByText("Feather Wedding Fur Wrap Shawl",
                    ".info-p-name:nth-of-type(1)>a");
            Assert.assertNotEquals(product, null, "Product not found!");
            product.click();
        }


        try {
            Thread.sleep(8000);
        } catch (
                InterruptedException e)

        {
            e.printStackTrace();
        }

        productPage.chooseColor();
        //   Assert.assertEquals(productPage.currentColor().trim(), "Blue", "The color is wrong");
        try

        {
            Thread.sleep(5000);
        } catch (
                InterruptedException e)

        {
            e.printStackTrace();
        }
        productPage.chooseSize();
        //    Assert.assertEquals(productPage.currentSize().trim(), "US6", "The size of US6 is not matched");

        productPage.inputProductsQuantity();
        productPage.clickAddToCartButton();

        cartPopUp = productPage.getLayout().

                hoverandClickCartIcon();

        checkoutPage = cartPopUp.getCartCheckoutButton();
        checkoutPage.clickStep1AccountContinueButton();
        checkoutPage.inputCredentials(userData);
        checkoutPage.chooseCountry();
        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
        checkoutPage.chooseState();
        Assert.assertEquals(checkoutPage.currentStateSelected(), "Arkansas", "The State name have to be Arkansas");
        checkoutPage.clickStep2BillingContinueButton();
        checkoutPage.clickStep3DeliveryDetailsContinueButton();
        checkoutPage.clickStep4DeliveryMethodContinueButton();
        checkoutPage.clickStep5PaymentMethodContinueButton();
        payPage = checkoutPage.clickStep6ConfirmOrderButton();

        payPage.enterClientCredentialsPaypage(userData);
        payPage.clickOnSubmitTransactionButton();
        Assert.assertEquals(transactionFinalPage.TransactionIsSuccessful().

                getText(), "Transaction Success", "Transaction is not successful or the text Transaction Success is wrong");
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











