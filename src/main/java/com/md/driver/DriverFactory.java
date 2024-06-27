package com.md.driver;

import com.md.enums.Modes;
import com.md.exceptions.PropertyFileUsageException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public final class DriverFactory {

    private DriverFactory(){}

    public static WebDriver get(String mode) throws MalformedURLException {
        if(mode.equalsIgnoreCase(String.valueOf(Modes.LOCAL))){
         return new LocalDriverImpl().getDriver();
        }
        else if(mode.equalsIgnoreCase(String.valueOf(Modes.BS))){
            return new BrowserStackImpl().getDriver();
        }
        else{
            throw new PropertyFileUsageException("You are passing invalid value from config.properties file." +
                    "Expected values : ["+Modes.LOCAL+","+Modes.BS+"]");
        }

    }
}
