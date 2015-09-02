package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_InstructorVerifiesProgressApp extends BaseTest {
	String ScoreOnProgressApp;
	String LPNScore;
	static String take1;

	@Then("^\"(.*?)\", \"(.*?)\", \"(.*?)\" and \"(.*?)\" tabs are displayed on progress app$")
	public void and_tabs_are_displayed_on_progress_app(String arg1,
			String arg2, String arg3, String arg4) {
		Assert.assertEquals("Progress App tab name :", "Overview",
				progressApp.getTabsInProgressAppAtInstructorEnd(arg1));
		logMessage("Progress App tab name :" + arg1 + "is displayed");
		Assert.assertEquals("Progress App tab name :", "Analytics",
				progressApp.getTabsInProgressAppAtInstructorEnd(arg2));
		logMessage("Progress App tab name :" + arg2 + "is displayed");
		Assert.assertEquals("Progress App tab name :", "Gradebook",
				progressApp.getTabsInProgressAppAtInstructorEnd(arg3));
		logMessage("Progress App tab name :" + arg3 + "is displayed");
		Assert.assertEquals("Progress App tab name :", "Mastery Report",
				progressApp.getTabsInProgressAppAtInstructorEnd(arg4));
		logPassMessage("Progress App tab name :" + arg4 + "is displayed");
	}

	@Then("^Gradebook tab is active by default$")
	public void gradebook_tab_is_active_by_default() {
		Assert.assertEquals("default tab name :", "Gradebook",
				progressApp.getSelectedTabInProgressAppAtInstructorEnd());
		logPassMessage("Gradebook tab is active by default");

	}

	@When("^I should be on Instructor's progress app$")
	public void I_Should_Be_On_Instructor_Progress_App() {
		mindTapLPNPage.clickInstructorProgressApp();
		Assert.assertEquals("Progress App heading name :", "Progress",
				progressApp.verifyProgressAppHeading());
		logPassMessage("I should be on Instructor's progress app");
	}
@When("^verify I am on Instructor's progress app$")
public void verify_I_am__On_Instructor_Progress_App()
{
	Assert.assertEquals("Progress App heading name :", "Progress",progressApp.verifyProgressAppHeading());
	logPassMessage("I should be on Instructor's progress app");
}
	@And("^\"(.*?)\" tab is displayed$")
	public void tab_is_displayed_in_progress_app(String tabName) {
		Assert.assertEquals("Progress App tab name :", "Mastery Report",
				progressApp.getTabsInProgressAppAtInstructorEnd(tabName));
		logPassMessage("Progress App tab name :" + tabName + "is displayed");
	}

	@When("^I click on \"(.*?)\" tab$")
	public void click_on_tab_in_progress_App(String tabName) {
		progressApp.clickOnTabInProgressAppAtInstructorEnd(tabName);
		logMessage("I click on " + tabName + "in progress app");
	}

	@When("^I click on progress app icon from App dock At Instructor End$")
	public void i_click_on_progress_app_icon_from_App_dock_At_Instructor_End() {

		

		mindTapLPNPage.clickInstructorProgressApp();
		logMessage("I click on progress app icon from App dock At Instructor End");
	}

	@Then("^correct score is displayed for attempted inline simple assessment activity At InstructorEnd$")
	public void correct_score_is_displayed_for_attempted_inline_simple_assessment_activity_at_instructor_end() {
		ScoreOnProgressApp = progressApp.getInlineSAScoreAtInstructorEnd();
		LPNScore = PropFileHandler.readProperty("InlineSALpnScore",
				YamlReader.getData("propertyfilepath"));	
		progressApp.closeProgressApp();
		System.out.println("progress app closed");
		Assert.assertEquals(
				"Inline Simple Assessment Score at progress app is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("Inline Simple Assessment Score at progress app at Instructor end is same as on LPN");
		
		
	}

	@Then("^Correct score is displayed for attempted SAA activity at instructor end$")
	public void correct_score_is_displayed_for_attempted_SAA_activity_at_instructor_end() {
		String ScoreOnProgressApp = progressApp.getSAAScoreAtInstructorEnd();
		LPNScore = PropFileHandler.readProperty("SALpnScore",
				YamlReader.getData("propertyfilepath"));
		progressApp.closeProgressApp();
		
		Assert.assertEquals("SAA Score at progress app is not same as on LPN",
				ScoreOnProgressApp, LPNScore);
		logPassMessage("SAA Score at progress app is same as on LPN");
		
	}
	
	@And("^I close progress App$")
	public void close_Progress_App() {
		progressApp.closeProgressApp();
		logPassMessage("closed progress App");
	}
	@And("^I click on home icon$")
	public void click_Home_Icon()
	{
		progressApp.clickHomeIcon();
	}
	

	@Then("^correct score for the current attempt is displayed for Distinct Simple Assessment activity at instructor end$")
	public void correct_score_for_the_current_attempt_is_displayed_for_Simple_Assessment_activity_at_instructor_end() {
		String LPNScore = PropFileHandler.readProperty("SALpnScore",
				YamlReader.getData("propertyfilepath"));
		System.out.println(LPNScore+"lpn score");
		Assert.assertTrue("Distinct SA Score is not same as on LPN",
				progressApp.verifySAScore(LPNScore.trim()));
		logPassMessage("Distinct SA Score is  same as on LPN");
	}

	@When("^I click on Simple Assessment activity link at instructor end$")
	public void i_click_on_Simple_Assessment_activity_link_at_instructor_end() {
		progressApp.clickDistinctSaActivityLinkAtInstructorEnd();
	}

	
	@Then("^I click on score$")
	public void i_click_on_SA_score() {
		String LPNScore = PropFileHandler.readProperty("SALpnScore",
				YamlReader.getData("propertyfilepath"));
		System.out.println(LPNScore+"lpn score");
		progressApp.clickOnSAScore(LPNScore);
	}
	
	@Then("^correct score for the current attempt is displayed for Inline Simple Assessment activity at instructor end$")
	public void correct_score_for_the_current_attempt_is_displayed_for_Inline_Simple_Assessment_activity_at_instructor_end() {
		String LPNScore = PropFileHandler.readProperty("InlineSALpnScore",
				YamlReader.getData("propertyfilepath"));
		System.out.println(LPNScore+"lpn score");
		Assert.assertTrue("Distinct SA Score is not same as on LPN",
				progressApp.verifySAScore(LPNScore.trim()));
		switchToDefaultContent();
		logPassMessage("Distinct SA Score is  same as on LPN");
	}
	
	
	@When("^I click on inline Simple Assessment activity link at instructor end$")
	public void i_click_on_inline_Simple_Assessment_activity_link_at_instructor_end() {
		progressApp.clickInlineSaActivityLinkAtInstEnd();
	}
	
	@When("^I click on distinct SAA activity link at instructor end$")
	public void i_click_on_distinct_SAA_activity_link_at_instructor_end() {
		progressApp.clickSaaActivityLink();
	}
	
	@Then("^correct score for the current attempt is displayed for distinct SAA activity at instructor end$")
	public void correct_score_for_the_current_attempt_is_displayed_for_Distinct_SAA_activity_33at_instructor_end() {
		String LPNScore = PropFileHandler.readProperty("SAALpnScore",
				YamlReader.getData("propertyfilepath"));
		System.out.println(LPNScore+"SAA LPN score");
		Assert.assertTrue("Distinct SA Score is not same as on LPN",
				progressApp.verifySAScore(LPNScore.trim()));
		logPassMessage("Distinct SA Score is  same as on LPN");
	}
	
	
	@And("^I click on already attempted manually gradable activity$")
	public void I_click_on_already_attempted_manually_gradable_activity(){
		progressApp.clickManualGradingActivityOnProgressApp();
		logMessage("Clicked on manual grading activity on progress app");
	}
	
	@Then("^Activity Summary is displayed$")
	public void Activity_Summary_is_displayed(){
		Assert.assertTrue("Activity Summary for manual grading activity is not visible!!!",progressApp.verifyActivitySummaryOnProgressApp());
		logPassMessage("Activty summary section successfully opens on clicking manually grading activity link on progress app");
	}
	
	@When("^I click on student name link$")
	public void I_click_on_student_name_link(){
		progressApp.clickOnStudentLink();
		logMessage("User clicked on the Student link on progress app");
	}
	
	@Then("^Activity detail modal is opened$")
	public void Activity_detail_modal_opens(){
		Assert.assertTrue("Activity Detail Modal doesn't open pn clicking student link on progress App!!!", progressApp.verifyActivityDetailModalWindowOpens());
		logPassMessage("Activity Details modal window opens up on clicking student link");
	}
	
	@And("^correct grading message appears on the activity detail modal$")
	public void correct_grading_message_appears_on_the_activity_detail_modal(){
		Assert.assertTrue("Message for pending grade on progress app doesn't appear!!!", progressApp.verifyCorrectMessageForPendingGrading(YamlReader.getYamlValue("pendingMessageForManualGradingActivityOnProgressApp")));
		logPassMessage("Correct message for pendign grading appears on instructor progress app");
	}
	

	@When("^I click on View button$")
	public void i_click_on_View_button(){
		progressApp.clickViewButtonForManualGradingActivity();
	}
	
	@Then("^I am on Manual Grading Widget section$")
	public void i_am_on_Manual_Grading_Widget_section(){
		Assert.assertTrue("Manual Grading widget is not correctly visible", manuallyGradableActivityPage.isUserOnManualGradingWidgetThroughProgressApp());
		logPassMessage("Manual Grading Widget is successfully launched on clicking view on progress app");
	}
	
	@When("^I grade the activity as an instructor$")
	public void i_grade_the_activity_as_an_instructor(){
		Assert.assertTrue("Problems occurred while grading the activity on manual grading widget", manuallyGradableActivityPage.instructorGradesActivity(YamlReader.getYamlValue("manualGradeScore"), "Optional comment from instructor"));
		logPassMessage("Instructor successfully grades the manually gradable activity");
	}
	
	@Then("^correct final score should be displayed on manual grading widget$")
	public void correct_final_score_should_be_displayed_on_manual_grading_widget(){
		Assert.assertTrue("Final score does not match the expected score", manuallyGradableActivityPage.verifyFinalScoreOnMaunalWidget(YamlReader.getYamlValue("manualGradeScore")));
		logPassMessage("Final score is correctly populated on Manual Grading widget");

	}
	
	@And("^correct final score should be displayed on progress app for manually gradable activity$")
	public void correct_final_score_should_be_displayed_on_progress_app_for_manually_gradable_activity(){
		progressApp.verifyManualGradingScoreAfterInstructorDidGrading();
	}
	
	@Then("^score is not generated on progress app after instructor preview$")
	public void score_is_not_generated_on_progress_app_after_instructor_preview(){
		Assert.assertTrue("Score generated at instructor end on progress App for activity preview!!!",progressApp.verifyNoStudentOnProgresApp());
		logPassMessage("No score is generated on progress app at instructor end on preview of activity");

	}

		@When("^I click on simple assessment$")
		public void i_click_on_select_simple_assessment()
		{
		addActivityPage.selectSimpleAssessment();
		addActivityPage.expandAndSelectRadioForSimpleAssessment();
		}
	
		@Then("^I choose Best simple assessment and click publish$")
		public void I_choose_Best_simple_assesment()
		{
			addActivityPage.verifyBestOptionIsSelected();
			addActivityPage.clickPublish();
			String assigmentName=addActivityPage.getAssignmentname();
			addActivityPage.clickOnSaveButton();
		}
	    @Then("^I choose Last simple assessment and click publish$")
	    public void i_Choose_Last_Simple_Assessment()
	    {
	    	addActivityPage.verifyLastOptionIsSelected();
	    	
	    }
		
		@And("^I logout from the Instructor$")
		public void I_logout_from_instructor()
		{
			addActivityPage.logout();
		}
		
		@When("^I answer questions in simple assessment activity$")
		public void I_answer_questions_in_simple_assessment_activity()
		{
			simpleAssessmentActivityPage.clickOnAnswerRadioButton();
		}
		@When("^I answer questions second time in simple assessment activity$")
		public void I_answer_questions_second_time_in_simple_assessment_activity()
		{
			simpleAssessmentActivityPage.clickOnAnswerRadioButton2();
		}
		@Then("^I submit the activity and click on I am done$")
		public void i_submit_activity_and_click_on_i_am_done()
		{
			simpleAssessmentActivityPage.clickReviewSubmitGDA();
			//simpleAssessmentActivityPage.saveScoreForBestLast();
			simpleAssessmentActivityPage.clickOnIAmDoneGradeAssignment();
		}
		@And("^I save the LPN score for this Take$")
		public void  I_save_the_LPN_score_for_this_Take()
		{
			
			take1=mindTapLPNPage.saveTheLpnScore();
		}
		
		@When("^$I click on start to retake the activity")
		public void I_click_on_start()
		{
			activityInfo.clickStartButton();
		}
	
		
		@Then("^verify for the Best score$")
		public void verify_for_the_best_score()
		{
			
			mindTapLPNPage.verifyFortheBestScore(take1);
		}
		@Then("^verify for the Last score$")
		public void verify_for_the_Last_score()
		{
			
			mindTapLPNPage.verifyFortheLastScore();
		}
		
		@And("^I logout from the Student$")
		public void i_logout_from_student()
		{
			addActivityPage.logout();
		}
		@Then("^I click on Student name shown on the progress app$")
		public void i_click_on_student_name_shown_on_progress_app()
		{
			progressApp.clickOnStudentNameOnGradebook();	
		}
		@When("^I click on Quiz name for review$")
		public void i_click_on_Quiz_name_for_review()
		{
			progressApp.clickonQuizNameForReview();
		}
		@Then("^Instructor Review the student score for Best case$")
		public void instructor_Review_Student_Score_for_Best_case()
		{
			progressApp.reviewTheStudentActivityForBestCase();
		}
	    
		@Then("^Instructor Review the student score for Last case$")
		public void instructor_Review_Student_Score_for_Last_case()
		{
			progressApp.reviewTheStudentActivityForLastCase();
		}
	

	
}
