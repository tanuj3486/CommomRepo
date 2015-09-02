package com.qait.Domestic.automation.fixture;



import org.junit.Assert;

public class EOLDomesticReceiveInfo_Fixture  extends EOLDomesticReceiveInfo_nocourse_Fixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		DomReciveInfo.navigateToDomesticURLReciveInformationNoCource();
				
	}
	
	
	public void verifyElementsDisplayOnStep1()
	{
		DomReciveInfo.varifyPageElementsForStep1();
	}
	
	
	public void enterStudentInformationInStep1Form(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip)
	{
		DomReciveInfo.fillFormStep1ForDomestic(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip);
		
	}
	
	
	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink()
	{
		DomReciveInfo.verifyThnakYouPageAfterStep1FormPage();
	}
	
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		DomReciveInfo.verifyPersonalInformationPage();
	}
	
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		DomReciveInfo.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	
	public void redirectToPaymentInformationPage()
	{
		DomReciveInfo.verificationPaymentInformationPage();
	}

	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		DomReciveInfo.verifyElemetsOnPaymentInformationPage();
	}
	
	
	public void selectPaymentModeAndEnterCardInformation()
	{
		Assert.assertTrue(DomReciveInfo.selectfullpaymentmodeOnPaymentInformationPage());
	}

	
	public void verifyElementDisplayAfterCreditCardSelection()
	{
		DomReciveInfo.verifyElementOnCreditCardSectionOnPaymentInformationPage();
	}

	
	public void enterCreditCardInformationAfterCreditCardSelection(String CreditCardNumber, String CVV)
	{
		DomReciveInfo.enterCreditCardInformationSectionOnPaymentInformationPage(CreditCardNumber, CVV);
	}
	
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		DomReciveInfo.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}

	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		DomReciveInfo.acceptTermandConditionOnReviewAndSubmitPage();
	}

	
}
