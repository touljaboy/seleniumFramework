package waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.manager.DriverManager;

import java.time.Duration;

public class WaitForElement {
//Class implementing different 'waits', depending on the conditions
    private static int time;
    public static WebDriverWait getWebDriverWait() {
        return  new WebDriverWait(DriverManager.getWebdriver(), Duration.ofSeconds(time));
    }

    public static void waitForElementToBeVisible(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementClickable(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void setWaitDuration(int seconds) {
        time = seconds;
    }
}
