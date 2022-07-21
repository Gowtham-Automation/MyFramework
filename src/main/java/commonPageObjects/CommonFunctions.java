package commonPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Scenario;


public class CommonFunctions extends DriverManager {
	WebDriver driver;
	public WebElement element;
	public WebDriverWait webDriverWait;

	public CommonFunctions() {
		this.driver = DriverManager.driver;
		this.webDriverWait = DriverManager.webDriverWait;
	}
	
	public static void clickElement(WebDriver driver, By element){
		driver.findElement(element).click();
	}
	
	public static void sendInput(WebDriver driver, By element, String input){
		driver.findElement(element).sendKeys(input);
	}
	
	public static void sendInput(WebDriver driver, By element, Keys key){
		driver.findElement(element).sendKeys(key);
	}
	
	public static void clickElementJS(WebDriver driver, By element){
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element.findElement(driver));
	}
	
	public static boolean ValidateFieldValue(String val, String actVal, String expVal){
		boolean flag = false;
		
		if(expVal.equals(actVal)) {
			System.out.println(val+ "in UI -" +val+ "and data -"+ expVal);
			flag = true;
		}
		else {
			System.out.println("Failed" + val+ "in UI -" +val+ "and data -"+ expVal +"are not matched");
			flag = false;
		}
		return flag;
	}
	
	public String elementGetText(WebDriver driver, By byType){
		String returnText ="";
		element =  driver.findElement(byType);
		if(element.isDisplayed() && element.isEnabled()) {
			returnText = element.getText();
		}
		else
			System.out.println("Element is not present in UI");
		return returnText;
	}
	
	public static void selectDropdown(WebDriver driver, By element, String value){
		WebElement dropdown=driver.findElement(element);
	    Select select=new Select(dropdown);
	    select.selectByVisibleText(value);
	}
	
	public static void actionClick(WebDriver driver, By element){
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(element);
		action.moveToElement(ele).click().perform();
	}
	
	public static void methodToScrollDownTillTheElementFound(WebDriver driver, By element){
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement ele=driver.findElement(element);
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void attachScreenshot(WebDriver driver, Scenario scenario, String screenshotName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", screenshotName);
	}
	
}
