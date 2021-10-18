package com.cydeo.utility;

import org.openqa.selenium.By;

public class WebOrderUtil {


    public static void openWebOrderApp(){

        com.cydeo.utility.Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx") ;

    }

    /*
     * A method for logging into Web Order practice site from login page
     */

    public static void login(){
        // enter username
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        // enter password
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_password")) .sendKeys("test");
        // click login
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    public static void login(String username, String password){
        // enter username
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(username);
        // enter password
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_password")) .sendKeys(password);
        // click login
        com.cydeo.utility.Driver.getDriver().findElement(By.id("ctl00_MainContent_login_button")).click();
    }

    /*
     * Check for login error message is visible or not , by calling the BrowserUtil method we created
     * @return true if error message displayed , false if not
     */
        public static boolean loginErrorMsgVisible(){

            boolean elementFound =
                    com.cydeo.utility.BrowserUtil.checkVisibilityOfElement(By.xpath("//span[. ='Invalid Login or Password.']"),2);
            return elementFound ;
        }



}
