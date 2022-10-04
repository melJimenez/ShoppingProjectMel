package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.base.BasePage;
import utils.Click;

public class FalabellaProductDetailsPage extends BasePage {
    private By addShoppingCartButton = By.xpath("//div[@id='buttonForCustomers']//button");
    private By incrementButton= By.xpath("//div[contains(@class,'stepper')]//button[contains(@class,'increment')]");
    private By extendedWarrantyButton =  By.xpath("//div[@id='testId-InCart-inPDP-WarrantyOption-btn-1']");
    private By shoppingCartButton =  By.id("linkButton");
    public FalabellaProductDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void addShoppingCart(){
        goToProductAddedPreferences();
        addOneMoreProducts();
        selectExtendedWarranty();
    }
    public void goToProductAddedPreferences(){
        click.clickEvent(addShoppingCartButton);
    }

    public void addOneMoreProducts(){
        click.clickEvent(incrementButton);
    }

    public void selectExtendedWarranty(){
        click.clickEvent(extendedWarrantyButton);
    }

    public FalabellaShoppingCartPage goToShoppingCart(){
        click.clickEvent(shoppingCartButton);
        return new FalabellaShoppingCartPage(webDriver);
    }
}
