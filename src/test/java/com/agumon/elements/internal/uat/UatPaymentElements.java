package com.agumon.elements.internal.uat;

public class UatPaymentElements {

    public static final String payFullBalanceValueXpath = "//span[@class='c-text normal span mb-0 bgc-normal text-15x24 text-700'][1]";
    public static final String payPartialBalanceValueCSS = "form > div.OptionStyles__OptionStyled-sc-1ik8g70-0.bWooTK > div.OptionStyles__OptionMainStyled-sc-1ik8g70-5.bAoKit > div.c-box.normal.normal.bgc-normal.OptionStyles__OptionListStyled-sc-1ik8g70-6.gKYRZf.MuiBox-root.css-0 > div > div.c-box.px-4.normal.bgc-normal.CardRadioStyles__CardRadioWrapperStyled-sc-1mcerk5-0.cEpbmt.c-card-radio.c-card-radio--active.c-card-radio--not-disabled.bgc-basic-100.MuiBox-root.css-0 > div > span";
    public static final String amountToPayXpath = "/html/body/div/main/section[1]/div/div/div/div[1]/section[1]/form/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div/div[4]/div[1]/p";
    public static final String amountToPayPartialCSS = "input[name*='invoice_']";
    public static final String returnToBillingButtonOnConfirmationPageXPATH = "//*[@id=\"__next\"]/main/div[1]/div/div[1]/button";
    public static final String payByBankAccountButtonXPATH = "//*[@id=\"103980753b1af0472-5f1a-a288-aa14-235970782a94\"]";
    public static final String submitPaymentButtonCSS = ".PaymentMethodStyles__MethodButtonActionStyled-sc-1mgys45-5 > button";
    public static final String singleInvoiceidOnPaymentPageXPATH = "/html/body/div/main/section[1]/div/div/div/div[1]/section[1]/form/div[1]/div[3]/div[2]/div/div[2]/div/div[2]/div[1]/div[1]";
    public static final String singleInvoiceidOnConfirmationPageXPATH = "//*[@id=\"__next\"]/main/div[1]/div/div[3]/ul[2]/li[2]/span[1]";
    public static final String paidAmountOnInvoiceSummaryOnConfirmationPageXPATH = "//*[@id=\"__next\"]/main/div[1]/div/div[3]/ul[2]/li[2]/span[2]";
    public static final String paymentDueAmountOnPaymentSummaryXPATH = "/html/body/div/main/section[1]/div/div/div/div[1]/section[2]/div/div[2]/div[3]/p[2]";
    public static final String PaymentDueAmountOnPaymentConfirmationXPATH = "//*[@id=\"__next\"]/main/div[1]/div/div[3]/div/div[2]";
    public static final String invoiceIdOnInvoiceSummaryCSS = "span[class='c-text normal span mb-0 bgc-normal text-600 text-13x24']";
    public static final String xButtonForDeleteXpath = "(//div[@class='InvoiceCardStyles__InvoiceCardDeleteStyled-sc-w4svge-5 boqetN'])[1]";
    public static final String arrowIconXpath = "(//div[@class='CardAccordionStyles__CardAccordionToggleStyled-sc-sa12v5-1 fWXSqU c-card-accordion__head__icon'])[1]";
    public static final String availDiscFirstXpath = "(//span[@class='c-text normal span mb-0 bgc-normal text-400 text-13x18'])[1]";
    public static final String availDiscPaymentSumXpath = "(//p[@class='c-text normal undefined mb-0 bgc-normal text-15x24 text-600'])[2]";
    public static final String paymentSumIIconCSS = "img[alt='tooltip']";

}