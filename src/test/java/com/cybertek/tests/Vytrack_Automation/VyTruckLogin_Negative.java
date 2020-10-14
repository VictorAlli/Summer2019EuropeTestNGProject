package com.cybertek.tests.Vytrack_Automation;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VyTruckLogin_Negative {

    public static void main(String[] args) {

        /*  * Go to the login pade of Vytruck
         *Enter valid credentials
         * Click login JButton
         * Verify that the system shows error message “Invalid user name or
password.”
         */

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.get("http://qa1.vytrack.com/user/login");

        WebElement inputUsername = driver.findElement(By.id("prependedInput"));

        inputUsername.sendKeys("MikeTyson");

        WebElement inputPassword = driver.findElement(By.id("prependedInput2"));

        inputPassword.sendKeys("Tyson123");

        WebElement loginButton = driver.findElement(By.id("_submit"));

        loginButton.click();



        WebElement messageElement = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/form/fieldset/div[1]/div"));

        String actualMessage = messageElement.getText();
        String expectedMessage = "Invalid user name or password.";

        if(actualMessage.equals(expectedMessage)){
            System.out.println("PASS");

        }else{
            System.out.println("FAIL");
            System.out.println("actualMessage = " + actualMessage);
            System.out.println("expectedMessage = " + expectedMessage);
        }

    }
}
