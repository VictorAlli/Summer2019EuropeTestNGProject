package com.cybertek.tests.day9_popups_tabs_frames;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class MultipleWindows {
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
    public void switchWindowsTest(){
        driver.get("http://practice.cybertekschool.com/windows");

        System.out.println("Before clicking the link :");
        System.out.println(driver.getTitle());


        //clicking click here link
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println("After clicking the link :");
        System.out.println(driver.getTitle());

       //code for switching windows, we have to pass handle
        //driver.switchTo().window()

       String currentWindowsHandle =  driver.getWindowHandle();
        System.out.println("currentWindowsHandle = " + currentWindowsHandle);

        //after this line, our purpose is switching to new window

        //Set is just like ArrayList but without duplicate values
        Set<String> windowsHandles = driver.getWindowHandles();

        //how many different handles set is keeping
        System.out.println("windowsHandles.size() = " + windowsHandles.size());

        //Our problem is how can wwe get new window hamdle from set of handles.There is no index
        //loop through all handles inside the Set of handles
        for (String handle : windowsHandles) {
            //checking handle is not equal to current page
            if(!currentWindowsHandle.equals(handle)){

                System.out.println("handle = " + handle);
                //switching to new window
                driver.switchTo().window(handle);
            }

        }

        System.out.println("After switching :"+driver.getTitle());

    }

    @Test
    public void moreThan2Windows(){
        driver.get("http://practice.cybertekschool.com/windows");

        String targetWindowTitle = "New Window";

        driver.findElement(By.linkText("Click Here")).click();

        //check how many windows we have
        System.out.println(driver.getWindowHandles().size());

        Set<String> windowsHandles = driver.getWindowHandles();

        //we will keep switching windowsuntil our title equals to targetWindowTitle.

        for (String Handle : windowsHandles) {

            //switch them one by one

            driver.switchTo().window(Handle);
            //checking if the current title is equal to target windows title
            if(driver.getTitle().equals(targetWindowTitle)){
                //if they are equal stop looping. i want to keep that window
                break;
            }

        }

        System.out.println("After loop title is = " + driver.getTitle());

    }

}
