package com.agumon.pages.quotes;

import com.agumon.elements.internal.uat.UatQuotesElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class QuotesElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatQuotesElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
