import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {
    WebDriver driver = new FirefoxDriver();
    ProductPage PurcaseProduct = new ProductPage(driver);

    @BeforeTest
    public void StartUp() {
        driver.get("http://fashionstylefit.com/index.php?route=product/product&path=59_60&product_id=76");
        driver.manage().window().maximize();
    }

    @Test
    public void MakePurchase() {
        PurcaseProduct.enterSize();
        PurcaseProduct.enterColor();
        PurcaseProduct.ClickOnAddToCartButton();
    }
}

