package com.agumon.pages.home;

import com.agumon.stepdefinition.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class SearchbarComponent extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SearchbarComponent.class);

    public void userSearchesForAAndThenClickSearchIcon(String productName) {
        utils.waitAndSendText(homeElements.searchBar, productName);
        utils.wait(5);
        utils.waitAndSendText(homeElements.searchBar, "" + Keys.ENTER);
    }

    public String theResultsIncludeTheExactMatchForTheItem() {
        utils.wait(5);
        return productListingElements.itemTitleAbsXpath.getText();
    }

    public boolean theNoResultPageIsDisplayedSinceThereIsNoProduct() {
        return homeElements.notExistingProductText.isDisplayed();
    }

    public void userSearchesForTheItemCodeAndThenClickSearchIcon(String itemCode) {
        utils.waitAndSendText(homeElements.searchBar, itemCode);
        utils.wait(5);
        utils.waitAndSendText(homeElements.searchBar, "" + Keys.ENTER);
    }

    public String theResultsIncludeTheExactItemCodeForTheItem() {
        utils.wait(5);
        return homeElements.itemCode.getText();
    }

    /**
     * TODO: 6.12.2023
     * <p>
     * xref is not displayed on UI. Now an item with an xref is selected and searched here.
     * this should be improved while doing API tests.
     */
    public void userSearchesForTheXrefAndThenClickSearchIcon(String xref) {
        utils.waitAndSendText(homeElements.searchBar, xref);
        utils.wait(5);
        utils.waitAndSendText(homeElements.searchBar, "" + Keys.ENTER);
    }

    public String theProductWithTheXrefIsAndIsDisplayed(String product) {
        return productListingElements.itemTitleAbsXpath.getText();
    }

    public void userSearchesForTheKeywordAndThenClickSearchIcon(String keyword) {
        utils.waitAndSendText(homeElements.searchBar, keyword);
        utils.wait(5);
        utils.waitAndSendText(homeElements.searchBar, "" + Keys.ENTER);
    }

    public String theProductWithTheKeywordIsAndIsDisplayed(String product) {
        return productListingElements.itemTitleAbsXpath.getText();
    }

    public void userSearchesForTheKeyword(String suggestionKeyword) {
        utils.waitAndSendText(homeElements.searchBar, suggestionKeyword);
        utils.wait(5);
    }

    public boolean keywordSearchAndIsDisplayCaseInsensitive(String caseInsentitiveKeyword) {
        String lowerCaseKeyword = productListingElements.itemTitleAbsXpath.getText().toLowerCase();
        return lowerCaseKeyword.contains(caseInsentitiveKeyword.toLowerCase());
    }

    public void userIsRedirectedToPLPPageUponClickingOnAResult(String suggestedProduct) {
        List<WebElement> singleProductElement = homeElements.searchSingleSuggestionBox;
        for (WebElement element : singleProductElement) {
            if (element.getText().contains(suggestedProduct)) {
                element.click();
                break;
            }
        }
        utils.wait(5);
    }

    public boolean theSuggestionPartOfSearchShowsTheResultsFor(String suggestionKeyword) throws IOException {
        utils.getScreenshot("screenshotSuggest");
        return productListingElements.searchSuggestion.getText().contains(suggestionKeyword);
    }
}