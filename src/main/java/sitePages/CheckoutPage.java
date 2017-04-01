package sitePages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import ru.yandex.qatools.allure.annotations.Step;
import technical.BasePage;
import technical.User;

/**
 * Created by alex on 21.02.2017.
 */
public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators

    //STEP#2
    private String FIRSTNAME = "#input-payment-firstname";
    private String LASTNAME = "#input-payment-lastname";
    private String EMAIL = "#input-payment-email";
    private String PHONE = "#input-payment-telephone";
    private String ADDRESS = "#input-payment-address-1";
    private String CITY = "#input-payment-city";
    private String POSTCODE = "#input-payment-postcode";
    private String COUNTRY = "#input-payment-country";
    private String STATE = "#input-payment-zone";
    private String PASSWORD = "#input-payment-password";
    private String PASSCONFIRM = "#input-payment-confirm";
    private String RADIOBUTTON = ".agree+input";

    @Step
    public void inputCredentials(User user) {

        waiter(FIRSTNAME);
        driver.findElement(By.cssSelector(FIRSTNAME)).sendKeys(user.FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(user.Lastname);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(user.EMail);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(user.Telephone);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(user.Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(user.City);
        driver.findElement(By.cssSelector(POSTCODE)).sendKeys(user.PostCode);
        driver.findElement(By.cssSelector(PASSWORD)).sendKeys(user.Password);
        driver.findElement(By.cssSelector(PASSCONFIRM)).sendKeys(user.Password);
    }
    @Step
    public void chooseCountry() {
        Select select = new Select(driver.findElement(By.cssSelector(COUNTRY)));
        select.selectByIndex(239);
    }

    public String currentCountrySelected() {
        Select select = new Select(driver.findElement(By.cssSelector(COUNTRY)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void chooseState() {
        Select select = new Select(driver.findElement(By.cssSelector(STATE)));
        select.selectByIndex(5);
    }

    public String currentStateSelected() {
        Select select = new Select(driver.findElement(By.cssSelector(STATE)));
        return select.getFirstSelectedOption().getText();
    }

    @Step
    public void clickPrivacyPolicyRadioButton() {
        clickOn(RADIOBUTTON);
    }

    // CHECKOUT STEPS
    private String NEW_CUSTOMER_CONTINUE_BUTTON = "#button-account";
    private String BILLING_CONTINUE_BUTTON = "#button-register";
    private String DELIVERY_DETAILS_CONTINUE_BUTTON = "#button-shipping-address";
    private String DELIVERY_METHOD_CONTINUE_BUTTON = "#button-shipping-method";
    private String PAYMENT_METHOD_CONTINUE_BUTTON = "#button-payment-method";
    private String CONFIRM_ORDER_BUTTON = "#cardgate-confirm";


    @Step
    public void clickOn_Step1_AccountContinueButton() {
        waiter(NEW_CUSTOMER_CONTINUE_BUTTON);
        clickOn(NEW_CUSTOMER_CONTINUE_BUTTON);
    }

    @Step
    public void clickOn_Step2_BillingContinueButton() {
        clickOn(this.BILLING_CONTINUE_BUTTON);
    }

    @Step
    public void clickOn_Step3_DeliveryDetailsContinueButton() {
        waiter(DELIVERY_DETAILS_CONTINUE_BUTTON);
        clickOn(this.DELIVERY_DETAILS_CONTINUE_BUTTON);
    }

    @Step
    public void clickOn_Step4_DeliveryMethodContinueButton() {
        waiter(DELIVERY_METHOD_CONTINUE_BUTTON);
        clickOn(this.DELIVERY_METHOD_CONTINUE_BUTTON);
    }

    @Step
    public void clickOn_Step5_PaymentMethodContinueButton() {
        waiter(PAYMENT_METHOD_CONTINUE_BUTTON);
        clickOn(this.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    @Step
    public void clickOn_Step6_ConfirmOrderButton() {
        waiter(CONFIRM_ORDER_BUTTON);
        clickOn(this.CONFIRM_ORDER_BUTTON);
    }
}