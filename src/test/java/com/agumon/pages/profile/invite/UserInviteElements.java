package com.agumon.pages.profile.invite;

import com.agumon.elements.internal.uat.UatUserInviteElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class UserInviteElements extends BaseElements {

    // please update it
    @FindBy(how = How.XPATH, using = UatUserInviteElements.exampleButtonXpath)
    @Title(value = "This is example input in billing page")
    public WebElement exampleInput;

}
