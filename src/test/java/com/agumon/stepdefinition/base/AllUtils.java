package com.agumon.stepdefinition.base;

import com.agumon.stepdefinition.utils2.SeleniumUtilities;
import com.agumon.stepdefinition.utils2.WaitUtils;
import com.agumon.utility.base.BaseUtils;
import com.agumon.utility.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.agumon.utility.global.Constants.EXPLICIT_ALL_UTILS;

public class AllUtils extends BaseUtils {
    private static final Duration defaultDuration = Duration.ofSeconds(EXPLICIT_ALL_UTILS);

    private final WebDriver driver;
    private WaitUtils waitUtils;
    private SeleniumUtilities seleniumUtilities;
    private WebDriverWait webDriverWait;

    public AllUtils() {
        super(DriverManager.driver());
        this.driver = DriverManager.driver();
    }

    public WaitUtils getWaitUtils() {
        if (waitUtils == null) {
            waitUtils = new WaitUtils(driver, defaultDuration);
        }
        return waitUtils;
    }

    public SeleniumUtilities getSeleniumUtilities() {
        if (seleniumUtilities == null) {
            seleniumUtilities = new SeleniumUtilities(driver, defaultDuration);
        }
        return seleniumUtilities;
    }

    public WebDriverWait geWebDriverWait() {
        if (webDriverWait == null) {
            webDriverWait = new WebDriverWait(driver, defaultDuration);
        }
        return webDriverWait;
    }
}
