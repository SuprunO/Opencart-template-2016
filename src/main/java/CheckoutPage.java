import org.openqa.selenium.WebDriver;

/**
 * Created by alex on 21.02.2017.
 */
public class CheckoutPage extends PageObject {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //Locators
    private String BILLING_CONTINUE_BUTTON = "#button-payment-address";
    private String DELIVERY_DETAILS_CONTINUE_BUTTON = "#button-shipping-address";
    private String DELIVERY_METHOD_CONTINUE_BUTTON = "#button-shipping-method";
    private String PAYMENT_METHOD_CONTINUE_BUTTON = "##button-payment-method";
    private String CONFIRM_ORDER_BUTTON = "#cardgate-confirm";

    public void pushBillingContinueButton(){
        clickOn(this.BILLING_CONTINUE_BUTTON);
    }

    public void pushDeliveryDetailsContinueButton(){
        clickOn(this.DELIVERY_DETAILS_CONTINUE_BUTTON);
    }

    public void pushDeliveryMethodContinueButton(){
        clickOn(this.DELIVERY_METHOD_CONTINUE_BUTTON);
    }

    public void pushPaymentMethodContinueButton(){
        clickOn(this.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    public void pushConfirmOrderButton(){
        clickOn(this.CONFIRM_ORDER_BUTTON);
    }







}