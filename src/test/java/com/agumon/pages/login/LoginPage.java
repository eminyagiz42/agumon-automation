package com.agumon.pages.login;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.driver.DriverManager;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.agumon.utility.global.Constants.*;

public class LoginPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class);

    public void enterLoginDetailsAndClickSignIn() {
        utils.sendKeysToElementWithWait(loginElements.usernameTextBox, USERNAME, 10);
        utils.sendKeysToElementWithWait(loginElements.passwordTextBox, PASSWORD, 10);

            waitUtils.waitForElementVisibleWithCustomTime(loginElements.signInButton, 30).click();
    }

    public void enterLoginDetailsAndClickSignIn(String userName, String password) {
        utils.sendKeysToElementWithWait(loginElements.usernameTextBox, userName, 10);
        utils.sendKeysToElementWithWait(loginElements.passwordTextBox, password, 10);
            waitUtils.waitForElementVisibleWithCustomTime(loginElements.signInButton, 30).click();
    }

    private boolean isDemoStorefront() {
        return BASE_URL.equalsIgnoreCase(DEMO_STOREFRONT);
    }

    public boolean messageIsDisplayed(DataTable table) {
        final By containsXpath = utils.containsText(table.row(1).get(0));
        WebElement toastMessage = waitUtils.waitForElementVisibleWithCustomTime(containsXpath, 3000); // 3 second
        utils.hover(toastMessage);
        LOGGER.debug(toastMessage.getText());
        return toastMessage.isDisplayed();
    }

    public boolean checkInvalidUserErrorMessageDisplayed(DataTable dataTable) {
        List<String> credentials = dataTable.row(1);
        utils.sendKeysToElementWithWait(loginElements.usernameTextBox, credentials.get(0), 10);
        utils.sendKeysToElementWithWait(loginElements.passwordTextBox, credentials.get(1), 10);
        waitUtils.waitForElementPresent(loginElements.signInButton).click();
        waitUtils.waitForElementPresent(loginElements.loginErrorMessage);
        return waitUtils.waitForElementPresent(loginElements.loginErrorMessage).getText().equals(credentials.get(2));
    }

    public boolean verifyUserStillOnLoginPage() {
        utils.wait(5);
        return DriverManager.driver().getCurrentUrl().equalsIgnoreCase(LOGIN_URL);
    }

    public void enterLoginDetailsCheckRememberMeAndClickSignIn(String username, String password) {
        waitUtils.waitForElementPresent(loginElements.usernameTextBox);
        utils.sendKeysToElementWithWait(loginElements.usernameTextBox, username, 10);
        utils.sendKeysToElementWithWait(loginElements.passwordTextBox, password, 10);
        utils.selectCheckBox(loginElements.rememberMeButton, true);
        waitUtils.waitForElementClickableWithCustomTime(loginElements.signInButton, 30);
        utils.clickWebElement(loginElements.signInButton);
    }

    public void userClicksSignIn(String password) {
        utils.sendKeysToElementWithWait(loginElements.passwordTextBox, password, 10);
        utils.clickWebElement(loginElements.signInButton);
    }

    public void clickRequestAccountLink() {
        waitUtils.waitForElementClickable(loginElements.requestAccountLink).click();
        LOGGER.debug("Username password entered, Sign In button clicked");
    }

    public void clicksOnSomewhere() {

        utils.clickWebElement(loginElements.somewhereOnSite);
    }

    public boolean userClicksOnSignOutAndLandsOnLoginPage() {
        WebElement signOut = homeElements.userMenuElements.get(homeElements.userMenuElements.size() - 1);
        signOut.click();
        utils.wait(7);
        return loginElements.signInButton.isDisplayed();
    }
}
