package com.agumon.stepdefinition;

import com.agumon.stepdefinition.base.BaseStepDefinition;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static com.agumon.stepdefinition.message.AssertMessageManager.message;
import static org.junit.Assert.assertTrue;

public class ProductListingPageSteps extends BaseStepDefinition {

    @And("user is redirected to PLP page with searched results")
    public void userIsRedirectedToPLPPageWithSearchedResults() {
        productListingPage.userIsRedirectedToPLPPageWithSearchedResults();
    }

    @And("user clicks on first item image on product listing page")
    public void userClicksOnFirstItemImageOnProductListingPage() {
        productListingPage.clicksOnFirstItemImageOnProductListingPage();

    }

    @And("user is redirected to PLP page")
    public void userIsRedirectedToPLPPage() {
        productListingPage.userIsRedirectedToPLPPageWithSearchedResults();
    }

    @And("verify item codes of products correctly shown")
    public void verifyItemCodesOfProductsCorrectlyShown() throws Exception {
        productListingPage.itemCodesOfProductsCorrectlyShown();
    }

    @And("verify my list part shown in the PLP Cards")
    public void verifyMyListPartShownInThePLPCards() throws Exception {
        productListingPage.myListPartShownInPLPCards();
    }

    @And("verify UOM is shown in the PLP Cards")
    public void verifyUOMIsShownInThePLPCards() throws Exception {
        productListingPage.uomShownInPLPCards();
    }

    @And("verify user is on the PDP of first item")
    public void verifyUserIsOnThePDPOfFirstItem() {
        assertTrue(message().userNotInPDP(), productListingPage.userOnPDPOfFirstItem());
    }

    @Then("user changes quantity {string}")
    public void userChangesQuantity(String quantity) {
        productListingPage.userChangesQuantity(quantity);
    }

    @Then("user changes UOM of item in PLP")
    public void userChangesUOMOfItemInPLP() {
        productListingPage.userChangesUOMOfItemInPLP();
    }

    @And("user can add first item to cart by clicking Add to Cart button")
    public void userCanAddFirstItemToCartByClickingAddToCartButton() {
        productListingPage.addFirstItemToCartInPLP();
    }

    @Then("verify first item is added to cart")
    public void verifyFirstItemIsAddedToCart() {
        assertTrue(message().addedItemNotInCart(), productListingPage.firstItemAddedToCart());
    }

    @And("user clicks on Shop All Products within the category")
    public void userClicksOnShopAllProductsWithinTheCategory() throws IOException {
        productListingPage.userClicksOnShopAllProductsWithinTheCategory();
    }

    @Then("the user is landed on the category PLP")
    public void theUserIsLandedOnTheCategoryPLP() {
        productListingPage.theUserIsLandedOnTheCategoryPLP();
        assertTrue(message().categoryPlpPageIsNotDisplayed(), productListingPage.theUserIsLandedOnTheCategoryPLP());
    }
}