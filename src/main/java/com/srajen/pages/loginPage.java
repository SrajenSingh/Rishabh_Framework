package com.srajen.pages;

import com.srajen.enums.WaitType;
import com.srajen.driver.DriverManager;
import com.srajen.utils.seleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;

public class loginPage {
    private static final By SIGN_IN_NAV_BUTTON = By.xpath("//div[@id='navbarSupportedContent']/child::ul/child::li[contains(@class,'Nav__links_signin')]/child::div/child::a[contains(text(),'Sign In')]");
    private static final By EMAIL_FIELD = By.xpath("//input[@placeholder='Email *']");
    private static final By PASS_WORD = By.xpath("//input[@placeholder=\"Password *\"]");
    private static final By SIGN_IN_BUTTON = By.xpath("//input[@value=\"Sign in\"]");
    private static final By Cross_Button = By.xpath("//div[@class='container']//span[@class='lightbox_close_toggle']");

    private static final By Im = By.xpath("//div[@class=\"background\"]/../child::div[@class=\"container\"]/span");
   private loginPage clickOnCrossButton() throws InterruptedException {
      try{
          DriverManager.getDriver().switchTo().frame("ViralSweep Promotion Embed");
          if(DriverManager.getDriver().findElement(Im).isDisplayed()){
              seleniumUtils.actionClick(Cross_Button);
          }
          DriverManager.getDriver().switchTo().defaultContent();

      }
      catch(NoSuchElementException e)
      {
          return this;
      }

             return this;
    }
    private loginPage clickOnSignInNavButton() throws InterruptedException {
       try{

           seleniumUtils.click(SIGN_IN_NAV_BUTTON, WaitType.PRESENCE,"Sign In Nav Button");

       }
       catch (ElementNotInteractableException e){

           clickOnCrossButton();
           seleniumUtils.click(SIGN_IN_NAV_BUTTON, WaitType.PRESENCE, "Sign In Nav Button");

       }

        return this;
    }
    private loginPage enterEmailId(String username){

        seleniumUtils.sendKeysFunction(EMAIL_FIELD,username,"Email_Id");
        return this;
    }
    private loginPage enterPassword(String password){
        seleniumUtils.sendKeysFunction(PASS_WORD,password,"PassWord");
        return this;
    }
    private homePage clickOnSignInButton(String title) {
        seleniumUtils.click(SIGN_IN_BUTTON, WaitType.CLICKABLE,"Sign In Button");
        seleniumUtils.waitUntilTitleisMatched(title);
        return new homePage();

    }
    public homePage loginToApplicaton(String username, String password, String title) throws InterruptedException {
         return clickOnCrossButton().
             clickOnSignInNavButton()
                .enterEmailId(username)
                .enterPassword(password)
                .clickOnSignInButton(title);
    }
}
