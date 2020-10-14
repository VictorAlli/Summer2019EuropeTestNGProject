package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //WebElement homeLink = driver.findElement(By.xpath("/html/body/nav/ul/li/a"));
        //homeLink.click();

        WebElement button1 = driver.findElement(By.xpath("//button[@*='button1()']"));
        //WebElement button1 = driver.findElement(By.xpath("//button[@onclick='button1()']"));
        //WebElement button1 = driver.findElement(By.xpath("//*[@onclick='button1()']"));
        button1.click();



        Thread.sleep(20000);
        driver.quit();
    }
}
