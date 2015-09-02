package com.gale.knewton.StepDefs;

import java.io.IOException;

import javax.activity.ActivityRequiredException;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_assessment extends BaseTest {
	
	

	@Then("^Creation type display as \"(.*?)\"$")
	public void verify_the_creation_type_as(String actType) {
		Assert.assertTrue("Creation type '"+actType+"' is not displayed", 
				addActivityPage.verifySACreationTypeForAssessmentActivity().equals(actType));
		logPassMessage(actType + " is displaying as creation type for Assessment");		

	}
	
	@Given("^Creation type displayed as \"(.*?)\"$")
	public void creation_type_displayed_as(String activity){
	   Assert.assertTrue("Creation type '"+activity+"' is not displayed", 
			   addActivityPage.verifySAACreationTypeForGDA().equals(activity));
	   logMessage(activity+" is displayed successfully as creation type for Assessment");
	}
	
	//****************Link SAA Distinct Activity*****************
	

	@When("^I select SAA as creation type$")
	public void i_select_SAA_as_creation_type(){
		addActivityPage.selectSAA();
	}
	
	@When("^I publish first SAA activity$")
	public void i_publish_first_SAA_activity(){
		addActivityPage.expandAndSelectRadioBtnForSAA();
		addActivityPage.clickPublish();
	}
	
	@When("^I save distinct SAA activity with default options$")
	public void i_save_distinct_SAA_activity_with_default_options(){
	   mindTapDescriptionPage.enterTitleOnDescriptionLPNForm("saaActivity");
	   mindTapDescriptionPage.reorderActivity();
	   mindTapDescriptionPage.clickSaveButton();
	}
	
	@Then("^verify created SAA activity should linked to LPN$")
	public void verify_created_SAA_activity_should_linked_to_LPN(){
		mindTapLPNPage.closeAnnouncement();
		Assert.assertTrue("SAA is not Published to LPN", mindTapLPNPage.verifySavedActivityOnLPN("saaActivity"));
		logPassMessage("Published SAA is correctly displayed on LPN");
	}
	
	//*******************Link Simple Assessment********************
	
	
	@When("^I select Simple Assessment as creation type$")
	public void i_select_Simple_Assessment_as_creation_type() {
		addActivityPage.selectSimpleAssessment();
	}
	@When("^I publish practice Simple Assessment activity$")
	public void I_Publish_First_Practice_SA_Activity() {
		addActivityPage.expandAndSelectRadioForSimpleAssessment();
		addActivityPage.clickPublish();
	}
	@When("^I select radio for product in Simple Assessment activity$")
	public void I_select_radio_for_product_SA_Activity() {
		addActivityPage.expandAndSelectRadioForSimpleAssessment();
	}
	

	@When("^I save distinct Simple Assessment activity with default options$")
	public void i_save_distinct_Simple_Assessment_activity_with_default_options() throws IOException {
		mindTapDescriptionPage.enterTitleOnDescriptionLPNForm("SimpleAssessmentActivity");
		mindTapDescriptionPage.reorderActivity();
		mindTapDescriptionPage.clickSaveButton();
	}

	@Then("^verify created Simple Assessment activity should linked to LPN$")
	public void verify_created_Simple_Assessment_activity_should_linked_to_LPN() {
		mindTapLPNPage.closeAnnouncement();
		Assert.assertTrue("Simple Assessment is not Published to LPN", mindTapLPNPage.verifySavedActivityOnLPN("SimpleAssessmentActivity"));
		logPassMessage("Published Simple Assessment is correctly displayed on LPN");
	}
	
	@When("^I publish manually gradable video activity$")
	public void I_Publish_Manually_Gradable_Video_Activity() {
		addActivityPage.expandAndSelectRadioForFirstVideoActivity();
		addActivityPage.clickPublish();
	}
	
	@When("^I save manually gradable activity with default options$")
	public void I_save_manually_gradable_activity_with_default_options() throws IOException {
		mindTapDescriptionPage.enterTitleOnDescriptionLPNForm("ManualGradingVideoActivity");
		mindTapDescriptionPage.reorderActivity();
		mindTapDescriptionPage.clickSaveButton();
	}
	
	@Then("^verify created manually gradable activity should be linked to LPN$")
	public void Verify_created_manually_gradable_activity_should_be_linked_to_LPN() {
		mindTapLPNPage.closeAnnouncement();
		Assert.assertTrue("Manually Gradable Video Activity is not Published to LPN", mindTapLPNPage.verifySavedVideoActivityOnLPN());
		logPassMessage("Published Manually Gradable Video Activity is correctly displayed on LPN");
	}
	
	@Then("^verify if cancel button appears$")
	public void verify_if_cancel_button_appears(){
		Assert.assertTrue("Select Assessment label on Add Activity panel is missing", addActivityPage.verifySelectAssessmentPanel());	
		logPassMessage("Select Assessment label is appearing on Add Activity panel");
		Assert.assertTrue("Cancel button is missing on Add Activity panel", addActivityPage.verifyCancelButton());
		logPassMessage("Cancel button is appearing on Select Assessment Page");
	}
	
	@Then("^I should see product title in creation type Panel$")
	public void I_should_see_product_title_in_creation_type_Panel(){
//		//Assert.assertTrue("Creation type Panel does not display",addActivityPage.verifyContainerPanelOnSelectAssessmentPage());
//		logPassMessage("Creation type panel is appearing");
//		Assert.assertTrue("Title did not mach",addActivityPage.verifyTheCourseOnCreationTypePanel());
	}
	
	@When ("^I expand title panel$")
	public void I_expand_title_panel(){
		addActivityPage.clickOnExpandToggleOnCreationTypePanel();
		logMessage("Expanded the title from Select Assessment panel");
	}
	
	@Then ("^I should see Assessment Activity list$")
	public void I_should_see_Assessment_Activity_list(){
		Assert.assertTrue("List of activity is present", addActivityPage.verifyAssessmentActivityList());
		logPassMessage("Assessment list is appearing");
	}
	
	@Then ("^I should see preview button against each assignment activity$")
	public void I_should_see_preview_button_against_each_assignment_activity(){
		Assert.assertTrue("List of activity is present", addActivityPage.verifyPreviewButtonAssociatedWithEachSimpleAssessmentAcitvity());
		logPassMessage("Preview button apearing against each assessment");
	}
	

	@Then("^I should see used button against each assignment activity$")
	public void I_should_see_used_button_against_each_assignment_activity() {
		Assert.assertTrue("List of activity is present", addActivityPage.verifyPreviewButtonAssociatedWithEachSimpleAssessmentAcitvity());
		logPassMessage("Used button apearing against each assessment");
	}
	@Then("^I launch the simple assessment activity$")
	public void I_launch_the_simple_assessment_activity()
	{
		simpleAssessmentActivityPage.clickOnStart();
	}
	
	
	
	@Then ("^verify the preview panel for assessment$")
	public void verify_the_preview_panel_for_assessment(){
		Assert.assertTrue("Review and Submit button is not present on assessment preview panel", addActivityPage.verifyReviewAndSubmitButtonOnPreviewAssessmentPanel());
		logPassMessage("Review and Submit button is present in assessment preview panel");
		Assert.assertTrue("Check my work button is not present on assessment preview panel", addActivityPage.verifyCheckMyWorkButtonOnPreviewAssessmentPanel());
		logPassMessage("Check my work button is present in assessment preview panel");
		Assert.assertTrue("Close button is not present on assessment preview panel ", addActivityPage.verifyCloseButtonverifyOnPreviewAssessmentPanel());
		logPassMessage("Close button is present on assessment preview panel");
		addActivityPage.clickOnCloseButtonOfAssessmentPanel();
		logMessage("User is at Simple Assessment activity page");
	}

	@Then("^I should see various assignment option groups$")
	public void i_should_see_various_assignment_option_groups() throws Throwable {
		addActivityPage.expandAndSelectRadioForSimpleAssessment();
	    Assert.assertTrue("Problems in loading various assignment option groups", addActivityPage.
	    		verifyAssignmentGroupOptions(YamlReader.getYamlValue("assignmentGroupOptions.option1")
	    		,YamlReader.getYamlValue("assignmentGroupOptions.option2"),YamlReader.getYamlValue("assignmentGroupOptions.option3")
	    		,YamlReader.getYamlValue("assignmentGroupOptions.option4"),YamlReader.getYamlValue("assignmentGroupOptions.option5")
	    		,YamlReader.getYamlValue("assignmentGroupOptions.option6")));
	    logPassMessage("Various assignment option groups like Practice, Attempts, Timed etc are appearing fine on Add activity page");
	}

	
	@When("^I click on Preview button for first Assessment$")
	public void I_click_on_preview_button_for_first_assessment(){
		addActivityPage.clickOnExpandToggleOnCreationTypePanel();
		addActivityPage.clickOnPreviewButtonForFirstAssessment();
		logMessage("Clicked on preview link against first assessment");
	}
	@When("^I click on Preview button for SAA first Assessment$")
	public void I_click_on_preview_button_for_SAA_first_assessment(){
		addActivityPage.clickOnPreviewButtonForSAAFirstAssessment();
		logMessage("Clicked on preview link against first assessment");
	}

	@When("^I Select an Assessment Test For SAA$")
	public void I_Select_an_Assessment_Test_For_SAA(){
		addActivityPage.expandAndSelectRadioBtnForSAA();
	}
	
	@Then("^verify unchecked Practice button option on selecting SAA  $")
	public void verify_unchecked_Practice_button_option_on_selecting_SAA(){
		Assert.assertTrue("Practice label is not present", addActivityPage.verifyPresenceOfPracticeLabel());
		logPassMessage("Practice label is present");
		Assert.assertFalse("CheckBox with practice label is already checked", addActivityPage.verifyCheckBoxIsUnChecked());
		logPassMessage("CheckBox with practice label is already un-checked");
	}
	
	@Then("^I click on cancel button$")
	public void I_click_on_cancel_button(){
		addActivityPage.clickOnCancelButton();
		logMessage("Clicked on cancel button");
	}
	
	@Then("^verify the preview panel for SAA$")
	public void verify_the_preview_panel_for_SAA(){
		Assert.assertTrue("Preview panel for SAA didn't open", addActivityPage.verifyPreviewPanelForSAA());
		addActivityPage.clickOnCloseButtonOfAssessmentPanel();
		addActivityPage.clickOnCancelButton();
		addActivityPage.clickCancelOnList();
	}
	
	@When("^I click on Start button on Activity Page&")
	public void clickStartOnActivityInfo()
	{
		activityInfo.clickStartButton();
	       
			
		}
	}

	
	

