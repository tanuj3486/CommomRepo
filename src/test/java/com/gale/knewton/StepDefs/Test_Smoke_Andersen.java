package com.gale.knewton.StepDefs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gale.knewton.base.BaseTest;




import com.gale.knewton.util.Emailer;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features="src/test/resources/com/gale/knewton/features_smoke",
tags={"@SmokeAndersen"},
format = {"pretty" ,"html:target/cucumber","json:target/cucumber.json"})
     
public class Test_Smoke_Andersen {
	@BeforeClass
	public static void classSetup() {
		BaseTest.setUp(System.getProperty("environment"));
	}

	@AfterClass
	public static void classTeardown() {
		BaseTest.tearDown();
	}
	
}	