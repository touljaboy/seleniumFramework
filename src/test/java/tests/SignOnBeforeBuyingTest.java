package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import pageObjects.*;
import driver.manager.DriverUtils;

import static navigation.ApplicationURL.CATALOG_URL;
import static org.testng.AssertJUnit.assertEquals;

public class SignOnBeforeBuyingTest extends TestBase {

    @TmsLink("ID-02")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    @Description("The goal of this test is to enter the fishstore section of the store, add the angel fish to the cart " +
            "and try to checkout. The test checks if the message 'You must sign in before buying' is visible afterwards")
    public void signOnBeforeByingAnAngelFishTest() {
        DriverUtils.navigateToPage(CATALOG_URL);

        MainStorePage mainStorePage = new MainStorePage();
        mainStorePage.enterFishSectionUsingLeftSideMenu()
                .selectAngelFish()
                .addSmallAngelFishToCart()
                .pressProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage();
       loginPage.assertThatWarningIsDisplayed(
                "You must sign on before attempting to check out. Please sign on and try checking out again.");
    }
}
