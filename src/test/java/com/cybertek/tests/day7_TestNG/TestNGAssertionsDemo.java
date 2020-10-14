package com.cybertek.tests.day7_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGAssertionsDemo {


    @Test
    public void test1(){
        System.out.println("First Assertion");
        Assert.assertEquals(25, 25);

        System.out.println("Second Assertion");
        Assert.assertEquals("title", "title");
    }

    @Test
    public void test2(){
        //verify that title starts with C
        String actualTitle = "Cybertek";
        String expectedTitleBeginning = "B";

        System.out.println("First Assertion");
        Assert.assertTrue(actualTitle.startsWith(expectedTitleBeginning),"Verify title starts with C");
    }

    @Test
    public void test3(){
        String email="victorallison19@gmail.com";
        Assert.assertTrue(email.contains("@"),"Verify that email contains @");

        Assert.assertNotEquals("one","two");
    }

    @Test
    public void test4(){
        Assert.assertFalse(1<0);
    }

}
