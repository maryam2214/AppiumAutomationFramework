package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WebViewElements<MobileElement> extends BasePage {
    @AndroidFindBy(xpath = "//android.widget.Button[@text='Search']")
    protected WebElement searchButton;

    @AndroidFindBy(xpath ="//android.widget.Image[@text='Algolia']")
    protected WebElement algoliaSearchLink;
}