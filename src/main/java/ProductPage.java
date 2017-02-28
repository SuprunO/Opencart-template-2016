import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by alex on 21.02.2017.
 */
public class ProductPage extends PageObject {

    //Locators
    private String CHOOSESIZEFIELD = "#input-option582";
    //   private String CHOOSECOLOR = "option[value=\"2262\"]";
    //   private String CHOOSEQTY = "#input-quantity";
  //  private String ADDTOCARTBUTTON = "#button-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void enterSize() {
        clickOn(this.CHOOSESIZEFIELD);
        Select select=new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        List<WebElement> elements = driver.findElements(By.cssSelector("#input-option582 option"));
//        Actions action=new Actions(driver);
//        action.moveToElement(elements.get(5)).build().perform();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elements.get(5).click();
        Assert.assertTrue(true==true);
        }
    }






