@SignInSignOut
Feature: Validate Sign In Sign Out functionalities
  	  
  @SignIn @signOut
  Scenario Outline: validate user able to sign in and sign out successfully
	  Given user launches the "AutomationPractice" application
	  When the user clicks on Sign in button
	  And the user enters the "<EmailID>" and "<Password>" and clicks on sign in
	  Then the user clicks on logout button
	   
	    Examples:
  	  |EmailID       	   |Password|
  	  | b.ke51@gmail.com | feabcd |