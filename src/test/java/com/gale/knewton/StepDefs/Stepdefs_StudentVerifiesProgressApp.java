package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_StudentVerifiesProgressApp extends BaseTest {


	String ScoreOnProgressApp;
	String LPNScore;

	@When("^I click on progress app icon from App dock$")
	public void i_click_on_progress_app_icon_from_App_dock() {

		mindTapLPNPage.clickProgressApp();
		logMessage("I click on progress app icon from App dock");
	}

	@Then("^My Grades tab is active by default$")
	public void my_Grades_tab_is_active_by_default() {
		Assert.assertTrue("My Grade tab is not selected by default",
				progressApp.verifyMyGradeAsDefaultTab());
		logPassMessage("My Grade tab is selected by default");
		progressApp.closeProgressApp();
	}

	@Then("^\"(.*?)\" and \"(.*?)\" tabs are displayed$")
	public void tabs_displayed_are(String myGrade, String masteryReport) {
		Assert.assertEquals("My Grade tab not displayed", myGrade,
				progressApp.getMyGrade());
		logPassMessage("My Grade tab displayed successfully");
		Assert.assertEquals("Mastery Report tab not displayed", masteryReport,
				progressApp.getMasteryReport());
		logPassMessage("Mastery Report tab displayed successfully");
	}

	@Then("^I should be on Student's progress app$")
	public void i_should_be_on_progress_app() {
		mindTapLPNPage.clickProgressApp();
		Assert.assertTrue("Student's progress app not displayed",
				progressApp.isStudentProgressAppDisplayed());
		logPassMessage("Student's progress app displayed successfully");
	}

	@Then("^Correct score is displayed for attempted Distinct Simple Assessment activity$")
	public void correct_score_is_displayed_for_attempted_simple_assessment_activity() {
		ScoreOnProgressApp = progressApp.getSAScore();
		LPNScore = PropFileHandler.readProperty("SALpnScore",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals(
				"Simple Assessment Score at progress app is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("Simple Assessment Score at progress app is same as on LPN");
		progressApp.closeProgressApp();
	}

	@Then("^Correct score is displayed for attempted Inline Simple Assessment activity$")
	public void correct_score_is_displayed_for_attempted_inline_simple_assessment_activity() {
		ScoreOnProgressApp = progressApp.getInlineSAScore();
		LPNScore = PropFileHandler.readProperty("InlineSALpnScore",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals(
				"Inline Simple Assessment Score at progress app is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("Inline Simple Assessment Score at progress app is same as on LPN");
		progressApp.closeProgressApp();
	}

	@Then("^Correct score is displayed for attempted SAA activity$")
	public void correct_score_is_displayed_for_attempted_SAA_activity() {
		ScoreOnProgressApp = progressApp.getSAAScore();
		LPNScore = PropFileHandler.readProperty("SAALpnScore",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals("SAA Score at progress app is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("SAA Score at progress app is same as on LPN");
		progressApp.closeProgressApp();
	}

	@When("^I click on Simple Assessment activity link$")
	public void i_click_on_Simple_Assessment_activity_link() {
		progressApp.clickDistinctSimpleActivityLink();
		
	}

	@Then("^correct score for the current attempt is displayed for Distinct Simple Assessment activity$")
	public void correct_score_for_the_current_attempt_is_displayed_for_Simple_Assessment_activity() {
		LPNScore = PropFileHandler.readProperty("SALpnScore",
				YamlReader.getData("propertyfilepath"));
		ScoreOnProgressApp = progressApp.getPopUpRecordedScore();
		Assert.assertEquals("Distinct SA Score at popup is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("Distinct SA Score at popup is  same as on LPN");
	}

	@Then("^View button is displayed$")
	public void view_button_is_displayed() {
		Assert.assertTrue(
				"View button is not displayed for Simple Assessment activity",
				progressApp.isViewButtonDisplayed());
		logPassMessage("View button is displayed for Simple Assessment activity");

	}

	@When("^I click on view button$")
	public void i_click_on_view_button() {
		progressApp.clickViewButton();
		progressApp.closeProgressApp();
		hardWait(3);
	}

	@When("^I click on inline Simple Assessment activity link$")
	public void i_click_on_inline_Simple_Assessment_activity_link() {
		progressApp.clickDistinctSimpleActivityLink();
	}
	
	
	
	@Then("^correct score for the current attempt is displayed for inline Simple Assessment activity$")
	public void correct_score_for_the_current_attempt_is_displayed_for_inline_Simple_Assessment_activity() {
		LPNScore = PropFileHandler.readProperty("InlineSALpnScore",
				YamlReader.getData("propertyfilepath"));
		ScoreOnProgressApp = progressApp.getPopUpRecordedScore();
		Assert.assertEquals("Inline SA Score at popup is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("Inline SA Score at popup is  same as on LPN");
	}

	@When("^I click on SAA activity link$")
	public void i_click_on_SAA_activity_link() {
		progressApp.clickDistinctSimpleActivityLink();
	}

	@Then("^correct score for the current attempt is displayed for SAA activity$")
	public void correct_score_for_the_current_attempt_is_displayed_for_SAA_activity() {
		LPNScore = PropFileHandler.readProperty("SAALpnScore",
				YamlReader.getData("propertyfilepath"));
		ScoreOnProgressApp = progressApp.getPopUpRecordedScore();
		Assert.assertEquals("SAA Score at popup is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("SAA Score at popup is  same as on LPN");
	}

	@Then("^Mastery Report tab is displayed$")
	public void mastery_Report_tab_is_displayed() {
		Assert.assertEquals("Mastery Report tab not displayed",
				"Mastery Report", progressApp.getMasteryReport());
		logPassMessage("Mastery Report tab displayed successfully");
	}

	@When("^I click on Mastery Report tab$")
	public void i_click_on_Mastery_Report_tab() {
		progressApp.clickMasteryReport();
		logPassMessage("Mastery report tab clicked");
	}

	@Then("^Configured ESC chapter is displayed with two stars rating$")
	public void configured_ESC_chapter_is_displayed_with_two_stars_rating() {
		String ESCchapter = PropFileHandler.readProperty("EscChapterName",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals("Configured ESC chapter (" + ESCchapter
				+ ") is not displayed in Mastery report", ESCchapter,
				progressApp.getEscChapterName());
		logPassMessage("Configured ESC chapter (" + ESCchapter
				+ ") is displayed at mastery report");
		Assert.assertEquals("ESC Chapter does not have two stars rating", 2,
				progressApp.getEscChapterRating());
		logPassMessage("ESC Chapter has two stars ratings");
	}

	@When("^I click on chapter link$")
	public void i_click_on_chapter_link() {
		progressApp.clickEscChapterLink();
		logPassMessage("ESC chapter link clicked");
	}

	@Then("^Learning Objectives for the selected chapter are displayed$")
	public void learning_Objectives_for_the_selected_chapter_are_displayed() {
		String EscChapterName = PropFileHandler.readProperty("EscChapterName",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals("Correct Chapter not displayed on LO window",
				EscChapterName, progressApp.getEscChapterNameOnLoWindow());
		logPassMessage("Correct Chapter name is displayed on LO window");
		Assert.assertTrue("No learning objectives are present on LO window",
				(progressApp.getLoSizeOfEscChapter() > 0));
		logPassMessage("Learning Objectives are present on LO window");
		progressApp.closeProgressApp();
	}

	@Then("^USC chapter is displayed with two stars rating$")
	public void usc_chapter_is_displayed_with_two_stars_rating() {
		String USCchapter = PropFileHandler.readProperty("USCchapter",
				YamlReader.getData("propertyfilepath"));
		Assert.assertEquals("Configured USC chapter (" + USCchapter
				+ ") is not displayed in Mastery report", USCchapter,
				progressApp.getUscChapterName());
		logPassMessage("Configured USC chapter (" + USCchapter
				+ ") is displayed at mastery report");
		Assert.assertEquals("USC Chapter does not have two stars rating", 2,
				progressApp.getUscChapterRating());
		logPassMessage("USC Chapter has two stars ratings");

	}

	@When("^I click on USC chapter link$")
	public void i_click_on_USC_chapter_link() {
		progressApp.clickUscChapterLink();
		logPassMessage("USC chapter link clicked");

	}

	@Then("^Learning Objectives for the selected USC chapter are displayed$")
	public void learning_Objectives_for_the_selected_USC_chapter_are_displayed() {
		Assert.assertEquals("chapter heading present in selected chapters",
				true, progressApp.verifyLOForSelectedChapterInProgressApp());
		progressApp.closeProgressApp();
		logPassMessage("learning_Objectives_for_the_selected_USC_chapter_are_displayed");
	}
	
	
}
