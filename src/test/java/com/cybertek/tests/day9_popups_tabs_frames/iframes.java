package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class iframes {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");

        //How to switch frames
        //1. switch by using name id or attribute of iframe
        driver.switchTo().frame("mce_0_ifr");
        //clear the text inside the box
        driver.findElement(By.id("tinymce")).clear();
        //locate and send some keys
        driver.findElement(By.id("tinymce")).sendKeys("Mike Smith");

        //go back to first frame, useful when we have switched multiple frames
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        //2.Using Index
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("Victor Allison");

        //go back to first frame, only to parent frame
        driver.switchTo().parentFrame();

        //3. Using the WebElement

        WebElement frameElement = driver.findElement(By.tagName("iframe"));

        //passing frame as a WebElement
        driver.switchTo().frame(frameElement);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("We located with WebElement");


    }


    @Test
    public void multipleFrames(){
        driver.get("http://practice.cybertekschool.com/nested_frames");

        //switching to frame top
        driver.switchTo().frame("frame-top");
        //frmae top has 3 chilkdren frame, left ,middle, right
        //switching to frame middle
        driver.switchTo().frame("frame-middle");
        //get the middle text and print
        System.out.println(driver.findElement(By.id("content")).getText());

        //go back to parent (top frame) to switch right
        driver.switchTo().parentFrame();

        //switching right using the index number
        driver.switchTo().frame(2);

        //print the text right from the right frame
        System.out.println(driver.findElement(By.tagName("body")).getText());

        //go up to top level html directly
        driver.switchTo().defaultContent();

        //switch to frame bottom
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.tagName("body")));


    }
}
