package StepDefinitions;

import io.cucumber.java.en.When;
import pageObjects.HomePageObject;

public class HomePageSD extends HomePageObject{

	@When("the user clicks on Sign in button")
	public void the_user_clicks_on_Sign_in_button() throws Exception {
		clickSignInButton();
		Thread.sleep(1000);
	}
}
