package com.agumon.pages.home;

import com.agumon.elements.internal.demo.DemoHomeElements;
import com.agumon.elements.internal.qa.QaHomeElements;
import com.agumon.elements.internal.uat.UatHomeElements;
import com.agumon.elements.production.develprod.ProdHomeElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class HomeElements extends BaseElements {

    @FindAll({
            @FindBy(how = How.XPATH, using = UatHomeElements.loginButtonXpath),
            @FindBy(how = How.CSS, using = UatHomeElements.loginButtonCss),
            @FindBy(how = How.CSS, using = ProdHomeElements.loginButtonCss),
            @FindBy(how = How.XPATH, using = DemoHomeElements.loginAvatarButtonXpath)
    })
    @Title(value = "This is login button element in home page")
    public WebElement loginButton;

    @FindAll({
            @FindBy(how = How.XPATH, using = UatHomeElements.accountNameXpath),
            @FindBy(how = How.XPATH, using = UatHomeElements.accountNameXpath2),
            @FindBy(how = How.XPATH, using = UatHomeElements.accountNameXpath3),
            @FindBy(how = How.XPATH, using = UatHomeElements.accountNameXpath4),
            @FindBy(how = How.ID, using = QaHomeElements.accountNameButtonId),
            @FindBy(how = How.XPATH, using = QaHomeElements.accountNameXpath)
    })
    @Title(value = "This is account name element in home page")
    public WebElement accountName;

    @FindAll({
            @FindBy(how = How.ID, using = UatHomeElements.accountNameButtonId),
            @FindBy(how = How.ID, using = UatHomeElements.accountNameButtonXpath),
            @FindBy(how = How.CSS, using = ProdHomeElements.accountNameButtonCss),
            @FindBy(how = How.XPATH, using = ProdHomeElements.accountNameButtonXpath),
    })
    @Title(value = "This is account name button element in home page")
    public WebElement accountNameButton;

    @FindAll({
            @FindBy(how = How.XPATH, using = UatHomeElements.signOutButtonXpath),
            @FindBy(how = How.CSS, using = UatHomeElements.signOutButtonCss),
            @FindBy(how = How.XPATH, using = ProdHomeElements.signOutButtonXpath),
            @FindBy(how = How.CSS, using = ProdHomeElements.signOutButtonCss),
            @FindBy(how = How.XPATH, using = DemoHomeElements.profileLogoutButtonXpath)
    })
    @Title(value = "This is sign out button in home page")
    public WebElement signOutButton;

    @FindAll({
            @FindBy(how = How.XPATH, using = DemoHomeElements.productPageButtonAddToCartXpath),
    })
    @Title(value = "This is add to cart button in home page")
    public WebElement productPageButtonAddToCart;

    @FindAll({
            @FindBy(how = How.XPATH, using = DemoHomeElements.searchBoxInputXpath),
    })
    @Title(value = "This is search box input in home page")
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = DemoHomeElements.quickAddButtonCss)
    @Title(value = "This is quick add button in home page")
    public WebElement quickAddButton;

    @FindBy(how = How.XPATH, using = DemoHomeElements.backofficeDashboardTextXpath)
    @Title(value = "This is backoffice dashboard button in home page")
    public WebElement backofficeDashboard;

    @FindBy(how = How.XPATH, using = DemoHomeElements.profileAvatarButtonXpath)
    @Title(value = "This is profile avatar button in home page")
    public WebElement profileAvatarButton;

    @FindBy(how = How.XPATH, using = DemoHomeElements.profileMyAccountButtonXpath)
    @Title(value = "This is backoffice dashboard button in home page")
    public WebElement profileMyAccountButton;

    @FindBy(how = How.XPATH, using = DemoHomeElements.profileCompanyButtonXpath)
    @Title(value = "This is backoffice dashboard button in home page")
    public WebElement profileCompanyButton;

    @FindBy(how = How.XPATH, using = DemoHomeElements.homepageMainLogoXpath)
    @Title(value = "This is backoffice dashboard button in home page")
    public WebElement homepageMainLogo;

    @FindBy(how = How.XPATH, using = DemoHomeElements.productPageButtonColourOneXpath)
    @Title(value = "This is product button color in home page")
    public WebElement productPageButtonColourOne;

    @FindBy(how = How.XPATH, using = DemoHomeElements.productPageButtonColourTwoXpath)
    @Title(value = "This is product button color in home page")
    public WebElement productPageButtonColourTwo;

    @FindBy(how = How.XPATH, using = DemoHomeElements.productPageButtonColourThreeXpath)
    @Title(value = "This is product button color three in home page")
    public WebElement productPageButtonColourThree;

    @FindBy(how = How.XPATH, using = DemoHomeElements.productPageInputQuantityXpath)
    @Title(value = "This is quantity input in home page")
    public WebElement productPageInputQuantity;

    @FindBy(how = How.ID, using = UatHomeElements.AllProductsID)
    @Title(value = "This is All Products at header")
    public WebElement allProductsAtHeader;

    @FindBy(how = How.ID, using = UatHomeElements.categoryListID)
    @Title(value = "This is category list")
    public WebElement categoryList;

    @FindBy(how = How.XPATH, using = UatHomeElements.billingButton)
    @Title(value = "This is used to go Billing")
    public WebElement billing;

    @FindBy(how = How.ID, using = UatHomeElements.quickOrderButtonID)
    @Title(value = "This is Quick Order Button")
    public WebElement quickOrderButton;

    @FindBy(how = How.XPATH, using = UatHomeElements.quickOrderBoxXpath)
    @Title(value = "This is Quick Order Box")
    public WebElement quickOrderBox;

    @FindBy(how = How.ID, using = UatHomeElements.headerBranchDD_ID)
    @Title(value = "This is Branch Customer Ship-To DropDown")
    public WebElement headerBranchDD;

    @FindBy(how = How.XPATH, using = UatHomeElements.headerBranchPopUpXpath)
    @Title(value = "This is Branch Customer Ship-To pop up")
    public WebElement headerBranchPopUp;

    @FindBy(how = How.XPATH, using = UatHomeElements.headerBranchPopUpXpath + "/h6")
    @Title(value = "This is Branch Customer Ship-To pop up")
    public WebElement headerBranchPopUpBranchText;

    @FindBy(how = How.ID, using = UatHomeElements.branchDDSearchboxesID)
    @Title(value = "This is searchbox on Branch Customer Ship-To DD ")
    public WebElement branchDDSearchbox;

    @FindBy(how = How.XPATH, using = UatHomeElements.checkoutIcon)
    @Title(value = "")
    public WebElement checkoutIcon;

    @FindBy(how = How.XPATH, using = UatHomeElements.searchBar)
    @Title(value = "")
    public WebElement searchBar;

    @FindBy(how = How.XPATH, using = UatHomeElements.searchBarButton)
    @Title(value = "")
    public WebElement searchBarButton;

    @FindBy(how = How.CSS, using = UatHomeElements.notExistingProductText)
    @Title(value = "")
    public WebElement notExistingProductText;

    @FindBy(how = How.XPATH, using = UatHomeElements.itemCode)
    @Title(value = "")
    public WebElement itemCode;

    @FindBy(how = How.XPATH, using = UatHomeElements.branchDDColumnTwoXpath)
    @Title(value = "This is second column on Branch Customer Ship-To DD ")
    public WebElement branchDDColumnTwo;

    @FindBy(how = How.XPATH, using = UatHomeElements.branchDDShipToCheckBoxesXpath)
    @Title(value = "These are ship to's CheckBoxes on Branch Customer Ship-To DD ")
    public List<WebElement> branchDDShipToCheckBoxesList;

    @FindBy(how = How.XPATH, using = UatHomeElements.searchSingleSuggestionBox)
    @Title(value = "This is the single product within search suggestion dropdown ")
    public List<WebElement> searchSingleSuggestionBox;

    @FindBy(how = How.XPATH, using = UatHomeElements.userMenuPopUpXpath)
    @Title(value = "This is User Menu Pop-Up")
    public WebElement userMenuPopUp;

    @FindBy(how = How.XPATH, using = UatHomeElements.shoppingCartIconXpath)
    @Title(value = "This is Shopping Cart icon on header")
    public WebElement cartIcon;

    @FindBy(how = How.ID, using = UatHomeElements.pricingDDId)
    @Title(value = "This is Pricing dropdown on header")
    public WebElement pricingDropDown;

    @FindBy(how = How.XPATH, using = UatHomeElements.pricingPopUpXpath)
    @Title(value = "This is Pricing pop-up")
    public WebElement pricingPopUp;

    @FindBy(how = How.XPATH, using = UatHomeElements.userMenuElementsXpath)
    @Title(value = "This is list of user menu elements")
    public List<WebElement> userMenuElements;

    @FindBy(how = How.XPATH, using = UatHomeElements.allshiptoCheckboxesXPath)
    @Title(value = "This are ship to's CheckBoxes on Branch Customer Ship-To DD ")
    public List<WebElement> allshiptoCheckboxes;

    @FindBy(how = How.XPATH, using = UatHomeElements.branchSecondOptionXPath)
    @Title(value = "This is Second Option for branches on Branch Customer Ship-To DD ")
    public WebElement branchSecondOption;

    @FindBy(how = How.XPATH, using = UatHomeElements.customerSecondOptionXPath)
    @Title(value = "This is Second Option for customers on Branch Customer Ship-To DD ")
    public WebElement customerSecondOption;

    @FindBy(how = How.ID, using = UatHomeElements.shiptoSecondOptionID)
    @Title(value = "This is Second Option for shipto on Branch Customer Ship-To DD ")
    public WebElement shiptoSecondOption;

    @FindBy(how = How.XPATH, using = UatHomeElements.headerBranchInfoXPath)
    @Title(value = "This is Branch Customer Ship-To DD - branch info ")
    public WebElement headerBranchInfo;

    @FindBy(how = How.XPATH, using = UatHomeElements.headerShiptoInfoXPath)
    @Title(value = "This is Branch Customer Ship-To DD - branch info ")
    public WebElement headerShiptoInfo;

    @FindBy(how = How.XPATH, using = UatHomeElements.headerBranchDDActivePathsXPath)
    @Title(value = "This are Branch Customer Ship-To DD Active paths")
    public List<WebElement> headerBranchDDActivePaths;

    @FindBy(how = How.XPATH, using = UatHomeElements.userMenuXpath)
    @Title(value = "This is user menu")
    public WebElement userMenu;

    @FindBy(how = How.XPATH, using = UatHomeElements.userProfilePageTitleXpath)
    @Title(value = "This is user profile page title")
    public WebElement userProfilePageTitle;

    @FindBy(how = How.XPATH, using = UatHomeElements.myListPageTitleXpath)
    @Title(value = "This is user profile page title")
    public WebElement myListPageTitle;

    @FindBy(how = How.XPATH, using = UatHomeElements.shopAllProductsXpath)
    @Title(value = "This is Shop All Products button")
    public WebElement shopAllProducts;

    @FindBy(how = How.XPATH, using = UatHomeElements.bathProductsXpath)
    @Title(value = "This is Bath Products button")
    public WebElement bathProducts;

}