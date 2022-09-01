package com.srajen.test;

import com.srajen.driver.DriverManager;
import com.srajen.pages.homePage;
import com.srajen.pages.loginPage;
import com.srajen.utils.seleniumUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginTest extends BaseTest {
    @DataProvider
    public static Object[][] getData() {
        return new Object[][]{
                {"srajensingh924@gmail.com","Mummy@241",
                        "Casey's Pizza, Food & Grocery Delivery | Gas Station & Convenience Store"
                }
        };
    }

    @Test(description = "To check whether user can login to Caseys website",dataProvider = "getData")
    public void login(String username, String password, String expectedText) throws InterruptedException {
        loginPage lp = new loginPage();
        String actualText= lp.loginToApplicaton(username, password,expectedText).getTitle();
        Assert.assertEquals(actualText,expectedText);


    }

}
