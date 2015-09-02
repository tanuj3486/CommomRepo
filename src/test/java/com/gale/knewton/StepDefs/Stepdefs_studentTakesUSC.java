package com.gale.knewton.StepDefs;

import static org.hamcrest.core.StringStartsWith.startsWith;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_studentTakesUSC extends BaseTest {

	@Then("^I am on Unit Study Center page$")
	public void i_am_on_Unit_Study_Center_page() {
	   Assert.assertTrue("USC activity page not displayed", uscActivitypage.isUSCactivityDisplayed());
	   logPassMessage("USC activity page displayed successfully");
	}
	
	@Given("^I should be on Unit Study Center page$")
	public void i_should_be_on_Unit_Study_Center_page() {
		Assert.assertTrue("USC activity page not displayed", uscActivitypage.isUSCactivityDisplayed());
		logPassMessage("User is on USC activity page");
	}   
	
    @Then("^Mastery Report link is available$")
    public void mastery_Report_link_is_available() {
    	Assert.assertTrue("Mastery Report link not displayed", uscActivitypage.isMasteryReportDisplayed());
    	logPassMessage("Mastery Report link displayed successfully");
    }

    @Then("^Next button is displayed and is clickable$")
    public void next_button_is_displayed_and_is_clickable() {
    	Assert.assertTrue("Next button is not displayed", uscActivitypage.isNextButtondisplayed());
    	logPassMessage("Next button is displayed successfully");
    	uscActivitypage.clickNextButton();
    }

    @Then("^I am on chapter LPN$")
    public void i_am_on_chapter_LPN() {

    	Assert.assertTrue("Chapter LPN not displayed", mindTapLPNPage.isUSCLinkDisplayed(""));
    	logPassMessage("Chapter LPN displayed successfully");
    	mindTapLPNPage.navigateToBaseLPN();
    }
    
    @Then("^Chapter content is displayed with relevant chapter title$")
    public void chapter_content_is_displayed() {
    	Assert.assertTrue("Chapter content not displayed", uscActivitypage.isContentDisplayed());
    	logPassMessage("Chapter content displayed successfully");
    	Assert.assertTrue("Incorrect chapter displayed", uscActivitypage.verifyChapterNumber());
    	logPassMessage("Correct chapter displayed");
    }
    @Then("^Learning objetives associated with chapter available on Mastery Report$")
    public void learning_objetives_associated_with_chapter_while_taking_unit_study_center(){
    	String firstObjective="Compare and contrast major frameworks of sociological theory.";
		String firstLo=uscActivitypage.getFirstLearningObjectivesOnMasteryReport();
    	Assert.assertThat("First objective didnt match",firstLo , startsWith(firstObjective));
    }
    @When("^Student submit answers$")
    public void student_submit_answers(){
    	uscActivitypage.clickOnsubmitAnswer();
    }
    @Then("^Student is able to receive feedback$")
    public void student_is_able_to_receive_feedback_in_Unit_Study_Center(){
    	Assert.assertThat("feedback title didnt match",uscActivitypage.getAnswerFeedback(),startsWith("Feedback"));
    }
}
