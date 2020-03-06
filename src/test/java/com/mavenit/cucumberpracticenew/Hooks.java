package com.mavenit.cucumberpracticenew;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import driver.DriverManager;

public class Hooks{
    private DriverManager driverManager=new DriverManager();
    @Before
    public void setUp(){
        driverManager.openBrowser();
        driverManager.maxBrowser();
        driverManager.navigateTo("https://www.argos.co.uk/");
        driverManager.applyImplicitWait();
    }
   // @After
    //public void tearDown(){
       // driverManager.closeBrowser();
    //}

}
