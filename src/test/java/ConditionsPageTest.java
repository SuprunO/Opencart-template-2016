import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sitePages.ConditionsPage;
import technical.User;

/**
 * Created by alex on 23.03.2017.
 */
public class ConditionsPageTest {

    WebDriver driver;
    ConditionsPage conditionsPage;
    User user;

    @BeforeClass
    public void startUp() {
        driver = new FirefoxDriver();
        user = new User();
        driver.get(user.SiteURL + "/index.php?route=information/information&information_id=5");
        conditionsPage = new ConditionsPage(driver);
    }

    @Test
    public void ConditionsTestIsPresent(){
        Assert.assertFalse(conditionsPage.conditionsPageIsNotEmpty(),"Conditions test is missing");
    }

    @Test
    public void checkConditionsFontsize(){
        Assert.assertEquals(conditionsPage.getConditionsPageFontsize(),Boolean.TRUE,"ConditionsPageFontsize is not 14px, kindly fix");
    }

}
