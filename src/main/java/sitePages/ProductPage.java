package sitePages;


import constantElements.Layout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;

import java.util.ArrayList;

/**
 * Created by alex on 21.02.2017.
 */


public class ProductPage extends BasePage {

    public Layout getLayout() {
        return new Layout(driver);

    }

    private String COLORLOCATOR = "#input-option526";
    private String SIZELOCATOR = "#input-option525";
    private String CHOOSEQTYFIELD = "#input-quantity";
    private String ADDTOCARTBUTTON = "#button-cart";

    public ProductPage(WebDriver driver) {
        super(driver);
    }


    @Step
    public void chooseColor() {
        waitCSSSelector(COLORLOCATOR);
        Select select = new Select(driver.findElement(By.cssSelector(COLORLOCATOR)));
        select.selectByIndex(1);
    }

    @Step
    public String currentColor() {
        Select select = new Select(driver.findElement(By.cssSelector(COLORLOCATOR)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void chooseSize() {
        Select select = new Select(driver.findElement(By.cssSelector(SIZELOCATOR)));
        select.selectByIndex(3);
    }

    @Step
    public String currentSize() {
        Select select = new Select(driver.findElement(By.cssSelector(SIZELOCATOR)));
        return select.getFirstSelectedOption().getText();
    }


    @Step
    public void inputProductsQuantity() {
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).clear();
        driver.findElement(By.cssSelector(CHOOSEQTYFIELD)).sendKeys("5");
    }


    @Step
    public void pushAddToCartButton() {
        waitCSSSelector(ADDTOCARTBUTTON);
        clickOnСSSSelector(ADDTOCARTBUTTON);
    }

    public int sizeDropdownExpectedSize() {
        ArrayList<String> size = new ArrayList<String>();
        size.add("--- Please Select ---");
        size.add("US2");
        size.add("US4");
        size.add("US6");
        size.add("US8");
        size.add("US10");
        size.add("US12");
        size.add("US14");
        size.add("US16");
        size.add("US16W");
        size.add("US18W");
        size.add("US20W");
        size.add("US22W");
        size.add("US24W");
        size.add("US26W");
        return size.size();
    }


    public String sizeDropdownExpectedOptions(){
        ArrayList<String> size = new ArrayList<String>();
        size.add("--- Please Select ---");
        size.add("US2");
        size.add("US4");
        size.add("US6");
        size.add("US8");
        size.add("US10");
        size.add("US12");
        size.add("US14");
        size.add("US16");
        size.add("US16W");
        size.add("US18W");
        size.add("US20W");
        size.add("US22W");
        size.add("US24W");
        size.add("US26W");
        return size.toString();
    }
}







