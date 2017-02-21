import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

/**
 * Created by alex on 21.02.2017.
 */
public class PurchaseProductTest {
    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void StartUp() {
        driver.get("http://fashionstylefit.com/index.php?route=product/product&path=59_60&product_id=76");
        driver.manage().window().maximize();


    }
}
