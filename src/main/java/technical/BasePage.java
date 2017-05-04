package technical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


/**
 * Created by alex on 07.02.2017.
 */
public class BasePage {

    //INPUT THE SITE NAME TO CHECK HERE:
    public static String SiteURL = "http://" + "giftsshopstar.com";
//-------------------------------------------------------------
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitCSSSelector(String SomeLocatorByCSSSelector) {
        WebDriverWait waitForOne = new WebDriverWait(driver, 30);
        return waitForOne.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SomeLocatorByCSSSelector)));
    }

    public void waitByLinkText(String ByLinkText) {
        WebDriverWait waitForOne = new WebDriverWait(driver, 25);
        waitForOne.until(ExpectedConditions.elementToBeClickable(By.linkText(ByLinkText)));
    }


    public void clickOnСSSSelector(String CSSSelector) {
        driver.findElement(By.cssSelector(CSSSelector)).click();
    }

    public void hoverAndClick(WebDriver driver, WebElement clickElement) {
        Actions action = new Actions(driver);
        action.moveToElement(clickElement).build().perform();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickElement.click();
    }

    public WebElement findProductByText(String name) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4>a"));
        for (WebElement product : products) {
            if (product.getText().contains(name)) {
                return product;
            }
        }
        return null;
    }

    public WebElement findPriceByProductName(String name) {
        return findProductByText(name).findElement(By.xpath("../../p[2]"));
    }
}



