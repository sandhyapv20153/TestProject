package scenarios;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import main.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class IdentifyElementsTest2 {
	
	Browser browserObj;
	WebDriver driver;

	@Test
	public void staticDropdownTest() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		WebElement dropDownElem = driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']"));
		Select currencyDropDown= new Select(dropDownElem);
		
		currencyDropDown.selectByVisibleText("USD");
		currencyDropDown.selectByValue("BDT");
		currencyDropDown.selectByIndex(1);
		
		driver.close();
		
	}
	
	
	
	
	@Test
	public void staticDropdownTest2() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement dropDownElem = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select adultDropDown= new Select(dropDownElem);
		adultDropDown.selectByVisibleText("5");
		
		driver.close();
	}
	
	
	
	
	@Test
	public void staticDropdownTest3() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		driver.get("https://www.united.com/en/us");
		driver.manage().window().maximize();
		try
		{
		Thread.sleep(100);
		}catch(Exception e) {}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("bookFlightModel.passengers")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("savedTripButton")));
		driver.findElement(By.xpath("//input[@id='bookFlightModel.passengers']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("clearPassengers")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("passengersCloseBtn")));
		driver.findElement(By.id("NumOfAdults plusBtn")).click();

		driver.close();
		
		
	}
	
	
	
	
	
	@Test
	public void dynamicDropdownTest1() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver,60);
		
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		try
		{
		Thread.sleep(100);
		}catch(Exception e) {}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='BLR']")));
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='MAA']")));
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		
		try
		{
		Thread.sleep(1000);
		}catch(Exception e) {}
		
		
		driver.close();
		
		
	}


}
