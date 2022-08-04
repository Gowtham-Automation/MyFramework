package StepDefinition.OrangeHrmStepDef;


import org.testng.Assert;

import commonPageObjects.TestContextSetup;
import io.cucumber.java.en.Then;
import orangeHRMPageObjects.DashBoardPage;
import orangeHRMPageObjects.LoginPage;

public class DashboardPageSD {
	
	TestContextSetup testContextSetup;
	public DashBoardPage dashBoardPage;
	
	public DashboardPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.dashBoardPage = testContextSetup.pageObjectManager.getDashBoardPage();
	}

	@Then("verify user is successfully login to dashboard")
	public void verify_user_is_successfully_login_to_dashboard() {
		Assert.assertTrue(dashBoardPage.verifyDashBoardTitle(), "Successfully login to dashboard");
	}
}
