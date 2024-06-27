package com.md.driver;

import com.md.enums.ConfigProperties;
import com.md.utils.PropertyUtils;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.Objects;

public final class Driver {

    private Driver(){}

    public static void initDriver() throws MalformedURLException {
        if(Objects.isNull(DriverManager.getDriver())) {
            WebDriver driver = DriverFactory.get(PropertyUtils.get(ConfigProperties.RUNMODE));
            DriverManager.setDriver(driver);
        }
    }

    public static void quitDriver(){
       if(Objects.nonNull(DriverManager.getDriver())){
           DriverManager.getDriver().quit();
           DriverManager.unload();
       }

    }

}
