package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_instructorLoginandCourse extends BaseTest {

	// ##############################---Instructor
	// Login/Logout---####################################
	boolean flag = false;

	@Given("^I am on the Cengage Learning Login Page to login as instructor$")
	public void I_am_on_the_Cengage_Learning_Login_Page() throws Throwable {
		loginPage.LaunchLoginpage();
	}

	
	@When("^I provide instructor username and password and hit login button$")
	public void I_provide_instructor_username_and_password() {
		String username = null;
		String password = null;
		String title = System.getProperty("title");
		System.out.println("............//\\"+title);
		String environment = System.getProperty("environment");
		if(environment == null || environment.isEmpty() || environment.equals("")){
			if(title == null || title.isEmpty() || title.equals("")){
			username = YamlReader.getYamlValue(YamlReader.getYamlValue("Environment")+"."+"instructor.userName"+"."+YamlReader.getYamlValue("title"));
			password = YamlReader.getYamlValue(YamlReader.getYamlValue("Environment")+"."+"instructor.password");
			}
		}else{
			username = YamlReader.getYamlValue(environment+"."+"instructor.userName"+"."+title.trim());
			password = YamlReader.getYamlValue(environment+"."+"instructor.password");

		}
				loginPage.login(username, password);
		
	}


	@Then("^I should be able to login successfully as an instructor$")
	public void I_should_be_able_to_login_successfully_as_an_instructor() {
		
		Assert.assertTrue("Login attempt of Instructor failed",
				ssoInstDashBoardPage.isUserOnDashboardPage());
	}

	@Given("^I am on the Cengage Learning Home Page of Instructor$")
	public void I_am_on_the_Cengage_Learning_Home_Page() throws Throwable {
		// TODO - Resolve this initialization

	}

	@When("^I click the Sign out button on Instructor DashBoard Page$")
	public void I_click_the_Sign_out_button() throws Throwable {
		ssoDashBoardPage.logout();
	}

	@Then("^I should be able to logout successfully as an Instructor$")
	public void I_should_be_able_to_logout_successfully() throws Throwable {
		Assert.assertTrue("Log out did not work", loginPage.isUserOnLoginPage());
	}

	// ##############################---CreateCourse---####################################
	

	@Given("^I am on the Cengage Learning instructor's sso dashboard$")
	public void i_am_on_the_Cengage_Learning_instructor_welcome_page() {
		
		ssoInstDashBoardPage.isUserOnDashboardPage();
	}

	@When("^I click Create Course hyperlink and navigate to create course page$")
	public void i_click_Create_Course_hyperlink() {

		ssoInstDashBoardPage.clickOnCreateCourseLink();
	}

	@Then("^I select Create a new course option and click on Continue$")
	public void i_select_Create_a_new_course_option() {
		
		createCoursePage.selectCreateNewCourseRadioBtnAndContinue();
	}

	@Then("^I should be navigated to Course Details page and enter course details$")
	public void i_should_be_navigated_to_Course_Details_page() {
		createCoursePage.enterCourseInformation();
	}

	@When("^click Create Course button$")
	public void click_Create_Course_button() {
		createCoursePage.clickOnCreateCourseButton();
	}

	@Then("^course should be created$")
	public void course_should_be_created() {
		Assert.assertTrue("Course creation is failed",
				createCoursePage.CourseIsCreated());
		logPassMessage("");
	}

	@Then("^we save the course info and navigate to dashboard$")
	public void we_save_the_course_key() {
		createCoursePage.getCourseKey();
		createCoursePage.saveCourseNameToFile();
		createCoursePage.saveCourseKeyToFile();
		createCoursePage.clickReturnDashboard();
	}

	// ######################### Accept Eula ######################
	

	@Given("^I click newly created course$")
	public void i_click_newly_created_course() {

		ssoInstDashBoardPage.clickNewCourse();
	}

	@When("^I click newly created course for QAD$")
	public void I_click_newly_created_course_for_QAD() {
		ssoInstDashBoardPage.clickNewCourseQAD();
	}

	@Then("^I am on the MindTap window$")
	public void i_am_on_the_MindTap_window() {
		Assert.assertTrue("MindTap window not displayed",
				eulaPage.isOnMindTapWindow());
		logPassMessage("MindTap window is displayed");

		
		//mindTapDashboard.showInstructorLPN();
	}

	@When("^verify presence of Eula and accept EULA if present$")
	public void verify_presence_of_Eula_and_accept_EULA_if_present() {
		String currentLogin = PropFileHandler.readProperty("CurrentLogin",
				YamlReader.getYamlValue("propertyfilepath"));
		System.out.println(currentLogin);
		
	


		try{
			
			Assert.assertTrue("End User License agreements page not displayed",
			eulaPage.isEndUserLicensePageDisplayed());
			logPassMessage("End User License agreement page displayed successfully");
			flag = true;
		}catch(Exception ex){
			
			logWarningMessage("Eula did not appear");
			flag = false;
			
		}
		if (flag) {
			Assert.assertTrue("MindTap Eula link not displayed",
					eulaPage.isMindTapEulaDisplayed());
			logPassMessage("MindTap Eula link displayed successfully");
			Assert.assertTrue("Knewton Eula link not displayed",
					eulaPage.isKnewtonEulaDisplayed());
			logPassMessage("Knewton Eula link displayed Successfully");
			hardWait(1);
			eulaPage.clickMinTapEula();
			Assert.assertEquals("Mind Tap Eula content not displayed",
					eulaPage.mindTapEulaContent(), "MINDTAP SERVICE AGREEMENT");
			logPassMessage("Content present in MindTap eula");
			hardWait(1);
			eulaPage.clickMindTapBackButton();
			hardWait(1);
			eulaPage.clickKnewtonEula();
			Assert.assertEquals("Knewton Eula content not displayed",
					eulaPage.knewtonEulaContent(), "Knewton Terms of Service");
			logPassMessage("Content present in Knewton Eula");
			hardWait(1);
			eulaPage.clickKnewtonBackButton();
			hardWait(1);
			eulaPage.clickEulaCheckboxes();
			hardWait(1);
			eulaPage.clickAcceptButton();
			hardWait(1);
			logPassMessage("Eulas accepted successfully");
			mindTapLPNPage.clickEnter();
		}
		hardWait(3);
		threeLeggedAuthentication.clickOnEnterButonOnSplashScreen();
		
		
		}

	
	
	@When("^I enter valid (.*) and (.*) and click on login button$")
	public void enterValidCredentials(String username, String password){
		loginPage.login(username, password);
	}
}
