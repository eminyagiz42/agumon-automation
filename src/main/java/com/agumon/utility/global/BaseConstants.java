package com.agumon.utility.global;


import static com.agumon.utility.global.Constants.*;

public class BaseConstants {

    protected BaseConstants() {
    }

    protected static String getProperty(final String path) {
        return ConfigurationReader.getProperty(path);
    }

    protected static boolean parseBool(final String path) {
        return Boolean.parseBoolean(getProperty(path));
    }

    protected static String slash(final String baseUrl) {
        return removeEndingSlash(baseUrl);
    }

    public static String removeEndingSlash(final String str) {
        if (str.endsWith("/")) {
            return str.substring(0, str.length() - 1);
        }
        return str;
    }

    protected static String getBaseURLWithAuthentication() {
        return String.format(AUTH_PATTERN, AUTH_USERNAME, AUTH_PASSWORD, BASE_URL.replace(URL_PREFIX, ""));
    }

}
