package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;

public class ProductPageObject extends CommonFunctions{
	
	WebDriver driver;
	WebDriverWait webDriverWait;
	
	public ProductPageObject() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
	
	private static final By product = By.xpath("(//img[@title='Printed Summer Dress'])[1]");
	private static final By btnAddToCart = By.xpath("//button[@name='Submit']");
	private static final By btnProceedToCheckout = By.xpath("//a[@title='Proceed to checkout']");
	
	public void selectProduct() {
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(product));
		clickElement(driver,product);
	}
	
	public void clickAddToCart() {
		//actionClick(driver,btnAddToCart);
		methodToScrollDownTillTheElementFound(driver,btnAddToCart);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(btnAddToCart));
		clickElement(driver,btnAddToCart);
	}
	
	public void clickProceedToCheckout() {
		webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(btnProceedToCheckout));
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(btnProceedToCheckout));
		clickElement(driver,btnProceedToCheckout);
	}
	
}
