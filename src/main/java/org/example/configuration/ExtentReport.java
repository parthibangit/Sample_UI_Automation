package org.example.configuration;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;

import java.io.File;

public class ExtentReport {

    public ExtentSparkReporter extentSparkReporter;
    public ExtentReports extentReports;

    public void startReporter()
    {
        extentSparkReporter  = new ExtentSparkReporter(System.getProperty("user.dir")+File.separator+"test-output"+File.separator+"report.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        //configuration items to change the look and feel
        //add content, manage tests etc
        extentSparkReporter.config().setDocumentTitle("Ecommerce Automation Project");
        extentSparkReporter.config().setReportName("Smoke Report");
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    public ExtentTest createExtentTest(ITestContext context) {

        return extentReports.createTest(context.getName());
    }


}
