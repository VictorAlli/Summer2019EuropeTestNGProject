package com.cybertek.tests.day16_review;



import com.cybertek.pages.*;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class verifyContactInfoTests extends TestBase {
/*
* open the chrome
* go to qa3.vytrack
* login as a sales manager
* navigate to costumers -> contacts
* click on email mbrakstone99@example.com
* verify that full name is Ms Mariam Brackstone
* verify that email is mbrakstone99@example.com
* verify that phone number is +18982323434 */

    @Test
    public void contactDetailsTest(){

        extentLogger = report.createTest("contactDetailsTest");

        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        extentLogger.info("username :" +username);
        extentLogger.info("password :" +password);
        extentLogger.info("Login as a sales manager");

        loginPage.login(username,password);

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);
        extentLogger.info("Navigate to Customers -- Contacts Page");

        contactsPage.navigateToModule("Customers", "Contacts");

        contactsPage.waitUntilLoaderScreenDisappear();
        BrowserUtils.waitFor(5);

        extentLogger.info("Click on mbrackstone9@example.com email");
        contactsPage.getContactEmail("mbrackstone9@example.com").click();

        ContactInfoPage contactInfoPage = new ContactInfoPage();

        String actualFullname = contactInfoPage.fullName.getText();
        String expectedFullname = "Mariam Brackstone";

        extentLogger.info("Verify full name is "+expectedFullname);
        Assert.assertEquals(actualFullname,expectedFullname,"Verify fullnames");

        String actualEmail = contactInfoPage.email.getText();
        Assert.assertEquals(actualEmail,"mbrackstone9@example.com");

        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434");


    }

}
