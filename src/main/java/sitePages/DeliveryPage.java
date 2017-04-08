package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class DeliveryPage extends BasePage {


    public DeliveryPage(WebDriver driver) {
        super(driver);
    }

    private String DELIVERY_PAGE_CONTENT = "#content";

    private String getDeliveryPageText(){
        waitCSSSelector(DELIVERY_PAGE_CONTENT);
      return driver.findElement(By.cssSelector(DELIVERY_PAGE_CONTENT)).getText();
    }



    public Boolean getOrderHourConditions(){
      return getDeliveryPageText().contains("48 working hours");
    }

    public Boolean getShipingRate(){
        return getDeliveryPageText().contains("$18 per order");
    }

    public Boolean getMaximumDeliveryPeriod(){
        return getDeliveryPageText().contains("maximum 20 working days");
    }

    public Boolean PaymentDetails(){
        return getDeliveryPageText().contains("MasterCard and VISA");
    }

    public Boolean getMaximumStatusCheck(){
        return getDeliveryPageText().contains("36 hours");
    }

    public Boolean getRefunds(){
        return getDeliveryPageText().contains("10 working days");
    }

    public Boolean getRefundsInCaseOfCancellation(){
        return getDeliveryPageText().contains("within 3 working days");
    }

    public Boolean getMaxPeriodOfRefundsInCaseOfCancellation(){
        return getDeliveryPageText().contains("within 10 working days.");
    }


    //CSS
    public Boolean getDeliveryPageFontsize(){
        waitCSSSelector(DELIVERY_PAGE_CONTENT);
        return driver.findElement(By.cssSelector(DELIVERY_PAGE_CONTENT)).getCssValue("font-size").contains("14px");
    }
}

