package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;

public class FalabellaShoppingCartEmail extends BasePage {
    private By emailInput =  By.id("testId-Input-email");
    private By continueButton =  By.xpath("//button[contains(@data-testid,'continueButton')]");

    public FalabellaShoppingCartEmail(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterEmailInput(String email) {
        enter.enterText(emailInput,email);
    }

    public FalabellaDeliveryPage continueShopping(){
        click.clickEvent(continueButton);
        return new FalabellaDeliveryPage(webDriver);
    }
}
