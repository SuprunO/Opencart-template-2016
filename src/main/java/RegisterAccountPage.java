import com.sun.prism.shader.Solid_TextureRGB_AlphaTest_Loader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alex on 07.02.2017.
 */
public class RegisterAccountPage {
    WebDriver driver = new FirefoxDriver();
    WebDriverWait wait = new WebDriverWait(driver, 35);


    //CSS LOCATORS
    private String FIRSTNAME = "#input-firstname";
    private String LASTNAME = "#input-lastname";
    private String EMAIL = "#input-email";
    private String PHONE = "#input-telephone";
    private String ADDRESS = "#input-address-1";
    private String CITY = "#input-city";
    private String COUNTRY = "#input-country";
    private String STATE = "#input-zone";
    private String PASSWORD = "#input-password";
    private String PASSCONFIRM = "#input-confirm";
    private String RADIOBUTTON = ".agree+input";
    private String CONTINUEBUTTON = ".btn.btn-primary";


    public void clientsCredentials(String FirstName, String LastName, String EMail, String Telephone, String Address, String City, String Country, String State, String Password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(FIRSTNAME)));
        driver.findElement(By.cssSelector(FIRSTNAME)).sendKeys(FirstName);
        driver.findElement(By.cssSelector(LASTNAME)).sendKeys(LastName);
        driver.findElement(By.cssSelector(EMAIL)).sendKeys(EMail);
        driver.findElement(By.cssSelector(PHONE)).sendKeys(Telephone);
        driver.findElement(By.cssSelector(ADDRESS)).sendKeys(Address);
        driver.findElement(By.cssSelector(CITY)).sendKeys(City);
        driver.findElement(By.cssSelector(COUNTRY)).sendKeys(Country);
        driver.findElement(By.cssSelector(STATE)).sendKeys(State);
        driver.findElement(By.cssSelector(PASSWORD)).sendKeys(Password);
        driver.findElement(By.cssSelector(PASSCONFIRM)).sendKeys(Password);
        driver.findElement(By.cssSelector(RADIOBUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CONTINUEBUTTON)));
        driver.findElement(By.cssSelector(CONTINUEBUTTON)).click();
        driver.findElement(By.cssSelector(CONTINUEBUTTON)).click();
    }
}
