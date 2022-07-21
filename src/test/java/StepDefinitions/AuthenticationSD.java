package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.AuthenticationPageObject;

public class AuthenticationSD extends AuthenticationPageObject{
	
	@And("user should navigate to {string} screen")
	public void user_should_navigate_to_authentication_screen(String title) {
		assertTrue(verifyAuntenticationScreenLoaded(title), "Verify User should be navigated to "+ title+ "Screen");
	}
	
	@Then("the user enter the {string} to {string}")
	public void the_user_enter_the_to_create_an_account(String emailId, String title) throws Exception {
		Thread.sleep(1000);
		enterEmailId(emailId);
		Thread.sleep(1000);
		clickCreateAccount();
		assertTrue(verifyCreateAnAccountScreenLoaded(title), "Verify Create an account screen is loaded");
	}
	
	@And("the user enters the mandatory fields and clicks on register")
	public void the_user_enters_the_mandatory_fields_and_clicks_on_register(DataTable customerData) throws Exception {
		List<Map<String,String>> data = customerData.asMaps(String.class,String.class);
		Thread.sleep(1000);
		selectTitle(data.get(0).get("Title"));
		enterFirstName(data.get(0).get("FirstName"));
		enterLastName(data.get(0).get("LastName"));
		enterPassword(data.get(0).get("Password"));
		enterAddressDetails();
		clickButtonSubmitAccount();
		verifyMyAccountScreenLoaded("My Account");
	}
	
	@And("the user enters the {string} and {string} and clicks on sign in")
    public void the_user_enters_the_credentials_and_clicks_on_sign_in(String email, String password) throws InterruptedException {
		signIn(email,password, "My Account");
    }
}
