package com.agumon.pages.login;

import com.agumon.elements.internal.demo.DemoLoginElements;
import com.agumon.elements.internal.qa.QaLoginElements;
import com.agumon.elements.internal.uat.UatHomeElements;
import com.agumon.elements.internal.uat.UatLoginElements;
import com.agumon.elements.production.develprod.ProdLoginElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginElements extends BaseElements {

    @FindAll({
            @FindBy(how = How.ID, using = "user-name"),
            @FindBy(how = How.ID, using = ProdLoginElements.usernameTextBoxId),
            @FindBy(how = How.XPATH, using = "//input[@name='email']")
    })
    @Title(value = "This is user name text box in forget login page")
    public WebElement usernameTextBox;

    @FindAll({
            @FindBy(how = How.ID, using = "password"),
            @FindBy(how = How.CSS, using = UatLoginElements.passwordTextBoxCss),
            @FindBy(how = How.ID, using = QaLoginElements.passwordTextBoxId),
            @FindBy(how = How.CSS, using = QaLoginElements.passwordTextBoxCss),
            @FindBy(how = How.XPATH, using = QaLoginElements.passwordTextBoxXpath),
            @FindBy(how = How.ID, using = ProdLoginElements.passwordTextBoxId),
            @FindBy(how = How.XPATH, using = "//input[@name='password']")
    })
    @Title(value = "This is password text box in login page")
    public WebElement passwordTextBox;

    @FindAll({
            @FindBy(how = How.XPATH, using = UatLoginElements.rememberMeButtonXpath),
            @FindBy(how = How.XPATH, using = ProdLoginElements.rememberMeButtonXpath),
    })
    @Title(value = "This is remember me button in login page")
    public WebElement rememberMeButton;

    @FindAll({
            @FindBy(how = How.XPATH, using = UatLoginElements.forgetPasswordLinkXpath),
            @FindBy(how = How.XPATH, using = ProdLoginElements.forgetPasswordLinkXpath),
    })
    @Title(value = "This is forget password link text in login page")
    public WebElement forgetPasswordLink;

    @FindAll({
            @FindBy(how = How.ID, using = "login-button"),
            @FindBy(how = How.CSS, using = UatLoginElements.signInButtonCss),
            @FindBy(how = How.CSS, using = ProdLoginElements.signInButtonCss),
            @FindBy(how = How.XPATH, using = "//*[@id=\":rc:\"]"),
            @FindBy(how = How.CSS, using = "#\\:rd\\:")
    })
    @Title(value = "This is sign in button in login page")
    public WebElement signInButton;

    @FindAll({
            @FindBy(how = How.XPATH, using = UatLoginElements.loginErrorMessageXpath2),
            @FindBy(how = How.XPATH, using = UatLoginElements.loginErrorMessageXpath),
            @FindBy(how = How.CSS, using = UatLoginElements.loginErrorMessageCss),
            @FindBy(how = How.XPATH, using = ProdLoginElements.loginErrorMessageXpath),
            @FindBy(how = How.CSS, using = ProdLoginElements.loginErrorMessageCss),
    })
    @Title(value = "This is login error config in login page")
    public WebElement loginErrorMessage;

    @FindAll({
            @FindBy(how = How.CSS, using = UatLoginElements.requestAccountLinkCss),
            @FindBy(how = How.XPATH, using = ProdLoginElements.requestAccountLinkXpath),
            @FindBy(how = How.CSS, using = ProdLoginElements.requestAccountLinkCss)
    })
    @Title(value = "This is request Account Link in request login page")
    public WebElement requestAccountLink;

    @FindBy(how = How.XPATH, using = DemoLoginElements.demoSignInButton)
    @Title(value = "This is sign in button in backoffice home page")
    public WebElement demoSignInButton;

    @FindBy(how = How.XPATH, using = UatHomeElements.somewhereOnSiteXpath)
    @Title(value = "This is some where on all page")
    public WebElement somewhereOnSite;
}
