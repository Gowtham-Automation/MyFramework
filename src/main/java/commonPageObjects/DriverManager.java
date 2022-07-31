package commonPageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverManager {
	public static WebDriver driver;
	public static WebDriverWait webDriverWait;
	private static Properties properties;
	TestContextSetup testContextSetup;
	
	static {
		properties = new Properties();
			try {
				properties.load(new FileInputStream("src/main/resources/config/config.properties"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public WebDriver launchApplication(String url) throws IOException{
		getDriver();
		driver.get(properties.getProperty(url));
		driver.manage().window().maximize();
		return driver;
	}

	
	public WebDriver getDriver() throws IOException {
		WebDriver driver = null;
		String driverPath = properties.getProperty("Driver");
		if(properties.getProperty("Browser").equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",driverPath);
			driver = new ChromeDriver();
		}
		else if(properties.getProperty("Browser").equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", driverPath);
			driver= new FirefoxDriver();
		}
		else if(properties.getProperty("Browser").equals("IE"))
		{
			System.setProperty("webdriver.ie.driver", driverPath);
			driver = new InternetExplorerDriver();
			
		}
		else
			System.out.println("Browser value not initialized in Property file");
		webDriverWait = new WebDriverWait(driver, returnExplicitWait());
		return DriverManager.driver = driver;
	}
	
	public static long returnExplicitWait() {
		String s= properties.getProperty("Wait");
		long wait =Long.parseLong(s);
		return wait;
	}
	
	public void closeWindow() {
		driver.close();
	}
}
