package com.agumon.pages.cart;


import com.agumon.stepdefinition.base.BasePage;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class CartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(CartPage.class);

    public void deleteCart() {
        utils.waitAndClick(cartElements.deleteCartButton);
        utils.waitAndClick(cartElements.deleteCartonOnPopUp);
    }
}