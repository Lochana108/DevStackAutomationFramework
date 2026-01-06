package com.devstack.automation.tests.functions.commons;

import com.devstack.automation.tests.functions.FunctionBase;
import com.devstack.automation.tests.pages.commons.LoginPage;
import org.openqa.selenium.WebDriver;

public class LIB_Common extends FunctionBase {
    public LoginPage loginPage;

    public LIB_Common(WebDriver driver) {
        super(driver);
        loginPage = new LoginPage(driver);
    }
    public void bc_login(String userName,String password) {
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        loginPage.clickLogin();
    }
}
