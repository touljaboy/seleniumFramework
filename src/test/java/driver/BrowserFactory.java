package driver;

import configuration.LocalWebDriverProperties;
import configuration.TestRunProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {

    private static final String MESSAGE_UNKNOWN_BROWSER =  "Unknown Browser Type! Check your configuration";

    private BrowserType browserType;
    private boolean isRemoteRun;

    //After configuration.properties are loaded, the BrowserFactory 'produces' browsers, meaning it applies
    //the described properties such as browserType and boolean containing information whether the run is remote
    public BrowserFactory(BrowserType browserType, boolean isRemoteRun) {
        this.browserType = browserType;
        this.isRemoteRun = isRemoteRun;
    }

    //Next, depending whether the run is remote or not, different actions are needed to get the proper webdriver.
    //The following code dictates the correct webdriver. It uses configuration properties as well as all_tests_suite.xml
    public WebDriver getBrowser() {
        if (isRemoteRun) {

            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

            switch (browserType) {
                case CHROME:
                    ChromeOptions chromeOptions = new ChromeOptions();
                    desiredCapabilities.merge(chromeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case FIREFOX:
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    desiredCapabilities.merge(firefoxOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                case MSEDGE:
                    EdgeOptions edgeOptions = new EdgeOptions();
                    desiredCapabilities.merge(edgeOptions);
                    return getRemoteWebDriver(desiredCapabilities);
                default:
                    throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        }
        else {
            switch (browserType) {

                case FIREFOX -> {
                    System.setProperty("webdriver.gecko.driver", LocalWebDriverProperties.getFirefoxDriverLocation());
                    return new FirefoxDriver();
                }
                case CHROME -> {
                    System.setProperty("webdriver.chome.driver", LocalWebDriverProperties.getChromeDriverLocation());
                    return new ChromeDriver();
                }
                case MSEDGE -> {
                    System.setProperty("webdriver.edge.driver", LocalWebDriverProperties.getMsEdgeDriverLocation());
                    return new EdgeDriver();
                }
                default -> throw new IllegalStateException(MESSAGE_UNKNOWN_BROWSER);
            }
        }
    }

    private WebDriver getRemoteWebDriver(DesiredCapabilities desiredCapabilities) {
        RemoteWebDriver remoteWebDriver = null;

        try {
            remoteWebDriver = new RemoteWebDriver(new URL(TestRunProperties.getGridUrl()), desiredCapabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to create RemoteWebDriver due to: "+ e.getMessage());
        }
        return remoteWebDriver;
    }
}
