package driver.manager;

import driver.BrowserType;
import org.openqa.selenium.WebDriver;
import driver.BrowserFactory;
import driver.listeners.DriverEvenetListenerRegistar;

import static configuration.TestRunProperties.getBrowserToRun;
import static configuration.TestRunProperties.getIsRemoteRun;

public class DriverManager {
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    public DriverManager() {
    }

    //Function used to set the webdriver
    public static void setWebDriver(BrowserType browserType) {
        WebDriver browser = null;
        if (browserType==null) {
            browserType = getBrowserToRun();
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }
        else {
            browser = new BrowserFactory(browserType, getIsRemoteRun()).getBrowser();
        }

        browser = DriverEvenetListenerRegistar.registerWebDriverEvenetListener(browser);

        browserTypeThreadLocal.set(browserType);
        webDriverThreadLocal.set(browser);
    }


    public static WebDriver getWebdriver() {
        if(webDriverThreadLocal.get() == null) {
            throw new IllegalStateException("WebDriver instance was null! " +
                    "Please create instance of Webdriver using setWebdriver");
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().quit();
//      webDriverThreadLocal.get().close();
//        if(!getBrowserToRun().equals(FIREFOX)) {
//            webDriverThreadLocal.get().quit();
//
//        }

        webDriverThreadLocal.remove();
        browserTypeThreadLocal.remove();
    }
}
