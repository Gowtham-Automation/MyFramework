package StepDefinition.OrangeHrmStepDef;


import org.testng.Assert;

import commonPageObjects.TestContextSetup;
import io.cucumber.java.en.Then;

public class DashboardPageSD extends orangeHRMPageObjects.DashBoardPageObject{
	
	public DashboardPageSD(TestContextSetup testContextSetup) {
		super(testContextSetup);
	}

	@Then("verify user is successfully login to dashboard")
	public void verify_user_is_successfully_login_to_dashboard() {
		Assert.assertTrue(verifyDashBoardTitle(), "Successfully login to dashboard");
	}
}
