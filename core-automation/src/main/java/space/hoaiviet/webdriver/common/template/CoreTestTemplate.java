package space.hoaiviet.webdriver.common.template;

import org.openqa.selenium.Dimension;
import org.testng.annotations.*;
import space.hoaiviet.webdriver.common.core.HVWebDriver;
import space.hoaiviet.webdriver.common.core.configuration.Configuration;
import space.hoaiviet.webdriver.common.core.driverprovider.DriverProvider;

/**
 * Created by hoaiviet on 5/18/17.
 * CoreTestTemplate
 */
public abstract class CoreTestTemplate {

    private HVWebDriver driver;

    private void refreshDriver() {
        driver = DriverProvider.getActiveDriver();
    }

    @BeforeTest
    public void beforeTest() {
    }

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
    }

    @BeforeMethod(alwaysRun = true)
    public void initTest() {
        Configuration.clearCustomTestProperties();
        driver = DriverProvider.getActiveDriver();
        setWindowsSize();
        loadFirstPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        //TODO: Write result & Update status for TeamServices
        DriverProvider.close();
    }

    @Deprecated
    private void setTestProperty(String key, String value) {
        if (!"".equals(value)) Configuration.setTestValue(key, value);
    }

    private void setWindowsSize() {
        Dimension browserSize = Configuration.getBrowserSize();
        if (browserSize != null) {
            driver.manage().window().setSize(browserSize);
        } else {
            driver.manage().window().maximize();
        }
    }

    @Deprecated
    protected String switchToWindow(int index) {
        DriverProvider.switchActiveWindow(index);
        refreshDriver();
        return DriverProvider.getActiveDriver().equals(driver) ? "primary window" : "secondary window";
    }

    @AfterSuite
    public void afterSuite() {
        //TODO
    }

    protected abstract void loadFirstPage();
    protected abstract void prepareURLs();
}
