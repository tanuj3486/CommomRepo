package com.qait.Domestic.automation.fixture;



import org.junit.Assert;

public class SiteCoreULR_Feature_Fixture extends EOLDomesticReceiveInfo_Fixture {
		
	static int CourseCount;
	
	

	public void verifyNavigatedtoSiteCoreHomepage()
	{
				SiteCore.verifyUserNavigatedtoSiteCoreHomepage();
	}
	
	public void verifyUserNavigatedtoEnrollNowSiteCoreHomepage()
	{
				SiteCore.verifyUserNavigatedtoEnrollNowSiteCoreHomepage();
	}
		
	public void verifyElementsDisplayOnStep1() {
		SiteCore.varifyPageElementsForStep1();
	}

	public void enterStudentInformationInStep1Form(String preFix, String Fname,
	String Lname, String Mail, String EmailExt, String Phone,
	String Address, String City, String State, String Zip) {
		SiteCore.fillFormStep1ForDomestic(preFix, Fname, Lname, Mail,
				EmailExt, Phone, Address, City, State, Zip);
	}

	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink() {
		SiteCore.verifyThnakYouPageAfterStep1FormPage();
	}
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		SiteCore.verifyPersonalInformationPage();
	}
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		SiteCore.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}
	
	public void redirectToPaymentInformationPage()
	{
		SiteCore.verificationPaymentInformationPage();
	}
	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		SiteCore.verifyElemetsOnPaymentInformationPage();
	}
	
	public void selectPaymentModeAndEnterCardInformation()
	{
		Assert.assertTrue(SiteCore.selectfullpaymentmodeOnPaymentInformationPage());
	}
	
	public void verifyElementDisplayAfterCreditCardSelection()
	{
		SiteCore.verifyElementOnCreditCardSectionOnPaymentInformationPage();
	}
	
	public void enterCreditCardInformationAfterCreditCardSelection(String CreditCardNumber, String CVV)
	{
		SiteCore.enterCreditCardInformationSectionOnPaymentInformationPage(CreditCardNumber, CVV);
	}
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		SiteCore.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}
	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		SiteCore.acceptTermandConditionOnReviewAndSubmitPage();
	}
	
	public void clickonTermAndConditionsonReviewandSubmitPageForEnroll()
	{
		SiteCore.acceptTermandConditionOnReviewAndSubmitPageForEnroll();
	}
	
}
