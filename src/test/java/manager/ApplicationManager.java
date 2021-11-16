package manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    String SITE_URL = "https://trello.com/en";

    BoardHelper boardHelper;
    TeamHelper teamHelper;
    SessionHelper sessionHelper;
    ListHelper listHelper;
    NavigationHelper navigationHelper;
    EventFiringWebDriver eventFiringWebDriver;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void start() {
        switch (browser) {
            case BrowserType.CHROME:
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                eventFiringWebDriver = new EventFiringWebDriver(new ChromeDriver());
                break;
            case BrowserType.FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                eventFiringWebDriver = new EventFiringWebDriver(new FirefoxDriver());
                break;
            case BrowserType.EDGE:
                System.setProperty("webdriver.edge.driver", "src/test/resources/drivers/msedgedriver.exe");
                eventFiringWebDriver = new EventFiringWebDriver(new EdgeDriver());
                break;
        }

        eventFiringWebDriver.register(new TListener());

        eventFiringWebDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        eventFiringWebDriver.manage().window().maximize();
        openSite(SITE_URL);

        sessionHelper = new SessionHelper(eventFiringWebDriver);
        boardHelper = new BoardHelper(eventFiringWebDriver);
        teamHelper = new TeamHelper(eventFiringWebDriver);
        listHelper = new ListHelper(eventFiringWebDriver);
        navigationHelper = new NavigationHelper(eventFiringWebDriver);
    }

    public void stop() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        eventFiringWebDriver.quit();
    }

    public void openSite(String url) {
        eventFiringWebDriver.get(url);
    }

    public void returnToPreviousPage() {
        eventFiringWebDriver.navigate().back();
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }

    public ListHelper getListHelper() {
        return listHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

}
