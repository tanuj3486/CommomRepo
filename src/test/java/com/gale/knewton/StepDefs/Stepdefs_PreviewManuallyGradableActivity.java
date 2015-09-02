	package com.gale.knewton.StepDefs;

import org.junit.Assert;



import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_PreviewManuallyGradableActivity extends BaseTest {
	
	
		
	@When("^I click the already linked Manually Gradable video activity$")
	public void i_click_start_for_the_linked_inline_Simple_Assessment_activity() throws Throwable {
		hardWait(1);
		mindTapLPNPage.clickManuallyGradableVideo_Activity();
	}

	@Then("^I am on Manually Gradable video activity page$")
	public void i_am_on_inline_Simple_Assessment_activity_overview_page() {
		
		Assert.assertTrue("Manually Gradable activity didn't launch from LPN!!!", manuallyGradableActivityPage.isVideoActivityOpened());
		logPassMessage("Manually gradable video activity launched successfully from LPN");
	}
	
	@When("^I provide response in video activity textbox and move to review and submit tab$")
	public void I_provide_respons_in_video_activity_textbox_and_move_to_review_and_submit_tab() {
		Assert.assertTrue("Clicking next button on video activity doesn't take user to Review and Submit tab", manuallyGradableActivityPage.provideResponseInVideoActivityAndMoveGradingScreen(YamlReader.getYamlValue("videoActivityTextContent")));
		logMessage("Filled response for video activity and moved to review and submit page successfully");
	}
	
	@Then("^I should see correct message for manual grading activity$")
	public void I_should_see_correct_message_for_manual_grading_activity() {
		Assert.assertTrue("Manually Gradable activity didn't show up correct grading message !!!", manuallyGradableActivityPage.verifyGradingMessage(YamlReader.getYamlValue("manuallyGradableActivityMessage")));
		logPassMessage("Manually gradable video activity displays correct message on activity sbumit page");
	}
	
	@And("^I submit Video Activity for grading$")
	public void I_submit_Video_Activity_for_grading() {
		manuallyGradableActivityPage.submitVideoActivity();
		logMessage("Manually gradable video activity submitted...");
	}
	
	@And("^I click on close activity$")
	public void I_click_on_close_activity() {
     manuallyGradableActivityPage.closeSAActivity();

	}
	
	@Then("^I navigate to page and grades activity$")
	public void I_click_on_activity() {
		  manuallyGradableActivityPage.clickStudentName();
     manuallyGradableActivityPage.clickOnGradableActivity();
   manuallyGradableActivityPage.clickViewButtonForGrading();
manuallyGradableActivityPage.instructorGradesActivity(PropFileHandler.readProperty("gradingScore",
		(YamlReader.getData("propertyfilepath"))), 
				YamlReader.getYamlValue("Comment"));
}
}
