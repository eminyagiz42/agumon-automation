package com.agumon.pages.home;

import com.agumon.stepdefinition.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

public class HeaderComponent extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(HeaderComponent.class);

    private static String branchDDInfo;

    public void goToBilling() {
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.accountNameButton, 5000);
        utils.clickWebElement(homeElements.accountNameButton);
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.billing, 3000);
        utils.clickWebElement(homeElements.billing);
        LOGGER.debug("Billing button clicked");
    }

    public void goRandomlyFromUserMenu() {
        utils.wait(3);
        utils.waitForVisibility(homeElements.accountNameButton, 3);
        utils.wait(10);
        utils.waitForVisibility(homeElements.accountNameButton, 10);
        utils.clickWebElement(homeElements.accountNameButton);
        final Integer number = utils.faker().random().nextInt(1, 5);
        utils.wait(3);
        utils.clickWebElement(homeElements.userMenuElements.get(number));
    }

    public void clickLogo() {
        utils.wait(5);
        //waitUtils.waitForElementVisibleWithCustomTime(null, 8000);
        //utils.clickWebElement(null);
        LOGGER.debug("Logo clicked");
    }

    public void clickAllProducts() {
        utils.wait(5);
        utils.wait(7);
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.allProductsAtHeader, 5000);
        utils.clickWebElement(homeElements.allProductsAtHeader);
        LOGGER.debug("All Products clicked");
    }

    public void verifyShopAllProductsPopUpIsShown() {
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.categoryList, 5000);
        Assert.assertTrue(homeElements.categoryList.isDisplayed());
        LOGGER.debug("Shop All Products PopUp is displayed");
    }

    public void clickQuickOrder() {
        waitUtils.waitForElementPresent(homeElements.quickOrderButton);
        utils.clickWebElement(homeElements.quickOrderButton);
        LOGGER.debug("Quick Order clicked");
    }

    public void quickOrderPopUpDisplayed() {
        Assert.assertTrue(homeElements.quickOrderBox.isDisplayed());
        LOGGER.debug("Quick Order pop-up displayed");
    }

    public boolean branchSearchBoxIsDisplayed() {
        return homeElements.branchDDSearchbox.isDisplayed();
    }

    public String getBranchDDColumnTwoName() {
        return homeElements.branchDDColumnTwo.getText();
    }

    public boolean shipTosColumnsRadioButtonsAreDisplayed() {
        return !homeElements.branchDDShipToCheckBoxesList.isEmpty();
    }

    public void userOnOutsideOfLogin() {
        Assert.assertTrue(homeElements.loginButton.isDisplayed());
        LOGGER.debug("User is on outside of login");
    }

    public boolean quickOrderButtonDisplayed() {
        utils.wait(5);
        try {
            homeElements.quickOrderButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean branchCustomerShipToDropdownDisplayed() {
        utils.wait(5);
        try {
            homeElements.headerBranchDD.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickBranchCustomerShipToDropdown() {
        utils.waitForPageToLoad(10);
        utils.wait(3);
        branchDDInfo = homeElements.headerBranchInfo.getText() + homeElements.headerShiptoInfo.getText();
        waitUtils.waitForElementPresent(homeElements.headerBranchDD);
        utils.clickWebElement(homeElements.headerBranchDD);
        LOGGER.debug("Branch/Customer/ShipTo clicked");
    }

    public boolean headerBranchPopUpDisplayed() {
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.headerBranchPopUp, 3000);
        try {
            homeElements.headerBranchPopUp.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean radioButtonIsActive() {
        boolean flag = false;
        for (WebElement e : homeElements.allshiptoCheckboxes) {
            if (e.isSelected()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public boolean isOldBranchEqualWithNewBranch() {
        utils.wait(3);
        final String newBranchDD = getCurrentBranchDDInfo();
        LOGGER.debug("Old value: \n" + branchDDInfo + "\n" + "New value: \n" + newBranchDD);
        return branchDDInfo.equals(newBranchDD);
    }

    private String getCurrentBranchDDInfo() {
        return homeElements.headerBranchInfo.getText() + homeElements.headerShiptoInfo.getText();
    }

    public boolean isDropdownBranchCustomerShipTo() {
        try {
            LOGGER.debug(homeElements.headerBranchPopUpBranchText.getText());
            return homeElements.headerBranchPopUpBranchText.getText().length() > 0;
        } catch (NullPointerException e) {
            LOGGER.error("There is no text \n" + e.getMessage());
            return false;
        }
    }

    public void changeBranch() {
        try {
            utils.clickWebElement(homeElements.branchSecondOption);
        } catch (Exception e) {
            LOGGER.error("User can not change the Branch!\n" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void changeCustomer() {
        try {
            waitUtils.waitForElementClickable(homeElements.customerSecondOption);
            utils.clickWebElement(homeElements.customerSecondOption);
        } catch (TimeoutException te) {
            LOGGER.warn("Customer column is not exist!");
        } catch (Exception e) {
            LOGGER.error("User can not change the customer!");
            e.printStackTrace();
        }
    }

    public boolean userOnThePage(String page) {
        utils.waitInMilis(3000);
        return driver.getCurrentUrl().contains(page);
    }

    public void changeShipto() {
        try {
            utils.clickWebElement(homeElements.shiptoSecondOption);
        } catch (Exception e) {
            LOGGER.warn("User can not change the shipto!");
            LOGGER.warn(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean userMenuDropDownIsDisplayed() {
        utils.wait(5);
        try {
            homeElements.accountNameButton.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickUserMenu() {
        utils.wait(5);
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.accountNameButton, 15000);
        utils.clickWebElement(homeElements.accountNameButton);
    }

    public boolean userMenuPopUpIsDisplayed() {
        try {
            homeElements.userMenuPopUp.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean shoppingCartIconIsDisplayed() {
        utils.wait(3);
        try {
            homeElements.cartIcon.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void goToCart() {
        waitUtils.waitForElementPresent(homeElements.cartIcon);
        utils.clickWebElement(homeElements.cartIcon);
    }

    public boolean pricingDropdownIsDisplayed() {
        utils.wait(3);
        try {
            homeElements.pricingDropDown.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void clickPricingDropDown() {
        utils.wait(5);
        waitUtils.waitForElementVisibleWithCustomTime(homeElements.pricingDropDown, 3000);
        utils.clickWebElement(homeElements.pricingDropDown);
    }

    public boolean pricingPopUpIsDisplayed() {
        try {
            homeElements.pricingPopUp.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    /**
     * Verifies Active Branch Customer Ship-to displayed first
     */
    public boolean isActiveBCSDisplayedFirst() {
        boolean flag = true;
        for (WebElement w : homeElements.headerBranchDDActivePaths) {
            if (!w.getText().equalsIgnoreCase("Active")) {
                flag = false;
                break;
            } else {
                LOGGER.debug(w.getText());
            }
        }
        return flag;
    }

    public void clickUserProfileList() {
        utils.wait(5);
        utils.waitInMilis(5000);
        utils.clickWebElement(homeElements.accountNameButton);
    }

    public boolean isManageAccountListOpened() {
        try {
            utils.waitInMilis(200);
            return homeElements.userMenu.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean userOnUserProfilePage() {
        return homeElements.userProfilePageTitle.getText().equalsIgnoreCase("User Profile");
    }

    public boolean userOnUserMyListsPage() {
        return homeElements.myListPageTitle.getText().equalsIgnoreCase("My Lists");
    }

    public void userClicksOnUserProfileList(String menuName) {
        for (int i = 0; i < homeElements.userMenuElements.size(); i++) {
            if (homeElements.userMenuElements.get(i).getText().equals(menuName)) {
                homeElements.userMenuElements.get(i).click();
                utils.waitForPageToLoad(15);
                break;
            }
        }

    }

    public void clickShopAllProducts() {
        utils.wait(3);
        utils.waitAndClick(homeElements.shopAllProducts);
        utils.waitForPageToLoad(10);
    }
}