package tests;

import configuration.ConfigurationProperties;
import configuration.PropertiesLoader;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import driver.BrowserType;
import driver.manager.DriverManager;
import driver.manager.DriverUtils;

import java.util.Properties;

import static navigation.ApplicationURL.APPLICATION_URL;

public class TestBase {

    @Step("Loading configuration from configuration.properties")
    @BeforeClass
    public void beforeMethod() {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        Properties propertiesFromFile = propertiesLoader
                .getPropertiesFromFile("configuration.properties");
        ConfigurationProperties.setProperties(propertiesFromFile);
    }

    @Step("Setting browser to {browserType} and navigating to HomePage")
    @Parameters("browser")
    @BeforeMethod
    public void beforeTest(@Optional BrowserType browserType) {
        DriverManager.setWebDriver(browserType);
        DriverManager.getWebdriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage(APPLICATION_URL);
   }

   @Step("Disposing browser")
    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
