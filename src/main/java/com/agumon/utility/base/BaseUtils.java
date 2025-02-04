package com.agumon.utility.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BaseUtils {

    protected WebDriver driver;

    protected BaseUtils(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
