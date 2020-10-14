package com.cybertek.tests.day4_basic_Locaters;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NameLocaterTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = WebDriverFactory.getDriver("firefox");

        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/sign_up");

        WebElement fullnameInput = driver.findElement(By.name("full_name"));

        fullnameInput.sendKeys("Mike Smith");

        WebElement emailAddress = driver.findElement(By.name("email"));

        emailAddress.sendKeys("allisonvictor19@gmail.com");

        WebElement signupButton = driver.findElement(By.name("wooden_spoon"));

        signupButton.click();

        //task
        //verify that you got "Thank you for signing up. Click the button to return
        WebElement message = driver.findElement(By.name("signup_message"));
        String actualMessage = message.getText();
        String expectedMessage = "Thank you for signing up. Click the button below to return to the home page.";

        if(expectedMessage.equals(actualMessage)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("expectedMessage = "+ expectedMessage);
            System.out.println("actualMessage = " + actualMessage);
        }

        Thread.sleep(5000);

        driver.quit();



    }
}
