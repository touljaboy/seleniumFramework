package configuration;

import driver.BrowserType;

public class TestRunProperties {
    //Using configuration properties, the browser is determined
    public static BrowserType getBrowserToRun() {
        return BrowserType.valueOf(ConfigurationProperties.getProperties().getProperty("browser"));

    }
    //Using configuration properties, the grid.url is determined
    public static String getGridUrl() {
        return ConfigurationProperties.getProperties().getProperty("grid.url");
    }

    //Using configuration properties, the information whether the run is remote is obtained
    public static boolean getIsRemoteRun() {
        return Boolean.parseBoolean(ConfigurationProperties.getProperties().getProperty("is.remote.run"));
    }
}
