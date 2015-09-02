package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.pageObjects.MindTapLPNPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentTakesESC extends BaseTest{
		
	//#################   Student Takes ESC  ###########
	
	@Then("^I am on Exam Study Center page$")
	public void i_am_on_Exam_Study_Center_page() {
		hardWait(2);
		Assert.assertTrue("ESC activity not displayed at student", escActivity.isESCActivityDisplayedatStud());
		logPassMessage("ESC activity launched successfully at student");
	}
	
	@When("^I click Mastery Report link$")
	public void i_click_Mastery_Report_link(){
		escActivity.clickMasteryReport();   
	}
	
	@Then("^Chapter configured from instructor is displayed$")
	public void chapter_configured_from_instructor_is_displayed() {
		Assert.assertTrue("Chapter at mastery report do not match with configured chapter at Instructor",
				escActivity.verifyChapterNameOnMasteryReport());
		logPassMessage("Chapter in mastery report matches with chapter configured at instructor");
	 }
	
	@Then("^Relevant chapter content is displayed$")
	public void relevant_chapter_content_is_displayed() {
	escActivity.verifyEscContent();
	}
	
	@When("^I click close icon$")
	public void i_click_close_icon() {
		escActivity.closeActivity();
		logPassMessage("activity closed successfully");
	}

	@When("^I click on pre built ESC on LPN$")
	public void i_click_on_pre_linked_ESC_on_LPN(){
		Assert.assertTrue("Pre built ESC is not displayed on LPN",mindTapLPNPage.navigateToPreBuiltESC());
	}
	
}
