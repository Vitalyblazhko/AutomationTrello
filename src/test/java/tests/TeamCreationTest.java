package tests;

import dataProvider.StaticProvider;
import models.Team;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if(!mApplicationManager.getSessionHelper().isUserLoggedIn()) {
            mApplicationManager.getSessionHelper().logIn();
        }
    }

    /*@Test(dataProvider = "validTeam", dataProviderClass = StaticProvider.class)
    public void teamCreationFromLeftNavMenuTest(String teamName, String description){

        app.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        app.getTeamHelper().fillTeamCreationForm(new Team().
                setNameWithTeamName(teamName).
                setWithDescription(description));
        app.getTeamHelper().submitTeamCreation();
        app.returnToPreviousPage();
    }*/

    @Test(dataProvider = "validTeamFromCsv", dataProviderClass = StaticProvider.class)
    public void teamCreationFromLeftNavMenuTest(Team team){

        mApplicationManager.getTeamHelper().clickCreateTeamButtonOnNavMenu();
        mApplicationManager.getTeamHelper().fillTeamCreationForm(team);
        mApplicationManager.getTeamHelper().submitTeamCreation();
        mApplicationManager.returnToPreviousPage();
    }

}
