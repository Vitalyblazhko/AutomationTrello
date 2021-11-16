package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class SessionHelper extends HelperBase {

    private final String CRED_USER = "vitaly.blazhko@gmail.com";
    private final String CRED_PASSWORD = "vitaly1986";
    private final String USER_LOGGED_IN_LOCATOR = "//span[@title='Vitaly Blazhko (vitalyblazhko)']";

    public SessionHelper(WebDriver webDriver) {
        super(webDriver);
    }

    public void logIn() {
        clickLoginButton();
        fillLoginForm();
        confirmLogin();
    }

    public void logOut() {
        clickOnAvatar();
        clickLogOutButton();
        submitLogOut();
    }

    public void confirmLogin() {
        click(By.cssSelector("#login-submit"));
    }

    public void fillLoginForm() {
        type(By.cssSelector("#user"), CRED_USER);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        click(By.xpath("//*[@id='login']"));
        type(By.cssSelector("#password"), CRED_PASSWORD);
    }

    public void clickLoginButton() {
        click(By.xpath("//*[contains(text(),'Log in')]"));
    }

    public void clickLogOutButton() {
        click(By.xpath("//*[@data-test-id='header-member-menu-logout']"));
    }

    public void submitLogOut() {
        click(By.id("logout-submit"));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.xpath(USER_LOGGED_IN_LOCATOR));
    }

    public boolean isLogInButtonExist() {
        return isElementPresent(By.xpath("//*[contains(text(),'Log In')]"));
    }

    public void clickOnAvatar() {
        Actions actions = new Actions(mWebDriver);
        actions.moveToElement(mWebDriver.findElement(By.xpath(USER_LOGGED_IN_LOCATOR))).click().perform();
    }
}
