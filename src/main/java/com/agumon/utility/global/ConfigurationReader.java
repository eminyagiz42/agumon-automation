package com.agumon.utility.global;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.agumon.utility.global.Constants.CONFIGURATION_PATH;


public class ConfigurationReader {

    private static final Logger LOGGER = LogManager.getLogger(ConfigurationReader.class);
    private static final Properties PROPERTIES = new Properties();

    private ConfigurationReader() {
    }

    static {
        try {
            FileInputStream configurationFile = new FileInputStream(CONFIGURATION_PATH);
            PROPERTIES.load(configurationFile);
            configurationFile.close();
        } catch (IOException e) {
            LOGGER.error("Configuration Properties file not found in the ConfigurationReader");
            e.printStackTrace();
        }
    }

    public static String getProperty(final String keyword) {
        return PROPERTIES.getProperty(keyword);
    }
}
