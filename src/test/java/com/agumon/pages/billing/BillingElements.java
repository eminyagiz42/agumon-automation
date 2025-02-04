package com.agumon.pages.billing;

import com.agumon.elements.internal.uat.UatBillingElements;
import com.agumon.utility.base.BaseElements;
import com.agumon.utility.annotations.Title;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class BillingElements extends BaseElements {

    @FindBy(how = How.XPATH, using = UatBillingElements.paySelectedInvoicesButtonXPATH)
    @Title(value = "This is the pay button on the invoice page")
    public WebElement paySelectedInvoicesButton;

    @FindBy(how = How.XPATH, using = UatBillingElements.payPartialBalanceRadioButtonXPATH)
    @Title(value = "This is the checkbox for pay partial balance radio button")
    public WebElement payPartialBalanceRadioButton;

    //    @FindBy(how = How.XPATH, using = UatBillingElements.paySelectedInvoicesButtonXPATH)
    @Title(value = "This is the pay button on the invoice page")
    public By paySelectedInvoicesButton2 = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[1]/div[2]/div/div[2]/div[2]/div/button");

    @FindBy(how = How.XPATH, using = UatBillingElements.avaliableCreditsAccordionXPATH)
    @Title(value = "This is the accordion to open available credits tab on payment page")
    public WebElement avaliableCreditsAccordion;

    @FindBy(how = How.XPATH, using = UatBillingElements.availableCreditsCheckBoxesXPATH)
    @Title(value = "This is the checkbox withing open available credits accordion tab on payment page")
    public List<WebElement> availableCreditsCheckBoxes;

    @FindBy(how = How.XPATH, using = UatBillingElements.availableCreditsValuesXPATH)
    @Title(value = "This is the amount of available credit")
    public List<WebElement> availableCreditsValues;

    @FindBy(how = How.XPATH, using = UatBillingElements.invoiceSummaryValueXPATH)
    @Title(value = "This is the invoice summary amount")
    public WebElement invoiceSummaryValue;
    // TODO WebElement does not work
//    @FindBy(how = How.XPATH, using = UatBillingElements.paymentOnAccountXpath)
    @Title(value = "This is Make Payment on Account button")
    public By makePaymentOnAccount = By.xpath("//*[@id='__next']/main/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[2]/button");

    @FindBy(how = How.XPATH, using = UatBillingElements.allInvoicesCheckbox)
    @Title(value = "This is used to select all invoices")
    public WebElement allInvoicesCheckbox;

    @FindBy(how = How.XPATH, using = UatBillingElements.invoicesCheckboxes)
    @Title(value = "This is set of all invoices' checkboxes")
    public List<WebElement> invoicesCheckboxes;

    @FindBy(how = How.XPATH, using = UatBillingElements.downloadInvoiceButton)
    @Title(value = "This is used to Download invoice(s)")
    public WebElement downloadInvoiceButton;

    @Title(value = "This is used to Download invoice(s)")
    public By downloadInvoiceButton2 = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[1]/div[2]/div/div[2]/div[1]/button[1]");

    @FindBy(how = How.XPATH, using = UatBillingElements.makePaymentInPreviewPopUp)
    @Title(value = "This is redirects user to Payment page")
    public WebElement makePaymentInPreviewPopUp;

    @Title(value = "This is redirects user to Payment page")
    public By makePaymentInPreviewPopUp2 = By.xpath("/html/body/div[3]/div[3]/div/div[2]/button");

    @FindBy(how = How.XPATH, using = UatBillingElements.secondInvoiceCheckbox)
    @Title(value = "This is redirects user to Payment page")
    public WebElement secondInvoiceCheckbox;

    @FindBy(how = How.XPATH, using = UatBillingElements.payByCreditCardRadioButtonXPATH)
    @Title(value = "This is the radio button to select pay by credit card")
    public WebElement payByCreditCardRadioButton;

    @FindBy(how = How.ID, using = UatBillingElements.creditCardNumberFieldID)
    @Title(value = "This is the area to enter credit card number")
    public WebElement creditCardNumberField;

    @FindBy(how = How.LINK_TEXT, using = UatBillingElements.processTransactionButtonLINKTEXT)
    @Title(value = "This is the button to process transaction")
    public WebElement processTransactionButton;

    @FindBy(how = How.XPATH, using = UatBillingElements.paymentWithCCandCreditConfirmationMessageXPATH)
    @Title(value = "This is the confirmation page after billing payment")
    public WebElement paymentWithCCandCreditConfirmationMessage;

    @FindBy(how = How.XPATH, using = UatBillingElements.creditCardiFrameXPATH)
    @Title(value = "This is the credid card infrmation area")
    public WebElement creditCardiFrame;

    @FindBy(how = How.XPATH, using = UatBillingElements.tableInBillingPageXPATH)
    @Title(value = "This is the table in billing home page")
    public WebElement tableInBillingPage;

    @FindBy(how = How.CSS, using = UatBillingElements.amountToPayAreaCSS)
    @Title(value = "This is the manual amount to pay area")
    public List<WebElement> amountToPayArea;

    @FindBy(how = How.XPATH, using = UatBillingElements.minimumAmountToPayErrorMessageXPATH)
    @Title(value = "This is error message of Minimum $0.01 when trying to pay less than 0.01 on billing page")
    public WebElement minimumAmountToPayErrorMessage;

    @FindBy(how = How.CSS, using = UatBillingElements.paymentDueAmountCSS)
    @Title(value = "This is payment due amount on billing page")
    public WebElement paymentDueAmount;

    @FindBy(how = How.XPATH, using = UatBillingElements.unpaidInvoicesTabOnBillingPageXPATH)
    @Title(value = "This is the unpaid invoices tab on billing page")
    public WebElement unpaidInvoicesTabOnBillingPage;

    //    @FindBy(how = How.XPATH, using = UatBillingElements.tableInBillingPageXPATH)
    @Title(value = "This is the table in billing home page")
    public By tableInBillingPage2 = By.xpath("/html/body/div/main/div[2]/div/div[2]");

    @FindBy(how = How.CSS, using = UatBillingElements.checkboxesInTableCSS)
    @Title(value = "This is the checkboxes in the billing table")
    public List<WebElement> checkboxesInTable;

//    @FindBy(how = How.CSS, using = UatBillingElements.checkboxesInTableCSS)
    @Title(value = "This is the checkboxes in the billing table")
    public By checkboxesInTable2 = By.cssSelector("input[type='checkbox']") ;

    @FindBy(how = How.CSS, using = UatBillingElements.invoiceIdBillingInTableCSS)
    @Title(value = "This is the checkboxes in the billing table")
    public List<WebElement> invoiceIdBilling;

//    @FindBy(how = How.CSS, using = UatBillingElements.invoiceIdBillingInTableCSS)
    @Title(value = "This is the checkboxes in the billing table")
    public By invoiceIdBilling2 = By.cssSelector("div[class='MuiStack-root tdFixed css-1hz1e32']");

    //    @FindBy(how = How.XPATH, using = UatBillingElements.agingBucketsContainerXpath)
    @Title(value = "This is aging buckets")
    public By agingBuckets = By.xpath("/html/body/div/main/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div[1]");

    @FindBy(how = How.XPATH, using = UatBillingElements.previewButtonXpath)
    @Title(value = "This is Preview button")
    public WebElement previewButton;

    @Title(value = "This is Preview button")
    public By previewButton2 = By.xpath("//button[contains(@class,'leWqgI btn-custom  css-thzpcf')]");

    @FindBy(how = How.XPATH, using = UatBillingElements.slideBoxOnPreviewPopUpXpath)
    @Title(value = "This is slide box on preview pop-up")
    public WebElement slideBoxOnPreviewPopUp;

    @Title(value = "This is slide box on preview pop-up")
    public By slideBoxOnPreviewPopUp2 = By.xpath("//div[contains(@class,'slick-slide slick-active')][2]");

    @FindBy(how = How.XPATH, using = UatBillingElements.visibleColumnIconXpath)
    @Title(value = "This is visible column icon")
    public WebElement visibleColumnIcon;

    @Title(value = "This is visible column icon")
    public By visibleColumnIcon2 = By.xpath("(//button[contains(@class,'MuiIconButton-root MuiIconButton')])[2]");

    @Title(value = "This is Selected invoice balance due")
    public By selectedInvBalanceDue = By.xpath("//p[@class='BillingFilterViewbyStyles__TotalBillingsStyled-sc-1ym1fmu-7 hMccUY']");

    @Title(value = "This is first Invoice ID")
    public By firstInvoiceID = By.xpath("(//div[@class='MuiStack-root tdFixed css-1hz1e32'])[1]");

    @Title(value = "This is Search bar for invoices")
    public By invoiceSearchBar = By.id("autocomplete-search");

    @Title(value = "These are checkboxes of invoices")
    public By invoiceCheckboxes = By.xpath("//input[@type='checkbox']");

    @Title(value = "This is first invoice's checkbox of Billing Page")
    public By firstInvoiceCheckbox = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div[1]/div/span/input");

    @Title(value = "This is first invoice's id of search result")
    public By firstInvoiceIDofSearchResultPreview = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[1]/div[2]/div/div/div[4]/div[1]/div[2]/div/p[1]");

    @Title(value = "This is Balance due of first invoice")
    public By balanceDueOfFirstInv = By.xpath("//*[@id=\"__next\"]/main/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/div[6]");
}