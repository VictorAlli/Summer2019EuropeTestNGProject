package com.cybertek.tests.day14_pom_tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageSubtitleTest extends TestBase {
    /* Test CAse
    Open Browser
    Login As Driver
    VErify that pagesubtitle is quick launchpad
    go to activities-> Calender events
    verify that sybtitle is Calender Events

    */

    @Test
    public void verifySubtitleTest(){
        LoginPage loginpage = new LoginPage();

        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        loginpage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();

        String expectedSubtitle = "Quick Launchpad";
        String actualsubTitle = dashboardPage.getPageSubTitle();


        Assert.assertEquals(actualsubTitle, expectedSubtitle, "Verify Subtitles");

        dashboardPage.navigateToModule("Activities", "Calendar Events");

        //if you switch to a new page you should create an object belongs to that page

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events");


    }

}
