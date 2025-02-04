package com.agumon.utility.global;


public class Constants extends BaseConstants {

    public static final String BROWSER = getProperty("agumon.test.browser");

    //ENVIRONMENT VARIABLES
    public static final String USERNAME = getProperty("agumon-uat.account.username");
    public static final String PASSWORD = getProperty("agumon-uat.account.password");
    public static final String ACCOUNT_MENU_NAME = getProperty("agumon-uat.account.menu.verification.name");
    public static final String AUTH_USERNAME = getProperty("agumon-uat.authentication.via.url.username");
    public static final String AUTH_PASSWORD = getProperty("agumon-uat.authentication.via.url.password");
    public static final String BACKOFFICE_USERNAME = getProperty("agumon-uat.backoffice.username");
    public static final String BACKOFFICE_PASSWORD = getProperty("agumon-uat.backoffice.password");

    //FLAGS
    public static final Boolean REDIRECTS_LOGIN_FLAG = parseBool("agumon-uat.home.redirects.to.login");
    public static final Boolean BROWSER_HEADLESS_FLAG = parseBool("agumon.test.browser.headless");
    public static final Boolean SEND_EMAIL_FLAG = parseBool("agumon.test.send.grid.email");
    public static final Boolean SCREENSHOT_FLAG = parseBool("agumon.test.capture.screenshot");

    //SELENIUM GRID
    public static final String SELENIUM_PORT = getProperty("selenium.grid.port");

    //TIMEOUTS
    public static final long PAGE_LOAD_TIMEOUT = Long.parseLong(getProperty("wait.page.load.driver.timeout"));
    public static final long DRIVER_IMPLICIT_WAIT_SEC = Long.parseLong(getProperty("wait.implicit.driver.timeout"));
    public static final long SCRIPT_TIMEOUT = Long.parseLong(getProperty("wait.script.driver.timeout"));
    public static final long EXPLICIT_ALL_UTILS = Long.parseLong(getProperty("wait.explicit.all.utils.timeout"));

    //URLS
    public static final String BASE_URL = slash(getProperty("agumon-uat.base.url"));
    public static final String BASE_URL_WITH_AUTH = getBaseURLWithAuthentication();
    public static final String BILLING_URL = BASE_URL.concat("/billing");
    public static final String BACKOFFICE_URL = BASE_URL.concat("/backoffice/login");
    public static final String CART_URL = BASE_URL.concat("/cart");
    public static final String CART2_URL = BASE_URL.concat("/cart2"); //TODO LOOKS NOT EXIST ANYMORE ?
    public static final String FORGOT_PASSWORD_URL = BASE_URL.concat("/forgot-password");
    public static final String LOGIN_URL = BASE_URL.concat("/login");
    public static final String NOT_FOUND_URL = BASE_URL.concat("/not-found");
    public static final String ORDERS_URL = BASE_URL.concat("/orders");
    public static final String PAYMENTS_URL = BASE_URL.concat("/payment");
    public static final String PRODUCT_LISTING_URL = BASE_URL.concat("/products2");
    public static final String CHANGE_PASSWORD_URL = BASE_URL.concat("/profile#change-password");
    public static final String USER_INVITE_URL = BASE_URL.concat("/profile#user-invite");
    public static final String MY_LIST_URL = BASE_URL.concat("/profile#my-list");
    public static final String QUOTES_URL = BASE_URL.concat("/quotes");
    public static final String REQUEST_ACCOUNT_URL = BASE_URL.concat("/request-account");
    public static final String UPDATE_PASSWORD_URL = BASE_URL.concat("/update-password");
    public static final String PAGE_404_URL = BASE_URL.concat("/404");

	//File Paths
	public static final String CONFIGURATION_PATH = "src/main/resources/configuration.properties";
	public static final String BANNER_PATH = "src/main/resources/banner/agumon-banner.txt";
	public static final String PROFILE_LOGO_FILE_PATH = "src/main/resources/files/Cirrus_Logo.png";
	public static final String PROFILE_GIF_LOGO_FILE_PATH = "src/main/resources/files/example.gif";
	public static final String PROFILE_LOGO_FILE_PATH2 = "src/main/resources/files/agumon_logo.png";

	//CONSTANTS
    public static final String TAG_SKIP = "@skip";
    public static final String AUTH_PATTERN = "https://%s:%s@%s";
    public static final String URL_PREFIX = "https://";
    public static final String BY_LINK_TEXT_LOGIN = "LOGIN";
    public static final String DEMO_STOREFRONT = "demo-storefront";
    public static final String HEADLESS = "--headless";
    public static final String REMOTE_ALLOW_ORIGINS = "--remote-allow-origins=*";
    public static final String MEDIA_TYPE = "image/png";
    public static final String FIREFOX = "firefox";
    public static final String CHROME = "chrome";
    public static final String EDGE = "edge";
    public static final String IE = "ie";
    public static final String SAFARI = "safari";
    public static final String SHIP_TOS_COLUMN_NAME = "Available Ship-To’S";
    public static final String ADMIN_ACCOUNT_NAME = "SUPER";
    public static final String SUCCESS = "success";
	public static final String ENVIRONMENT_KEY = "ENVIRONMENT: ";
	public static final String BROWSER_KEY = " - BROWSER: ";






}
