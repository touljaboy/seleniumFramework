package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class ShoppingCartPage extends BasePage{


    @FindBy(css = "#Cart > a")
    WebElement proceedToCheckoutButton;

    @Step("Pressing the proceed to checkout button")
    public CheckOutPage pressProceedToCheckoutButton() {
        WaitForElement.waitUntilElementClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Proceed to checkout button clicked");
        return new CheckOutPage();
    }
}
