package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;

public class CheckOutPageObject extends CommonFunctions{
	
	WebDriver driver;
	WebDriverWait webDriverWait;
	
	public CheckOutPageObject() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
	
	public static final By txtcartProductDescription = By.xpath("//td[@class='cart_description']/p");
	public static final By btnProcessSignInCheckout = By.xpath("//p[@class='cart_navigation clearfix']//a[@title ='Proceed to checkout']");
	public static final By txtaddress = By.xpath("//h1[text()='Addresses']");
	public static final By btnProcessAddressCheckout = By.xpath("//button[@name='processAddress']");
	public static final By txtShippingTitle = By.xpath("//h1[text()='Shipping']");
	public static final By termsOfServiceCheckBox = By.xpath("//input[@id='cgv']");
	public static final By btnProcessShipmentCheckout = By.xpath("//button[@name='processCarrier']");
	public static final By txtPaymentTitle = By.xpath("//h1[text()='Please choose your payment method']");

	
	public boolean verifyProductName(String expProductName) {
		boolean flag = false;
		String actualProductName = elementGetText(driver,txtcartProductDescription);
		flag = ValidateFieldValue("Verify Cart Product Description",actualProductName, expProductName);
		return flag;
	}
	
	public boolean verifyAddressCheckout(String expTitle) throws Exception{
		boolean flag = false;
		methodToScrollDownTillTheElementFound(driver,btnProcessSignInCheckout);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(btnProcessSignInCheckout));
		clickElement(driver,btnProcessSignInCheckout);
		//actionClick(driver,btnProcessSignInCheckout);
		Thread.sleep(1000);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtaddress));
		String actualTitle = elementGetText(driver,txtaddress);
		flag = ValidateFieldValue("Verify Address Title is displayed",actualTitle, expTitle.toUpperCase());
		return flag;
	}	
	
	public boolean verifyShippingCheckout(String expTitle) throws Exception {
		boolean flag = false;
		methodToScrollDownTillTheElementFound(driver,btnProcessAddressCheckout);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(btnProcessAddressCheckout));
		clickElement(driver,btnProcessAddressCheckout);
		//actionClick(driver,btnProcessAddressCheckout);
		Thread.sleep(1000);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtShippingTitle));
		String actualTitle = elementGetText(driver,txtShippingTitle);
		flag = ValidateFieldValue("Verify Shipping title is displayed",actualTitle, expTitle.toUpperCase());
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(termsOfServiceCheckBox));
		clickElement(driver,termsOfServiceCheckBox);
		return flag;
	}
	
	public boolean verifyPaymentCheckout(String expTitle, String expProductName) throws Exception {
		boolean flag = false;
		methodToScrollDownTillTheElementFound(driver,btnProcessShipmentCheckout);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(btnProcessShipmentCheckout));
		clickElement(driver,btnProcessShipmentCheckout);
		//actionClick(driver,btnProcessShipmentCheckout);
		Thread.sleep(1000);
		webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtPaymentTitle));
		String actualTitle = elementGetText(driver,txtPaymentTitle);
		flag = ValidateFieldValue("Verify Payment title is displayed",actualTitle, expTitle.toUpperCase());
		String actualProductName = elementGetText(driver,txtcartProductDescription);
		flag = flag && ValidateFieldValue("Verify Cart Product Description",actualProductName, expProductName);
		return flag;
	}
	
	 
}
