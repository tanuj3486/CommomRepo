package com.qait.gateway.keywords;

import org.openqa.selenium.WebDriver;

import com.qait.automation.getpageobjects.GetPage;

public class EnrollPageActions extends GetPage {

	private String pageTitle = "Penn Foster - Enroll";
	
	public EnrollPageActions(WebDriver driver) {
		super(driver, "");
	}

	public void verifyUserIsOnEnrollPage(){
		verifyPageTitleContains();
	}
	
	
}
