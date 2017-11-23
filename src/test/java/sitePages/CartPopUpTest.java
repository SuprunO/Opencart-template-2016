package sitePages;

import constantElements.CartPopUp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import technical.User;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 08.04.2017.
 */
public class CartPopUpTest {
    ChromeDriver driver;
    ProductPage productPage;
    User userData;
    HomePage homePage;
    CartPopUp cartPopUp;

    @BeforeClass
    public void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPopUp = new CartPopUp(driver);

    }

    //Locators
    @Title("Cart Pop up test")
    @Description("Purchase the product and validate all the product info is in the Pop up Correct")
    @Severity(SeverityLevel.CRITICAL)


    @Test
    public void CartPopUpTest() {
   //     WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
   //     Assert.assertNotEquals(product, null, "Product not found!");
    ///    product.click();
        homePage.waitCSSSelector("#content>h1");

        productPage.chooseColor();
        Assert.assertEquals(productPage.currentColor().trim(), "Blue", "The color is wrong");
        productPage.chooseSize();
        Assert.assertEquals(productPage.currentSize().trim(), "US6", "The size of US6 is not matched");

        productPage.inputProductsQuantity();
        productPage.clickAddToCartButton();
        cartPopUp = productPage.getLayout().hoverandClickCartIcon();
        Assert.assertEquals(cartPopUp.getProductNameLocator().getText(),productPage.getProductNameLocator().getText(), "The product name is wrong");
        Assert.assertEquals(cartPopUp.getColorLocator().getText().trim(),"Color Blue", "The product color in the pop up is wrong");
        Assert.assertEquals(cartPopUp.getSizeLocator().getText().trim(),"Size US6", "The product color size in the popup is wrong");
        Assert.assertEquals(cartPopUp.getNumberOfItemsLocator().getText().replace("x ","").trim(),"5","The quantity is wrong");
        Assert.assertEquals(cartPopUp.getProductPriceLocator().getText().trim(),"$660", "The product price in the popup is wrong");
       // Assert.assertEquals(cartPopUp.getSubtotalPriceLocator().getText().trim(),"$660","The product subtotal price in the in the popup is wrong");
       // Assert.assertEquals(cartPopUp.getTotalPriceLocator().getText().trim(),"$660","The product total price in the in the popup is wrong");
        Assert.assertEquals(cartPopUp.getViewCartButtonLocator().getText(),"View Cart","The text is wrong");
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
