package com.devstack.automation.testBase;

import com.devstack.automation.reporter.ExtentReporterManager;
import com.devstack.automation.utils.ThreadLocalWebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumTestBase {
    protected static WebDriver driver;
    protected JavascriptExecutor executor;

    public SeleniumTestBase(WebDriver driver) {
        this.driver = ThreadLocalWebDriverManager.getDriver();
        this.executor = (JavascriptExecutor) this.driver;
    }

    public void click(By locator)  {

            try{
                WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
                moveToElement(element);
                element.click();
                ExtentReporterManager.logPass("Clicked in "+locator);
            }catch(Exception e){
                ExtentReporterManager.logFail("No such element in locator "+locator+"\n"+e.getMessage());
            }
    }
    public void jsClick(By locator){
        try{
        WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
        moveToJsElement(element);
        executor.executeScript("arguments[0].click();",element);
        ExtentReporterManager.logPass("JS clicked in locator :"+locator);
        } catch (Exception e) {
            ExtentReporterManager.logFail("No such element in locator :"+locator);
        }
    }
    public void type(By locator,String inputText){    // type on textbox
       try{
           WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
           moveToElement(element);
           element.click();
           element.clear();
           element.sendKeys(inputText);
           ExtentReporterManager.logPass("Typed [ "+inputText+" ] in locator : "+locator);
       }catch (Exception e){
            ExtentReporterManager.logFail("No such element in locator : "+locator+"\n"+e.getMessage());
       }
    }
    public void jsType(By locator,String inputText){
        try {
            WebElement element = waitForVissibilityOfElement(driver.findElement(locator));
            moveToJsElement(element);
            executor.executeScript("arguments[0].value='';",element);
            executor.executeScript("arguments[0].value='"+inputText+"';",element);
            ExtentReporterManager.logPass("JS Typed [ "+inputText+" ] in locator : "+locator);
        } catch (Exception e) {
            ExtentReporterManager.logFail("No such element in locator :"+locator+"\n"+e.getMessage());
        }
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
    public void moveToJsElement(WebElement locator){
        executor.executeScript("arguments[0].scrollIntoView();",locator);
    }
}
