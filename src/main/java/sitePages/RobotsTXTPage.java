package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 27.03.2017.
 */
public class RobotsTXTPage extends BasePage {

    public RobotsTXTPage(WebDriver driver) {
        super(driver);
    }
    public Boolean get_Notfound() {
        return driver.findElement(By.cssSelector("h1")).getText().contains("Not Found");
    }
}
