package com.srajen.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.srajen.driver.StartDriver;
import com.srajen.reports.ExtentReport;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {



    /*@BeforeSuite
    public void beforeSuite(){
        ExtentReport.initReports();
    }
    @AfterSuite
    public void afterSuite(){
        ExtentReport.flushReport();
    }*/
    @BeforeClass
    public void beforeClass(){
        String className = getClass().getName();
        ExtentReport.initReports(className);
    }
    @BeforeMethod
    public void setUp(Method method){
        ExtentReport.createTest(method.getName());
        StartDriver.initDriver();
    }
    @AfterMethod
    public void tearDown(){StartDriver.quitDriver();}

    @AfterClass
    public void afterClass(){
        ExtentReport.flushReport();
    }
}
