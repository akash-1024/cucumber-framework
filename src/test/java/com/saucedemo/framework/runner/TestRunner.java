package com.saucedemo.framework.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.saucedemo.framework",
        plugin = {
                "pretty",
                "net.serenitybdd.cucumber.core.plugin.SerenityReporter"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
