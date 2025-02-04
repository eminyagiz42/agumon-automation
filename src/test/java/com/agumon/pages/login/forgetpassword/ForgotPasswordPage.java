package com.agumon.pages.login.forgetpassword;

import com.agumon.stepdefinition.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ForgotPasswordPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ForgotPasswordPage.class);

    public void clickForgotPasswordLink() {
        utils.clickWebElement(loginElements.forgetPasswordLink);
    }

    public boolean isRecoveryVerified() {
        utils.waitAndSendText(forgetPasswordElements.resetPasswordTextBox, utils.faker().greekPhilosopher().name());
        return forgetPasswordElements.resetPasswordButton.isDisplayed();
    }

}
