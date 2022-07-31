@OrangeHRMSignInFeature
Feature: Validate Sign In functionalities
  	  
  @OrangeHRMSignIn
  Scenario: validate user able to sign in successfully
	  Given user launches the "OrangeHRM" application
	  When the user is logged in
	  Then verify user is successfully login to dashboard