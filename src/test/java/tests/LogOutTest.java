package tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends TestBase {

    Logger logger = LoggerFactory.getLogger(LogOutTest.class);

    @BeforeMethod
    public void ensurePrecondition(){
        if(!mApplicationManager.getSessionHelper().isUserLoggedIn()){
            mApplicationManager.getSessionHelper().logIn();
        }
    }

    @Test
    public void logOutTest(){
        logger.info("Start test logOutTest");

        mApplicationManager.getSessionHelper().clickOnAvatar();
        mApplicationManager.getSessionHelper().clickLogOutButton();
        mApplicationManager.getSessionHelper().submitLogOut();

        Assert.assertFalse(mApplicationManager.getSessionHelper().isUserLoggedIn());
        Assert.assertTrue(mApplicationManager.getSessionHelper().isLogInButtonExist());

        logger.info("Stop test logOutTest");
    }

}
