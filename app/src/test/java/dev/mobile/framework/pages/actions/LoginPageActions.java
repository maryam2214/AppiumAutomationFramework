package dev.mobile.framework.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.AssertJUnit.assertEquals;

import java.time.Duration;

import dev.mobile.framework.pages.elements.LoginPageElements;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPageActions extends LoginPageElements {
    public LoginPageActions(WebDriver mobileDriver) {
        setDriver(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public LoginPageActions performLogin(String email, String password) {
        writeText(emailField,email);
        writeText(passwordField, password);
        click(loginButton);
        return this;
    }

    public LoginPageActions verifyLogin() {
        assertEquals(readAlertText(), "Success\nYou are logged in!");
        return this;
    }

    public LoginPageActions closeAlert() {
        acceptAlert();
        return this;
    }

}
