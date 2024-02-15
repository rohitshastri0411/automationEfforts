package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(tags = "@SmokeTest", features = {"src/test/resources/features"}, glue = {"selenium.stepDefinitions"})

public class CucumberRunner extends AbstractTestNGCucumberTests {
}


