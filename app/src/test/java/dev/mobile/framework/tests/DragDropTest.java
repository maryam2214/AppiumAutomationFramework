package dev.mobile.framework.tests;

import org.testng.annotations.Test;

public class DragDropTest extends BaseTest {

    @Test(description = "Performing drag and drop")
    public void dragDropTest() {
        homePage.goToDragDropPage()
                .dragItems();
    }

}
