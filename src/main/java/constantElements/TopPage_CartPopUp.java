package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import sitePages.CartPage;
import technical.BasePage;

/**
 * Created by alex on 31.03.2017.
 */
public class TopPage_CartPopUp extends BasePage {

    public TopPage_CartPopUp(WebDriver driver) {
        super(driver);
    }


    private String CART_ICON = "#cart";


    @Step
    public CartPage clickCartIcon() {
        waiter(CART_ICON);
        driver.findElement(By.cssSelector(CART_ICON)).click();
        return new CartPage(driver);
    }

//    private WebElement CART_ICON = driver.findElement(By.cssSelector("#cart"));
//    @Step
//    public void hoverandClickCartIcon() {
//        hoverAndClick(driver,CART_ICON, CART_ICON);
//    }
}
