package com.qait.Domestic.automation.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractClass {
	
	 WebDriver driver;
	    
	    public AbstractClass(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
		 }
	    
	    // utilities to be used by UI classes

}
