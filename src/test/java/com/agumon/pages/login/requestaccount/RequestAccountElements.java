package com.agumon.pages.login.requestaccount;

import com.agumon.elements.internal.uat.UatRequestAccountElements;
import com.agumon.elements.production.develprod.ProdRequestAccountElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RequestAccountElements extends BaseElements {

    @FindAll({
            @FindBy(how = How.CSS, using = UatRequestAccountElements.requestAccountNameTextBox),
            @FindBy(how = How.XPATH, using = ProdRequestAccountElements.requestAccountNameTextBoxXpath),
            @FindBy(how = How.CSS, using = ProdRequestAccountElements.requestAccountNameTextBoxCss)
    })
    @Title(value = "This is request account name text box in request account page")
    public WebElement requestAccountNameTextBox;


}
