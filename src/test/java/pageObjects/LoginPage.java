package pageObjects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    private WebElement usernameInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(name = "signon")
    private WebElement signButton;
    @FindBy(xpath = "//*[@id='Content']/ul/li")
    private WebElement signInFailedLabel;

    @Step("Type in username field: {username}")
    public LoginPage fillUsernameField(String username) {
        WaitForElement.waitForElementToBeVisible(usernameInput);
        usernameInput.sendKeys(username);
        log().info("Entered username: " + username);
        return this;
    }
    @Step("Type in password field: {password}")
    public LoginPage fillPasswordField(String password) {
        passwordInput.sendKeys(password);
        log().info("Entered password: " +password);
        return this;
    }
    @Step("Clear all fields")
    public LoginPage clearAllFields() {
        usernameInput.clear();
        passwordInput.clear();
        log().info("All fields have been cleared");
        return this;
    }
    @Step("Click on sign on button")
    public FooterPage clickOnSignOnButton() {
        signButton.click();
        log().info("clicked on the sign on button");
        return new FooterPage();
    }
    @Step("Assert that warning message {warningMessage} is displayed")
    public LoginPage assertThatWarningIsDisplayed(String warningMessage) {
        log().info("Checking if warning message {} is displayed", warningMessage);
        WaitForElement.waitForElementToBeVisible(signInFailedLabel);
        log().info("SignInFailedLabel is visible! Getting the message: " + signInFailedLabel.getText());
        AssertWebElement.assertThat(signInFailedLabel).isDisplayed().hasText(warningMessage);
        return this;
    }

}
