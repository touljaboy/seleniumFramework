package tests;

import driver.manager.DriverManager;
import io.qameta.allure.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import driver.manager.DriverUtils;

import java.io.File;
import java.io.IOException;

import static navigation.ApplicationURL.LOGIN_URL;

public class FailedLoginTests  extends  TestBase{

    @Issue("Defect-01")
    @TmsLink("ID-01")
    @Severity(SeverityLevel.NORMAL)
    @Test
    @Description("The goal of this test is to log in using inproper username and password" +
            "and verify whether the warning message Invalid username or passowrd is displayed")
    public void loginWithIncorrectLoginAndPasswordTest() {
        DriverUtils.navigateToPage(LOGIN_URL);
       LoginPage loginPage = new LoginPage();
                loginPage.fillUsernameField("idiot420")
                .fillPasswordField("idiotPass")
                .clickOnSignOnButton();
        File screenshotFile = ((TakesScreenshot) DriverManager.getWebdriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshotFile, new File("Screenshots/selenium_screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginPage.assertThatWarningIsDisplayed("Invalid username or password. Signon failed.");
    }



}
