package com.srajen.pages;

import com.srajen.driver.DriverManager;

public class homePage {
    public String getTitle() {

        return DriverManager.getDriver().getTitle();
    }
}
