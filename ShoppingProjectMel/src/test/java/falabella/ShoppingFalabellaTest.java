package falabella;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.falabella.*;
import pages.google.GooglePage;
import pages.google.GoogleResultsPage;
public class ShoppingFalabellaTest extends BaseTest {
    @Test
    public void testShoppingProductName(){
        String validationMessage = "Lo sentimos, no podemos agregar tu tarjeta. Por favor, llama al 600 329 2002";
        GooglePage googlePage = new GooglePage(webDriver);
        GoogleResultsPage googleResultsPage = googlePage.search("Falabella");
        googleResultsPage.selectLinkWithUrlFromResult("www.falabella.com");
        FalabellaHomePage falabellaHomePage = new FalabellaHomePage(webDriver);
        falabellaHomePage.closeModal();
        FalabellaResultsPage falabellaResultsPage = falabellaHomePage.searchProduct("Vivobook 15 OLED K513EA-L12336W Intel Core i5 Intel Iris Xe 8GB RAM 512GB SSD 15,6\" FHD");
        FalabellaProductDetailsPage falabellaProductDetailsPage = falabellaResultsPage.selectProduct("1");
        falabellaProductDetailsPage.addShoppingCart();
        FalabellaShoppingCartPage falabellaShoppingCartPage = falabellaProductDetailsPage.goToShoppingCart();
        FalabellaShoppingCartEmail falabellaShoppingCartEmail = falabellaShoppingCartPage.continueShopping();
        falabellaShoppingCartEmail.enterEmailInput("toked976234@migonom.com");
        FalabellaDeliveryPage falabellaDeliveryPage = falabellaShoppingCartEmail.continueShopping();
        falabellaDeliveryPage.enterDeliveryStreetDepartment("Nataniel Cox 125, Santiago, Chile","Depto 2");
        Assert.assertTrue(falabellaDeliveryPage.verifyProductName("Vivobook 15 OLED K513EA-L12336W Intel Core i5 Intel Iris Xe 8GB RAM 512GB SSD 15,6\" FHD"));
        falabellaDeliveryPage.clickOnBodyPage();
        falabellaDeliveryPage.clickOnGoToBuyButton();
        falabellaDeliveryPage.clickOnGiftCard();
        falabellaDeliveryPage.fillGiftCardInformation("11111111111","000000");
        Assert.assertEquals(falabellaDeliveryPage.getValidationGiftCard(), validationMessage, "El mensaje de validation no es correcto");
        falabellaDeliveryPage.clickAcceptGiftCard();
        Assert.assertEquals(falabellaDeliveryPage.getPartialAmount(),"$ 629.990", "The Partial amount value is not as expected");
        Assert.assertEquals(falabellaDeliveryPage.getTotalAmount(), "$ 1.477.580","The Total amount value is not as expected");
    }
}
