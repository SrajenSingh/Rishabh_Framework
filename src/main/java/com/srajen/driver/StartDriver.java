package com.srajen.driver;

import com.srajen.config.ConfigFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public final class StartDriver {

    private StartDriver(){

    }

    private static WebDriver driver;

    public static void initDriver(){
        if(DriverManager.getDriver()==null){
            String browser = ConfigFactory.getConfig().browser();
            driver=DriverFactory.getDriver(browser);
            DriverManager.setDriver(driver);
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(ConfigFactory.getConfig().timeout(), TimeUnit.SECONDS);
            DriverManager.getDriver().get(ConfigFactory.getConfig().url());

        }


    }
    public static void quitDriver(){
        if(DriverManager.getDriver()!=null){
            DriverManager.getDriver().quit();
            DriverManager.setDriver(null);
        }

    }
}
