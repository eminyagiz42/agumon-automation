package com.agumon.stepdefinition;

import com.agumon.stepdefinition.base.BaseStepDefinition;
import com.agumon.utility.global.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.agumon.stepdefinition.message.AssertMessageManager.message;
import static org.junit.Assert.*;


public class LoginSteps extends BaseStepDefinition {

    @When("User enter the login details and clicks sign in")
    public void userEnterTheLoginDetails() {
        loginPage.enterLoginDetailsAndClickSignIn();
    }

    @When("user enter the {string} as username and {string} as password and clicks sign in")
    public void userEnterTheAndAndClicksSignIn(String username, String password) {
        loginPage.enterLoginDetailsAndClickSignIn(username, password);
    }

    @And("User should log out successfully")
    public void userShouldLogOutSuccessfully() {
        homePage.logout();
    }

    @When("User clicks on Request an account link")
    public void userClicksOnRequestAnAccountLink() {
        loginPage.clickRequestAccountLink();
    }

    @Then("User fills all fields in Request an account form and submit the request")
    public void userFillsAllFieldsInRequestAnAccountForm() {
        requestAccountPage.fillAllFieldRequestAccountAndSubmit();
    }

    @Then("verify user is on the home page")
    public void verifyUserIsOnTheHomepage() {
        assertTrue(message().notOnHome(), homePage.verifyUserIsOnTheHomepage());
    }

    @Then("user enters invalid username and password clicks sign in and error message displayed")
    public void userEntersInvalidUsernameAndPasswordClicksSignInAndErrorMessageDisplayed(DataTable dataTable) {
        assertTrue(message().invalidAccountNotDisplayed(), loginPage.checkInvalidUserErrorMessageDisplayed(dataTable));
    }

    @Given("User enters credentials checks the Remember Me checkbox and logs in")
    public void userEntersCredentialsChecksTheRememberMeCheckboxAndLogsIn() {
        loginPage.enterLoginDetailsCheckRememberMeAndClickSignIn(Constants.USERNAME, Constants.PASSWORD);
    }

    @And("username is remembered by the site and the user enters password presses the sign in button")
    public void usernameIsRememberedByTheSiteAndTheUserEntersPasswordPressesTheSignInButton() {
        loginPage.userClicksSignIn(Constants.PASSWORD);
    }

    @And("Verify user name same with in the account menu")
    public void compareAccountName() {
        assertEquals(message().failedAccountNameComparison(), Constants.ACCOUNT_MENU_NAME, homePage.checkAccountName());
    }

    @When("User clicks on the Forgot Password link")
    public void userClicksOnTheForgotPasswordLink() {
        forgotPasswordPage.clickForgotPasswordLink();
    }

    @Then("User should see the Account recovery box")
    public void userShouldSeeTheAccountRecoveryBox() {
        assertTrue(message().resetPasswordFailed(), forgotPasswordPage.isRecoveryVerified());
    }

    @Then("Approval message should display")
    public void approvalMessageShouldDisplay(DataTable dataTable) {
        assertTrue(message().requestAccessReceived(), loginPage.messageIsDisplayed(dataTable));
    }

    @When("user clicks on somewhere")
    public void userClicksOnSomewhere() {
        loginPage.clicksOnSomewhere();
    }

}