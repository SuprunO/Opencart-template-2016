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
public class BrokenImgCheckTest {
    WebDriver driver = new FirefoxDriver();
    BasePage verifyActive = new BasePage(driver);

    @Test
    public void VerifyImages() {
        WebDriver driver = new FirefoxDriver();
        UserCredentialsProvider userData = new UserCredentialsProvider();
        driver.manage().window().maximize();
        driver.get(userData.SiteURL);
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total links are " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement ele = images.get(i);
            String url = ele.getAttribute("src");
            verifyActive.verifyActive(url);
        }
    }
}

