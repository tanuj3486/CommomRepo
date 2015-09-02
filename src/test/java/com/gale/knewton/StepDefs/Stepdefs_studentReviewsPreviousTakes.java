package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentReviewsPreviousTakes extends BaseTest {

	
//******************______Student_Reviews_previous_Simple_Assessment_Take______***************************** 

	@Given("^Attempted Simple Assessment activity is present on LPN$")
	public void attempted_Simple_Assessment_activity_is_present_on_LPN() {
	   Assert.assertTrue("Distinct Simple Assessment activity not attempted", mindTapLPNPage.isDistinctSAattempted());
	   logPassMessage("Attempted distinct Simple Assessment activity is present on LPN ");
	}

	@When("^I click on attempted Simple Assessment activity$")
	public void i_click_on_attempted_Simple_Assessment_activity() {
		
		mindTapLPNPage.clickDistinctSimpleAssessment_Activity();	   
	}
	
	@When("^I click on attempted Simple Assessment activity for review$")
	public void i_click_on_attempted_Simple_Assessment_activity_for_review() {
		
		mindTapLPNPage.refeshPageBeforeReview();
		 mindTapDashboard.showStudentLPN();
		mindTapLPNPage.clickDistinctSimpleAssessment_Activity();	   
	}
	
	//

	@Then("^I am on Assessment Activity Information page$")
	public void i_am_on_Assessment_Activity_Information_page() {
	   Assert.assertTrue("Assessment Activity Information page not displayed", 
			   activityInfo.isUserOnAssessmentActivityPage());
	   logPassMessage("Assessment Activity Information page launched successfully");
	}

	@Then("^Recorded Score is displayed same as score on LPN's Simple Assessment activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_s_activity_link() {
	  String SALpnScore = PropFileHandler.readProperty("SALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", SALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}

	@Then("^Review button is displayed$")
	public void review_button_is_displayed() {
		Assert.assertTrue("Review button not displayed", activityInfo.isReviewButtonDisplayed());
	    logPassMessage("Review button displayed successfully");
	}

	@When("^I click on Review button$")
	public void i_click_on_Review_button() {
	    activityInfo.clickReviewButton();
	}

	@Then("^Attempted Simple Assessment activity is displayed$")
	public void attempted_activity_is_displayed() {
		Assert.assertTrue("Attempted Simple Assessment activity not displayed", simpleAssessmentActivityPage.isFeedbackDisplayed());
		logPassMessage("Attempted Simple Assessment activity displayed successfully");
	   }
	

	//******************______Student_Reviews_previous_SAA_Take______***************************** 
	
	@Given("^Attempted SAA activity is present on LPN$")
	public void attempted_SAA_activity_is_present_on_LPN() {
	   Assert.assertTrue("Distinct Simple Assessment activity not attempted", mindTapLPNPage.isSAAattempted());
	   logPassMessage("Attempted distinct Simple Assessment activity is present on LPN ");
	}
	
	@Then("^Recorded Score is displayed same as score on LPN's SAA activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_saa_activity_link() {
	  String SAALpnScore = PropFileHandler.readProperty("SAALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", SAALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}
	
	@When("^I click on attempted SAA activity$")
	public void i_click_on_attempted_SAA_activity() {
		mindTapLPNPage.clickAttemptedSAAactivity();	   
	}
	
	@Then("^Attempted SAA activity is displayed$")
	public void attempted_SAA_activity_is_displayed() {
		Assert.assertTrue("Attempted SAA activity not displayed", saaActivity.isAttemptedSAADisplayed());
		logPassMessage("Attempted SAA activity displayed successfully");
		saaActivity.closeSAAactivity();
	   }
	
//******************______Student_Reviews_previous_Inline_Simple_Assessment_Take______***************************** 		

	@Given("^Attempted Inline Simple Assessment activity is present on LPN$")
	public void attempted_inline_simple_assessment_activity_is_present_on_LPN() {
	   Assert.assertTrue("Inline Simple Assessment activity not attempted", mindTapLPNPage.isInlineSAattempted());
	   logPassMessage("Attempted Inline Simple Assessment activity is present on Chapter LPN ");
	   PropFileHandler.writeToFile("LpnScore",mindTapLPNPage.getInlineSimpleAssessmentLpnScore(), 
			   (YamlReader.getData("propertyfilepath")));
	}
	
	@Then("^Recorded Score is displayed same as score on LPN's Inline Simple Assessment activity link$")
	public void recorded_Score_is_displayed_same_as_score_on_LPN_inline_activity_link() {
	  String InlineSALpnScore = PropFileHandler.readProperty("InlineSALpnScore", (YamlReader.getData("propertyfilepath")));
	  Assert.assertEquals("Recorded Score is not same as LPN score", InlineSALpnScore, activityInfo.getRecordedScore());
	  logPassMessage("Recorded score equals LPN score");
	}
	
	@When("^I click on attempted Inline Simple Assessment activity$")
	public void i_click_on_attempted_inline_simple_assessment_activity() {
		mindTapLPNPage.clickAttemptedInlineSAactivity();	
	}
	@When("^I click on score of attemped inline activity$")
	public void I_click_on_score_Of_Attemped_Inline_Activity() {
		mindTapLPNPage.clickScoreOfAttemptedInlineSAactivity();
	}
	@Then("^I click on view button for inline assessment$")
	public void I_Click_On_View_Button_For_Inline_Assessment()
	{
		mindTapLPNPage.clickViewButtonforInlineAssessment();
	}
	@Then("^Attempted Inline Simple Assessment activity is displayed$")
	public void attempted_inline_simple_assessment_activity_is_displayed() {
		Assert.assertTrue("Attempted Inline Simple Assessment activity not displayed", simpleAssessmentActivityPage.isInlineActivityDisplayed());
		logPassMessage("Attempted Inline Simple Assessment activity displayed successfully");
		simpleAssessmentActivityPage.closeSAActivity();
		eBookDocPage.closeEbook();
		mindTapLPNPage.navigateToBaseLPN();
		
	   }
	@Then("^verify take again button is available$")
	public void verify_Take_Again_Button_Is_Available()
	{
		mindTapLPNPage.verifyTakeAgainButtonForInlineAssessment();
	}
	@Given("^Attempted Inline Simple Assessment activity is present on LPN at instructor end$")
	public void attempted_inline_simple_assessment_activity_is_present_on_LPN_at_instructor_end() {
	   Assert.assertTrue("Inline Simple Assessment activity not attempted", mindTapLPNPage.isInlineSAattemptedAtInstructorEnd());
	   logPassMessage("Attempted Inline Simple Assessment activity is present on Chapter LPN ");
	   PropFileHandler.writeToFile("InlineSALpnScore",mindTapLPNPage.getInlineSimpleAssessmentLpnScoreAtInstEnd(), 
			   (YamlReader.getData("propertyfilepath")));
	}
    @When("^I navigate to base LPN$")
   public void And_I_navigate_to_base_LPN()
{
    	mindTapLPNPage.navigateToBaseLPN();
}
	
	@Then("^navigate to base LPN$")
	public void navigate_to_base_lpn()
	{
		mindTapLPNPage.navigateToBaseLPN();
	}
}
