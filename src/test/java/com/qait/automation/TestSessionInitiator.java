/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation;

import static com.qait.automation.utils.DataReadWrite.getProperty;
import static com.qait.automation.utils.YamlReader.getYamlValue;
import static com.qait.automation.utils.YamlReader.setYamlFilePath;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;

import com.qait.automation.utils.CustomFunctions;
import com.qait.gateway.keywords.EnrollPageActions;
import com.qait.gateway.keywords.HomePageActions;

/**
 * 
 * @author Samnoon Afaq
 */
public class TestSessionInitiator {

	public CustomFunctions customFunctions;
	protected WebDriver driver;
	String browser;
	private WebDriverFactory wdfactory;
	static int timeout;
	DesiredCapabilities capabilities;
	public EnrollPageActions enrollpage;
	public HomePageActions homepage;
	
	
	private void _initPage() {
		homepage = new HomePageActions(driver);
		}
	
	 public TestSessionInitiator() {
		wdfactory = new WebDriverFactory();
		setYamlFilePath();
		_configureBrowser();
		_initPage();
	}
	 
	 private void _configureBrowser() {
			driver = wdfactory.getDriver(_getSessionConfig());
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage()
					.timeouts()
					.implicitlyWait(
							Integer.parseInt(_getSessionConfig().get("timeout")),
							TimeUnit.SECONDS);
		}
		
	 private Map<String, String> _getSessionConfig() {
			String[] configKeys = { "tier", "browser", "seleniumserver",
					"seleniumserverhost", "timeout","driverpathchrome","driverpathie"};
			Map<String, String> config = new HashMap<String, String>();
			for (String string : configKeys) {
				config.put(string, getProperty("./Config.properties", string));
			}
			return config;
		}
		
		public String getEnv(){
			String tier = System.getProperty("env");
			if (tier == null)
				tier = _getSessionConfig().get("tier");
			return tier;
		}
		
		public String getBrowser() {
			String browser = System.getProperty("browser");
			if (browser == null)
				browser = _getSessionConfig().get("browser");
			return browser;
		}
		
		public void launchApplication(String applicationpath) {
			Reporter.log("The application url is :- " + applicationpath, true);
			Reporter.log(
					"The test browser is :- " + _getSessionConfig().get("browser"),
					true);
			driver.get(applicationpath);
		}
	
		public void getURL(String url) {
			driver.manage().deleteAllCookies();
			driver.get(url);
		}
		
		public void stepStartMessage(String testStepName){
			Reporter.log(" ", true);
			Reporter.log("***** STARTING TEST STEP:- " + testStepName.toUpperCase() + " *****", true);
			Reporter.log(" ", true);
		}
		
		 public String getCurrentURL(){
		    	return driver.getCurrentUrl();
		    }
	
		public void launchApplication() {
		        launchApplication(getYamlValue("baseurl"));
		    }
	
		public void closeBrowserSession(){
			driver.quit();
		}
		
		public void closeBrowserWindow(){
			driver.close();
			Reporter.log("User Close browser");
		}
	
}