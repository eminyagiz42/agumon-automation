package com.agumon.runner.testng;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = "src/test/resources/features/storefront/plp/DTA_1_Catalog.feature",
        glue = "com/agumon/stepdefinition",
        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        //tags = "@tc1",
        publish = false,
        plugin = {
                "pretty",
                "summary",
                "html:src/main/resources/agumon-reports/cucumber-runner/index.html",
                "json:target/agumon-json/cucumber.json",
                "junit:src/main/resources/agumon-reports/cucumber-runner/cucumber.xml",
                "rerun:src/main/resources/agumon-reports/cucumber-runner/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        })
public class AgumonTestNGRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider
    //@DataProvider (parallel = true) -- For parallel execution support
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
