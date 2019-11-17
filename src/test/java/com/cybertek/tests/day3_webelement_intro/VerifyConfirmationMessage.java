package com.cybertek.tests.day3_webelement_intro;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerifyConfirmationMessage {
    /***•	open browser
     * •	go to http://practice.cybertekschool.com/forgot_passwordHarici bir siteye bağlantılar.
     * •	enter any email
     * •	verify that email is displayed in the input box
     * •	click on Retrieve password
     * •	verify that confirmation message says 'Your e-mail's been sent!'
     *
     */
    public static void main(String[] args) throws InterruptedException {

        //WebDriver driver = WebDriverFactory.getDriver("firefox");
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebElement emailInputBox = driver.findElement(By.name("email"));

        String expectedEmail= "test@gmail.com";
        //send expected email
        emailInputBox.sendKeys(expectedEmail);
        
        //verify that email is displayed in the input box
        //getting text from webelements
        //getText()-->get text from webelement %99
        //getAttribute()--> get value of attributea
        String actualEmail = emailInputBox.getAttribute("value");
        
        if (expectedEmail.equals(actualEmail)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("expectedUrl = " + expectedEmail);
            System.out.println("actualEmail = " + actualEmail);
        }

        //locating retrievePassword using id attribute
        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //verify that confirmation message says 'Your e-mail's been sent!'
        String expectedMessage = "Your e-mail's been sent!";

        WebElement confirmationMessage = driver.findElement(By.name("confirmation_message"));

        String actualMessage = confirmationMessage.getText();
        System.out.println(actualMessage);


           if(expectedMessage.equals(actualMessage)){
                System.out.println("PASS");
            }else{
                System.out.println("FAIL");
                System.out.println("Expected Message = "+expectedMessage);
                System.out.println("Actual Message = " + actualMessage);
            }

            Thread.sleep(30000);

            driver.quit();

        }
    }

