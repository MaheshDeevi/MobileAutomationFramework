package com.md.utils;

import com.md.constants.FrameworkConstants;
import com.md.enums.Capabilities;
import com.md.enums.ConfigProperties;
import com.md.exceptions.PropertyFileUsageException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){}

    private static final Properties PROPERTIES = new Properties();
    private static final Map<String,String> CONFIGMAP = new HashMap<>();

    static {
        String[] configFilePaths = FrameworkConstants.getInstance().getCONFIGFILEPATHS();

        for (String configFilePath : configFilePaths) {
            try (FileInputStream fis = new FileInputStream(configFilePath)) {
                PROPERTIES.load(fis);
                PROPERTIES.forEach((key, value) -> CONFIGMAP.put(key.toString(), value.toString().trim()));
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0); // Graceful termination
            }
        }
    }


    public static String get(Enum key) {
        String lowercaseKey = key.toString().toLowerCase();

        if (!CONFIGMAP.containsKey(lowercaseKey)) {
            throw new PropertyFileUsageException("Expected Key: " + lowercaseKey +
                    " not found in config.properties or capabilities.properties file.");
        }

        String value = CONFIGMAP.get(lowercaseKey);

        // Optional: Null check
        if (value == null) {
            throw new PropertyFileUsageException("Value for key " + lowercaseKey + " is null.");
        }

        return value;
    }


}
