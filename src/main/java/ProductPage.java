import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.reporters.jq.BasePanel.S;

/**
 * Created by alex on 21.02.2017.
 */
public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage(WebDriverWait wait) {
        super(wait);
    }

    //Locators
    private  String CHOOSESIZEFIELD ="#input-option582";
    private String CHOOSESIZEOPTION = "#input-option582>option:nth-child(2)";
    private String CHOOSECOLOR = "option[value=\"2262\"]";
 //   private String CHOOSEQTY = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";


    public void enterSize() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHOOSESIZEOPTION)));
        Select oSelect = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));

        oSelect.selectByIndex(2263);
    }


    public void enterColor() {

       driver.findElement(By.cssSelector(CHOOSECOLOR)).click();
    }

    public void ClickOnAddToCartButton() {
        clickOn(this.ADDTOCARTBUTTON);
    }
}



