package com.cybertek.tests.day4_basic_Locaters;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkText_PartialLinkTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");
        driver.get("http://practice.cybertekschool.com/dynamic_loading");

        WebElement link3 = driver.findElement(By.linkText("Example 3: Element on page that is hidden and become visible after 5 seconds"));
        link3.click();

        driver.navigate().back();

        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink.click();
        driver.navigate().back();
        WebElement link6 = driver.findElement(By.partialLinkText("6"));
        link6.click();


        Thread.sleep(50000);
        driver.quit();
    }

}
