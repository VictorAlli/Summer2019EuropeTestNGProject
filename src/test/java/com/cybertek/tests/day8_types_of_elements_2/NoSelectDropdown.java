package com.cybertek.tests.day8_types_of_elements_2;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class NoSelectDropdown {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdownMenuLink"));

        //If the dropsdown is a non-select then it gives an error:
        //UnexpectedTagNameException: Element should have been "select" but was "a"
        //Select links = new Select(dropdownElement);

        //open the dropdown
        dropdownElement.click();

        driver.findElements(By.className("dropdown-item"));

        List<WebElement> listofLinks =  driver.findElements(By.className("dropdown-item"));

        System.out.println("Number of links = "+ listofLinks.size());


        //text of first element in the list

        System.out.println(listofLinks.get(0).getText());


        //print text of each link

        for (WebElement link : listofLinks) {

            System.out.println(link.getText());

        }

        //locate the element and click it
        // driver.findElement(By.linkText("Yahoo")).click();

        //use index number and click
        listofLinks.get(2).click();


    }
}
