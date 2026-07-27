package com.testng.practice.LoginTestcases.POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

/**
 * Page Object Model class for OrangeHRM Login page.
 * This class locates elements using driver.findElement() instead of @FindBy annotations.
 */
public class Loginwithoutfindby {

    WebDriver driver;
    WebDriverWait wait;

    public static WebElement username;
    public static WebElement password;
    public static WebElement  Login ;

    
@Test
    public void Loginwithoutfindby() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        PageFactory.initElements(driver, Loginwithoutfindby.class);

        username.sendKeys("Admin");
        password.sendKeys("admin123");
         Login .click();
    }

    
 
        
    }
