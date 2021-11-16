package tests;

import manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    public static ApplicationManager mApplicationManager = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite
    public void setUp() {
        mApplicationManager.start();
    }

    @AfterSuite
    public void tearDown() {
        mApplicationManager.stop();
    }
}
