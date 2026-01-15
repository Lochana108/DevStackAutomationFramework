package com.devstack.automation.login;

import com.devstack.automation.BaseTest;
import com.devstack.automation.functions.commons.LIB_Common;
import com.devstack.automation.utils.PropertyHandler;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LIB_Common common = new LIB_Common(driver);
        common.bc_login(PropertyHandler.getProperty("username"),PropertyHandler.getProperty("password"));
    }
}
 