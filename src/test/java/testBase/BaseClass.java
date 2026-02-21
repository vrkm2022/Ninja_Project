package testBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.*;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

/*
 * BaseClass:
 * - WebDriver setup
 * - Logger
 * - Extent Report
 * - Screenshot on Failure
 */

public class BaseClass {

    public WebDriver driver;
    public Logger logger;

    public ExtentReports extent;
    public ExtentTest test;

    @BeforeMethod
    public void setup() {

        logger = LogManager.getLogger(this.getClass());

        extent = ExtentManager.getInstance();

        driver = new ChromeDriver();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://tutorialsninja.com/demo/");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.fail("Test Failed: " + result.getThrowable());

            String path = ScreenshotUtil.captureScreenshot(
                    driver, result.getName());

            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        }

        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped");
        }

        driver.quit();
        extent.flush();   // Write report
    }
}
