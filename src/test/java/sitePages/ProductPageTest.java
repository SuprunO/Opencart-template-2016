package sitePages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 06.04.2017.
 */
public class ProductPageTest {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;

    @BeforeTest
    void StartUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get(SiteURL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
    }

    @Test
    public void verifySizeDropdownByListSize() {
        WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
        Assert.assertNotEquals(product, null, "Product not found!");
        product.click();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement colorDropdown = driver.findElement(By.cssSelector("#input-option525"));
        Select select = new Select(colorDropdown);
        List<WebElement> actualDropdownOptions = select.getOptions();
        //  Assert.assertEquals(actualDropdownOptions.size(), productPage.sizeDropdownExpectedSize());
        for (WebElement color: actualDropdownOptions){
            Assert.assertTrue(productPage.sizeDropdownExpectedOptions().contains(color.getText()),"The dropdown is not equal");
        }
    }



//    @Test
//    public void verifySizeDropdownByEquality() {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        WebElement product = homePage.findProductByText("Scoop Natural Zipper Knee-Length");
//        Assert.assertNotEquals(product, null, "Product not found!");
//        product.click();
//
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        WebElement colorDropdown = driver.findElement(By.cssSelector("#input-option525"));
//        Select select = new Select(colorDropdown);
//        List<WebElement> actualDropdownOptions = select.getOptions();
//        for (WebElement color: actualDropdownOptions){
//           Assert.assertTrue(productPage.sizeDropdownExpectedOptions().contains(color.getText()),"The dropdown is not equal");
//        }
//}
//
//    @AfterClass
//    public void cleanUp() {
//        try {
//            driver.close();
//            driver.quit();
//        } catch (Exception e) {
//            System.out.println("some errors occured during closing driver: \n" + e);
//        }
//    }
}
