package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_instructorLPNActivities extends BaseTest {

	// ##############################---Instructor
	// Login/Logout---####################################
	boolean flag = false;

	@When("^I add a Unit from Add activity option$")
	public void i_add_a_Unit_from_Add_Activity_option(){
		mindTapLPNPage.clickAddUnitlink();
		mindTapDescriptionPage.enterTitleOnDescriptionLPNForm("Unit");
		mindTapDescriptionPage.reorderActivity();
		mindTapDescriptionPage.clickSaveButton();
		logPassMessage("Unit added successfully");
	}

	@Then("^I should see the created Unit on LPN$")
	public void i_should_see_the_created_Unit_on_LPN(){
		Assert.assertTrue("Unit is not visible on LPN", mindTapLPNPage.verifySavedActivityOnLPN("Unit"));
		logPassMessage("Unit created is seen successfully on LPN");
	}
	
	@When("^I add a Folder from Add activity option$")
	public void i_add_a_Folder_from_Add_activity_option(){
		mindTapLPNPage.clickAddFolderButton();
		mindTapDescriptionPage.enterTitleOnDescriptionLPNForm("Folder");
		mindTapDescriptionPage.reorderActivity();
		mindTapDescriptionPage.clickSaveButton();
		logPassMessage("Folder added successfully");
	}
	
	@Then("^I should see the created Folder on LPN$")
	public void i_should_see_the_created_Folder_on_LPN(){
		Assert.assertTrue("Folder is not visible on LPN", mindTapLPNPage.verifySavedActivityOnLPN("Folder"));
		logPassMessage("Folder created is seen successfully on LPN");
	}
	
	@When("^I hover on the Unit$")
	public void i_hover_on_the_Unit(){
	    mindTapLPNPage.hoverOnLPNElement("Unit");
	    logPassMessage("Successfully hovered on the unit on LPN");
	}

	@When("^I click hide activity link$")
	public void i_click_hide_activity_link(){
	    mindTapLPNPage.hideLPNElement();
	    logMessage("User clicked on hide link");
	}
	
	@Then("^Unit should get hidden on LPN$")
	public void unit_should_get_hidden_on_LPN(){
	    Assert.assertTrue("Problems in hiding unit on LPN!!!",mindTapLPNPage.verifyHiddenMessage("Unit"));
	    logPassMessage("Unit is successfully hidden from LPN");
	}

	@When("^I click show activity link for unit$")
	public void i_click_show_activity_link_for_unit(){
	    mindTapLPNPage.showLPNActivity("Unit");
	    logMessage("User clicked on show link for unit");
	}
	
	@When("^I click show activity link for folder$")
	public void i_click_show_activity_link_for_folder(){
		  mindTapLPNPage.showLPNActivity("Folder");
		  logMessage("User clicked on show link for folder");
	}
	@Then("^Click Add activity button on instructor LPN$")
	public void Click_Add_Activity_Button_On_Instructor_LPN()
	{
		mindTapLPNPage.clickAddActivitybutton();
	}

	@Then("^hidden unit gets visible again$")
	public void hidden_unit_gets_visible_again(){
		Assert.assertTrue("A hidden unit is not visible on clicking show link!!!",mindTapLPNPage.verifyHiddenElementNowVisibleOnLPN("Unit"));
		logPassMessage("Hidden unit is now Visible on LPN");
	}

	@When("^I click delete activity link$")
	public void i_click_delete_activity_link() {
		mindTapLPNPage.deleteLPNElement();
	    logMessage("User clicked on delete link");
	}
	

	@Then("^Unit should get deleted from LPN$")
	public void unit_should_get_deleted_from_LPN() {
		Assert.assertTrue("Problems in deleting a unit from LPN", mindTapLPNPage.verifyActivtyGetsDeleted("Unit"));
		logPassMessage("Unit gets deleted from LPN");
	}

	@When("^I hover on the Folder$")
	public void i_hover_on_the_Folder()  {
		 mindTapLPNPage.hoverOnLPNElement("Folder");
		 logPassMessage("Successfully hovered on the folder on LPN");
	}

	@Then("^Folder should get hidden on LPN$")
	public void folder_should_get_hidden_on_LPN() {
		Assert.assertTrue("Hiding a folder failed!!!", mindTapLPNPage.verifyHiddenMessage("Folder"));
		logPassMessage("Folder is successfully hidden from LPN");
	}

	@Then("^hidden folder gets visible again$")
	public void hidden_folder_gets_visible_again() {
	    Assert.assertTrue("A hidden folder is not visible on clicking show link",mindTapLPNPage.verifyHiddenElementNowVisibleOnLPN("Folder"));
	    logPassMessage("Hidden folder is now Visible on LPN");
	}

	@Then("^Folder should get deleted from LPN$")
	public void folder_should_get_deleted_from_LPN(){
	   mindTapLPNPage.verifyActivtyGetsDeleted("Folder");
	   logPassMessage("Folder gets deleted from LPN");
	}
	
	@Then("^score is not generated on LPN after instructor preview for distinct Simple Assessment$")
	public void verify_score_is_not_generated_on_LPN_after_instructor_preview_for_SA(){
		Assert.assertTrue("Score generated at instructor end for distinct SA activity!!!",mindTapLPNPage.verifyNoScoreIsGeneretedOnLPN("SimpleAssessmentActivity"));
		logPassMessage("No score is generated at instructor end on preview of simple Assessment distinct activity");
	}
	
	@Then("^score is not generated on LPN after instructor preview for distinct SAA$")
	public void verify_score_is_not_generated_on_LPN_after_instructor_preview_for_SAA(){
		Assert.assertTrue("Score generated at instructor end for distinct SAA activity!!!",mindTapLPNPage.verifyNoScoreIsGeneretedOnLPN("saaActivity"));
		logPassMessage("No score is generated at instructor end on preview of SAA distinct activity");
	}


	@Then("^verify that student is not able to re-take SAA activity$")
	public void verify_student_is_not_able_to_reTake_SAA_Activity(){
		Assert.assertTrue("Incorrect message for already attempted SAA activity", mindTapLPNPage.verifyNoMoreAttemptRemainingForActivity(YamlReader.getYamlValue("noMoreAttemptMessage.part1"), YamlReader.getYamlValue("noMoreAttemptMessage.part2")));
		logPassMessage("Correct message appears for already attempted SAA activity on LPN which can not be re-taken");
	}

	
}
