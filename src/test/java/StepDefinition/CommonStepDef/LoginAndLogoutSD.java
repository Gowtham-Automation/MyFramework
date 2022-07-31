package StepDefinition.CommonStepDef;

import java.io.IOException;

import commonPageObjects.DriverManager;
import io.cucumber.java.en.Given;

public class LoginAndLogoutSD {
	
  @Given("user launches the {string} application")
	public void user_launches_the_application(String application) throws IOException {
		DriverManager driverManager = new DriverManager();
		driverManager.launchApplication(application);
	}
}
