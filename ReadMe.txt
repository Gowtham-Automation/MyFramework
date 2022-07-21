AUTHOR: GOWTHAM

Plugin
1. Install "Cucumber eclipse Plugin"

Dependencies 

1. To support Cucumber - cucumber-java dependencies
2. To Support assertions/@RunWith - Junit
3. To support @CucumberOptions, Cucumber.class - Cucumber-Junit
4. To Support Selenium - selenium-java
5. To support Allure Reports - allure-cucumber7-jvm & Plugins

Configurations
1. Browser & Driver informations are located at "src/main/resources/config/config.properties" 

Steps to Run
1. Download this package and run in any IDE
2. The project is developed on Maven Build and dependencies will be downloaded automatically on first run
3. Open the testRunner file and click on Run. The testRunner is placed in "src\test\java\TestRunner\TestRunner.java"

How to see Test Execution results in Allure

Pre requisite
1. Install node js in your machine
2. Install npm install -g allure-commandline

Once after the test execution 
	Right click on project
	select "Terminal" under "Show in Local Terminal"
	Enter command "allure serve" - It'll generate a report