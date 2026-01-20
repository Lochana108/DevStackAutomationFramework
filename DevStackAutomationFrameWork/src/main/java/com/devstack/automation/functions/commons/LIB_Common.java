package com.devstack.automation.functions.commons;

import com.devstack.automation.functions.FunctionBase;
import com.devstack.automation.pages.commons.LoginPage;
import com.devstack.automation.reporter.ExtentReporterManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LIB_Common extends FunctionBase {
    public LoginPage loginPage;

    public LIB_Common(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }
    public void bc_login(String userName,String password) {
        ExtentReporterManager.writeToReport("Start of bc_login");
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.verifyChooseLocation());
        ExtentReporterManager.writeToReport("End of bc_login");
    }
}
