package sitePages;

import constantElements.Layout;
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





