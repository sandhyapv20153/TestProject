package scenarios;


import static org.junit.Assert.*;

import org.junit.Assert;

import main.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IdentifyElementsTest {

	Browser browserObj;
	WebDriver driver;
	
	//xpath and css selector
	@Test
	public void testOne() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#email")).sendKeys("Email");
		driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("password");
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		driver.close();
		
	}
	
	
	//Identifying sibling..
	@Test
	public void testTwo() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://rahulshettyacademy.com/#/index");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='courses-block col-lg-3 col-md-4 col-sm-6 col-xs-12']/following-sibling::div[2]")).click();
		String strTitle = driver.findElement(By.cssSelector("h1[class='course-title']")).getText();
		
		if(strTitle.contains("JMETER"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}

		
		driver.close();
		
	}
	
	//Identifying parent
	@Test
	public void testThree() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://rahulshettyacademy.com/#/index");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Courses']/parent::li")).click();
		
		driver.close();
		
	}
	
	
	//identifying element based on text
	@Test
	public void testFour() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://www.rahulshettyacademy.com/#/practice-project");
		driver.manage().window().maximize();
		
		if(driver.findElement(By.xpath("//*[text()='Join now to Practice']")).isDisplayed())
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
				
	
		driver.close();
		
	}
	
	
	
	
	

}
