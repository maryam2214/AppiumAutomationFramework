package dev.mobile.framework.pages.actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import dev.mobile.framework.pages.elements.WebViewElements;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WebViewPageActions extends WebViewElements {

    public WebViewPageActions(WebDriver webDriver) {
        setDriver(webDriver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebViewPageActions clickSearchButton() {
        click(searchButton);
        return this;
    }

    public MobileBrowserActions clickSearchBar() {
        click(searchButton);
        return new MobileBrowserActions(driver);
    }

   public MobileBrowserActions goToAlgoliaSearchInBrowser() throws InterruptedException {
       click(algoliaSearchLink);
        return new MobileBrowserActions(driver);
   }

}
