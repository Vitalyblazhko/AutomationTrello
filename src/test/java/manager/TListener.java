package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;

public class TListener extends AbstractWebDriverEventListener {
    public TListener() {
        super();
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("search " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println(by + " found");
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        System.out.println("!!!---------ERROR----------!!!");
        System.out.println(throwable);
        System.out.println("!!!------------------------!!!");

        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp, new File("screen_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
