package dev.mobile.framework.util.extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/extent-report.html");
        reporter.config().setReportName("Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Maryam Sana");
        return extentReports;
    }
}
