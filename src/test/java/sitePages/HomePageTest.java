package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 06.04.2017.
 */
public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;

    @BeforeTest
    void StartUp() {
        driver = new FirefoxDriver();
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    //UI Side


    @Test
    public void verifySizeDropdownByElementsCount() {
        List<WebElement> sizes = driver.findElements(By.cssSelector("#input-option525>option"));
        for (WebElement size : sizes) {
            System.out.println(size.getText().toString().length());
        }

    }


    @Test
    public void verifyEachElementInSizeDropdownByLenghs() {
        WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();

        String[] expSizes = {"US2", "US4", "US6", "US8", "US10", "US12", "US14", "US16", "US16W", "US1W", "US20W", "US22W", "US24W", "US26W",};
        productPage.waitCSSSelector("#input-option525");
        WebElement colorDropdown = driver.findElement(By.cssSelector("#input-option525"));
        Select select = new Select(colorDropdown);

        List<WebElement> options = select.getOptions();
        int count = 0;
        for (WebElement size : options) {
            for (int i = 0; i < expSizes.length; i++) {
                if (size.getText().trim().equals(expSizes[i])) {
                    count++;
                }
            }
        }
        if (count == expSizes.length) {
            System.out.println("Matched");
        } else {
            System.out.println("Not matched");
        }
    }


//    @Test
//    public void getExpectedColorList() {
//        productPage.colorList();
//    }


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
