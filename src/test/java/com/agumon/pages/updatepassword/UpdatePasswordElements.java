package com.agumon.pages.updatepassword;

import com.agumon.elements.internal.uat.UatUpdatePasswordElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class UpdatePasswordElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatUpdatePasswordElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
