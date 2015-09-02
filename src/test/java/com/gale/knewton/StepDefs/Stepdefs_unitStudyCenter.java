package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;



import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_unitStudyCenter extends BaseTest {

	private String nameOfUnitClickedOnLPN = null;
	
	@When("^I navigate to a chapter from LPN$")
	public void i_navigate_to_a_chapter_from_LPN() {
		nameOfUnitClickedOnLPN = mindTapLPNPage.navigateToChapterLPN();
		logPassMessage("Navigated to course LPN");
	}
	
	@Then("^Unit Exam Center link should be present$")
	public void unit_Exam_Center_link_should_be_present() {
	   Assert.assertTrue("Unit Study Center link not displayed", mindTapLPNPage.isUSCLinkDisplayed(nameOfUnitClickedOnLPN));
	   logPassMessage("Unity Study Center link displayed successfully");
	  // mindtapLPN.navigateToBaseLPN();
	}
	
}
