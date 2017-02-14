import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by alex on 07.02.2017.
 */
public class RegisterAccountPage {

    //CSS LOCATORS
    private String FIRSTNAME = "#input-firstname";
    private String LASTNAME = "#input-lastname";
    private String EMAIL = "#input-email";
    private String PHONE = "#input-telephone";
    private String ADDRESS = "#input-address-1";
    private String CITY = "#input-city";
    private String COUNTRY = "#input-country:first-child";
    private String STATE = "#input-zone:first-child";
    private String PASSWORD = "#input-password";
    private String PASSCONFIRM = "#input-confirm";
    private String RADIOBUTTON = ".agree+input";
    private String CONTINUEBUTTON = ".btn.btn-primary";


    public void verifyCredentials(String FirstName, String LastName, String EMail, String Telephone, String Address, String City, String Country, String State, String Password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(FIRSTNAME))).sendKeys(FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(LastName);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(EMail);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(Telephone);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(City);
        driver.findElement(By.cssSelector(COUNTRY)).isSelected();
        driver.findElement(By.cssSelector(STATE)).isSelected();
        driver.findElement(By.cssSelector(PASSWORD)).sendKeys(Password);
        driver.findElement(By.cssSelector(PASSCONFIRM)).sendKeys(Password);
        driver.findElement(By.cssSelector(RADIOBUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CONTINUEBUTTON))).click();

    }
}

    class User{
        String FirstName = "Rob";
        String Lastname = "Kawalski";
        String EMail = "rob.kaialski@gmail.com";
        String Telephone = "+(44)567-56-65";
        String Address = "Brookyn st, 45";
        String City = "New york";
        String Country = "United States";
        String State = "Alabama";
        String Password = "156423";
    }
