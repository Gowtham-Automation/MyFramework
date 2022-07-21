package StepDefinitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MyAccountPageObject;
import pageObjects.ProductPageObject;

public class MyAccountSD extends MyAccountPageObject{
	ProductPageObject productPageObject;
	
	@And("the user verifies if the name is displayed correctly")
	public void the_user_verifies_if_the_name_is_displayed_correctly() {
		assertTrue(verifyMyAccountScreenLoaded("My Account"), "Verify my account screen is loaded");
		assertTrue(verifyCustomerNameIsDisplayed("Malik das"), "Verify customer name is displayed");
	}
	
	@Then("the user clicks on logout button")
	public void the_user_clicks_on_logout_button() {
		signOut();
	}
	
	@When("the user adds a product to the cart")
    public void the_customer_adds_a_product_to_the_cart() throws Exception {
        Thread.sleep(1000);
        searchProduct();
        Thread.sleep(1000);
        productPageObject = new ProductPageObject();
        productPageObject.selectProduct();
        Thread.sleep(2000);
        productPageObject.clickAddToCart();
    }
	
	@Then("the user lands in checkout page")
	public void the_customer_lands_in_checkout_page() throws Exception {
		Thread.sleep(1000);
		productPageObject = new ProductPageObject();
		productPageObject.clickProceedToCheckout();
	}
}
