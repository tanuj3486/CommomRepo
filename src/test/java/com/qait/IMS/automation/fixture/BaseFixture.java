package com.qait.IMS.automation.fixture;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.WebDriver;

import com.qait.IMS.automation.pageobjects.EOLEnrollNow_nocourse_UI;
import com.qait.IMS.automation.pageobjects.EOLIMSReceiveInfo_nocourse_UI;

import com.qait.Domestic.automation.util.Utilities;


public class BaseFixture {
	
	public WebDriver driver;
	public DesiredCapabilities capabilities;
	
	
	

	EOLEnrollNow_nocourse_UI IMSEnrollNowNoCourse;
	EOLIMSReceiveInfo_nocourse_UI PanFoster;
	
	public void startBrowserSession()
	{
		capabilities = new DesiredCapabilities();
	    capabilities.setJavascriptEnabled(true);
	    if (getYamlVal("browser").equalsIgnoreCase("firefox")) {
		capabilities.setBrowserName("firefox");
		driver = new FirefoxDriver();
		}else if (getYamlVal("browser").equalsIgnoreCase("iexplore")){
			File file = new File("IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setJavascriptEnabled(true);
            Utilities.hardWait(5);
            driver = new InternetExplorerDriver(dc);
            
            Utilities.hardWait(5);

		} else if (getYamlVal("browser").equalsIgnoreCase("chrome")){
			capabilities.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver",
	                "chromedriver.exe");
			driver = new ChromeDriver();
		}
		int ajax_timeout = Integer.parseInt(getYamlVal("ajax_timeout"));
        driver.manage().timeouts().implicitlyWait(ajax_timeout, TimeUnit.SECONDS);
        initPageObjects();
        driver.manage().window().maximize();

	}
	
	public void initPageObjects() {	

		IMSEnrollNowNoCourse = new EOLEnrollNow_nocourse_UI(driver);
		PanFoster = new EOLIMSReceiveInfo_nocourse_UI(driver);
	}
	
	public void launchUrl(String url)
	{
		driver.get(url);
		
	}
	
	public void stopBrowserSession() {
        driver.quit();
	}
	
	
	
	public void setUpDataFile(String dataFilePath) {
        Utilities.setYamlFilePath(dataFilePath);
    }
	
	public String getYamlVal(String yamlMapObj) {
        return Utilities.getYamlValue(yamlMapObj);
    }

}
