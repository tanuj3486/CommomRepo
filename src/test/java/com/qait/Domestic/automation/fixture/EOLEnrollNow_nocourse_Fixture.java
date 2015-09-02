package com.qait.Domestic.automation.fixture;




public class EOLEnrollNow_nocourse_Fixture  extends EOLDomesticReceiveInfo_Fixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		DomEnrollNowNoCourse.navigateToDomesticURLReciveInformationNoCource();
	}
		
	
	public int getCourseCount()
	{
		CourseCount = DomEnrollNowNoCourse.getCourseCountFromPannFosterPage();
		return CourseCount;
	}

	public void selectCourse(String Cource)
	{
		DomEnrollNowNoCourse.selectCourseFromPannFosterPage(Cource);
	}
	
	
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		DomEnrollNowNoCourse.verifyPersonalInformationPage();
	}
	
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
													String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		DomEnrollNowNoCourse.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone,
																	Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	
	public void redirectToPaymentInformationPage()
	{
		DomEnrollNowNoCourse.verificationPaymentInformationPage();
	}

	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		DomEnrollNowNoCourse.verifyElemetsOnPaymentInformationPage();
	}
	
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		DomEnrollNowNoCourse.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}

	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		DomEnrollNowNoCourse.acceptTermandConditionOnReviewAndSubmitPage();
	}
	
	public void clickPersonalInfoEditButtonOnReviewAndSubmit() {
		PanFoster.clickPersonalInfoEditButtonOnReviewAndSubmit();
	}

	public void clickProgramInfoEditButtonOnReviewAndSubmit() {
		PanFoster.clickProgramInfoEditButtonOnReviewAndSubmit();
	}

	public void clickPaymentInfoEditButtonOnReviewAndSubmit() {
		PanFoster.clickPaymentInfoEditButtonOnReviewAndSubmit();
	}

	
}
