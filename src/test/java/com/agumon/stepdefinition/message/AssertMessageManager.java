package com.agumon.stepdefinition.message;


import org.aeonbits.owner.ConfigCache;

public final class AssertMessageManager {

    private AssertMessageManager() {
    }

    public static AssertProperties message() {
        return ConfigCache.getOrCreate(AssertProperties.class);
    }
}