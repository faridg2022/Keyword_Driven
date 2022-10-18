package com.operation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class UIOperations {

	WebDriver driver;

	public UIOperations() {
		// this.driver = driver;
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//this.driver = driver;
		driver.manage().window().maximize();
	}

	public void perform(Properties p, String operation, String objectName, String objectType, String value, String ddType)
			throws Exception {
		// System.out.println("");
		switch (operation.toUpperCase()) {
		case "CLICK":
			// Perform click
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
		case "SETTEXT":
			// Set text on control
			driver.findElement(this.getObject(p, objectName, objectType)).sendKeys(value);
			break;

		case "GOTOURL":
			// Get url of application
			driver.get(p.getProperty(value));
			break;
		case "CLOSEBROWSER":
			// Close Browser
			driver.quit();
			break;
		case "GETTEXT":
			// Get text of an element
			driver.findElement(this.getObject(p, objectName, objectType)).getText();
			break;
		case "SELECTRADIOBUTTON":
			// Get text of an element
			driver.findElement(this.getObject(p, objectName, objectType)).click();
			break;
		case "SELECTDROPDOWNVALUE":
			// Get text of an element
			Select sele = new Select(driver.findElement(this.getObject(p, objectName, objectType)));
			if(ddType.equalsIgnoreCase("ByText"))
				sele.selectByVisibleText(value);
			else if (ddType.equalsIgnoreCase("ByIndex"))
				sele.selectByIndex(0);
			else if (ddType.equalsIgnoreCase("ByValue"))
				sele.selectByValue(value);
			break;
		case "THREAD_SLEEP":
			// Get text of an element
			Thread.sleep(2000);
			break;
		default:
			break;
		case "VERIFYTEXTISPRESENT":
			boolean textPresent = driver.getPageSource().contains(objectName);
			Assert.assertTrue(textPresent);
			break;
		case "MOUSSEHOVER":
			Actions action = new Actions(driver);
			WebElement element = driver.findElement(this.getObject(p, objectName, objectType));
			action.moveToElement(element);
			break;
		case "SWITCHTOALERT":
			driver.switchTo().alert();
			break;
		case "SWITCHTOFRAME":
			driver.switchTo().frame(driver.findElement(this.getObject(p, objectName, objectType)));
			break;
		case "TEXTNOTPRESENTE":
			boolean text = driver.getPageSource().contains(objectName);
			Assert.assertFalse(text);
			break;
			
		}
	}

	/**
	 * Find element BY using object type and value
	 * 
	 * @param p
	 * @param objectName
	 * @param objectType
	 * @return
	 * @throws Exception  driver.findelement(By.id("bla")).sendkeys();
	 */
	private By getObject(Properties p, String objectName, String objectType) throws Exception {
		// Find by xpath
		if (objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(objectName));
		}
		// find by class
		else if (objectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(p.getProperty(objectName));
		}
		// find by ID
		else if (objectType.equalsIgnoreCase("ID")) {
			return By.id(p.getProperty(objectName));
		}
		// find by name
		else if (objectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(objectName));
		}
		// Find by css
		else if (objectType.equalsIgnoreCase("CSS")) {
			return By.cssSelector(p.getProperty(objectName));
		}
		// find by link
		else if (objectType.equalsIgnoreCase("LINK")) {
			return By.linkText(p.getProperty(objectName));
		}
		// find by partial link
		else if (objectType.equalsIgnoreCase("PARTIALLINK")) {

			return By.partialLinkText(p.getProperty(objectName));

		} else {
			throw new Exception("Wrong object type");
		}
	}

}
