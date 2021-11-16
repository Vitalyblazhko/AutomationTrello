package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    public WebDriver mWebDriver;
    WebDriverWait wait;

    public HelperBase(WebDriver wd) {
        this.mWebDriver = wd;
    }

    public void type(By locator, String text) {
        if(text!=null){
            mWebDriver.findElement(locator).click();
            mWebDriver.findElement(locator).clear();
            mWebDriver.findElement(locator).sendKeys(text);
        }
    }

    public void clear(By locator) {
        mWebDriver.findElement(locator).clear();
    }

    public void click(By locator) {
        mWebDriver.findElement(locator).click();
    }

    public boolean isElementPresent(By by) {
        try {
            mWebDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
