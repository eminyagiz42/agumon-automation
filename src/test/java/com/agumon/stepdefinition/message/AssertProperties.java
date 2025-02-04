package com.agumon.stepdefinition.message;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;


@LoadPolicy(LoadType.MERGE)
@Sources({"system:properties", "classpath:assert-messages.properties"})
public interface AssertProperties extends Config {

    @Key("reset.password.failed")
    String resetPasswordFailed();

    @Key("not.on.login.page")
    String notOnLogin();

    @Key("not.on.home.page")
    String notOnHome();

    @Key("failed.account.name.comparison")
    String failedAccountNameComparison();

    @Key("invalid.account.is.not.displayed")
    String invalidAccountNotDisplayed();

    @Key("account.request.not.displayed")
    String requestAccessReceived();

    @Key("not.on.backoffice.home.page")
    String notOnBackofficeHomePage();

    @Key("invalid.backoffice.account.not.displayed")
    String invalidBackofficeNotDisplayed();

    @Key("confirmation.not.displayed")
    String confirmationNotDisplayed();

    @Key("minimum.amount.error.message.not.displayed")
    String minimumAmountErrorMessageNotDisplayed();

    @Key("inputed.amount.not.displayed")
    String inputedAmountNotDisplayed();

    @Key("billing.page.is.not.displayed")
    String billingPageIsNotDisplayed();

    @Key("information.not.matched")
    String informationNotMatched();

    @Key("category.plp.page.is.not.displayed")
    String categoryPlpPageIsNotDisplayed();

    @Key("billing.search.not.case.insensitive")
    String billingSearchNotCaseInsensitive();

    @Key("aging.buckets.not.displayed")
    String agingBucketsNotDisplayed();

    @Key("pay.selected.invoice.button.not.enabled")
    String paySelectedInvButtonNotEnabled();

    @Key("search.results.not.correct.with.POID ")
    String searchResultNotCorrectWithPOID();

    @Key("user.not.in.PDP")
    String userNotInPDP();

    @Key("added.item.not.in.cart")
    String addedItemNotInCart();
}