package com.devstack.automation;

import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        // Find the search box and enter text
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium javaScript Executor");

        // Find the search button
        WebElement searchButton = driver.findElement(By.name("btnK"));

        //Click using javaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",searchButton);

        driver.quit();
    }
    //this class created for practice to javaScriptExecutors,
}
