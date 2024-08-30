package org.example.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.example.configuration.DriverFactory;
import org.example.configuration.ExtentReport;
import org.example.configuration.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {

    private final ExtentReport extentReport = new ExtentReport();
    protected WebDriver driver;
    ExtentTest extentTest;
    ExtentTest node;
    int count = 0;


    @BeforeSuite
    public void setUpReporter() {

        extentReport.startReporter();
    }

    @BeforeTest
    public void createTest(ITestContext context) {

        extentTest = extentReport.createExtentTest(context);
    }

    @Parameters({"browserName"})
    @BeforeMethod
    public void setUp(@Optional String browserName, ITestContext context) {

        driver = DriverFactory.getDriver(browserName);
        openApplication();

        ITestNGMethod[] methods = context.getAllTestMethods();
        if(methods.length != 0) {
            node = extentTest.createNode(methods[count].getMethodName());
            count=count+1;
        }

    }


    private void openApplication() {

        String url = PropertyReader.getInstance().getValue("url");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30L));
    }



    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            node.log(Status.PASS, "Test case passed");
        }
        else if (result.getStatus() == ITestResult.FAILURE){
            node.log(Status.FAIL, "Test case failed: " + result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            node.log(Status.SKIP, "Test case skipped");
        }

        driver.quit();
    }

    @AfterSuite
    public void updateReport() {
        extentReport.extentReports.flush();
    }
}
