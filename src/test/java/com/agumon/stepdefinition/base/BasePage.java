package com.agumon.stepdefinition.base;


import com.agumon.pages.backoffice.BackofficeElements;
import com.agumon.pages.billing.BillingElements;
import com.agumon.pages.cart.CartElements;
import com.agumon.pages.home.HomeElements;
import com.agumon.pages.login.forgetpassword.ForgetPasswordElements;
import com.agumon.pages.login.LoginElements;
import com.agumon.pages.login.requestaccount.RequestAccountElements;
import com.agumon.pages.notfound.NotFoundElements;
import com.agumon.pages.profile.invite.UserInviteElements;
import com.agumon.pages.profile.mylist.MyListElements;
import com.agumon.pages.order.OrdersElements;
import com.agumon.pages.payment.PaymentElements;
import com.agumon.pages.productdetail.ProductDetailElements;
import com.agumon.pages.productlisting.ProductListingElements;
import com.agumon.pages.profile.UserProfileElements;
import com.agumon.pages.quotes.QuotesElements;
import com.agumon.pages.updatepassword.UpdatePasswordElements;
import com.agumon.stepdefinition.utils2.SeleniumUtilities;
import com.agumon.stepdefinition.utils2.WaitUtils;
import com.agumon.utility.factory.BaseElementFactory;
import com.agumon.utility.factory.BaseUtilsFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.agumon.utility.driver.DriverManager.driver;

public abstract class BasePage {

    protected WebDriver driver;

    // Utils
    private final AllUtils allUtils;
    protected SeleniumUtilities utils;
    protected WaitUtils waitUtils;
    protected WebDriverWait wait;

    // Elements
    protected ForgetPasswordElements forgetPasswordElements;
    protected HomeElements homeElements;
    protected LoginElements loginElements;
    protected RequestAccountElements requestAccountElements;
    protected BillingElements billingElements;
    protected BackofficeElements backofficeElements;
    protected MyListElements myListElements;
    protected OrdersElements ordersElements;
    protected ProductDetailElements productDetailElements;
    protected ProductListingElements productListingElements;
    protected UserProfileElements userProfileElements;
    protected QuotesElements quotesElements;
    protected CartElements cartElements;
    protected PaymentElements paymentElements;
    protected UserInviteElements userInviteElements;
    protected NotFoundElements notFoundElements;
    protected UpdatePasswordElements updatePasswordElements;

    public BasePage() {
        this.driver = driver();

        allUtils = BaseUtilsFactory.createInstance(AllUtils.class);
        waitUtils = allUtils.getWaitUtils();
        utils = allUtils.getSeleniumUtilities();
        wait = allUtils.geWebDriverWait();

        homeElements = BaseElementFactory.createInstance(driver, HomeElements.class);
        loginElements = BaseElementFactory.createInstance(driver, LoginElements.class);
        forgetPasswordElements = BaseElementFactory.createInstance(driver, ForgetPasswordElements.class);
        requestAccountElements = BaseElementFactory.createInstance(driver, RequestAccountElements.class);
        billingElements = BaseElementFactory.createInstance(driver, BillingElements.class);
        backofficeElements = BaseElementFactory.createInstance(driver, BackofficeElements.class);
        myListElements = BaseElementFactory.createInstance(driver, MyListElements.class);
        ordersElements = BaseElementFactory.createInstance(driver, OrdersElements.class);
        productDetailElements = BaseElementFactory.createInstance(driver, ProductDetailElements.class);
        productListingElements = BaseElementFactory.createInstance(driver, ProductListingElements.class);
        userProfileElements = BaseElementFactory.createInstance(driver, UserProfileElements.class);
        quotesElements = BaseElementFactory.createInstance(driver, QuotesElements.class);
        cartElements = BaseElementFactory.createInstance(driver, CartElements.class);
        paymentElements = BaseElementFactory.createInstance(driver, PaymentElements.class);
        userInviteElements = BaseElementFactory.createInstance(driver, UserInviteElements.class);
        notFoundElements = BaseElementFactory.createInstance(driver, NotFoundElements.class);
        updatePasswordElements = BaseElementFactory.createInstance(driver, UpdatePasswordElements.class);
    }

}