package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.Click;

public class GoogleResultsPage extends BasePage {

    private By resultLink ;

    public GoogleResultsPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void selectLinkWithUrlFromResult(String url) {
        Click clickElement = new Click(webDriver);
        resultLink = By.xpath(String.format("//div[@class='yuRUbf']//a[contains(@href,'%s')]",url));
        clickElement.clickEvent(resultLink);
    }
}
