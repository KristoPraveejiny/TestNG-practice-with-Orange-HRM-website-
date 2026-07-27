

package com.testng.practice.LoginTestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class Login {

     WebDriver driver;

   String Data[][] = null;


@DataProvider(name = "LoginData")
    public String[][] LoginDataprovider() throws BiffException, IOException{

        Data=getexceldata();
        return Data;

    }

    public String[][] getexceldata() throws BiffException, IOException{
        FileInputStream Excel = new FileInputStream("D:\\Praveena\\OrangeHRM Selenium TestNG\\TestNGPractice\\TestCase.xls");
        Workbook workbook = Workbook.getWorkbook(Excel);
        Sheet sheet=workbook.getSheet(0);
        int Rows=sheet.getRows();
        int Columns=sheet.getColumns();

        String Testdata[][]=new String[Rows-1][Columns];

        for(int i=1;i<Rows;i++){
            for(int j=0;j<Columns;j++){
                Testdata [i-1][j]=sheet.getCell(j, i).getContents();

            }
        }
        return Testdata;

    }

    @BeforeTest()
    
public void BeforeTest() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
}

    @AfterTest()
    public void AfterTest() {
        driver.quit();
    }




    @Test(dataProvider = "LoginData")

    public void LoginWithBothCorrect(String Uname, String Pword) {

     

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // wait for username input to be visible
        WebElement username = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("username")));

        username.sendKeys(Uname);

        WebElement Password = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.name("password")));

        Password.sendKeys(Pword);

        // use stable locator for login button
        WebElement loginButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]")));
        loginButton.click();

        
    }
}