package com.gale.knewton.StepDefs;

import java.awt.AWTException;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentLessonCenter extends BaseTest {
	
	@When("^I see lesson center acitivites displayed on student LPN$")
	public void I_See_lesson_Center_Acitivites_Displayed_On_Student_LPN()
	{
	 LCactivityPage.isLessonCenterActivitiesDisplayed();
	}
	
	@Then("^i see Mastery tab as enabled and Assessment tab as disabled$")
	public void i_See_Mastery_Tab_As_Enabled_And_Assessment_Tab_As_Disabled()
	{
		Assert.assertTrue("Mastery Tab is not enabled", LCactivityPage.isMasteryTabActive());
		Assert.assertTrue("Assessment tab not disabled",LCactivityPage.isAssessmentTabDisabled());
	}
	
	@And("^i see \"Assessment will be available when you achieve Mastery or on DATE, TIME\" message just right to disable ASSESSEMT tab$")
	public void i_See_Assessment_Availability_Message()
	{
		LCactivityPage.verifyAssessmentNotAvailablityMessage();
	}
	
	@When("^i open on other LC activities and Verify student is not able to take future LCs and error message displayed as (.*)$")
	public void i_Open_Other_LC_Activities(String Error)
	{
	
		LCactivityPage.openOtherLcActivity(2);
		LCactivityPage.verifyStudentNotAbleToTakeFutureLCs(Error);
		escActivity.closeActivity();
	
	}
	
	@Then("^I attempt mastery Questions on LC activity$")
	public void i_attempt_LC_Activity()
	{
		LCactivityPage.isIncludedInstructionMaterialDisplayedOnActivity();
		LCactivityPage.clickNextButton();
		LCactivityPage.clickNextButton();
		LCactivityPage.attemptMasteryQuestions();
		LCactivityPage.isFeedbackShown();
		LCactivityPage.clickNextButton();
		
	}
	
	@Then("^I launch Assessment and Answer One Question$")
	public void I_Launch_Assessment_And_Answer_One_Question()
	{
		LCactivityPage.clickRadioButtonForAssessmentQuestions();
	}
	
	@Then("^I am able to see mastery message on achieving mastery$")
	public void i_see_Message_On_Achieving_Mastery()
	{
    LCactivityPage.verifyStudentIsAbleToSeeMasteryAcheivedMessageOnTopHeader();
	LCactivityPage.verifyStudentIsAbleToSeeMasteryAcheivedMessage();
	}
	
	@And("^i see student receive additional reccomendation on clicking continue button$")
	public void i_See_Student_Receive_Additional_Reccomendation_On_Clicking_Continue_Button()
	{
		LCactivityPage.clickContinueButtonOnMastery();
	    LCactivityPage.verifyStudentReceiveAdditionalRecomendation();
	}
	
	@And("^i see \"Assessment Unlocked!\" message on top of the header on achieving the mastery$")
	public void i_See_Assessment_Unlocked_Message_On_Acheving_Mastery()
	{
		LCactivityPage.verifyAssessmentUnlockedMessage();
		LCactivityPage.clickOnAssessmentTab();
		LCactivityPage.isAssessmentTabEnabled();
	}
	
	@And("^I click CheckMyWork button$")
	public void I_Click_CheckMyWork_Button()
	{
		LCactivityPage.clickCheckMyWorkButton();
		LCactivityPage.isFeedbackShown();
		LCactivityPage.clickTryAnotherVersionButton();
		LCactivityPage.clickNextButtonforAssessmentQuestions();
	}
	
	@Then("^i am able to take ASSESSMENT questions$")
	public void i_Am_Able_To_Take_Assessment_Questions()
	{
	
		
		LCactivityPage.isAssessmentScoreDisplayedUnderReviewAndSubmitTag();
		LCactivityPage.clickOnReviewAndSubmitButton();
		LCactivityPage.clickIamDoneWithGradingButton();
		LCactivityPage.verifyAssessementIsSubmittedOnClickingDoneWithGradingButton();
	}
	
	@When("^i verify assessment tab is not availaible on lesson center if it is not included$")
	public void i_Cannot_See_Assessment_Tab_If_It_Is_Not_Included_In_LC()
	{
		LCactivityPage.openOtherLcActivity(2);
		LCactivityPage.verifyAssessmentTabIsNotAvailableIfItIsNotIncluded();	
	}
	
	@Then("^I am able to Take LC if Assessment is not Included$")
	public void I_Am_Able_To_Take_LC_If_Assessment_Not_Included()
	{
		LCactivityPage.clickNextButton();
		
	}
	
}
