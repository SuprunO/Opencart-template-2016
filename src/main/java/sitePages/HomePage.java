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

    public WebElement get_link_Cart(){
        return driver.findElement(By.cssSelector(CART_LINK));
    }


    //CART popup
    public WebElement getPopUpCheckoutLink(){
     return driver.findElement(By.cssSelector(CHECKOUT_LINK));
    }


    //CART popup
    private String CART_LINK=".btn.btn-inverse.btn-block.btn-lg.dropdown-toggle";
    private String CHECKOUT_LINK="text-right>a:nth-child(2)";




    //Categories
    private String CATEGORY1=".nav.navbar-nav>li:nth-child(1)>a";
    private String CATEGORY2=".nav.navbar-nav>li:nth-child(2)>a";
    private String CATEGORY3=".nav.navbar-nav>li:nth-child(3)>a";

    //Header Featured Products
    private String FeaturedProducts=".feature_container>h3";


    //FOOTER
    //Headers
    private String INFO = ".col-sm-2:nth-child(1):first-child h4";
    private String EXTRAS = ".col-sm-2:nth-child(2) h4";
    private String MY_ACCOUNT = ".col-sm-2:nth-child(3) h4";
    // TODO: 21.02.2017 Разобраться с локаторами / попросить команду изменить ихменить их
    //private String COMPANY_INFO = "";
    // private String CONTACT_US = "";
}





