package dev.mobile.framework.pages.actions;

import static org.testng.AssertJUnit.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import dev.mobile.framework.pages.elements.MobileBrowserElements;
import io.appium.java_client.android.AndroidDriver;

public class MobileBrowserActions extends MobileBrowserElements {

    AndroidDriver androidDriver;
    public MobileBrowserActions(WebDriver webdriver) {
       setDriver(webdriver);
       androidDriver = ((AndroidDriver)driver);
    }

    public MobileBrowserActions switchTowebContext() throws InterruptedException {
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.equals("WEBVIEW_com.wdiodemoapp"))
            {
                Thread.sleep(5000);
                androidDriver.context("WEBVIEW_com.wdiodemoapp");
                System.out.println(androidDriver.getCurrentUrl());
                Thread.sleep(5000);
            }
        }
        return this;
    }
    public  MobileBrowserActions navigateToWebPage(String url) {
        androidDriver.get(url);
        return this;
    }

    public MobileBrowserActions enterEmail(String email)  {
       androidDriver.findElement(By.id("txt-username")).sendKeys(email);
       // writeText(emailInput, email);
        return this;
    }

    public MobileBrowserActions enterPassword(String password) {
        androidDriver.findElement(By.id("txt-password")).sendKeys(password);
        //writeText(passwordInput, password);
        return this;
    }

    public MobileBrowserActions clickLogin() {
        androidDriver.findElement(By.id("btn-login")).click();
      //  click(loginButton);
        return this;
    }

    public MobileBrowserActions verifyLogin(String url)  {
        assertEquals(androidDriver.getCurrentUrl(), url);
        return this;
    }

    public MobileBrowserActions switchToNativeContext() throws InterruptedException {
        Set<String> contextNames = androidDriver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.equals("NATIVE_APP"))
            {
                Thread.sleep(5000);
                androidDriver.context("NATIVE_APP");
                Thread.sleep(5000);
            }
        }
        return this;
    }

}
