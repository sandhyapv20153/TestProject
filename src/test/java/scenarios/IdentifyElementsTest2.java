package scenarios;

import java.util.List;

import main.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class IdentifyElementsTest2 {

	Browser browserObj;
	WebDriver driver;

	
	/*
	 * Select static dropdown
	 */
	@Test
	public void staticDropdownTest() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']")));
		WebElement dropDownElem = driver
				.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']"));
		Select currencyDropDown = new Select(dropDownElem);

		currencyDropDown.selectByVisibleText("USD");
		currencyDropDown.selectByValue("BDT");
		currencyDropDown.selectByIndex(1);

		driver.close();

	}

	
	/*
	 * Select dropdown shows up after clicking on an element
	 */
	@Test
	public void staticDropdownTest2() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("divpaxinfo")));
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement dropDownElem = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select adultDropDown = new Select(dropDownElem);
		adultDropDown.selectByVisibleText("5");

		driver.close();
	}

	
	/*
	 * Static dropdown with a + button
	 */
	@Test
	public void staticDropdownTest3() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.united.com/en/us");
		driver.manage().window().maximize();
		try {
			Thread.sleep(100);
		} catch (Exception e) {
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.id("bookFlightModel.passengers")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("savedTripButton")));
		driver.findElement(By.xpath("//input[@id='bookFlightModel.passengers']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("clearPassengers")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("passengersCloseBtn")));
		driver.findElement(By.id("NumOfAdults plusBtn")).click();

		driver.close();

	}
	
	
	/*
	 * Dynamic dropdown- second dropdown populates based on the selection in the first dropdown.
	 */
	@Test
	public void dynamicDropdownTest1() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_ddl_originStation1_CTXT")));
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='BLR']")));
		driver.findElement(By.xpath("//a[@value='BLR']")).click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@value='MAA']")));
		driver.findElement(By.xpath("//a[@value='MAA']")).click();

		driver.close();

	}

	
	/*
	 * Dynamic dropdown populates based on the partial keyword entered
	 */
	@Test
	public void dynamicDropdownTest2() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("autosuggest")));
		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-1")));
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.close();

	}

	
	/*
	 * Checkboxes
	 */
	@Test
	public void checkboxTest1() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_mainContent_chk_friendsandfamily")));
		// Select checkbox
		WebElement familyCheckbox = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
		familyCheckbox.click();
		System.out.println(familyCheckbox.isSelected());

		// find the number of checkboxes selected.
		List<WebElement> options = driver.findElements(By.cssSelector("div[id='discount-checkbox'] div input"));
		int counter = 0;
		for (WebElement option : options) {
			if (option.isSelected()) {
				counter++;
			}
		}
		System.out.println("Number of selected checkboxes :" + counter);

		driver.close();
	}

	
	/*
	 * Selecting calendar element
	 */
	@Test
	public void calendarTest1() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")));
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		driver.close();
	}

	
	/*
	 * Working with alert popup
	 */
	@Test
	public void alertTest() {

		browserObj = new Browser();
		driver = browserObj.getDriverValue();
		WebDriverWait wait = new WebDriverWait(driver, 60);

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("alertbtn")));
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmbtn")).click();
		driver.switchTo().alert().dismiss();

		driver.close();
	}

}
