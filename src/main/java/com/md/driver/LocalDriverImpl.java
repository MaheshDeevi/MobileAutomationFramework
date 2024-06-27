package com.md.driver;

import com.md.constants.FrameworkConstants;
import com.md.enums.Capabilities;
import com.md.utils.PropertyUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class LocalDriverImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, FrameworkConstants.getInstance().getAPKFILEPATH());
        return new AndroidDriver<>(new URL(PropertyUtils.get(Capabilities.APPIUMSERVERURL)),capabilities);
    }
}
