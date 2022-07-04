package dev.mobile.framework.util.listeners;

import static dev.mobile.framework.util.extentreports.ExtentTestManager.getTest;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.util.Objects;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import dev.mobile.framework.tests.BaseTest;
import dev.mobile.framework.util.extentreports.ExtentManager;

public class TestListener extends BaseTest implements ITestListener {

    Logger log = LoggerFactory.getLogger(TestListener.class);

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", driver);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log.info("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for ExtentReports reporting!
        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is starting.");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is succeed.");
        //ExtentReports log operation for passed tests.
        getTest().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is failed.");

        //Get driver from BaseTest and assign to local webserver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        if (driver != null) {
            //Take base64Screenshot screenshot for extent reports
            String base64Screenshot =
                    "data:image/png;base64," + ((TakesScreenshot) Objects.requireNonNull(driver)).getScreenshotAs(OutputType.BASE64);

            //ExtentReports log and screenshot operations for failed tests.
            ExtentTest test = getTest();
            test.log(Status.FAIL, "Test Failed", test.addScreenCaptureFromBase64String(base64Screenshot).getModel().getMedia().get(0));
        }
        else {
           log.error("Driver from test class is null");
        }

        ExtentManager.extentReports.flush();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log.info(getTestMethodName(iTestResult) + " test is skipped.");
        //ExtentReports log operation for skipped tests.
        getTest().log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}
