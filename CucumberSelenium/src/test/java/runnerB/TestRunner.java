package runnerB;

import org.junit.runner.RunWith;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.*;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features//Login.feature",
		glue = {"stepDefinition"},
		plugin = {"pretty", "json:target/cucumber-reports/Automation.json"},
		tags = "@login",
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests  {

}
