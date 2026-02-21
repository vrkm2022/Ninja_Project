package utilities;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/*
 * This class creates Extent Report instance
 * Singleton Pattern used (Only one report instance)
 */

public class ExtentManager {

    // Static object of ExtentReports (Singleton)
    private static ExtentReports extent;

    @BeforeSuite
    public static ExtentReports getInstance() {

        // Check if extent instance is null (Create only once)
        if (extent == null) {

            // Report file path
            String path = System.getProperty("user.dir") 
                    + "/reports/ExtentReport.html";

            // Create Spark Reporter
            ExtentSparkReporter spark = new ExtentSparkReporter(path);

            // ------------------ REPORT CONFIGURATION ------------------

            // Set Report Name (Shown at top of report)
            spark.config().setReportName("TutorialsNinja Automation Report");

            // Set Browser Tab Title
            spark.config().setDocumentTitle("Hybrid Framework Report");

            // ⭐ Set DARK THEME
            spark.config().setTheme(Theme.DARK);

            // -----------------------------------------------------------

            // Create ExtentReports object
            extent = new ExtentReports();

            // Attach reporter to ExtentReports
            extent.attachReporter(spark);

            // Add System Information
            extent.setSystemInfo("Tester", "Vivek Kumar");
            extent.setSystemInfo("Team Name", "Alpha Charli");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Browser", "Chrome");
        }

        // Return same instance every time
        return extent;
    }
}
