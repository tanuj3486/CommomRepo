package com.gale.knewton.StepDefs;

import java.io.IOException;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_3LeggedAuthentication extends BaseTest{


	String heading;

	@Then ("^I should see authentication panel$")
	public void I_should_see_authentication_panel(){
		Assert.assertTrue("3 legged authentication panel did not appear", threeLeggedAuthentication.verify3LeggedAuthenticationPanel());
	}

	@Then ("^I should see Login form and sign in message$")
	public void I_should_see_Login_form_and_sign_in_message(){
		Assert.assertTrue("Login form  does not appear on authentication panel", threeLeggedAuthentication.verifyLoginFormWithintheAuthenticationPanel());
		Assert.assertTrue("the login messege for knewton 3 legged authentication panel did not appear", threeLeggedAuthentication.verifyLoginMessege());
	}

	@Then ("^I should see Sign up link on the authentication panel$")
	public void I_should_see_Sign_up_link_on_the_authentication_panel(){
		Assert.assertTrue("Signup link is did not appear on 3 legged authentication panel",threeLeggedAuthentication.verifySignUpLinkOnThePanel());
	}

	@Then ("^I should see submit button within the authentication panel$")
	public void I_should_see_submit_button_within_the_authentication_panel(){
		Assert.assertTrue("Submit button did not appear on 3 legged authentication panel", threeLeggedAuthentication.cerifySubmitButtonOnThePanel());
	}
	@When ("^I click on Sign up button$")
	public void I_click_on_Sign_up_button(){
		threeLeggedAuthentication.clickOnSignUpButton();
	}

	@Then("^I should See create knewton profile messege$")
	public void I_should_See_create_knewton_profile_messege(){
		Assert.assertTrue("Create new profile messege did not appear",threeLeggedAuthentication.verifySignUpMessege());
	}

	@Then("^I See Sign in button$")
	public void I_See_Sign_in_button(){
		Assert.assertTrue("Sigin in blink did not appear on the authentication panel", threeLeggedAuthentication.verifySignInLink());
	}

	@When("^I click on Sign in button$")
	public void I_click_on_Sign_in_button(){
		threeLeggedAuthentication.clickOnSignInButton();
	}
	@Then("^I should be able to see loading screen processing,please wait$")
	public void I_Should_Be_Able_To_See_Loading_Screen()
	{
		threeLeggedAuthentication.verifyLoadingScreenWhenOpeningNewCourse();
	}
	@Then("^I should not be able to see loading screen processing,please wait$")
	public void I_Should_Not_Be_Able_To_See_Loading_Screen()
	{
		threeLeggedAuthentication.verifyAbsenceOfLoadingScreenWhenOpeningOldCourse();
	}
	@And("^I should not be able to see 3Legged authentication screen$")
	public void And_I_Should_Not_Be_Able_To_See_3Legged_Authentication_Screen()
	{
		threeLeggedAuthentication.verifyAbsenceOf3LeggedAuthenticationPanel();
	}

	@When("^I click on Enter button on splash screen$")
	public void I_Click_On_Enter_Button_On_Splash_Screen(){
		threeLeggedAuthentication.clickOnEnterButonOnSplashScreen();
	}
	@Then("^I click on disable dashborad$")
	public void I_click_on_disable_dashboard()
	{

		mindTapDashboard.disableDashboard();

	}
}


