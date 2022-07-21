package StepDefinitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPageObject;

public class CheckOutSD extends CheckOutPageObject{
	
	@And("the user verifies {string} product name is displayed in Checkout screen")
	public void the_user_verifies_product_name_details_is_displayed_in_Checkout_screen(String expProduct) {
		assertTrue(verifyProductName(expProduct), "Verify product name is displayed in Checkout screen");
	}
	
	@Then("the user clicks on Proceed to Checkout to land in Address Page")
	public void the_customer_clicks_on_Proceed_to_Checkout_to_land_in_Address_Page() throws Exception {
		assertTrue(verifyAddressCheckout("Addresses"), "Verify Address is displayed in Checkout screen");
	}
	
	@Then("the user clicks on Proceed to Checkout to land in Shipping Page")
	public void the_customer_clicks_on_Proceed_to_Checkout_to_land_in_Shipping_Page() throws Exception {
		assertTrue(verifyShippingCheckout("Shipping"), "Verify Shipment is displayed in Checkout screen");
	}

	@Then("the user clicks on Proceed to Checkout to land in Payment Page")
	public void the_customer_clicks_on_Proceed_to_Checkout_to_land_in_Payment_Page() throws Exception {
		assertTrue(verifyPaymentCheckout("Please choose your payment method", "Printed Summer Dress"), "Verify Payment is displayed in Checkout screen");
	}
}
