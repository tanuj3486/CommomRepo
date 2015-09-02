package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentTakesAssessment extends BaseTest {
		
	@Then("^I am on Student's LPN page$")
	public void i_am_on_students_LPN_page()
	{ mindTapDashboard.showStudentLPN();
		Assert.assertTrue("Student LPN not displayed", mindTapLPNPage.isLPNDisplayedAtStudent());
		logPassMessage("User is on Student's LPN");
	}
	
	@And("^LPN score is displayed on Simple Assessment activity link$")
	public void lpn_score_is_displayed_on_simple_assessment_activity_link()
	{
		
		Assert.assertFalse("lpn score not displayed at Simple Assessment activity link", mindTapLPNPage.getDistinctSimpleAssessmentLpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at Simple Assessment activity link");
		PropFileHandler.writeToFile("SALpnScore", mindTapLPNPage.getDistinctSimpleAssessmentLpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
	}
	
	@And("^LPN score is displayed on SAA activity link$")
	public void lpn_score_is_displayed_on_saa_activity_link()
	{
		
		Assert.assertFalse("lpn score not displayed at SAA activity link", mindTapLPNPage.getSAALpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at SAA activity link");
		PropFileHandler.writeToFile("SAALpnScore", mindTapLPNPage.getSAALpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
	}
	
	@Then("^I see score as Pending on LPN for manually graded activity on LPN$")
	public void I_see_score_as_Pending_on_LPN_for_manually_graded_activity_on_LPN(){
		Assert.assertTrue("Score isn't showed as 'Pending' for manually graded activity", mindTapLPNPage.getManuallyGradableVideoActivityScore().equals("Pending"));
	}
	
	
	@Then("^I am on Activity Information Page$")
	public void I_am_on_Activity_Information_Page(){
		manuallyGradableActivityPage.verifyActivityInfoPage();
	}
	
	@When("^I click On Review button$")
	public void I_Click_Activity_Information_Page(){
		manuallyGradableActivityPage.navigateToEditGradeDetailsPage();
	}
	
	@Then("^I reach Manual Grading widget successfully$")
	public void I_reach_Edit_Grade_Details_Page_successfully(){
		manuallyGradableActivityPage.verifyStudentIsOnManulGradeWidgetPage(YamlReader.getYamlValue("WarningMessageOnEditGradeDetails"));
		logPassMessage("Manual Grading Widget is successfully opened");
	
	}
	

	@Then("^correct score for manually graded activity should be displayed on LPN$")
	public void correct_score_for_manually_graded_activity_should_be_displayed_on_LPN(){
		Assert.assertTrue("Socre verification on LPN for manually gradable activity failed!!!",mindTapLPNPage.verifyGeneratedScoreForManualGradingActivityOnLPN());
		logPassMessage("Score on LPN for manually gradable activity is correctly displayed on LPN");
	}
	
	@When("^I click Start button on Assessment Information page$")
	public void i_click_Start_button_on_Assessment_Information_page(){
		saaActivity.clickStartOnAssessmentActivityInfoPage();
	}
	

	
}
