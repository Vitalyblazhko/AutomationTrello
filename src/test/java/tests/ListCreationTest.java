package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (!mApplicationManager.getSessionHelper().isUserLoggedIn()) {
            mApplicationManager.getSessionHelper().logIn();
        }
    }

    @Test
    public void testListCreationViaBoardCreationFromHeader() {
        mApplicationManager.getBoardHelper().clickPlusButtonOnHeader();
        mApplicationManager.getBoardHelper().selectCreateBoard();
        mApplicationManager.getBoardHelper().addBoardTitle();
        mApplicationManager.getBoardHelper().clickCreateBoardButton();

        mApplicationManager.getListHelper().enterListTitle();
        mApplicationManager.getListHelper().submitAddListCreation();
        mApplicationManager.getListHelper().clickAddACard();
        mApplicationManager.getListHelper().enterFirstCardTitle();
        mApplicationManager.getListHelper().submitAddCardCreation();
        mApplicationManager.getListHelper().enterSecondCardTitle();
        mApplicationManager.getListHelper().submitAddCardCreation();

        int numberOfCards = mApplicationManager.getListHelper().mWebDriver.findElements(By.xpath("//*[@class='list-card-details js-card-details']")).size();

        Assert.assertEquals(2, numberOfCards);

        mApplicationManager.getNavigationHelper().returnHome();

    }
}
