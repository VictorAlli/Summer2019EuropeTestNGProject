package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class verifyURLnotchanged {
    /* •	open browser
    •	go to http://practice.cybertekschool.com/forgot_password .Harici bir siteye bağlantılar.
    •	click on Retrieve password
    •	verify that url did not change
    */
    public static void main(String[] args) throws InterruptedException {

       //open browser
        WebDriver driver = WebDriverFactory.getDriver("firefox");

        //go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //save url to string variable
        String expectedUrl = driver.getCurrentUrl();

        //click on Retrieve password
        WebElement retrievePasswordButton = driver.findElement(By.id("form_submit"));

        //click()-->clicking the web element
        retrievePasswordButton.click();

        String actualUrl = driver.getCurrentUrl();

        //verify that url is not change

        if(expectedUrl.equals(actualUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
        }


        Thread.sleep(30000);
        //close the browser
        driver.close();



    }
}
