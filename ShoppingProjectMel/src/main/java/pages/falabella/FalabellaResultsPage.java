package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class FalabellaResultsPage extends BasePage {
    public FalabellaResultsPage(WebDriver webDriver) {
        super(webDriver);
    }
    public FalabellaProductDetailsPage selectProduct(String index){
        String locator = "//div[@id='testId-searchResults-products']//img["+index+"]";
        click.clickEvent(By.xpath(locator));
        return new FalabellaProductDetailsPage(webDriver);
    }
}
