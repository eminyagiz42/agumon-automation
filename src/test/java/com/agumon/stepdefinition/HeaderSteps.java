package com.agumon.stepdefinition;

import com.agumon.stepdefinition.base.BaseStepDefinition;
import com.agumon.utility.global.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class HeaderSteps extends BaseStepDefinition {

    public static final String NOT_ON_CART = "User is NOT in the cart";

    @Then("user goes to another page using account menu")
    public void userGoesToAnotherPageUsingAccountMenu() {
        headerComponent.goRandomlyFromUserMenu();
    }

    @Then("user clicks logo")
    public void userClicksLogo() {
        headerComponent.clickLogo();
    }

    @Then("user clicks All Products")
    public void userClicksAllProducts() {
        headerComponent.clickAllProducts();
    }

    @Then("verify Shop All Products pop-up is shown")
    public void verifyShopAllProductsPopUpIsShown() {
        headerComponent.verifyShopAllProductsPopUpIsShown();
    }

    @Then("verify Quick Order icon is shown")
    public void verifyQuickOrderIconIsShown() {
        assertTrue(headerComponent.quickOrderButtonDisplayed());
    }

    @Then("Verify that Branch Search box is shown.")
    public void verifyThatBranchSearchBoxIsShown() {
        assertTrue(headerComponent.branchSearchBoxIsDisplayed());
    }

    @Then("verify that column two is Ship-to's")
    public void verifyThatColumnTwoIsShipToS() {
        assertEquals(Constants.SHIP_TOS_COLUMN_NAME, headerComponent.getBranchDDColumnTwoName());
    }

    @Then("verify that shipto's column's radio buttons are displayed")
    public void verifyThatShipTosColumnsRadioButtonsAreDisplayed() {
        assertTrue(headerComponent.shipTosColumnsRadioButtonsAreDisplayed());
    }

    @When("user change customer")
    public void userChangeCustomer() {
        headerComponent.changeCustomer();
    }

    @When("user change branch")
    public void userChangeBranch() {
        headerComponent.changeBranch();
    }

    @When("user change Ship-to")
    public void userChangeShipto() {
        headerComponent.changeShipto();
    }

    @Then("Verify no radio buttons are active on Ship-to column")
    public void verifyNoRadioButtonsAreActiveOnShipToColumn() {
        assertFalse(headerComponent.radioButtonIsActive());
    }

    @Then("verify branch dropdown header information is updated")
    public void verifyDropdownHeaderInformationIsUpdated() {
        assertFalse(headerComponent.isOldBranchEqualWithNewBranch());
        //assertNotEquals(headerComponent.branchDDInfo, headerComponent.getCurrentBranchDDInfo());
    }

    @Then("verify Dropdown displays Branch customer ship-to")
    public void verifyDropdownDisplaysBranchCustomerShipTo() {
        assertTrue(headerComponent.isDropdownBranchCustomerShipTo());
    }

    @Then("user clicks Quick Order icon")
    public void userClicksQuickOrderIcon() {
        headerComponent.clickQuickOrder();
    }

    @Then("verify Quick Order pop-up is shown")
    public void verifyQuickOrderPopUpIsShown() {
        headerComponent.quickOrderPopUpDisplayed();
    }

    @Then("verify user is on outside the login")
    public void verifyUserIsOnOutsideTheLogin() {
        headerComponent.userOnOutsideOfLogin();
    }

    @Then("verify Quick Order icon is hidden")
    public void verifyQuickOrderIconIsHidden() {
        assertFalse(headerComponent.quickOrderButtonDisplayed());
    }

    @Then("verify Branch Customer Ship-To dropdown is shown")
    public void verifyBranchCustomerShipToDropdownIsShown() {
        assertTrue(headerComponent.branchCustomerShipToDropdownDisplayed());
    }

    @Then("user clicks Branch Customer Ship-To dropdown")
    public void userClicksBranchCustomerShipToDropdown() {
        headerComponent.clickBranchCustomerShipToDropdown();
    }

    @Then("verify Branch Customer Ship-To pop-up is shown")
    public void verifyBranchCustomerShipToPopUpIsShown() {
        assertTrue(headerComponent.headerBranchPopUpDisplayed());
    }

    @Then("verify Branch Customer Ship-To dropdown is hidden")
    public void verifyBranchCustomerShipToPopUpIsHidden() {
        assertFalse(headerComponent.branchCustomerShipToDropdownDisplayed());
    }

    @Then("verify active Branch Customer Ship-to display first in the list")
    public void verifyActiveBranchCustomerShipToDisplayFirstInTheList() {
        assertTrue(headerComponent.isActiveBCSDisplayedFirst());
    }

    @Given("user uploads logo on user profile page")
    public void userUploadsLogoOnUserProfilePage() {
        userProfilePage.uploadLogo();
    }

    @Given("user uploads gif logo on user profile page")
    public void userUploadsGifLogoOnUserProfilePage() {
        userProfilePage.uploadGifLogo();
    }

    @Then("Verify logo is saved on user profile page")
    public void verifyLogoIsSavedOnUserProfilePage() {
        assertTrue(userProfilePage.isLogoSaved());
    }

    @Then("user click on delete logo button")
    public void userClickOnDeleteLogoButton() {
        userProfilePage.clickDeleteLogoButton();
    }

    @Then("Verify logo is deleted on user profile page")
    public void verifyLogoIsDeletedOnUserProfilePage() {
        assertTrue(userProfilePage.isLogoDeleted());
    }

    @Then("verify logo is not saved")
    public void verifyLogoIsNotSaved() {
        assertFalse(userProfilePage.isLogoSaved());
    }

    @Then("verify warning message is shown")
    public void verifyWarningMessageIsShown() {
        assertTrue(userProfilePage.isWarningMessageShown());
    }

    @Given("user uploads multiple logo on user profile page")
    public void userUploadsMultipleLogoOnUserProfilePage() {
        userProfilePage.uploadMultipleLogo();
    }

    @Then("verify user can not upload multiple logo on user profile page")
    public void verifyUserCanNotUploadMultipleLogoOnUserProfilePage() {
        assertTrue(userProfilePage.isOneLogoSaved());
    }

    @When("verify User Menu dropdown is shown")
    public void verifyUserMenuDropdownIsShown() {
        assertTrue(headerComponent.userMenuDropDownIsDisplayed());
    }

    @Then("user clicks User Menu dropdown")
    public void userClicksUserMenuDropdown() {
        headerComponent.clickUserMenu();
    }

    @Then("verify User Menu pop-up is shown")
    public void verifyUserMenuPopUpIsShown() {
        assertTrue(headerComponent.userMenuPopUpIsDisplayed());
    }

    @And("verify User Menu dropdown is hidden")
    public void verifyUserMenuDropdownIsHidden() {
        assertFalse(headerComponent.userMenuDropDownIsDisplayed());
    }

    @And("verify Shopping Cart icon is shown")
    public void verifyShoppingCartIconIsShown() {
        assertTrue(headerComponent.shoppingCartIconIsDisplayed());
    }

    @Then("user clicks Shopping Cart icon")
    public void userClicksShoppingCartIcon() {
        headerComponent.goToCart();
    }

    @Then("verify user is on the {string} page")
    public void verifyUserIsOnThePage(String page) {
        assertTrue(headerComponent.userOnThePage(page));
    }

    @And("verify Shopping Cart icon is hidden")
    public void verifyShoppingCartIconIsHidden() {
        assertFalse(headerComponent.shoppingCartIconIsDisplayed());
    }

    @And("verify Pricing dropdown is shown")
    public void verifyPricingDropdownIsShown() {
        assertTrue(headerComponent.pricingDropdownIsDisplayed());
    }

    @Then("user clicks Pricing dropdown")
    public void userClicksPricingDropdown() {
        headerComponent.clickPricingDropDown();
    }

    @And("verify Pricing pop-up is shown")
    public void verifyPricingPopUpIsShown() {
        assertTrue(headerComponent.pricingPopUpIsDisplayed());
    }

    @And("user clicks on Billing")
    public void userClicksOnBilling() {
        billingPage.userClicksOnBilling();
    }

    @Then("verify branch dropdown header information is not updated")
    public void verifyBranchDropdownHeaderInformationIsNotUpdated() {
        assertTrue(headerComponent.isOldBranchEqualWithNewBranch());
        //assertEquals(headerComponent.branchDDInfo, headerComponent.getCurrentBranchDDInfo());
    }

    @When("user clicks on user profile list button")
    public void userClicksOnUserProfilelistButton() {
        headerComponent.clickUserProfileList();
    }

    @Then("verify manage account list is opened")
    public void verifyManageAccountListIsOpened() {
        assertTrue(headerComponent.isManageAccountListOpened());
    }

    @Then("verify manage account list is closed")
    public void verifyManageAccountListIsClosed() {
        assertFalse(headerComponent.isManageAccountListOpened());
    }

    @Then("verify user is on the user profile page")
    public void verifyUserIsOnTheUserProfilePage() {
        assertTrue(headerComponent.userOnUserProfilePage());
    }

    @Then("verify user is on the my lists page")
    public void verifyUserIsOnTheMyListsPage() {
        assertTrue(headerComponent.userOnUserMyListsPage());
    }

    @Given("user clicks on {string} in user profile list")
    public void userClicksOn(String menuName) {
        headerComponent.userClicksOnUserProfileList(menuName);
    }

    @And("user clicks Shop All Products")
    public void userClicksShopAllProducts() {
        headerComponent.clickShopAllProducts();
    }
}