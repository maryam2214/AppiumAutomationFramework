package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePageElements extends BasePage {

    @FindBy(xpath= "//android.widget.Button[@content-desc='Login']")
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc='Login']")
    protected WebElement loginButton;

    @FindBy(xpath= "//android.widget.Button[@content-desc='Webview']")
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc='Webview']")
    protected WebElement webViewButton;

    @FindBy(xpath= "//android.widget.Button[@content-desc='Swipe']")
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc='Swipe']")
    protected WebElement swipeButton;

    @FindBy(xpath= "//android.widget.Button[@content-desc='Drag']")
    @AndroidFindBy(xpath= "//android.widget.Button[@content-desc='Drag']")
    protected WebElement dragButton;
}
