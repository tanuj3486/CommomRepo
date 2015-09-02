package com.qait.Canada.automation.fixture;


public class EOLCanadaReceiveInfo_nocourse_Fixture extends BaseFixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		ICSCanada.navigateToCanadaURLReciveInformationNoCource();
				
	}
	
	public int getCourseCount()
	{
		CourseCount = ICSCanada.getCourseCountFromICSCanadaPage();
		return CourseCount;
	}

	public void selectCourse(String Course)
	{
		ICSCanada.selectCourseFromICSCanadaPage(Course);
	}
	
	public void verifyElementsDisplayOnStep1()
	{
		ICSCanada.varifyPageElementsForStep1();
	}
	
	public void enterStudentInformationInStep1Form(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip)
	{
		ICSCanada.fillFormStep1ForCanada(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip);
		
	}
	
	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink()
	{
		ICSCanada.verifyThnakYouPageAfterStep1FormPage();
	}
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		ICSCanada.verifyPersonalInformationPage();
	}
	
//	public void enterInformationOnPersonalInformationPage(String DOBmonth, String DOBday, String DOByear)
//	{
//		ICSCanada.enterExtraInformationOnPersonalInformationPage(DOBmonth, DOBday, DOByear);
//	}
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		ICSCanada.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}
	
	public void enterInformationAfterEditOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		ICSCanada.enterExtraInformationAfterEditOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	public void redirectToPaymentInformationPage()
	{
		ICSCanada.verificationPaymentInformationPage();
	}

	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		ICSCanada.verifyElemetsOnPaymentInformationPage();
	}
	

	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage()
	{
		ICSCanada.verifyElementsOnReviewAndSubmitPage();
	}
	
	public void clickPersonalInfoEditButtonOnReviewAndSubmit()
    {
		ICSCanada.clickPersonalInfoEditButtonOnReviewAndSubmit();
    }
    
    public void clickProgramInfoEditButtonOnReviewAndSubmit()
    {
    	ICSCanada.clickProgramInfoEditButtonOnReviewAndSubmit();
    }
    
    public void clickPaymentInfoEditButtonOnReviewAndSubmit()
    {
    	ICSCanada.clickPaymentInfoEditButtonOnReviewAndSubmit();
    }

	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		ICSCanada.acceptTermandConditionOnReviewAndSubmitPage();
//		PanFoster.redirectTOElectronicSignaturePage();
	}

}
