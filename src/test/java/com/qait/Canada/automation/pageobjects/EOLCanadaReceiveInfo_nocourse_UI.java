package com.qait.Canada.automation.pageobjects;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.qait.Canada.automation.pageobjects.AbstractClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.qait.Canada.automation.tests.AllCourse_EOLCanadaReceiveInfo_nocourse_Tests;
import com.qait.Canada.automation.tests.EOLCanadaReceiveInfo_nocourse_Test;
//import com.qait.Canada.automation.tests.EOLCanadaReceiveInfo_nocourse_Test;
import com.qait.Canada.automation.util.ReadWriteExcelFile;
import com.qait.Canada.automation.util.Utilities;


public class EOLCanadaReceiveInfo_nocourse_UI extends AbstractClass{
	
WebDriver driver;

ReadWriteExcelFile writeResult = new ReadWriteExcelFile("LastRunReport/last/Result.xls");
String course;

    public EOLCanadaReceiveInfo_nocourse_UI(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
             
		@FindBy(xpath = "//form[@id='form5']/a")
		protected WebElement CanadaURLReceiveInformationnocourse;		
		@FindBy(xpath = "//img[@id='ctl00_ctl00_imgLogo' or @ alt = 'ICS Canada']")
		protected WebElement ICSCanadaImage;		
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlProgram']")
		protected WebElement courseDropDown;		
		@FindBy(xpath = "//input[@value='Continue']")
		protected WebElement continueButton;		
		
//		################  Step1 Page elements   #######################
		
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_spanProgramName1']")
		protected WebElement courseNameHeadingOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtFirstName']")
		protected WebElement firstNameTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* First Name')]")
		protected WebElement firstNameTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtLastName']")
		protected WebElement lastNameTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Last Name')]")
		protected WebElement lastNameTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='txtEmail1']")
		protected WebElement emailTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Email')]")
		protected WebElement emailTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='txtEmail2']")
		protected WebElement reTypeEmailTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Re-Type Email')]")
		protected WebElement reTypeEmailTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtPhone1']")
		protected WebElement primaryPhoneTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Primary Phone')]")
		protected WebElement primaryPhoneTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtAddress1']")
		protected WebElement address1TextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Address 1')]")
		protected WebElement address1TextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtAddress2']")
		protected WebElement address2TextBoxOnStep1Page;	
		@FindBy(xpath = "//label[contains(text(),'Address 2')]")
		protected WebElement address2TextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtCity']")
		protected WebElement cityTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* City')]")
		protected WebElement cityTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlState']")
                protected WebElement ProvinceTextBoxOnStep1Page;
		@FindBy(xpath = "//strong[contains(text(),'* Province')]")
                protected WebElement ProvinceTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txtZipPostal']")
                protected WebElement PostalCodeTextBoxOnStep1Page;	
		@FindBy(xpath = "//strong[contains(text(),'* Postal Code')]")
                protected WebElement PostalCodeTextBoxLabelOnStep1Page;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_chkCommunicateEmail']")
		protected WebElement communicateViaEmailCheckbox;		
		@FindBy(xpath = "//label[contains(text(),'I would like ICS Canada to communicate with me via Email.')]")
		protected WebElement communicateViaEmailCheckboxLabel;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_chkCommunicateTextMsg']")
		protected WebElement communicateViaTextMsgCheckbox;		
		@FindBy(xpath = "//label[contains(text(),'I would like ICS Canada to communicate with me via Text Message.')]")
		protected WebElement communicateViaTextMsgCheckboxLabel;		
		@FindBy(id = "rdoPhoneType1Mobile")
		protected WebElement mobilePhoneTypeRadioButton;		
		@FindBy(xpath = "//span[contains(text(),'Mobile')]")
		protected WebElement mobilePhoneTypeRadioButtonLabel;		
		@FindBy(id = "rdoPhoneType1Other")
		protected WebElement otherPhoneTypeRadioButton;	
		@FindBy(xpath = "//span[contains(text(),'Other')]")
		protected WebElement otherPhoneTypeRadioButtonLabel;		
		@FindBy(xpath = "//strong[contains(text(),'* Phone Type')]")
		protected WebElement phoneTypeRadioButtonLabelOnStep1Page;		
		@FindBy(xpath = "//input[@value='Send Information']")
		protected WebElement sendInformationButton;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal']")
		protected WebElement reminderPopupOnStep1FormSubmit;	
		
//		#########  Thank You Page ########################
		
		
		@FindBy(xpath = "//b[contains(text(),'Thank You!')]")
		protected WebElement thnakyouPageAfterStep1FormPage;		
		@FindBy(xpath = "//u[contains(text(),'Enrol online')]")
		protected WebElement enrollOnlineLinkThnakyouPageAfterStep1FormPage;	
		
		
//		######### Personal Information Page #################
		
		
		@FindBy(xpath = "//input[@value='Proceed To Step 2']")
		protected WebElement proceedToStep2Button;		
		@FindBy(xpath = "//strong[contains(text(),'* Date of Birth')]")
		protected WebElement dobTextBoxLabelOnStep1PersonalInformationPage;		
		@FindBy(xpath = ".//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_DateOfBirth_Month']")
		protected WebElement monthTextboxDOBOnStep1PersonalInformationPage;		
		@FindBy(xpath = ".//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_DateOfBirth_Day']")
		protected WebElement dayTextboxDOBOnStep1PersonalInformationPage;		
		@FindBy(xpath = ".//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_DateOfBirth_Year']")
		protected WebElement yearTextboxDOBOnStep1PersonalInformationPage;		
		@FindBy(xpath = "//strong[contains(text(),'* Highest Level of Education')]")
		protected WebElement levelOFEductionLabelOnStep1PersonalInformationPage;		
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlLevelOfEducation']")
		protected WebElement levelOFEductionDropDownOnStep1PersonalInformationPage;		
		@FindBy(xpath = "//strong[contains(text(),'* Gender')]")
		protected WebElement genderLabelOnStep1PersonalInformationPage;		
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlGender']")
		protected WebElement genderDropDownOnStep1PersonalInformationPage;
		@FindBy(xpath = "//a[@id='linkStep1']")
		protected WebElement step1TabOnEnrollmentFormForCanada;
		@FindBy(xpath = "//a[@id='linkStep2']")
		protected WebElement step2TabOnEnrollmentFormForCanada;
		@FindBy(xpath = "//a[@id='linkStep3']")
		protected WebElement step3TabOnEnrollmentFormForCanada;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_BankNumber']")
		protected WebElement BankNumberTextPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_TransitNumber']")
		protected WebElement TransitNumberTextPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_AcctNumber']")
		protected WebElement AccountNumberTextPaymentInformationPage;
		
//		####################  Payment Information Page ######################
		
		
		@FindBy(xpath = "//div[@class='program_name']")
		protected WebElement courseHaadingOnPaymentInformationPage;
		@FindBy(xpath = "//a[@class='lnkPromoCode']")
		protected WebElement promoCodeOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PayPlan_PayInFull']")
		protected WebElement PaymentPlanRadioOnPaymentInformationPage;
		@FindBy(xpath = "//label[contains(text(),' Payment Plan')]")
		protected WebElement PaymentPlanRadioLabelOnPaymentInformationPage;
		                            
		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_div_PayPlan_PayInFull_ProgramPrice']")
		protected WebElement totalAmountPaymentPlanRadioOnPaymentInformationPage;
		@FindBy(xpath = "//img[@alt='Click for company profile']")
		protected WebElement secureTransactionImageFooterOnPaymentInformationPage;
		@FindBy(xpath = "//div[@id='secure-logos']")
		protected WebElement secureTransactionImageTextFooterOnPaymentInformationPage;
		@FindBy(xpath = "//div[@class='step_name']")
		protected WebElement headerPaymentInfoTextOnPaymentInformationPage;	
		@FindBy(xpath = "//div[@id='main']/div[2]/div/div/div/div[1]/p")
		protected WebElement textPaymentInformationOnPaymentInformationPage;	
		@FindBy(xpath = "//p[@class='paytoday']")
		protected WebElement textTodaysPaymentOnPaymentInformationPage;
		@FindBy(xpath = "//div[@id='main']/div[2]")
		protected WebElement updatedTodaysPaymentOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_CreditDebit']")
		protected WebElement creditCardRadioOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_ACH']")
		protected WebElement savingsAccountRadioOnPaymentInformationPage;
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddl_PaymentInfo_ACH_US_Type']")
		protected WebElement accountTypesavingsAccountDropdownOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_US_RoutingNumber']")
		protected WebElement routingNumbersavingsAccountOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_US_AcctNumber']")
		protected WebElement accountNumbersavingsAccountOnPaymentInformationPage;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_divMailPaymentsWarning")
		protected WebElement mailmymonthlypaymentsWarning;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal2")
		protected WebElement mailmymonthlypaymentsWarningOKbutton;
	
		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PayPlan_PayInMonthly']")
		protected WebElement MonthlyPayPlanRadioOnPaymentInformationPage;
		@FindBy(xpath = "//label[contains(text(),'Monthly Pay')]")
		protected WebElement MonthlyPayPlanLabelOnPaymentInformationPage;
		@FindBy(xpath = "//p[contains(text(),'Initial Payment')]")
		protected WebElement InitialPaymentText;
		@FindBy(xpath = "//span[contains(text(),'Monthly Payment')]")
		protected WebElement MonthlyPaymentText;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentCalc_DownPayment")
		protected WebElement InitialPaymentTextBox;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentCalc_MonthlyPayment")
		protected WebElement MonthlyPaymentTextBox;
		@FindBy(xpath = "//input[@value='Calculate']")
		protected WebElement CalculateButton;
		@FindBy(xpath = "//input[@value='Reset']")
		protected WebElement ResetButton;
		@FindBy(xpath = "//input[@type='checkbox']")
		protected WebElement mailmymonthlypayments;
		@FindBy(xpath = "//label[contains(text(),'I prefer to mail my monthly payments.')]")
		protected WebElement Checkboxlabel;
		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_vld_PaymentCalculator']/ul/li")
		protected WebElement getErrorMessageMOnthlyPaymentMode;
		@FindBy(xpath = "(//div[contains(text(),'Total Price:')])[2]")
		protected WebElement MonthlyTotalPayment;
		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_vld_PaymentCalculator']/ul")
		protected WebElement MonthlyTotalOKBlankErrorMessage;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_par_PaymentCalc_Terms")
		protected WebElement paymentDescriptionCalculate;
		@FindBy(xpath = "//span[contains(text(),'Pay as little as')]")
		protected WebElement monthlyPaymentMin;
		@FindBy(xpath = "//p[contains(text(),'Payment Frequency:')]")
		protected WebElement headingPaymentFrequency;
		@FindBy(xpath = "//input[@value='rdo_PaymentFrequency_Monthly']")
		protected WebElement radioMonthly;
		@FindBy(xpath = "//input[@value='rdo_PaymentFrequency_14Days']")
		protected WebElement radio14days;
		@FindBy(id = "ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_par_PaymentFrequency_OptionSelection")
		protected WebElement paymentFrequencyDescription;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']")
		protected WebElement paymentFrequencymonthlyDescription;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']/input[1]")
		protected WebElement paymentFrequencyDescriptionMonth;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']/input[2]")
		protected WebElement paymentFrequencyDescriptionday;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']/input[3]")
		protected WebElement paymentFrequencyDescriptionyear;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']/input[4]")
		protected WebElement paymentFrequencyDescriptionCalander;
		@FindBy(xpath = "(//input[@value='OK'])[2]")
		protected WebElement paymentFrequencyOKButton;
		
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']")
		protected WebElement halfdaypaymentFrequencymonthlyDescription;		
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']/input[1]")
		protected WebElement halfdayspaymentFrequencyDescriptionMonth;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']/input[2]")
		protected WebElement halfdayspaymentFrequencyDescriptionday;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']/input[3]")
		protected WebElement halfdayspaymentFrequencyDescriptionyear;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']/input[4]")
		protected WebElement halfdayspaymentFrequencyDescriptionCalander;

		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_div_PayPlan_PayInMonthly_ProgramPrice']")
		protected WebElement totalAmountMonthlyPaymentPlanRadioOnPaymentInformationPage;
		
//		#############  Card Information Section  ###########################
		
		@FindBy(xpath = "//input[@type='checkbox']")
		protected WebElement checkboxBillingAddressCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//label[contains(text(),'My billing information is the same as my mailing address.')]")
		protected WebElement labelBillingAddressCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_FirstName']")
		protected WebElement textboxFirstNameCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*First Name')]")
		protected WebElement labelFirstNameCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_LastName']")
		protected WebElement textboxLastNameCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*Last Name')]")
		protected WebElement labelLastNameCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_Address1']")
		protected WebElement textboxAdderss1CreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*Address 1')]")
		protected WebElement labelAddress1CreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_Address2']")
		protected WebElement textboxAdderss2CreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_City']")
		protected WebElement textboxCityCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*City')]")
		protected WebElement labelCityCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddl_PaymentInfo_CC_State']")
                protected WebElement textboxProvinceCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),' *Province')]")
                protected WebElement labelProvinceCreditCardOnPaymentInformationPage;		
//		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_ZipCode']")
//		protected WebElement textboxZipCreditCardOnPaymentInformationPage;
//		@FindBy(xpath = "//strong[contains(text(),' *Zip')]")
//		protected WebElement labelZipCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_ZipCode']")
		protected WebElement textboxPostalCodeCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),' *Postal Code')]")
		protected WebElement labelPostalCodeCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_CardNumber']")
		protected WebElement textboxCardNumberCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*Card Number')]")
		protected WebElement labelCardNumberCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_CC_CVV']")
		protected WebElement textboxCVVCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*CVV Code')]")
		protected WebElement labelCVVrCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = ".//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddl_PaymentInfo_CC_ExpMonth']")
		protected WebElement textboxExpDateMonthCreditCardOnPaymentInformationPage;
		@FindBy(xpath = ".//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddl_PaymentInfo_CC_ExpYear']")
		protected WebElement textboxExpDateYearCreditCardOnPaymentInformationPage;
		@FindBy(xpath = "//strong[contains(text(),'*Exp. Date')]")
		protected WebElement labelExpDateCreditCardOnPaymentInformationPage;		
		@FindBy(xpath = "//input[@value='Proceed to Final Step']")
		protected WebElement proceedtoFinalStepCreditCardOnPaymentInformationPage;
		
		
//		############  Review and Submit Page   #######################
		
		
	
		@FindBy(xpath = "//*[@id='main']/div[1]")
		protected WebElement p1;
		@FindBy(xpath = "//*[@id='main']/div[2]")
		protected WebElement p2;
		@FindBy(xpath = "//*[@id='main']/div[3]")
		protected WebElement p3;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btn_EditPersonalInfo']")
		protected WebElement EditPersonalInfoOnReviewAndSubmitPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btn_EditProgramInfo']")
		protected WebElement EditProgramInfoOnReviewAndSubmitPage;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btn_EditPaymentInfo']")
		protected WebElement EditPaymentInfoOnReviewAndSubmitPage;
		@FindBy(xpath = "//input[@type='checkbox']")
		protected WebElement checkboxTermandConditionOnReviewAndSubmitPage;
		@FindBy(xpath = "//label[contains(text(),'I have reviewed and understand the terms and conditions of my enrolment.')]")
		protected WebElement checkboxLabelTermandConditionOnReviewAndSubmitPage;
		@FindBy(xpath = "//input[@id='btn_Enroll']")
		protected WebElement enrollTermandConditionOnReviewAndSubmitPage;
		@FindBy(xpath = "//b[contains(text(),'Congratulations')]")
		protected WebElement txtCongratulationsOnReviewAndSubmitPage;
		
		
//		############  Electronic Signature Page   #######################
		
		@FindBy(xpath = "//div[@class='step_name']")
		protected WebElement textElectronicSignature;
		@FindBy(xpath = "//input[@id='txt_Name']")
		protected WebElement textboxNameOnElectronicSigAgreement;
		@FindBy(xpath = "//input[@id='txt_Email']")
		protected WebElement textboxEmailOnElectronicSigAgreement;
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_submitButton']")
		protected WebElement submitBtnOnElectronicSigAgreementPage;
		@FindBy(xpath = "//span[contains(text(),'Click Here to Sign')]")
		protected WebElement ClickToSignInOnElectronicSigAgreement;
		@FindBy(xpath = "//span[contains(text(),'Click Here to Continue')]")
		protected WebElement ClickToContinueInOnElectronicSigAgreement;
		@FindBy(xpath = "//img[@alt='Error Image']")
		protected WebElement ErrorImageOnElectronicSigAgreement;
		@FindBy(xpath = "//div[@class='step_name']")
		protected WebElement ElectronicSignatureAgreementText;
		@FindBy(xpath = "//input[@value='rdo_Sign']")
		protected WebElement radiobuttonSignyourEnrollmentAgreementOnline;
		@FindBy(xpath = "//input[@value='rdo_Mail']")
		protected WebElement radiobuttonSignyourEnrollmentMailed;
		@FindBy(xpath = "//input[@value='Next']")
		protected WebElement nextButtonDisplayOnElectronicSignature;			
		@FindBy(linkText = "Yes, I consent to complete and sign this document electronically.")
		protected WebElement yesLinkonDisplayOnElectronicSignature;		
		@FindBy(linkText = "No, I prefer to have this document mailed to me, which I will sign and return via postal mail")
		protected WebElement noLinkonDisplayOnElectronicSignature;		
		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_div_MarketingContent']/span")
		protected WebElement getStudentIDFromCongratulationsPage;
		@FindBy(xpath = "//div[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_div_MarketingContent']/p/span")
		protected WebElement getStudentIDFromCongratulationsPage2;
		@FindBy(linkText = "Click here")
		protected WebElement clickHereLinkOnCongratulationsPage;	
		
		// ############ Field Validation Electronic Signature agreement Page
		// ##############

		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_studentIDNum']")
		protected WebElement StudentIDOnElectronicSigAgreement;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_studentName']")
		protected WebElement StudentNameOnElectronicSigAgreement;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_studentAddress']")
		protected WebElement StudentAddressOnElectronicSigAgreement;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_courseDesc']")
		protected WebElement CourseNameOnElectronicSigAgreement;
		// phone and DOB in 'PersonalDataOnElectronicSigAgreement'
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_personalData']")
		protected WebElement PersonalDataOnElectronicSigAgreement;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_eMail']")
		protected WebElement EmailOnElectronicSigAgreement;
		@FindBy(xpath = "//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_payMethod']")
		protected WebElement PaymentOnElectronicSigAgreement;
		@FindBy(xpath = "/html/body/table/tbody/tr[4]/td[2]")
		protected WebElement StudentInfoOnElectronicSigAgreement;
		@FindBy(xpath = "/html/body/table/tbody/tr[8]/td[2]")
		protected WebElement PaymentDetailsOnElectronicSigAgreement;
		@FindBy(xpath = "/html/body/table/tbody/tr/td/div/p[1]")
		protected WebElement ErrorTextOnElectronicSigAgreement;

			
//		##############  Field validation msg ####################
		@FindBy(xpath = "//li[contains(text(),'Email Address is Required')]")
		protected WebElement emailAddressisRequired;
		@FindBy(xpath = "//li[contains(text(),'Email Addresses Do Not Match')]")
		protected WebElement emailAddressesDoNotMatch;
		@FindBy(xpath = "//input[@value='OK']")
		protected WebElement okButtonValidationPopUp;
		@FindBy(xpath = "//li[contains(text(),'Re-Type Email Address is Required')]")
		protected WebElement reTypeEmailAddressisRequired;
		@FindBy(xpath = "//li[contains(text(),'Please enter a valid telephone number')]")
		protected WebElement pleaseEnteraValidTelephoneNumber;
		@FindBy(xpath = "//li[contains(text(),'Primary Phone is Required')]")
		protected WebElement primaryPhoneisRequired;
		@FindBy(xpath = "//li[contains(text(),'Address 1 is Required')]")
		protected WebElement address1isRequired;
		@FindBy(xpath = "//li[contains(text(),'City is Required')]")
		protected WebElement cityIsRequired;		
		@FindBy(xpath = "//li[contains(text(),'Postal Code is Required')]")
		protected WebElement zipIsRequired;
		@FindBy(xpath = "//li[contains(text(),'First Name is Required')]")
		protected WebElement firstNameisRequired;
		@FindBy(xpath = "//li[contains(text(),'Last Name is Required')]")
		protected WebElement lastNameisRequired;
		
			
//		########### Message validation Personal Information Page  ######################
		
		@FindBy(xpath = "//li[contains(text(),'Month of Birth is required')]")
		protected WebElement monthofBirthisrequired;
		@FindBy(xpath = "//li[contains(text(),'Day of Birth is required')]")
		protected WebElement dayofBirthisrequired;
		@FindBy(xpath = "//li[contains(text(),'Year of Birth is required')]")
		protected WebElement yearofBirthisrequired;
		@FindBy(xpath = "//li[contains(text(),'Highest Level of Education is Required')]")
		protected WebElement highestlevelofEducationisRequired;		
		@FindBy(xpath = "//li[contains(text(),'Gender is Required')]")
		protected WebElement genderisRequired;
		
		
//		########### Message validation Payment Information Page  ######################
		
		@FindBy(xpath = "//li[contains(text(),'Please enter the first name on your credit or debit card')]")
		protected WebElement pleaseEnterFirstName;
		@FindBy(xpath = "//li[contains(text(),'Please enter the last name on your credit or debit card')]")
		protected WebElement pleaseEnterLastName;
		@FindBy(xpath = "//li[contains(text(),'Please enter your address in Street Address')]")
		protected WebElement pleaseEnterAddressInStreet;
		@FindBy(xpath = "//li[contains(text(),'Please enter your city')]")
		protected WebElement pleaseEnterYourCity;
		@FindBy(xpath = "//li[contains(text(),'Please enter a valid postal code.')]")
		protected WebElement pleaseEnterYourPostalCode;
		@FindBy(xpath = "//li[contains(text(),'Please enter your credit card number')]")
		protected WebElement Pleaseenteryourcreditcardnumber;
		@FindBy(xpath = "//li[contains(text(),'Please enter your CVV Code')]")
		protected WebElement PleaseenteryourCVVCode;
		@FindBy(xpath = "//li[contains(text(),'your expiration month')]")
		protected WebElement enteryourexpirationmonth;
		@FindBy(xpath = "//li[contains(text(),'Please enter your expiration year')]")
		protected WebElement enteryourexpirationyear;		
		@FindBy(xpath = "//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal']")
		protected WebElement okbuttonDisplayonPaymentInfoPage;
		
		static int coursecount; 
		String selectedCourseName;
		int currentCourseUI = AllCourse_EOLCanadaReceiveInfo_nocourse_Tests.initialCounter + 1;
		int ScenarioCount = AllCourse_EOLCanadaReceiveInfo_nocourse_Tests.ScenarioCounter;
		static String StudentFilename;
		String lname;
		String email;
		String courseCost;
		String PaymentScenario;
		String[] parts;
		String MinCost;
		String MaxCost;
		int MonthCount;
		int FinalPayCost;
		String ByWeeklyPay;
		
		public void getScenarioFromYAML()
        {
		    System.out.println("ScenarioCount :"+ScenarioCount);
			System.out.println(Utilities.getScenario(ScenarioCount));			
			 PaymentScenario = Utilities.getScenario(ScenarioCount);
					 		
        }
		
		public void splitScenario(){
			 parts = PaymentScenario.split(";");
			 System.out.println(parts.length);
			 
			 for (int i=0;i<parts.length;i++){
				 System.out.println(parts[i].trim());
			 }
		}
		
		public void navigateToCanadaURLReciveInformationNoCource()
        {       
			CanadaURLReceiveInformationnocourse.click();			
			Reporter.log(Utilities.logOutputFile("Click on Receive Information (No course) - Pass"));
			Assert.assertTrue(ICSCanadaImage.isDisplayed());  
			Reporter.log(Utilities.logOutputFile("ICS Canada Image Verify - Pass"));
			getScenarioFromYAML(); 

        }
		
		public int getCourseCountFromICSCanadaPage()
        {			
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlProgram']")));
			coursecount = Integer.parseInt(courseDropDown.getAttribute("length"));			
			Reporter.log(Utilities.logOutputFile("Total number of Course under Receive Information (No course) is --> "+coursecount+" - Pass"));

			Utilities.hardWait(3);
			return coursecount;
        }
			
		public void selectCourseFromICSCanadaPage(String Course)
		{
			if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){		
				WebElement OptionFordropdown = driver.findElement(By.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlProgram']/option["+currentCourseUI+"]"));
				selectedCourseName = OptionFordropdown.getText();				
			}else{
				if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
					selectedCourseName = Course;					
				}else{

					selectedCourseName = Course;
				}
			}			
			Reporter.log(Utilities.logOutputFile(" Select a course from dropdown - Pass"));
			Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlProgram']")));
			select.selectByVisibleText(selectedCourseName);
			//System.out.println("Selected Course Name --> "+selectedCourseName);
			course = selectedCourseName;
			continueButton.click();
			Reporter.log(Utilities.logOutputFile(" Click on Continue button - Pass"));
		}
			
		public void varifyPageElementsForStep1()
        {
			
				try{
					
						Reporter.log(Utilities.logOutputFile(" Fill form for Course --> "+courseNameHeadingOnStep1Page.getText()+" - Pass"));
						Assert.assertTrue(courseNameHeadingOnStep1Page.getText().equalsIgnoreCase(selectedCourseName));
						Assert.assertTrue(firstNameTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(firstNameTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(lastNameTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(lastNameTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(emailTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(emailTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(reTypeEmailTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(reTypeEmailTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(primaryPhoneTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(primaryPhoneTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(address1TextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(address1TextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(address2TextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(address2TextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(cityTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(cityTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(ProvinceTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(ProvinceTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(PostalCodeTextBoxOnStep1Page.isDisplayed());
						Assert.assertTrue(PostalCodeTextBoxLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(communicateViaEmailCheckbox.isDisplayed());					
						Assert.assertTrue(communicateViaEmailCheckboxLabel.isDisplayed());					
						Assert.assertTrue(communicateViaTextMsgCheckbox.isDisplayed());					
						Assert.assertTrue(communicateViaTextMsgCheckboxLabel.isDisplayed());					
						Assert.assertTrue(mobilePhoneTypeRadioButton.isDisplayed());					
						Assert.assertTrue(mobilePhoneTypeRadioButtonLabel.isDisplayed());					
						Assert.assertTrue(otherPhoneTypeRadioButton.isDisplayed());					
						Assert.assertTrue(otherPhoneTypeRadioButtonLabel.isDisplayed());					
						Assert.assertTrue(phoneTypeRadioButtonLabelOnStep1Page.isDisplayed());
						Assert.assertTrue(sendInformationButton.isDisplayed());
						Reporter.log(Utilities.logOutputFile(" Verify Elements display on Step1 page - Pass"));

						
					
				}catch(Exception e){
					//System.out.println("Unable to Find Element on Step1 page --> "+e);
				}						
        }
		
        public void fillFormStep1ForCanada(String preFix, String Fname, String Lname, 
				String Mail, String EmailExt, String Phone, String Address, String City, String State, String Zip)
        {	
			Reporter.log(Utilities.logOutputFile(" Enter Information on Step1 page - Pass"));
			StudentFilename = Fname+Lname;
			
			try {
				sendInformationButton.click();
				firstNameisRequired.isDisplayed();
				lastNameisRequired.isDisplayed();
				emailAddressisRequired.isDisplayed();
				reTypeEmailAddressisRequired.isDisplayed();
				primaryPhoneisRequired.isDisplayed();
				address1isRequired.isDisplayed();
				cityIsRequired.isDisplayed();
				zipIsRequired.isDisplayed();
				okButtonValidationPopUp.click();
				
			}catch(Exception e)
			{
				//System.out.println("Error in validating all empty message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			
			
			try{
				firstNameTextBoxOnStep1Page.sendKeys(Fname+"123");
				lastNameTextBoxOnStep1Page.click();
				firstNameTextBoxOnStep1Page.getAttribute("value");
                                //System.out.println("actual: "+firstNameTextBoxOnStep1Page.getAttribute("value"));
                                //System.out.println("expected:" + Fname);
				Assert.assertTrue(firstNameTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Fname));
			}catch(Exception e){
				//System.out.println("Error in validating all first name message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
				lastNameTextBoxOnStep1Page.sendKeys(Lname+"123");
				emailTextBoxOnStep1Page.click();
				Assert.assertTrue(lastNameTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Lname));
			}catch(Exception e){
				//System.out.println("Error in validating all last name message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			emailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			address1TextBoxOnStep1Page.sendKeys(Address);
			cityTextBoxOnStep1Page.sendKeys(City);
			Select select = new Select(driver.findElement(By.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlState']")));
			select.selectByVisibleText(State);
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			otherPhoneTypeRadioButton.click();
			}catch(Exception e){
				//System.out.println("Error in validating all email message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			emailTextBoxOnStep1Page.clear();
			sendInformationButton.click();
			emailAddressisRequired.isDisplayed();
			emailAddressesDoNotMatch.isDisplayed();
			okButtonValidationPopUp.click();
			emailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			}catch(Exception e){
				//System.out.println("Error in validating all email required message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			reTypeEmailTextBoxOnStep1Page.clear();
			sendInformationButton.click();
			reTypeEmailAddressisRequired.isDisplayed();
			okButtonValidationPopUp.click();
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			}catch(Exception e){
				//System.out.println("Error in validating all email required message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			emailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail+"@"+EmailExt);
			sendInformationButton.click();
			emailAddressesDoNotMatch.isDisplayed();
			okButtonValidationPopUp.click();
			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			emailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			}catch(Exception e){
				//System.out.println("Error in validating all email does not match message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}

			try{
			primaryPhoneTextBoxOnStep1Page.clear();
			sendInformationButton.click();
			primaryPhoneisRequired.isDisplayed();
			okButtonValidationPopUp.click();
			primaryPhoneTextBoxOnStep1Page.sendKeys("909090909");
			sendInformationButton.click();
			pleaseEnteraValidTelephoneNumber.isDisplayed();
			okButtonValidationPopUp.click();
			primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			}catch(Exception e){
				//System.out.println("Error in validating phone number message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			address1TextBoxOnStep1Page.clear();
			sendInformationButton.click();
			address1isRequired.isDisplayed();
			okButtonValidationPopUp.click();
			address1TextBoxOnStep1Page.sendKeys(Address);
			}catch(Exception e){
				//System.out.println("Error in validating address message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			cityTextBoxOnStep1Page.clear();
			sendInformationButton.click();
			cityIsRequired.isDisplayed();
			okButtonValidationPopUp.click();
			cityTextBoxOnStep1Page.sendKeys(City);
			}catch(Exception e){
				//System.out.println("Error in validating city message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}
			
			try{
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			PostalCodeTextBoxOnStep1Page.clear();
			sendInformationButton.click();
			zipIsRequired.isDisplayed();
			okButtonValidationPopUp.click();
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			}catch(Exception e){
				//System.out.println("Error in validating zip message on Step1 page " + e);
				okButtonValidationPopUp.click();
			}

			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			primaryPhoneTextBoxOnStep1Page.clear();
			address1TextBoxOnStep1Page.clear();
			cityTextBoxOnStep1Page.clear();			
			PostalCodeTextBoxOnStep1Page.clear();
			
			emailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail+preFix+"@"+EmailExt);
			primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			address1TextBoxOnStep1Page.sendKeys(Address);
			cityTextBoxOnStep1Page.sendKeys(City);
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			otherPhoneTypeRadioButton.click();
			
			sendInformationButton.click();
                        
			
//			#############################################################################
			try{
				okButtonValidationPopUp.click();

				sendInformationButton.click();

				
			}catch(Exception e){
				
			}
//			#############################################################################


			Reporter.log(Utilities.logOutputFile(" Enter First Name --> "+Fname));
			Reporter.log(Utilities.logOutputFile(" Enter Last Name  --> "+Lname));
			Reporter.log(Utilities.logOutputFile(" Enter Email  --> "+Mail+preFix+"@"+EmailExt));
			Reporter.log(Utilities.logOutputFile(" Enter Phone Number  --> "+Phone));
			Reporter.log(Utilities.logOutputFile(" Enter Address  --> "+Address));
			Reporter.log(Utilities.logOutputFile(" Enter City  --> "+City));
			Reporter.log(Utilities.logOutputFile(" Enter Zip  --> "+Zip));
			
			lname = Lname;
			email = Mail+preFix;
			   if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){
				    writeResult.writeColInExcelFile("Result", course, currentCourseUI-1, 0);
					writeResult.writeColInExcelFile("Result", Fname, currentCourseUI-1, 1);
					writeResult.writeColInExcelFile("Result", Lname, currentCourseUI-1, 2);
					writeResult.writeColInExcelFile("Result", Mail+preFix+"@"+EmailExt, currentCourseUI-1, 3);
					writeResult.writeColInExcelFile("Result", Phone, currentCourseUI-1, 4);
					writeResult.writeColInExcelFile("Result", Address, currentCourseUI-1, 5);
					writeResult.writeColInExcelFile("Result", City, currentCourseUI-1, 6);
					writeResult.writeColInExcelFile("Result", Zip, currentCourseUI-1, 7);
		        }else{
		        	 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
		        		 writeResult.writeColInExcelFile("Result", course, currentCourseUI-1, 0);
		     			 writeResult.writeColInExcelFile("Result", Fname, currentCourseUI-1, 1);
		     			 writeResult.writeColInExcelFile("Result", Lname, currentCourseUI-1, 2);
		     			 writeResult.writeColInExcelFile("Result", Mail+preFix+"@"+EmailExt, currentCourseUI-1, 3);
		     			 writeResult.writeColInExcelFile("Result", Phone, currentCourseUI-1, 4);
		     			 writeResult.writeColInExcelFile("Result", Address, currentCourseUI-1, 5);
		     			 writeResult.writeColInExcelFile("Result", City, currentCourseUI-1, 6);
		     			 writeResult.writeColInExcelFile("Result", Zip, currentCourseUI-1, 7);    
		                 }		        	
		        }					
        }
		
		public void verifyThnakYouPageAfterStep1FormPage()	
		{		
			Assert.assertTrue(thnakyouPageAfterStep1FormPage.isDisplayed());
			Reporter.log(Utilities.logOutputFile("Verify thankyou page displayed  - PASS "));

			enrollOnlineLinkThnakyouPageAfterStep1FormPage.click();
			Reporter.log(Utilities.logOutputFile("Click on Enroll OnLine Link  - PASS "));

						
        }
		
		public void verifyPersonalInformationPage()	
		{
			try
			{
				Assert.assertTrue(proceedToStep2Button.isDisplayed());
				Assert.assertTrue(firstNameTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(firstNameTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(firstNameTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")));
				Assert.assertTrue(lastNameTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(lastNameTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(lastNameTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(lname));
				Assert.assertTrue(emailTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(emailTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(emailTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(email+"@"+Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt")));
				Assert.assertTrue(reTypeEmailTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(reTypeEmailTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(reTypeEmailTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(email+"@"+Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt")));
				Assert.assertTrue(primaryPhoneTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(primaryPhoneTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(primaryPhoneTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.PrimaryPhone")));
				Assert.assertTrue(address1TextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(address1TextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(address1TextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.Address")));
				Assert.assertTrue(address2TextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(address2TextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(cityTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(cityTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(cityTextBoxOnStep1Page.getAttribute("value").equalsIgnoreCase(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.City")));
				Assert.assertTrue(ProvinceTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(ProvinceTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(PostalCodeTextBoxOnStep1Page.isDisplayed());
				Assert.assertTrue(PostalCodeTextBoxLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(PostalCodeTextBoxOnStep1Page.getAttribute("value").replace(" ", "").equalsIgnoreCase(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.ZIP").replace(" ", "")));
				Assert.assertTrue(communicateViaEmailCheckbox.isDisplayed());					
				Assert.assertTrue(communicateViaEmailCheckboxLabel.isDisplayed());					
				Assert.assertTrue(communicateViaTextMsgCheckbox.isDisplayed());					
				Assert.assertTrue(communicateViaTextMsgCheckboxLabel.isDisplayed());					
				Assert.assertTrue(mobilePhoneTypeRadioButton.isDisplayed());					
				Assert.assertTrue(mobilePhoneTypeRadioButtonLabel.isDisplayed());					
				Assert.assertTrue(otherPhoneTypeRadioButton.isDisplayed());					
				Assert.assertTrue(otherPhoneTypeRadioButtonLabel.isDisplayed());					
				Assert.assertTrue(phoneTypeRadioButtonLabelOnStep1Page.isDisplayed());
				Assert.assertTrue(dobTextBoxLabelOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(monthTextboxDOBOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(dayTextboxDOBOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(yearTextboxDOBOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(levelOFEductionLabelOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(levelOFEductionDropDownOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(genderLabelOnStep1PersonalInformationPage.isDisplayed());		
				Assert.assertTrue(genderDropDownOnStep1PersonalInformationPage.isDisplayed());
				Assert.assertTrue(step1TabOnEnrollmentFormForCanada.isDisplayed());
				Assert.assertTrue(step2TabOnEnrollmentFormForCanada.isDisplayed());
				Assert.assertTrue(step3TabOnEnrollmentFormForCanada.isDisplayed());
				Reporter.log(Utilities.logOutputFile("Verify textboxes and Labels display on Personal Information Page  - PASS "));

			}catch(Exception e)
			{
				//System.out.println("Unable to varify element on Personal Information Page --> "+e);
				Reporter.log(Utilities.logOutputFile("Verify textboxes and Labels display on Personal Information Page  - FAIL "));

			}
								
				
		}
		
		public void enterExtraInformationOnPersonalInformationPage(String preFix,
				String Fname, String Lname, String Mail, String EmailExt,
				String Phone, String Address, String City, String State,
				String Zip, String DOBmonth, String DOBday, String DOByear) {
			Reporter.log(Utilities
					.logOutputFile(" Enter Information on Step1 page - Pass"));
			StudentFilename = Fname + Lname;

			firstNameTextBoxOnStep1Page.clear();
			lastNameTextBoxOnStep1Page.clear();
			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			primaryPhoneTextBoxOnStep1Page.clear();
			address1TextBoxOnStep1Page.clear();
			cityTextBoxOnStep1Page.clear();
			PostalCodeTextBoxOnStep1Page.clear();

			try {
				proceedToStep2Button.click();
				firstNameisRequired.isDisplayed();
				lastNameisRequired.isDisplayed();
				emailAddressisRequired.isDisplayed();
				reTypeEmailAddressisRequired.isDisplayed();
				primaryPhoneisRequired.isDisplayed();
				address1isRequired.isDisplayed();
				cityIsRequired.isDisplayed();
				zipIsRequired.isDisplayed();
				okButtonValidationPopUp.click();

			} catch (Exception e) {
				// System.out.println("Error in validating all empty message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				firstNameTextBoxOnStep1Page.sendKeys(Fname + "123");
				lastNameTextBoxOnStep1Page.click();
				firstNameTextBoxOnStep1Page.getAttribute("value");
				Assert.assertTrue(firstNameTextBoxOnStep1Page.getAttribute("value")
						.equalsIgnoreCase(Fname));
			} catch (Exception e) {
				// System.out.println("Error in validating all first name message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				lastNameTextBoxOnStep1Page.sendKeys(Lname + "123");
				emailTextBoxOnStep1Page.click();
				Assert.assertTrue(lastNameTextBoxOnStep1Page.getAttribute("value")
						.equalsIgnoreCase(Lname));
			} catch (Exception e) {
				// System.out.println("Error in validating all last name message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
				primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
				address1TextBoxOnStep1Page.sendKeys(Address);
				cityTextBoxOnStep1Page.sendKeys(City);
				Select select = new Select(
						driver.findElement(By
								.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlState']")));
				select.selectByVisibleText(State);
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
				otherPhoneTypeRadioButton.click();
			} catch (Exception e) {
				// System.out.println("Error in validating all email message on Step1 page2 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				emailAddressisRequired.isDisplayed();
				emailAddressesDoNotMatch.isDisplayed();
				okButtonValidationPopUp.click();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			} catch (Exception e) {
				// System.out.println("Error in validating all email required message on Step1 page3 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				reTypeEmailTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				reTypeEmailAddressisRequired.isDisplayed();
				okButtonValidationPopUp.click();
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
			} catch (Exception e) {
				// System.out.println("Error in validating all email required message on Step1 page4 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.clear();
				reTypeEmailTextBoxOnStep1Page.clear();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + "@" + EmailExt);
				proceedToStep2Button.click();
				emailAddressesDoNotMatch.isDisplayed();
				okButtonValidationPopUp.click();
				emailTextBoxOnStep1Page.clear();
				reTypeEmailTextBoxOnStep1Page.clear();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
			} catch (Exception e) {
				// System.out.println("Error in validating all email does not match message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				primaryPhoneTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				primaryPhoneisRequired.isDisplayed();
				okButtonValidationPopUp.click();
				primaryPhoneTextBoxOnStep1Page.sendKeys("909090909");
				proceedToStep2Button.click();
				pleaseEnteraValidTelephoneNumber.isDisplayed();
				okButtonValidationPopUp.click();
				primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			} catch (Exception e) {
				// System.out.println("Error in validating phone number message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				address1TextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				address1isRequired.isDisplayed();
				okButtonValidationPopUp.click();
				address1TextBoxOnStep1Page.sendKeys(Address);
			} catch (Exception e) {
				// System.out.println("Error in validating address message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				cityTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				cityIsRequired.isDisplayed();
				okButtonValidationPopUp.click();
				cityTextBoxOnStep1Page.sendKeys(City);
			} catch (Exception e) {
				// System.out.println("Error in validating city message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
				PostalCodeTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				zipIsRequired.isDisplayed();
				okButtonValidationPopUp.click();
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			} catch (Exception e) {
				// System.out.println("Error in validating zip message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			primaryPhoneTextBoxOnStep1Page.clear();
			address1TextBoxOnStep1Page.clear();
			cityTextBoxOnStep1Page.clear();
			PostalCodeTextBoxOnStep1Page.clear();

			emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			address1TextBoxOnStep1Page.sendKeys(Address);
			cityTextBoxOnStep1Page.sendKeys(City);
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			otherPhoneTypeRadioButton.click();
			// proceedToStep2Button.click();

			// #####################################################

			// try {
			// okButtonValidationPopUp.click();
			// proceedToStep2Button.click();
			// } catch (Exception e) {
			// }
			// #####################################################

			Reporter.log(Utilities.logOutputFile(" Enter First Name --> " + Fname));
			Reporter.log(Utilities.logOutputFile(" Enter Last Name  --> " + Lname));
			Reporter.log(Utilities.logOutputFile(" Enter Email  --> " + Mail
					+ preFix + "@" + EmailExt));
			Reporter.log(Utilities.logOutputFile(" Enter Phone Number  --> "
					+ Phone));
			Reporter.log(Utilities.logOutputFile(" Enter Address  --> " + Address));
			Reporter.log(Utilities.logOutputFile(" Enter City  --> " + City));
			Reporter.log(Utilities.logOutputFile(" Enter Zip  --> " + Zip));

			lname = Lname;
			email = Mail + preFix;

			// ##############################################################

			try {
				proceedToStep2Button.click();
				monthofBirthisrequired.isDisplayed();
				dayofBirthisrequired.isDisplayed();
				yearofBirthisrequired.isDisplayed();
				highestlevelofEducationisRequired.isDisplayed();
				genderisRequired.isDisplayed();
				okButtonValidationPopUp.click();

			} catch (Exception e) {
				// System.out.println("Error in validating all empty messages on Personal Information Page1 "
				// + e);
				okButtonValidationPopUp.click();

			}

			Select select = new Select(
					levelOFEductionDropDownOnStep1PersonalInformationPage);
			select.selectByValue("16");
			Select selectgender = new Select(
					genderDropDownOnStep1PersonalInformationPage);
			selectgender.selectByValue("M");

			monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);
			dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);
			yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOByear);

			try {
				monthTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				monthofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);

			} catch (Exception e) {
				// System.out.println("Error in validating Month required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			try {
				dayTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				dayofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);

			} catch (Exception e) {
				// System.out.println("Error in validating Day required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			try {
				yearTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				yearofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);

			} catch (Exception e) {
				// System.out.println("Error in validating Year required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			monthTextboxDOBOnStep1PersonalInformationPage.clear();
			dayTextboxDOBOnStep1PersonalInformationPage.clear();
			yearTextboxDOBOnStep1PersonalInformationPage.clear();

			monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);
			dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);
			yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOByear);

			Reporter.log(Utilities
					.logOutputFile("Enter DOB on personal Inforation page MM:DD:YYY format --> "
							+ DOBmonth + DOBday + DOByear));

			proceedToStep2Button.click();

			// #####################################################
			try {
				okButtonValidationPopUp.click();
				proceedToStep2Button.click();
			} catch (Exception e) {
			}

			// #####################################################

		}
		
		public void enterExtraInformationAfterEditOnPersonalInformationPage(
				String preFix, String Fname, String Lname, String Mail,
				String EmailExt, String Phone, String Address, String City,
				String State, String Zip, String DOBmonth, String DOBday,
				String DOByear) {
			Reporter.log(Utilities
					.logOutputFile(" Enter Information on Step1 page - Pass"));
			StudentFilename = Fname + Lname;

			firstNameTextBoxOnStep1Page.clear();
			lastNameTextBoxOnStep1Page.clear();
			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			primaryPhoneTextBoxOnStep1Page.clear();
			address1TextBoxOnStep1Page.clear();
			cityTextBoxOnStep1Page.clear();
			PostalCodeTextBoxOnStep1Page.clear();
			monthTextboxDOBOnStep1PersonalInformationPage.clear();
			dayTextboxDOBOnStep1PersonalInformationPage.clear();
			yearTextboxDOBOnStep1PersonalInformationPage.clear();

			try {
				proceedToStep2Button.click();
				firstNameisRequired.isDisplayed();
				lastNameisRequired.isDisplayed();
				emailAddressisRequired.isDisplayed();
				reTypeEmailAddressisRequired.isDisplayed();
				primaryPhoneisRequired.isDisplayed();
				address1isRequired.isDisplayed();
				cityIsRequired.isDisplayed();
				zipIsRequired.isDisplayed();
				okButtonValidationPopUp.click();

			} catch (Exception e) {
				// //System.out.println("Error in validating all empty message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				firstNameTextBoxOnStep1Page.sendKeys(Fname + "123");
				lastNameTextBoxOnStep1Page.click();
				firstNameTextBoxOnStep1Page.getAttribute("value");
				Assert.assertTrue(firstNameTextBoxOnStep1Page.getAttribute("value")
						.equalsIgnoreCase(Fname));
			} catch (Exception e) {
				// //System.out.println("Error in validating all first name message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				lastNameTextBoxOnStep1Page.sendKeys(Lname + "123");
				emailTextBoxOnStep1Page.click();
				Assert.assertTrue(lastNameTextBoxOnStep1Page.getAttribute("value")
						.equalsIgnoreCase(Lname));
			} catch (Exception e) {
				// //System.out.println("Error in validating all last name message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
				primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
				address1TextBoxOnStep1Page.sendKeys(Address);
				cityTextBoxOnStep1Page.sendKeys(City);
				Select select = new Select(
						driver.findElement(By
								.xpath("//select[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_ddlState']")));
				select.selectByVisibleText(State);
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
				otherPhoneTypeRadioButton.click();
			} catch (Exception e) {
				// //System.out.println("Error in validating all email message on Step1 page3 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				emailAddressisRequired.isDisplayed();
				emailAddressesDoNotMatch.isDisplayed();
				okButtonValidationPopUp.click();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			} catch (Exception e) {
				// //System.out.println("Error in validating all email required message on Step1 page5 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				reTypeEmailTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				reTypeEmailAddressisRequired.isDisplayed();
				okButtonValidationPopUp.click();
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
			} catch (Exception e) {
				// //System.out.println("Error in validating all email required message on Step1 page6 "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				emailTextBoxOnStep1Page.clear();
				reTypeEmailTextBoxOnStep1Page.clear();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + "@" + EmailExt);
				proceedToStep2Button.click();
				emailAddressesDoNotMatch.isDisplayed();
				okButtonValidationPopUp.click();
				emailTextBoxOnStep1Page.clear();
				reTypeEmailTextBoxOnStep1Page.clear();
				emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
				reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@"
						+ EmailExt);
			} catch (Exception e) {
				// //System.out.println("Error in validating all email does not match message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				primaryPhoneTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				primaryPhoneisRequired.isDisplayed();
				okButtonValidationPopUp.click();
				primaryPhoneTextBoxOnStep1Page.sendKeys("909090909");
				proceedToStep2Button.click();
				pleaseEnteraValidTelephoneNumber.isDisplayed();
				okButtonValidationPopUp.click();
				primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			} catch (Exception e) {
				// //System.out.println("Error in validating phone number message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				address1TextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				address1isRequired.isDisplayed();
				okButtonValidationPopUp.click();
				address1TextBoxOnStep1Page.sendKeys(Address);
			} catch (Exception e) {
				// //System.out.println("Error in validating address message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				cityTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				cityIsRequired.isDisplayed();
				okButtonValidationPopUp.click();
				cityTextBoxOnStep1Page.sendKeys(City);
			} catch (Exception e) {
				// //System.out.println("Error in validating city message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			try {
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
				PostalCodeTextBoxOnStep1Page.clear();
				proceedToStep2Button.click();
				zipIsRequired.isDisplayed();
				okButtonValidationPopUp.click();
				PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			} catch (Exception e) {
				// //System.out.println("Error in validating zip message on Step1 page "
				// + e);
				okButtonValidationPopUp.click();
			}

			emailTextBoxOnStep1Page.clear();
			reTypeEmailTextBoxOnStep1Page.clear();
			primaryPhoneTextBoxOnStep1Page.clear();
			address1TextBoxOnStep1Page.clear();
			cityTextBoxOnStep1Page.clear();
			PostalCodeTextBoxOnStep1Page.clear();

			emailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			reTypeEmailTextBoxOnStep1Page.sendKeys(Mail + preFix + "@" + EmailExt);
			primaryPhoneTextBoxOnStep1Page.sendKeys(Phone);
			address1TextBoxOnStep1Page.sendKeys(Address);
			cityTextBoxOnStep1Page.sendKeys(City);
			PostalCodeTextBoxOnStep1Page.sendKeys(Zip);
			otherPhoneTypeRadioButton.click();
			// proceedToStep2Button.click();

			// #####################################################

			// try {
			// okButtonValidationPopUp.click();
			// proceedToStep2Button.click();
			// } catch (Exception e) {
			// }
			// #####################################################

			Reporter.log(Utilities.logOutputFile(" Enter First Name --> " + Fname));
			Reporter.log(Utilities.logOutputFile(" Enter Last Name  --> " + Lname));
			Reporter.log(Utilities.logOutputFile(" Enter Email  --> " + Mail
					+ preFix + "@" + EmailExt));
			Reporter.log(Utilities.logOutputFile(" Enter Phone Number  --> "
					+ Phone));
			Reporter.log(Utilities.logOutputFile(" Enter Address  --> " + Address));
			Reporter.log(Utilities.logOutputFile(" Enter City  --> " + City));
			Reporter.log(Utilities.logOutputFile(" Enter Zip  --> " + Zip));

			lname = Lname;
			email = Mail + preFix;

			// ##############################################################

			try {
				proceedToStep2Button.click();
				monthofBirthisrequired.isDisplayed();
				dayofBirthisrequired.isDisplayed();
				yearofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();

			} catch (Exception e) {
				// //System.out.println("Error in validating all empty messages on Personal Information Page2 "
				// + e);
				okButtonValidationPopUp.click();

			}
			monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);
			dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);
			yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOByear);

			try {
				monthTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				monthofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);

			} catch (Exception e) {
				// //System.out.println("Error in validating Month required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			try {
				dayTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				dayofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);

			} catch (Exception e) {
				// //System.out.println("Error in validating Day required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			try {
				yearTextboxDOBOnStep1PersonalInformationPage.clear();
				proceedToStep2Button.click();
				yearofBirthisrequired.isDisplayed();
				okButtonValidationPopUp.click();
				yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);

			} catch (Exception e) {
				// //System.out.println("Error in validating Year required messages on Personal Information Page "
				// + e);
				okButtonValidationPopUp.click();

			}

			monthTextboxDOBOnStep1PersonalInformationPage.clear();
			dayTextboxDOBOnStep1PersonalInformationPage.clear();
			yearTextboxDOBOnStep1PersonalInformationPage.clear();

			monthTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBmonth);
			dayTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOBday);
			yearTextboxDOBOnStep1PersonalInformationPage.sendKeys(DOByear);

			Reporter.log(Utilities
					.logOutputFile("Enter DOB on personal Inforation page MM:DD:YYY format --> "
							+ DOBmonth + DOBday + DOByear));

			proceedToStep2Button.click();

			// #####################################################
			try {
				okButtonValidationPopUp.click();
				proceedToStep2Button.click();
			} catch (Exception e) {
			}

			// #####################################################

		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		public void  verificationPaymentInformationPage()	
		{
			//System.out.println(courseHaadingOnPaymentInformationPage.getText());
			Assert.assertTrue(courseHaadingOnPaymentInformationPage.getText().equals(selectedCourseName));
			Reporter.log(Utilities.logOutputFile("Verify Course Name display on page i.e. "+courseHaadingOnPaymentInformationPage.getText()+" - PASS"));
			Assert.assertTrue(promoCodeOnPaymentInformationPage.isDisplayed());
			Reporter.log(Utilities.logOutputFile("Verify Promo COde Link display on Page - PASS"));
			
			Assert.assertTrue(headerPaymentInfoTextOnPaymentInformationPage
					.getText().equalsIgnoreCase("Step 2 Payment Information"));
			Reporter.log(Utilities.logOutputFile("Verify Step Text - PASS"));

			Assert.assertTrue(secureTransactionImageTextFooterOnPaymentInformationPage
					.getText().equalsIgnoreCase("This is a secure transaction"));
			Reporter.log(Utilities
					.logOutputFile("Verify Footer Image Secure Transaction - PASS"));
			
			List<WebElement> radioButton = driver.findElements(By.xpath("//input[@type='radio']"));

			
			if (radioButton.size() == 1){
			    if (PaymentPlanRadioOnPaymentInformationPage.isDisplayed()){
				PaymentScenario = " Payment; Credit or Debit Card";
				AllCourse_EOLCanadaReceiveInfo_nocourse_Tests.ScenarioCounter = ScenarioCount - 1;
				writeResult.writeColInExcelFile("Result", "MOnthly payment option does not display so default Scenario implemented", currentCourseUI-1, 10);

			    }
			}		
			
			if(PaymentScenario.contains("Pay By Mail")){
				try{
					MonthlyPayPlanRadioOnPaymentInformationPage.click();
					secureTransactionImageFooterOnPaymentInformationPage.isDisplayed();					
					WebDriverWait wait = new WebDriverWait(driver, 50 );
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Customize your')]")));					
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_chk_PaymentFrequency_PayByMail']")));
											
				}catch(Exception e){
					PaymentScenario = "Full Payment; Credit or Debit Card";
					AllCourse_EOLCanadaReceiveInfo_nocourse_Tests.ScenarioCounter = ScenarioCount - 1;
					writeResult.writeColInExcelFile("Result", "Pay by mail option does not display so default Scenario implemented", currentCourseUI-1, 10);
					
					
				}
				
				
				
			}
			 EOLCanadaReceiveInfo_nocourse_Test.PayScenarioGet = PaymentScenario ;
			splitScenario();

		}
		
		public void verifyElemetsOnPaymentInformationPage() {
			
			writeResult.writeColInExcelFile("Result", PaymentScenario, currentCourseUI-1, 8);

			
//			#################   Payment Mode  #################

			
			if (parts[0].trim().equalsIgnoreCase("Full Payment")){
				PaymentPlanRadioOnPaymentInformationPage.isDisplayed();
				PaymentPlanRadioLabelOnPaymentInformationPage.isDisplayed();
				courseCost = totalAmountPaymentPlanRadioOnPaymentInformationPage.getText();

				Reporter.log(Utilities.logOutputFile("Verify Mode of Payment display on Payment Information Page - PASS"));
				
				PaymentPlanRadioOnPaymentInformationPage.click();
				
				WebDriverWait wait = new WebDriverWait(driver, 50 );
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='paytoday']")));
				
				String str = updatedTodaysPaymentOnPaymentInformationPage.getText();
				
				
				if(str.contains("Please select your payment method:") && str.contains("Credit / Debit Card")&&
						str.contains("Chequing / Savings Account") && str.contains("Payment Information:") &&
						str.contains("Today's Payment:")){
									
					Reporter.log(Utilities.logOutputFile("Verify Options diplsy under  Payment display on Payment Information Page - PASS"));
					
					if (parts[1].trim().equalsIgnoreCase("Checking or Savings Account")){	
																
						savingsAccountRadioOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Select savings account option display on Payment Information Page - PASS"));
						wait = new WebDriverWait(driver, 10);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_BankNumber']")));

						Assert.assertTrue(BankNumberTextPaymentInformationPage.isDisplayed());
						Assert.assertTrue(TransitNumberTextPaymentInformationPage.isDisplayed());
						Assert.assertTrue(AccountNumberTextPaymentInformationPage.isDisplayed());
						
						
						BankNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.BankNumber"));
						TransitNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.TransitNumber"));
						AccountNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.AccountNumber"));
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Click on Proceed to Final Step button - PASS "));
						
						
						
						
					}else{
						creditCardRadioOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Select creadit card option display on Payment Information Page - PASS"));
						
						 wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
						
					
						Assert.assertTrue(labelBillingAddressCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")));
						Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelFirstNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
								.getAttribute("value").equalsIgnoreCase(lname));
						Assert.assertTrue(labelLastNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.Address")));
						Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelAddress1CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxAdderss2CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.City")));
						Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCityCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxProvinceCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelProvinceCreditCardOnPaymentInformationPage
								.isDisplayed());
						//System.out.println("actual pc "
						// +textboxPostalCodeCreditCardOnPaymentInformationPage.getAttribute("value").replace(" ",
						// ""));
						//System.out.println("expected pc "
						// +Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.ZIP").replace(" ",
						// ""));
						Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.replace(" ", "")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.ZIP")
												.replace(" ", "")));
						Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelPostalCodeCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCardNumberCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCardNumberCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCVVCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCVVrCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxExpDateMonthCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxExpDateYearCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelExpDateCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(proceedtoFinalStepCreditCardOnPaymentInformationPage
								.isDisplayed());
						Reporter.log(Utilities
								.logOutputFile("Verify form display under creadit card on Payment Information Page - PASS"));

						
						String CreditCardNumber = Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.CreditCardNumber");
						String CVV = Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.CVV");
						
						try {
							String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							// //System.out.println("firstname is" + firstName);
							textboxFirstNameCreditCardOnPaymentInformationPage.clear();
							String lastName = textboxLastNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxLastNameCreditCardOnPaymentInformationPage.clear();
							String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss1CreditCardOnPaymentInformationPage.clear();
							String address2 = textboxAdderss2CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss2CreditCardOnPaymentInformationPage.clear();
							String city = textboxCityCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxCityCreditCardOnPaymentInformationPage.clear();
							String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
							textboxCardNumberCreditCardOnPaymentInformationPage.clear();
							textboxCVVCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterFirstName.isDisplayed();
							pleaseEnterLastName.isDisplayed();
							pleaseEnterAddressInStreet.isDisplayed();
							pleaseEnterYourCity.isDisplayed();
							pleaseEnterYourPostalCode.isDisplayed();
							Pleaseenteryourcreditcardnumber.isDisplayed();
							PleaseenteryourCVVCode.isDisplayed();
							enteryourexpirationmonth.isDisplayed();
							enteryourexpirationyear.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxFirstNameCreditCardOnPaymentInformationPage
									.sendKeys(firstName);
							textboxLastNameCreditCardOnPaymentInformationPage
									.sendKeys(lastName);
							textboxAdderss1CreditCardOnPaymentInformationPage
									.sendKeys(address1);
							textboxAdderss2CreditCardOnPaymentInformationPage
									.sendKeys(address2);
							textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);
							textboxPostalCodeCreditCardOnPaymentInformationPage
									.sendKeys(zipCode);

						} catch (Exception e) {
							// //System.out.println("Error in validating all empty messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();
						}

						textboxCardNumberCreditCardOnPaymentInformationPage
								.sendKeys(CreditCardNumber);
						textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
						Select select = new Select(
								textboxExpDateMonthCreditCardOnPaymentInformationPage);
						select.selectByValue("04");
						Select select1 = new Select(
								textboxExpDateYearCreditCardOnPaymentInformationPage);
						select1.selectByValue("2018");

						try {
							String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxFirstNameCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterFirstName.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxFirstNameCreditCardOnPaymentInformationPage
									.sendKeys(firstName);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter first name messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String lastName = textboxLastNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxLastNameCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterLastName.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxLastNameCreditCardOnPaymentInformationPage
									.sendKeys(lastName);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter last name messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss1CreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterAddressInStreet.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxAdderss1CreditCardOnPaymentInformationPage
									.sendKeys(address1);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter address messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String city = textboxCityCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxCityCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterYourCity.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);

						} catch (Exception e) {
							// //System.out.println("Error in validating city messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterYourPostalCode.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxPostalCodeCreditCardOnPaymentInformationPage
									.sendKeys(zipCode);

						} catch (Exception e) {
							// //System.out.println("Error in validating zip code messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							textboxCardNumberCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							Pleaseenteryourcreditcardnumber.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCardNumberCreditCardOnPaymentInformationPage
									.sendKeys(CreditCardNumber);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter Credit Card no. messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							textboxCVVCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							PleaseenteryourCVVCode.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter CVV no. messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();
						}

						textboxCardNumberCreditCardOnPaymentInformationPage.clear();
						textboxCVVCreditCardOnPaymentInformationPage.clear();

						Reporter.log(Utilities
								.logOutputFile("Enter information in creadit card form"));
						textboxCardNumberCreditCardOnPaymentInformationPage
								.sendKeys(CreditCardNumber);
						textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
						Reporter.log(Utilities
								.logOutputFile("Enter Credit Card number in creadit card form is -- > "
										+ CreditCardNumber));
						Reporter.log(Utilities
								.logOutputFile("Enter CVV number in creadit card form is -- > "
										+ CVV));

						Reporter.log(Utilities
								.logOutputFile("Select Expiry date of creadit card - PASS "));
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						Reporter.log(Utilities
								.logOutputFile("Click on Proceed to Final Step button - PASS "));						
						
					
					}
				}			
			}
			
			
			
			
//			#################  Monthly Payment Mode  #################

			
			if (parts[0].trim().equalsIgnoreCase("Monthly Payment")){
				
			    

				MonthlyPayPlanLabelOnPaymentInformationPage.isDisplayed();
				MonthlyPayPlanRadioOnPaymentInformationPage.isDisplayed();

//				writeResult.writeColInExcelFile("Result", "Monthly Payment; By Monthly; Credit or Debit Card", currentCourseUI-1, 8);

				MonthlyPayPlanRadioOnPaymentInformationPage.click();
				courseCost = totalAmountMonthlyPaymentPlanRadioOnPaymentInformationPage.getText();

				secureTransactionImageFooterOnPaymentInformationPage.isDisplayed();
				
				WebDriverWait wait = new WebDriverWait(driver, 30 );
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Customize your')]")));
				
				
				Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Use the calculator below to customize the payments that work for you. Your payments') and contains(text(),'will be automatically processed based on the payment method you choose.')]")).isDisplayed());
				MonthlyPayPlanLabelOnPaymentInformationPage.isDisplayed();
				InitialPaymentText.isDisplayed();
				InitialPaymentTextBox.isDisplayed();
				MonthlyPaymentText.isDisplayed();
				MonthlyPaymentTextBox.isDisplayed();
				CalculateButton.isDisplayed();
				ResetButton.isDisplayed();
//				mailmymonthlypayments.isDisplayed();
//				Checkboxlabel.isDisplayed();
				MonthlyTotalPayment.isDisplayed();
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				Utilities.hardWait(2);
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				Utilities.hardWait(1);

				CalculateButton.click();
				Utilities.hardWait(1);
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter an initial payment") && MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter a monthly payment"));
				driver.findElement(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")).click();
				ResetButton.click();	
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				
				    
			    
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.sendKeys("2");
				CalculateButton.click();				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter a monthly payment"));
				driver.findElement(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")).click();
				ResetButton.click();	
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.sendKeys("2");
				CalculateButton.click();				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter an initial payment"));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
				ResetButton.click(); 
				Utilities.hardWait(3);				  
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.sendKeys("2");
				MonthlyPaymentTextBox.sendKeys("2");
				CalculateButton.click();
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
											
				String CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				String[] getCost = CostfromError.split("\\$");
				getCost = getCost[2].split("\\.");
				int mincost = Integer.parseInt(getCost[0].trim());
				System.out.println(mincost);
				System.out.println(CostfromError);
				Assert.assertTrue(CostfromError.contains("Your initial payment of $2.00 is less than the minimum initial payment of $"+mincost+".00.") || CostfromError.contains("Your monthly payment of $2.00 is less than the minimum monthly payment of $"+mincost+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
				Utilities.hardWait(2);

				
				
				CostfromError = MonthlyTotalPayment.getText();				
				getCost = CostfromError.split("\\$");
				System.out.println(getCost[1].trim());
				getCost = getCost[1].trim().split("\\.");
				
				int maxcost;
				
				String maxcosttext = getCost[0].trim();
				
				if (getCost[0].trim().contains(",")){
				    String str = getCost[0].trim().replace(",", "");
				     maxcost = Integer.parseInt(str);
				    	System.out.println(maxcost);

				}
				else
				{
				     maxcost = Integer.parseInt(getCost[0].trim());
				    	System.out.println(maxcost);
				}
				
				
				
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}

				

				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				
				Assert.assertTrue(CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost-1));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
			
				
				Assert.assertTrue(CostfromError.contains("Your initial payment of $"+Integer.toString(mincost-1)+".00 is less than the minimum initial payment of $"+Integer.toString(mincost)+".00.") || CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
							
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				
				Assert.assertTrue(CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				System.out.println(monthlyPaymentMin.getText());
				
				String str = monthlyPaymentMin.getText();
				getCost = str.split("\\$");
				getCost = getCost[1].split("\\.");
				int MinMonthlyCost = Integer.parseInt(getCost[0].trim());
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(MinMonthlyCost));
				InitialPaymentText.click();
				
				MinCost = Integer.toString(mincost);
				MaxCost = Integer.toString(MinMonthlyCost);
				
				CalculateButton.click();				

				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_par_PaymentCalc_Terms']")));
				
				System.out.println(paymentDescriptionCalculate.getText());
				str = paymentDescriptionCalculate.getText();
				
				int month = (maxcost-mincost)/MinMonthlyCost ;
				int FinalPayment = (maxcost-mincost)%MinMonthlyCost ;
				MonthCount = month;
				FinalPayCost = FinalPayment;
				
				Assert.assertTrue(str.contains("Amount Paid Today: $"+mincost+".00"));
				Assert.assertTrue(str.contains("Monthly Payment: $"+MinMonthlyCost+".00 for "+month+" months"));
				Assert.assertTrue(str.contains("Final Payment: $"+FinalPayment+".00"));
				
//				headingPaymentFrequency.isDisplayed();
				radioMonthly.isDisplayed();
				radio14days.isDisplayed();
				
				str = paymentFrequencyDescription.getText();
				System.out.println(str);
				System.out.println("Every 14 Days ($"+String.format("%.2f", (float) MinMonthlyCost / 2)+".00 every 14 days.)");
				Assert.assertTrue(str.contains("I wish to make my payments:")&& str.contains("Monthly ($"+MinMonthlyCost+".00 once a month.)"));
				Assert.assertTrue(str.contains("Every 14 Days ($"+String.format("%.2f", (float) MinMonthlyCost / 2)+" every 14 days.)"));
				
				
				ByWeeklyPay = "$"+String.format("%.2f", (float) MinMonthlyCost / 2);
//				Select By monthly plan 
				
				if (parts[1].trim().equalsIgnoreCase("By Monthly")){
				    
				    	radioMonthly.click();
									
					wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_Monthly']")));
					
					paymentFrequencymonthlyDescription.getText();
					paymentFrequencyDescriptionMonth.isDisplayed();
					paymentFrequencyDescriptionday.isDisplayed();
					paymentFrequencyDescriptionyear.isDisplayed();
					paymentFrequencyDescriptionCalander.isDisplayed();
					
					DateFormat dateFormat = new SimpleDateFormat("MM,dd,yyyy");
					Calendar cal1 = Calendar.getInstance();
					cal1.add(Calendar.DATE, +2);    
					System.out.println(dateFormat.format(cal1.getTime()));
					String datetoenter = dateFormat.format(cal1.getTime());
					getCost = datetoenter.split(",");
					
					paymentFrequencyDescriptionMonth.sendKeys(getCost[0].trim());
					paymentFrequencyDescriptionday.sendKeys(getCost[1].trim());
					paymentFrequencyDescriptionyear.sendKeys(getCost[2].trim());
					
//					Enter date
					paymentFrequencyOKButton.click();
					try{
					wait = new WebDriverWait(driver, 15);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_CreditDebit']")));
					
					}
					catch(Exception e){
						paymentFrequencyOKButton.click();

						wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_CreditDebit']")));
						
						
					}
				}
				
				
				if (parts[1].trim().equalsIgnoreCase("By 14 days")){
				    
				    	radio14days.click();
									
					wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_span_PaymentFrequency_14Days']")));
					
					
					
					halfdaypaymentFrequencymonthlyDescription.getText();
					halfdayspaymentFrequencyDescriptionMonth.isDisplayed();
					halfdayspaymentFrequencyDescriptionday.isDisplayed();
					halfdayspaymentFrequencyDescriptionyear.isDisplayed();
					halfdayspaymentFrequencyDescriptionCalander.isDisplayed();
					
					DateFormat dateFormat = new SimpleDateFormat("MM,dd,yyyy");
					Calendar cal1 = Calendar.getInstance();
					cal1.add(Calendar.DATE, +2);    
					System.out.println(dateFormat.format(cal1.getTime()));
					String datetoenter = dateFormat.format(cal1.getTime());
					getCost = datetoenter.split(",");
					
					halfdayspaymentFrequencyDescriptionMonth.sendKeys(getCost[0].trim());
					halfdayspaymentFrequencyDescriptionday.sendKeys(getCost[1].trim());
					halfdayspaymentFrequencyDescriptionyear.sendKeys(getCost[2].trim());
					
//					Enter date
					paymentFrequencyOKButton.click();
					
					try{
					wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_CreditDebit']")));
					
					}
					catch(Exception e){
						paymentFrequencyOKButton.click();
						wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_rdo_PaymentInfo_CreditDebit']")));
						
					}
				}
			
			
			wait = new WebDriverWait(driver, 50 );
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='paytoday']")));
			
			str = updatedTodaysPaymentOnPaymentInformationPage.getText();
			
			
			if(str.contains("Please select your payment method:") && str.contains("Credit / Debit Card")&&
					str.contains("Chequing / Savings Account") && str.contains("Payment Information:") &&
					str.contains("Today's Payment:")){
								
				Reporter.log(Utilities.logOutputFile("Verify Options diplsy under  Payment display on Payment Information Page - PASS"));
				
				if (parts[2].trim().equalsIgnoreCase("Checking or Savings Account")){	
															
					savingsAccountRadioOnPaymentInformationPage.click();
					Reporter.log(Utilities.logOutputFile("Select savings account option display on Payment Information Page - PASS"));
					wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_BankNumber']")));

					Assert.assertTrue(BankNumberTextPaymentInformationPage.isDisplayed());
					Assert.assertTrue(TransitNumberTextPaymentInformationPage.isDisplayed());
					Assert.assertTrue(AccountNumberTextPaymentInformationPage.isDisplayed());
					
					
					BankNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.BankNumber"));
					TransitNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.TransitNumber"));
					AccountNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.AccountNumber"));
					proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
					Reporter.log(Utilities.logOutputFile("Click on Proceed to Final Step button - PASS "));
					
					
					
					
				}
				
				if (parts[2].trim().equalsIgnoreCase("Credit or Debit Card")){
					creditCardRadioOnPaymentInformationPage.click();
					Reporter.log(Utilities.logOutputFile("Select creadit card option display on Payment Information Page - PASS"));
					
					 wait = new WebDriverWait(driver, 20);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
					
				
					Assert.assertTrue(labelBillingAddressCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
							.getAttribute("value")
							.equalsIgnoreCase(
									Utilities
											.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")));
					Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelFirstNameCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
							.getAttribute("value").equalsIgnoreCase(lname));
					Assert.assertTrue(labelLastNameCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
							.getAttribute("value")
							.equalsIgnoreCase(
									Utilities
											.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.Address")));
					Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelAddress1CreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxAdderss2CreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
							.getAttribute("value")
							.equalsIgnoreCase(
									Utilities
											.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.City")));
					Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelCityCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxProvinceCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelProvinceCreditCardOnPaymentInformationPage
							.isDisplayed());

					Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
							.getAttribute("value")
							.replace(" ", "")
							.equalsIgnoreCase(
									Utilities
											.getYamlValue(
													"CanadaURLReceiveInformationnocourse.StudentInformation.ZIP")
											.replace(" ", "")));
					Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelPostalCodeCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxCardNumberCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelCardNumberCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxCVVCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelCVVrCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxExpDateMonthCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(textboxExpDateYearCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(labelExpDateCreditCardOnPaymentInformationPage
							.isDisplayed());
					Assert.assertTrue(proceedtoFinalStepCreditCardOnPaymentInformationPage
							.isDisplayed());
					Reporter.log(Utilities
							.logOutputFile("Verify form display under creadit card on Payment Information Page - PASS"));

					
					String CreditCardNumber = Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.CreditCardNumber");
					String CVV = Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.CVV");
					
					try {
						String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
								.getAttribute("value");
						// //System.out.println("firstname is" + firstName);
						textboxFirstNameCreditCardOnPaymentInformationPage.clear();
						String lastName = textboxLastNameCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxLastNameCreditCardOnPaymentInformationPage.clear();
						String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxAdderss1CreditCardOnPaymentInformationPage.clear();
						String address2 = textboxAdderss2CreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxAdderss2CreditCardOnPaymentInformationPage.clear();
						String city = textboxCityCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxCityCreditCardOnPaymentInformationPage.clear();
						String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
						textboxCardNumberCreditCardOnPaymentInformationPage.clear();
						textboxCVVCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterFirstName.isDisplayed();
						pleaseEnterLastName.isDisplayed();
						pleaseEnterAddressInStreet.isDisplayed();
						pleaseEnterYourCity.isDisplayed();
						pleaseEnterYourPostalCode.isDisplayed();
						Pleaseenteryourcreditcardnumber.isDisplayed();
						PleaseenteryourCVVCode.isDisplayed();
						enteryourexpirationmonth.isDisplayed();
						enteryourexpirationyear.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxFirstNameCreditCardOnPaymentInformationPage
								.sendKeys(firstName);
						textboxLastNameCreditCardOnPaymentInformationPage
								.sendKeys(lastName);
						textboxAdderss1CreditCardOnPaymentInformationPage
								.sendKeys(address1);
						textboxAdderss2CreditCardOnPaymentInformationPage
								.sendKeys(address2);
						textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);
						textboxPostalCodeCreditCardOnPaymentInformationPage
								.sendKeys(zipCode);

					} catch (Exception e) {
						// //System.out.println("Error in validating all empty messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();
					}

					textboxCardNumberCreditCardOnPaymentInformationPage
							.sendKeys(CreditCardNumber);
					textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
					Select select = new Select(
							textboxExpDateMonthCreditCardOnPaymentInformationPage);
					select.selectByValue("04");
					Select select1 = new Select(
							textboxExpDateYearCreditCardOnPaymentInformationPage);
					select1.selectByValue("2018");

					try {
						String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxFirstNameCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterFirstName.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxFirstNameCreditCardOnPaymentInformationPage
								.sendKeys(firstName);

					} catch (Exception e) {
						// //System.out.println("Error in validating Enter first name messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						String lastName = textboxLastNameCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxLastNameCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterLastName.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxLastNameCreditCardOnPaymentInformationPage
								.sendKeys(lastName);

					} catch (Exception e) {
						// //System.out.println("Error in validating Enter last name messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxAdderss1CreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterAddressInStreet.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxAdderss1CreditCardOnPaymentInformationPage
								.sendKeys(address1);

					} catch (Exception e) {
						// //System.out.println("Error in validating Enter address messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						String city = textboxCityCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxCityCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterYourCity.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);

					} catch (Exception e) {
						// //System.out.println("Error in validating city messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
								.getAttribute("value");
						textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						pleaseEnterYourPostalCode.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxPostalCodeCreditCardOnPaymentInformationPage
								.sendKeys(zipCode);

					} catch (Exception e) {
						// //System.out.println("Error in validating zip code messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						textboxCardNumberCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						Pleaseenteryourcreditcardnumber.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxCardNumberCreditCardOnPaymentInformationPage
								.sendKeys(CreditCardNumber);

					} catch (Exception e) {
						// //System.out.println("Error in validating Enter Credit Card no. messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();

					}

					try {
						textboxCVVCreditCardOnPaymentInformationPage.clear();
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						PleaseenteryourCVVCode.isDisplayed();
						okbuttonDisplayonPaymentInfoPage.click();
						textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);

					} catch (Exception e) {
						// //System.out.println("Error in validating Enter CVV no. messages on Payment Information Page "
						// + e);
						okbuttonDisplayonPaymentInfoPage.click();
					}

					textboxCardNumberCreditCardOnPaymentInformationPage.clear();
					textboxCVVCreditCardOnPaymentInformationPage.clear();

					Reporter.log(Utilities
							.logOutputFile("Enter information in creadit card form"));
					textboxCardNumberCreditCardOnPaymentInformationPage
							.sendKeys(CreditCardNumber);
					textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
					Reporter.log(Utilities
							.logOutputFile("Enter Credit Card number in creadit card form is -- > "
									+ CreditCardNumber));
					Reporter.log(Utilities
							.logOutputFile("Enter CVV number in creadit card form is -- > "
									+ CVV));

					Reporter.log(Utilities
							.logOutputFile("Select Expiry date of creadit card - PASS "));
					proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
					Reporter.log(Utilities
							.logOutputFile("Click on Proceed to Final Step button - PASS "));						
					
				}
			}
			}	
			
			
			
			if (parts[0].trim().equalsIgnoreCase("Pay By Mail")){   
			    

				MonthlyPayPlanLabelOnPaymentInformationPage.isDisplayed();
				MonthlyPayPlanRadioOnPaymentInformationPage.isDisplayed();

//				writeResult.writeColInExcelFile("Result", "Monthly Payment; By Monthly; Credit or Debit Card", currentCourseUI-1, 8);

				MonthlyPayPlanRadioOnPaymentInformationPage.click();
				courseCost = totalAmountMonthlyPaymentPlanRadioOnPaymentInformationPage.getText();

				secureTransactionImageFooterOnPaymentInformationPage.isDisplayed();
				
				WebDriverWait wait = new WebDriverWait(driver, 50 );
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Customize your')]")));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_chk_PaymentFrequency_PayByMail']")));

				
				
//				#########  Select pay By Mail  ##########


			
				mailmymonthlypayments.click();
				
				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal2")));

				System.out.println("############################");
				System.out.println(mailmymonthlypaymentsWarning.getText());
				System.out.println("############################");
				
				String str = mailmymonthlypaymentsWarning.getText();
				String[] getCost;
				
				getCost = str.split("your total price increases to");
				System.out.println(getCost[1]);
				getCost = getCost[1].split(" To save");
				
				mailmymonthlypaymentsWarningOKbutton.click();
				
				System.out.println(getCost[0]);
				courseCost = getCost[0];
				
				getCost = str.split("your total price increases to");
				System.out.println(getCost[1]);
				getCost = getCost[1].split("\\. To save");
				
				String CourseCostToTrim = getCost[0];
				
				System.out.println("CourseCostToTrim : "+CourseCostToTrim);
				
				Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Use the calculator below to customize the payments that work for you. Your payments') and contains(text(),'will be automatically processed based on the payment method you choose.')]")).isDisplayed());
				MonthlyPayPlanLabelOnPaymentInformationPage.isDisplayed();
				InitialPaymentText.isDisplayed();
				InitialPaymentTextBox.isDisplayed();
				
				MonthlyPaymentText.isDisplayed();
				MonthlyPaymentTextBox.isDisplayed();
				CalculateButton.isDisplayed();
				ResetButton.isDisplayed();
				mailmymonthlypayments.isDisplayed();
				Checkboxlabel.isDisplayed();
				MonthlyTotalPayment.isDisplayed();
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				Utilities.hardWait(2);
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				Utilities.hardWait(1);

				CalculateButton.click();
				Utilities.hardWait(1);
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter an initial payment") && MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter a monthly payment"));
				driver.findElement(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")).click();
				ResetButton.click();	
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				
				    
			    
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.sendKeys("2");
				CalculateButton.click();				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter a monthly payment"));
				driver.findElement(By.id("ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_btnCloseModal")).click();
				ResetButton.click();	
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.sendKeys("2");
				CalculateButton.click();				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));				
				System.out.println(MonthlyTotalOKBlankErrorMessage.getText());				
				Assert.assertTrue(MonthlyTotalOKBlankErrorMessage.getText().contains("Please enter an initial payment"));
				driver.findElement(By.xpath("(//input[@value='OK'])[2]")).click();
				ResetButton.click(); 
				Utilities.hardWait(3);				  
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				
				
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.sendKeys("2");
				MonthlyPaymentTextBox.sendKeys("2");
				CalculateButton.click();
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
											
				String CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				getCost = CostfromError.split("\\$");
				getCost = getCost[2].split("\\.");
				int mincost = Integer.parseInt(getCost[0].trim());
				System.out.println(mincost);
				System.out.println(CostfromError);
				Assert.assertTrue(CostfromError.contains("Your initial payment of $2.00 is less than the minimum initial payment of $"+mincost+".00.") || CostfromError.contains("Your monthly payment of $2.00 is less than the minimum monthly payment of $"+mincost+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[3]")).click();
				Utilities.hardWait(2);

				
				
				CostfromError = CourseCostToTrim;				
				getCost = CostfromError.split("\\$");
				System.out.println(getCost[1].trim());
				getCost = getCost[1].trim().split("\\.");
				
				int maxcost;
				
				String maxcosttext = getCost[0].trim();
				
				if (getCost[0].trim().contains(",")){
				     str = getCost[0].trim().replace(",", "");
				     maxcost = Integer.parseInt(str);
				    	System.out.println(maxcost);

				}
				else
				{
				     maxcost = Integer.parseInt(getCost[0].trim());
				    	System.out.println(maxcost);
				}
				
				
				
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
					InitialPaymentTextBox.click();
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}

				

				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				
				Assert.assertTrue(CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[3]")).click();
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost-1));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
			
				
				Assert.assertTrue(CostfromError.contains("Your initial payment of $"+Integer.toString(mincost-1)+".00 is less than the minimum initial payment of $"+Integer.toString(mincost)+".00.") || CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[3]")).click();
							
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(maxcost+2));
				InitialPaymentText.click();

				CalculateButton.click();				
				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@value='OK'])[2]")));
				
				CostfromError = getErrorMessageMOnthlyPaymentMode.getText();
				System.out.println(CostfromError);
				
				Assert.assertTrue(CostfromError.contains("Your initial and monthly payments amount to a value greater than the total program price of $"+maxcosttext+".00."));
				driver.findElement(By.xpath("(//input[@value='OK'])[3]")).click();
				
				ResetButton.click();
				Utilities.hardWait(3);
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='caltxtfrm'])[1]")));
				for (int i=1;i<25;i++)
				{
					InitialPaymentTextBox.click();
				    if(InitialPaymentTextBox.getAttribute("value").equals("") || InitialPaymentTextBox.getAttribute("value").equals(null)){
					break;
				    }else{
					    System.out.println(InitialPaymentTextBox.getAttribute("value"));
					    Utilities.hardWait(1);
				    }
				}
				
				System.out.println(monthlyPaymentMin.getText());
				
				 str = monthlyPaymentMin.getText();
				getCost = str.split("\\$");
				getCost = getCost[1].split("\\.");
				int MinMonthlyCost = Integer.parseInt(getCost[0].trim());
				

				InitialPaymentTextBox.click();
				InitialPaymentTextBox.clear();
				InitialPaymentTextBox.sendKeys(Integer.toString(mincost));
				MonthlyPaymentTextBox.click();
				MonthlyPaymentTextBox.clear();
				MonthlyPaymentTextBox.sendKeys(Integer.toString(MinMonthlyCost));
				InitialPaymentText.click();
				
        			MinCost = Integer.toString(mincost);
        			MaxCost = Integer.toString(MinMonthlyCost);
				
				CalculateButton.click();				

				
				wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_par_PaymentCalc_Terms']")));
				
				System.out.println(paymentDescriptionCalculate.getText());
				str = paymentDescriptionCalculate.getText();
				
				int month = (maxcost-mincost)/MinMonthlyCost ;
				int FinalPayment = (maxcost-mincost)%MinMonthlyCost ;
				MonthCount = month;
				FinalPayCost = FinalPayment;
				System.out.println("maxcost : "+maxcost);
				System.out.println("mincost : "+mincost);
				System.out.println("MinMonthlyCost : "+MinMonthlyCost);
				System.out.println("month : "+month);
				Assert.assertTrue(str.contains("Amount Paid Today: $"+mincost+".00"));
				Assert.assertTrue(str.contains("Monthly Payment: $"+MinMonthlyCost+".00 for "+month+" months"));
				Assert.assertTrue(str.contains("Final Payment: $"+FinalPayment+".00"));
				
				paymentFrequencyOKButton.click();
				

//				#########################################
				
				wait = new WebDriverWait(driver, 50 );
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='paytoday']")));
				
				str = updatedTodaysPaymentOnPaymentInformationPage.getText();
				
				
				if(str.contains("Please select your payment method:") && str.contains("Credit / Debit Card")&&
						str.contains("Chequing / Savings Account") && str.contains("Payment Information:") &&
						str.contains("Today's Payment:")){
									
					Reporter.log(Utilities.logOutputFile("Verify Options diplsy under  Payment display on Payment Information Page - PASS"));
					
					if (parts[1].trim().equalsIgnoreCase("Checking or Savings Account")){	
																
						savingsAccountRadioOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Select savings account option display on Payment Information Page - PASS"));
						wait = new WebDriverWait(driver, 10);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_ctl00_MasterContentPlaceHolder_NestedMasterContentPlaceHolder_Form_txt_PaymentInfo_ACH_CAN_BankNumber']")));

						Assert.assertTrue(BankNumberTextPaymentInformationPage.isDisplayed());
						Assert.assertTrue(TransitNumberTextPaymentInformationPage.isDisplayed());
						Assert.assertTrue(AccountNumberTextPaymentInformationPage.isDisplayed());
						
						
						BankNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLEnrollNownocourse.BankNumber"));
						TransitNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLEnrollNownocourse.TransitNumber"));
						AccountNumberTextPaymentInformationPage.sendKeys(Utilities.getYamlValue("CanadaURLEnrollNownocourse.AccountNumber"));
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Click on Proceed to Final Step button - PASS "));
						
						
						
						
					}
					
					if (parts[1].trim().equalsIgnoreCase("Credit or Debit Card")){
						creditCardRadioOnPaymentInformationPage.click();
						Reporter.log(Utilities.logOutputFile("Select creadit card option display on Payment Information Page - PASS"));
						
						 wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='checkbox']")));
						
					
						Assert.assertTrue(labelBillingAddressCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLEnrollNownocourse.StudentInformation.FirstName")));
						Assert.assertTrue(textboxFirstNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelFirstNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxLastNameCreditCardOnPaymentInformationPage
								.getAttribute("value").equalsIgnoreCase(lname));
						Assert.assertTrue(labelLastNameCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLEnrollNownocourse.StudentInformation.Address")));
						Assert.assertTrue(textboxAdderss1CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelAddress1CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxAdderss2CreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue("CanadaURLEnrollNownocourse.StudentInformation.City")));
						Assert.assertTrue(textboxCityCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCityCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxProvinceCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelProvinceCreditCardOnPaymentInformationPage
								.isDisplayed());

						Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
								.getAttribute("value")
								.replace(" ", "")
								.equalsIgnoreCase(
										Utilities
												.getYamlValue(
														"CanadaURLEnrollNownocourse.StudentInformation.ZIP")
												.replace(" ", "")));
						Assert.assertTrue(textboxPostalCodeCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelPostalCodeCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCardNumberCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCardNumberCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxCVVCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelCVVrCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxExpDateMonthCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(textboxExpDateYearCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(labelExpDateCreditCardOnPaymentInformationPage
								.isDisplayed());
						Assert.assertTrue(proceedtoFinalStepCreditCardOnPaymentInformationPage
								.isDisplayed());
						Reporter.log(Utilities
								.logOutputFile("Verify form display under creadit card on Payment Information Page - PASS"));

						
						String CreditCardNumber = Utilities.getYamlValue("CanadaURLEnrollNownocourse.StudentInformation.CreditCardNumber");
						String CVV = Utilities.getYamlValue("CanadaURLEnrollNownocourse.StudentInformation.CVV");
						
						try {
							String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							// //System.out.println("firstname is" + firstName);
							textboxFirstNameCreditCardOnPaymentInformationPage.clear();
							String lastName = textboxLastNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxLastNameCreditCardOnPaymentInformationPage.clear();
							String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss1CreditCardOnPaymentInformationPage.clear();
							String address2 = textboxAdderss2CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss2CreditCardOnPaymentInformationPage.clear();
							String city = textboxCityCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxCityCreditCardOnPaymentInformationPage.clear();
							String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
							textboxCardNumberCreditCardOnPaymentInformationPage.clear();
							textboxCVVCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterFirstName.isDisplayed();
							pleaseEnterLastName.isDisplayed();
							pleaseEnterAddressInStreet.isDisplayed();
							pleaseEnterYourCity.isDisplayed();
							pleaseEnterYourPostalCode.isDisplayed();
							Pleaseenteryourcreditcardnumber.isDisplayed();
							PleaseenteryourCVVCode.isDisplayed();
							enteryourexpirationmonth.isDisplayed();
							enteryourexpirationyear.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxFirstNameCreditCardOnPaymentInformationPage
									.sendKeys(firstName);
							textboxLastNameCreditCardOnPaymentInformationPage
									.sendKeys(lastName);
							textboxAdderss1CreditCardOnPaymentInformationPage
									.sendKeys(address1);
							textboxAdderss2CreditCardOnPaymentInformationPage
									.sendKeys(address2);
							textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);
							textboxPostalCodeCreditCardOnPaymentInformationPage
									.sendKeys(zipCode);

						} catch (Exception e) {
							// //System.out.println("Error in validating all empty messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();
						}

						textboxCardNumberCreditCardOnPaymentInformationPage
								.sendKeys(CreditCardNumber);
						textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
						Select select = new Select(
								textboxExpDateMonthCreditCardOnPaymentInformationPage);
						select.selectByValue("04");
						Select select1 = new Select(
								textboxExpDateYearCreditCardOnPaymentInformationPage);
						select1.selectByValue("2018");

						try {
							String firstName = textboxFirstNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxFirstNameCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterFirstName.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxFirstNameCreditCardOnPaymentInformationPage
									.sendKeys(firstName);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter first name messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String lastName = textboxLastNameCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxLastNameCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterLastName.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxLastNameCreditCardOnPaymentInformationPage
									.sendKeys(lastName);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter last name messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String address1 = textboxAdderss1CreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxAdderss1CreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterAddressInStreet.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxAdderss1CreditCardOnPaymentInformationPage
									.sendKeys(address1);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter address messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String city = textboxCityCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxCityCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterYourCity.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCityCreditCardOnPaymentInformationPage.sendKeys(city);

						} catch (Exception e) {
							// //System.out.println("Error in validating city messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							String zipCode = textboxPostalCodeCreditCardOnPaymentInformationPage
									.getAttribute("value");
							textboxPostalCodeCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							pleaseEnterYourPostalCode.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxPostalCodeCreditCardOnPaymentInformationPage
									.sendKeys(zipCode);

						} catch (Exception e) {
							// //System.out.println("Error in validating zip code messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							textboxCardNumberCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							Pleaseenteryourcreditcardnumber.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCardNumberCreditCardOnPaymentInformationPage
									.sendKeys(CreditCardNumber);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter Credit Card no. messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();

						}

						try {
							textboxCVVCreditCardOnPaymentInformationPage.clear();
							proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
							PleaseenteryourCVVCode.isDisplayed();
							okbuttonDisplayonPaymentInfoPage.click();
							textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);

						} catch (Exception e) {
							// //System.out.println("Error in validating Enter CVV no. messages on Payment Information Page "
							// + e);
							okbuttonDisplayonPaymentInfoPage.click();
						}

						textboxCardNumberCreditCardOnPaymentInformationPage.clear();
						textboxCVVCreditCardOnPaymentInformationPage.clear();

						Reporter.log(Utilities
								.logOutputFile("Enter information in creadit card form"));
						textboxCardNumberCreditCardOnPaymentInformationPage
								.sendKeys(CreditCardNumber);
						textboxCVVCreditCardOnPaymentInformationPage.sendKeys(CVV);
						Reporter.log(Utilities
								.logOutputFile("Enter Credit Card number in creadit card form is -- > "
										+ CreditCardNumber));
						Reporter.log(Utilities
								.logOutputFile("Enter CVV number in creadit card form is -- > "
										+ CVV));

						Reporter.log(Utilities
								.logOutputFile("Select Expiry date of creadit card - PASS "));
						proceedtoFinalStepCreditCardOnPaymentInformationPage.click();
						Reporter.log(Utilities
								.logOutputFile("Click on Proceed to Final Step button - PASS "));						
						
					}
					}

			}
		
			}
		

		public boolean verifyElementsOnReviewAndSubmitPage()
		{
			boolean result = true;
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='agree_header']")));
			
			Reporter.log(Utilities.logOutputFile("Verify redirect user to review & submit page - PASS "));

			String PersonalInformation = p1.getText();
			if (PersonalInformation.contains("Personal Information") &&	  PersonalInformation.contains("Personal Information") &&
					PersonalInformation.contains("First Name:")      &&   PersonalInformation.contains("Last Name:")           &&
					PersonalInformation.contains("Address:")         &&	  PersonalInformation.contains("City:")                &&
					PersonalInformation.contains("State:")           &&   PersonalInformation.contains("Zip Code:")            &&
					PersonalInformation.contains("Country:")         &&   PersonalInformation.contains("Email:")               &&
					PersonalInformation.contains("Phone (Other):")   &&   PersonalInformation.contains("Birth Date"))
			{
				Reporter.log(Utilities.logOutputFile("Information Display under Personal Information Heading - PASS "));

			}
			else
			{
				//System.out.println(p1.getText());
				result = false;
				Reporter.log(Utilities.logOutputFile("Information Display under Personal Information Heading - FAIL "));

				return result;
			}
			
			String ProgramInformation = p2.getText();
			if (ProgramInformation.contains("Program Information")    &&	ProgramInformation.contains("Program:")               &&
					ProgramInformation.contains("Program Price:")     &&	ProgramInformation.contains("Initial Payment:")       &&
					ProgramInformation.contains("Monthly Payment:")   &&	ProgramInformation.contains("# of Monthly Payments:") &&
					ProgramInformation.contains("Final Payment:"))
			{
				Reporter.log(Utilities.logOutputFile("Information Display under Program Information Heading - PASS "));

			}
			else
			{
				//System.out.println(p2.getText());
				result = false;
				Reporter.log(Utilities.logOutputFile("Information Display under Program Information Heading - FAIL "));

				return result;
			}
			
			
			String PaymentInformation  = p3.getText();
			if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.PaymentMode").equalsIgnoreCase("Checking or Savings Account"))
			{
				if (PaymentInformation.contains("Amount Charged Today")     &&	PaymentInformation.contains("Payment Information") &&
						PaymentInformation.contains("Account Number")   &&	PaymentInformation.contains("Monthly Payment:"))
				{
					Reporter.log(Utilities.logOutputFile("Information Display under Payment Information Heading - PASS "));
				}
				else
				{
					//System.out.println(p3.getText());
					result = false;
					Reporter.log(Utilities.logOutputFile("Information Display under Payment Information Heading - FAIL "));

					return result;
				}
				
			}else{
				if (PaymentInformation.contains("Amount Charged Today")     &&	PaymentInformation.contains("Payment Information") &&
						PaymentInformation.contains("Credit Card Number")   &&	PaymentInformation.contains("Exp. Date:")          &&
						PaymentInformation.contains("Monthly Payment:"))
				{
					Reporter.log(Utilities.logOutputFile("Information Display under Payment Information Heading - PASS "));
				}
				else
				{
					//System.out.println(p3.getText());
					result = false;
					Reporter.log(Utilities.logOutputFile("Information Display under Payment Information Heading - FAIL "));

					return result;
				}				
			}
			
						
			return result;
		}
		
		public void clickPersonalInfoEditButtonOnReviewAndSubmit() {
			Assert.assertTrue(EditPersonalInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditProgramInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditPaymentInfoOnReviewAndSubmitPage.isDisplayed());
			EditPersonalInfoOnReviewAndSubmitPage.click();
		}

		public void clickProgramInfoEditButtonOnReviewAndSubmit() {
			Assert.assertTrue(EditPersonalInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditProgramInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditPaymentInfoOnReviewAndSubmitPage.isDisplayed());
			EditProgramInfoOnReviewAndSubmitPage.click();
		}

		public void clickPaymentInfoEditButtonOnReviewAndSubmit() {
			Assert.assertTrue(EditPersonalInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditProgramInfoOnReviewAndSubmitPage.isDisplayed());
			Assert.assertTrue(EditPaymentInfoOnReviewAndSubmitPage.isDisplayed());
			EditPaymentInfoOnReviewAndSubmitPage.click();
		}

		public boolean acceptTermandConditionOnReviewAndSubmitPage()
		{
			int m = 0;
			Assert.assertTrue(checkboxLabelTermandConditionOnReviewAndSubmitPage.isDisplayed());
			checkboxTermandConditionOnReviewAndSubmitPage.click();
			enrollTermandConditionOnReviewAndSubmitPage.click();
			
			try{
				textElectronicSignature.isDisplayed();
//				textElectronicSignature.getText().contains("Electronic Signature");
				radiobuttonSignyourEnrollmentMailed.isDisplayed();
				
				radiobuttonSignyourEnrollmentAgreementOnline.click();
				nextButtonDisplayOnElectronicSignature.click();	
				
				yesLinkonDisplayOnElectronicSignature.isDisplayed();
				noLinkonDisplayOnElectronicSignature.isDisplayed();
				if (Utilities.getYamlValue(
						"CanadaURLReceiveInformationnocourse.SignDocElectronically")
						.equalsIgnoreCase("yes")) {
					yesLinkonDisplayOnElectronicSignature.click();
					textElectronicSignature.isDisplayed();
					textboxNameOnElectronicSigAgreement.isDisplayed();
					textboxEmailOnElectronicSigAgreement.isDisplayed();
					String Name = Utilities
							.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")
							+ " "
							+ Utilities
									.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.LastName");
					try {
						String DOB = Utilities
								.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBmonth")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBday")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOByear");
						Assert.assertTrue(StudentIDOnElectronicSigAgreement
								.isDisplayed());
						// if(StudentIDOnElectronicSigAgreement.isDisplayed()){
						// Reporter.log(Utilities.logOutputFile(" Final "+StudentIDOnElectronicSigAgreement.getText()+" - Pass"));
						// }
						Assert.assertTrue(StudentIDOnElectronicSigAgreement
								.getText().contains("Student ID"));
						Assert.assertTrue(StudentNameOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentNameOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")
												.toUpperCase()));
						Assert.assertTrue(StudentNameOnElectronicSigAgreement
								.getText().contains(lname.toUpperCase()));
						Assert.assertTrue(StudentAddressOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentAddressOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.Address")
												.toUpperCase()));
						Assert.assertTrue(StudentAddressOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.City")
												.toUpperCase()));
						Assert.assertTrue(StudentAddressOnElectronicSigAgreement
								.getText()
								.replace(" ", "")
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.ZIP")
												.replace(" ", "")));
						Assert.assertTrue(StudentAddressOnElectronicSigAgreement
								.getText().contains("ON"));
						Assert.assertTrue(PersonalDataOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(PersonalDataOnElectronicSigAgreement
								.getText().contains(DOB));
						Assert.assertTrue(EmailOnElectronicSigAgreement
								.getText()
								.contains(
										email.toUpperCase()
												+ "@"
												+ Utilities
														.getYamlValue(
																"CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt")
														.toUpperCase()));
						Assert.assertTrue(PaymentOnElectronicSigAgreement.getText()
								.contains(courseCost.substring(13)));
					} catch (Exception e) {

						////System.out.println(e);
						 //System.out.println("Error in validating fields4 "+e);
					}
					textboxNameOnElectronicSigAgreement.sendKeys(Name);
					textboxEmailOnElectronicSigAgreement
							.sendKeys(email
									+ "@"
									+ Utilities
											.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt"));
					submitBtnOnElectronicSigAgreementPage.click();
					WebDriverWait wait = new WebDriverWait(driver, 50);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//span[contains(text(),'Click Here to Sign')]")));
					try {
						String DOB = Utilities
								.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBmonth")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBday")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOByear");
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains("Student ID"));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.Address")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.City")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.replace(" ", "")
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.ZIP")
												.replace(" ", "")));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains("ON"));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains(DOB));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										email.toUpperCase()
												+ "@"
												+ Utilities
														.getYamlValue(
																"CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt")
														.toUpperCase()));
						Assert.assertTrue(PaymentDetailsOnElectronicSigAgreement
								.getText().contains(courseCost.substring(13)));
					} catch (Exception e) {

						////System.out.println(e);
						//System.out.println("Error in validating fields1 "+e);
					}
					ClickToSignInOnElectronicSigAgreement.click();
					WebDriverWait wait1 = new WebDriverWait(driver, 50);
					wait1.until(ExpectedConditions.visibilityOfElementLocated(By
							.xpath("//span[contains(text(),'Click Here to Continue')]")));
					try {
						String DOB = Utilities
								.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBmonth")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOBday")
								+ "/"
								+ Utilities
										.getYamlValue("CanadaURLReceiveInformationnocourse.StudentInformation.DOByear");
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains("Student ID"));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.FirstName")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.Address")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.City")
												.toUpperCase()));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.replace(" ", "")
								.contains(
										Utilities
												.getYamlValue(
														"CanadaURLReceiveInformationnocourse.StudentInformation.ZIP")
												.replace(" ", "")));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains("ON"));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.isDisplayed());
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText().contains(DOB));
						Assert.assertTrue(StudentInfoOnElectronicSigAgreement
								.getText()
								.contains(
										email.toUpperCase()
												+ "@"
												+ Utilities
														.getYamlValue(
																"CanadaURLReceiveInformationnocourse.StudentInformation.EmailExt")
														.toUpperCase()));
						Assert.assertTrue(PaymentDetailsOnElectronicSigAgreement
								.getText().contains(courseCost.substring(13)));
					} catch (Exception e) {

						////System.out.println(e);
						//System.out.println("Error in validating fields2 "+e);
					}
					String ID = StudentInfoOnElectronicSigAgreement.getText();
					String StudentID = ID.substring(0, 20);
					//System.out.println(ID.substring(0, 20));
					ClickToContinueInOnElectronicSigAgreement.click();
					try {
						clickHereLinkOnCongratulationsPage.isDisplayed();
//						Reporter.log(Utilities.logOutputFile(" Final "
//								+ getStudentIDFromCongratulationsPage.getText()
//								+ " for Enroll Link1 - Pass"));
						m = 1;
						// //System.out.println("$$$$$$$$$$  Completed Student ID is --> "+getStudentIDFromCongratulationsPage.getText());
					} catch (Exception e) {
						//System.out.println("Error in validating fields3 "+e);
						Reporter.log(Utilities.logOutputFile(" Final " + StudentID
								+ " - Pass"));
						Reporter.log(Utilities
								.logOutputFile("ID Generated and Exception Page displayed on final Enroll"));

					}

				} else {
					noLinkonDisplayOnElectronicSignature.click();
					clickHereLinkOnCongratulationsPage.isDisplayed();
//					Reporter.log(Utilities.logOutputFile(" Final Student ID is "
//							+ getStudentIDFromCongratulationsPage.getText()
//							+ " for enroll link2 - Pass"));		
//				noLinkonDisplayOnElectronicSignature.click();
//				
////				textElectronicSignature.getText().contains("Congratulations");
//				clickHereLinkOnCongratulationsPage.isDisplayed();
				m = 1;
				}
			}catch(Exception e){				
				//System.out.println("$$$$$$$$$$  Completed Student ID is  exit--> ");

				WebDriverWait wait = new WebDriverWait(driver, 50);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Congratulations')]")));

				if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){
					writeResult.writeColInExcelFile("Result", "ID not generated", currentCourseUI-1, 9);

		        }else{
		        	 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
		 				writeResult.writeColInExcelFile("Result", "ID not generated", currentCourseUI-1, 9);
		                 }
		        	
		        }
				
				txtCongratulationsOnReviewAndSubmitPage.isDisplayed();
				Reporter.log(Utilities.logOutputFile(" Final Student ID not genrated application display only is Congratulations page"));
				
			}			
			
			if (m==1)
			{
				//System.out.println("$$$$$$$$$$$  DONE   $$$$$$$$$$$$$");
				try{
					Reporter.log(Utilities.logOutputFile(" Final Student ID is "+getStudentIDFromCongratulationsPage.getText()+" - Pass"));
					//System.out.println("$$$$$$$$$$  Completed Student ID is --> "+getStudentIDFromCongratulationsPage.getText());
					 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){
							writeResult.writeColInExcelFile("Result", getStudentIDFromCongratulationsPage.getText(), currentCourseUI-1, 9);

				        }else{
				        	 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
				 				writeResult.writeColInExcelFile("Result", getStudentIDFromCongratulationsPage.getText(), currentCourseUI-1, 9);   
				                 }
				        	
				        }
					 
				}catch(Exception e){	
					
					try{
						Reporter.log(Utilities.logOutputFile(" Final Student ID is "+getStudentIDFromCongratulationsPage2.getText()+" - Pass"));
						//System.out.println("$$$$$$$$$$  Completed Student ID is --> "+getStudentIDFromCongratulationsPage2.getText());

						 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("AllCources")){
								writeResult.writeColInExcelFile("Result", getStudentIDFromCongratulationsPage2.getText(), currentCourseUI-1, 9);

					        }else{
					        	 if (Utilities.getYamlValue("CanadaURLReceiveInformationnocourse.RunType").equalsIgnoreCase("Selected")){
					 				writeResult.writeColInExcelFile("Result", getStudentIDFromCongratulationsPage2.getText(), currentCourseUI-1, 9);   
					                 }
					        	
					        }
					}catch(Exception em){
						writeResult.writeColInExcelFile("Result", "ID not generated", currentCourseUI-1, 9);				
						Reporter.log(Utilities.logOutputFile(" Final Student ID not genrated application display only is Congratulations page"));
						
					}
					
				}			
			
			}
			
			return true;
			}



}
