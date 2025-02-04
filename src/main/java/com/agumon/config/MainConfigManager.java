package com.agumon.config;


import org.aeonbits.owner.ConfigCache;

public final class MainConfigManager {

    private MainConfigManager() {
    }

    public static MainConfig config() {
        return ConfigCache.getOrCreate(MainConfig.class);
    }
}