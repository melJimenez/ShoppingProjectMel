package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Enter {
    protected WebDriver webDriver;

    public Enter(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public void enterText(By input, String text){
        if (isVisible(input)){
            WebElement inputElement = webDriver.findElement(input);
            inputElement.sendKeys(text);
        }
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
}
