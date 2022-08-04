package managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.TestContextSetup;
import orangeHRMPageObjects.DashBoardPage;
import orangeHRMPageObjects.LoginPage;

public class PageObjectManager {
	
	private DashBoardPage dashBoardPage;
	private LoginPage loginPage;
	public WebDriver driver;
	TestContextSetup testContextSetup;
	WebDriverWait webDriverWait;
	
	public PageObjectManager(WebDriver driver, WebDriverWait webDriverWait){
		this.driver = driver;
		this.webDriverWait = webDriverWait;
	}

	/*
	 * To create an Object of Page Class only if the object is null.
	   To supply the already created object if it is not null
	 */
	public DashBoardPage getDashBoardPage(){

		return (dashBoardPage == null) ? dashBoardPage = new DashBoardPage(driver,webDriverWait) : dashBoardPage;
	}
	
	public LoginPage getLoginPage(){		
		return (loginPage == null) ? loginPage = new LoginPage(driver,webDriverWait) : loginPage;
	}

}
