package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags="@BothTests")
public class TestRunner extends AbstractTestNGCucumberTests {
}
