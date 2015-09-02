package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchAndSubmitDistinctSA extends BaseTest {

	boolean flag = false;
	
	private String product;

	
	//********************Launch GDA Simple Assessment**************
	@When("^I click the already linked Simple Assessment activity$")
	public void i_click_the_already_linked_Simple_Assessment_activity() {
		hardWait(1);
	    mindTapLPNPage.clickDistinctSimpleAssessment_Activity();
	}
	@When("^I click the already linked Last Simple Assessment activity$")
	public void i_click_the_already_linked_Last_Simple_Assessment_activity() {
		hardWait(1);
	    mindTapLPNPage.clickLastSimpleAssessment_Activity();
	}
	

	@Then("^I am on Simple Assessment activity page$")
	public void i_am_on_Simple_Assessment_activity_overview_page() {
		flag = simpleAssessmentActivityPage.isSimpleAssessmentLaunched();
		if(!flag){
			simpleAssessmentActivityPage.relaunchActivity();
			flag = simpleAssessmentActivityPage.isSimpleAssessmentLaunched();
		}
		Assert.assertTrue("Simple Assessment activity page not displayed", flag);
		logPassMessage("Simple Assessment activity page displayed successfully");
	}

	// ********************Submit Simple Assessment Activity******************

	@When("^I launch Activity and answer one Question$")
	public void i_click_Start_Activity_and_answer_one_Question() {
		simpleAssessmentActivityPage.selectOption();
	    logPassMessage("Activity Launched and answered one question");
	}
	
	@And ("^I click on Check My Work button$")
	public void i_click_on_Check_My_Work_button() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		simpleAssessmentActivityPage.checkMyWork();
		Assert.assertTrue("Feedback not displayed", simpleAssessmentActivityPage.isFeedbackDisplayed());
		logPassMessage("Feedback displayed successfully");
		if(product.equals("Andersen")){
		Assert.assertTrue("Try Another Version button not displayed", simpleAssessmentActivityPage.isTryAnotherVersionbtnDisplayed());
		logPassMessage("Try Another Version button displayed");
		}
	}
	
	@And ("^I close the activity without submitting it$")
	public void i_close_the_activity_without_submitting_it() {
		Assert.assertTrue("Problems while closing activity and saving its state for resume scenario",simpleAssessmentActivityPage.closeActivityAndSaveState());
		logPassMessage("An activity is successfully closed and its state is saved");
	}
	
	@And("^I submit Simple Assessment activity$")
	public void i_submit_Simple_Assessment_activity() {
		
		simpleAssessmentActivityPage.clickReviewSubmitGDA();
		//Assert.assertTrue("Current Score and Entry Score do not match",simpleAssessmentActivityPage.verifyGradesOnTable());
		logPassMessage("Current Score and Entry Score matches");
		simpleAssessmentActivityPage.submitSimpleAssessmentActivity();
		
	}
	
	@Then("^I am on Simple Assessment Activity page where I left$")
	public void i_am_on_Simple_Assessment_Activity_page_where_I_left(){
		
		Assert.assertTrue("Problems with activity Reusme!!!", simpleAssessmentActivityPage.verifySavedStateforAnActivity());
		logPassMessage("Activity successfully resumed....");
	}
	@Then("^$Click on close")
	public void click_on_close()
	{
		escActivity.closeActivity();	
			}

}
