package commonPageObjects;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.PageObjectManager;

public class TestContextSetup {
	
	public Map<String, String> dataManager = new HashMap<String, String>();
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public DriverManager driverManager;
	public WebDriverWait webDriverWait;
	
	public TestContextSetup() throws IOException
	{
		driverManager = new DriverManager();
		this.driver = driverManager.getDriver();
		this.webDriverWait = driverManager.synchronize();
		pageObjectManager = new PageObjectManager(driver, webDriverWait);
	}

}
