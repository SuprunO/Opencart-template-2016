package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */



public class ProductPage extends BasePage {

    //Locators
    private String CHOOSESIZEFIELD = "#input-option292";
    private String CHOOSECOLORFIELD = "#input-option291";
    private String CHOOSEQTYFIELD = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void chooseSize() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        select.selectByIndex(3);
    }

    @Step
    public String currentSize() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSESIZEFIELD)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void chooseColor() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSECOLORFIELD)));
        select.selectByIndex(1);
    }

    @Step
    public String currentColor() {
        Select select = new Select(driver.findElement(By.cssSelector(CHOOSECOLORFIELD)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void inputProductsQuantity() {
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).clear();
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).sendKeys("5");
    }


    @Step
    public void pushAddToCartButton() {
        waiter(ADDTOCARTBUTTON);
        clickOn(ADDTOCARTBUTTON);
    }
}







