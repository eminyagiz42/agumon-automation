package com.agumon.pages.backoffice;


import com.agumon.elements.internal.uat.UatBackofficeElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class BackofficeElements extends BaseElements {

    @FindBy(how = How.NAME, using = UatBackofficeElements.usernameTextBoxName)
    @Title(value = "This is username text box in backoffice login page")
    public WebElement usernameTextBox;

    @FindBy(how = How.NAME, using = UatBackofficeElements.passwordTextBoxName)
    @Title(value = "This is password text box in backoffice login page")
    public WebElement passwordTextBox;

    @FindBy(how = How.ID, using = UatBackofficeElements.signInButtonId)
    @Title(value = "This is password text box in backoffice login page")
    public WebElement signInButton;

    @FindBy(how = How.ID, using = UatBackofficeElements.accountNameLinkId)
    @Title(value = "This is account name link text in backoffice home page")
    public WebElement accountName;

    @FindBy(how = How.XPATH, using = UatBackofficeElements.signOutButtonXpath)
    @Title(value = "This is sign out button in backoffice home page")
    public WebElement signOutButton;


}
