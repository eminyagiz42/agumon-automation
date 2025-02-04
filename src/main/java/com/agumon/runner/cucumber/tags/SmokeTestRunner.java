package com.agumon.runner.cucumber.tags;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/agumon/stepdefinition",
        tags = "@invalid",
        monochrome = true,
        publish = false,
        snippets = CAMELCASE,
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
public class SmokeTestRunner {
}