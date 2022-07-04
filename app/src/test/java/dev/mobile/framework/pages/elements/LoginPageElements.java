package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPageElements extends BasePage {

    @AndroidFindBy(xpath= "//android.widget.EditText[@content-desc='input-email']")
    protected WebElement emailField;

    @AndroidFindBy(xpath= "//android.widget.EditText[@content-desc='input-password']")
    protected WebElement passwordField;

    @AndroidFindBy(xpath= "//android.widget.TextView[@text='LOGIN']")
    protected WebElement loginButton;

}
