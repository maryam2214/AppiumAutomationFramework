package dev.mobile.framework.pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

import dev.mobile.framework.pages.elements.SwipePageElements;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SwipePageActions extends SwipePageElements {

    public SwipePageActions(WebDriver mobileDriver) {
        setDriver(mobileDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public SwipePageActions horizentalSwipe() {
        WebElement elementCurrent = scrollCards.get(0);
        int moveOffest = -(elementCurrent.getSize().width);
        moveOffest += moveOffest / 3;

        Actions actions = new Actions(driver);
        actions.clickAndHold(elementCurrent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.moveByOffset(moveOffest, 0);
        actions.build().perform();

        return this;
    }

    public SwipePageActions verifyCardTitle(String title) {
        WebElement cardTitle = driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']", title)));

        Assert.assertNotNull(cardTitle);
        return this;
    }
}



