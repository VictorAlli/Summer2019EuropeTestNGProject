package com.cybertek.tests.day2_webdriver_basics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class getUrlAndTitle {

    public static void main(String[] args) {

        //WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();

        //WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://practice.cybertekschool.com");

        // getTitle()-->get the title of the page
        String title = driver.getTitle();
        //soutv
        System.out.println("title = " + title);

        //getCurrwntUrl()--> get the current url of the page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);

        //getPageSource()--> get source code of the page
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);



    }
}
