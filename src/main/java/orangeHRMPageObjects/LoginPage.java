package orangeHRMPageObjects;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.TestContextSetup;

public class LoginPage extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;

	public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
		this.driver = driver;
		this.webDriverWait = webDriverWait;
	}
	
	private static final By signInBtn = By.xpath("//span[contains(text(),'Username') and contains(text(),'Password')]");
	private static final By txtUserName = By.xpath("//input[@name='txtUsername']");
	private static final By txtPassword = By.xpath("//input[@name='txtPassword']");
	private static final By btnLogin = By.xpath("//input[@id='btnLogin']");

	public void enterUsernamePassword(String userName, String password) {
		sendInput(driver,txtUserName,userName);
		sendInput(driver,txtPassword,password);
		clickElement(driver,btnLogin);
	}
	
	public Map<String,String> setUsernamePassword(){
		
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signInBtn));
		String credentials = elementGetText(driver,signInBtn);
		String result = credentials.replaceAll("[^A-Za-z0-9]", " ").replace("   ", " ").trim();
		String value[] = result.split(" ");
		Map<String, String> mapData = new HashMap<String, String>();
		for(int i=0; i<value.length; i++) {
			if(value[i].equals("Username")) {
				mapData.put("Username", value[i+1]);
			}
			else if(value[i].equals("Password")) {
				mapData.put("Password", value[i+1]);
			}	
		}
		return mapData;
	}
}
