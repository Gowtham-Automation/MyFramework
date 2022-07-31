package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features ="@target/failed_scenarios.txt",
glue= {"StepDefinitions"},
monochrome=true, // Display the console output in a proper readable format
dryRun = false, // Checks that every Step mentioned in the Feature File have corresponding code in Step Definition file or not
plugin= {"pretty","html:target/test-output",
		"json:target/json-output/report.json",
		"junit:target/junit-xml/report.xml",
		"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})// to generate different types of reporting

public class FailedTestRunner {

}
