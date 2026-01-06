package com.devstack.automation.tests.testBase;

import com.devstack.automation.tests.utils.PropertyHandler;
import com.devstack.automation.tests.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class SeleniumTestBaseHelper {
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        // extend report init
    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        this.driver = ThreadLocalWebDriverManager.createWebDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(PropertyHandler.getProperty("url"));
        // create test for reporting
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
       ThreadLocalWebDriverManager.removeDriver();
    }
    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        //flush the report
    }
}

