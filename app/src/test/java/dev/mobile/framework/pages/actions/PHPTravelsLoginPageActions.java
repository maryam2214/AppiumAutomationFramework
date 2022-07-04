package dev.mobile.framework.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import static org.testng.AssertJUnit.assertEquals;

import dev.mobile.framework.pages.elements.PHPTravelsLoginPageElements;

public class PHPTravelsLoginPageActions extends PHPTravelsLoginPageElements {

    public PHPTravelsLoginPageActions(WebDriver webDriver) {
        setDriver(webDriver);
        PageFactory.initElements(driver, this );
    }

    public PHPTravelsLoginPageActions entermail(String email)  {
        writeText(emailInput, email);
        return this;
    }

    public PHPTravelsLoginPageActions enterPass(String password) {
        writeText(passwordInput, password);
        return this;
    }

    public PHPTravelsLoginPageActions clickLogin() {
        click(loginButton);
        return this;
    }

    public PHPTravelsLoginPageActions verifyLogin(String url)  {
        assertEquals(driver.getCurrentUrl(), url);
        return this;
    }
}
