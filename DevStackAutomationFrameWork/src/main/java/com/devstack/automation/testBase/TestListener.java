package com.devstack.automation.testBase;

import com.devstack.automation.reporter.ExtentReporterManager;
import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onTestStart(ITestResult result) {
        ExtentReporterManager.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReporterManager.logPass(result.getMethod().getMethodName()+" Passed..");
    }

    public void onTestFailure(ITestResult result) {
        WebDriver driver = ThreadLocalWebDriverManager.getDriver();
        String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        ExtentReporterManager.logFailWithScreenShot("Test failed"+result.getThrowable().getLocalizedMessage(),base64Screenshot);
        ExtentReporterManager.logFail(result.getMethod().getMethodName()+" Failed..");
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReporterManager.logSkip(result.getMethod().getMethodName()+" Skipped"+result.getThrowable().getMessage());
    }

    public void onStart(ITestContext context) {
        ExtentReporterManager.initReport();
    }

    public void onFinish(ITestContext context) {
        ExtentReporterManager.flushReport();
    }
}
