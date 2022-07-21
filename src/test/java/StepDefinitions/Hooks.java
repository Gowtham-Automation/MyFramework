package StepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp() {
		DriverManager driverManager = new DriverManager();
		try {
			driver = driverManager.getDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterStep
	public void printScreenEveryStep(Scenario scenario) {
		try {
			CommonFunctions.attachScreenshot(driver,scenario, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			if(scenario.isFailed())
				scenario.log("Scenario got Failed");
			else
				scenario.log("Scenario got Successfull");
			CommonFunctions.attachScreenshot(driver,scenario, screenshotName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
}
