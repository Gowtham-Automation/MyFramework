package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;

public class MyAccountPageObject extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;

	public MyAccountPageObject() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
	
	private static final By txtMyAccountTitle = By.xpath("//h1[text()='My account']");
	private static final By customerNameMyAccount = By.xpath("//a[@class='account']//span");
	private static final By signOut = By.xpath("//a[@class='logout']");
	private static final By searchProduct = By.xpath("//input[@id='search_query_top']");
	private static final By submitSearch = By.xpath("//button[@name='submit_search']");
	
	public boolean verifyMyAccountScreenLoaded(String expTitle) {
		boolean flag = false;
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtMyAccountTitle));
		String actualTitle = elementGetText(driver,txtMyAccountTitle);
		flag = ValidateFieldValue("My Account Title ",actualTitle, expTitle.toUpperCase());
		return flag;
	}
	
	public boolean verifyCustomerNameIsDisplayed(String expTitle) {
		boolean flag = false;
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(customerNameMyAccount));
		String actualTitle = elementGetText(driver,customerNameMyAccount);
		flag = ValidateFieldValue("Customer Name ",actualTitle, expTitle);
		return flag;
	}
	
	public void signOut() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(signOut));
		clickElement(driver,signOut);
	}
	
	public void searchProduct() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(searchProduct));
		sendInput(driver,searchProduct,"dress");
		clickElement(driver,submitSearch);
	}
}
