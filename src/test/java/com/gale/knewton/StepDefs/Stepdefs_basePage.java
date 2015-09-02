package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class Stepdefs_basePage extends BaseTest {

	
	private String lbl_addActivityHeading_xpath = "//h1[text()='Add Activity']";
	private String lbl_GDAHeading_xpath = "//span[contains(text(),' Select Assessment')]";
	

	@Before
	public void printScenarioName(Scenario scenario) {
		System.out.println("****Running scenario:****" + scenario.getName());
	}
	
	@Given("^I am on Add Activity List$")
	public void i_am_on_Add_Activity_List() {
		Assert.assertTrue("MindTap LPN did not appear",
				mindTapLPNPage.getInstLPNDisplayed());
		mindTapLPNPage.clickAddActivitybutton();
		Assert.assertEquals("Add Activity list do not appear",
				findElementByXpath(lbl_addActivityHeading_xpath).getText(),
				"Add Activity");
		logPassMessage("I am on Add Activity List");
	}
	

	@Given("^I am on Exam Study Center configuration page$")
	public void i_am_on_Exam_Study_Centre_configuration_page() {
		String EscCenterHead;
		EscCenterHead = escConfigPage.getExamStudyCenterHead();
		System.out.println(EscCenterHead);
		Assert.assertTrue("Exam Study Center Configuration page not displayed",
				(EscCenterHead).equals("Exam Study Center - Configuration"));
	}

	@Given("^I am on Select Assessment page$")
	public void i_am_on_Select_Assessment_page() {

		Assert.assertTrue("MindTap LPN did not appear",
				mindTapLPNPage.getInstLPNDisplayed());
		logPassMessage("Mindtap LPN appeared");
		mindTapLPNPage.clickAddActivitybutton();
		Assert.assertEquals("Add Activity page do not appear", "Add Activity",
				findElementByXpath(lbl_addActivityHeading_xpath).getText());
		logPassMessage("I am on Add Activity page");

		addActivityPage.selectAssessment();
		hardWait(5);
		Assert.assertEquals("Select Assessment page do not appear",
				"Select Assessment", findElementByXpath(lbl_GDAHeading_xpath)
						.getText());
	}

	@Given("^I should be on instructor's LPN page$")
	public void i_should_be_on_instructor_LPN_page() {
		resetImplicitTimeout(5);
		
		try {
			mindTapDashboard.clickCancelButton();
		} catch (Exception e) {

		}


		Assert.assertTrue("MindTap LPN did not appear",
				mindTapLPNPage.getInstLPNDisplayed());
		resetImplicitTimeout(60);
	}

	@Given("^I am on instructor's LPN page$")
	public void i_am_on_instructor_LPN_page() {
			   mindTapDashboard.showInstructorLPN();
		resetImplicitTimeout(30);
		Assert.assertTrue("Instructor LPN Page not displayed",
				mindTapLPNPage.isLPNDisplayedAtInstructor());
		logPassMessage("Instructor LPN page is displayed successfully");
		resetImplicitTimeout(60);
	}
	@Given("^I should be on Lesson center instructor LPN page$")
	public void i_Should_be_on_Lesson_Center_LPN()
	{
		Assert.assertTrue("Student LPN not displayed", LCconfigPage.getLessonCenterLPN());
	}

	@Given("^I should be on Student's LPN page$")
	public void i_should_be_on_studentLPN_page() {
		Assert.assertTrue(
				"Studentlbl_addActivityHeading_xpath LPN not displayed",
				mindTapLPNPage.getStudLPNDisplayed());
		logPassMessage("User is on Student LPN");
	}

	@Given("^I should be on Simple Assessment activity page$")
	public void i_should_be_on_Simple_Assessment_activity_page()
			throws Throwable {
		resetImplicitTimeout(10);
	

		if (simpleAssessmentActivityPage.isSimpleAssessmentLaunched()) {
			logPassMessage("Simple Assessment activity page displayed successfully");
		} else {
			logWarningMessage("Simple Assessment activity page not displayed");
	
			mindTapLPNPage.getInstLPNDisplayed();
			hardWait(1);
			mindTapLPNPage.clickDistinctSimpleAssessment_Activity();
			Assert.assertTrue(
					"Simple Assessment activity page still not displayed",
					simpleAssessmentActivityPage.isSimpleAssessmentLaunched());
			logPassMessage("Simple Assessment activity page displayed successfully");
		}
		resetImplicitTimeout(60);

	}

	@Given("^I should be on inline Simple Assessment activity page$")
	public void i_should_be_on_inline_Simple_Assessment_activity_overview_page()
			throws Throwable {
		resetImplicitTimeout(10);
		

		if (simpleAssessmentActivityPage.isInlineSimpleAssessmentLaunched()) {
			logPassMessage("Simple Assessment(inline) activity page displayed successfully");
		} else {
			logWarningMessage("Simple Assessment(inline) activity page not displayed");
			
			
			Assert.assertTrue("User is not on the Ebook Document Page",
					eBookDocPage.isUserOnEbookDocumentPage());
			eBookDocPage.clickInlineSA_Activity();
			Assert.assertTrue(
					"Simple Assessment(inline) activity page still not displayed",
					simpleAssessmentActivityPage.isSimpleAssessmentLaunched());
			logPassMessage("Simple Assessment(inline) activity page displayed successfully");
		}
		resetImplicitTimeout(60);

	}

	@Given("^I should be on Exam Study Center page$")
	public void i_should_be_on_Exam_Study_Center_page() {
		
		Assert.assertTrue("Student is not on ESC activity page",
				escPage.isESCActivityDisplayedatStud());
		logPassMessage("Student is on ESC activity page");

	} 
	
	@Given("^I should be on Lesson Center configuration page$")
	public void i_should_be_on_lesson_center_config_page()
	{
		Assert.assertTrue("Instructor is not on lesson cnter configuration page",LCconfigPage.verifyLCConfigPage());
	}
	@And("I am on Add Activity page")
	public void i_am_on_add_activity_page()
	{

		mindTapLPNPage.clickAddActivitybutton();
		Assert.assertEquals("Add Activity list do not appear",
				findElementByXpath(lbl_addActivityHeading_xpath).getText(),
				"Add Activity");
		logPassMessage("I am on Add Activity List");
	}
	

}
