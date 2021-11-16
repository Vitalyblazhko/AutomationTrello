package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListHelper extends HelperBase{

    public ListHelper(WebDriver wd) {
        super(wd);
    }

    public void enterListTitle() {
        wait = new WebDriverWait(mWebDriver, 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-sm icon-add']")));
        type(By.xpath("//*[@class='list-name-input']"), "new List");
    }

    public void submitAddListCreation() {
        click(By.xpath("//*[@type='submit']"));
    }

    public void clickAddACard() {
        click(By.xpath("//*[@class='js-add-a-card']"));
    }

    public void enterFirstCardTitle() {
        type(By.xpath("//*[@class='list-card-composer-textarea js-card-title']"), "Title for the first card");
    }

    public void submitAddCardCreation() {
        click(By.xpath("//*[@class='primary confirm mod-compact js-add-card']"));
    }

    public void enterSecondCardTitle() {
        type(By.xpath("//*[@class='list-card-composer-textarea js-card-title']"), "Title for the second card");
    }

}
