package com.devstack.automation.tests.testBase;

import com.devstack.automation.tests.constants.SeleniumErrorMessage;
import com.devstack.automation.tests.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestBase {
    protected static WebDriver driver;

    public SeleniumTestBase(WebDriver driver) {
        this.driver = ThreadLocalWebDriverManager.getDriver();
    }

    public void click(By locator)  {
            WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
            moveToElement(element);
            element.click();
    }
    public void type(By locator,String inputText){    // type on textbox
        WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
        moveToElement(element);
        element.click();
        element.clear();
        element.sendKeys(inputText);
    }
    // explicitly wait :  diipu time eka athulatha expected condition eka true wenkn wait wela innwa.
    // fluent wait : custom pollin ekkk denwa.check karanwa pollin wena time eka athulatha conditon eka ture wenawd kiyala.

    public static WebElement waitForVissibilityOfElement (WebElement locator){  // wait (Explicitly wait)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(locator));
    }
    public static void selectDropDownByVisibleText(By locator,String optionText){ //select dropDown using visible text
        WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
        new Select(element).selectByVisibleText(optionText);
    }
    public static void selectDropDownByIndex(By locator,int index){ // select dropDown using index
        WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
        new Select(element).selectByIndex(index);
    }
    public static void moveToElement(WebElement locator){
        new Actions(driver).moveToElement(locator).perform();
    }
}
