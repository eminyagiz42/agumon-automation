package com.agumon.stepdefinition.utils2;

import com.agumon.utility.base.BaseUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class WaitUtils extends BaseUtils {

    private static final Logger LOGGER = LogManager.getLogger(WaitUtils.class);

    private final Duration defaultDuration;
    private static WebDriver driver;

    public WaitUtils(WebDriver driver, Duration defaultDuration) {
        super(driver);
        WaitUtils.driver = driver;
        this.defaultDuration = defaultDuration;
    }

    @Deprecated
    public static void waitFor(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e1) {
            LOGGER.error("ERROR in waitForMethod");
        }
    }

    public WebElement waitForElementVisibleWithCustomTime(By locator, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(mills));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisibleWithCustomTime(WebElement element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(mills));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickableWithCustomTime(WebElement element, long mills) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(mills));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return waitForElementClickableWithCustomTime(element, defaultDuration.toMillis());
    }

    public WebElement waitForElementVisible(WebElement element) {
        return waitForElementVisibleWithCustomTime(element, defaultDuration.toMillis());
    }

    public WebElement waitForElementVisible(By locator) {
        return waitForElementVisibleWithCustomTime(locator, defaultDuration.toMillis());
    }

    public void waitForAttributePresentWithCustomWaitTime(long mills, WebElement element,
                                                          String nameOfAttribute) {
        int milsWaitStep = 500;
        long numberOfLoops = mills / milsWaitStep;
        for (int i = 0; i < numberOfLoops; i++) {
            try {
                element.getAttribute(nameOfAttribute);
            } catch (Exception ex) {
                waitFor(milsWaitStep);
            }
        }
    }

    public void waitForAttributePresent(WebElement element, String nameOfAttribute) {
        waitForAttributePresentWithCustomWaitTime(defaultDuration.toMillis(), element, nameOfAttribute);
    }

    public List<WebElement> waitForAllElementsVisible(List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(defaultDuration.toMillis()));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        return elements;
    }


    public void waitForElementAbsent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(defaultDuration.toMillis()));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForTextToBePresentInElement(WebElement element, String string) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(defaultDuration.toMillis()));
        wait.until(ExpectedConditions.textToBePresentInElement(element, string));
    }

    public WebElement waitForElementPresent(WebElement element, long mills) {
        int milsWaitStep = 500;
        long numberOfLoops = mills / milsWaitStep;
        for (int i = 0; i < numberOfLoops; i++) {
            try {
                element.getLocation();
                return element;
            } catch (Exception ex) {
                waitFor(milsWaitStep);
            }
        }
        throw new AssertionError("Target element absent");
    }

    public WebElement waitForElementPresent(WebElement element) {
        waitForElementPresent(element, 30000);
        waitFor(1000);
        return element;
    }
}
