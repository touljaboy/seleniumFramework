package pageObjects;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import driver.manager.DriverManager;
import waits.WaitForElement;

public class AngelFishPage extends BasePage{


    @FindBy(xpath = "//*[@id='Catalog']/table/tbody/tr[3]/td[5]/a")
    WebElement addSmallAngelFishToCartButton;

    @Step("Adding Small Angelfish to the cart")
    public ShoppingCartPage addSmallAngelFishToCart() {
        WaitForElement.waitUntilElementClickable(addSmallAngelFishToCartButton);
        addSmallAngelFishToCartButton.click();
        log().info("Small Angel Fish added to cart. Proceeding to Shopping Cart Page");
        return new ShoppingCartPage();
    }
}
