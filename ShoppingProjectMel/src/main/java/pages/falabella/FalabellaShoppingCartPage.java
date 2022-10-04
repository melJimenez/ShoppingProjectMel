package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.Click;

public class FalabellaShoppingCartPage extends BasePage {
    private By continueShoppingButton = By.xpath("//button[contains(@data-testid,'testId-ContinueShopping-enabled')]");
    public FalabellaShoppingCartPage(WebDriver webDriver) {
        super(webDriver);
    }
    public FalabellaShoppingCartEmail continueShopping(){
        click.clickEvent(continueShoppingButton);
        return new FalabellaShoppingCartEmail(webDriver);
    }

}
