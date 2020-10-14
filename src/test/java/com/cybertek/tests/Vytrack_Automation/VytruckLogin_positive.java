package com.cybertek.tests.Vytrack_Automation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class VytruckLogin_positive {

    public static void main(String[] args) throws InterruptedException {
      /*  * Go to the login pade of Vytruck
         *Enter valid credentials
         * Click login JButton
        * Verify that the user login succesfully
    */

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.get("http://qa1.vytrack.com/user/login");

        WebElement inputUsername = driver.findElement(By.id("prependedInput"));

        inputUsername.sendKeys("user24");

        WebElement inputPassword = driver.findElement(By.id("prependedInput2"));

        inputPassword.sendKeys("UserUser123");

        WebElement loginButton = driver.findElement(By.id("_submit"));

        loginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://qa1.vytrack.com/";

        if(actualUrl.equals(expectedUrl)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actualUrl = " + actualUrl);
            System.out.println("expectedUrl = " + expectedUrl);
        }

        Thread.sleep(10000);

        driver.quit();


    }

}
