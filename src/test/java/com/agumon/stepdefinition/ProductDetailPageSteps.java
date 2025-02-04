package com.agumon.stepdefinition;

import com.agumon.stepdefinition.base.BaseStepDefinition;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertTrue;

public class ProductDetailPageSteps extends BaseStepDefinition {

    @Then("verify product images shown on product detail page")
    public void verifyProductImagesShownOnProductDetailPage() {
        assertTrue(productDetailPage.isImageDisplayed());
    }

    @Then("verify UOM menu is shown on product listing page")
    public void verifyUOMMenuIsShownOnProductListingPage() {
        assertTrue("UOM Menu is not shown!", productDetailPage.isUOMMenuShown());
    }

    @And("user changes UOM on product listing page")
    public void userChangesUOMOnProductListingPage() {
        productDetailPage.changeTheUOM();
    }

    @Then("verify UOM type is changed")
    public void verifyUOMTypeIsChanged() {
        assertTrue(productDetailPage.isUOMChanged());
    }

    @Then("verif user clicks on hyperlinks from More Info section and focus to accordingly table")
    public void verifUserClicksOnFromMoreInfoSectionAndFocusToAccordinglyTable(DataTable dataTable) {
        assertTrue(productDetailPage.focusToAccordinglyTable(dataTable));
    }
}