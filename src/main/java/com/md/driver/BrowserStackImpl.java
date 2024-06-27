package com.md.driver;

import com.md.enums.Capabilities;
import com.md.utils.PropertyUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackImpl implements IDriver{
    @Override
    public WebDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", PropertyUtils.get(Capabilities.BSUSER));
        capabilities.setCapability("browserstack.key", PropertyUtils.get(Capabilities.BSKEY));
        capabilities.setCapability("os_version", PropertyUtils.get(Capabilities.OSVERSION));
        capabilities.setCapability("device", PropertyUtils.get(Capabilities.DEVICE));
        capabilities.setCapability("app", PropertyUtils.get(Capabilities.APP));

        return new AndroidDriver<>(new URL(PropertyUtils.get(Capabilities.BSUSER)),capabilities);

    }
}
