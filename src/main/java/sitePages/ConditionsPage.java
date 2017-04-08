package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 09.03.2017.
 */
public class ConditionsPage extends BasePage {
    public ConditionsPage(WebDriver driver) {
        super(driver);
    }

    private String CONDITIONS_PAGE_CONTENT = "#content";

    private String getConditionsPageText() {
        waitCSSSelector(CONDITIONS_PAGE_CONTENT);
        return driver.findElement(By.cssSelector(CONDITIONS_PAGE_CONTENT)).getText();
    }

    public Boolean conditionsPageIsNotEmpty() {
        return getConditionsPageText().isEmpty();
    }

    //CSS
    public Boolean getConditionsPageFontsize() {
        waitCSSSelector(CONDITIONS_PAGE_CONTENT);
        return driver.findElement(By.cssSelector(CONDITIONS_PAGE_CONTENT)).getCssValue("font-size").contains("14px");
    }
}
