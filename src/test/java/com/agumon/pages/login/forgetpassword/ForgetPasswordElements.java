package com.agumon.pages.login.forgetpassword;

import com.agumon.elements.internal.uat.UatForgetPasswordElements;
import com.agumon.elements.production.develprod.ProdForgetPasswordElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgetPasswordElements extends BaseElements {

    @FindAll({
            @FindBy(how = How.ID, using = UatForgetPasswordElements.resetPasswordTextBoxId),
            @FindBy(how = How.XPATH, using = ProdForgetPasswordElements.resetPasswordTextBoxXpath),
    })
    @Title(value = "This is reset password text box in forget password page")
    public WebElement resetPasswordTextBox;

    @FindAll({
            @FindBy(how = How.CSS, using = UatForgetPasswordElements.resetPasswordButtonCss),
            @FindBy(how = How.XPATH, using = ProdForgetPasswordElements.resetPasswordButtonXpath),
            @FindBy(how = How.CSS, using = ProdForgetPasswordElements.resetPasswordButtonCss),
    })
    @Title(value = "This is reset password button in forget password page")
    public WebElement resetPasswordButton;
}
