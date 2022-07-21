@Account
Feature: Validate create account feature
  	  
  @CreateAccount
  Scenario Outline: validate user able to create an account successfully
	  Given user launches the application
	  When the user clicks on Sign in button
	  And user should navigate to "Authentication" screen
    Then the user enter the "<EmailID>" to "create an account"
  	And the user enters the mandatory fields and clicks on register
  	| Title   | FirstName |LastName |Password|
    | Mr 			| Malik 		|das 			|feabcd  |
  	And the user verifies if the name is displayed correctly
  	Then the user clicks on logout button
  	  
  	  Examples:
  	  |EmailID       	   |
  	  | b.ke50@gmail.com |