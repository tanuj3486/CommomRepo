package com.qait.Canada.automation.fixture;

public class EOLCanadaEnrollNow_nocourse_Fixture extends BaseFixture{
	
static int CourseCount;
	
	

	public void verifyHomepage()
	{
		CanEnrollNow.navigateToCanadaURLReciveInformationNoCource();
				
	}
	
	public int getCourseCount()
	{
		CourseCount = CanEnrollNow.getCourseCountFromICSCanadaPage();
		return CourseCount;
	}

	public void selectCourse(String Course)
	{
		CanEnrollNow.selectCourseFromICSCanadaPage(Course);
	}
	
//	public void verifyElementsDisplayOnStep1()
//	{
//		CanEnrollNow.varifyPageElementsForStep1();
//	}
//	
//	public void enterStudentInformationInStep1Form(String preFix, String Fname, String Lname, 
//			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip)
//	{
//		CanEnrollNow.fillFormStep1ForCanada(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip);
//		
//	}
//	
//	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink()
//	{
//		CanEnrollNow.verifyThnakYouPageAfterStep1FormPage();
//	}
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		CanEnrollNow.verifyPersonalInformationPage();
	}
	
//	public void enterInformationOnPersonalInformationPage(String DOBmonth, String DOBday, String DOByear)
//	{
//		CanEnrollNow.enterExtraInformationOnPersonalInformationPage(DOBmonth, DOBday, DOByear);
//	}
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		CanEnrollNow.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}
	
	public void enterInformationAfterEditOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		CanEnrollNow.enterExtraInformationAfterEditOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	public void redirectToPaymentInformationPage()
	{
		CanEnrollNow.verificationPaymentInformationPage();
	}

	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		CanEnrollNow.verifyElemetsOnPaymentInformationPage();
	}
	

	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage()
	{
		CanEnrollNow.verifyElementsOnReviewAndSubmitPage();
	}
	
	public void clickPersonalInfoEditButtonOnReviewAndSubmit()
    {
		CanEnrollNow.clickPersonalInfoEditButtonOnReviewAndSubmit();
    }
    
    public void clickProgramInfoEditButtonOnReviewAndSubmit()
    {
    	CanEnrollNow.clickProgramInfoEditButtonOnReviewAndSubmit();
    }
    
    public void clickPaymentInfoEditButtonOnReviewAndSubmit()
    {
    	CanEnrollNow.clickPaymentInfoEditButtonOnReviewAndSubmit();
    }

	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		CanEnrollNow.acceptTermandConditionOnReviewAndSubmitPage();
	}

}
