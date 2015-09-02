package com.gale.knewton.pageObjects;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.Select;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ThreeLeggedAuthentication extends BaseWebComponent {

	String courseKey;

	private String panel_3leggedAuthentication_css = "#knewtonLogin";
	private String loginForm_css = "#login";
	private String loginMessage = "#login .title";
	private String authentication_frame_css = "iframe";
	private String lnk_signup_css = ".create-account a";
	private String btn_submit_css = "#login-form .actions>button";
	private String signupMessege_css = "#register .title";
	private String lnk_Signin_css =".sign-in .link";
	private String frame_loading_window_css = "#knewtonLogin>iframe";
	private String txt_loading_screen_xpath = "//h1[contains(.,'Processing, Please Wait')]";
	private String btn_enter_splash_screen_css = "#nb_enter";

	public boolean verify3LeggedAuthenticationPanel(){
		return waitAndLocateElementByCss(panel_3leggedAuthentication_css).isDisplayed();

	}

	public boolean verifyLoginFormWithintheAuthenticationPanel(){
		switchToFrame(findElementByCssPath(authentication_frame_css));
		return waitAndLocateElementByCss(loginForm_css).isDisplayed();
	}

	public boolean verifyLoginMessege(){
		boolean flag ;
		String messege = waitAndLocateElementByCss(loginMessage).getText();
		String expectedMessege= YamlReader.getYamlValue("3leggedAuthentication.signinMessege");
		flag = messege.contains(expectedMessege);
		switchToDefaultContent();
		return flag;
	}

	public boolean verifySignUpLinkOnThePanel(){
		boolean flag;
		switchToFrame(findElementByCssPath(authentication_frame_css));
		flag= waitAndLocateElementByCss(lnk_signup_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public boolean cerifySubmitButtonOnThePanel(){
		boolean flag;
		switchToFrame(findElementByCssPath(authentication_frame_css));
		flag = waitAndLocateElementByCss(btn_submit_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void clickOnSignUpButton(){
		switchToFrame(findElementByCssPath(authentication_frame_css));
		waitAndLocateElementByCss(lnk_signup_css).click();
		switchToDefaultContent();
	}

	public boolean verifySignUpMessege(){
		boolean flag;
		switchToFrame(findElementByCssPath(authentication_frame_css));
		String messege= waitAndLocateElementByCss(signupMessege_css).getText();
		String expectedMessege = YamlReader.getYamlValue("3leggedAuthentication.signupMessege");
		flag = messege.contains(expectedMessege);
		switchToDefaultContent();
		return flag;

	}

	public boolean verifySignInLink(){
		boolean flag;
		switchToFrame(findElementByCssPath(authentication_frame_css));
		flag= waitAndLocateElementByCss(lnk_Signin_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void clickOnSignInButton(){
		switchToFrame(findElementByCssPath(authentication_frame_css));
		waitAndLocateElementByCss(lnk_Signin_css).click();
		switchToDefaultContent();
	}

	public void verifyLoadingScreenWhenOpeningNewCourse() {
		try
		{
			switchToDefaultContent();
			switchToFrameByIndex(0);
			findElementByXpath(txt_loading_screen_xpath).isDisplayed();
		}
		catch(StaleElementReferenceException e)
		{
			hardWait(1);
			switchToFrame(findElementByCssPath(frame_loading_window_css));
			findElementByXpath(txt_loading_screen_xpath).isDisplayed();
		}
		catch(NoSuchElementException e1)
		{
			switchToFrame(findElementByCssPath(frame_loading_window_css));
			findElementByXpath(txt_loading_screen_xpath).isDisplayed();
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}

		switchToDefaultContent();
	}

	public void clickOnEnterButonOnSplashScreen() {
		waitAndLocateElementsByCss(btn_enter_splash_screen_css);
		findElementByCssPath(btn_enter_splash_screen_css).click();

	}

	public void verifyAbsenceOfLoadingScreenWhenOpeningOldCourse() {
	
	Assert.assertFalse("Element is displayed",findElementByCssPath(frame_loading_window_css).isDisplayed());
	Assert.assertFalse("Element is displayed",findElementByCssPath(txt_loading_screen_xpath).isDisplayed());
	}

	public void verifyAbsenceOf3LeggedAuthenticationPanel() {
		Assert.assertFalse("Authentication panel is Showed",findElementByCssPath(panel_3leggedAuthentication_css).isDisplayed());
	}
}