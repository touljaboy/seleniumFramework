package utils;

import driver.manager.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotMaker {

    @Attachment(value = "Page screenshot test failure", type = "image/png")
    public static byte[] takeScreenshot() {
        byte[] screenshotFile = ((TakesScreenshot) DriverManager.getWebdriver()).getScreenshotAs(OutputType.BYTES);
        return screenshotFile;
    }
}
