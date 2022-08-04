package StepDefinition.OrangeHrmStepDef;


import commonPageObjects.TestContextSetup;
import io.cucumber.java.en.When;
import orangeHRMPageObjects.LoginPage;

public class LoginPageSD {
	TestContextSetup testContextSetup;
	public LoginPage loginPage;
	
	public LoginPageSD(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.loginPage = testContextSetup.pageObjectManager.getLoginPage();
	}

	@When("the user is logged in")
	public void the_user_is_logged_in() {
		testContextSetup.dataManager = loginPage.setUsernamePassword();
		String userName = testContextSetup.dataManager.get("Username");
		String password = testContextSetup.dataManager.get("Password");
		loginPage.enterUsernamePassword(userName, password);
	}
}
