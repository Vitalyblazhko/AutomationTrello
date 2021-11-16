package manager;

import models.Team;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends HelperBase {

    public TeamHelper(WebDriver wd) {
        super(wd);
     //   this.wd = wd;
    }

    /*public void teamCreationFromLeftNavMenu() {
        clickCreateTeamButtonOnNavMenu();
        fillTeamCreationForm(new Team().
                setNameWithTeamName("newTeam" + TimeUnit.SECONDS).
                setWithDescription("newTeam" + TimeUnit.SECONDS));
        submitTeamCreation();
    }*/

    public void fillTeamCreationForm(Team team) {
        type(By.id("org-display-name"), team.getTeamName());
        type(By.id("org-desc"), team.getTeamDescription());

    }

    public void clickCreateTeamButtonOnNavMenu() {
        click(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

    public void submitTeamCreation() {
        //wait = new WebDriverWait(wd, 10);
        click(By.xpath("//*[@value='Create']"));
    }


    public int teamCount() {
        //wait = new WebDriverWait(wd, 20);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@data-test-id='home-team-tab-name']")));
        int teamsCount = mWebDriver.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).size();
        return teamsCount;
    }

    public void clickFirstTeam() {
        mWebDriver.findElements(By.cssSelector("[data-test-id^='home-team-tab-section']")).get(0).click();
    }

    public void clickSettings() {
        click(By.xpath("//*[contains(text(), 'Settings')]"));
    }

    public void clickDeleteThisTeamQuestion() {
        click(By.xpath("//span[contains(text(),'Delete this team?')]"));
    }

    public void submitTeamDeleting() {
        click(By.xpath("//*[@class='js-confirm full negate']"));
    }




}
