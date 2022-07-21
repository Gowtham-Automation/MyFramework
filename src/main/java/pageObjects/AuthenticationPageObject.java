package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;
import commonPageObjects.DriverManager;

public class AuthenticationPageObject extends CommonFunctions{
	
	WebDriver driver;
	WebDriverWait webDriverWait;
	
	public AuthenticationPageObject() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
		
		private static final By txtAuthenticationTitle = By.xpath("//h1[@class='page-heading'][text()='Authentication']");
		private static final By txtInputEmailId = By.xpath("//input[@id='email_create']");
		private static final By btnCreateAccount = By.xpath("//button[@id='SubmitCreate']");
		private static final By txtCreateAnAccountTitle = By.xpath("//h1[@class='page-heading'][text()='Create an account']");
		private static final By txtInputCustomerFirstName = By.xpath("//input[@id='customer_firstname']");
		private static final By txtInputCustomerLastName = By.xpath("//input[@id='customer_lastname']");
		private static final By txtInputCustomerPassword = By.xpath("//input[@id='passwd']");
		private static final By txtTitleLabel = By.xpath("//label[text()='Title']");
		private static final By radioinputMr = By.xpath("//input[@name='id_gender'][@value='1']");
		private static final By radioinputMrs = By.xpath("//input[@name='id_gender'][@value='2']");
		private static final By txtInputAddressFirstName = By.xpath("//input[@id='firstname']");
		private static final By txtInputAddressLastName = By.xpath("//input[@id='lastname']");
		private static final By txtInputAddress = By.xpath("//input[@name='address1']");
		private static final By txtInputCity = By.xpath("//input[@name='city']");
		private static final By txtInputState = By.xpath("//select[@name='id_state']");
		private static final By txtInputPostCode = By.xpath("//input[@id='postcode']");
		private static final By txtInputCountry = By.xpath("//select[@id='id_country']");
		private static final By txtInputMobilePhone = By.xpath("//input[@id='phone_mobile']");
		private static final By txtInputaliasAddress = By.xpath("//input[@name='alias']");
		private static final By btnSubmitAccount = By.xpath("//button[@id='submitAccount']");
		private static final By txtMyAccountTitle = By.xpath("//h1[text()='My account']");
		private static final By txtInputSignInEmail = By.xpath("(//input[@name='email'])[1]");
		private static final By txtInputSignInPassword = By.xpath("//input[@name='passwd']");
		private static final By btnSignInSubmit = By.id("SubmitLogin");
		
		
		public boolean verifyAuntenticationScreenLoaded(String expTitle) {
			boolean flag = false;
			webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(txtAuthenticationTitle));
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtAuthenticationTitle));
			String actualTitle = elementGetText(driver,txtAuthenticationTitle);
			flag = ValidateFieldValue("Verify Authentication screen is loaded",actualTitle, expTitle.toUpperCase());
			return flag;
		}
		
		public void enterEmailId(String emailId) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputEmailId));
			sendInput(driver, txtInputEmailId, emailId);
		}
		
		public void clickCreateAccount() {
			clickElement(driver,btnCreateAccount);
		}
		
		public boolean verifyCreateAnAccountScreenLoaded(String expTitle) {
			boolean flag = false;
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtCreateAnAccountTitle));
			String actualTitle = elementGetText(driver,txtCreateAnAccountTitle);
			flag = ValidateFieldValue("Verify Create an account screen is loaded",actualTitle, expTitle.toUpperCase());
			return flag;
		}
		
		public void selectTitle(String title) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtTitleLabel));
			if(title.equals("Mr"))
				clickElement(driver,radioinputMr);
			else if(title.equals("Mrs"))
				clickElement(driver,radioinputMrs);
		}
		
		public void enterFirstName(String firstName) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputCustomerFirstName));
			sendInput(driver, txtInputCustomerFirstName, firstName);
		}
		
		public void enterLastName(String lastName) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputCustomerLastName));
			sendInput(driver, txtInputCustomerLastName, lastName);
		}
		
		public void enterPassword(String password) {
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputCustomerPassword));
			sendInput(driver, txtInputCustomerPassword, password);
		}
		
		public void enterAddressDetails() {
			//EnterAddressFirstName
//			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputAddressFirstName));
//			sendInput(driver, txtInputAddressFirstName, "Malik");
			
			//EnterLastName
//			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputAddressLastName));
//			sendInput(driver, txtInputAddressLastName, "das");
			
			//Enter Address
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputAddress));
			sendInput(driver, txtInputAddress, "No 22");
			
			//select Country
			selectDropdown(driver,txtInputCountry,"United States");
			
			//select State
			selectDropdown(driver,txtInputState,"Arizona");
			
			//Enter City
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputCity));
			sendInput(driver, txtInputCity, "NY");
			
			//Enter PostCode
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputPostCode));
			sendInput(driver, txtInputPostCode, "56470");
			
			//Enter Mobile Number
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputMobilePhone));
			sendInput(driver, txtInputMobilePhone, "098765432");
			
			//Enter alias address
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputaliasAddress));
			sendInput(driver, txtInputaliasAddress, "test");
		}
		
		public void clickButtonSubmitAccount() {
			clickElement(driver,btnSubmitAccount);
		}
		
		public boolean verifyMyAccountScreenLoaded(String expTitle) {
			boolean flag = false;
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtMyAccountTitle));
			String actualTitle = elementGetText(driver,txtMyAccountTitle);
			flag = ValidateFieldValue("Verify My account screen is loaded",actualTitle, expTitle.toUpperCase());
			return flag;
		}
		
		public boolean signIn(String email, String password,String expTitle) {
			boolean flag = false;
			webDriverWait.until(ExpectedConditions.presenceOfElementLocated(txtInputSignInEmail));
			sendInput(driver, txtInputSignInEmail, email);
			sendInput(driver, txtInputSignInPassword, password);
			clickElement(driver,btnSignInSubmit);
			flag = verifyMyAccountScreenLoaded(expTitle);
			return flag;
		}

}
