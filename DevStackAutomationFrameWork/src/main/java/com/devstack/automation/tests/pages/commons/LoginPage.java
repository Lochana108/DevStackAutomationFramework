package com.devstack.automation.tests.pages.commons;

import com.devstack.automation.tests.testBase.SeleniumTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends SeleniumTestBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
 // practices
    // input  | text field ----------> tf_<fieldName>
    // button ---------->  btn_<buttonName>
    // checkBox --------> chk_<checkboxName>
    // radio button ------> rdo_<radioButtonName>
    // dropdown --------> dd_<dropdownName>

    By tf_userName = By.id("username");
    By tf_password = By.id("password");
    By btn_login = By.xpath("//button[text() = 'Login']");

    public void fillUserName(String userName){
        type(tf_userName,userName);
    }
    public void fillPassword(String password){
        type(tf_password,password);
    }
    public void clickLogin() {
        click(btn_login);
    }

}
