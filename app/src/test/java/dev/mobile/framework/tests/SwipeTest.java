package dev.mobile.framework.tests;

import org.testng.annotations.Test;

public class SwipeTest extends BaseTest {

    @Test(description = "Performing horizontal swipe")
    public void swipeHorizontalTest() {
        homePage.goToSwipePage()
                .horizentalSwipe()
                .verifyCardTitle("GREAT COMMUNITY");
    }

}
