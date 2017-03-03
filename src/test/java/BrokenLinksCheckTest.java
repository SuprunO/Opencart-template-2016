import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by alex on 03.03.2017.
 */
public class BrokenLinksCheckTest {

    WebDriver driver = new FirefoxDriver();
    BasePage verifyActive = new BasePage(driver);

    @Test
    public void VerLink() {
        WebDriver driver = new FirefoxDriver();
        UserCredentialsProvider userData = new UserCredentialsProvider();
        driver.manage().window().maximize();
        driver.get(userData.SiteURL);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + links.size());

        for (int i = 0; i < links.size(); i++) {
            WebElement ele = links.get(i);
            String url = ele.getAttribute("href");
            verifyActive.verifyActive(url);
        }
    }
}


