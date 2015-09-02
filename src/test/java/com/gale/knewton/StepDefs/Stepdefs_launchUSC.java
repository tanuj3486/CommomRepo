package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs_launchUSC extends BaseTest{

	private static String nameOfUnitClickedOnLPN;
	
	@Given("^I should be on chapter LPN$")
	public void i_should_be_on_chapter_LPN(){
		
	 nameOfUnitClickedOnLPN = mindTapLPNPage.navigateToChapterLPN();
		Assert.assertTrue("Chapter LPN not displayed", mindTapLPNPage.isUSCLinkDisplayed(nameOfUnitClickedOnLPN));
		logPassMessage("Chapter LPN displayed successfully");	  
	}
	
	@When("^I click on USC link$")
	public void i_click_on_USC_link() throws Throwable {
		mindTapLPNPage.clickUSCActivity();
	}

	@Then("^I should be navigated to USC page and error message displayed as (.*)$")
	public void i_should_be_navigated_to_USC_page(String Error){
		Assert.assertTrue("Incorrect error message is displayed",escActivity.isErrorDisplayed(Error));
		logPassMessage("Error message is displayed successfully on ESC activity page");
		uscActivitypage.closeUSCActivity();
		mindTapLPNPage.navigateToBaseLPN();
		
	}
	@When("^I click on unit chapter link then i can see Unit study center link on Unit page$")
	public void i_click_on_unit_chapter_link_And_Navigate_To_Unit_Page(){
		Assert.assertTrue("Unit Study Center link not displayed", mindTapLPNPage.isUSCLinkDisplayed(nameOfUnitClickedOnLPN));
	}
	
}
