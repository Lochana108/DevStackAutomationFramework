package com.devstack.automation.tests.login;

import com.devstack.automation.tests.BaseTest;
import com.devstack.automation.tests.functions.commons.LIB_Common;
import com.devstack.automation.tests.utils.PropertyHandler;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LIB_Common  common = new LIB_Common(driver);
        common.bc_login(PropertyHandler.getProperty("username"),PropertyHandler.getProperty("password"));
    }
}
