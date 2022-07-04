package dev.mobile.framework.pages.elements;

import org.openqa.selenium.WebElement;

import dev.mobile.framework.pages.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DragDropPageElements extends BasePage {

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-l1']")
    protected WebElement dragItemL1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-l1']")
    protected WebElement dropItemL1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-c1']")
    protected WebElement dragItemC1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-c1']")
    protected WebElement dropItemC1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-r1']")
    protected WebElement dragItemR1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-r1']")
    protected WebElement dropItemR1;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-l2']")
    protected WebElement dragItemL2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-l2']")
    protected WebElement dropItemL2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-c2']")
    protected WebElement dragItemC2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-c2']")
    protected WebElement dropItemC2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-r2']")
    protected WebElement dragItemR2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-r2']")
    protected WebElement dropItemR2;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-l3']")
    protected WebElement dragItemL3;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-l3']")
    protected WebElement dropItemL3;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-c3']")
    protected WebElement dragItemC3;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-c3']")
    protected WebElement dropItemC3;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drag-r3']")
    protected WebElement dragItemR3;

    @AndroidFindBy(xpath= "//android.view.ViewGroup[@content-desc='drop-r3']")
    protected WebElement dropItemR3;

    @AndroidFindBy(xpath= "//android.view.TextView[@text='Congratulations']")
    protected WebElement congratulationsMessage;
}
