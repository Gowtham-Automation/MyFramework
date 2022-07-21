package StepDefinitions;

import java.io.IOException;

import commonPageObjects.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginAndLogoutSD {
	
  @Given("user launches the application")
	public void user_launches_the_application() throws IOException {
		DriverManager driverManager = new DriverManager();
		driverManager.launchApplication();
	}
  
  @Then("the customer clicks on logout button")
	public void the_customer_clicks_on_logout_button() throws IOException {
		DriverManager driverManager = new DriverManager();
		driverManager.launchApplication();
	}
  
}
