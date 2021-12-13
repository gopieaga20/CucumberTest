package runnerA;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//TestRunnerforCt-123

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features",
		glue = {"stepDefinition"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/Automation.html", "pretty", "json:target/cucumber-reports/Automation.json"},
		tags= {},
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests  {

}
