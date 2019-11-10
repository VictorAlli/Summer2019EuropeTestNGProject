package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

        //setting up the driver
        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();


        //import class CMD+ENTER or ALT+ENTER
        //selenium object
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

        //navigate to website
        driver.get("https://www.google.com");

        Thread.sleep(5000);

        //another way of opening website
        driver.navigate().to("https://www.facebook.com");

        //goes back to previous webpage
        driver.navigate().back();

        Thread.sleep(3000);

        //goes back to
        driver.navigate().forward();

        //refresh the webpage
        driver.navigate().refresh();


    }

}
