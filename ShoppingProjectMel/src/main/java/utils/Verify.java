package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Verify {
    protected WebDriver webDriver;

    public Verify(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public boolean verifyText(By element, String text){
        boolean isTheSame = false;
        if (isVisible(element)){
           WebElement webElement = webDriver.findElement(element);
            if(webElement.getText().equalsIgnoreCase(text)){
                isTheSame= true;
            }else{
                isTheSame = false;
            }
        }else{
            isTheSame=false;
        }
        return isTheSame;
    }

    public boolean isVisible(By element){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean isClickable(By element){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            System.out.println(element + " - Clickable.");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isEnable(By element){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element).andThen(WebElement::isEnabled));
            System.out.println(element + " - Enabled");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
