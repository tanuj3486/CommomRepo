package com.qait.automation.getpageobjects;

import static com.qait.automation.getpageobjects.ObjectFileReader.getELementFromFile;
import static org.testng.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GetPage extends BaseUi {

	protected WebDriver driver;
	String pageName;
	// protected static JSONReadWrite json = JSONReadWrite.getInstance();
	String version;

	public GetPage(WebDriver driver, String pageName) {
		super(driver, pageName);
		this.driver = driver;
		this.pageName = pageName;
	}

	// TODO: put this in right place, create dedicated class for frame and
	// window handlers
	protected void switchToNestedFrames(String frameNames) {
		switchToDefaultContent();
		String[] frameIdentifiers = frameNames.split(":");
		for (String frameId : frameIdentifiers) {
			wait.waitForFrameToBeAvailableAndSwitchToIt(getLocator(frameId
					.trim()));
		}
	}

	

	protected WebElement element(String elementToken) {
		return wait.waitForElementToBeVisible(driver
				.findElement(getLocator(elementToken)));
	}
	
	protected WebElement elementWithoutWait(String elementToken){
		return driver.findElement(getLocator(elementToken));
	}

	protected void waitForElementToBeVisible(WebElement elementToken) {
		try {
			wait.waitForElementToBeVisible(elementToken);
		} catch (Exception e) {
			logMessage(elementToken + " is not visible with in specific time");
		}
	}

	protected void waitForElementToInvisible(String elementToken) {
		try{
		wait.waitForElementToBeInVisible(getLocator(elementToken));
		}catch(Exception e)
		{
			
		}
	}

	protected WebElement element(String elementToken, String replacement) {
		return wait.waitForElementToBeVisible(driver.findElement(getLocator(
				elementToken, replacement)));
	}

	protected WebElement waitForElementToBeClickable(WebElement element) {
		return wait.waitForElementToBeClickable(element);
	}

	protected List<WebElement> elements(String elementToken, String replacement) {
		return driver.findElements(getLocator(
				elementToken, replacement));
	}

	protected List<WebElement> elements(String elementToken) {
		String[] locator = getELementFromFile(this.pageName, elementToken);
		return driver.findElements(getLocators(locator[1].trim(),
				locator[2].trim()));
	}

	protected boolean isElementDisplayed(String elementName,
			String elementTextReplace) {
		wait.waitForElementToBeVisible(element(elementName, elementTextReplace));
		boolean result = element(elementName, elementTextReplace).isDisplayed();
		assertTrue(result, "Assertion Failed: element '" + elementName
				+ "with text " + elementTextReplace + "' is not displayed.");
		logMessage("Assertion Passed: element " + elementName + " with text "
				+ elementTextReplace + " is displayed.");
		return result;
	}

	protected boolean isElementDisplayed(String elementName) {
		wait.waitForPageToLoadCompletely();
		wait.waitForElementToBeVisible(element(elementName));
		boolean result = element(elementName).isDisplayed();
		assertTrue(result, "Assertion Failed: element '" + elementName
				+ "' is not displayed.");
		logMessage("Assertion Passed : " + elementName + " is displayed");
		return result;
	}

	protected void isElementNotDisplayed(String elementName) {
		 wait.resetImplicitTimeout(5);
		  Boolean status = false;
		  try {
			  status = element(elementName).isDisplayed();
			  Assert.assertFalse(status,"Assertion Failed : Element is displayed");
		  } catch (NoSuchElementException e) {
		   logMessage("Assertion Passed : Element "+elementName+" is not displayed ");
		  }
		  finally{
		  wait.resetImplicitTimeout(wait.timeout);
		  }
		
	}

	protected void isElementNotDisplayed(String elementName, String replacement) {
		  wait.resetImplicitTimeout(5);
		  Boolean status = false;
		  try {
			  status = element(elementName, replacement).isDisplayed();
			  Assert.assertFalse(status,"Assertion Failed : Element is displayed");
		  } catch (NoSuchElementException e) {
		   logMessage("Assertion Passed : Element "+elementName+" is not displayed ");
		  }
		  finally{
		  wait.resetImplicitTimeout(wait.timeout);
		  }
	}
	
	protected void verifyElementText(WebElement element, String expectedValue) {
		String actualValue = element.getText().trim();
		Assert.assertEquals(actualValue, expectedValue,
				"Assetion Failed : Value does't match");
		logMessage("Assertion Passed : " + actualValue + "is equals to "
				+ expectedValue);
	}

	protected By getLocator(String elementToken) {
		String[] locator = getELementFromFile(this.pageName, elementToken);
		return getLocators(locator[1].trim(), locator[2].trim());
	}

	protected By getLocator(String elementToken, String replacement) {
		String[] locator = getELementFromFile(this.pageName, elementToken);
		locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
		return getLocators(locator[1].trim(), locator[2].trim());
	}

	// TODO rename to distiguish between getlocator and getlocators
	private By getLocators(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

	protected void sendKeys(WebElement element, String text) {
		JavascriptExecutor executor = (JavascriptExecutor) this.driver;
		executor.executeScript("arguments[0].value='" + text + "';", element);
	}

	public void writeTextFile() {
		File file = null;
		try {
			file = new File("src" + File.separator + "test" + File.separator
					+ "resources" + File.separator + "testdata"
					+ File.separator + "files" + File.separator
					+ "importText.txt");

			String text = "fname,lname,uname,psswd";
			long start = System.currentTimeMillis();
			String username = "stud" + start + "@sam.com";
			String text1 = "first,last," + username + ",password";
			// json.writeIntoJsonFile(getVersion()+".importUser",username);
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.newLine();
			bw.write(text1);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public void writeUserEmailIntoJsonFileBasedOnRole(String UserRole,String
	 * email) { if (UserRole.equalsIgnoreCase("administrator"))
	 * json.writeIntoJsonFile(getVersion()+".administratoremail", email); else
	 * if (UserRole.equalsIgnoreCase("instructor"))
	 * json.writeIntoJsonFile(getVersion()+".instructoremail", email); else if
	 * (UserRole.equalsIgnoreCase("student"))
	 * json.writeIntoJsonFile(getVersion()+".studentemail", email);
	 * 
	 * }
	 */

	/*
	 * public String readUserEmailFromJsonFileBasedOnRole(String UserRole) { if
	 * (UserRole.equalsIgnoreCase("administrator")){
	 * System.out.println("email while login="
	 * +json.readFromJson(getVersion()+".administratoremail")); return
	 * json.readFromJson(getVersion()+".administratoremail"); } else if
	 * (UserRole.equalsIgnoreCase("import_user")) return
	 * json.readFromJson(getVersion()+".importUser"); else if
	 * (UserRole.equalsIgnoreCase("instructor")) return
	 * json.readFromJson(getVersion()+".instructoremail"); else if
	 * (UserRole.equalsIgnoreCase("student")) return
	 * json.readFromJson(getVersion()+".studentemail"); return ""; }
	 */

}