package com.md.pages;

import com.md.driver.DriverManager;
import com.md.reports.ExtentLogger;
import io.appium.java_client.MobileBy;

public class BasePage {

    protected BasePage(){}

     static void click(String menu){
        DriverManager.getDriver().findElement(new MobileBy.ByAccessibilityId(menu)).click();
         ExtentLogger.pass(menu+" is clicked");
    }
}
