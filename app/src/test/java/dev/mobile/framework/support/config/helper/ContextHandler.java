package dev.mobile.framework.support.config.helper;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.android.AndroidDriver;

public class ContextHandler {

    protected AndroidDriver driver;

    public ContextHandler(WebDriver webDriver) {
        driver = ((AndroidDriver) webDriver);
    }

}
