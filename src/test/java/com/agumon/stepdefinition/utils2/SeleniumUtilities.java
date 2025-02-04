package com.agumon.stepdefinition.utils2;

import com.agumon.utility.base.BaseUtils;
import com.agumon.utility.driver.DriverManager;
import com.google.common.util.concurrent.Uninterruptibles;
import net.datafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.List;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;


public class SeleniumUtilities extends BaseUtils {

    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtilities.class);
    static Logger log = Logger.getLogger(SeleniumUtilities.class.getName());

    private static final int TIMEOUT = 5;
    private final String multipleValueDelimiter = ",";
    private Actions action;
    private boolean acceptNextAlert = true;
    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private final Duration defaultDuration;
    private Faker faker;

    public SeleniumUtilities(WebDriver driver, Duration defaultDuration) {
        super(driver);
        this.driver = driver;
        this.defaultDuration = defaultDuration;
        this.waitUtils = new WaitUtils(driver, defaultDuration);
    }

    public Faker faker() {
        if (faker == null) {
            faker = new Faker();
        }
        return faker;
    }

    public void closeRecentlyOpenedWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String windowHandle : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
                driver.close(); // closing child window
                driver.switchTo().window(parentWindow); // cntrl to parent
                // window
            }
        }
    }


    public By locatorValue(String locatorType, String value) {
        By by = By.id(value);
        switch (locatorType.toLowerCase()) {
            case "id":
                by = By.id(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "css":
                by = By.cssSelector(value);
                break;
            case "link":
                by = By.linkText(value);
                break;
            case "partiallink":
                by = By.partialLinkText(value);
                break;
            case "class":
                by = By.className(value);
                break;
            default:
                by = null;
                break;
        }
        return by;
    }

    public WebElement findElement(String locatorType, String value)
            throws NoSuchElementException, IOException {
        WebElement field = null;
        try {
            field = driver.findElement(locatorValue(locatorType, value));
        } catch (NoSuchElementException ex) {
            log.warn("No element with locatorType: " + locatorType
                    + " And Value " + value + " was NOT found.");
        }
        return field;
    }

    public WebElement findElement(By by)
            throws NoSuchElementException, IOException {
        WebElement field = null;
        try {
            field = driver.findElement(by);
        } catch (NoSuchElementException ex) {
            log.warn("Unable to find an element");
        }
        return field;
    }

    public List<WebElement> findElements(String locatorType, String value)
            throws NoSuchElementException {
        List<WebElement> allData = null;
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            allData = driver.findElements(locatorValue(locatorType, value));
        } catch (NoSuchElementException ex) {
            log.warn("No element with locatorType: " + locatorType
                    + " And Value " + value + " was NOT found.");
        }
        return allData;
    }

    public List<WebElement> findElements(By by)
            throws NoSuchElementException {
        List<WebElement> allData = null;
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            allData = driver.findElements(by);
        } catch (NoSuchElementException ex) {
            log.warn("Element is NOT found.");
        }
        return allData;
    }

    public void enterText(String locatorType, String value, String text) {

        try {
            WebElement element = findElement(locatorType, value);
            element.clear();
            waitInMilis(100);
            element.sendKeys(text);
            waitInMilis(100);
            element = null;
        } catch (NoSuchElementException e) {
            log.warn("No Element Found to enter text" + locatorType + ":"
                    + value);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.warn("No Element Found to enter text" + locatorType + ":"
                    + value);
        }
    }

    public void enterText(String locatorType, String value, Keys text) {

        try {
            WebElement element = findElement(locatorType, value);
            waitInMilis(100);
            element.sendKeys(text);
            waitInMilis(100);
            element = null;
        } catch (NoSuchElementException e) {
            log.warn("No Element Found to enter text" + locatorType + ":"
                    + value);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            log.warn("No Element Found to enter text" + locatorType + ":"
                    + value);
        }
    }

    public void enterText(WebElement element, String text) {

        try {
            element.sendKeys(text);
            waitInMilis(100);
            element = null;
        } catch (Exception e) {
            log.warn("No Element Found to enter text" + element);
        }
    }

    public void enterText(By by, String text) {

        try {
            WebElement element = driver.findElement(by);
            element.sendKeys(text);
            waitInMilis(100);
            element = null;
        } catch (Exception e) {
            log.warn("No Element Found to enter text");
        }
    }

    public void enterText(WebElement element, Keys text) {

        try {
            element.sendKeys(text);
            waitInMilis(100);
            element = null;
        } catch (Exception e) {
            log.warn("No Element Found to enter text" + element);
        }
    }

    public void clickOnElement(String locatorType, String value)
            throws Exception {
        try {

            WebElement element = findElement(locatorType, value);
            element.click();
            waitInMilis(1000);
        } catch (NoSuchElementException e) {
            log.warn("No Element Found to click with: " + locatorType + "= "
                    + value);

        }
    }

    public void clickOnElement(WebElement element)
        /*throws Exception*/ {
        try {
            element.click();
            waitInMilis(1000);
        } catch (Exception e) {
            log.warn("No Element Found to click with: " + element);
        }
    }

    public void clickOnElement(By by) {
        try {
            WebElement element = findElement(by);
            element.click();
            waitInMilis(1000);
        } catch (Exception e) {
            log.warn("No Element Found to click with: " + by);
        }
    }

    public String getTextFromWebElement(String locatorType, String value)
            throws Exception {
        WebElement element = null;
        String gettext = null;
        try {
            element = findElement(locatorType, value);

            gettext = element.getText();
            log.info("Element text is: " + gettext);

        } catch (NoSuchElementException e) {
            log.warn("No element with name " + element + "was found.");
        }
        return gettext;
    }

    public String getTextFromWebElement(WebElement element)
            throws Exception {
        String gettext = null;
        try {
            gettext = element.getText();
            log.info("Element text is: " + gettext);

        } catch (NoSuchElementException e) {
            log.warn("No element with name " + element + "was found.");
        }
        return gettext;
    }

    public String getTextFromWebElement(By by)
            throws Exception {
        WebElement element = null;
        String gettext = null;
        try {
            element = findElement(by);
            gettext = element.getText();
            log.info("Element text is: " + gettext);

        } catch (NoSuchElementException e) {
            log.warn("No element with name " + element + "was found.");
        }
        return gettext;
    }

    public void fluentWaitElementToBeVisible(By locator) {
        try {
            log.info("Waiting for Element to be Visible");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(defaultDuration.toMillis()));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void fluentWaitElementToBeVisible(WebElement element) {
        try {
            log.info("Waiting for Element to be Visible");
            new WebDriverWait(driver, defaultDuration).until(ExpectedConditions
                    .visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void fluentWaitElementToBeInvisible(By locator) {
        try {
            log.info("Waiting for Element to be Invisible");
            new WebDriverWait(driver, defaultDuration).until(ExpectedConditions
                    .invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void fluentWaitElementToBeInvisible(WebElement element) {
        try {
            log.info("Waiting for Element to be Invisible");
            new WebDriverWait(driver, defaultDuration).until(ExpectedConditions
                    .invisibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void fluentWaitElementToBeClickable(By locator) {
        try {
            log.info("Waiting for Element to be Clickable");
            new WebDriverWait(driver, defaultDuration).until(ExpectedConditions
                    .elementToBeClickable(locator));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void fluentWaitElementToBeClickable(WebElement element) {
        log.info("Waiting for Element to be Clickable");
        try {
            new WebDriverWait(driver, defaultDuration).until(ExpectedConditions
                    .elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("Unable to find web element");
        }
    }

    public void waitUntilElementBecomesClickable(String locatorType,
                                                 String value, Integer seconds) {

        By locator;
        try {
            locator = locatorValue(locatorType, value);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.not(ExpectedConditions
                    .visibilityOf(driver.findElement(locator))));
        } catch (NoSuchElementException ex) {
            log.warn("No element with name " + locatorType + " : " + value
                    + "was found.");
        }

    }

    public void waitUntilElementBecomesClickable(WebElement element, Integer seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
            wait.until(ExpectedConditions.not(ExpectedConditions.visibilityOf(element)));
        } catch (NoSuchElementException ex) {
            log.warn("Unable to find web element");
        }

    }

    public void WaitforElement(String locatorType, String value) {

        try {
            By locator;
            locator = locatorValue(locatorType, value);
            fluentWaitElementToBeVisible(locator);

        } catch (NoSuchElementException ex) {
            log.warn("No element with name " + locatorType + " : " + value
                    + "was found.");
        }
    }

    public void WaitforElementToBeInvisible(String locatorType, String value) {

        try {
            By locator;
            locator = locatorValue(locatorType, value);
            fluentWaitElementToBeInvisible(locator);
        } catch (NoSuchElementException ex) {
            log.warn("No element with name " + locatorType + " : " + value
                    + "was found.");
        }
    }

    public String getElementAttribute(String locatorType, String value,
                                      String name) {
        String attribute = null;
        try {
            log.info("Element with Attribute Name: " + name);

            attribute = findElement(locatorType, value).getAttribute(name);
        } catch (Exception ex) {
            log.warn("No element with name " + locatorType + " : " + value
                    + "was found.");
        }
        return attribute;
    }

    public boolean isAttributePresent(String locatorType, String value,
                                      String attributeName) {
        String attribute = null;
        try {
            log.info("Element with Attribute Name: " + attributeName);

            attribute = findElement(locatorType, value).getAttribute(
                    attributeName);
        } catch (Exception ex) {
            log.warn("No element with name " + locatorType + " : " + value
                    + "was found.");
        }
        return attribute != null;
    }

    public void setClipboardData(String string) {
        StringSelection stringSelection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard()
                .setContents(stringSelection, null);
    }

    public void paste_Function() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean pageLaunchSuccess(final String pageTitle) {
        boolean flag = false;
        try {
            if (pageTitle.equals(driver.getTitle())) {
                log.info("Launched the expected page: Title as "
                        + driver.getTitle());
                flag = true;
            } else {
                log.warn("Incorrect webpage launched!!! \nExpected Title: "
                        + pageTitle + ". Actual Title: " + driver.getTitle());
            }
        } catch (Exception ex) {
            log.warn("Page did NOT launch successfully ");
        }
        return flag;
    }

    public void assertElementPresent(String locatorType, String value,
                                     String message) throws Exception {
        try {
            log.info("Assert Element Present with locatorType: " + locatorType
                    + "and value: " + value);
            WebElement element = findElement(locatorType, value);
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e) {
            log.warn("Element is NOT present" + locatorType + ":" + value);
            log.warn(e.getMessage());
            Assert.fail(message + ", Element is NOT present " + locatorType
                    + ":" + value);
        }
    }

    public void assertElementPresent(WebElement element, String message) throws Exception {
        try {
            log.info("Assert Element Present");
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e) {
            log.warn("Element is NOT present");
            log.warn(e.getMessage());
            Assert.fail(message + " Element is NOT present");
        }
    }

    public void assertElementPresent(String locatorType, String value)
            throws Exception {
        try {
            log.info("Assert Element Present with locatorType: " + locatorType
                    + "and value: " + value);
            WebElement element = findElement(locatorType, value);
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e) {
            log.info("Element is NOT present" + locatorType + ":" + value);
            log.info(e.getMessage());
            Assert.fail("Element is NOT present " + locatorType + ":" + value);
        }
    }

    public void assertElementPresent(WebElement element) throws Exception {
        try {
            log.info("Assert Element Present");
            Assert.assertTrue(element.isDisplayed());
        } catch (NoSuchElementException e) {
            log.warn("Element is NOT present");
            log.warn(e.getMessage());
            Assert.fail(" Element is NOT present");
        }
    }

    public boolean assertElementIsNotPresent(String locatorType, String value)
            throws Exception {
        boolean isElementPresent = false;
        try {
            log.info("Assert Element with locatorType: " + locatorType
                    + "and value: " + value + " is not present");
            findElement(locatorType, value);
            isElementPresent = true;
        } catch (NoSuchElementException e) {
            log.warn("Element is NOT present" + locatorType + ":" + value
                    + ", So returning true as per the check");
            isElementPresent = false;
        }
        return isElementPresent;

    }

    public boolean assertElementIsNotPresent(WebElement element)
            throws Exception {
        boolean isElementPresent = false;
        try {
            element.getClass();
            isElementPresent = true;
        } catch (NoSuchElementException e) {
            log.warn("Element is NOT present");
        }
        return isElementPresent;
    }

    public void verifyResultGridValues(WebElement element,
                                       int columnNumber, String values) throws IOException {

        List<String> expectedValues = Arrays.asList(values
                .split(multipleValueDelimiter));

        try {
            List<String> actualValues = new ArrayList<String>();
            List<WebElement> rows = element.findElements(By.tagName("tr"));

            for (int i = 0; i < rows.size(); i++) {
                String column = rows.get(i).findElements(By.tagName("td"))
                        .get(columnNumber - 1).getText();
                actualValues.add(column);
            }
            Assert.assertEquals(actualValues, expectedValues,
                    "Values are not matching");

        } catch (NoSuchElementException e) {
            log.error("The Element is NOT found.");

            Assert.fail("The Element is NOT found."
                    + e.getLocalizedMessage());
        }
    }

    public void assertElementText(String locatorType, String value, String text)
            throws Exception {

        try {
            String actualTextOnElement = findElement(locatorType, value)
                    .getText();
            // log.info("Actual Text on Element: " + actualTextOnElement);
            Assert.assertEquals(actualTextOnElement, text,
                    "Assertion Failed - " + "Expected: " + text + " Actual: "
                            + actualTextOnElement);
        } catch (NoSuchElementException ex) {
            log.error("The Element with locator Type: " + locatorType + ":"
                    + value + "with Text: " + "was NOT found.");
            Assert.fail("The Element with locator Type: " + locatorType + ":"
                    + value + "with Text: " + "was NOT found.");
        }
    }

    public void assertElementText(WebElement element, String text)
            throws Exception {

        try {
            String actualTextOnElement = element.getText();
            // log.info("Actual Text on Element: " + actualTextOnElement);
            Assert.assertEquals(actualTextOnElement, text,
                    "Assertion Failed - " + "Expected: " + text + " Actual: "
                            + actualTextOnElement);
        } catch (NoSuchElementException ex) {
            log.error("The Element is NOT found.");
            Assert.fail("The Element is NOT found.");
        }
    }

    public boolean assertElementContainsText(final String locatorType,
                                             String value, String text) throws Exception {

        boolean flag = false;
        try {
            String actualTextOnElement = findElement(locatorType, value)
                    .getText();

            // log.info("Actual Text on Element: " + actualTextOnElement);
            if (actualTextOnElement.contains(text)) {
                // log.info("Actual Matches expected.");
                flag = true;
            } else {
                // log.warn("Actual does NOT Matches expected.");
                // log.warn("Actual Text on Element" + actualTextOnElement);
                // log.warn("Expected Text on Element" + text);

            }
        } catch (NoSuchElementException ex) {
            log.error("The Element with locator Type: " + locatorType + ": "
                    + " with Value: " + value + " was NOT found."
                    + ex.getMessage());
            // log.warn("Expected Text on Element" + text);
            // log.warn(ex.getMessage());

        }

        return flag;
    }

    public boolean assertElementContainsText(WebElement element, String text)
            throws Exception {
        boolean flag = false;
        try {
            String actualTextOnElement = element.getText();
            if (actualTextOnElement.contains(text)) {
                flag = true;
            }
        } catch (NoSuchElementException ex) {
            log.error("The Element is NOT found." + ex.getMessage());
            // log.warn("Expected Text on Element" + text);
            // log.warn(ex.getMessage());

        }
        return flag;
    }

    public void switchToFrame(String frame) {
        try {
            // log.info("Popup/Frame Name or ID is" + frame);
            driver.switchTo().frame(frame);

        } catch (Exception e) {
            log.error(frame + " Popup/Frame is NOT found");
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
        timeOut(30);
        pleaseWaitTillLoadingIsDone();
        waitInMilis(2000);
    }

    public String getPageTitle() {
        String title = null;
        try {
            title = driver.getTitle();
            // log.info("Page Title is: " + title);
        } catch (Exception e) {
            log.error("Could NOT find page with Title" + title);
        }
        return title;
    }

    public enum AlertType {
        ACCEPT, OK, DISMISS, CANCEL;

        public AlertType find(String action) {
            for (AlertType at : AlertType.values()) {
                if (at.name().equalsIgnoreCase(action)) {
                    return at;
                }
            }
            return ACCEPT;
        }

    }

    public void timeOut(long val) {
        driver.manage().timeouts().implicitlyWait(val, TimeUnit.SECONDS);
    }

	/*
	public void clickAlert(String action) {
		waitInMilis(1000);
		Alert alert = driver.switchTo().alert();
		AlertType alertType = AlertType.find(action);
		switch (alertType) {
		case ACCEPT:
		case OK:
			alert.accept();
			break;
		case DISMISS:
		case CANCEL:
			alert.dismiss();
			break;
		default:
			waitInMilis(1000);
		}
	}
	 */

    public void switchToActiveElement() {
        try {
            driver.switchTo().activeElement();

        } catch (Exception e) {
            log.error("Could NOT switch to active element");
        }
    }

    public String switchToAlert(String command) {
        try {
            Alert alert = driver.switchTo().alert();

            if (command.equalsIgnoreCase("OK")) {
                String text = alert.getText();
                alert.accept();
                return text;
            } else if (command.equalsIgnoreCase("CANCEL")) {
                String text = alert.getText();
                alert.dismiss();
                return text;
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Could NOT switch to alert");
        }
        return null;
    }

    public boolean assertAlertText(String text) {
        boolean flag = false;
        try {

            String alertText = driver.switchTo().alert().getText();
            log.info("Actual Text on Alert: " + alertText);
            if (alertText.contains(text)) {
                // log.info("Actual Matches expected.");
                flag = true;
            } else {
                log.error("Actual does NOT Matches expected.");
            }
        } catch (NoSuchElementException ex) {
            log.error("The Alert with Text: " + text + "was NOT found.");

        }

        return flag;

    }

    public void waitInMilis(int timeInMiliSeconds) {
        try {
            Thread.sleep(timeInMiliSeconds);
        } catch (InterruptedException e) {
            log.error("Could NOT execute waitInMilis method");
        }
    }

    public boolean mouseOverAndClickOnElement(String locatorType, String value)
            throws Exception {
        boolean mouseHover = false;
        WebElement myElement = findElement(locatorType, value);
        action = new Actions(driver);
        action.moveToElement(myElement).build().perform();
        action.click();
        if (null != myElement) {
            mouseHover = true;
        }
        return mouseHover;
    }

    public boolean mouseOverAndClickOnElement(WebElement element)
            throws Exception {
        boolean mouseHover = false;
        action = new Actions(driver);
        action.moveToElement(element).build().perform();
        action.click();
        if (null != element) {
            mouseHover = true;
        }
        return mouseHover;
    }

    public boolean mouseOverOnElement(String locatorType, String value)
            throws Exception {
        boolean mouseHover = false;
        waitInMilis(1000);
        WebElement myElement = findElement(locatorType, value);
        action = new Actions(driver);
        action.moveToElement(myElement).build().perform();
        if (null != myElement) {
            mouseHover = true;
            log.info("Mouse hovered successfully on " + myElement.getText());
        }
        return mouseHover;
    }

    public boolean mouseOverOnElement(WebElement myElement)
            throws Exception {
        boolean mouseHover = false;
        action = new Actions(driver);
        action.moveToElement(myElement).build().perform();
        if (null != myElement) {
            mouseHover = true;
            log.info("Mouse hovered successfully on " + myElement.getText());
        }
        return mouseHover;
    }

    public void clearAndEnterText(String locatorType, String value, String text)
            throws Exception {
        WebElement element = null;
        try {
            element = findElement(locatorType, value);
            element.click();
            element.clear();
            waitInMilis(1000);
            element.sendKeys(text);
        } catch (NoSuchElementException ex) {
            log.error("No element with LOCATORTYPE: " + locatorType
                    + " And VALUE: " + value + " was found.");
        }
    }

    public void clearAndEnterText(WebElement element, String text)
            throws Exception {
        try {
            element.click();
            element.clear();
            waitInMilis(1000);
            element.sendKeys(text);
        } catch (NoSuchElementException ex) {
            log.error("Unable to find an element");
        }
    }

    public void clearAndEnterText(By by, String text)
            throws Exception {
        WebElement element = null;
        try {
            element = findElement(by);
            element.click();
            element.clear();
            waitInMilis(1000);
            element.sendKeys(text);
        } catch (NoSuchElementException ex) {
            log.error("Unable to find an element");
        }
    }

    public void selectTextFromDropDown(String locatorType, String value,
                                       String text) throws Exception {
        try {
            WebElement element = findElement(locatorType, value);
            Select sel = new Select(element);
            sel.selectByVisibleText(text);
            waitInMilis(1000);
        } catch (NoSuchElementException ex) {
            log.error("No element with LOCATORTYPE: " + locatorType
                    + " And VALUE: " + value + " was found.");
            ex.printStackTrace();
        }
    }

    public void selectTextFromDropDown(WebElement element, String text) throws Exception {
        try {
            Select sel = new Select(element);
            sel.selectByVisibleText(text);
            waitInMilis(1000);
        } catch (NoSuchElementException ex) {
            log.error("Unable to find an element");
            ex.printStackTrace();
        }
    }

    public void selectTextFromDropDown(By by, String text) throws Exception {
        try {
            Select sel = new Select(findElement(by));
            sel.selectByVisibleText(text);
            waitInMilis(1000);
        } catch (NoSuchElementException ex) {
            log.error("Unable to find an element");
            ex.printStackTrace();
        }
    }

    public String getSelectedTextFromDropDown(String locatorType, String value)
            throws Exception {
        try {
            WebElement element = findElement(locatorType, value);
            Select sel = new Select(element);
            String text = sel.getFirstSelectedOption().getText();
            waitInMilis(1000);
            return text;
        } catch (NoSuchElementException ex) {
            log.error("No element with LOCATORTYPE: " + locatorType
                    + " And VALUE: " + value + " was found.");
            ex.printStackTrace();
            return "";
        }
    }

    public String getSelectedTextFromDropDown(WebElement element)
            throws Exception {
        try {
            Select sel = new Select(element);
            String text = sel.getFirstSelectedOption().getText();
            waitInMilis(1000);
            return text;
        } catch (NoSuchElementException ex) {
            log.error("Unable to find an element");
            ex.printStackTrace();
            return "";
        }
    }

    public void assertElementIsEnabled(String locatorType, String value,
                                       boolean bool) {
        try {
            WebElement element = findElement(locatorType, value);
            if (bool == false) {
                Assert.assertFalse(element.isEnabled());
            }
            if (bool == true) {
                if (element.isEnabled()) {
                    Assert.assertTrue(element.isEnabled());
                } else {
                    new WebDriverWait(driver, Duration.ofMillis(15)).until(ExpectedConditions
                            .elementToBeClickable(element));
                    Assert.assertTrue(element.isEnabled());
                }
            }
        } catch (Exception e) {

            log.error("ELEMENT WITH: " + locatorType + ": " + value
                    + "ENABLE CONDITION " + bool + " IS FALSE");
        }
    }

    public void assertElementIsEnabled(WebElement element,
                                       boolean bool) {
        try {
            if (bool == false) {
                Assert.assertFalse(element.isEnabled());
            }
            if (bool == true) {
                if (element.isEnabled()) {
                    Assert.assertTrue(element.isEnabled());
                } else {
                    new WebDriverWait(driver, Duration.ofMillis(15)).until(ExpectedConditions
                            .elementToBeClickable(element));
                    Assert.assertTrue(element.isEnabled());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Unable to find an element");
        }
    }

    public void assertElementIsSelected(WebElement element,
                                        boolean bool) {
        try {
            if (bool == true) {
                if (element.isSelected()) {
                    Assert.assertTrue(element.isSelected());
                } else {
                    new WebDriverWait(driver, Duration.ofMillis(15)).until(ExpectedConditions
                            .elementToBeSelected(element));
                    Assert.assertTrue(element.isSelected());
                }
            } else if (bool == false) {
                Assert.assertFalse(element.isSelected());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Unable to find an element");

        }
    }

    public void assertElementIsSelected(String locatorType, String value,
                                        boolean bool) {
        try {
            // log.info("ELEMENT WITH: " + locatorType + ":" + value +
            // "SELECTED CONDITION" + bool);
            WebElement element = findElement(locatorType, value);
            if (bool == true) {

                if (element.isSelected()) {
                    Assert.assertTrue(element.isSelected());
                } else {
                    new WebDriverWait(driver, Duration.ofMillis(15)).until(ExpectedConditions
                            .elementToBeSelected(element));
                    Assert.assertTrue(element.isSelected());
                }
            } else if (bool == false) {
                Assert.assertFalse(element.isSelected());
            }
        } catch (Exception e) {
            log.error("ELEMENT WITH: " + locatorType + ":" + value
                    + "SELECTED CONDITION" + bool + "IS FALSE");

        }
    }

    public String currentSystemDate() {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        return currentDate;
    }

    public String currentSystemDatePlus(int days) {
        String currentDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // dd/MM/yyyy
            Date date = new Date();
            currentDate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(currentDate));
            c.add(Calendar.DATE, days); // number of days to add
            currentDate = dateFormat.format(c.getTime());
            return currentDate;
        } catch (Exception e) {
            log.error("Unable to add date" + e.getMessage());
            e.printStackTrace();
        }
        return currentDate;
    }

    public String currentSystemDateMinus(int days) {
        String currentDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); // dd/MM/yyyy
            Date date = new Date();
            currentDate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(currentDate));
            c.add(Calendar.DATE, -days); // number of days to add
            currentDate = dateFormat.format(c.getTime());
            return currentDate;
        } catch (Exception e) {
            log.error("Unable to subtract date" + e.getMessage());
            e.printStackTrace();
        }
        return currentDate;
    }

    public String getYesterdaysDate() throws Exception {
        String yestDate = null;
        try {
            yestDate = currentSystemDateMinus(1);
            return yestDate;
        } catch (Exception e) {
            log.error("Unable to get yesterday's date" + e.getMessage());
            e.printStackTrace();
            return yestDate;
        }
    }

    public String currentSystemTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String currentDate = dateFormat.format(date);
        return currentDate;
    }

    public String currentSystemTimePlus(int mins) {
        String currentDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm"); // dd/MM/yyyy
            Date date = new Date();
            currentDate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(currentDate));
            c.add(Calendar.MINUTE, mins); // number of days to add
            currentDate = dateFormat.format(c.getTime());
            return currentDate;
        } catch (Exception e) {
            log.error("Unable to add time " + e.getMessage());
            e.printStackTrace();
        }
        return currentDate;
    }

    public String currentSystemTimeMinus(int mins) {
        String currentDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat("HH:mm"); // dd/MM/yyyy
            Date date = new Date();
            currentDate = dateFormat.format(date);
            Calendar c = Calendar.getInstance();
            c.setTime(dateFormat.parse(currentDate));
            c.add(Calendar.MINUTE, -mins); // number of days to add
            currentDate = dateFormat.format(c.getTime());
            return currentDate;
        } catch (Exception e) {
            log.error("Unable to subtract time " + e.getMessage());
            e.printStackTrace();
        }
        return currentDate;
    }

    public boolean checkMatchAttr(By by, String compareWith, String fieldName) {
        boolean isCorrect = false;
        if (driver.findElement(by).getAttribute("value").trim()
                .equalsIgnoreCase(compareWith.trim())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + driver.findElement(by).getAttribute("value"));
        return isCorrect;
    }

    public boolean checkPartialMatchAttr(By by, String compareWith,
                                         String fieldName) {
        boolean isCorrect = false;
        if (compareWith
                .trim()
                .toLowerCase()
                .contains(
                        driver.findElement(by).getAttribute("value").trim()
                                .toLowerCase())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + driver.findElement(by).getAttribute("value"));
        return isCorrect;
    }

    public boolean checkPartialMatchAttr(WebElement element, String compareWith,
                                         String fieldName) {
        boolean isCorrect = false;
        if (compareWith
                .trim()
                .toLowerCase()
                .contains(
                        element.getAttribute("value").trim()
                                .toLowerCase())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + element.getAttribute("value"));
        return isCorrect;
    }

    public boolean checkMatchText(By by, String compareWith, String fieldName) {
        boolean isCorrect = false;
        if (driver.findElement(by).getText().trim()
                .equalsIgnoreCase(compareWith.trim())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + driver.findElement(by).getText());
        return isCorrect;
    }

    public boolean checkMatchText(WebElement element, String compareWith, String fieldName) {
        boolean isCorrect = false;
        if (element.getText().trim()
                .equalsIgnoreCase(compareWith.trim())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + element.getText());
        return isCorrect;
    }

    public boolean checkPartialMatchText(By by, String compareWith,
                                         String fieldName) {
        boolean isCorrect = false;
        if (compareWith
                .trim()
                .toLowerCase()
                .contains(
                        driver.findElement(by).getText().trim()
                                .toLowerCase())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + driver.findElement(by).getText());
        return isCorrect;
    }

    public boolean checkPartialMatchText(WebElement element, String compareWith,
                                         String fieldName) {
        boolean isCorrect = false;
        if (compareWith
                .trim()
                .toLowerCase()
                .contains(element.getText().trim().toLowerCase())) {
            log.info(fieldName + " is correctly shown");
            System.out.println(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        System.out.println(fieldName + " "
                + element.getText());
        return isCorrect;
    }

    public boolean isEqual(String string1, String string2, String fieldName) {
        boolean isCorrect = false;
        if (string1.trim().equalsIgnoreCase(string2.trim())) {
            System.out.println(fieldName + " is correctly shown");
            log.info(fieldName + " is correctly shown");
            isCorrect = true;
        } else {
            log.error(fieldName + " is not shown correctly");
            System.out.println(fieldName + " is not shown correctly");
            isCorrect = false;
        }
        return isCorrect;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(WebElement element) {
        try {
            element.getSize();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public String readField(WebElement el) {
        List<WebElement> options = el.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if (option.isSelected()) {
                return option.getText();
            }
        }
        return null;
    }

    public List<String> getDropDownOptions(WebElement el) {
        List<WebElement> opt = new ArrayList<WebElement>();
        opt = new Select(el).getOptions();
        List<String> optionText = new ArrayList<String>();
        for (int i = 0; i < opt.size(); i++) {
            optionText.add(opt.get(i).getText());
        }
        return optionText;
    }

    public void pleaseWait() {
        try {
            Thread.sleep(100);
            for (int x = 0; x < 100; x++) {
                if (isElementPresent(By.id("ricolaPleaseWait"))) {
                    if (!driver.findElement(By.id("ricolaPleaseWait"))
                            .isDisplayed()) {
                        break;
                    } else {
                        Thread.sleep(100);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unable to waitInMilis");
            e.printStackTrace();
        }
    }

    public void pleaseWaitTillLoadingIsDone() {
        try {
            Thread.sleep(200);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(200));
            if (isElementPresent(By.className("rc-loading-animation"))) {
                wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.className("rc-loading-animation"))));
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.error("Element is still available in DOM " + e.getMessage());
            e.printStackTrace();
        }
        // WebDriverWait waitInMilis = new WebDriverWait(driver, 100);
        // waitInMilis.until(ExpectedConditions.invisibilityOfElementLocated(By.className("rc-loading-animation")));
        // System.out.print("Text box text4 is now invisible");
    }

    public void pleaseWaitTillLoadingIsDone1() {
        try {
            Thread.sleep(100);
            for (int x = 0; x < 200; x++) {
                if (isElementPresent(By.className("rc-loading-animation"))) {
                    if (!driver.findElement(
                            By.className("rc-loading-animation")).isDisplayed()) {
                        break;
                    } else {
                        Thread.sleep(100);
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unable to waitInMilis till loading is done");
            e.printStackTrace();
        }
        // WebDriverWait waitInMilis = new WebDriverWait(driver, 100);
        // waitInMilis.until(ExpectedConditions.invisibilityOfElementLocated(By.className("rc-loading-animation")));
        // System.out.print("Text box text4 is now invisible");
    }

    public boolean compareDataIgnoreCase(String expected, String actual) {
        if (actual.toLowerCase().contains(expected.toLowerCase())) {
            log.info("comparison is successful between " + expected + " & "
                    + actual);
            return true;
        } else {
            log.error("comparison is failed between " + expected + " & "
                    + actual);
            return false;
        }
    }

    public String compareData(boolean bool) {
        String flagText = "";
        if (bool) {
            flagText = "Yes";
        } else {
            flagText = "No";
        }
        return flagText;
    }

    public boolean compareData(String expected, String actual) {
        if (expected.equals(actual)) {
            log.info("comparison is successful between " + expected + " & "
                    + actual);
            return true;
        } else {
            log.error("comparison is failed between " + expected + " & "
                    + actual);
            return false;
        }
    }

    public void elementVerification(By by, String element) {
        if (isElementPresent(by)) {
            System.out.println(element + " is available on page");
        } else {
            log.error(element + " is not available on page");
            System.out.println(element + " is not available on page");
        }
    }

    public void clickOnCalender(WebElement cal) {
        try {
            action = new Actions(driver);
            int x_location = cal.getLocation().getX();
            int width = cal.getSize().getWidth();
            System.out.println("Width " + width);
            System.out.println("clicked x at " + x_location + (width - 2));
            action.moveToElement(cal, width - 2, 0).click().perform();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            log.error("Unable to click on calender");
            e.printStackTrace();
        }
    }

    public void setYesterdaysDateInWicket() throws Exception {
        // clickOnCalender(findElement("css",
        // "div.ricCalendarInputWrapper.ricInlineWrapper"));
        // Thread.sleep(1000);
        WebElement caldate = findElement("class", "ricCalendarDays");
        if (getTodaysDay() == 1) {
            clickOnElement("css", "th.ricCalendarMonthPrev");
            Thread.sleep(1000);
            caldate.findElement(By.xpath("//td[text()='28']")).click();
        } else {
            int day = getTodaysDay() - 1;
            caldate.findElement(By.xpath("//td[text()='" + day + "']")).click();
        }

        Thread.sleep(2000);
    }

    public String getTodaysDate() throws Exception {
        String day, month, year;
        day = Integer.toString(getTodaysDay());
        month = Integer.toString(getTodaysMonth());
        year = Integer.toString(getTodaysYear());
        String finalDate = month + "/" + day + "/" + year;
        return dateFormatter(finalDate);
    }

    public String dateFormatter(String date) {
        String dutyDate = date;
        String[] splDutyDate = dutyDate.split("/");
        for (int i = 0; i < (splDutyDate.length - 1); i++) {
            // System.out.println(splDutyDate[i].length());
            if (splDutyDate[i].length() == 1) {
                // System.out.println("value ="+splDutyDate[i]);
                splDutyDate[i] = "0" + splDutyDate[i];
                // System.out.println("value ="+splDutyDate[i]);
            }
            // System.out.println(splDutyDate[i]);
        }
        if (splDutyDate[2].length() == 2) {
            // System.out.println("Year = "+splDutyDate[2]);
            splDutyDate[2] = "20" + splDutyDate[2];
            // System.out.println("Year = "+splDutyDate[2]);
        }
        System.out.println(splDutyDate[1] + "/" + splDutyDate[0] + "/"
                + splDutyDate[2]);
        return splDutyDate[0] + "/" + splDutyDate[1] + "/" + splDutyDate[2];
    }

    public int getTodaysDay() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth;
    }

    public int getTodaysMonth() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = (cal.get(Calendar.MONTH) + 1);
        return dayOfMonth;
    }

    public int getTodaysYear() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonth = cal.get(Calendar.YEAR);
        return dayOfMonth;
    }

    public void selectDateFromCalendar(WebElement cal, String date) {
        try {
            action = new Actions(driver);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(10));
            int x_location = cal.getLocation().getX();
            int width = cal.getSize().getWidth();
            System.out.println("Width " + width);
            System.out.println("clicked x at " + x_location + (width - 2));
            action.moveToElement(cal, width - 2, 0).click().perform();
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By
                    .className("ricCalendarWrapper")));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            log.error("Unable to select date from calender");
            e.printStackTrace();
        }
    }

    public void compareValuesFromList(List<String> knownVal, List<String> el,
                                      String fieldName) {
        log.info("Checking for drop down values for " + fieldName);
        if (knownVal.size() == el.size()) {
            for (int i = 0; i < el.size(); i++) {
                if (knownVal.get(i).equalsIgnoreCase(el.get(i))) {
                    log.info("Value matched for " + knownVal.get(i) + " and "
                            + el.get(i));
                    System.out.println("Value matched for " + knownVal.get(i)
                            + " and " + el.get(i));
                } else {
                    log.error("Value does not matched for " + knownVal.get(i)
                            + " and " + el.get(i));
                    System.out.println("Value does not matched for "
                            + knownVal.get(i) + " and " + el.get(i));
                }
            }
        } else {
            log.error("Values count is mismatched for " + fieldName);
            System.out.println("Values count is mismatched for " + fieldName);
        }
    }

    public void compareRandomValuesFromList(List<String> mandField,
                                            List<String> valArrayText) {
        for (int i = 0; i < valArrayText.size(); i++) {
            boolean tempBool = false;
            for (int j = 0; j < mandField.size(); j++) {
                if (valArrayText.get(i).equalsIgnoreCase(mandField.get(j))) {
                    log.info("Mandatory field validation is working for "
                            + valArrayText.get(i));
                    tempBool = true;
                    break;
                }
            }
			/*
			Global.as.assertTrue(
					tempBool,
					"Mandatory validation is not working for "
							+ valArrayText.get(i));
			*/
            if (!tempBool) {
                log.error("Mandatory validation is not working for "
                        + valArrayText.get(i));
            }
        }
    }

    public String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }

    public void quitBrowser() {
        driver.quit();
    }

    public String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = "src/main/resources/agumon-reports/manual-screenshots" + name + date + ".png";

        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);

        return target;
    }

    //========Switching Window=====//
    public void switchToWindow(String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().equals(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    //========Hover Over=====//
    public void hover(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public List<String> getElementsText(By locator) {
        List<WebElement> elems = driver.findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //===============Thread.sleep Wait==============//
    public void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver ->
                ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            LOGGER.info("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            LOGGER.error(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    //======Fluent Wait====//
    public WebElement fluentWait(final WebElement webElement, int timeinsec) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(15)).pollingEvery(Duration.ofSeconds(timeinsec))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public void doubleClick(WebElement element) {
        new Actions(driver).doubleClick(element).build().perform();
    }

    /**
     * @param element
     * @param check
     */
    public void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param select
     * @return
     */
    public WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    public void waitAndClick(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public void waitAndClick(WebElement element) {
        for (int i = 0; i < TIMEOUT; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public void waitAndSendText(WebElement element, String text, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public void waitAndSendText(WebElement element, String text) {
        for (int i = 0; i < TIMEOUT; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public void waitAndSendTextWithDefaultTime(WebElement element, String text) {
        for (int i = 0; i < TIMEOUT; i++) {
            try {
                element.sendKeys(text);
                return;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
    }

    public String waitAndGetText(WebElement element, int timeout) {
        String text = "";
        for (int i = 0; i < timeout; i++) {
            try {
                text = element.getText();
                return text;
            } catch (WebDriverException e) {
                wait(1);
            }
        }
        return null;
    }

    //5 seconds
    public void waitAndClickElement(WebElement element, int seconds) {
        for (int i = 0; i < seconds; i++) {

            try {
                element.click();
                break;
            } catch (Exception e) {
                wait(1);
            }
        }
    }

    @Deprecated
    public void wait(int secs) {
        /**
         *  Please avoid using Thread sleep
         *  It creates brittle tests that can fail unpredictably
         *  depending on environment ("Passes on my machine!") or load.
         *  Don’t rely on timing, See Also: Explicit and Fluent Waits
         */

        try {
            Thread.sleep(1000 * secs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public Boolean waitForInVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void executeJScommand(WebElement element, String command) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(command, element);
    }

    public void selectAnItemFromDropdown(WebElement item, String selectableItem) {
        wait(5);
        Select select = new Select(item);
        for (int i = 0; i < select.getOptions().size(); i++) {
            if (select.getOptions().get(i).getText().equalsIgnoreCase(selectableItem)) {
                select.getOptions().get(i).click();
                break;
            }
        }
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public void clickWithJS(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param elements
     */
    public void clickWithJSAsList(List<WebElement> elements) {
        for (WebElement each : elements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", waitForVisibility(each, 5));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", each);
        }
    }

    public void selectByVisibleText(WebElement element, String text) {
        Select objSelect = new Select(element);
        objSelect.selectByVisibleText(text);
    }

    public void selectByIndex(WebElement element, int index) {
        Select objSelect = new Select(element);
        objSelect.selectByIndex(index);
    }

    public void selectByValue(WebElement element, String value) {
        Select objSelect = new Select(element);
        List<WebElement> elementCount = objSelect.getOptions();
        objSelect.selectByValue(value);
        LOGGER.info("number of elements: " + elementCount.size());
    }

    public void sleep(int timeOut) {
        try {
            Thread.sleep(timeOut);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitAndClickLocationText(WebElement element, String value) {
        driver.findElement(By.xpath("//*[text()='" + value + "']")).click();
    }

    public void uploadFile(String contentRoot) {
        String userDirectory = System.getProperty("user.dir");
        String path = userDirectory + contentRoot;
    }

    public void scrollIntoViewJS(WebElement element) {
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) driver);
        jsexecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<String> getBrowserLogs() {
        LogEntries logEntries = null;
        try {
            logEntries = driver
                    .manage()
                    .logs().get("browser");
        } catch (NoSuchSessionException ex) {
            return new LinkedList<>();
        }
        return logEntries.getAll()
                .stream()
                .map(LogEntry::getMessage)
                .collect(Collectors.toList());
    }

    public void maximizeWindowOfDriver() {
        driver.manage().window().maximize();
    }

    public void closeDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (WebDriverException exception) {
                LOGGER.error(exception.getMessage());
            }
        }
    }

    public void setImplicitlyTimeout(long valueInSecond) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(valueInSecond));
    }

    public void switchToTab(int numberOfTab) {
        ArrayList<String> newTb = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTb.get(numberOfTab));
        WaitUtils.waitFor(5000);
    }

    public void clearAllCookies() {
        driver.manage().deleteAllCookies();
    }

    public void setResolution(String resolution) {
        int width = Integer.parseInt(resolution.substring(0, resolution.indexOf("x")));
        int height = Integer.parseInt(resolution.substring(resolution.indexOf("x") + 1));
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void clickWebElement(WebElement webElement) {
        waitUtils.waitForElementClickable(webElement).click();
    }

    public boolean isEnabledWebElement(WebElement webElement) {
        return waitUtils.waitForElementClickable(webElement).isEnabled();
    }

    public void javaScriptClick(WebElement webElement) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", webElement);
    }

    public void moveMouseToElement(WebElement element) {
        new Actions(driver)
                .moveToElement(element)
                .perform();
        WaitUtils.waitFor(5000);
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollOffset(int x, int y) {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollBy(arguments[0],arguments[1])", x, y);
    }

    public void scrollToBottomOfPage() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public String getTextWithoutSubElements(WebElement element) {
        String fullText = element.getText()
                .trim();
        for (WebElement subElement : element.findElements(By.xpath(".//*"))) {
            fullText = fullText.replace(subElement.getText().trim(), "");
        }
        fullText = fullText.replaceAll("\n", "");
        return fullText;
    }

    public void sendKeysToElementWithWait(WebElement element, String value, long millsWait) {
        element.sendKeys(value);
        WaitUtils.waitFor(millsWait);
    }

    public boolean isElementVisibleWithWait(WebElement element, int mills) {
        try {
            waitUtils.waitForElementVisibleWithCustomTime(element, mills);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void clearTextBox(WebElement element) {
        element.clear();
    }

    public void goToURL(String url) {
        DriverManager.driver().get(url);
    }

    public By containsText(String str) {
        return By.xpath(String.format("//*[contains(text(), '%s')]", str));
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public void waitForSomeTime() {
        Uninterruptibles.sleepUninterruptibly(5, TimeUnit.SECONDS);
    }

    protected void waitForGivenTime(long time) {
        Uninterruptibles.sleepUninterruptibly(time, TimeUnit.SECONDS);
    }

    public String getXpath(String xpath, String value) {
        return String.format(xpath, value);
    }

    public String getXpath(String xpath, String value1, String value2) {
        return String.format(xpath, value1, value2);
    }

    // convert from WebElement to By
    public By toBy(WebElement we) {
        String[] data = we.toString().split(" -> ")[1].replace("]", "").split(": ");
        String locator = data[0];
        String term = data[1];

        switch (locator) {
            case "xpath":
                return By.xpath(term);
            case "css selector":
                return By.cssSelector(term);
            case "id":
                return By.id(term);
            case "tag name":
                return By.tagName(term);
            case "name":
                return By.name(term);
            case "link text":
                return By.linkText(term);
            case "class name":
                return By.className(term);
        }
        return (By) we;
    }

    public int getTodayDay() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public int getTodayMonth() {
        Calendar cal = Calendar.getInstance();
        return (cal.get(Calendar.MONTH) + 1);
    }

    public int getTodayYear() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    public static void scrollIntoView(WebElement randomCheckbox) {
        ((JavascriptExecutor) DriverManager.driver()).executeScript("arguments[0].scrollIntoView(true);", randomCheckbox);
    }

    public static void scrollToTop() {
        ((JavascriptExecutor) DriverManager.driver()).executeScript("window.scrollTo(0, 0);");
    }
}
