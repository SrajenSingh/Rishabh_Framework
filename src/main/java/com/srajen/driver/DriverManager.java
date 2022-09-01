package com.srajen.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){

    }
    //This will make sure your driver is thread safe
    private static final ThreadLocal<WebDriver>threadLocal=new ThreadLocal<>();

    public static WebDriver getDriver(){
        return threadLocal.get();
    }
    public static void setDriver(WebDriver driver){
        threadLocal.set(driver);
    }
}
