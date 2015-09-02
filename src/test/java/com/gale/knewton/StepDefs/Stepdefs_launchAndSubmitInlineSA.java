	package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchAndSubmitInlineSA extends BaseTest {

	private boolean flag;
	private String product;
	
		
	@When("^I click start for the linked inline Simple Assessment activity$")
	public void i_click_start_for_the_linked_inline_Simple_Assessment_activity() throws Throwable {
		
		Assert.assertTrue("Saved ESC Activity is not displaying on LPN",eBookDocPage.verifySimpleAssessmentOnEbook());
		logPassMessage("Inline Activity is verified on Ebook");
		eBookDocPage.clickInlineSA_Activity();
	}

	@Then("^I am on inline Simple Assessment activity page$")
	public void i_am_on_inline_Simple_Assessment_activity_overview_page() throws Throwable {
		
		flag = simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched();
		if(!flag){
			simpleAssessmentActivityPage.relaunchActivity();
			eBookDocPage.clickInlineSA_Activity();
			flag = simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched();
			}
		Assert.assertTrue("Activity not launched properly", flag);
		logPassMessage("Simple Assessment Activity launched successfully");
	}
	
	// ********************Submit Inline Simple Assessment Activity******************

	@When("^I click Start Activity and submit answer for a Question$")
	public void i_click_Start_Activity_and_submit_answer_for_a_Question() throws Throwable {
		
		simpleAssessmentActivityPage.selectOptionInline();
		logPassMessage("Activity started and one question selected");		
	}
	
	@And("^I click Check My Work button$")
	public void i_click_Check_My_Work_button(){
		simpleAssessmentActivityPage.checkMyWorkInline();
	}
	
	@Then("^Feedback section and Try Another button is displayed$")
	public void feedback_section_and_try_another_button_is_displayed(){
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		Assert.assertTrue("Feedback is not displayed",simpleAssessmentActivityPage.isInlineFeedbackDisplayed());
		logPassMessage("Feedback is displayed");
		if(product.equals("Andersen")){
		Assert.assertTrue("Try Another Version button is not displayed",
				simpleAssessmentActivityPage.isInlineTryAnotherVersionbtnDisplayed());
		logPassMessage("Try Another Version button is displayed");
		}
	}
	
	@And("^I submit inline Simple Assessment activity$")
	public void i_submit_inline_Simple_Assessment_activity() throws Throwable {
		simpleAssessmentActivityPage.clickReviewSubmitInline();
		simpleAssessmentActivityPage.gradeAssignmentButton();
		logPassMessage("Activity submitted Successfully");
	}
	
	@Then("^I am on Ebook Document Page$")
	public void i_am_on_ebook_document_page(){
		
		Assert.assertTrue("Not navigated to Ebook Document Page",eBookDocPage.isUserOnEbookDocumentPage());
		logPassMessage("Successfully navigated to ebook document page");
		eBookDocPage.closeEbook();
		if(PropFileHandler.readProperty("CurrentLogin", 
				YamlReader.getData("propertyfilepath")).equalsIgnoreCase("Instructor"))
		mindTapLPNPage.navigateToBaseLPN();
	}
	
	
	@Then("^I am on Ebook Document Page and continue button appears for activity$")
	public void i_am_on_Ebook_Document_Page_and_continue_button_appears_for_activity(){
		Assert.assertTrue("Not navigated to Ebook Document Page",eBookDocPage.isUserOnEbookDocumentPage());
		logPassMessage("Successfully navigated to ebook document page");
		Assert.assertTrue("Continue button not there on closing inline activity", simpleAssessmentActivityPage.verifyContinueButtonForInlineActivity());
		logPassMessage("Continue button for a non-submitted inline SA activity appears correctly on ebook document page");
	}
	
	
	@And("^I close the inline Simple Assessment activity without submitting it$")
	public void i_close_the_inline_Simple_Assessment_activity_without_submitting_it(){
		simpleAssessmentActivityPage.closeInlineActivityAndSaveState();
		logMessage("Closed inline SA activity and saved the feedback");
	}
	
	@When("^I click continue for the linked inline Simple Assessment activity$")
	public void i_click_continue_for_the_linked_inline_Simple_Assessment_activity(){
		simpleAssessmentActivityPage.continueInlinActivity();
		logMessage("Clicked continue button for inline Simple Assessment Activity");
	}
	@When("^I click takeAgain for the linked inline Simple Assessment activity$")
	public void i_click_takeAgain_for_the_linked_inline_Simple_Assessment_activity(){
		simpleAssessmentActivityPage.takeAgainInlinActivity();
		logMessage("Clicked Take Again button for inline Simple Assessment Activity");
		simpleAssessmentActivityPage.selectOptionInline();
		logPassMessage("Activity started and one question selected");	
	}
	@Then("^I am on Inline Simple Assessment Activity page where I left$")
	public void i_am_on_Inline_Simple_Assessment_Activity_page_where_I_left(){
		Assert.assertTrue("Problems in resuming inline Simple Assessment activity", simpleAssessmentActivityPage.verifyResumeStateForInlineActivity());
		logPassMessage("Inline Simple Assessment activity successfully resumed");
	}
}
