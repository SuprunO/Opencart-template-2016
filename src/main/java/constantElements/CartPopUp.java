package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import sitePages.CheckoutPage;
import technical.BasePage;

/**
 * Created by alex on 07.04.2017.
 */


public class CartPopUp extends BasePage {

    public CartPopUp(WebDriver driver) {
        super(driver);
    }
    private String CART_CHECKOUT_BUTTON = ".text-right a:nth-child(2)";

    @Step
    public CheckoutPage getCartCheckoutButton() {
        waitCSSSelector(CART_CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }


    public WebElement ProductName(){
        return driver.findElement(By.cssSelector(""));
    }

    public WebElement Color(){
        return driver.findElement(By.cssSelector(""));
    }

    public WebElement Size(){
        return driver.findElement(By.cssSelector(""));
    }

    public WebElement NumberOfItems(){
        return driver.findElement(By.cssSelector(""));
    }

    public WebElement PriceOne(){

        return driver.findElement(By.cssSelector(""));
    }

    public WebElement PriceTwo(){

        return driver.findElement(By.cssSelector(""));
    }

    public WebElement PriceThree(){

        return driver.findElement(By.cssSelector(""));
    }

    public WebElement ViewCartButton(){

        return driver.findElement(By.cssSelector(""));
    }

}
