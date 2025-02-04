package com.agumon.pages.home;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.driver.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static com.agumon.utility.global.Constants.*;

public class HomePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(HomePage.class);

    public void goToHomepageURL() {
        // if (utils.isAlertPresent()) {
        //DriverManager.driver().get(BASE_URL_WITH_AUTH);
        //}
        //utils.refreshPage();
        DriverManager.driver().get(BASE_URL);
        LOGGER.debug("Home page displayed");
    }

    public void clickLoginButton() {
        waitUtils.waitForElementPresent(homeElements.loginButton).click();
        LOGGER.debug("Login Link is clicked to go Login Page ");
    }

    public String checkAccountName() {
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.accountName, 100);
        return utils.getTextWithoutSubElements(homeElements.accountName);
    }

    public void logout() {
        utils.wait(10);
        utils.clickWebElement(homeElements.accountNameButton);
        utils.wait(5);
        utils.clickWebElement(homeElements.signOutButton);
        LOGGER.debug("Sign out button clicked");
    }

    public boolean verifyUserIsOnTheHomepage() {
        utils.wait(7);
        return DriverManager.driver().getCurrentUrl().equals(BASE_URL.concat("/"));
    }

    public void verifyUserIsLoggedIn() {
      //  utils.waitForVisibility(homeElements.checkoutIcon, 10);
       // homeElements.checkoutIcon.isDisplayed();
    }
}