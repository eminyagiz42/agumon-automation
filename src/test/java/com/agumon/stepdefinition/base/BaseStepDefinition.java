package com.agumon.stepdefinition.base;


import com.agumon.pages.backoffice.BackofficePage;
import com.agumon.pages.billing.BillingPage;
import com.agumon.pages.cart.CartPage;
import com.agumon.pages.home.HeaderComponent;
import com.agumon.pages.home.HomePage;
import com.agumon.pages.home.SearchbarComponent;
import com.agumon.pages.login.forgetpassword.ForgotPasswordPage;
import com.agumon.pages.login.LoginPage;
import com.agumon.pages.login.requestaccount.RequestAccountPage;
import com.agumon.pages.notfound.NotFoundPage;
import com.agumon.pages.profile.invite.UserInvitePage;
import com.agumon.pages.profile.mylist.MyListPage;
import com.agumon.pages.order.OrdersPage;
import com.agumon.pages.payment.PaymentPage;
import com.agumon.pages.productdetail.ProductDetailPage;
import com.agumon.pages.productlisting.CostRetailComponent;
import com.agumon.pages.productlisting.ProductFiltersComponent;
import com.agumon.pages.productlisting.ProductListingPage;
import com.agumon.pages.profile.UserProfilePage;
import com.agumon.pages.quotes.QuotesPage;
import com.agumon.pages.updatepassword.UpdatePasswordPage;

public abstract class BaseStepDefinition {

    // Pages
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected BillingPage billingPage;
    protected CartPage cartPage;
    protected ForgotPasswordPage forgotPasswordPage;
    protected RequestAccountPage requestAccountPage;
    protected OrdersPage ordersPage;
    protected PaymentPage paymentPage;
    protected NotFoundPage notFoundPage;
    protected ProductDetailPage productDetailPage;
    protected ProductListingPage productListingPage;
    protected UserProfilePage userProfilePage;
    protected UserInvitePage userInvitePage;
    protected MyListPage myListPage;
    protected QuotesPage quotesPage;
    protected BackofficePage backofficePage;
    protected UpdatePasswordPage updatePasswordPage;

    //Components
    protected HeaderComponent headerComponent;
    protected ProductFiltersComponent filtersComponent;
    protected CostRetailComponent costRetailComponent;
    protected SearchbarComponent searchbarComponent;

    public BaseStepDefinition() {
        homePage = BasePageFactory.createInstance(HomePage.class);
        loginPage = BasePageFactory.createInstance(LoginPage.class);
        billingPage = BasePageFactory.createInstance(BillingPage.class);
        cartPage = BasePageFactory.createInstance(CartPage.class);
        forgotPasswordPage = BasePageFactory.createInstance(ForgotPasswordPage.class);
        myListPage = BasePageFactory.createInstance(MyListPage.class);
        ordersPage = BasePageFactory.createInstance(OrdersPage.class);
        productDetailPage = BasePageFactory.createInstance(ProductDetailPage.class);
        productListingPage = BasePageFactory.createInstance(ProductListingPage.class);
        quotesPage = BasePageFactory.createInstance(QuotesPage.class);
        requestAccountPage = BasePageFactory.createInstance(RequestAccountPage.class);
        userProfilePage = BasePageFactory.createInstance(UserProfilePage.class);
        backofficePage  = BasePageFactory.createInstance(BackofficePage.class);
        headerComponent = BasePageFactory.createInstance(HeaderComponent.class);
        filtersComponent  = BasePageFactory.createInstance(ProductFiltersComponent.class);
        costRetailComponent = BasePageFactory.createInstance(CostRetailComponent.class);
        searchbarComponent = BasePageFactory.createInstance(SearchbarComponent.class);
        paymentPage = BasePageFactory.createInstance(PaymentPage.class);
        notFoundPage = BasePageFactory.createInstance(NotFoundPage.class);
        userInvitePage = BasePageFactory.createInstance(UserInvitePage.class);
        updatePasswordPage = BasePageFactory.createInstance(UpdatePasswordPage.class);
    }
}
