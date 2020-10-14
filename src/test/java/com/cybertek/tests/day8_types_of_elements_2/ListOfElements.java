package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        List<WebElement> buttons = driver.findElements(By.tagName("button"));

        System.out.println("buttons.size() = " + buttons.size());

       //Verify that you got 6 webelements
        Assert.assertEquals(buttons.size(),6,"Verify that we got buttons");

        for (WebElement button : buttons) {
            System.out.println(button.getText());

        }
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        //Wrong locator will give error below
        //WebElement button = driver.findElement(By.tagName("BUTTONSASAS"));

        //Wrong locator but we are not getting any error, we are getting empty list
        List<WebElement> buttons = driver.findElements(By.tagName("buttonasasas"));
        System.out.println(buttons.size());
    }


}
