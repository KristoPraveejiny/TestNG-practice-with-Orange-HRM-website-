package com.testng.practice.LoginTestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenusingPOI {
 

    static List<String> UsernameList = new ArrayList<String>();
    static List<String> PasswordList = new ArrayList<String>();

    public void ReadExcel() throws IOException {
        FileInputStream file = new FileInputStream(
                "D:\\Praveena\\OrangeHRM Selenium TestNG\\TestNGPractice\\Testcase1.xlsx");
        Workbook workbook = new XSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Iterator<Cell> ColumnIterator = row.iterator();
            int i = 2;

            while (ColumnIterator.hasNext()) {

                if (i % 2 == 0) {

                    UsernameList.add(ColumnIterator.next().toString());
                } else {
                    PasswordList.add(ColumnIterator.next().toString());

                }
                i++;

            }

        }

    }

    public void login(String Uname, String Pword) {

       WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

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
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]")));
        loginButton.click();

        driver.quit();

    }

    public void executeTest(){
        for(int i=0; i<UsernameList.size(); i++){
            login(UsernameList.get(i), PasswordList.get(i));
            
    }}

    

    public static void main(String[] args) throws IOException {
        DataDrivenusingPOI obj = new DataDrivenusingPOI();
        obj.ReadExcel();
        System.out.println("Username List: " + UsernameList);
        System.out.println("Password List: " + PasswordList);
        obj.executeTest();
    }
}



