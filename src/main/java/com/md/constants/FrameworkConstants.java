package com.md.constants;

import lombok.Getter;

import java.util.Objects;


@Getter
public final class FrameworkConstants {

    private FrameworkConstants(){}

    /**
     * Singleton Pattern
     */
    private static FrameworkConstants frameWorkConstants;
    public static FrameworkConstants getInstance(){
        if(Objects.isNull(frameWorkConstants)){
            frameWorkConstants = new FrameworkConstants();
        }
        return frameWorkConstants;
    }


    private static final String USERDIRPATH = System.getProperty("user.dir");

    private final String APKFILEPATH = USERDIRPATH+"/src/test/resources/apkfiles/ApiDemos-debug.apk";
    private final String[] CONFIGFILEPATHS = new String[]{USERDIRPATH + "/src/test/resources/config/config.properties"
                                                ,USERDIRPATH+"/src/main/resources/config/capabilities.properties"};
}
