package space.hoaiviet.webdriver.common.core.driverprovider;

import space.hoaiviet.webdriver.common.core.HVWebDriver;
import space.hoaiviet.webdriver.common.core.configuration.Configuration;
import space.hoaiviet.webdriver.common.core.driver.Browser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hoaiviet on 5/18/17.
 * DriverProvider
 */
public class DriverProvider {

    private static final List<HVWebDriver> drivers = new ArrayList<>();
    private static int ACTIVE_BROWSER_INDEX = 0;

    private static void newInstance() {
        drivers.add(Browser.lookup(Configuration.getBrowser()).getInstance());
    }

    private static HVWebDriver getBrowserDriver(int index) {
        for (; drivers.size() <= index; ) {
            newInstance();
        }

        return drivers.get(index);
    }

    public static HVWebDriver getActiveDriver() {
        return getBrowserDriver(ACTIVE_BROWSER_INDEX);
    }

    public static HVWebDriver switchActiveWindow(int index) {
        ACTIVE_BROWSER_INDEX = index;
        return getActiveDriver();
    }

    public static void close() {
        for (HVWebDriver webDriver : drivers) {
            if (webDriver != null) {
                try {
                    webDriver.quit();
                } catch (UnsatisfiedLinkError | NoClassDefFoundError e) {
                    e.printStackTrace();
                }
            }
        }
        drivers.clear();
        ACTIVE_BROWSER_INDEX = 0;
    }
}
