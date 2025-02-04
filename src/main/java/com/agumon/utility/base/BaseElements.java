package com.agumon.utility.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BaseElements {

    protected WebDriver driver;

    public void initDriverAndElements(final WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

}

