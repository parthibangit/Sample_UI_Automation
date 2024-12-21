package org.example.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.configuration.DriverFactory;
import org.example.configuration.ExtentReport;
import org.example.configuration.PropertyReader;
import org.example.utilities.Utils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.time.Duration;

public class BaseHelper {

    private final ExtentReport extentReport = new ExtentReport();
    private final String filePath = System.getProperty("user.dir")+ File.separator+"test-output"+File.separator+"screenshots"+File.separator+"screenshot "+Utils.getCurrentDateAndTime()+".png";
    protected WebDriver driver;
    private ExtentTest extentTest;
    public ExtentTest node;
    private int count = 0;



    @BeforeSuite
    protected void setUpReporter() {

        extentReport.startReporter();
    }

    @BeforeTest
    protected void createTest(ITestContext context) {

        extentTest = extentReport.createExtentTest(context);
    }

    @Parameters({"browserName"})
    @BeforeMethod
    protected void setUp( @Optional String browserName, ITestContext context) {

        driver = DriverFactory.getDriver(browserName);
        openApplication();

        ITestNGMethod[] methods = context.getAllTestMethods();
        if(methods.length != 0) {
            node = extentTest.createNode(methods[count].getMethodName());
            count=count+1;
        }
    }

    protected void openApplication() {

        String url = PropertyReader.getInstance().getValue("url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            node.log(Status.PASS, "Test case passed");
        }
        else if (result.getStatus() == ITestResult.FAILURE){
            node.log(Status.FAIL, "Test case failed: " + result.getThrowable());
            Utils.takeScreenshot(filePath, driver);
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            node.log(Status.SKIP, "Test case skipped");
        }

        driver.quit();
    }

    @AfterSuite
    protected void updateReport() {
        extentReport.extentReports.flush();
    }
}
