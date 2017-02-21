import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex on 21.02.2017.
 */
public class PayPage extends PageObject {

    public PayPage(WebDriver driver) {
        super(driver);
    }

    public PayPage(WebDriverWait driverWait) {
        super(driverWait);
    }

    //CSS LOCATORS
    private String FIRSTNAME = "[name=first_name]";
    private String LASTNAME = "[name=last_name]";
    private String ADDRESS = "[name=address]";
    private String CITY = "[name=city]";
    private String ZIP = "[name=postal_code]";
    private String COUNTRY = ".country_code";
    private String PHONE = "[name=phone_number]";
    private String EMAIL = "[name=email]";
    private String ISSUINGBANK = "[name=cc_issuer]";
    private String CARDNUMBER = "[name=cc_number]";
    private String EXPIRATIONMONTH = ".cc_exp_month";
    private String EXPIRATIONYEAR = "[name=cc_exp_year]";
    private String CVV = "[name=cc_cvv]";
    private String SUBMITTRANSACTIONBUTTON = "#formsubmit";


    public void enterClientCredentialsPaypage(String FirstName, String LastName, String Address, String City, String PostalCode, String Country, String Phone, String Email, String IssuingBank, String CardNumber, String ExpirationMonth, String ExpirationYear, String CVV2) {
        driver.findElement(By.cssSelector(FIRSTNAME)).sendKeys(FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(LastName);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(City);
        driver.findElement(By.cssSelector(ZIP)).sendKeys(PostalCode);
        driver.findElement(By.cssSelector(COUNTRY)).sendKeys(Country);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(Phone);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(Email);
        driver.findElement(By.cssSelector(ISSUINGBANK)).sendKeys(IssuingBank);
        driver.findElement(By.cssSelector(CARDNUMBER)).sendKeys(CardNumber);
        driver.findElement(By.cssSelector(EXPIRATIONMONTH)).sendKeys(ExpirationMonth);
        driver.findElement(By.cssSelector(EXPIRATIONYEAR)).sendKeys(ExpirationYear);
        driver.findElement(By.cssSelector(CVV)).sendKeys(CVV2);
        driver.findElement(By.cssSelector(SUBMITTRANSACTIONBUTTON)).click();
    }
}



