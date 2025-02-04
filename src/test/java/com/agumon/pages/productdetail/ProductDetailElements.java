package com.agumon.pages.productdetail;

import com.agumon.elements.internal.uat.UatProductDetailElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.List;


public class ProductDetailElements extends BaseElements {

    @FindBy(how = How.CLASS_NAME, using = UatProductDetailElements.itemCodeOfFirstItemInPDPClassName)
    @Title(value = "This is item code of first item in PDP")
    public WebElement itemCodeOfFirstItemInPDP;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.productMainImageXpath)
    @Title(value = "This is main image for product in product detail page")
    public WebElement productMainImage;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.uomDropDownXpath)
    @Title(value = "This is UOM drop down in product detail page")
    public WebElement uomDropDown;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.uomValueXpath)
    @Title(value = "This is UOM value box in product detail page")
    public WebElement uomValue;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.uomDropDownOptionsXpath)
    @Title(value = "This are options for UOM in UOM drop down in product detail page")
    public List<WebElement> uomDropDownOptions;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.moreInfoHyperLinksXpath)
    @Title(value = "This are more info hyperlinks in product detail page")
    public List<WebElement> moreInfoHyperLinks;

    @FindBy(how = How.XPATH, using = UatProductDetailElements.activeTabXpath)
    @Title(value = "This is the active tab of more info section in product detail page")
    public WebElement moreInfoActiveTab;
}
