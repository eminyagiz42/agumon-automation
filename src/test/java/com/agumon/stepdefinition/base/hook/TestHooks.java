package com.agumon.stepdefinition.base.hook;


import com.agumon.utility.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assume;

import static com.agumon.utility.global.Constants.SCREENSHOT_FLAG;
import static com.agumon.utility.global.Constants.TAG_SKIP;


public class TestHooks {

    private static final Logger LOGGER = LogManager.getLogger(TestHooks.class);
    public static final String TEST_PATTERN = " - Test: ";

    @Before
    public void initializeTest(Scenario scenario) throws Exception {
        final boolean hasSkipTagsInScenario = scenario.getSourceTagNames()
                .stream().anyMatch(TAG_SKIP::equalsIgnoreCase);
        if (!hasSkipTagsInScenario) {
            DriverManager.start();
        }
    }

    @After
    public void tearDownTest(Scenario scenario) {
        if (!Status.SKIPPED.equals(scenario.getStatus())) {
            if (SCREENSHOT_FLAG) {
                DriverManager.captureScreenshot(scenario);
            }
            DriverManager.shutdown();
            if (scenario.isFailed()) {
                LOGGER.error(scenario.getStatus() + TEST_PATTERN + scenario.getName());
            } else {
                LOGGER.info(scenario.getStatus() + TEST_PATTERN + scenario.getName());
            }
        }
    }

    @Before(TAG_SKIP)
    public void skipScenario(Scenario scenario) {
        LOGGER.warn("SKIPPED- Test: " + scenario.getName());
        Assume.assumeTrue("SKIP SCENARIO: " + scenario.getName(), Boolean.FALSE);
    }

    /*
    @BeforeStep
    public void BeforeEveryStep(Scenario scenario) {
        //LOGGER.info("Before every step " + scenario.getId());
    }

    @AfterStep
    public void AfterEveryStep(Scenario scenario) {
        //LOGGER.info("Before every step " + scenario.getId());
    }
     */
}
