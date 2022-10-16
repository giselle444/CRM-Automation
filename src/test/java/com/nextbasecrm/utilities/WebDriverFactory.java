package com.nextbasecrm.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    // TASK: NEW METHOD CREATION
// Method name : getDriver


// Static method
// Accepts String arg: browserType
//   - This arg will determine what type of browser is opened
//   - if "chrome" passed --> it will open chrome browser
//   - if "firefox" passed --> it will open firefox browser
// RETURN TYPE: "WebDriver"

    public static WebDriver getDriver(String browserName){
      //  WebDriver driver;
      //  if (browserType.equalsIgnoreCase("chrome")){
    //        WebDriverManager.chromedriver().setup();
     //       return new ChromeDriver();
     //   }else if(browserType.equalsIgnoreCase("safari")){
      //      WebDriverManager.safaridriver().setup();
      //      return new SafariDriver();
     //   }else{
       //     System.out.println("Given browser type doesn't exist/ or not currently supported ");
     //       return null;
     //   }
      //  driver.manage().window().maximize();
      //  return driver;

        WebDriver driver;
        switch (browserName.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver= new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver= new FirefoxDriver();
            default:
                System.out.println("Unknown Browser type" + browserName);
                driver=null;
        }
        driver.manage().window().maximize();
        return driver;

    }


    }

