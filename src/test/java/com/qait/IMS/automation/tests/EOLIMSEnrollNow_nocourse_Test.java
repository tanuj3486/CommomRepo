package com.qait.IMS.automation.tests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.qait.IMS.automation.fixture.*;
import com.qait.Domestic.automation.util.*;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EOLIMSEnrollNow_nocourse_Test {
	
	WebDriver driverTest;
	
	EOLEnrollNow_nocourse_Fixture test = new EOLEnrollNow_nocourse_Fixture();
	 
	 String preFix;
	 String Fname;
	 String Lname;
	 String Mail;
	 String EmailExt;
	 String Phone;
	 String Address;
	 String City;
	 String State;
	 String Zip;
	 String DOBmonth;
	 String DOBday;
	 String DOByear;
	 String CreditCardNumber;
	 String CVV;
	 public static String PayScenarioGet;
	 
	 EOLIMSEnrollNow_nocourse_Test()
	 {
		 DateFormat dateFormat = new SimpleDateFormat("ddmmssSSS");
		 Date date = new Date();		 
		 preFix = dateFormat.format(date);
	 }
	
	 
	@BeforeClass
    public void initialsettings() 
    {
        System.out.println("Class : BeforeClass  : ");

        test.setUpDataFile("testData/integration_testData_IMS.yml");
        if (Utilities.getYamlValue("IMSURLEnrollNownocourse.RunType").equalsIgnoreCase("OneIteration")){
        	Utilities.createExcel();
        }
       
        
    }
	
	
	@Test
    public void setup()
    {
        System.out.println("Class : SetUP  : ");

		
		Reporter.log(Utilities.logOutputFile(" ########## Start browser session STARTS ###########"));
        test.startBrowserSession();        
		Reporter.log(Utilities.logOutputFile(" ########## Start browser session ENDS ###########"));

    }
	
	
	@Test(dependsOnMethods = "setup")
    public void launchHomePage() throws InterruptedException
    {
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.launchUrl(test.getYamlVal("appurl"));
		Utilities.hardWait(4);
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

    }
	
	
	@Test(dependsOnMethods = "launchHomePage")
	public void homePageactions()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.verifyHomepage();		
		Reporter.log(Utilities.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

	}
	

	@Test(dependsOnMethods = "homePageactions")
	public void getNumberOfCourseAvailable()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Get Number Of Course Available STARTS ###########"));
		test.getCourseCount();		
		Reporter.log(Utilities.logOutputFile(" ########## Start Get Number Of Course Available ENDS ###########"));


	}
	
	@Test(dependsOnMethods = "getNumberOfCourseAvailable")
	public void selectCourseFromAvailableCourses()
	{		
		if (Utilities.getYamlValue("IMSURLEnrollNownocourse.RunType").equalsIgnoreCase("Selected")){
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));
			//System.out.println("get from yamal and converted ######### " + Utilities.getYamlValue("IMSURLEnrollNownocourse.SelectCourse.Cource"+AllCourse_EOLDomesticEnrollNow_nocourse_Tests.initialCounter).replaceAll("_", ":"));
			test.selectCourse(Utilities.getYamlValue("IMSURLEnrollNownocourse.SelectCourse.Cource"+AllCourse_EOLIMSEnrollNow_nocourse_Tests.initialCounter).replaceAll("_", ":"));				
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));			
		}else{
			if (Utilities.getYamlValue("IMSURLEnrollNownocourse.RunType").equalsIgnoreCase("AllCources")){
				Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));			
				test.selectCourse("");				
				Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));
		}else{
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));			
			test.selectCourse("CHILD DAY CARE MANAGEMENT");				
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));
			
		}
						
		}
		

	}
		
	
	
	@Test(dependsOnMethods = "selectCourseFromAvailableCourses")
	public void verifyElementsPersentOnPersonalInformationPage(){
		test.verifyElementsPersentOnPersonalInformationPage();
	}
	
	
	@Test(dependsOnMethods = "verifyElementsPersentOnPersonalInformationPage")
	public void enterRemaningInformationOnPersonalInformatoinPage() throws IOException
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Information On Personal Informatoin Page STARTS ###########"));

		  Fname = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.FirstName");
		  Lname = Utilities.getFname();
		  Mail = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.Email");
		  EmailExt = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.EmailExt");
		  Phone = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.PrimaryPhone");
		  Address = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.Address");
		  City = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.City");
		  State = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.State");
		  Zip = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.ZIP");		
		  
		DOBmonth = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.DOBmonth");
		DOBday = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.DOBday");
		DOByear = test.getYamlVal("IMSURLEnrollNownocourse.StudentInformation.DOByear");
		test.enterInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "enterRemaningInformationOnPersonalInformatoinPage")
	public void verifyredirectToPaymentInformationPage()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page STARTS ###########"));
		test.redirectToPaymentInformationPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}
	
	
	@Test(dependsOnMethods = "verifyredirectToPaymentInformationPage")
	public void verifyElementsDisplayOnPaymentInformation()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Redirect To Payment Information Page STARTS ###########"));
		test.verifyElemetsDisplayOnPaymentInformationPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Redirect To Payment Information Page ENDS ###########"));

	}
	

		
	
	@Test(dependsOnMethods = "verifyElementsDisplayOnPaymentInformation")
	public void verifyElementsDisplayOnReviewAndSubmitPage()
	{
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information STARTS ###########"));
		test.verifyInformationFieldDisplayOnReviewandSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);	
		Reporter.log(Utilities.logOutputFile(" ########## Start Enter CreditCard Information ENDS ###########"));
	}
	


	@Test(dependsOnMethods = "verifyElementsDisplayOnReviewAndSubmitPage")
	public void verifyandClickOnTermAndComtitionsDisplayOnReviewandSubmitPage()
	{		
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page STARTS ###########"));
		test.clickonTermAndConditionsonReviewandSubmitPage();	
		Reporter.log(Utilities.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page ENDS ###########"));

	}

	
	@AfterClass
    public void tearDown() 
     {
		Reporter.log(Utilities.logOutputFile(" ########## Stop Browser Session ###########"));
		test.stopBrowserSession();
     }	
	
}

