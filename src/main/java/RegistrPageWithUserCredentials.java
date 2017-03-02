import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

/**
 * Created by alex on 07.02.2017.
 */
public class RegistrPageWithUserCredentials extends PageObject {


    public RegistrPageWithUserCredentials(WebDriver driver) {
        super(driver);
    }


    //CSS LOCATORS
    private String siteURL = "http://weddingclothesnow.com";

    private String FIRSTNAME = "#input-firstname";
    private String LASTNAME = "#input-lastname";
    private String EMAIL = "#input-email";
    private String PHONE = "#input-telephone";
    private String ADDRESS = "#input-address-1";
    private String CITY = "#input-city";
    private String POSTCODE = "#input-postcode";
    private String COUNTRY = "#input-country:first-child option[value=\"223\"]";
    private String STATE = "#input-zone:first-child";
    private String PASSWORD = "#input-password";
    private String PASSCONFIRM = "#input-confirm";
    private String RADIOBUTTON = ".agree+input";
    private String CONTINUEBUTTON = ".btn.btn-primary";

    //click on method
    public void enterCountry() {
        clickOn(this.COUNTRY);
    }


    public void verifyCredentials(String FirstName, String LastName, String EMail, String Telephone, String Address, String City, String Psstcode, String State, String Password) {
        driver.findElement(By.cssSelector(FIRSTNAME)).sendKeys(FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(LastName);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(EMail);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(Telephone);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(City);
        driver.findElement(By.cssSelector(POSTCODE)).sendKeys(Psstcode);
        driver.findElement(By.cssSelector(STATE)).sendKeys(State);
        driver.findElement(By.cssSelector(PASSWORD)).sendKeys(Password);
        driver.findElement(By.cssSelector(PASSCONFIRM)).sendKeys(Password);
        driver.findElement(By.cssSelector(RADIOBUTTON)).click();
        driver.findElement(By.cssSelector(CONTINUEBUTTON)).click();
    }
}


class UserCredentialsProvider {
    //credentials for registration page
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

    public String SiteURL = "http://kidsclotheslab.com/";
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


