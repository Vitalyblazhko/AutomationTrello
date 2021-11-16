package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteBoardTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if(!mApplicationManager.getSessionHelper().isUserLoggedIn()) {
                mApplicationManager.getSessionHelper().logIn();
        }
    }

    @Test
    public void deleteBoardFromStartOfList(){
        int beforeCount = mApplicationManager.getBoardHelper().personalBoardsCount();

        mApplicationManager.getBoardHelper().clickFirstBoard();
        try {
            mApplicationManager.getBoardHelper().clickShowMenu();
        } catch (Exception e) {};

        mApplicationManager.getBoardHelper().clickMoreFromMenu();
        mApplicationManager.getBoardHelper().clickCloseBoardFromMenu();
        mApplicationManager.getBoardHelper().confirmBoardDeleting();
        mApplicationManager.returnToPreviousPage();

        int afterCount = mApplicationManager.getBoardHelper().personalBoardsCount();

        Assert.assertEquals(afterCount+1, beforeCount);
        mApplicationManager.getNavigationHelper().returnHome();
    }

}
