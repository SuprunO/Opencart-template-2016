package UIPageTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sitePages.HomePage;
import sitePages.RobotsTXTPage;

import static technical.BasePage.SiteURL;

/**
 * Created by alexei on 27.04.17.
 */
public class UIHomePage {

    WebDriver driver;
    HomePage homePage;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.gecko.driver", "//home//alexei//geckodriver");
        driver = new FirefoxDriver();
        driver.get(SiteURL);
        homePage = new HomePage(driver);

    }

    @Test
    public void verifyHomeLinkText(){
        Assert.assertEquals(homePage.getLayout().getHomeLinkText().getText(),"Home","Fix Home link text to Home");
    }

    @Test
    public void verifyContactUsText(){
        Assert.assertEquals(homePage.getLayout().getContactUsLinkText().getText(),"Contact Us","Fix Contact US link text to Home");
    }

    @Test
    public void verifyLoginText(){
        Assert.assertEquals(homePage.getLayout().getLoginLinkText().getText(),"Login","Fix Login link text to Login");
    }

    @Test
    public void verifyCartLinkText(){
        Assert.assertEquals(homePage.getLayout().getCartLinkText().getText().trim(),"0 item(s) - $0","Fix Login link text to 0 item(s) - $0");
    }

    @Test
    public void verifyFirstCategoryText(){
        Assert.assertEquals(homePage.getLayout().getFirstCategoryText().getText(),"Wedding Dresses","Fix first category link text to Wedding Dresses");
    }

    @Test
    public void verifySecondCategoryText(){
        Assert.assertEquals(homePage.getLayout().getSecondCategoryText().getText(),"Mother of the Bride","Fix second category link text to Mother of the Bride");
    }

    @Test
    public void verifyThirdCategoryText(){
        Assert.assertEquals(homePage.getLayout().getThirdCategoryText().getText(),"Bridesmaid Dresses","Fix third category link text to Bridesmaid Dresses");
    }

    @Test
    public void verifyFeaturedProductsHeaderText(){
        Assert.assertEquals(homePage.getLayout().getFeaturedProductsHeaderText().getText(),"Featured Products","Fix header Featured Products to Featured Products");
    }

    @Test
    public void verifyInformationHeaderTextFooter(){
        Assert.assertEquals(homePage.getLayout().getInformationHeaderText().getText(),"INFORMATION","The Information header is written wrong, fix to Information");
    }

    @Test
    public void verifyMyAccountHeaderTextFooter(){
        Assert.assertEquals(homePage.getLayout().getMyAccountHeaderText().getText(),"My Account","The My Account header is written wrong, fix to My Account");
    }

    @Test
    public void verifyOurOffersHeaderTextFooter(){
        Assert.assertEquals(homePage.getLayout().getOurOffersHeaderText().getText(),"OUR OFFERS","The Our Offers header is written wrong, fix to Our Offers");
    }

    @Test
    public void verifyCompanyInfoHeaderTextFooter(){
        Assert.assertEquals(homePage.getLayout().getCompanyInfoHeaderText().getText(),"COMPANY INFO","The Company Info header is written wrong, fix to Company Info");
    }

    @Test
    public void verifyContactUsHeaderTextFooter(){
        Assert.assertEquals(homePage.getLayout().getContactUsHeaderTextFooter().getText(),"Contact Us","The Contact Us header is written wrong, fix to Contact Us");
    }

    @Test
    public void verifyDeliveryLinkTextFooter(){
        Assert.assertEquals(homePage.getLayout().getDeliveryTextFooter().getText(),"Delivery Information","The Delivery header is written wrong, fix to Delivery");
    }

    @Test
    public void verifyPrivacyPolicyLinkTextFooter(){
        Assert.assertEquals(homePage.getLayout().getPrivacyPolicyTextFooter().getText(),"Privacy Policy","The Privacy Policy header is written wrong, fix to Privacy Policy");
    }


    @Test

    public void verifyTermsConditionsLinkTextFooter(){
        Assert.assertEquals(homePage.getLayout().getTermsConditionsTextFooter().getText(),"Terms & Conditions","Terms & Conditions header is written wrong, fix to Terms & Conditions");
    }

    @Test

    public void verifyMyAccountLinkText(){
        Assert.assertEquals(homePage.getLayout().getMyAccountTextFooter().getText(),"My Account","My Account link is written wrong, fix to My Account");
    }

    @Test

    public void verifyOrderHistoryLinkText(){
        Assert.assertEquals(homePage.getLayout().getOrderHistoryTextFooter().getText(),"Order History","Order History is written wrong, fix to Order History");
    }

    @Test

    public void verifyTermsSpecialsLinkTextFooter(){
        Assert.assertEquals(homePage.getLayout().getSpecialsLinkText().getText(),"Specials","Specials is written wrong, fix to Specials");
    }


    @AfterClass
    public void cleanUp() {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            System.out.println("some errors occured during closing driver: \n" + e);
        }
    }


}
