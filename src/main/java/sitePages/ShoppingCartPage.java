package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 01.05.2017.
 */
public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public static final By CART_CHECKOUT_BUTTON1 = By.cssSelector(".btn-primary:last-of-type");
    public static final By CART_CHECKOUT_BUTTON2 = By.cssSelector("#tdb5");



    public WebElement ShoppingCartHeader() {
        return driver.findElement(By.cssSelector("#content>h1"));
    }

    public WebElement ImageHeader() {
        return driver.findElement(By.cssSelector("#td-sm-10"));
    }

    public WebElement ProductNameHeader() {
        return driver.findElement(By.cssSelector("#td-sm-11"));
    }

    public WebElement ModelHeader() {
        return driver.findElement(By.cssSelector("#td-sm-12"));
    }

    public WebElement QuantityHeader() {
        return driver.findElement(By.cssSelector("#td-sm-13"));
    }

    public WebElement UnitPriceHeader() {
        return driver.findElement(By.cssSelector("#td-sm-14"));
    }

    public WebElement TotalHeader() {
        return driver.findElement(By.cssSelector("#td-sm-15"));
    }


    public WebElement ProductNameText() {
        return driver.findElement(By.cssSelector("#td-sm-17>a"));
    }

    public WebElement Color() {
        return driver.findElement(By.cssSelector("#td-sm-17>small:first-of-type"));
    }

    public WebElement Size() {
        return driver.findElement(By.cssSelector("#td-sm-17>small:last-of-type"));
    }

    public WebElement NumberOfItems() {
        return driver.findElement(By.cssSelector("#content>.form-control"));
    }

    public WebElement PricePerItem() {
        return driver.findElement(By.cssSelector("#td-sm-20"));
    }

    public WebElement PriceOne() {

        return driver.findElement(By.cssSelector("#td-sm-21"));
    }

    public WebElement PriceTwo() {

        return driver.findElement(By.cssSelector("#td-sm-23"));
    }

    public WebElement PriceThree() {

        return driver.findElement(By.cssSelector("#td-sm-25"));
    }
}
