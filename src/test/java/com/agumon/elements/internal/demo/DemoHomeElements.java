package com.agumon.elements.internal.demo;


public class DemoHomeElements {

    public static final String quickAddButtonCss = "a[href='/quick-add']";
    public static final String backofficeDashboardTextXpath = "//span[contains(text(),'Dashboard')]";
    public static final String profileAvatarButtonXpath = "//button[@data-test='layout-profile']";
    public static final String loginAvatarButtonXpath = "//button[contains(text(),'Login')]";
    public static final String profileLogoutButtonXpath = "(//li//a[contains(text(),'Logout')])";
    public static final String profileMyAccountButtonXpath = "(//li//a[contains(text(),'My Account')])";
    public static final String profileCompanyButtonXpath = "(//li//a[contains(text(),'Company')])";
    public static final String homepageMainLogoXpath = "//img[@class='header__logo']";
    public static final String productPageButtonColourOneXpath = "(//p[contains(text(),'COLOUR')]/following-sibling::div//div//div)[1]";
    public static final String productPageButtonColourTwoXpath = "(//p[contains(text(),'COLOUR')]/following-sibling::div//div//div)[2]";
    public static final String productPageButtonColourThreeXpath = "(//p[contains(text(),'COLOUR')]/following-sibling::div//div//div)[3]";
    public static final String productPageButtonAddToCartXpath = "(//button[contains(text(),'Add to Cart')])[1]";
    public static final String productPageInputQuantityXpath = "//input[@name='product_quantity']";
    public static final String searchBoxInputXpath = "//form[@class='sc-SearchBox-form']//input";

}
