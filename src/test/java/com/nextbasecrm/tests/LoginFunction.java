package com.nextbasecrm.tests;

import com.nextbasecrm.utilities.BrowserUtilities;
import com.nextbasecrm.utilities.ConfigurationReader;
import com.nextbasecrm.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginFunction {
//1TC for login


    //2-write username
    //3-write password
    //4-click login btn

WebDriver driver;
    @BeforeMethod
    public void setUp() {
       driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //1-go to login page
       driver.get(ConfigurationReader.getProperty("env"));

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtilities.sleep(3);
        driver.close();
    }
    //positive scenario
    @Test
    public void login_with_valid_credentials_with_login_btn(){
        //2-write username
       WebElement username= driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
       username.sendKeys(ConfigurationReader.getProperty("username"));
        //3-write password
       WebElement password= driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
       password.sendKeys(ConfigurationReader.getProperty("password"));

        //4-click login btn
        WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtilities.sleep(3);
        loginBtn.click();

        //5.Verify Title
        String expectedTitle="Portal";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);

    }

    //negative scenario
    //valid username, invalid password
    @Test
    public void login_with_valid_Username_invalid_password_with_login_btn(){
        //2-write valid username
        WebElement username= driver.findElement(By.xpath("(//input[@class='login-inp'])[1]"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        //3-write invalid password
        WebElement password= driver.findElement(By.xpath("(//input[@class='login-inp'])[2]"));
        password.sendKeys("abcd");

        //4-click login btn
        WebElement loginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
        BrowserUtilities.sleep(3);
        loginBtn.click();

        //5.Verify error message
        String expectedErrorMessage="Incorrect login or password";
       String actualErrorMessage= driver.findElement(By.xpath("//div[@class=\"errortext\"]")).getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);

    }

}
