package com.agumon.pages.productlisting;

import com.agumon.stepdefinition.base.BasePage;
import com.agumon.utility.driver.DriverManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ProductListingPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ProductListingPage.class);
    public static final String DROPDOWN_NOT_DISPLAYED_ON_PLP = "Relevance dropdown is NOT displayed on PLP page";
    private static String itemCodeOfFirstItem = "";

    private static String categoryName = "Products";

    public void userIsRedirectedToPLPPageWithSearchedResults() {
        utils.wait(1);
        utils.waitForVisibility(productListingElements.relevanceDropdownID, 100);
        assertTrue(DROPDOWN_NOT_DISPLAYED_ON_PLP, productListingElements.relevanceDropdownID.isDisplayed());
    }

    public void clicksOnFirstItemImageOnProductListingPage() {
        utils.clickWebElement(productListingElements.productImages.get(0));
        utils.waitForPageToLoad(10);
    }

    public void itemCodesOfProductsCorrectlyShown() throws Exception {
        for (int i = 0; i < 8; i++) {
            utils.wait(1);
            utils.scrollIntoViewJS(productListingElements.itemCodesInPLPCards.get(i));
            if (!productListingElements.itemCodesInPLPCards.get(i).isDisplayed()) {
                throw new Exception("Item codes of products are NOT shown");
            }
        }
    }

    public void myListPartShownInPLPCards() throws Exception {
        for (int i = 0; i < 8; i++) {
            utils.wait(1);
            utils.scrollIntoViewJS(productListingElements.myListInPLPCards.get(i));
            if (!productListingElements.myListInPLPCards.get(i).isDisplayed()) {
                throw new Exception("My List part is NOT shown in PLP Cards");
            }
        }
    }

    public void uomShownInPLPCards() throws Exception {
        for (int i = 0; i < 8; i++) {
            utils.wait(1);
            utils.scrollIntoViewJS(productListingElements.uomInPLPCards.get(i));
            if (!productListingElements.uomInPLPCards.get(i).isDisplayed()) {
                throw new Exception("My UOM is NOT shown in PLP Cards");
            }
        }
    }

    public boolean userOnPDPOfFirstItem() {
        return productListingElements.itemCodesInPLPCards.get(0).getText().replace(" ", "")
                .equalsIgnoreCase(productDetailElements.itemCodeOfFirstItemInPDP.getText());
    }

    public void userChangesQuantity(String quantity) {
        utils.waitAndClick(productListingElements.quantityBoxesOfItemsInPLP.get(0));
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.BACK_SPACE).perform();
        utils.waitAndSendText(productListingElements.quantityBoxesOfItemsInPLP.get(0), quantity);
        utils.wait(5);
    }

    public void userChangesUOMOfItemInPLP() {
        utils.waitAndClick(productListingElements.uomBoxOfLB001);
        utils.waitAndClick(DriverManager.driver().findElement(By.xpath("//div[text()='CASE']")));
        utils.wait(5);
    }

    public void addFirstItemToCartInPLP() {
        itemCodeOfFirstItem = productListingElements.itemCodesInPLPCards.get(0).getText();
        utils.waitAndClick(productListingElements.addToCartButtonsInPLP.get(0));
    }

    public boolean firstItemAddedToCart() {
        return productListingElements.itemCodeOfFirstItemInCart.getText().equalsIgnoreCase(itemCodeOfFirstItem);
    }

    public void userClicksOnShopAllProductsWithinTheCategory() throws IOException {
            try {
                utils.waitFor(4);
                utils.clickWebElement(productListingElements.allProducts);
                List<WebElement> allCategoriesInAllProducts = productListingElements.allProductsCategoryLists;
                int randomIndex = new Random().nextInt(allCategoriesInAllProducts.size() - 1);
                WebElement randomCategory = allCategoriesInAllProducts.get(randomIndex);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].scrollIntoView(true);", randomCategory);
                categoryName = (String) js.executeScript("return arguments[0].innerText;", randomCategory);
                randomCategory.click();
                utils.waitFor(4);
                js.executeScript("window.scrollTo(0, 0);");
                utils.waitFor(4);

                //TODO Let's make this accessible globally. This is to circle the element clicked in screenshot.
                //TODO Now it highlights the element to be clicked but while taking the screenshot, the highlight is not visible. Let's implement it
                if (driver instanceof JavascriptExecutor) {
                    JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
                    jsExecutor.executeScript("arguments[0].style.border='2px solid red'",
                            productListingElements.allProductsSubCategoryShopAllLink);
                    Thread.sleep(1000);
                    jsExecutor.executeScript("arguments[0].style.border=''",
                            productListingElements.allProductsSubCategoryShopAllLink);
                    Thread.sleep(1000);
                    utils.getScreenshot("clicked category");
                    productListingElements.allProductsSubCategoryShopAllLink.click();
                    utils.waitFor(4);

                }
            } catch
            (InterruptedException e) {
                e.printStackTrace();
            }
        if (productListingElements.showing0of0productsText.isDisplayed()
                && productListingElements.showing0of0productsText.getText().equals("Showing 0 of 0 Results")) {
            driver.navigate().back();
            utils.waitFor(4);
        userClicksOnShopAllProductsWithinTheCategory();
    }
        }

    public boolean theUserIsLandedOnTheCategoryPLP() {
        String selectedFilterCategoryName = productListingElements.selectedFilterCategoryName.getText();
        return selectedFilterCategoryName.equals(categoryName);
    }

}