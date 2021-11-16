package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTeamTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        if(!mApplicationManager.getSessionHelper().isUserLoggedIn()) {
            mApplicationManager.getSessionHelper().logIn();
        }
    }

    @Test
    public void deleteTeamFromLeftNavMenu(){
        int beforeTestTeamCount = mApplicationManager.getTeamHelper().teamCount();

        mApplicationManager.getTeamHelper().clickFirstTeam();
        mApplicationManager.getTeamHelper().clickSettings();
        mApplicationManager.getTeamHelper().clickDeleteThisTeamQuestion();
        mApplicationManager.getTeamHelper().submitTeamDeleting();

        int afterTestTeamCount = mApplicationManager.getTeamHelper().teamCount();

        Assert.assertEquals(afterTestTeamCount, beforeTestTeamCount-1);
    }
}
