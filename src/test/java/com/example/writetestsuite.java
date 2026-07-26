package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class writetestsuite {

    WebDriver driver;
    long startTime;
    long endTime;

    // aim: open chrome and goto
    // 1. google.in 2.bing.com 3.yahoo.com

    /**
     * 
     */
    @BeforeSuite
    public void OpenBrowser() {
        startTime = System.currentTimeMillis();
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void openGoogle() {

        driver.get("https://www.google.com");

    }

    @Test
    public void openBing() {

        driver.get("https://www.bing.com");

    }

    @Test
    public void openYahoo() {

        driver.get("https://www.yahoo.com");

    }

    @AfterSuite
    public void closeBrowser() {
        driver.quit();
        endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Time taken to open Google: " + duration);

    }

}
