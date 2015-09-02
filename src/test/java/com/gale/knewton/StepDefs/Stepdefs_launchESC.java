package com.gale.knewton.StepDefs;


import org.junit.Assert;

import com.gale.knewton.base.BaseTest;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchESC extends BaseTest {
	
	@When("^I click the already linked ESC activity$")
	public void i_click_the_already_linked_ESC_activity(){
	
	mindTapLPNPage.clickESCActivity();
	}
	
	@Then("^I am on Exam Study Center page and error message displayed as (.*)$")
	public void i_am_on_exam_study_center_page(String Error){
		boolean flag=false;
	   flag = escActivity.isErrorDisplayed(Error);
		System.out.println(flag+"is the value of flag");
		escActivity.closeActivity();
		Assert.assertTrue("Incorrect error message is displayed",flag);
		logPassMessage("Error message is displayed successfully on ESC activity page");
		
	}
}
