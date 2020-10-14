package com.cybertek.tests.day11_actions_jsexecuter;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoverTest {
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

    //hover over each image in the website
    //verify each name :user text is displayed

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/hovers");

        WebElement img = driver.findElement(By.tagName("img"));
        //creating actions object
        Actions actions = new Actions(driver);

        actions.moveToElement(img).perform();

        WebElement text = driver.findElement(By.xpath("//h5[.='name: user1']"));

        Assert.assertTrue(text.isDisplayed());
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");

        for (int i = 1; i < 4; i++) {

            //creating dynamic xpath using ,
            String imageXpath = "(//img)["+i+"]";
            System.out.println("imageXpath = " + imageXpath);
            //passing xpath to webelement
            WebElement img = driver.findElement(By.xpath(imageXpath));
            //creating actions object
            Actions actions = new Actions(driver);
            Thread.sleep(1000);
            actions.moveToElement(img).perform();
            //creating dynamic xpath for the text
            String textXpath = "//h5[.='name: user"+i+"']";
            System.out.println("textXpath = " + textXpath);
            //passing xpath to webelement
            WebElement text = driver.findElement(By.xpath(textXpath));
            //verifying text is displayed
            Assert.assertTrue(text.isDisplayed());
        }



    }
    @Test
    public void StaleTest(){
        driver.get("https://google.com");
        WebElement input = driver.findElement(By.name("q"));
        input.sendKeys("Selenium"+ Keys.ENTER);

        WebElement results = driver.findElement(By.id("resultStats"));
        Assert.assertTrue(results.isDisplayed());

        //go to google second time
        driver.navigate().back();
        //locate the element again
        input = driver.findElement(By.name("q"));
        input.sendKeys("Java"+Keys.ENTER);

    }
}
