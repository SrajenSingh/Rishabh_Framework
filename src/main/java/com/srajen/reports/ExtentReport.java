package com.srajen.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.srajen.constants.FrameworkConstant;

public final class ExtentReport {
    private ExtentReport(){}
    public static  ExtentReports extent;
    public static ExtentTest extentTest;

    public static  ExtentSparkReporter spark;
    public static void initReports(String className){

         extent = new ExtentReports();
         spark = new ExtentSparkReporter(FrameworkConstant.setReportPath(className));
         spark = new ExtentSparkReporter(FrameworkConstant.getReportPath());
         extent.attachReporter(spark);
    }
    public static void flushReport(){
            extent.flush();
    }

    public static void createTest(String testCaseName) {
            extentTest = extent.createTest(testCaseName);
            ExtentManager.setExtentTest(extentTest);
    }
}
