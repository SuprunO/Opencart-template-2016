package technical;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Random;


/**
 * Created by alex on 07.02.2017.
 */
public class BasePage {

    public WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waiter(String SomeLocatorByCSSSelector){
        WebDriverWait waitForOne = new WebDriverWait(driver, 25);
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

public class UserCredentialsProvider {

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    public String SiteURL = "http://kidsclothesmart.com";
    public String FirstName = "Rob";
    public String Lastname = "Kawalski";
    public String EMail =   getSaltString()+"@gmail.com";
    public String Telephone = "+(44)567-56-65";
    public String Address = "Brookyn st, 45";
    public String City = "New york";
    public String PostCode = "03125";
    public String Password = "156423";

    //Credentials for paypage
    public String Country = "United States";
    public String IssuingBank = "CityBank";
    public String CardNumber = "4444333322221111";
    public String ExpirationMonth = "02";
    public String ExpirationYear = "2020";
    public String CVV2 = "987";
}

