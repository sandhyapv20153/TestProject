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

public class UserActionTest {
	
	Browser browserObj;
	WebDriver driver;

	/*
	 * Actions class - performs all user actions such as hover,right click, drag and drop
	 */
	@Test
	public void actionTest() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		
		Actions act = new Actions(driver);
		WebElement elem = driver.findElement(By.id("nav-link-accountList"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-link-accountList")));
		act.moveToElement(elem).build().perform();
		
		WebElement searchElem = driver.findElement(By.id("twotabsearchtextbox"));
		act.moveToElement(searchElem).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		
		act.moveToElement(elem).contextClick().build().perform();
		
		driver.close();		
		
	}

}
