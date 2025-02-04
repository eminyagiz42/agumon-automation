package com.agumon.utility.driver;

import com.agumon.utility.enums.BrowserEnum;
import com.agumon.utility.exceptions.BrowserNotMatched;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.grid.Main;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.net.PortProber;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static com.agumon.utility.global.Constants.*;

import java.net.URL;
import java.time.Duration;


public class DriverFactory {

    private static WebDriver driver;

    protected DriverFactory() {
    }

    public static WebDriver setup(final BrowserEnum browserEnum) throws Exception {
        switch (browserEnum) {
            case FIREFOX:
                return firefox();
            case CHROME:
                return chrome();
            case EDGE:
                return edge();
            case IE:
                return ie();
            case SAFARI:
                return safari();
            case GRID:
                return gridFirefox();
            default:
                throw new BrowserNotMatched("Browser name Key value in configuration.properties is not matched");
        }
    }

    private static WebDriver chrome() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        chromeOptions.addArguments(REMOTE_ALLOW_ORIGINS);
        //chromeOptions.addExtensions(new File(AUTHENTICATION_ZIP).getAbsoluteFile());
        driver = new ChromeDriver(chromeOptions);

        if (BROWSER_HEADLESS_FLAG) {
            chromeOptions.addArguments(HEADLESS);
        }
        driver = new ChromeDriver(chromeOptions);
        setCommonDriverManage();
        return driver;
    }

    private static WebDriver firefox() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (BROWSER_HEADLESS_FLAG) {
            firefoxOptions.addArguments(HEADLESS);
        }
        driver = new FirefoxDriver(firefoxOptions);
        setCommonDriverManage();
        return driver;
    }

    private static WebDriver edge() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new EdgeDriver(edgeOptions);
        setCommonDriverManage();
        return driver;
    }

    private static WebDriver ie() {
        InternetExplorerOptions explorerOptions = new InternetExplorerOptions();
        explorerOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        explorerOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.IGNORE);
        driver = new InternetExplorerDriver(explorerOptions);
        setCommonDriverManage();
        return driver;
    }

    private static WebDriver safari() {
        SafariOptions safariOptions = new SafariOptions();
        safariOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new SafariDriver(safariOptions);
        setCommonDriverManage();
        return driver;
    }

    private static void setCommonDriverManage() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(DRIVER_IMPLICIT_WAIT_SEC));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(SCRIPT_TIMEOUT));
    }

    private static WebDriver gridFirefox() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        if (BROWSER_HEADLESS_FLAG) {
            firefoxOptions.addArguments(HEADLESS);
        }
        driver = new RemoteWebDriver(startStandaloneGrid(), firefoxOptions);
        setCommonDriverManage();
        return driver;
    }

    public static URL startStandaloneGrid() {
        int port = SELENIUM_PORT != null ? Integer.parseInt(SELENIUM_PORT) : PortProber.findFreePort();
        try {
            Main.main(
                    new String[]{
                            "standalone",
                            "--port",
                            String.valueOf(port),
                            "--selenium-manager",
                            "true",
                            "--enable-managed-downloads",
                            "true",
                            "--log-level",
                            "WARNING"
                    });
            System.out.println("http://localhost:" + port);
            return new URL("http://localhost:" + port);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}