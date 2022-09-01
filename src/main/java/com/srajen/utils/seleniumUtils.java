package com.srajen.utils;

import com.srajen.enums.WaitType;
import com.srajen.config.ConfigFactory;
import com.srajen.driver.DriverManager;
import com.srajen.reports.ExtentLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class seleniumUtils {

    public static void click(By by,String elementName){
            WebElement element = DriverManager.getDriver().findElement(by);
            element.click();
            ExtentLogger.pass(elementName + " is clicked successfully");
    }

    public static void click(WebElement element){element.click();}

    public static void click(By by, WaitType waitType, String elementName){
        WebElement element= null;

        if(waitType==WaitType.PRESENCE){
            element = waitUntilPresent(by);
        }
        else if(waitType==WaitType.CLICKABLE){
            element = waitUntilClickable(by);
        }
        element.click();
        ExtentLogger.pass(elementName+" is clicked successfully");
    }


    public static void actionClick(By by) throws InterruptedException {
        WebElement element = DriverManager.getDriver().findElement(by);
        Actions action = new Actions(DriverManager.getDriver());
        action.moveToElement(element).build().perform();
        waitUntilClickable(element);

    }
    public static void sendKeysFunction(By by, String value, String elementName){
        WebElement element = waitUntilPresent(by);
        element.sendKeys(value);
        ExtentLogger.pass(value+" is entered "+"successfully in "+ elementName);
    }
    public static WebElement waitUntilPresent(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }
    public static WebElement waitUntilClickable(By by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;
    }
    public static void waitUntilClickable(WebElement by){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();

    }
    public static void waitUntilTitleisMatched(String title){
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(ConfigFactory.getConfig().timeout()));
        wait.until(ExpectedConditions.titleIs(title));
        ExtentLogger.pass(title+" Is matched");
    }


}
