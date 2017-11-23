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

    public static final By Product2 = By.cssSelector("#col-sm-35>div>div:nth-of-type(2)>div");
    public static final By ListOfProducts1 =By.cssSelector("h4>a");
    public static final By ListOfProducts2 =By.cssSelector(".product-content>a");
    public static final By ListOfProducts3 =By.cssSelector(".info-p-name:nth-of-type(1)>a");

//    public class Product {
//        public WebElement color;
//        public WebElement size;
//        public WebElement button;
//
//
//        public Product(String name){
//            color = findElementByName(name);
//            size =  color.findElement(By.xpath("../div[2]"));
//            button =  color.findElement(By.xpath("../div[2]"));
//        }

// Pictures

}





