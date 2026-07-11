

package com.testng.practice.LoginTestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BothCorrect {

    @Test
    public void LoginWithBothCorrect() {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement username = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("username")));

        username.sendKeys("Admin");

        WebElement Password = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.name("password")));

        Password.sendKeys("admin123");

        driver.quit();
    }
}