package dev.mobile.framework.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import dev.mobile.framework.pages.elements.DragDropPageElements;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DragDropPageActions extends DragDropPageElements {

    public DragDropPageActions(WebDriver webDriver) {
        setDriver(webDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public DragDropPageActions dragItems() {

        Actions actions = new Actions(driver);

        actions.dragAndDrop(dragItemL1, dropItemL1);
        actions.dragAndDrop(dragItemC1, dropItemC1);
        actions.dragAndDrop(dragItemR1, dropItemR1);
        actions.dragAndDrop(dragItemL2, dropItemL2);
        actions.dragAndDrop(dragItemC2, dropItemC2);
        actions.dragAndDrop(dragItemR2, dropItemR2);
        actions.dragAndDrop(dragItemL3, dropItemL3);
        actions.dragAndDrop(dragItemC3, dropItemC3);
        actions.dragAndDrop(dragItemR3, dropItemR3);


        actions.build().perform();

        Assert.assertNotNull(congratulationsMessage);

        return this;
    }

}
