package com.agumon.runner.testng;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "com/agumon/stepdefinition",
        monochrome = true,
        publish = false,
        dryRun = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "summary",
                "json:target/agumon-json/cucumber.json"
        })
public class SnippetsTestNGRunner extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider
        public Object[][] scenarios() {
                return super.scenarios();
        }

}

