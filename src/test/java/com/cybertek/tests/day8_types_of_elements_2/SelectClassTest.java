package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //locate the dropdown element with unique locator
        //WebElement dropdownElement = driver.findElement(By.id("state"));

        //Select class is only works with select tag
        Select stateList = new Select(driver.findElement(By.id("state")));

        //getOptions()--> returns all available options from the dropdown list
        List<WebElement> options = stateList.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());
        }

    }

    @Test
    public void test2() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        //locate the dropdown element with unique locator
        WebElement dropdownElement = driver.findElement(By.id("state"));

        //Create Select object by passing the element as a constructor
        Select stateList = new Select(dropdownElement);

        //Verify that first option is "Select a State"
        String expectedOption = "Select a State";
        String actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        Assert.assertEquals(actualOption,expectedOption,"Verify that first selection is Select a State ");


        //HOW TO SELECT OPTIONS FROM THE DROPDOWN
        //1.USING VISIBLE TEXT
        Thread.sleep(3000);
        //Selecting "Texas" from the list
        stateList.selectByVisibleText("Texas");

        actualOption = stateList.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,"Texas");

        //2.USING INDEX NUMBER
        //total option -->52
        
        Thread.sleep(3000);
        stateList.selectByIndex(51);
        actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        Assert.assertEquals(actualOption,"Wyoming");

        //3.USING VALUE
        Thread.sleep(3000);
        stateList.selectByValue("VA");
        actualOption = stateList.getFirstSelectedOption().getText();
        System.out.println(actualOption);
        Assert.assertEquals(actualOption,"Virginia");








    }



}
