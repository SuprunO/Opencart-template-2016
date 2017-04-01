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
        if (driver.findElement(By.cssSelector("html>body>pre")).getText().contains("User-agent:")) {
            return Boolean.TRUE;

        } else
            return Boolean.FALSE;
    }
}
