package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;

import java.util.List;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SwipePageElements extends BasePage {

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='card']")
    protected List<WebElement> scrollCards;



}
