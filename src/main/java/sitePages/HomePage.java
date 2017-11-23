package sitePages;

import constantElements.Layout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Layout getLayout() {
        return new Layout(driver);
    }

    public static final By ListOfProducts1 =By.cssSelector("h4>a");
    public static final By Products2 =By.cssSelector("#bodyContent>.container>.row>div>div>ul>li:first-child>div>.product-content>div:first-child>a");
    public static final By ListOfProducts3 =By.cssSelector(".info-p-name>a");


    public static final By ShoppingCartIcon1 =By.cssSelector(".header-shopping-cart>h3>a");
    public static final By ShoppingCartIcon2 =By.cssSelector("#cart");



}





