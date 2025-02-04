package com.agumon.pages.profile.mylist;

import com.agumon.elements.internal.uat.UatMyListElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MyListElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatMyListElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
