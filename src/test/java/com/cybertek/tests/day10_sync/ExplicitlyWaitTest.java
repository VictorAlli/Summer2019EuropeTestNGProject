package com.cybertek.tests.day10_sync;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitlyWaitTest {
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

    @Test
    public void test1() {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        driver.findElement(By.tagName("button")).click();

        WebElement userInput =   driver.findElement(By.id("username"));

        //HOW TO WAIT EXPLICITLY?
        //Create Explicit wait object
        WebDriverWait wait = new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOf(userInput));

        userInput.sendKeys("Mike Smith");

    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_controls");

        //click enable
        driver.findElement(By.xpath("//button[ contains(text(), \"Enable\")]")).click();

        //find the inputbox
        WebElement inputBox = driver.findElement(By.cssSelector("input[type = 'text']"));

        //wait until inputBox is enabled or clickable
        //create to object to wait
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(inputBox));

        //type something in the inputBox
        inputBox.sendKeys("Something something");
    }
}
