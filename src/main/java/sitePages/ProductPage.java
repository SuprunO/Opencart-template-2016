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

    public Layout getLayout(){
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

    public void colorList() {
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("US2");
        obj.add("US4");
        obj.add("US6");
        obj.add("US8");
        obj.add("US10");
        obj.add("US12");
        obj.add("US14");
        obj.add("US16");
        obj.add("US16W");
        obj.add("US18W");
        obj.add("US20W");
        obj.add("US22W");
        obj.add("US24W");
        obj.add("US26W");
        obj.toArray();
    }
}







