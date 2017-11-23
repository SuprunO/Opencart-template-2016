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
    ShoppingCartPage shoppingCartPage;
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
        cartPopUp = new CartPopUp(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        productPage = new ProductPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage = new HomePage(driver);
        payPage = new PayPage(driver);
        categoriesPage = new CategoriesPage(driver);
        transactionFinalPage = new TransactionFinalPage(driver);

    }


    @DataProvider(name = "url-data-provider")
    public Object[][] urlDataProvider() {
        return new Object[][]{//{"http://yourgiftshome.com"},
                {"http://weddingdev.com"},
                {"http:/bestwatchesweb.com"}
                //  {"http://weddingstuffhub.com"},
                // {"http:/bestaccessoriesnow.com"},

        };
    }

    @Test(dataProvider = "url-data-provider")
    public void endToEndTest(String url) {
        driver.get(url);
        driver.manage().window().maximize();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        if (homePage.isElementPresent(HomePage.ListOfProducts1) == true) {
            WebElement product = homePage.findProductByText("Marvelous Tulle Bateau Neckline Sheath", HomePage.ListOfProducts1);
            Assert.assertNotEquals(product, null, "Product not found!");
            product.click();
        } else if (homePage.isElementPresent(HomePage.Products2) == true) {
            homePage.clickOnElement(HomePage.Products2, "Click on Product Site 2");
        }

        productPage.threadSleep(5000);
        if (productPage.isElementPresent(ProductPage.SELECT_COLOR) == true) {

            productPage.chooseColor();
        } else {

        }

        productPage.threadSleep(5000);
        if (productPage.isElementPresent(ProductPage.SELECT_SIZE) == true) {
            productPage.chooseSize();
        } else {

        }

        if (productPage.isElementPresent(ProductPage.CHOOSEQTYFIELD) == true) {
            productPage.inputProductsQuantity();
        } else {

        }
        if (productPage.isElementPresent(ProductPage.ADDTOCARTBUTTON1) == true) {
            productPage.clickOnElement(ProductPage.ADDTOCARTBUTTON1, "Add to cart Button Site 1");
        } else {
            productPage.clickOnElement(ProductPage.ADDTOCARTBUTTON2, "Add to cart Button Site 2");
        }


        productPage.threadSleep(5000);
        if (homePage.isElementPresent(ProductPage.Link_to_shopping_cart) == true) {
            homePage.clickOnElement(ProductPage.Link_to_shopping_cart, "Shopping Cart icon");
        } else {
            homePage.clickOnElement(ProductPage.Link_to_shopping_cart2, "Checkout Cart icon Site 2");
        }


        if (homePage.isElementPresent(ShoppingCartPage.CART_CHECKOUT_BUTTON1) == true) {
            homePage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON1, "CART_CHECKOUT_BUTTON1");
        } else {
            homePage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON2, "CART_CHECKOUT_BUTTON2");
        }

        if (shoppingCartPage.isElementPresent(ShoppingCartPage.CART_CHECKOUT_BUTTON1) == true) {
            shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON1, "CART_CHECKOUT_BUTTON1");
//        } else {
//            shoppingCartPage.clickOnElement(ShoppingCartPage.CART_CHECKOUT_BUTTON2, "CART_CHECKOUT_BUTTON2");
//        }
            checkoutPage.threadSleep(5000);


            if (checkoutPage.isElementPresent(CheckoutPage.CONTINUE_BUTTON1) == true) {
                checkoutPage.clickOnElement(CheckoutPage.CONTINUE_BUTTON1, "CONTINUE_BUTTON1");
            } else {
                checkoutPage.clickOnElement(CheckoutPage.CONTINUE_BUTTON2, "CONTINUE_BUTTON Site 2");
            }
            checkoutPage.inputCredentials(userData);
        }
    }



//        checkoutPage.chooseCountry();
//        Assert.assertEquals(checkoutPage.currentCountrySelected(), "United States", "The Country have to be United States");
//        checkoutPage.chooseState();
//        Assert.assertEquals(checkoutPage.currentStateSelected(), "Arkansas", "The State name have to be Arkansas");
//        checkoutPage.clickStep2BillingContinueButton();
//        checkoutPage.clickStep3DeliveryDetailsContinueButton();
//        checkoutPage.clickStep4DeliveryMethodContinueButton();
//        checkoutPage.clickStep5PaymentMethodContinueButton();
//        payPage = checkoutPage.clickStep6ConfirmOrderButton();
//
//        payPage.enterClientCredentialsPaypage(userData);
//        payPage.clickOnSubmitTransactionButton();
//        Assert.assertEquals(transactionFinalPage.TransactionIsSuccessful().
//
//                getText(), "Transaction Success", "Transaction is not successful or the text Transaction Success is wrong");
//    }


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












