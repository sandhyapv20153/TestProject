package scenarios;

import main.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import main.Browser;

public class WindowAuthenticationTest {
	
	Browser browserObj;
	WebDriver driver;

	/*
	 * Handling browser popup authentication
	 */
	@Test
	public void windowAutenticationTest() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/");// pattern will be http://username:password@siteurl
		driver.findElement(By.linkText("Basic Auth")).click();
		
		
		
		
	}

}
