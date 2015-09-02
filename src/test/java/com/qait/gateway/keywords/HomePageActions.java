package com.qait.gateway.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class HomePageActions extends GetPage {
	
	public HomePageActions(WebDriver driver) {
		super(driver, "HomePage");
	}

	/**
	 * Method verify the page title of home page  and PennFoster logo 
	 */
	public void verifyUserIsOnHomePage(){
		verifyPageTitleContains();
		isElementDisplayed("img_logo");
	}
	
	/**
	 * Click on Enroll Page 
	 */
	public EnrollPageActions clickOnEnrollLink(){
		click(element("lnk_enrollNow"));
		return new EnrollPageActions(driver);
	}
	
	/**
	 * Click on get InfoPage 
	 */
	public void clickOnGetInfoLink(){
		click(element(""));
	}
	
}
