package com.gale.knewton.StepDefs;

import org.junit.Assert;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.en.And;

public class Stepdefs_studentTakesInlineAssessment extends BaseTest{

	@And("^LPN score is displayed on Inline Simple Assessment activity link$")
	public void lpn_score_is_displayed_on_inline_simple_assessment_activity_link()
	{
		mindTapLPNPage.expandInlineOnLPN();
		Assert.assertFalse("lpn score not displayed at Inline Simple Assessment activity link", mindTapLPNPage.getInlineSimpleAssessmentLpnScore().isEmpty());
		logPassMessage("lpn score displayed successfully at Inline Simple Assessment activity link");
		PropFileHandler.writeToFile("InlineSALpnScore", mindTapLPNPage.getInlineSimpleAssessmentLpnScore(), 
				   (YamlReader.getData("propertyfilepath")));
		mindTapLPNPage.navigateToBaseLPN();
	}
}
