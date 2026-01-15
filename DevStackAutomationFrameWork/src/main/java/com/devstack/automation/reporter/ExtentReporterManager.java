package com.devstack.automation.reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.Objects;

public class ExtentReporterManager {
    private static ExtentReports extentReports;
    private static ExtentTest test;

    // initialize report
    public static void initReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("ExtentReports/extentReports.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setDocumentTitle("Automation Report");
        sparkReporter.config().setReportName("Test Automation Results");
        extentReports.attachReporter(sparkReporter);
    }
    // Test Creation
    public static void createTest(String testName){
        test = extentReports.createTest(testName);
    }
    // create pass log
    public static void logPass(String message){
        if (Objects.nonNull(test)){  // test != null ------>  same condition
            test.log(Status.PASS,message);
        }
    }
    //log fail
    public static void logFail(String message){
        if (Objects.nonNull(test)){
            test.log(Status.FAIL,message);
        }
    }
    //log skip
    public static void logSkip(String message){
        if(Objects.nonNull(test)){
            test.log(Status.SKIP,message);
        }
    }
    // log fail and add screenShot
    public static void logFailWithScreenShot(String message,String base64ScreenShot){
        if(Objects.nonNull(test)){
            test.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64ScreenShot).build());
        }
    }

    // flush reports
    public static void flushReport(){
        if (Objects.nonNull(test)){
            extentReports.flush();
        }
    }

    public static void writeToReport(String message){
        if(Objects.nonNull(test)){
            test.log(Status.INFO,message);
        }
    }

}
