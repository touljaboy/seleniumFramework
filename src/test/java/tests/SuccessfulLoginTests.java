package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pageObjects.FooterPage;
import pageObjects.LoginPage;
import driver.manager.DriverUtils;

import static navigation.ApplicationURL.LOGIN_URL;
import static org.testng.AssertJUnit.assertTrue;

public class SuccessfulLoginTests extends TestBase {

    @TmsLink("ID-03")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to log in using proper username and password" +
            "and verify whether the Dog Banner is displayed afterwards")
    public void loginWithCorrectLoginAndPasswordTest() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearAllFields()
                .fillUsernameField("j2ee")
                .fillPasswordField("j2ee")
                .clickOnSignOnButton();

        FooterPage footerPage = new FooterPage();
        footerPage.assertThatBannerVisibleCheck();
    }

}
