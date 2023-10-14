package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

import static generic.assertions.AssertWebElement.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class FooterPage extends BasePage{

    @FindBy(xpath = "//*[@id='Banner']/img")
    WebElement afterLoginBanner;

    @Step("Assert that element Dog Banner is visible")
    public FooterPage assertThatBannerVisibleCheck() {
        log().info("Checking if dogbanner is visible");
        WaitForElement.waitForElementToBeVisible(afterLoginBanner);
        assertThat(afterLoginBanner).isDisplayed();
        log().info("AfterLoginBanner is visible");
        return this;
    }


}
