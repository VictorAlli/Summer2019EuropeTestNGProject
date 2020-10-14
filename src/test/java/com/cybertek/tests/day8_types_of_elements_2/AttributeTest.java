package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AttributeTest {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        WebElement radioButton = driver.findElement(By.id("blue"));

        //get the name of name attribute
        System.out.println(radioButton.getAttribute("name"));

        //get the name of id attribute
        System.out.println(radioButton.getAttribute("id"));

        //get the name of type attribute
        System.out.println(radioButton.getAttribute("type"));

        //trying to get attribute does not exist
        //when we use non existing attribute it will return NULL to us.
        System.out.println(radioButton.getAttribute("href"));

        //attribute without value (checked)
        //checked attribute value is boolean if it is checked it will return true
        System.out.println(radioButton.getAttribute("checked"));

        //"outerHTML" returns full HTML of that element
        System.out.println(radioButton.getAttribute("outerHTML"));

        //third way of getting text "innerHTML" (in certain cases not in radio buttons because there is no text in Radio buttons)
        System.out.println(radioButton.getAttribute("innerHTML"));
        System.out.println(radioButton.getAttribute("value"));

        System.out.println(radioButton.isDisplayed());
    }
}
