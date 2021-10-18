package com.cydeo.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class Driver {

    private static WebDriver object;

    private Driver(){    }

    public static WebDriver getDriver(){
    // read the browser you want to launch from properties file
        String browserName = ConfigReader.read("browser");

        if (object==null){
            //according to browser type setup driver correctly

            switch (browserName.trim().toLowerCase(Locale.ROOT) ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    object = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    object = new FirefoxDriver();
                    break;
                default:
                    System.err.println("UNKNOWN BROWSER TYPE " + browserName);
                    object = null ;
            }
            return object;
        }else{
            //System.out.println("The driver was created");
            return object;
        }
    }

    /*
     * Quitting the browser and setting the value of
     * WebDriver instance to null because you can re-use already quitted driver
     */
    public static void closeBrowser(){
        //check if we have WebDriver instance or not
        // basically checking if obj is null or not
        // if not null
        // quit the browser
        // make it null , because once quit it can not be used
        if(object != null ){
            object.quit();
            // so when ask for it again , it gives us not quited fresh driver
            object = null ;
        }



    }

}
