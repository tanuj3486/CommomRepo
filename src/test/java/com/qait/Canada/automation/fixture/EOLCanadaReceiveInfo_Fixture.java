package com.qait.Canada.automation.fixture;


//import com.jav.Canada.fixture.*;

import org.junit.Assert;

public class EOLCanadaReceiveInfo_Fixture  extends EOLCanadaReceiveInfo_nocourse_Fixture {
		
	static int CourseCount;
	
	

	public void verifyHomepage()
	{
		CanReciveInfo.navigateToCanadaURLReciveInformation();
				
	}
	
	
	public void verifyElementsDisplayOnStep1()
	{
		CanReciveInfo.varifyPageElementsForStep1();
	}
	
	
	public void enterStudentInformationInStep1Form(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip)
	{
		CanReciveInfo.fillFormStep1ForCanada(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip);
		
	}
	
	
	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink()
	{
		CanReciveInfo.verifyThnakYouPageAfterStep1FormPage();
	}
	
	
	public void verifyElementsPersentOnPersonalInformationPage()
	{
		CanReciveInfo.verifyPersonalInformationPage();
	}
	
	
	public void enterInformationOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		CanReciveInfo.enterExtraInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}
        
        public void enterInformationAfterEditOnPersonalInformationPage(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear)
	{
		CanReciveInfo.enterExtraInformationAfterEditOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
	}

	
	public void redirectToPaymentInformationPage()
	{
		CanReciveInfo.verificationPaymentInformationPage();
	}

	
	public void verifyElemetsDisplayOnPaymentInformationPage()
	{
		CanReciveInfo.verifyElemetsOnPaymentInformationPage();
	}
	
	
	public void selectPaymentModeAndEnterCardInformation()
	{
//                System.out.println("boolean is " +CanReciveInfo.selectfullpaymentmodeOnPaymentInformationPage());
		Assert.assertTrue(CanReciveInfo.selectfullpaymentmodeOnPaymentInformationPage());
	}

	
	public void verifyElementDisplayAfterCreditCardSelection()
	{
		CanReciveInfo.verifyElementOnCreditCardSectionOnPaymentInformationPage();
	}

	
	public void enterCreditCardInformationAfterCreditCardSelection(String CreditCardNumber, String CVV)
	{
		CanReciveInfo.enterCreditCardInformationSectionOnPaymentInformationPage(CreditCardNumber, CVV);
	}
	
	
	public void verifyInformationFieldDisplayOnReviewandSubmitPage(String preFix, String Fname, String Lname, String Mail, String EmailExt, String Phone, 
			String Address, String City, String State, String Zip , String DOBmonth, String DOBday, String DOByear)
	{
		CanReciveInfo.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip , DOBmonth, DOBday, DOByear);
	}
        
        public void verifyEditButtonOnReviewAndSubmit(String preFix, String Fname, String Lname, 
			String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip, String DOBmonth, String DOBday, String DOByear, String CreditCardNumber, String CVV)
        {
            CanReciveInfo.clickPersonalInfoEditButtonOnReviewAndSubmit();
            enterInformationOnPersonalInformationPage(preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth, DOBday, DOByear);
            redirectToPaymentInformationPage();
            verifyElemetsDisplayOnPaymentInformationPage();
            selectPaymentModeAndEnterCardInformation();
            verifyElementDisplayAfterCreditCardSelection();
            enterCreditCardInformationAfterCreditCardSelection(CreditCardNumber, CVV);
            CanReciveInfo.clickProgramInfoEditButtonOnReviewAndSubmit();
            redirectToPaymentInformationPage();
            verifyElemetsDisplayOnPaymentInformationPage();
            selectPaymentModeAndEnterCardInformation();
            verifyElementDisplayAfterCreditCardSelection();
            enterCreditCardInformationAfterCreditCardSelection(CreditCardNumber, CVV);
            CanReciveInfo.clickPaymentInfoEditButtonOnReviewAndSubmit();
            redirectToPaymentInformationPage();
            verifyElemetsDisplayOnPaymentInformationPage();
            selectPaymentModeAndEnterCardInformation();
            verifyElementDisplayAfterCreditCardSelection();
            enterCreditCardInformationAfterCreditCardSelection(CreditCardNumber, CVV);    
        }
        
        public void clickPersonalInfoEditButtonOnReviewAndSubmit()
        {
            CanReciveInfo.clickPersonalInfoEditButtonOnReviewAndSubmit();
        }
        
        public void clickProgramInfoEditButtonOnReviewAndSubmit()
        {
            CanReciveInfo.clickProgramInfoEditButtonOnReviewAndSubmit();
        }
        
        public void clickPaymentInfoEditButtonOnReviewAndSubmit()
        {
            CanReciveInfo.clickPaymentInfoEditButtonOnReviewAndSubmit();
        }

	
	public void clickonTermAndConditionsonReviewandSubmitPage()
	{
		CanReciveInfo.acceptTermandConditionOnReviewAndSubmitPage();
	}

	
}
