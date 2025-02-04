package com.agumon.pages.cart;

import com.agumon.elements.internal.uat.UatCartElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CartElements extends BaseElements {

    @FindBy(how = How.LINK_TEXT, using = UatCartElements.deleteCartButton)
    @Title(value = "This is used to delete cart")
    public WebElement deleteCartButton;

    @FindBy(how = How.XPATH, using = UatCartElements.deleteCartOnPopUpXpath)
    @Title(value = "This is used to delete cart")
    public WebElement deleteCartonOnPopUp;



}
