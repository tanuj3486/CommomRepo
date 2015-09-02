package com.gale.knewton.StepDefs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.gale.knewton.base.BaseTest;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com/gale/knewton/features_critical/08_Manual_Gradable.feature", tags = { "@SmokeAndersen"
// + "@StuLaunchSubmitDistnct, @StuLaunchSubmitInline, @StuLaunchSubmitSAA"
},
// dryRun = true,
format = { "pretty", "html:target/cucumber", "json:target/cucumber.json" })
/*
 * Cucumber tags Instructor: @LogincreateLaunch, @LoginLaunch Student:
 * 
 * @LoginEnrollAndAcceptEula, @StudentLoginAndLaunchCourse Assessment:
 * 
 * @AccessAssessmentSA, @LaunchSubmitSA, @StuLaunchSubmitDistnct Inline
 * Assessment: @StuLaunchSubmitInline, @LaunchSubmitInlineSA,
 * 
 * @AccessinlineSAAndlinkToEBook ESC: @AccessESCandLinkToLPN, @InstLaunchESC,
 * 
 * @StudLaunchESC, @StuVerifyESC, @StuClosesESC SAA: @AccessAssessmentSA,SaaActivity_1429687875540 
 * 
 * @InstLaunchSubmitSAA, @StuLaunchSubmitSAA USC: @InstAccessLaunchUSC,
 * 
 * @StuTakesUSC Progress App: @StuProgressApp Student Reviews:
 * 
 * @StuReviewActivity Inst Progress app: @InstProgressApp
 */
public class Test_SpecificFeature {
	@BeforeClass
	public static void classSetup() {
		BaseTest.setUp(System.getProperty("environment"));
	}

	//@AfterClass
	public static void classTeardown() {
		BaseTest.tearDown();
	}

}