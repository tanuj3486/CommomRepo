package com.qait.gateway.domestic.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qait.automation.TestSessionInitiator;

public class Enroll_Student_In_HighSchool_Using_FullPayment {

	String appURL ;
	
	TestSessionInitiator test;
	
	@BeforeClass
	public void startSession(){
		test = new TestSessionInitiator();
		
	}
	
	@AfterClass
	public void closeSession(){
		test.closeBrowserSession();
		
	}
	
	@Test
	public void Step01_User_Launches_Application(){
		test.launchApplication(applicationpath);
	}
	
	@Test
	public void Step02_User_Clicks_On_Enroll_Links_ANd_Navigate_To_Enroll_ProductPage(){
		
	}
	
	@Test
	public void 
	
	@BeforeTest
	public void stepName(){
		
		
	}
	
	@AfterTest
	public void takeScreenShot(){
		
	}
}
