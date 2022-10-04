package pages.base;

import org.openqa.selenium.WebDriver;
import utils.Click;
import utils.Enter;
import utils.Verify;

public abstract class BasePage {
    protected WebDriver webDriver;
    protected Enter enter;
    protected Click click;
    protected Verify verify;
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.enter = new Enter(webDriver);
        this.click = new Click(webDriver);
        this.verify= new Verify(webDriver);
    }
}
