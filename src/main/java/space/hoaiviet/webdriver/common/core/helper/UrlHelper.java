package space.hoaiviet.webdriver.common.core.helper;

import space.hoaiviet.webdriver.common.core.configuration.Configuration;
import space.hoaiviet.webdriver.common.core.configuration.Environment;

/**
 * Created by hoaiviet on 5/18/17.
 * UrlHelper
 */
public class UrlHelper {

    private static Environment env = Configuration.getEnvironment();

    public static String getHQEndpoint() {
        return "http://dev-hq-frontend.seven-system.com";
    }

    public static String getGOTEndpoint() {
        return "http://dev-got.seven-system.com";
    }

    public static String getSCEndpoint() {
//        return "http://dev-sc.seven-system.com";
//        return "https://staging-sc-1.seven-system.com";
        return "https://staging-sc-1.sevensystem.vn";
    }
}
