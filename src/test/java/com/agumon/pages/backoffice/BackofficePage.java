package com.agumon.pages.backoffice;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.driver.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static com.agumon.utility.global.Constants.*;


public class BackofficePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(BackofficePage.class);

    public void userNavigatesToBackofficeLogin() {
        utils.goToURL(BACKOFFICE_URL);
    }

    public void userEntersRandomInvalidCredentials() {
        utils.wait(4);
        utils.sendKeysToElementWithWait(backofficeElements.usernameTextBox, utils.faker().name().username(), 10);
        utils.sendKeysToElementWithWait(backofficeElements.passwordTextBox, utils.faker().internet().password(), 10);
    }

    public void userClicksSignInButton() {
        waitUtils.waitForElementPresent(backofficeElements.signInButton).click();
    }

    public boolean verifyMessageDisplayed(String message) {
        final By messageXpath = utils.containsText(message);
        WebElement toastMessage = waitUtils.waitForElementVisibleWithCustomTime(messageXpath, 1000);
        utils.hover(toastMessage);
        return toastMessage.isDisplayed();
    }

    public void userEntersAdminCredentials() {
        utils.sendKeys(backofficeElements.usernameTextBox, BACKOFFICE_USERNAME);
        utils.sendKeys(backofficeElements.passwordTextBox, BACKOFFICE_PASSWORD);
    }

    public String verifyUserIsOnBackofficeHome() {
        utils.wait(3);
        return waitUtils.waitForElementVisibleWithCustomTime(backofficeElements.accountName, 1000).getText();
    }

    public void userClicksLogOutButton() {
        Actions action = new Actions(DriverManager.driver());
        action.moveToElement(backofficeElements.accountName).click().build().perform();
        utils.waitForClickablility(backofficeElements.signOutButton, 1000).click();
    }

    public boolean verifyUserIsOnBackofficeLogin() {
        return waitUtils.waitForElementPresent(backofficeElements.signInButton).getText().equals("SIGN IN");
    }
}