package com.agumon.utility.factory;


import com.agumon.utility.base.BaseUtils;


public final class BaseUtilsFactory {

    private BaseUtilsFactory() {
    }

    public static <T extends BaseUtils> T createInstance(final Class<T> clazz) {
        try {
            BaseUtils instance = clazz.getDeclaredConstructor().newInstance();

            return clazz.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Utils class instantiation failed.");
    }

}