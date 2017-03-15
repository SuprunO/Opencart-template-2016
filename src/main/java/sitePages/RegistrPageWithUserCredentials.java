package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import technical.BasePage;

/**
 * Created by alex on 07.02.2017.
 */
public class RegistrPageWithUserCredentials extends BasePage {


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





