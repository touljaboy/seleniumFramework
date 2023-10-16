package tests;

import driver.manager.DriverManager;
import driver.manager.DriverUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;
import pageObjects.FooterPage;
import pageObjects.LoginPage;
import waits.WaitForElement;

import java.sql.Driver;
import java.util.Set;

import static navigation.ApplicationURL.LOGIN_URL;

public class SuccessfulLoginWithCookiesTest extends TestBase {
    @TmsLink("ID-04")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to check whether correct cookie manipulation leads to a possibility of " +
            "using the site as a logged in user, without the need to enter the login data manually. This test will" +
            "later be useful, as not having a need to login each time will greatly optimise the test time")
    public void loginInThenManipulateCookiesAndCheckIfStillLoggedInTest() {
        DriverUtils.navigateToPage(LOGIN_URL);
        LoginPage loginPage = new LoginPage();
        loginPage.clearAllFields()
                .fillUsernameField("j2ee")
                .fillPasswordField("j2ee")
                .clickOnSignOnButton();

        FooterPage footerPage = new FooterPage();
        footerPage.assertThatBannerVisibleCheck();

        //Getting all of the cookies
        Set<Cookie> cookies = DriverManager.getWebdriver().manage().getCookies();
        //Getting the first cookie - in this case, the login cookie

        Cookie loginCookie = cookies.iterator().next();
        //deleting all cookies
        DriverManager.getWebdriver().manage().deleteAllCookies();
        //refresh the page
        DriverManager.getWebdriver().navigate().refresh();


        //Assert that element is not visible - add later
        try {
            //set time duration to 1 to make the test go quicker
            WaitForElement.setWaitDuration(1);
            footerPage.assertThatBannerVisibleCheck();
        } catch (org.openqa.selenium.TimeoutException e) {
            //just catch the error as expected, we can now proceed. Add a log entry later
            System.out.println("DogBanner not displayed!");
            //set the wait duration back to 10 seconds
            WaitForElement.setWaitDuration(10);
        }
        //refresh has added a cookie, so lets delete all of them again and add the login cookie and check whether
        //the AfterLoginBanner is visible
        DriverManager.getWebdriver().manage().deleteAllCookies();
        DriverManager.getWebdriver().manage().addCookie(loginCookie);
        DriverManager.getWebdriver().navigate().refresh();


        footerPage.assertThatBannerVisibleCheck();


    }
}
