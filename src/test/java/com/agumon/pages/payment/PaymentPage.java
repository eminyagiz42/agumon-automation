package com.agumon.pages.payment;


import com.agumon.stepdefinition.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.List;

public class PaymentPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(PaymentPage.class);

    public static final String DUE_AMOUNT_ON_PAYMENT_SUMMARY = "paymentDueAmountOnPaymentSummary";
    public static final String INVOICE_ID_ON_PAYMENT_PAGE = "singleInvoiceIdOnPaymentPage";
    private static String invoiceID = "";
    private static String paymentSummaryDiscountField = "";

    public static final String AMOUNT_ENTERED_ON_PAYMENT_SUMMARY = "amountEnteredOnPaymentSummaryPage";

    public Double getPriceOfPayFullBalance() {
        return convertToDouble(paymentElements.payFullBalanceValue.getText());
    }

    public Double getTotalPriceOfAllSelectedInvoices() {
        double totalPrice = 0.00;
        for (WebElement element : paymentElements.amountToPay) {
            if (paymentElements.amountToPay.indexOf(element) % 2 == 0) {
                totalPrice = totalPrice + convertToDouble(element.getText());
            }
        }
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        return totalPrice;
    }

    public Double getTotalPriceOfAllSelectedInvoicesPartialPay() {
        double totalPrice = 0.00;
        for (WebElement element : paymentElements.amountToPayPartial) {
            if (paymentElements.amountToPayPartial.indexOf(element) % 2 == 0) {
                totalPrice = totalPrice + convertToDouble(element.getAttribute("value"));
            }
        }
        totalPrice = Math.round(totalPrice * 100.0) / 100.0;
        return totalPrice;
    }

    public void checksPayPartialBalanceCheckbox() {
        billingElements.payPartialBalanceRadioButton.click();
        paymentSummaryDiscountField = paymentElements.availDiscPaymentSum.getText();
        billingElements.payPartialBalanceRadioButton.click();
        utils.waitFor(2);
    }

    public void changesAmountToPayForAnInvoice() throws Exception {
        List<WebElement> invoiceInputs = paymentElements.amountToPayPartial;
        if (!invoiceInputs.isEmpty()) {
            WebElement firstInvoiceInput = invoiceInputs.get(0);
            utils.clearAndEnterText(firstInvoiceInput, "0.01");
            utils.waitFor(5);
        }
    }

    public Double getPriceOfPayPartialBalance() {
        return convertToDouble(paymentElements.payPartialBalanceValue.getText());
    }

    public void userSelectsPayByBankAccountAndClickSubmitPayment() throws IOException {
        utils.scrollIntoView(paymentElements.payByBankAccountButton);
        utils.waitFor(5);
        paymentElements.payByBankAccountButton.click();
        utils.getScreenshot("Pay by bank account");
        utils.waitFor(5);
        paymentElements.submitPaymentButton.click();
    }

    public boolean compareValuesBetweenConfirmationAndPayment() {
        final String previousSingleInvoiceId = System.getProperty(INVOICE_ID_ON_PAYMENT_PAGE);
        final String previousPaymentDueAmount = System.getProperty(DUE_AMOUNT_ON_PAYMENT_SUMMARY);
        final String amountEnteredOnPaymentSummaryPage = System.getProperty(AMOUNT_ENTERED_ON_PAYMENT_SUMMARY);

        return previousSingleInvoiceId.equalsIgnoreCase(paymentElements.singleInvoiceidOnConfirmationPage.getText())
                && previousPaymentDueAmount.
                equalsIgnoreCase(getTextWithoutDollarSign(paymentElements.paymentDueAmountOnPaymentConfirmation))
                && amountEnteredOnPaymentSummaryPage.
                equalsIgnoreCase(getTextWithoutDollarSign(paymentElements.paidAmountOnInvoiceSummaryOnConfirmationPage));
    }

    public boolean usersClearsTheAmountToPayAreaAndEntersAnAmount(String amountEntered) {
        String paymentDueAmountOnPaymentSummary = "";
        try {
            List<WebElement> invoiceInputs = billingElements.amountToPayArea;
            if (!invoiceInputs.isEmpty()) {
                utils.clearAndEnterText(invoiceInputs.get(0), amountEntered);
                utils.waitFor(5);
                utils.getScreenshot("amount to be paid on billing page");
                paymentDueAmountOnPaymentSummary = getTextWithoutDollarSign(paymentElements.paymentDueAmountOnPaymentSummary);
                System.setProperty(INVOICE_ID_ON_PAYMENT_PAGE, paymentElements.singleInvoiceidOnPaymentPage.getText());
                System.setProperty(DUE_AMOUNT_ON_PAYMENT_SUMMARY, paymentDueAmountOnPaymentSummary);
                System.setProperty(AMOUNT_ENTERED_ON_PAYMENT_SUMMARY, amountEntered);
            }
        } catch (Exception e) {
            LOGGER.debug("An error occurred at usersClearsTheAmountToPayAreaAndEntersAnAmount");
            e.printStackTrace();
        }
        return amountEntered.equals(paymentDueAmountOnPaymentSummary);
    }

    public boolean userClicksOnOnReturnToBillingButtonAndBillingPageIsDisplayed() throws IOException {
        waitUtils.waitForElementVisible(paymentElements.returnToBillingButtonOnConfirmationPage);
        utils.getScreenshot("The Back to Billing page link clicked");
        paymentElements.returnToBillingButtonOnConfirmationPage.click();
        utils.waitFor(8);
        return billingElements.unpaidInvoicesTabOnBillingPage.isDisplayed();
    }

    public double convertToDouble(String str) {
        return Double.parseDouble(str.replace("$", "").replace(",", ""));
    }

    public static String getTextWithoutDollarSign(WebElement element) {
        return element.getText().replace("$", "");
    }

    public void theUserPicksAPaymentMethod() throws IOException {
        if (paymentElements.payByBankAccountButton.isSelected()) {
            utils.waitFor(5);
            paymentElements.payByBankAccountButton.click();
            utils.getScreenshot("Pay by bank account");
            utils.waitFor(5);
            paymentElements.submitPaymentButton.click();
        } else if (billingElements.payByCreditCardRadioButton.isSelected()) {
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.END)
                    .perform();
            utils.waitForVisibility(billingElements.payByCreditCardRadioButton, 20);
            utils.waitFor(5);
            utils.clickWebElement(billingElements.payByCreditCardRadioButton);
        } else {
            System.out.println("No payment method is selected");
        }
    }

    public boolean isAmountToPayChanged() {
        List<WebElement> invoiceInputs = paymentElements.amountToPayPartial;
        WebElement firstInvoiceInput = invoiceInputs.get(0);
        return firstInvoiceInput.getAttribute("value").equals("0.01");
    }

    public void clicksTheXIcon() {
        invoiceID = paymentElements.invoiceIdOnInvoiceSummary.get(0).getText();
        utils.clickWebElement(paymentElements.xButtonForDelete);
        utils.waitFor(2);
    }

    public boolean isInvoiceDeleted() {
        return !invoiceID.equalsIgnoreCase(paymentElements.invoiceIdOnInvoiceSummary.get(0).getText());
    }

    public void clicksTheArrowIcon() {
        invoiceID = paymentElements.invoiceIdOnInvoiceSummary.get(0).getText();
        utils.clickWebElement(paymentElements.arrowIcon);
        utils.waitFor(2);
    }

    public boolean isInvoiceSummaryCollapsed() {
        return !paymentElements.invoiceIdOnInvoiceSummary.get(0).isDisplayed();
    }

    public void selectHigherAvailableCredit() {
        int i = 0;
        do {
            utils.scrollIntoView(billingElements.availableCreditsCheckBoxes.get(i));
            billingElements.availableCreditsCheckBoxes.get(i).click();
            i++;
        }
        while (!paymentElements.paymentDueAmountOnPaymentSummary.getText().equalsIgnoreCase("$0.00"));

        utils.waitFor(3);
    }

    public boolean isDiscountZeroOnInvoiceSummary() {

        return paymentElements.availDiscFirst.getText().equalsIgnoreCase("$0.00");
    }

    public boolean isPaymentSummaryDiscountFieldChanged() {
        return !paymentElements.availDiscPaymentSum.getText().equals(paymentSummaryDiscountField);
    }

    public boolean isIIconAppeared() {
        return paymentElements.paymentSumIIcon.isDisplayed();
    }

    public void clicksSubmitPayment() {
        utils.scrollIntoView(paymentElements.submitPaymentButton);
        utils.waitFor(3);
        utils.clickWebElement(paymentElements.submitPaymentButton);
    }
}