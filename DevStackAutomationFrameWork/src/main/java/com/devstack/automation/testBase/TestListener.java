package com.devstack.automation.testBase;

import com.devstack.automation.reporter.ExtentReporterManager;
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
