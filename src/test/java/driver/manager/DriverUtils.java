package driver.manager;

import io.qameta.allure.Step;

public class DriverUtils {
    @Step("Maximizing browser window")
    public static void setInitialConfiguration() {
        DriverManager.getWebdriver().manage().window().maximize();
    }

    @Step("Navigating to URL:{url}")
    public static void navigateToPage(String url) {
        DriverManager.getWebdriver().navigate().to(url);
    }
}
