import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by alex on 21.02.2017.
 */
public class ProductPage extends BasePage {

    //Locators
    private String CHOOSESIZEFIELD = "#input-option582";
    private String CHOOSECOLORFIELD = "#input-option581";
    private String CHOOSEQTYFIELD = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void chooseSize() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        select.selectByIndex(5);
    }

    public void chooseColor(){
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSECOLORFIELD)));
        select.selectByIndex(1);
    }

    public void inputQTYofProducts(){
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).clear();
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).sendKeys("5");
    }

    public void pushAddToCartButton(){
        clickOn(ADDTOCARTBUTTON);
    }





}






