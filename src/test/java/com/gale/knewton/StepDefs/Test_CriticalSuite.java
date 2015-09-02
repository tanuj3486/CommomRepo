package com.gale.knewton.StepDefs;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.log4j.BasicConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

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
		features="src/test/resources/com/gale/knewton/features_critical",
		tags={"@LCconfig"},
		//dryRun = true,
		snippets = SnippetType.UNDERSCORE,
		format = {"pretty" ,"html:target/cucumber","json:target/cucumber.json"})
    
public class Test_CriticalSuite {
	
	@BeforeClass
	public static void classSetup(){
		//BasicConfigurator.configure();
		//PrintStream printStream = new PrintStream(new FileOutputStream("D:/lo.log"));
		//System.setOut(printStream);
		BaseTest.setUp(System.getProperty("environment"));
		
	}

	@AfterClass
	public static void classTeardown(){
		BaseTest.tearDown();
	}
	
}	


