package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PopupsAndAlerts {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {

        Thread.sleep(5000);
        driver.quit();

    }


    @Test
    public void htmlPopUp(){
    driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");

    //locating and clicking destroy button
       //WebElement destroyButton =  driver.findElement(By.xpath("//*[text() = \"Destroy the World\" ]"));
       //destroyButton.click();

        //locating and clicking destroy button - shorter way
        driver.findElement(By.xpath("//*[text() = \"Destroy the World\" ]")).click();

    }

    @Test
    public void Alerts() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

        //Click for JS Alert
        driver.findElement(By.xpath("//button[1]")).click();
        //Controling the alert using with Alert Class
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        //accept the alert
        alert.accept();
        //Clicking JS Confirm
        driver.findElement(By.xpath("//button[2]")).click();
        //clicking x to close, selecting no/cancel
        Thread.sleep(2000);
        alert.dismiss();

        //clickingvthe JS Prompt
        driver.findElement(By.xpath("//button[3]")).click();
        //sendKeys --> send some keys
        Thread.sleep(2000);
        alert.sendKeys("Mike Smith");
        //when we send the text ,we might not see the text in the inputbox
        Thread.sleep(2000);
        alert.accept();







    }

}
