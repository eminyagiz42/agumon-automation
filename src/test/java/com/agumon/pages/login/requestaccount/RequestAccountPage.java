package com.agumon.pages.login.requestaccount;

import com.agumon.stepdefinition.base.BasePage;
import net.datafaker.Faker;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

public class RequestAccountPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(RequestAccountPage.class);
    
    public void fillAllFieldRequestAccountAndSubmit() {
        final Faker faker = utils.faker();
        utils.sendKeysToElementWithWait(requestAccountElements.requestAccountNameTextBox, faker.name().firstName()
                + Keys.TAB
                + faker.internet().emailAddress() + Keys.TAB
                + faker.phoneNumber().phoneNumberNational() + Keys.TAB
                + faker.company().name() + Keys.TAB
                + faker.australia().animals() + Keys.TAB
                + faker.country().capital() + Keys.TAB
                + faker.book().title() + Keys.TAB
                + Keys.ENTER, 0);
    }
}