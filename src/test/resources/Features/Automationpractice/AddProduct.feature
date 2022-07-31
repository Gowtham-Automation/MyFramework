@Product
Feature: Validate Automation product application functionalities

  @AddProduct
  Scenario Outline: validate user able to add product and proceed till payments
	  Given user launches the "AutomationPractice" application
	  When the user clicks on Sign in button
	  And user should navigate to "Authentication" screen
    Then the user enter the "<EmailID>" to "create an account"
  	And the user enters the mandatory fields and clicks on register
  	And the user verifies if the name is displayed correctly
  	Then the user clicks on logout button
	  And the user enters the "<EmailID>" and "<Password>" and clicks on sign in
	  And the user adds a product to the cart
	  Then the user lands in checkout page
	  And the user verifies "Printed Summer Dress" product name is displayed in Checkout screen
	  Then the user clicks on Proceed to Checkout to land in Address Page
	  Then the user clicks on Proceed to Checkout to land in Shipping Page
	  Then the user clicks on Proceed to Checkout to land in Payment Page
  	  
  	  Examples:
  	  |EmailID       	  |Password|
  	  | b.h43@gmail.com | feabcd |