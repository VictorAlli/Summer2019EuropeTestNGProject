package com.cybertek.tests.day15_extent_report;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ExtentDemoTest {
    //this class is used for starting and building reports
    ExtentReports report;
    //this class is used to create the HTML report file
    ExtentHtmlReporter htmlReporter;
    //This will define a test,enables adding logs, authors, test steps
    ExtentTest extentLogger;

    @BeforeMethod
    public void setUp(){
        //initialize the class
        report = new ExtentReports();

        //create report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath+"/test-output/report.html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to the report object
        report.attachReporter(htmlReporter);

        //title in the report
        htmlReporter.config().setReportName("Vytrack smoke test");

        //set enviroment information
        report.setSystemInfo("Enviroment", "QA");
        report.setSystemInfo("Browser", "chrome");
        report.setSystemInfo("Tester", "Europe+UK Testers");



    }

    @Test
    public void test1 (){
        //give name to the current test
        extentLogger = report.createTest("TC42 Login As Driver Test");

        //test steps
        extentLogger.info("Open chrome");
        extentLogger.info("go to url");
        extentLogger.info("enter driver info");
        extentLogger.info("click submit");
        extentLogger.info("verify logged in");
        // pass()-->marks the test case is passed
        extentLogger.info("TC42 is passed");

        }

        @AfterMethod
        public void teardown(){
        //this is when the report is actually created
        report.flush();
        }



}
