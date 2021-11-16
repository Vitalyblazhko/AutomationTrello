package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void returnHome() {
        click(By.xpath("//*[@data-test-id='header-home-button']"));
    }

}
