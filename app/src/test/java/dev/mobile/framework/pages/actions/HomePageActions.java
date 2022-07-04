package dev.mobile.framework.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import dev.mobile.framework.pages.elements.HomePageElements;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePageActions extends HomePageElements {

    public HomePageActions(WebDriver mobileDriver) {
        setDriver(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public LoginPageActions goToLoginPage() {
        click(loginButton);
        return new LoginPageActions(driver);
    }

    public WebViewPageActions goToWebViewPage() {
        click(webViewButton);
        return new WebViewPageActions(driver);
    }

    public SwipePageActions goToSwipePage() {
        click(swipeButton);
        return new SwipePageActions(driver);
    }

    public DragDropPageActions goToDragDropPage() {
        click(dragButton);
        return new DragDropPageActions(driver);
    }
}
