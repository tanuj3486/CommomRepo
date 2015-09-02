package com.gale.knewton.StepDefs;

import java.io.IOException;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_examStudyCenter extends BaseTest{
	
	
	String heading;
	
	//**********Access Exam Study Center Configurations page**********
	
	@When("^I click Exam Study Center from Activities list$")
	public void i_click_Exam_Study_Center_from_Activities_list() {
		
		addActivityPage.selectExamStudyCenter();
	}

	//**********Save ESC after filling required details and verify its link on LPN********
	
	@When("^I save ESC activity after completing required details on Config page and following MindTap Description page$")
	public void i_enter_required_details_and_following_MindTap_Description_page_and_save() throws IOException {
		escConfigPage.enterExamDueDate();
		escConfigPage.selectChapterCheckbox();
	    escConfigPage.clickSave();
	  
		mindTapDescPage.enterTitleOnDescriptionLPNForm("ESC");
		mindTapDescPage.reorderActivity();
		mindTapDescPage.clickSaveButton();
	}

	@Then("^created ESC should be linked to LPN$")
	public void created_ESC_should_be_linked_to_LPN() {
		
		mindTapLPNPage.closeAnnouncement();
		Assert.assertTrue("Published Exam Study Center is not displayed on LPN ",mindTapLPNPage.verifySavedActivityOnLPN("ESC"));
		logPassMessage("ESC Activity is verified on LPN as distinct activity");
	//	hardWait(120); // hard wait due to issues with ESC launch in JIRA 
	}
	
	 @And("^Default Exam Target Due Date is displayed as mm/dd/yyyy$")
		public void default_exam_target_due_date() {
		// Assert.assertEquals("Default ESC due date is not mm/dd/yyyy","mm/dd/yyyy",escConfigPage.getExamDueDate());
			//logPassMessage("Default ESC due date is mm/dd/yyyy");
	 }
	 
	 @Then("^(.*) is displayed on ESC config page$")
	 public void  verify_ESC_config_components(String components){
		 Assert.assertTrue("Components aren't displaying", escConfigPage.verifyESCConfigComponents(components));
		 logPassMessage("ESC configurations are displaying");
	 }
	 
	 @Then ("^default Exam target score is displayed$")
	 public void default_Exam_target_score_is_displayed(){
		 Assert.assertTrue("Default Exam target score appearing is incorrect", escConfigPage.verifyExamTargetScore());
		 logPassMessage("Default Exam target score appearing is correctly");
	 }
	 
	 @Then ("^I see all chapters are unselected on Exam Study Center Configuration page$")
	 public void I_see_all_chapters_are_unselected_on_Exam_Study_Center_Configuration_page(){
		 Assert.assertFalse("Chapters checkboxes are selected", escConfigPage.verifyUnselectedChapterCheckboxes());
		 logPassMessage("All the checkboxes are unselected");
	 }
	 
	 @Then ("^I see all chapters are unselected$")
	 public void I_see_all_chapters_are_unselected(){
		 Assert.assertTrue("Check box is not appearing on ESC configuration",escConfigPage.verifyClearAllCheckBoxIsUnselected());
	 }
	 
	 @When ("^I click on select all checkbox$")
	 public void I_click_on_select_all_checkbox(){
		 escConfigPage.clickOnSelectAllCheckBox();
	 }
	 
	 @Then ("^I see all chapters should get selected$")
	 public void I_see_all_chapters_should_get_selected(){
		 Assert.assertTrue("Chapters aren't selected",escConfigPage.verifyAllChaptersAreSelected());
	 }
	 
	 @When ("^I hover on already linked ESC activity$")
	 public void I_hover_on_already_linked_ESC_activity(){
		mindTapLPNPage.hoverOnLPNElement("ESC"); 	 
	 }
	 
	 @When ("^I click on edit options button$")
	 public void I_click_on_edit_options_button(){
		 mindTapLPNPage.editLPNElement();
	 }
	 
	 @When("^I edit title of ESC and save it$")
	 public void I_edit_title_of_ESC_and_save_it(){
		 mindTapDescPage.enterTitleOnDescriptionLPNForm("ESC");
		 mindTapDescPage.clickSaveButton();
	 }
	 
	 @When("^I hover prebuilt ESC$")
	 public void I_hover_prebuilt_ESC(){
		 escConfigPage.hoverOnPreBuiltESC(); 
	 }
	 
	 @When ("^$I click on edit options button from edit panel$")
	 public void I_click_on_edit_options_button_from_edit_panel(){
		 escConfigPage.clickOnEditOptionsButtonOnEditPanel();
	 }

	
}
