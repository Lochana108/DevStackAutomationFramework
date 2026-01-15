package com.devstack.automation.testBase;

import com.devstack.automation.reporter.ExtentReporterManager;
import com.devstack.automation.utils.PropertyHandler;
import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class SeleniumTestBaseHelper {
    protected WebDriver driver;

//    @BeforeSuite(alwaysRun = true)
//    public void beforeSuite(){
//        ExtentReporterManager.initReport(); // init reporte
//    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method){
        this.driver = ThreadLocalWebDriverManager.createWebDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertyHandler.getProperty("url"));
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult testResult){
        if(testResult.getStatus() == ITestResult.FAILURE){
            ExtentReporterManager.logFail(testResult.getName()+"\n"+testResult.getThrowable().getMessage());
        } else if (testResult.getStatus() == ITestResult.SKIP) {
            ExtentReporterManager.logSkip(testResult.getName()+"\n"+testResult.getThrowable().getMessage());
        }else{
            ExtentReporterManager.logPass(testResult.getName()+" passed.");
        }
        ThreadLocalWebDriverManager.removeDriver();
    }

//    @AfterSuite(alwaysRun = true)
//    public void afterSuite(){
//        ExtentReporterManager.flushReport();//flush the report
//    }
}

