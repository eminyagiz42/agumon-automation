package com.agumon.pages.profile;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.global.Constants;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;

import java.io.File;


public class UserProfilePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(UserProfilePage.class);

    public void uploadLogo() {
        utils.waitForPageToLoad(10);
        utils.waitInMilis(2000);
        File uploadLogo = new File(Constants.PROFILE_LOGO_FILE_PATH);
        try {
            userProfileElements.fileUpload.sendKeys(uploadLogo.getAbsolutePath());
            utils.waitInMilis(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isLogoSaved() {
        try {
            return !userProfileElements.fileUpload.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void clickDeleteLogoButton() {
        utils.waitForPageToLoad(5);
        utils.hover(userProfileElements.logoImage);
        utils.waitInMilis(50);
        utils.hover(userProfileElements.logoImage);
        utils.hover(userProfileElements.logoImage);
        utils.clickWebElement(userProfileElements.deleteLogoButton);
    }

    public boolean isLogoDeleted() {
        try {
            return !userProfileElements.logoImage.isDisplayed();
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void uploadGifLogo() {
        File uploadLogo = new File(Constants.PROFILE_GIF_LOGO_FILE_PATH);
        utils.waitForPageToLoad(10);
        utils.waitInMilis(2000);
        try {
            userProfileElements.fileUpload.sendKeys(uploadLogo.getAbsolutePath());
            utils.waitInMilis(7000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isWarningMessageShown() {
        utils.waitForVisibility(userProfileElements.fileExtensionIsntJpgorPngMessage, 10);
        return userProfileElements.fileExtensionIsntJpgorPngMessage.isDisplayed();
    }

    public void uploadMultipleLogo() {
        utils.waitForPageToLoad(10);
        utils.waitInMilis(2000);
        File uploadLogo = new File(Constants.PROFILE_LOGO_FILE_PATH);
        File uploadLogo2 = new File(Constants.PROFILE_LOGO_FILE_PATH2);
        try {
            userProfileElements.fileUpload.sendKeys(uploadLogo.getAbsolutePath());
            userProfileElements.fileUpload.sendKeys(uploadLogo2.getCanonicalPath());
            utils.waitInMilis(7000);
        } catch (Exception e) {
            e.printStackTrace();
            utils.waitInMilis(4);
        }
        utils.waitInMilis(4);
    }

    public boolean isOneLogoSaved() {
        try {
            return !userProfileElements.secondLogoImage.isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            return true;
        }
    }
}