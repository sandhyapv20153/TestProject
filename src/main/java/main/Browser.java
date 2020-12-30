package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * @author Sandhya
 *
 */
public class Browser{
	
	protected static WebDriver browserDriver =null;
	protected String browserName;
	protected WebElement elem;
	
	
	
	public Browser() {
		this.browserName = PropertyFileUtility.readPropertyFile(Constants.PROJECT_PROPERTYFILE_PATH,"userBrowser");
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_DRIVER_PATH);
			browserDriver = new ChromeDriver();
			browserDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		else
		{
			System.out.println("Invalid browser");
		}

	}
	
	public WebDriver getDriverValue()
	{
		return browserDriver;
	}
	
	// Closes browser window that driver has focus on
	public void driverClose()
	{
		if(browserDriver!=null)
			browserDriver.close();
	}
	
	//Calls dispose which will close all browser windows and safely end session
	public void driverQuit()
	{
		if(browserDriver!=null)
			browserDriver.quit();
	}
	


}
