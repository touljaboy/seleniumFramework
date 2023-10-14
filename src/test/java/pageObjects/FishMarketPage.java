package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class FishMarketPage extends BasePage{


    @FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr[2]/td[1]/a")
    WebElement angelFishButton;

    @Step("Selecting Angelfish")
    public AngelFishPage selectAngelFish() {
        WaitForElement.waitUntilElementClickable(angelFishButton);
        angelFishButton.click();
        log().info("Entered the Angel Fish Page");
        return new AngelFishPage();
    }
}
