package com.agumon.pages.productdetail;

import com.agumon.stepdefinition.base.BasePage;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ProductDetailPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ProductDetailPage.class);
    private static String choosenUOMType;

    public boolean isImageDisplayed() {
        return productDetailElements.productMainImage.isDisplayed();
    }

    public boolean isUOMChanged() {
        return productDetailElements.uomValue.getText().equals(choosenUOMType);
    }

    public void changeTheUOM() {
        utils.wait(2);
        utils.clickWebElement(productDetailElements.uomDropDown);
        utils.wait(2);
        final int randomOptionNumber = utils.faker().random().nextInt(0, productDetailElements.uomDropDownOptions.size() - 1);
        choosenUOMType = productDetailElements.uomDropDownOptions.get(randomOptionNumber).getText();
        utils.clickWebElement(productDetailElements.uomDropDownOptions.get(randomOptionNumber));
        utils.wait(2);
    }

    public boolean isUOMMenuShown() {
        return productDetailElements.uomDropDown.isDisplayed();
    }

    public boolean focusToAccordinglyTable(DataTable dataTable) {
        boolean flag = true;
        List<String> hyperlinks = dataTable.column(0);
        for (WebElement hyperlink : productDetailElements.moreInfoHyperLinks) {
            String hyperlinkText = hyperlink.getText();
            utils.clickWebElement(hyperlink);
            waitUtils.waitForElementVisible(productDetailElements.moreInfoActiveTab);
            if (!hyperlinkText.trim().equalsIgnoreCase(productDetailElements.moreInfoActiveTab.getText().trim())) {
                flag = false;
                break;
            }
            utils.scrollToTop();
            utils.wait(2);
        }
        return flag;
    }
}