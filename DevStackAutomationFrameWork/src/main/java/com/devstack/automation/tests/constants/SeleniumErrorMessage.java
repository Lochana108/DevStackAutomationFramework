package com.devstack.automation.tests.constants;

public enum SeleniumErrorMessage {
    CLICK("No such element to click"),
    TYPE("No such element to type");

    private final String message;
    SeleniumErrorMessage(String message) {
        this.message = message;
    }
    public String getMessage(){
        return message;
    }
}
