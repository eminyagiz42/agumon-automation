package com.agumon.pages.order;


import com.agumon.elements.internal.uat.UatOrdersElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class OrdersElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatOrdersElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
