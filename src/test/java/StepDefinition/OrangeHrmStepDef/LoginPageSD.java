package StepDefinition.OrangeHrmStepDef;


import commonPageObjects.TestContextSetup;
import io.cucumber.java.en.When;

public class LoginPageSD extends orangeHRMPageObjects.LoginPageObject{
	
	public LoginPageSD(TestContextSetup testContextSetup) {
		super(testContextSetup);
	}

	@When("the user is logged in")
	public void the_user_is_logged_in() {
		enterUsernamePassword();
	}
}
