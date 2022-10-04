package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Click {

    protected WebDriver webDriver;

    public Click(WebDriver webDriver){
        this.webDriver= webDriver;
    }

    public void clickEvent(By element){
        if (isClickable(element)){
            WebElement clickElement = webDriver.findElement(element);
            clickElement.click();
        }
    }

    public boolean isClickable(By element){
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, 60);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
