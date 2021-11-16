package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase {

    String BOARD_NAME = "newBoard_";

    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void clickBoards() {
        click(By.xpath("//*[@class='boards-page-board-section-header-options-item-name']//*[text()='Boards']"));
    }

    public int personalBoardsCount(){
        WebElement personalBoards = mWebDriver.findElement(By.xpath("//ul[@class='boards-page-board-section-list']//li[@class='boards-page-board-section-list-item']"));
        return personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size() - 1;
    }

    public void clickCreateNewBoardFromBody() {
        click(By.xpath("//*[@data-test-id='create-board-tile']"));

    }

    public void addBoardTitle() {
        type(By.xpath("//*[@data-test-id='create-board-title-input']"), BOARD_NAME + System.currentTimeMillis());
    }

    public void clickCreateBoardButton() {
        click(By.xpath("//*[@data-test-id='create-board-submit-button']"));
//        wait = new WebDriverWait(mWebDriver, 20);
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-sm icon-add']")));
    }

    public void clickBoardsFromLeftSidebar() {
        click(By.xpath("//a[@href='/vitalyblazhko/boards']//span[text()='Boards']"));
    }

    public void clickBoardsFromHeader() {
        click(By.xpath("//span[text()='Boards']"));
    }

    public void clickCreateNewBoardOnTheEndOfList() {
        WebElement personalBoards = mWebDriver.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        int boardsCount = personalBoards.findElements(By.xpath(".//*[@class='boards-page-board-section-list-item']")).size();
        personalBoards.findElement(By.xpath(".//*[@class='boards-page-board-section-list-item']["+(boardsCount)+"]")).click();

    }

    public void clickPlusButtonOnHeader() {
        click(By.xpath("//*[@class='header-btn-icon icon-lg icon-add light']"));
    }

    public void selectCreateBoard() {
        click(By.cssSelector(".js-new-board"));
    }

    public void clickHomeButtonFromLeftMenu() {
        click(By.cssSelector("[data-test-id='home-link']"));
    }

    public void clickCreateABoard() {
        click(By.xpath("//*[@class='icon-add icon-sm _1qcR9v_U6yheVw']"));
    }

    public void clickFirstBoard() {
        WebElement personalBoards = mWebDriver.findElement(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
        personalBoards.findElements(By.xpath(".//*[@class='board-tile-details is-badged']")).get(0).click();
    }

    public void clickShowMenu() {
        click(By.xpath("//*[@class='board-header-btn mod-show-menu js-show-sidebar']"));
    }

    public void clickMoreFromMenu() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']"));
    }

    public void clickCloseBoardFromMenu() {
        click(By.xpath("//*[@class='board-menu-navigation-item-link js-close-board']"));
    }

    public void confirmBoardDeleting() {
        click(By.xpath("//*[@value='Close']"));
    }

    public void boardCreationFromBody() {
        clickCreateNewBoardOnTheEndOfList();
        addBoardTitle();
        clickCreateBoardButton();
    }

   /* public boolean checkMenu(){
        boolean flag = false;

        click(By.xpath("//a[@class='board-menu-navigation-item-link js-power-up-empty-slot']"));
        if(isElementPresent(By.xpath("//a[@class='board-menu-navigation-item-link js-power-up-empty-slot']"))){
            flag = true;
        } return flag;
    }*/
}
