package dev.mobile.framework.pages;


import static java.lang.Thread.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import dev.mobile.framework.support.config.ConfigReader;
import dev.mobile.framework.support.config.helper.DeviceController;

public class BasePage {
    private final ConfigReader      configReader;
    private WebDriverWait           wait;
    protected WebDriver             driver;

    //Constructor
    public BasePage() { configReader = new ConfigReader();
    }

    public void setDriver(WebDriver webDriver) {
        driver = webDriver;
        wait   = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    public WebDriver getDriver() {
        return driver;
    }

    public ConfigReader configReader() {
        return configReader;
    }


    //Click Method
    public void click(WebElement element) {
        waitVisibility(element).click();
    }

    //Write Text
    public void writeText(WebElement element, String text) {
        waitVisibility(element).sendKeys(text);
    }

    //Read Text
    public String readText(WebElement element) {
        return waitVisibility(element).getText();
    }

    //Wait
    public WebElement waitVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitVisibility(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    // Get Text from alert
    public String readAlertText() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    // Accept alert
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    // Dismiss alert
    public void dismissAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

    public void switchToTab(String title) {
        Set<String> currentHandles = driver.getWindowHandles();
        Set<String> newHandles = driver.getWindowHandles();

        for(String actual: newHandles) {
            if (!currentHandles.contains(actual)) {
                //Switch to the opened tab
                if (!driver.getTitle().contains(title)) {
                    driver.close();
                }
                driver.switchTo().window(actual);
                break;
            }
        }
    }

    public void clear(WebElement element) {
        element.clear();
    }
}