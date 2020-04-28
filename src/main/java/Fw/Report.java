package Fw;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    public static WebDriver driver;
    private static final String PATH_REPORT = System.getProperty("user.dir") + File.separator + "Report";
    public static ExtentHtmlReporter htmlReport;
    public static ExtentReports extent;
    public static ExtentTest test;


    public static void setExtent() {
        CreateFolder.createReportFolder(PATH_REPORT);
        htmlReport = new ExtentHtmlReporter(PATH_REPORT + File.separator + "myReport.html");

        htmlReport.config().setDocumentTitle("Automation Report");
        htmlReport.config().setReportName("Execution Test Report");

        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setEncoding("UTF-8");

        extent = new ExtentReports();

        extent.attachReporter(htmlReport);

    }


    public static void endReport() {
        extent.flush();

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
