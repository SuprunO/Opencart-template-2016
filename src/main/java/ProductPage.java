import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by alex on 21.02.2017.
 */
public class ProductPage extends PageObject {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private String CHOOSESIZE = "option[value=\"201\"]";
    private String CHOOSECOLOR = "#input-option279 option[value=\"199\"]";
    private String CHOOSEQTY = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";


    public void enterSize() {
        clickOn(this.CHOOSESIZE);
    }

    public void enterColor() {
        clickOn(this.CHOOSECOLOR);
    }

    public void ClickOnAddToCartButton() {
        clickOn(this.ADDTOCARTBUTTON);
    }
}


