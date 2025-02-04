package com.agumon.utility.enums;

public enum BrowserEnum {

    FIREFOX("firefox"), CHROME("chrome"), EDGE("edge"), IE("ie"), SAFARI("safari"), GRID("grid");

    private final String name;

    BrowserEnum(final String name) {
        this.name = name;
    }
}
