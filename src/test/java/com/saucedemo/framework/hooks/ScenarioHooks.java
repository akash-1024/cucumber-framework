package com.saucedemo.framework.hooks;

import com.saucedemo.framework.base.BaseTest;
import net.serenitybdd.core.Serenity;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHooks extends BaseTest {
    @Before
    public void launchChrome() {
        startBrowser();
    }

    @After
    public void closeChrome() {
        stopBrowser();
    }

    @AfterStep
    public void captureStepScreenshot() {
        Serenity.recordScreenshot(
                "After step",
                ((TakesScreenshot) BaseTest.currentDriver()).getScreenshotAs(OutputType.BYTES));
    }
}
