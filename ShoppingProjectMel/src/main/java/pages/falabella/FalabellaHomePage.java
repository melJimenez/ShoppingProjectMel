package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class FalabellaHomePage extends BasePage {

    private By searchInput = By.id("testId-SearchBar-Input");
    private By searchButton = By.xpath("//div[@id='testId-search-wrapper']//button");
    private By closeButton = By.xpath("//div[@class='dy-lb-close']");

    public FalabellaHomePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void closeModal(){
        click.clickEvent(closeButton);
    }
    public FalabellaResultsPage searchProduct(String productName){
        enter.enterText(searchInput,productName);
        click.clickEvent(searchButton);
        return new FalabellaResultsPage(webDriver);
    }
}
