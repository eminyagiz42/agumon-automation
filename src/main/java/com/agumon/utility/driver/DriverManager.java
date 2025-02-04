package com.agumon.utility.driver;

import com.agumon.utility.enums.BrowserEnum;
import com.agumon.utility.exceptions.BrowserNotImplemented;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.agumon.utility.global.Constants.*;


public class DriverManager {

    protected DriverManager() {
    }

    private static WebDriver driver;

    public static void start() throws Exception {
        driver = DriverFactory.setup(getBrowserEnum());
    }

    public static WebDriver driver() {
        return driver;
    }

    public static void shutdown() {
        driver.close();
    }

    public static void captureScreenshot(final Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, MEDIA_TYPE, scenario.getName());
    }

    public static BrowserEnum getBrowserEnum() {
        String browserName = BROWSER;
        if (browserName == null || browserName.equals(FIREFOX)) {
            return BrowserEnum.FIREFOX;
        } else if (browserName.equalsIgnoreCase(CHROME)) {
            return BrowserEnum.CHROME;
        } else if (browserName.equals(EDGE)) {
            return BrowserEnum.EDGE;
        } else if (browserName.equals(IE)) {
            return BrowserEnum.IE;
        } else if (browserName.equals(SAFARI)) {
            return BrowserEnum.SAFARI;
        } else {
            throw new BrowserNotImplemented("No such browser is implemented" + browserName);
        }
    }

}