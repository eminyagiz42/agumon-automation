package com.agumon.pages.productlisting;

import com.agumon.elements.internal.uat.UatHomeElements;
import com.agumon.elements.internal.uat.UatProductListingElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class ProductListingElements extends BaseElements {

    @FindBy(how = How.ID, using = UatProductListingElements.relevanceDropdownID)
    @Title(value = "")
    public WebElement relevanceDropdownID;

    @FindBy(how = How.XPATH, using = UatProductListingElements.itemTitleAbsXpath)
    @Title(value = "")
    public WebElement itemTitleAbsXpath;

    @FindBy(how = How.XPATH, using = UatProductListingElements.productImagesXpath)
    @Title(value = "These are product images in product listing page")
    public List<WebElement> productImages;

    @FindBy(how = How.CSS, using = UatHomeElements.searchSuggestion)
    @Title(value = "This is the search suggestion dropdown part when a keyword is entered on search bar ")
    public WebElement searchSuggestion;

    @FindBy(how = How.ID, using = UatProductListingElements.allProductsID)
    @Title(value = "This is the all products menu item ")
    public WebElement allProducts;

    @FindBy(how = How.XPATH, using = UatProductListingElements.allProductsCategoryListsXPATH)
    @Title(value = "This is the all products menu item ")
    public List<WebElement> allProductsCategoryLists;

    @FindBy(how = How.XPATH, using = UatProductListingElements.allProductsSubCategoryShopAllLinkXPATH)
    @Title(value = "This is the shop all ctageory products link within a category ")
    public WebElement allProductsSubCategoryShopAllLink;

    @FindBy(how = How.XPATH, using = "//*[@id=\"header_container\"]/div[2]/span")
    @Title(value = "This is the name of the category clicked on shop all menu shown on plp page filters area ")
    public WebElement selectedFilterCategoryName;

    @FindBy(how = How.XPATH, using = UatProductListingElements.showing0of0productsTextXPATH)
    @Title(value = "This is the name of the category clicked on shop all menu shown on plp page filters area ")
    public WebElement showing0of0productsText;

    @FindBy(how = How.XPATH, using = UatProductListingElements.plpProductsItemCodesXpath)
    @Title(value = "These are item codes in PLP")
    public List<WebElement> itemCodesInPLPCards;

    @FindBy(how = How.XPATH, using = UatProductListingElements.myListInPLPCardsXpath)
    @Title(value = "These are My List parts in PLP")
    public List<WebElement> myListInPLPCards;

    @FindBy(how = How.XPATH, using = UatProductListingElements.uomInPLPCardsXpath)
    @Title(value = "These are UOM parts in PLP")
    public List<WebElement> uomInPLPCards;

    @FindBy(how = How.XPATH, using = UatProductListingElements.quantityBoxesOfItemsInPLPXpath)
    @Title(value = "These are Quantity parts in PLP")
    public List<WebElement> quantityBoxesOfItemsInPLP;

    @FindBy(how = How.XPATH, using = UatProductListingElements.uomBoxOfLB001Xpath)
    @Title(value = "This is UOM of LB001 in PLP")
    public WebElement uomBoxOfLB001;

    @FindBy(how = How.XPATH, using = UatProductListingElements.addToCartButtonsInPLP)
    @Title(value = "These are Add to Cart buttons in PLP")
    public List<WebElement> addToCartButtonsInPLP;

    @FindBy(how = How.CSS, using = UatProductListingElements.itemCodeOfFirstItemInCartCSS)
    @Title(value = "This is UOM of LB001 in PLP")
    public WebElement itemCodeOfFirstItemInCart;

}
