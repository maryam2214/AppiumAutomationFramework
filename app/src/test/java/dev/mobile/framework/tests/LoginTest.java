package dev.mobile.framework.tests;


import org.testng.annotations.Test;
import static dev.mobile.framework.util.extentreports.ExtentTestManager.startTest;

//Task 7
public class LoginTest extends BaseTest {

    @Test(description = "Login test case for app side")
    public
    void performLogin() {
        homePage.goToLoginPage()
                .performLogin(configReader.getUserName(),
                              configReader.getPassword())
                .verifyLogin()
                .closeAlert();
    }

    //Task 3
    @Test(description = "Login test case for Web View")
    public void scenario1Test() throws InterruptedException {
        homePage.goToWebViewPage()
                .clickSearchBar()
                .switchTowebContext()
                .navigateToWebPage(configReader.getBaseUrl())
                .enterEmail(configReader.getWebUserName())
                .enterPassword(configReader.getWebPassword())
                .clickLogin()
                .verifyLogin("https://katalon-demo-cura.herokuapp.com/#appointment")
                .switchToNativeContext();

    }
}
