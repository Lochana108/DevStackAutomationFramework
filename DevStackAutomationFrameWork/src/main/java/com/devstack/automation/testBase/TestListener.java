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
    @Override
    public void onTestStart(ITestResult result) {
        ExtentReporterManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReporterManager.logPass(result.getMethod().getMethodName()+" passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ThreadLocalWebDriverManager.getDriver();
        String base64ScreenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
        ExtentReporterManager.logFailWithScreenShot("Test Failed."+result.getThrowable().getLocalizedMessage(),base64ScreenShot);
        ExtentReporterManager.logFail(result.getMethod().getMethodName()+" Test Failed.");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentReporterManager.logSkip(result.getMethod().getMethodName()+" skipped."+result.getThrowable().getMessage());
    }

    @Override
    public void onStart(ITestContext context) {
        ExtentReporterManager.initReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReporterManager.flushReport();
    }
}
