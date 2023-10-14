package configuration;

public class AppProperties {
    public static String getURL() {
        return ConfigurationProperties.getProperties().getProperty("app.url");
    }
}
