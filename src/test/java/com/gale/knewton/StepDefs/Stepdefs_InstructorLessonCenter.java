package com.gale.knewton.StepDefs;

import java.awt.AWTException;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_InstructorLessonCenter extends BaseTest {

	@When("^I select Lesson Center from Activity List$")
	public void select_Lesson_Center_From_Activity_List()
	{
		LCconfigPage.SelectLessonCenterFromActivityList();
		logPassMessage("Lesson Center clicked Successfully");
	}
	
	@And("^Verify ‘Lesson Center page' LOGO  on Add activity page$")
	public void verify_Lesson_center_Page_LOGO()
	{
		LCconfigPage.isLessonCenterLOGODisplayed();
	}

	@Then("^I am on Lesson Center Config Page$")
	public void verify_Lesson_Center_Config_Page()
	{
		Assert.assertTrue("Lesson Center Configuration page Not Displayed", LCconfigPage.verifyLCConfigPage());
		logPassMessage("Successfully navigated to Lesson Center config page");
	}

	@And("^I Verify text and headings on Lesson Center Page$")
	public void verifyTextOnLCconfigPage()
	{
		Assert.assertTrue(LCconfigPage.verifyTextContentOnLCconfigPage());
		logPassMessage("Lesson center content is verified succesfully");
	}

	@When("^I verify that lesson center name cannot be empty$")
	public void verify_lesson_center_name_cannot_be_empty()
	{
		LCconfigPage.verifyLCpageIsNotEmpty();
	}
	
	@Then("^I see validation message on hovering mouse over continue button$")
	public void i_verify_validation_message_if_name_not_entered() throws AWTException
	{
		LCconfigPage.verifyValidationMessageOnContinueButton();
	
	}
	
	@When("^I Verify validation message on entering wrong Target score$")
	public void verify_target_score_validation_message() throws AWTException
	{
		LCconfigPage.EnterTargetScore("999");
		LCconfigPage.verifyValidationMessageOnContinueButton();
		LCconfigPage.EnterTargetScore("-7");
		LCconfigPage.verifyValidationMessageOnContinueButton();
	}
	
	
	@Then("^I verify that ‘Target Mastery Score’ is in the range of 0-100$")
	public void verify_Target_Mastery_Score_Range()
	{
		LCconfigPage.verifyTargetMasteryScoreRange();
	}
	
	@And("^I enter target mastery score for lesson center$")
	public void EnterTargetMAsteryScore()
	{
		LCconfigPage.EnterTargetScore("10");
	}
	
	@And("^I am able to increment and decrement the score using the arrow$")
	public void Increment_Decrement_Target_Score()
	{
		LCconfigPage.verifyIncrementDecrementTargetScore();
	}
	
	@And("^I am not able to enter Past Due Dates$")
	public void I_am_not_able_to_enter_Past_Due_Dates()
	{ 
		String Yesterdaydate= LCconfigPage.getYesterdayDateString();
		LCconfigPage.verifyPastDueDatesInvalidity(Yesterdaydate);
	}

	@Then("^I select valid date from calender$")
	public void select_valid_date_from_calender()
	{
		LCconfigPage.selectValidDate();
	}
	
	@When("^instructor click on due date feild$")
	public void instructor_Click_On_Due_Date_Calender()
	{
		LCconfigPage.clickonDueDateFeild();
	}
	
	@Then("^I am able to see calender widget$")
	public void i_Am_Able_To_See_Calender_widget()
	{
		LCconfigPage.verifyCalenderWidget();
	}
	
	@And("^I am not able to continue without entering valid due date$")
	public void verify_That_I_am_Not_Able_To_Continue_Without_Entering_Valid_DueDate()
	{
		LCconfigPage.verifyErrorMessageIfValidDueDateIsNotEntered();
	}
	
	@When("^I expand the chapters and select a checkbox against a chapter name$")
	public void i_Expand_The_Chapters()
	{
		LCconfigPage.expandChapters();
		LCconfigPage.clickChapterCheckbox();
	}
	@Then("^I am able to see all the learning objective of a chapter as selected$")
	public void verify_Learning_Objectives_As_Selected()
	{
		LCconfigPage.verifyAllLearningObjectivesAreSelectedWhenClickingChapterCheckbox();
		LCconfigPage.collapseChapters();
		
	}
	
	@Then("^I am able to see all learning Objectives$")
	public void Is_All_Learning_Objectives_displayed()
	{
		LCconfigPage.IsAllLearningObjectivesDisplayed();
	}
	
	 @And("^I am able to see more learning objectives by clicking forward button$")
	  public void Is_More_Learning_Objectives_displayed()
	  {
		 LCconfigPage.VerifyMoreLearningObjectivesDisplayedOnClickingForwrdButton();
	  }
	
	 @When("^I click on 20page size, I see maximum 20 learning objective$")
	 public void I_see_Max_20_Objectives()
	 {
		 LCconfigPage.verifyMax20LearningObjectiveDisplayed();
	 }
	
   @And("^I Include Prerequisite and instruction material and Assessments$")
   public void i_Include_Prerequisite_and_instruction_material()
   {
	   LCconfigPage.selectInstructionMaterialAndPrerequitsiteAndAssessment();
   }
   
   @When("^I not included prerequisite while linking Lesson Center$")
   public void I_not_included_prerequisite()
   {
	   LCconfigPage.selectInstructionMaterial();
	   LCconfigPage.SelectIncludeAssessment();
   }
   
   @When("^I not included Instruction material while linking Lesson Center$")
   public void I_not_included_Instruction_Material()
   {
	   LCconfigPage.SelectPrerequisite();
	   LCconfigPage.SelectIncludeAssessment();
   }
   
   @When("^I not included Assessment while linking Lesson Center$")
   public void I_not_included_Assessment()
   {
	  LCconfigPage.selectInstructionMaterialAndPrerequitsite();
   }
   
	@When("^I click continue button on LC config page$")
	public void i_click_continue_button_on_LC_config()
	{
		LCconfigPage.clickContinueButton();
	}
	
	@Then("^I am on Mindtap activity page$")
	public void i_am_on_mindtap_activity_page()
	{
		LCconfigPage.verifyMindtapActivityPage();
	}

	@When("^I verify instructor is able to see Name, description and "
			+ "due date in no editable mode on MindTap activity page$")
	public void verify_Not_Editable_feilds_On_Activity_Page()
	{
		LCconfigPage.verifyNotEditableFeildsOnActivityPage();
	}
	
	@And("^I am able to see 'Include Assessment' after Selecting a Learning Objective$")
	public void i_see_IncludeAssessment_feild()
	{
		Assert.assertTrue(LCconfigPage.verifyIncludeAssessmentFeild());
	}
	
	@When("^I See disabled feilds under Include assessment$")
	public void i_See_Disabled_Feilds_under_Include_Assessments()
	{
		LCconfigPage.verifyISeeDisabledFeildsUnderIncludeAssessment();
	}
	
	@Then("^I am able to see Continue button as Disabled$")
	public void i_see_Disabled_Continue_Button()
	{
LCconfigPage.IsContinueButtonDisabled();
	}
	
	@When("^I am able to see Continue button as Enabled if all mandatory feilds are entered$")
	public void i_see_Enabled_Continue_Button()
	{
	LCconfigPage.IsContinueButtonEnabled();
	}
	@Then("^On clicking Checkbox under assessment feilds become enabled$")
	public void  verify_Disabled_Feilds_Become_Enabled_On_Clicking_Checkbox()
	{
		LCconfigPage.SelectIncludeAssessment();
		LCconfigPage.verifyDisabledFeildsBecomeEnabledOnClickingCheckbox();
		
	}
	
	@And("^I am able to see message while hovering mouse over feilds$")
	public void verify_Message_While_Hovering()
	{
		LCconfigPage.verifyHoverMessage();
		LCconfigPage.SelectIncludeAssessment();
		LCconfigPage.clickChapterCheckbox();
	}
	
	@When("^I fill all necessary feilds on LC config page$")
	public void i_fill_mandatory_feilds_on_LCconfig_page()
	{
       LCconfigPage.enterLessonCenterName("LessonCenter");
       LCconfigPage.enterDescriptionOnLcConfig("QA");
	}
	
	@Then("^I save Lesson center with default options$")
	public void i_Save_Lesson_Center_With_Default_Options()
	{
		LCconfigPage.saveLcCenterWithDefaultOptions();
	}
	
	@Then("^I am on Lesson center instructor LPN page$")
	public void is_Instructor_LPN_displayed()
	{ 
		mindTapDashboard.showInstructorLPN();
		resetImplicitTimeout(10); 
		Assert.assertTrue("mind tap lpn not displayed for lesson center",LCconfigPage.isLPNDisplayedAtInstructors());
	}
	
	@And("^Linked Lesson Center is displayed at LPN page$")
	public void lesson_Center_Displayed_at_LPN()
	{
		Assert.assertTrue("Lesson Center Activity Is not Displayed At LPN page", LCconfigPage.isLessonCEnterDisplayedAtLPN());
	}
	
	@When("^I select previously linked lesson center activity present On LPN$")
	public void I_select_lesson_center_activity_from_instructor_end()
	{
		LCconfigPage.clickOnLPNLessonCenter();
	}
	
	@Then("^I am able to see Knewton Adaptive Application Error$")
	public void i_can_see_Knweton_error ()
	{
		LCconfigPage.verifyErrorWhileAccessingLessonCenterFromInstEnd();
	}
	
	@When("^I navigate to edit options from Instructor LPN page$")
	public void i_Navigate_To_Edit_Options_From_Instructor_LPN_page()
	{
		LCconfigPage.navigateToEditOptionsFromLPN();
	}
	
	@Then("^I verify Lesson center Name,Description,Due Date and Target Mastrey are editable$")
	public void i_Verify_LessonCenterName_Description_Due_Date_And_Target_Mastrey_Are_Editable()
	{
		LCconfigPage.verifyLessonCenterNameIsEditable();
		LCconfigPage.verifyDescriptionIsEditable();
		LCconfigPage.verifyTargetMasteryScoreIsEditable();
		LCconfigPage.verifyDueDateIsEditable();
		LCconfigPage.verifyNumberOfHoursAreEditable();
		}
	
	@And("^I saved the changes$")
	public void i_Saved_The_Changes()
	{
		LCconfigPage.saveTheEditedFeilds();
	}
	
}

