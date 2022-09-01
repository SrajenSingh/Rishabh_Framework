package com.srajen.reports;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.srajen.utils.ScreenShotUtils;

public final class ExtentLogger {
        private ExtentLogger(){

        }
        public static void pass(String message){
           /* ExtentManager.getExtenttest().pass(message);*/
            ExtentManager.getExtenttest().pass(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenshot()).build());
        }
        public static void fail(String message){
           /* ExtentManager.getExtenttest().fail(message);*/
            ExtentManager.getExtenttest().fail(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenshot()).build());

        }
        public static void info(String message){
           /* ExtentManager.getExtenttest().info(message);*/
            ExtentManager.getExtenttest().info(message,
                    MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtils.getScreenshot()).build());

        }

}
