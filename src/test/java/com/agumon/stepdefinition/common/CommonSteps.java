package com.agumon.stepdefinition.common;

import com.agumon.stepdefinition.base.BaseStepDefinition;
import com.agumon.utility.global.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static com.agumon.stepdefinition.message.AssertMessageManager.message;
import static org.junit.Assert.assertTrue;

public class CommonSteps extends BaseStepDefinition {

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.goToHomepageURL();
    }

    @Given("User navigates to the login page")
    public void userNavigatesToTheLoginPage() {
        if (!Constants.REDIRECTS_LOGIN_FLAG) {
            homePage.clickLoginButton();
        }
    }

    @Given("verify user is still on the login page")
    public void verifyUserIsStillOnTheLoginPage() {
        assertTrue(message().notOnLogin(), loginPage.verifyUserStillOnLoginPage());
    }

    @Then("user clicks on sign out and lands on login page")
    public void userClicksOnSignOutAndLandsOnLoginPage() {
        Assert.assertTrue("The user is not directed back to login page", loginPage.userClicksOnSignOutAndLandsOnLoginPage());
    }

}