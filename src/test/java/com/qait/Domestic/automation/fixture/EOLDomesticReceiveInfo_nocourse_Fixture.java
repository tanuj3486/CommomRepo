package com.qait.Domestic.automation.fixture;


public class EOLDomesticReceiveInfo_nocourse_Fixture extends BaseFixture {

	static int CourseCount;

	public void verifyHomepage() {
		PanFoster.navigateToDomesticURLReciveInformationNoCource();

	}

	public int getCourseCount() {
		CourseCount = PanFoster.getCourseCountFromPannFosterPage();
		return CourseCount;
	}

	public void selectCourse(String Cource) {
		PanFoster.selectCourseFromPannFosterPage(Cource);
	}

	public void verifyElementsDisplayOnStep1() {
		PanFoster.varifyPageElementsForStep1();
	}

	public void enterStudentInformationInStep1Form(String preFix, String Fname,
			String Lname, String Mail, String EmailExt, String Phone,
			String Address, String City, String State, String Zip) {
		PanFoster.fillFormStep1ForDomestic(preFix, Fname, Lname, Mail,
				EmailExt, Phone, Address, City, State, Zip);

	}

	public void verifyRedirectToThnakyouPageandClickonEnrollOnlineLink() {
		PanFoster.verifyThnakYouPageAfterStep1FormPage();
	}

	public void verifyElementsPersentOnPersonalInformationPage() {
		PanFoster.verifyPersonalInformationPage();
	}

	public void enterInformationOnPersonalInformationPage(String preFix,
			String Fname, String Lname, String Mail, String EmailExt,
			String Phone, String Address, String City, String State,
			String Zip, String DOBmonth, String DOBday, String DOByear) {
		PanFoster.enterExtraInformationOnPersonalInformationPage(preFix, Fname,
				Lname, Mail, EmailExt, Phone, Address, City, State, Zip,
				DOBmonth, DOBday, DOByear);
	}

	public void enterInformationAfterEditOnPersonalInformationPage(
			String preFix, String Fname, String Lname, String Mail,
			String EmailExt, String Phone, String Address, String City,
			String State, String Zip, String DOBmonth, String DOBday,
			String DOByear) {
		PanFoster.enterExtraInformationAfterEditOnPersonalInformationPage(
				preFix, Fname, Lname, Mail, EmailExt, Phone, Address, City,
				State, Zip, DOBmonth, DOBday, DOByear);
	}

	public void redirectToPaymentInformationPage() {
		PanFoster.verificationPaymentInformationPage();
	}

	public void verifyElemetsDisplayOnPaymentInformationPage() {
		PanFoster.verifyElemetsOnPaymentInformationPage();
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

	public void verifyInformationFieldDisplayOnReviewandSubmitPage(
			String preFix, String Fname, String Lname, String Mail,
			String EmailExt, String Phone, String Address, String City,
			String State, String Zip, String DOBmonth, String DOBday,
			String DOByear) {
		PanFoster.verifyElementsOnReviewAndSubmitPage(preFix, Fname, Lname,
				Mail, EmailExt, Phone, Address, City, State, Zip, DOBmonth,
				DOBday, DOByear);
	}

	public void clickonTermAndConditionsonReviewandSubmitPage() {
		PanFoster.acceptTermandConditionOnReviewAndSubmitPage();
		
	}

}
