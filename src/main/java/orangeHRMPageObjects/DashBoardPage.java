package orangeHRMPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonPageObjects.CommonFunctions;

public class DashBoardPage extends CommonFunctions{
	
WebDriver driver;
WebDriverWait webDriverWait;

	public DashBoardPage(WebDriver driver, WebDriverWait webDriverWait) {
		this.driver = driver;
		this.webDriverWait = webDriverWait;
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
		return flag;
	}

}
