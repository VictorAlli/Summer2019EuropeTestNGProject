package com.cybertek.tests.day5_xpath;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        Thread.sleep(15000);

        WebElement searchBox = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));

        searchBox.sendKeys("Selenium");
        Thread.sleep(3000);

        WebElement searchElement = driver.findElement(By.xpath("//input[@value = 'Go']"));

        searchElement.click();

        Thread.sleep(5000);

        WebElement searchResult = driver.findElement(By.xpath("//span[contains(text(),'results for')]"));

        System.out.println("searchResult = " + searchResult.getText());

        Thread.sleep(10000);

        driver.quit();



    }




}
