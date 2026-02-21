package utilities;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * Captures screenshot on test failure
 */

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, 
                                           String testName) {

        String path = System.getProperty("user.dir")
                + "/screenshots/" + testName + ".png";

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(src, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
