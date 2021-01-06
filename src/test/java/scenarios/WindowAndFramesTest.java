package scenarios;

import main.*;

import java.util.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WindowAndFramesTest {
	
	Browser browserObj;
	WebDriver driver;
	
	
  /*
  * Handling multiple windows
  */
	@Test
	public void childWindowTest() {
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[text()='Privacy']")).click();
		Set<String> handles = driver.getWindowHandles();//window handles are stored in set data structure.
		Iterator itr=handles.iterator();
		String parentHandle = (String) itr.next();
		String childHandle = (String) itr.next();
		driver.switchTo().window(childHandle);
		System.out.println(driver.getTitle());
		driver.switchTo().window(parentHandle);
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}
	
	
	
	/*
	 * Handling frames. Drag and drop action
	 */
	@Test
	public void frameTest() {
		browserObj = new Browser();
		driver = browserObj.getDriverValue(); 
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
			
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		act.moveToElement(target).dragAndDrop(source, target).build().perform();
			
		driver.close();
	}
	
	
	/*
	 * Opening in another tab
	 */
	@Test
	public void tabTest() {
		
		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
			
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		WebElement columnDriver = footerDriver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));//limiting scope again
		
		for(int i=0;i<columnDriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonLink);
			
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		}
		
		Set<String> tabs =driver.getWindowHandles();
		Iterator itr= tabs.iterator();
		
		while(itr.hasNext())
		{
			driver.switchTo().window((String) itr.next());
			System.out.println(driver.getTitle());
		}
		
		
		driver.quit();
	}
	
	
	

}
