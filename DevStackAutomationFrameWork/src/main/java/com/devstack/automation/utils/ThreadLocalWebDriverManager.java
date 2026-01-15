package com.devstack.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class ThreadLocalWebDriverManager {
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    private static PropertyHandler propertyHandler = new PropertyHandler();

    public static WebDriver createWebDriver(){
        String browser = propertyHandler.getProperty("browser");
        WebDriver driver = null;

        if(browser.equalsIgnoreCase("chrome")){
            driver = WebDriverManager.chromedriver().create();
        }else if(browser.equalsIgnoreCase("firefox")){
            driver = WebDriverManager.firefoxdriver().create();
        }else if(browser.equalsIgnoreCase("edge")){
            driver = WebDriverManager.edgedriver().create();
        }else if(browser.equalsIgnoreCase("opera")){
            driver = WebDriverManager.operadriver().create();
        }else if(browser.equalsIgnoreCase("safari")){
            driver = WebDriverManager.safaridriver().create();
        }else{
            throw new IllegalArgumentException("Unsupported browser : "+browser);
        }
        threadLocalWebDriver.set(driver);
        return driver;
    }

    public static WebDriver getDriver(){
        return threadLocalWebDriver.get();
    }

    public static void removeDriver(){
        WebDriver driver = threadLocalWebDriver.get();
        if (driver != null){

        }
    }
}
