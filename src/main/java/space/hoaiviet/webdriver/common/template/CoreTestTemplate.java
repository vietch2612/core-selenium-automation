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

    protected HVWebDriver driver;

    private void refreshDriver() {
        driver = DriverProvider.getActiveDriver();
    }

    private static int runID;

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

//    @AfterMethod
//    public void afterMethod(ITestResult result) {
////        int testCaseID = (int) result.getAttribute("testCaseID");
////        UpdateReport updateReport = new UpdateReport();
////        updateReport.updateTestResult(runID, testCaseID, 1);
//    }

//    @AfterMethod
//    @Attachment(value = "Failure image", type = "image/png")
//    public byte[] takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        File destFile;
//        if (testResult.getStatus() == ITestResult.FAILURE
//                || testResult.getStatus() == ITestResult.SKIP) {
//            File scrFile = driver.getScreenshotAs(OutputType.FILE);
//            Calendar calendar = Calendar.getInstance();
//            SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//
//            try {
//                String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
//                destFile = new File(String.format("%s/failure_screenshots/%s_%s.png",
//                        reportDirectory,
//                        testResult.getName(),
//                        formatter.format(calendar.getTime())));
//
//                FileUtils.copyFile(scrFile, destFile);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

//    @AfterMethod
//    public byte[] takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        return driver.getScreenshotAs(OutputType.BYTES);
//    }

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
