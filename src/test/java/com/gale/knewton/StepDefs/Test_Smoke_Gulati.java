package com.gale.knewton.StepDefs;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.gale.knewton.base.BaseTest;
import com.gale.knewton.util.Emailer;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions( 
		features="src/test/resources/com/gale/knewton/features_smoke",
		tags={"@report"},
		//dryRun = true,
		snippets = SnippetType.UNDERSCORE,
		format = {"pretty" ,"html:target/cucumber","json:target/cucumber.json"})
    
public class Test_Smoke_Gulati {
		
	@BeforeClass
	public static void classSetup() {
		BaseTest.setUp(System.getProperty("environment"));
	}

	@AfterClass
	public static void classTeardown() throws AddressException, MessagingException, IOException {
		
		Emailer e = new Emailer("Knewton", "recepient");
		System.out.println("In Email now");
		e.sendResultsMail();
		BaseTest.tearDown();
	}
	
}	