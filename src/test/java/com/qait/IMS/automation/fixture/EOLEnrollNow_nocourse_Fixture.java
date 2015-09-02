package com.qait.IMS.automation.fixture;

public class EOLEnrollNow_nocourse_Fixture  extends BaseFixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		IMSEnrollNowNoCourse.navigateToDomesticURLReciveInformationNoCource();
	}
		
	
	public int getCourseCount()
	{
		CourseCount = IMSEnrollNowNoCourse.getCourseCountFromPannFosterPage();
		return CourseCount;
	}

	public void selectCourse(String Cource)
	{
		IMSEnrollNowNoCourse.selectCourseFromPannFosterPage(Cource);
	}
	
	
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		IMSEnrollNowNoCourse.verifyPersonalInformationPage();
	}
	
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
													String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		IMSEnrollNowNoCourse.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone,
																	Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	
	public void redirectToPaymentInformationPage()
	{
		IMSEnrollNowNoCourse.verificationPaymentInformationPage();
	}

	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		IMSEnrollNowNoCourse.verifyElemetsOnPaymentInformationPage();
	}
	
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		IMSEnrollNowNoCourse.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}

	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		IMSEnrollNowNoCourse.acceptTermandConditionOnReviewAndSubmitPage();
	}
	
	

	
}
