package tests;

import manager.TLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @BeforeMethod
    public void ensurePrecondition(){
        if(mApplicationManager.getSessionHelper().isUserLoggedIn()){
            mApplicationManager.getSessionHelper().logOut();
        }
    }

    @Test
    public void testLogin() {
        logger.info("Start test testLogin");

        mApplicationManager.getSessionHelper().clickLoginButton();
        mApplicationManager.getSessionHelper().fillLoginForm();
        mApplicationManager.getSessionHelper().confirmLogin();

        Assert.assertTrue(mApplicationManager.getSessionHelper().isUserLoggedIn());

        logger.info("Stop test testLogin");
    }
}
