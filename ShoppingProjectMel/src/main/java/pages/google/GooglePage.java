package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.Click;
import utils.Enter;

public class GooglePage extends BasePage {
    private By searchInput = By.name("q");
    private By searchButton = By.name("btnK");

    public GooglePage(WebDriver webDriver) {
        super(webDriver);
    }

    public GoogleResultsPage search(String textToSearch){
        Enter enter =  new Enter(webDriver);
        enter.enterText(searchInput,textToSearch);
        Click click = new Click(webDriver);
        click.clickEvent(searchButton);
        return new GoogleResultsPage(webDriver);
    }

}
