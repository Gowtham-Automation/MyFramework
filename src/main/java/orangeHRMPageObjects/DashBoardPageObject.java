package orangeHRMPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;
import commonPageObjects.TestContextSetup;

public class DashBoardPageObject extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;
TestContextSetup testContextSetup;

	//"TestContextSetup" is a Dependency Injector class there we are storing common objects
	public DashBoardPageObject(TestContextSetup testContextSetup) {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
		this.testContextSetup = testContextSetup;
	}
	
	private static final By txtDashBoardTitle = By.xpath("//div[@class='head']//h1");

	/*
	 * Verify dashboard title once login
	 */
	public boolean verifyDashBoardTitle() {
		boolean flag = false;
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtDashBoardTitle));
		String actualTitle= elementGetText(driver,txtDashBoardTitle);
		flag = ValidateFieldValue("DashBoard Title Validation", actualTitle, "Dashboard");
		System.out.println("The user name is " + testContextSetup.dataManager.get("Username"));
		return flag;
	}

}
