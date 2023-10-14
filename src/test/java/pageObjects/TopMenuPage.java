package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;



public class TopMenuPage extends BasePage{

    @FindBy(xpath = "//div[@id='MenuContent']/a[2]")
    private WebElement signInButton;


    @Step("Clicking on the sign in Button")
    public LoginPage clickOnSignInButton() {
        WaitForElement.waitUntilElementClickable(signInButton);
        signInButton.click();
        log().info("Clicked on Sign In Button");
        return new LoginPage();
    }
}
