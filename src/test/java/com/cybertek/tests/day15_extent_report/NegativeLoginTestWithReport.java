package com.cybertek.tests.day15_extent_report;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {
    @Test
    public void wrongPasswordTest(){

        //name of the test report

        extentLogger = report.createTest("Wrong Password Test");


        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username : user1 ");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password : somepassword ");

        loginPage.loginBtn.click();
        extentLogger.info("Click Login Button");

        extentLogger.info("Verify page url");
        //to fail the test
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");

        extentLogger.info("PASS : Wrong Password Test");
    }

    @Test
    public void wrongUsernameTest(){
        //name of the test report
        extentLogger = report.createTest("Wrong Username Test");


        LoginPage loginPage = new LoginPage();

        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter username : user1 ");

        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Enter password : somepassword");

        loginPage.loginBtn.click();
        extentLogger.info("Click Login Button");

        extentLogger.info("Verify page url");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa3.vytrack.com/user/login");
        extentLogger.info("PASS : Wrong Username Test");}

}
