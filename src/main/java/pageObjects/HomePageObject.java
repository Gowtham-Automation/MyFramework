package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;

public class HomePageObject extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;

	public HomePageObject() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
	
	private static final By signInBtn = By.className("login");

	public void clickSignInButton() {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(signInBtn));
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signInBtn));
		clickElement(driver,signInBtn);
	}

}
