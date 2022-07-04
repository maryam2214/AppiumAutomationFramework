package dev.mobile.framework.tests;

import static dev.mobile.framework.util.extentreports.ExtentTestManager.flushExtent;
import static dev.mobile.framework.util.extentreports.ExtentTestManager.startTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import dev.mobile.framework.pages.actions.HomePageActions;
import dev.mobile.framework.support.config.ConfigReader;
import dev.mobile.framework.support.config.helper.DeviceController;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;



public class BaseTest {
    /**
     * Variables
     */
    Logger log = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected ConfigReader configReader;
    protected DeviceController deviceController;

    protected HomePageActions homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters({ "deviceType", "udid", "platformVersion" })
    public void classLevelSetup(String deviceType, String udid, String platformVersion) {
        log.info("Tests are starting!");
        configReader = new ConfigReader();

        if (deviceType.isEmpty()) {
            deviceType = configReader.getDevice().toLowerCase(Locale.ROOT);
        }

        if (deviceType.equals("android")) {
            File app = new File("Android-NativeDemoApp-0.4.0.apk");

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.UDID, udid);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
            caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
          //  caps.setCapability("chromedriverExecutable", WebDriverManager.chromedriver());;
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("appWaitActivity", "com.wdiodemoapp.MainActivity");

            URL appiumServiceURL = null;
            try {
                //appiumServiceURL = new URL("http://127.0.0.1:4723/");
               appiumServiceURL = new URL("http://127.0.0.1:4723/wd/hub/");
                driver = new AndroidDriver(appiumServiceURL, caps);
            } catch (MalformedURLException e) {
                log.error(e.getLocalizedMessage());
                e.printStackTrace();
            }
        }
        else {
            throw new RuntimeException("Device unsupported");
        }

        deviceController = new DeviceController(driver);

    }

    @BeforeMethod
    public void methodLevelSetup(Method method) {
        homePage = new HomePageActions(driver);
        startTest(method.getName(), method.getAnnotation(Test.class).description());
    }

    @AfterMethod
    public void afterMethod() {
        flushExtent();
    }

    @AfterSuite
    public void afterSuiteMethod() {
        flushExtent();
    }

    @AfterClass
    public void teardown() {
        log.info("Tests are ending!");
        driver.quit();
    }

    public DeviceController deviceController() {return deviceController;}

}

