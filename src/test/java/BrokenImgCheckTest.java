import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by alex on 03.03.2017.
 */
public class BrokenImgCheckTest {
    WebDriver driver = new FirefoxDriver();
    BasePage getBasePageMethods = new BasePage(driver);

    @Title("Broken images HomePage Test")
    @Test
    public void checkBrokenImg_HomePage() {
        driver.get("http://kidsclotheslab.com");
        System.out.println("Checking Home page...");
        getBasePageMethods.verifyImages();



    }

    @Title("Broken images Test_Category1_Page_1")
    @Test
    public void checkBrokenImg_Category1_Page_1() {
        System.out.println("Checking _Category1_Page_1");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=63");
        getBasePageMethods.verifyImages();


    }

    @Test
    public void checkBrokenImg_Category_1_Page_4() {
        System.out.println("Checking _Category1_Page_4");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=63&page=4");
        getBasePageMethods.verifyImages();


    }

    @Test
    public void checkBrokenImg_Category_2_Page_1() {
        System.out.println("Checking _Category2_Page_1");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=62");
        getBasePageMethods.verifyImages();


    }

    @Test
    public void checkBrokenImg_Category_2_Page_3() {
        System.out.println("Checking _Category2_Page_3");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=62page=3");
        getBasePageMethods.verifyImages();


    }

    @Test
    public void checkBrokenImg_Category_2_Page_5() {
        System.out.println("Checking _Category2_Page_5");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=62page=5");
        getBasePageMethods.verifyImages();


    }

    @Test
    public void checkBrokenImg_Category_3_Page_1() {
        System.out.println("Checking _Category3_Page_1");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=64");
        getBasePageMethods.verifyImages();

    }

    @Test
    public void checkBrokenImg_Category_3_Page_3() {
        System.out.println("Checking _Category3_Page_3");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=64page=2");
        getBasePageMethods.verifyImages();

    }

    @Test
    public void checkBrokenImg_Category_3_Page_5() {
        System.out.println("Checking _Category3_Page_5");
        driver.get("http://kidsclotheslab.com/index.php?route=product/category&path=62page=7");
        getBasePageMethods.verifyImages();

    }


    @Test
    public void checkBrokenImg_Product_Category_1_Page1_Product1() {
        System.out.println("Checking _Category1_Page_1_Product1");
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=63&product_id=308");
        getBasePageMethods.verifyImages();

    }

    @Test
    public void checkBrokenImg_Product_Category_1_Page1_Product6() {
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=63&product_id=311");
        getBasePageMethods.verifyImages();

    }

    @Test
    public void checkBrokenImg_Product_Category_1_Page1_Product8() {
        driver.get("http://kidsclotheslab.com/index.php?route=product/product&path=63&product_id=281");
        getBasePageMethods.verifyImages();

    }

}

