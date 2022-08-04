package StepDefinition.CommonStepDef;

import commonPageObjects.CommonFunctions;
import commonPageObjects.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	TestContextSetup testContextSetup; 
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	
	@Before
	public void setUp(Scenario scenario) {
		scenario.log("Driver Setup Done - Start Scenario");
	}
	
//	@AfterStep
//	public void printScreenEveryStep(Scenario scenario) {
//		try {
//			CommonFunctions.attachScreenshot(testContextSetup.driver,scenario, "");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@After
	public void tearDown(Scenario scenario) {
		try {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			if(scenario.isFailed())
				scenario.log("Scenario got Failed");
			else
				scenario.log("Scenario got Successfull");
			CommonFunctions.attachScreenshot(testContextSetup.driver,scenario, screenshotName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		testContextSetup.driver.close();
	}
}
