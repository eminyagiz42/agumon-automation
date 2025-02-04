package com.agumon.runner.testng.story;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/storefront/pdp",
        glue = "com/agumon/stepdefinition",
        monochrome = true,
        publish = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "summary",
                "html:target/agumon-reports/cucumber-runner/index.html",
                "json:target/agumon-json/cucumber.json",
                "junit:target/agumon-reports/cucumber-runner/cucumber.xml",
                "rerun:target/agumon-reports/cucumber-runner/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class PDPTestNGRunner extends AbstractTestNGCucumberTests {

}

