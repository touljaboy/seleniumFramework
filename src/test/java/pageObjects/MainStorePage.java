package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class MainStorePage extends BasePage{


    @FindBy(xpath = "//*[@id='SidebarContent']/a[1]")
    private WebElement enterFishSectionOnLeftPageSideButton;

    @Step("Entering the Fish section of the store using the left side menu")
    public FishMarketPage enterFishSectionUsingLeftSideMenu() {
        WaitForElement.waitUntilElementClickable(enterFishSectionOnLeftPageSideButton);
        enterFishSectionOnLeftPageSideButton.click();
        log().info("Entered the Fish section");
        return new FishMarketPage();
    }
}
