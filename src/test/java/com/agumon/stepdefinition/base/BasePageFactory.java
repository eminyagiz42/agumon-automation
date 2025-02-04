package com.agumon.stepdefinition.base;


public final class BasePageFactory {

    private BasePageFactory() {
    }

    public static <T extends BasePage> T createInstance(final Class<T> clazz) {
        try {
            BasePage instance = clazz.getDeclaredConstructor().newInstance();

            return clazz.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Page class instantiation failed.");
    }

}