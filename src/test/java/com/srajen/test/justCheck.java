package com.srajen.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class justCheck {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get("https://www.caseys.com/");
        driver.switchTo().frame("ViralSweep Promotion Embed");
        driver.findElement(By.xpath("//div[@class='container']//span[@class='lightbox_close_toggle']")).click();
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//div[@id='navbarSupportedContent']/child::ul/child::li[contains(@class,'Nav__links_signin')]/child::div/child::a[contains(text(),'Sign In')]")).click();

    }
}
