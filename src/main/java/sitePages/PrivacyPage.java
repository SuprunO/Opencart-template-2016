package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class PrivacyPage extends BasePage {
    public PrivacyPage(WebDriver driver){
        super(driver);
    }

    private String PRIVACY_PAGE_CONTENT = "#content";

    private String getPrivacyPageText(){
        waiter(PRIVACY_PAGE_CONTENT);
        return driver.findElement(By.cssSelector(PRIVACY_PAGE_CONTENT)).getText();
    }
    public Boolean privacyPageTextIsPresent(){
        return getPrivacyPageText().isEmpty();
    }
}
