package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;

/**
 * Created by alex on 21.02.2017.
 */
public class PayPage extends BasePage {

    public PayPage(WebDriver driver) {
        super(driver);
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
    private String SUBMIT_TRANSACTIONBUTTON = "#formsubmit";


    public void enterClientCredentialsPaypage(String FirstName, String LastName, String Address, String City, String PostalCode, String Country, String Phone, String Email, String IssuingBank, String CardNumber, String ExpirationMonth, String ExpirationYear, String CVV2) {
        waiter(FIRSTNAME);
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
    }

    public String currentFirstNameInput() {
        Select select = new Select(driver.findElement(By.cssSelector(FIRSTNAME)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentLastNameInput() {
        Select select = new Select(driver.findElement(By.cssSelector(LASTNAME)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentAddressInput() {
        Select select = new Select(driver.findElement(By.cssSelector(ADDRESS)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentCityInput() {
        Select select = new Select(driver.findElement(By.cssSelector(CITY)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPostalCodeInput() {
        Select select = new Select(driver.findElement(By.cssSelector(ZIP)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentCountryInput() {
        Select select = new Select(driver.findElement(By.cssSelector(COUNTRY)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentPhoneInput() {
        Select select = new Select(driver.findElement(By.cssSelector(PHONE)));
        return select.getFirstSelectedOption().getText();
    }

    public String curreneMailInput() {
        Select select = new Select(driver.findElement(By.cssSelector(EMAIL)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentIssuingBankInput() {
        Select select = new Select(driver.findElement(By.cssSelector(ISSUINGBANK)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentCardNumberInput() {
        Select select = new Select(driver.findElement(By.cssSelector(CARDNUMBER)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentExpirationMonthInput() {
        Select select = new Select(driver.findElement(By.cssSelector(EXPIRATIONMONTH)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentExpirationYearInput() {
        Select select = new Select(driver.findElement(By.cssSelector(EXPIRATIONYEAR)));
        return select.getFirstSelectedOption().getText();
    }

    public String currentCVVInput() {
        Select select = new Select(driver.findElement(By.cssSelector(CVV)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void clickOnSubmitTransactionButton() {
        clickOn(SUBMIT_TRANSACTIONBUTTON);

    }
}



