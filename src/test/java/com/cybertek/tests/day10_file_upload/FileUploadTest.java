package com.cybertek.tests.day10_file_upload;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUploadTest {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(10000);
        driver.quit();

    }

    /*
    * go to the website "http://practice.cybertekschool.com/upload"
    * upload file.txt
    * verify filename is displayed in the page
    *
    * */
    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/upload");

        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/testfile.txt";
        String filePath = projectPath+"/"+relativePath;

        //file path unique for each computer
        driver.findElement(By.id("file-upload")).sendKeys(filePath);
        //clicking upload button
        driver.findElement(By.id("file-submit")).click();

        String expectedResult = "testfile.txt";
        //gettind text of webelement
        String actualResult = driver.findElement(By.id("uploaded-files")).getText();

        System.out.println("actualResult = " + actualResult);

        Assert.assertEquals(actualResult, expectedResult,"Verify the file name");


    }
}
