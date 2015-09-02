package com.qait.Domestic.automation.tests;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.qait.Domestic.automation.fixture.*;
import com.qait.Domestic.automation.util.*;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EOLDomesticReceiveInfo_nocourse_Test {

	WebDriver driverTest;

	EOLDomesticReceiveInfo_nocourse_Fixture test = new EOLDomesticReceiveInfo_nocourse_Fixture();

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

	EOLDomesticReceiveInfo_nocourse_Test() {
		DateFormat dateFormat = new SimpleDateFormat("ddmmssSSS");
		Date date = new Date();
		preFix = dateFormat.format(date);
	}

	@BeforeClass
	public void initialsettings() {
		test.setUpDataFile("./testData/integration_testData_Domestic.yml");
		if (Utilities.getYamlValue(
				"DomesticURLReceiveInformationnocourse.RunType")
				.equalsIgnoreCase("OneIteration")) {
			Utilities.createExcel();
		}

	}

	@Test
	public void setup() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start browser session STARTS ###########"));
		test.startBrowserSession();
		Utilities.hardWait(5);
		Reporter.log(Utilities
				.logOutputFile(" ########## Start browser session ENDS ###########"));

	}

	@Test(dependsOnMethods = "setup")
	public void launchHomePage() throws InterruptedException {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.launchUrl(test.getYamlVal("appurl"));
		Utilities.hardWait(4);
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "launchHomePage")
	public void homePageactions() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Launch Home Page STARTS ###########"));
		test.verifyHomepage();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Launch Home Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "homePageactions")
	public void getNumberOfCourseAvailable() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Get Number Of Course Available STARTS ###########"),true);
		test.getCourseCount();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Get Number Of Course Available ENDS ###########"),true);

	}

	@Test(dependsOnMethods = "getNumberOfCourseAvailable")
	public void selectCourseFromAvailableCourses() 
	{ 	System.out.println("Selecting course*********************");
		if (Utilities.getYamlValue("DomesticURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")) {
			Reporter.log(Utilities.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"),true);
			System.out.println("Value of yaml course ***********"+"DomesticURLReceiveInformationnocourse.SelectCourse.Cource"+AllCourse_EOLDomesticReceiveInfo_nocourse_Tests.initialCounter);
			//AllCourse_EOLDomesticReceiveInfo_nocourse_Tests.initialCounter
			test.selectCourse(Utilities.getYamlValue("DomesticURLReceiveInformationnocourse.SelectCourse.Cource"+"1").replaceAll("_",":"));
			Reporter.log(Utilities
					.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"),true);
		} else {
			if (Utilities.getYamlValue(
					"DomesticURLReceiveInformationnocourse.RunType")
					.equalsIgnoreCase("AllCources")) {
				Reporter.log(Utilities
						.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));
				test.selectCourse("");
				Reporter.log(Utilities
						.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));
			} else {
				Reporter.log(Utilities
						.logOutputFile(" ########## Start Select Course From Available Courses STARTS ###########"));
				test.selectCourse("ADMINISTRATIVE ASSISTANT");

				Reporter.log(Utilities
						.logOutputFile(" ########## Start Select Course From Available Courses ENDS ###########"));

			}

		}

	}

	@Test(dependsOnMethods = "selectCourseFromAvailableCourses")
	public void verifyElementsDisplayOnStep1EnrollmentProcess() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Elements Display On Step1 Enrollment Process STARTS ###########"));
		test.verifyElementsDisplayOnStep1();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Elements Display On Step1 Enrollment Process ENDS ###########"));

	}

	@Test(dependsOnMethods = "verifyElementsDisplayOnStep1EnrollmentProcess")
	public void enterStudentInformationOnStep1Page() throws IOException {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Student Information On Step1 Page STARTS ###########"));

		Fname = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.FirstName");
		Lname = Utilities.getFname();
		Mail = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.Email");
		EmailExt = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.EmailExt");
		Phone = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.PrimaryPhone");
		Address = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.Address");
		City = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.City");
		State = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.State");
		Zip = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.ZIP");

		test.enterStudentInformationInStep1Form(preFix, Fname, Lname, Mail,
				EmailExt, Phone, Address, City, State, Zip);
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Student Information On Step1 Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "enterStudentInformationOnStep1Page")
	public void redirectToThankYouPageAndClickEnrollOnLine() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Redirect To ThankYou Page And Click Enroll OnLine STARTS ###########"));
		test.verifyRedirectToThnakyouPageandClickonEnrollOnlineLink();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Redirect To ThankYou Page And Click Enroll OnLine ENDS ###########"));

	}

	@Test(dependsOnMethods = "redirectToThankYouPageAndClickEnrollOnLine")
	public void verifyElementDisplayOnPersonalInformationPage() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Element Display On Personal Information Page STARTS ###########"));
		test.verifyElementsPersentOnPersonalInformationPage();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Element Display On Personal Information Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "verifyElementDisplayOnPersonalInformationPage")
	public void enterRemaningInformationOnPersonalInformatoinPage() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page STARTS ###########"));
		DOBmonth = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.DOBmonth");
		DOBday = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.DOBday");
		DOByear = test
				.getYamlVal("DomesticURLReceiveInformationnocourse.StudentInformation.DOByear");
		test.enterInformationOnPersonalInformationPage(preFix, Fname, Lname,
				Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth,
				DOBday, DOByear);
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "enterRemaningInformationOnPersonalInformatoinPage")
	public void verifyredirectToPaymentInformationPage() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page STARTS ###########"));
		test.redirectToPaymentInformationPage();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter Remaning Information On Personal Informatoin Page ENDS ###########"));

	}

	@Test(dependsOnMethods = "verifyredirectToPaymentInformationPage")
	public void verifyElementsDisplayOnPaymentInformation() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Redirect To Payment Information Page STARTS ###########"));
		test.verifyElemetsDisplayOnPaymentInformationPage();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Redirect To Payment Information Page ENDS ###########"));

	}


	@Test(dependsOnMethods = "verifyElementsDisplayOnPaymentInformation")
	public void verifyElementsDisplayOnReviewAndSubmitPage() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter CreditCard Information STARTS ###########"));
		test.verifyInformationFieldDisplayOnReviewandSubmitPage(preFix, Fname,
				Lname, Mail, EmailExt, Phone, Address, City, State, Zip,
				DOBmonth, DOBday, DOByear);
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Enter CreditCard Information ENDS ###########"));

	}

	@Test(dependsOnMethods = "verifyElementsDisplayOnReviewAndSubmitPage")
	public void verifyEditButtonOnReviewAndSubmit() {
		if (Utilities.getYamlValue("DomesticURLReceiveInformationnocourse.RunType")
				.equalsIgnoreCase("AllCources")) {
			Reporter.log(Utilities
					.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page STARTS ###########"));
			Reporter.log(Utilities
					.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page ENDS ###########"));
		} else {
			Reporter.log(Utilities
					.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page STARTS ###########"));
			
			if(!PayScenarioGet.contains("Pay By Mail")){
				test.clickPersonalInfoEditButtonOnReviewAndSubmit();
				test.enterInformationAfterEditOnPersonalInformationPage(preFix,
						Fname, Lname, Mail, EmailExt, Phone, Address, City, State,
						Zip, DOBmonth, DOBday, DOByear);
				verifyredirectToPaymentInformationPage();
				verifyElementsDisplayOnPaymentInformation();
				
				test.clickProgramInfoEditButtonOnReviewAndSubmit();
				verifyredirectToPaymentInformationPage();
				verifyElementsDisplayOnPaymentInformation();
				
				test.clickPaymentInfoEditButtonOnReviewAndSubmit();
				verifyredirectToPaymentInformationPage();
				verifyElementsDisplayOnPaymentInformation();
			}

			
			Reporter.log(Utilities
					.logOutputFile(" ########## Start Verify Edit botton On Review and Submit Page ENDS ###########"));
		}
	}

	@Test(dependsOnMethods = "verifyEditButtonOnReviewAndSubmit")
	public void verifyandClickOnTermAndComtitionsDisplayOnReviewandSubmitPage() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page STARTS ###########"));
		test.clickonTermAndConditionsonReviewandSubmitPage();
		Reporter.log(Utilities
				.logOutputFile(" ########## Start Verify Elements Display On Review and Submit Page ENDS ###########"));

	}

	@AfterClass
	public void tearDown() {
		Reporter.log(Utilities
				.logOutputFile(" ########## Stop Browser Session ###########"));
		System.out.println("**********************************************Closing browser session******************");
		test.stopBrowserSession();
	}

}
