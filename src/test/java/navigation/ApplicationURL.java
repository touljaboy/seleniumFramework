package navigation;

import configuration.AppProperties;

public class ApplicationURL {

    //Sets the different app urls using the configuration properties and the later domains
    public static final String APPLICATION_URL = AppProperties.getURL();
    public static final String LOGIN_URL = APPLICATION_URL + "actions/Account.action;signonForm=";
    public static final String CATALOG_URL = APPLICATION_URL + "actions/Catalog.action";
}
