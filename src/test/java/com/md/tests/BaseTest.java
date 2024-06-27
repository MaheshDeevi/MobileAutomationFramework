package com.md.tests;

import com.md.driver.Driver;
import com.md.driver.DriverManager;
import com.md.reports.ExtentReport;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    @BeforeMethod
    public void setUpTest() throws MalformedURLException {
        Driver.initDriver();
    }

    @AfterMethod
    public void tearDownTest(){
        Driver.quitDriver();
    }

}
