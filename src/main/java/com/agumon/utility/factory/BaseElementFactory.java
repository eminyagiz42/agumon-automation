package com.agumon.utility.factory;


import com.agumon.utility.base.BaseElements;
import org.openqa.selenium.WebDriver;


public final class BaseElementFactory {

    private BaseElementFactory() {
    }

    public static <T extends BaseElements> T createInstance(
            final WebDriver driver, final Class<T> clazz) {
        try {
            BaseElements instance = clazz.getDeclaredConstructor().newInstance();

            instance.initDriverAndElements(driver);

            return clazz.cast(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new NullPointerException("Element class instantiation failed.");
    }

}