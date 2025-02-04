package com.agumon.pages.payment;

import com.agumon.elements.internal.uat.UatPaymentElements;
import com.agumon.utility.annotations.Title;
import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class PaymentElements extends BaseElements {

    @FindBy(how = How.XPATH, using = UatPaymentElements.payFullBalanceValueXpath)
    @Title(value = "This is the Value of pay full balance in the payment page")
    public WebElement payFullBalanceValue;

    @FindBy(how = How.CSS, using = UatPaymentElements.payPartialBalanceValueCSS)
    @Title(value = "This is the text of pay partial balance in the payment page")
    public WebElement payPartialBalanceValue;

    @FindBy(how = How.XPATH, using = UatPaymentElements.amountToPayXpath)
    @Title(value = "This is the amount To Pay values for full payment")
    public List<WebElement> amountToPay;

    @FindBy(how = How.CSS, using = UatPaymentElements.amountToPayPartialCSS)
    @Title(value = "This is the amount To Pay values for partial payment")
    public List<WebElement> amountToPayPartial;

    @FindBy(how = How.CSS, using = UatPaymentElements.invoiceIdOnInvoiceSummaryCSS)
    @Title(value = "This are the invoice Id's on invoice summary")
    public List<WebElement> invoiceIdOnInvoiceSummary;

    @FindBy(how = How.XPATH, using = UatPaymentElements.xButtonForDeleteXpath)
    @Title(value = "This is the text of pay full balance in the payment page")
    public WebElement xButtonForDelete;

    @FindBy(how = How.XPATH, using = UatPaymentElements.arrowIconXpath)
    @Title(value = "This is the text of pay full balance in the payment page")
    public WebElement arrowIcon;

    @FindBy(how = How.XPATH, using = UatPaymentElements.availDiscFirstXpath)
    @Title(value = "This is the text of pay full balance in the payment page")
    public WebElement availDiscFirst;

    @FindBy(how = How.XPATH, using = UatPaymentElements.availDiscPaymentSumXpath)
    @Title(value = "This is the text of pay full balance in the payment page")
    public WebElement availDiscPaymentSum;

    @FindBy(how = How.CSS, using = UatPaymentElements.paymentSumIIconCSS)
    @Title(value = "This is the text of pay full balance in the payment page")
    public WebElement paymentSumIIcon;

    @FindBy(how = How.XPATH, using = UatPaymentElements.payByBankAccountButtonXPATH)
    @Title(value = "This is pay by bank account radio button")
    public WebElement payByBankAccountButton;

    @FindBy(how = How.CSS, using = UatPaymentElements.submitPaymentButtonCSS)
    @Title(value = "This is submit payment button")
    public WebElement submitPaymentButton;

    @FindBy(how = How.XPATH, using = UatPaymentElements.paidAmountOnInvoiceSummaryOnConfirmationPageXPATH)
    @Title(value = "This is the amount paid displayed on confirmation page")
    public WebElement paidAmountOnInvoiceSummaryOnConfirmationPage;

    @FindBy(how = How.XPATH, using = UatPaymentElements.singleInvoiceidOnPaymentPageXPATH)
    @Title(value = "This is the single invoice ID on payment page")
    public WebElement singleInvoiceidOnPaymentPage;

    @FindBy(how = How.XPATH, using = UatPaymentElements.singleInvoiceidOnConfirmationPageXPATH)
    @Title(value = "This is the single invoice ID on confirmation page")
    public WebElement singleInvoiceidOnConfirmationPage;

    @FindBy(how = How.XPATH, using = UatPaymentElements.returnToBillingButtonOnConfirmationPageXPATH)
    @Title(value = "This is the return to billing link on payment confirmation page")
    public WebElement returnToBillingButtonOnConfirmationPage;

    @FindBy(how = How.XPATH, using = UatPaymentElements.paymentDueAmountOnPaymentSummaryXPATH)
    @Title(value = "This is the payment due amount on payment summary screen")
    public WebElement paymentDueAmountOnPaymentSummary;

    @FindBy(how = How.XPATH, using = UatPaymentElements.PaymentDueAmountOnPaymentConfirmationXPATH)
    @Title(value = "This is the payment due amount on payment confirmation page")
    public WebElement paymentDueAmountOnPaymentConfirmation;
}