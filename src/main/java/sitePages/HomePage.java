package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import technical.BasePage;

/**
 * Created by alex on 04.02.2017.
 */
public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Header
    public WebElement get_lnk_Login() {
        return driver.findElement(By.linkText("Login"));
    }

    public WebElement get_lnk_Home() {
        return driver.findElement(By.linkText("Home"));
    }

    public WebElement get_lnk_ContactUs() {
        return driver.findElement(By.linkText("Contact Us"));
    }


    private String PRODUCTLOCATOR = "#col-sm-39>a";

    public void clickOnFirstProduct(){
        waitCSSSelector(PRODUCTLOCATOR).click();

    }

    //Add categories


    //Add products

}





