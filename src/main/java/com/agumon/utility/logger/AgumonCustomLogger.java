package com.agumon.utility.logger;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.BufferedReader;
import java.io.FileReader;

import static com.agumon.utility.global.Constants.*;


public class AgumonCustomLogger {

    private static final Logger LOGGER = LogManager.getLogger(AgumonCustomLogger.class);

    private AgumonCustomLogger() {
    }

    public static synchronized void printBanner() {
        try (BufferedReader br = new BufferedReader(new FileReader(BANNER_PATH))){
            StringBuilder builder = new StringBuilder();
            String st;
            while ((st = br.readLine()) != null) {
                builder.append(st + "\n");
            }
            LOGGER.info("\n\n" + builder);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        LOGGER.info("\n" + ENVIRONMENT_KEY + BASE_URL + BROWSER_KEY + BROWSER.toUpperCase() + "\n");
    }

}