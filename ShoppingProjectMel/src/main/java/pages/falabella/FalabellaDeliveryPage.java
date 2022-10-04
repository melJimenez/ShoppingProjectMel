package pages.falabella;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.base.BasePage;
import utils.Click;
import utils.Enter;
import utils.Verify;

public class FalabellaDeliveryPage extends BasePage {
    private By streetInpt= By.id("testId-Input-street");
    private By departmentNumber = By.id("testId-Input-departmentNumber");
    private By continueButton = By.id("testId-infoModalFooter-button");
    private By selectStreetInput;
    private By productName = By.xpath("//div[@data-testid='testId-ItemCell']//div[contains(@class,'cell')]");
    private By numberOfProducts =  By.xpath("//div[@data-testid='testId-ItemCell']//span[2]");
    private By partialAmount = By.xpath("//div[@data-testid='testId-ItemCell']//div[2]//span[1]");
    private By totalAmount = By.xpath("//span[@data-testid='total-amount']");
    private By sumaryTitle = By.xpath("//span[contains(text(),'Resumen de la compra')]");
    private By goToPayButton =  By.id("testId-ContinueShopping-enabled");
    private By bodyPage = By.xpath("//div[contains(@class,'main')]");
    private By giftCard = By.xpath("//div[contains(@data-testid,'GIFT_CARD')]");
    private By idCardNumber = By.id("testId-Input-cardNumber");
    private By securityNumber = By.id("testId-Input-securityCode");
    private By addGiftCardButton = By.xpath("//button[@data-testid='testId-Button-SubmitGiftcard']");
    private By validationGiftCardMessage = By.xpath("//span[@data-testid='testId-process-payment-error']");
    private By acceptModalButton = By.xpath("//button[@data-testid='testId-infoModalAcceptButton']");
    public FalabellaDeliveryPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void enterDeliveryStreetDepartment(String street, String department){
        enterStreetInput(street);
        selectStreet(street);
        enterDepartmentInput(department);
        click.clickEvent(continueButton);
    }
    public void enterStreetInput(String street) {
        enter.enterText(streetInpt,street);
    }
    public void enterDepartmentInput(String department) {
        enter.enterText(departmentNumber,department);
    }
    public void selectStreet(String street){
        selectStreetInput = By.id("testId-Dropdown-"+street);
        click.clickEvent(selectStreetInput);
    }
    public boolean verifyProductName(String productNameText){
        if (isSumaryTitleDisplayed()) return verify.verifyText(productName,productNameText);
        return false;
    }
    public boolean isSumaryTitleDisplayed(){
        return verify.isVisible(sumaryTitle);
    }

    public boolean verifyNumberOfProducts(String numberOfProductText){
        return verify.verifyText(numberOfProducts,numberOfProductText);
    }

    public boolean verifyPartialAmount(String partialAmountText){
        return verify.verifyText(partialAmount,partialAmountText);
    }

    public boolean verifyTotalAmount(String totalAmountText){
        return verify.verifyText(totalAmount,totalAmountText);
    }
    public void clickOnGoToBuyButton() {
        click.clickEvent(goToPayButton);
    }
    public void clickOnBodyPage() {
        click.clickEvent(bodyPage);
    }
    public void clickOnGiftCard(){
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement Element = webDriver.findElement(giftCard);
        js.executeScript("arguments[0].scrollIntoView();", Element);
        click.clickEvent(giftCard);
    }

    public String getTotalAmount() {
        if(verify.isVisible(totalAmount)) {
            WebElement totalAmountWe = webDriver.findElement(totalAmount);
            return totalAmountWe.getText();
        }
        return "Null Value";
    }

    public String getPartialAmount(){
        if(verify.isVisible(partialAmount)) {
            WebElement totalAmountWe = webDriver.findElement(partialAmount);
            return totalAmountWe.getText();
        }
        return "Null Value";
    }

    public void fillGiftCardInformation(String idCardNumberText, String securityNumberText) {
        enter.enterText(idCardNumber, idCardNumberText);
        enter.enterText(securityNumber, securityNumberText);
        click.clickEvent(addGiftCardButton);
    }

    public void clickAcceptGiftCard() {
        click.clickEvent(acceptModalButton);
    }
    public String getValidationGiftCard() {
        if(verify.isVisible(validationGiftCardMessage)) {
            WebElement totalAmountWe = webDriver.findElement(validationGiftCardMessage);
            return totalAmountWe.getText();
        }
        return "Null Value";
    }

}
