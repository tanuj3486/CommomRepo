/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation.getpageobjects;

import static com.qait.automation.getpageobjects.ObjectFileReader.getPageTitleFromFile;
import static com.qait.automation.utils.DataReadWrite.getProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Reporter.log;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import com.qait.automation.utils.PropFileHandler;
import com.qait.automation.utils.SeleniumWait;

/**
 * 
 * @author QAIT
 */
public class BaseUi {

	WebDriver driver;
	protected SeleniumWait wait;
	private String pageName;
	String window;
	
	protected BaseUi(WebDriver driver, String pageName) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.pageName = pageName;
		this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty(
				"Config.properties", "timeout")));
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void verifyPageTitleExact() {
		String pagetitle = getPageTitleFromFile(pageName);
		assertEquals(getPageTitle(), pagetitle,
				"Verifying Page title to validate right " + pageName + " - ");
		log("Assertion Passed: PageTitle for " + pageName + " is exactly: '"
				+ pagetitle + "'.");
	}

	public void verifyPageTitleExact(String pagetitle) {
		wait.waitForPageToLoadCompletely();
		wait.waitForPageTitleToContain(pagetitle);
		assertEquals(getPageTitle(), pagetitle,
				"Verifying Page title to validate right " + pagetitle + " - ");
		log("Assertion Passed: PageTitle for " + pagetitle + " is exactly: '"
				+ pagetitle + "'.");
		logMessage("User is on " + pagetitle + "Page");
	}

	public void verifyPageTitleContains() {
		String expectedPagetitle = getPageTitleFromFile(pageName).trim();
		wait.waitForPageTitleToContain(expectedPagetitle);
		String actualPageTitle = getPageTitle().trim();
		assertTrue(actualPageTitle.contains(expectedPagetitle),
				"Verifying Actuals Page Title: '" + actualPageTitle
						+ "' contains expected Page Title : '"
						+ expectedPagetitle + "'.");
		log("Assertion Passed: PageTitle for " + actualPageTitle
				+ " contains: '" + expectedPagetitle + "'.");
	}

	public void clickByJavaScriptUsingXpath(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",
				element);
	}

	protected WebElement getElementByIndex(List<WebElement> elementlist,
			int index) {
		return elementlist.get(index);
	}

	protected WebElement getElementByExactText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list
		if (element == null) {
		}
		return element;
	}

	protected WebElement getElementByContainsText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().contains(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list
		if (element == null) {
		}
		return element;
	}

	public void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		} catch (StaleElementReferenceException ex1) {
			driver.switchTo().frame(element);
		}
	}

	public void switchToDefaultContent() {
		hardWait(1);
		driver.switchTo().defaultContent();
	}

	protected void executeJavascript(String script) {
		hardWait(1);
		((JavascriptExecutor) driver).executeScript(script);
		hardWait(1);
	}
	
	protected String executeJavascriptThatReturnValue(String script) {
		String value = (String)((JavascriptExecutor) driver).executeScript(script);
		return value;
	}

	protected void executeJavascript(String script, WebElement element) {
		((JavascriptExecutor) driver).executeScript(script, element);
	}

	protected Actions action() {
		Actions hoverOver = new Actions(driver);
		return hoverOver;
	}

	protected void handleAlert() {
		try {
			switchToAlert().accept();
			logMessage("Alert is Handled");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			logMessage("Alert did not come");
		}
	}

	public Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public String getAlertText(){
		Alert alert =switchToAlert();
		return alert.getText();
	}

	public void switchWindow() {
		Robot robo;
		try {
			robo = new Robot();
			robo.keyPress(KeyEvent.VK_ALT);
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_ALT);
			robo.keyRelease(KeyEvent.VK_TAB);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void changeWindow(int i) {
		//String currentWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		if (i > 0) {
			for (int j = 0; j < 5; j++) {
				if (windows.size() < 2) {
					try {
						Thread.sleep(2000);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				} else {
					break;
				}
			}
			windows = driver.getWindowHandles();
		}
		String wins[] = windows.toArray(new String[windows.size()]);
		String browser = getProperty("./Config.properties", "browser");
		if (browser.equalsIgnoreCase("ie")
				|| browser.equalsIgnoreCase("internetexplorer")
				|| browser.equalsIgnoreCase("internet explorer")) {
			driver.switchTo().window(wins[i]);
			driver.switchTo().window(wins[i]);
			driver.switchTo().window(wins[i]);
			//switch three time for browser ie
		} else
			driver.switchTo().window(wins[i]);

		while (driver.getTitle().equalsIgnoreCase("about:blank")
				|| driver.getTitle().equalsIgnoreCase("")) {
			hardWait(2);
		}
		driver.manage().window().maximize();
	}
	
	/*
	 * public void selectDropDownValue(WebElement ele,String value) {
	 * //select/option[text()='hghjghgh']
	 * 
	 * }
	 */
	public void hardWait(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public void closeWindow() {
		driver.close();
	}

	public void clearCookies() {
		driver.manage().deleteAllCookies();
	}

	public void selectProvidedTextFromDropDown(WebElement el, String text) {
		Select sel = new Select(el);
		sel.selectByVisibleText(text);
	}
	
	public List<WebElement> getAllOptionOFDropDown(WebElement el){
		Select sel = new Select(el);
		return sel.getOptions();
	}
	
	public String getSelectedValueFromDropdown(WebElement el){
		Select sel = new Select(el);
		return sel.getFirstSelectedOption().getText();
	}
	
	public void hoverOverElement(WebElement ele) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(ele).build().perform();
	}

	protected void clickUsingActionScript(WebElement e){
		Actions element = new Actions(driver);
		element.click().perform();
	}
	
	protected void logMessage(String message) {
		Reporter.log(message, true);
	}

	public void scrollDown(WebElement el) {
		try {

			Thread.sleep(100);
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView(true);", el);
			Thread.sleep(100);
		}

		catch (Exception e) {
			System.out.println("catch exception in scrolling to element " + el);
		}
	}

	public void enterText(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	public void click(WebElement element){
		try{
			wait.waitForElementToBeClickable(element);
			element.click();
		}catch(StaleElementReferenceException e){
			element.click();
		}
	}
	
	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void selectsec(WebElement el, int i) {
		Select sel = new Select(el);
		sel.selectByIndex(i);

	}

	public void verifyText(WebElement element, String text) {
		String expectedText = element.getText();
		Assert.assertEquals(expectedText, text,
				"Assertion Failed : Text does't Match");
		logMessage("Assertion Passed : " + text + " is correct");
	}

	public void waitForLoaderToDisappear(){
		wait.waitForLoaderToDisappear();
	}
	
	public void waitForProcessingMessageToDisappear(){
		wait.waitForProcessingMessageToDisappear();
	}
	
	public void saveCourseInDataFile(String propertyName, String propertyValue){
		PropFileHandler.writeToFile(propertyName, propertyValue);
	}
	
}