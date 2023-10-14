package waits;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import driver.manager.DriverManager;

import java.time.Duration;

public class WaitForElement {
//Class implementing different 'waits', depending on the conditions
    public static WebDriverWait getWebDriverWait() {
        return  new WebDriverWait(DriverManager.getWebdriver(), Duration.ofSeconds(10));
    }

    public static void waitForElementToBeVisible(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitUntilElementClickable(WebElement webElement) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
