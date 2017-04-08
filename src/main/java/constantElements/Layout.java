package constantElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;

/**
 * Created by alex on 07.04.2017.
 */
public class Layout extends BasePage {

    public Layout (WebDriver driver) {
        super(driver);
    }

    private WebElement cartIcon = driver.findElement(By.cssSelector("#cart"));

    @Step
    public CartPopUp hoverandClickCartIcon() {
        hoverAndClick(driver, cartIcon);
        return new CartPopUp(driver);
    }


}
