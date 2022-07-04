package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PHPTravelsLoginPageElements extends BasePage {

    @FindBy(id = "txt-username")
    protected WebElement emailInput;

    @FindBy(id= "txt-password")
    protected WebElement passwordInput;

    @FindBy(id = "btn-login")
    protected WebElement loginButton;
}
