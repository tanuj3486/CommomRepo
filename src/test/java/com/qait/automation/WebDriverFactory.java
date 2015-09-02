/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

public class WebDriverFactory {
	 private static String browser;
	 private static String driverPath;
	    private static DesiredCapabilities capabilities = new DesiredCapabilities();

	    public WebDriver getDriver(Map<String, String> seleniumconfig) {
	    	browser = System.getProperty("browser");
	    	//driverPath = seleniumconfig.get("driverpath");
	    	if (browser == null)
				browser = seleniumconfig.get("browser").toString();
	       
	        if (seleniumconfig.get("seleniumserver").toString().equalsIgnoreCase("local")) {
	            if (browser.equalsIgnoreCase("firefox")) {
	                return getFirefoxDriver();
	            } else if (browser.equalsIgnoreCase("chrome")) {  
	            	driverPath = seleniumconfig.get("driverpathchrome");
	                return getChromeDriver(driverPath);
	            } else if (browser.equalsIgnoreCase("Safari")) {
	                return getSafariDriver();
	            } else if ((browser.equalsIgnoreCase("ie"))
	                    || (browser.equalsIgnoreCase("internetexplorer"))
	                    || (browser.equalsIgnoreCase("internet explorer"))) {
	            	driverPath = seleniumconfig.get("driverpathie");
	                return getInternetExplorerDriver(driverPath);
	            }
	        }
	        if (seleniumconfig.get("seleniumserver").toString().equalsIgnoreCase("remote")) {
	            return setRemoteDriver(seleniumconfig);
	        }
	        Reporter.log("Test Browser is : "+ browser);
	        return new FirefoxDriver();
	    }

	    private WebDriver setRemoteDriver(Map<String, String> selConfig) {
	        DesiredCapabilities cap = null;
	        browser = selConfig.get("browser").toString();
	        if (browser.equalsIgnoreCase("firefox")) {
	            cap = DesiredCapabilities.firefox();
	        } else if (browser.equalsIgnoreCase("chrome")) {
	            cap = DesiredCapabilities.chrome();
	        } else if (browser.equalsIgnoreCase("Safari")) {
	            cap = DesiredCapabilities.safari();
	        } else if ((browser.equalsIgnoreCase("ie"))
	                || (browser.equalsIgnoreCase("internetexplorer"))
	                || (browser.equalsIgnoreCase("internet explorer"))) {
	            cap = DesiredCapabilities.internetExplorer();
	        }
	        String seleniuhubaddress = selConfig.get("seleniumserverhost");
	        URL selserverhost = null;
	        try {
	            selserverhost = new URL(seleniuhubaddress);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	        cap.setJavascriptEnabled(true);
	        RemoteWebDriver driver = new RemoteWebDriver(selserverhost, cap);
	        driver.setFileDetector(new LocalFileDetector());
	        return driver;
	    }

	    private static WebDriver getChromeDriver(String driverPath){
	    	System.out.println("os name : "+System.getProperty("os.name"));
	    	System.out.println("os arch : "+System.getProperty("os.arch"));
	    	if(System.getProperty("os.name").toUpperCase().equals("LINUX")){
	    		System.out.println("Under linux");
	    		System.setProperty("webdriver.chrome.driver", driverPath);
   			}
   			else System.setProperty("webdriver.chrome.driver", driverPath+".exe");
	    	ChromeOptions options = new ChromeOptions();
	        options.addArguments("test-type");
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        capabilities.setJavascriptEnabled(true);
			return new ChromeDriver(capabilities);
	    }

	    private static WebDriver getInternetExplorerDriver(String driverPath) {
	        System.setProperty("webdriver.ie.driver", driverPath);
	        capabilities.setJavascriptEnabled(true);
	        return new InternetExplorerDriver(capabilities);
	    }

	    private static WebDriver getSafariDriver() {
	        return new SafariDriver();
	    }

	    private static WebDriver getFirefoxDriver() {
	        FirefoxProfile profile = new FirefoxProfile();
	        profile.setPreference("browser.cache.disk.enable", false);
	        return new FirefoxDriver(profile);
	    }
}