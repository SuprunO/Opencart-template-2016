package sitePages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

import static technical.BasePage.SiteURL;

/**
 * Created by alex on 31.03.2017.
 */

@Title("Robot.txt page tests")
public class RobotPageTest {
    RobotsTXTPage robotsTXTPage;

    ChromeDriver  driver;

    @BeforeClass
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver/chromedriver.exe");
        // System.setProperty("webdriver.gecko.driver", "C://gecko/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get(SiteURL + "/robots.txt");
        robotsTXTPage = new RobotsTXTPage(driver);
    }
    @Title("Check the robot.txt file exists")
    @Description("Check the robot.txt file exists")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testGet_Notfound() {
        Assert.assertTrue(robotsTXTPage.get_Notfound(),"Robots.txt file not found, kindly insert it");
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
