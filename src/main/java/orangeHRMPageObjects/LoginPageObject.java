package orangeHRMPageObjects;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;
import commonPageObjects.TestContextSetup;

public class LoginPageObject extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;
TestContextSetup testContextSetup;

	//"TestContextSetup" is a Dependency Injector class there we are storing common objects
	public LoginPageObject(TestContextSetup testContextSetup) {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
		this.testContextSetup = testContextSetup;
	}
	
	private static final By signInBtn = By.xpath("//span[contains(text(),'Username') and contains(text(),'Password')]");
	private static final By txtUserName = By.xpath("//input[@name='txtUsername']");
	private static final By txtPassword = By.xpath("//input[@name='txtPassword']");
	private static final By btnLogin = By.xpath("//input[@id='btnLogin']");

	public void enterUsernamePassword() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signInBtn));
		String credentials = elementGetText(driver,signInBtn);
		String result = credentials.replaceAll("[^A-Za-z0-9]", " ").replace("   ", " ").trim();
		String value[] = result.split(" ");
		testContextSetup.dataManager = new HashMap<String, String>();
		for(int i=0; i<value.length; i++) {
			if(value[i].equals("Username")) {
				testContextSetup.dataManager.put("Username", value[i+1]);
			}
			else if(value[i].equals("Password")) {
				testContextSetup.dataManager.put("Password", value[i+1]);
			}	
		}
		sendInput(driver,txtUserName,testContextSetup.dataManager.get("Username"));
		sendInput(driver,txtPassword,testContextSetup.dataManager.get("Password"));
		clickElement(driver,btnLogin);
	}
}
