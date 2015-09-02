package com.qait.Domestic.automation.fixture;



import org.junit.Assert;

public class EOLEnrollNow_Fixture  extends EOLDomesticReceiveInfo_Fixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		DomEnrollNow.navigateToDomesticURLReciveInformationNoCource();
				
	}
		
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		DomEnrollNow.verifyPersonalInformationPage();
	}
	
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
													String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		DomEnrollNow.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone,
																	Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	
	public void redirectToPaymentInformationPage()
	{
		DomEnrollNow.verificationPaymentInformationPage();
	}

	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		DomEnrollNow.verifyElemetsOnPaymentInformationPage();
	}
	
	
	public void selectPaymentModeAndEnterCardInformation()
	{
		Assert.assertTrue(DomEnrollNow.selectfullpaymentmodeOnPaymentInformationPage());
	}

	
	public void verifyElementDisplayAfterCreditCardSelection()
	{
		DomEnrollNow.verifyElementOnCreditCardSectionOnPaymentInformationPage();
	}

	
	public void enterCreditCardInformationAfterCreditCardSelection(String CreditCardNumber, String CVV)
	{
		DomEnrollNow.enterCreditCardInformationSectionOnPaymentInformationPage(CreditCardNumber, CVV);
	}
	
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		DomEnrollNow.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}

	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		DomEnrollNow.acceptTermandConditionOnReviewAndSubmitPage();
	}

	
}
