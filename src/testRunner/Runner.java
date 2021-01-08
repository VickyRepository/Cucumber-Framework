package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Feature", glue = {"stepDefinition"},

		         plugin = {"com.cucumber.listener.ExtentCucumberFormatter:output/report.html"},monochrome=true,
		         format = {"pretty"},
		         tags= {"~@Order","@Crm"})

public class Runner {

	
}
