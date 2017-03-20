package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class DeliveryPage extends BasePage {

    private int SHIPPING_RATE = 18;

    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    private String DELIVERY_PAGE_CONTENT = "#content";

    public String getDeliveryPageText(){
      return driver.findElement(By.cssSelector(DELIVERY_PAGE_CONTENT)).getText();
    }



}

