package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;


public class LandingPage extends BasePage{
    @FindBy(css = "#Content a")
    private WebElement enterTheStoreButton;

    @Step("Clicking on Enter the store button")
    public TopMenuPage clickOnEnterStoreButton() {
        WaitForElement.waitUntilElementClickable(enterTheStoreButton);
        enterTheStoreButton.click();
        log().info("Clicked on Enter Store Link");
        return new TopMenuPage();
    }

}
