package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(BoardCreationTest.class);

    @BeforeMethod
    public void ensurePreconditions() {
        if (!mApplicationManager.getSessionHelper().isUserLoggedIn()) {
            mApplicationManager.getSessionHelper().logIn();
        }
    }

    @Test
    public void testBoardCreationFromBody(){
        logger.info("Start test testBoardCreationFromBody");

        mApplicationManager.getBoardHelper().clickBoards();

        int beforeCount = mApplicationManager.getBoardHelper().personalBoardsCount();

        mApplicationManager.getBoardHelper().clickCreateNewBoardFromBody();
        mApplicationManager.getBoardHelper().addBoardTitle();
        mApplicationManager.getBoardHelper().clickCreateBoardButton();
        mApplicationManager.getNavigationHelper().returnHome();
        mApplicationManager.getBoardHelper().clickBoardsFromLeftSidebar();


        int afterCount = mApplicationManager.getBoardHelper().personalBoardsCount();

        System.out.println("!!!!!!!!!!!!!!!!!!!: " + beforeCount);
        System.out.println("!!!!!!!!!!!!!!!!!!!: " + afterCount);

        Assert.assertEquals(afterCount, beforeCount+1);

        logger.info("Stop test testBoardCreationFromBody");
    }

    /*@Test(enabled = false)
    public void testBoardCreationFromHeader() {
        app.getBoardHelper().clickPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }

    @Test(enabled = false)
    public void testBoardCreationFromHome(){
        app.getBoardHelper().clickHomeButtonFromLeftMenu();
        app.getBoardHelper().clickCreateABoard();
        app.getBoardHelper().addBoardTitle("newBoard" + System.currentTimeMillis());
        app.getBoardHelper().clickCreateButton();
        app.returnToPreviousPage();
    }*/

}