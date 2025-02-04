package com.agumon.pages.notfound;

import com.agumon.elements.internal.uat.UatNotFoundElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class NotFoundElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatNotFoundElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
