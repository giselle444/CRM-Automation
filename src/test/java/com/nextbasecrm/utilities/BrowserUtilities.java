package com.nextbasecrm.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class BrowserUtilities {
    //Methods are static bc we do not want to create an object to call this methods.
    // We just want to call those methods with class name. That is why they are static type

    /*
    This method is used to pause the code for given seconds
    *It is static method we can call with class name
    BrowserUtils.sleep(3);

     */

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 10000);
        }catch (InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception occurred in sleep method");
        }

    }
    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(WebDriver driver, String expectedTitle) {
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        

    }

    }
