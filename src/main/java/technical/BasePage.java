package technical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


/**
 * Created by alex on 07.02.2017.
 */
public class BasePage {

    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waiter(String SomeLocatorByCSSSelector){
        WebDriverWait waitForOne = new WebDriverWait(driver, 30);
        waitForOne.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SomeLocatorByCSSSelector)));
    }

    public void waiterByLinkText(String ByLinkText){
        WebDriverWait waitForOne = new WebDriverWait(driver, 25);
        waitForOne.until(ExpectedConditions.elementToBeClickable(By.linkText(ByLinkText)));
    }


    public void clickOn(String CSSSelector) {
        driver.findElement(By.cssSelector(CSSSelector)).click();
    }


    public void verifyImages() {
        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total links are " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement ele = images.get(i);
            String url = ele.getAttribute("src");
            verifyActive(url);
        }
    }

    public void verifyLinks() {
        List<WebElement> images = driver.findElements(By.tagName("a"));
        System.out.println("Total links are " + images.size());

        for (int i = 0; i < images.size(); i++) {
            WebElement ele = images.get(i);
            String url = ele.getAttribute("href");
            verifyActive(url);
        }
    }

    public void verifyActive(String linkUrl) {
        try {
            URL img = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) img.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();

            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {}
    }


}

