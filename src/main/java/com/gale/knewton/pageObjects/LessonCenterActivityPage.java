package com.gale.knewton.pageObjects;



import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.interactions.Actions;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;
import com.gargoylesoftware.htmlunit.javascript.host.Document;

import cucumber.api.java.it.Date;

public class LessonCenterActivityPage extends BaseWebComponent {
	private String lnk_activity_xpath="//h3[@class='lpn_name']/a[not(contains(text(),'Overview - Knewton')) and contains(text(),'${activityname}')]";
	private String iframe_Lesson_Center_activity_css = "iframe[title*='Lesson Center App App']";
	private String iframe_nested_activity_css = "#easyXDM_activityService_cxp_target_rec_provider";
	private String mastery_active_css = "li.ng-isolate-scope.active";
	private String txt_assessment_availablity_css = "ul.nav.nav-tabs>span";
	private String txt_Assessment_xpath = "//a[contains(text(),'ASSESSMENT')]";
	private String Assessment_tab_css = "li.ng-isolate-scope.disabled";
	private String Assessment_tab_active_css = "li.ng-isolate-scope.active";
	private String btn_Assessment_header = "//li/a[contains(text(),'ASSESSMENT')]";
	private String Lc_activity_error_css = "p.ng-binding";
	private String btn_submit_Answer_css = "input[value*='Submit']";
	private String btn_next_css = "input[value*='Next']";
	private String radio_option_one_xpath = "(//div[@class='ci-choices']/div/span/span/input)[1]";
	private String radio_choices_xpath = "//div[@class='ci-choices']";
	private String radio_option_two_xpath = "(//input[@type='radio'])[2]";
	private String txt_mastery_achevied = "(//div[@id='masteryMessage']/div)[1]";
	private String txt_header_mastery_message = "//span[contains(text(),'Mastery achieved !')]";
	private String btn_continue_mastery_id = "continueRecommendations";
	private String txt_content_mastery_css = ".ci-content";
	private String radio_btn_assessment_xpath = "(//span[@class='ci-choice-indicator']/input)[1]";
	private String btn_check_my_work = "(//input[@value='Check My Work'])[1]";
	private String btn_Assessment_Next = ".next-button";
	private String feedback_assessment_css = ".ci-feedback-title";
	private String btn_reviewSubmit_css = "#nav-group-submit>button";
	private String btn_done_with_Grading_css = "#rhs-finalsubmit";
	private String txt_assessment_review = ".staticAssessmentInfo.ng-binding.ng-scope";
	private String txt_total_score = ".total>td:nth-child(3)";
	private String submit_score_css = ".current-points";
	private String txt_activity_instruction_material = "//div[@id='examTitle']/h2/span";
	
	private String activityDynamicXpath;
	Actions action = new Actions(driver);
	public static int number=0;
	public static int i=1;

	public void isLessonCenterActivitiesDisplayed() {
		for(int i=0;i<3;i++)
		{
		activityDynamicXpath = getLocator(lnk_activity_xpath
				,
				PropFileHandler.readProperty("LessonCenterName"+number,
						(YamlReader.getData("propertyfilepath"))));
		System.out.println(activityDynamicXpath+"Lesson center activity");
		
		Assert.assertTrue(findElementByXpath(activityDynamicXpath).isDisplayed());
		number++;
		}
		
	}
	public boolean isMasteryTabActive()
	{ 
		boolean flag=false;
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
	    flag=findElementByCssPath(mastery_active_css).getAttribute("class").contains("active");
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isAssessmentTabDisabled()
	{
	    boolean flag=false;
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
		doHoverOverElement(findElementByXpath(txt_Assessment_xpath));
	    flag=findElementByCssPath(Assessment_tab_css).getAttribute("class").contains("disabled");
		switchToDefaultContent();
		return flag;
	}
	
	public void verifyAssessmentNotAvailablityMessage()
	{
		switchToFrameByCss(iframe_Lesson_Center_activity_css);	
		findElementByCssPath(txt_assessment_availablity_css).getText().contains("Assessment will be available when you achieve Mastery or on");
		switchToDefaultContent();
		
	}
	public void openOtherLcActivity(int num) {
		activityDynamicXpath = getLocator(lnk_activity_xpath
				,
				PropFileHandler.readProperty("LessonCenterName"+(num-1),
						(YamlReader.getData("propertyfilepath"))));
		System.out.println(activityDynamicXpath+"Lesson center activity");
		findElementByXpath(activityDynamicXpath).click();
	}
	public void verifyStudentNotAbleToTakeFutureLCs(String Error) {
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
		System.out.println(Error);
		String ExpectedError=findElementByCssPath(Lc_activity_error_css).getText();
		System.out.println(ExpectedError);
		Assert.assertTrue(ExpectedError.equals(Error));
		switchToDefaultContent();
	}

	public void attemptMasteryQuestions() {
		    switchToDefaultContent();
		    switchToFrameByCss(iframe_Lesson_Center_activity_css);
		    //switchToFrameByCss(iframe_nested_activity_css);
		    switchToFrameByIndex(0);
			waitAndLocateElementByXpath(radio_option_one_xpath).click();
		    Assert.assertTrue(findElementByXpath(radio_option_one_xpath).isEnabled());
			findElementByCssPath(btn_submit_Answer_css).click();
			switchToDefaultContent();
	}
	
	
	public void clickNextButton() {
		
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
		findElementByCssPath(btn_next_css).click();
		switchToDefaultContent();
	}

	public void verifyStudentIsAbleToSeeMasteryAcheivedMessage()
	{
		hardWait(2);
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
		String msg=waitAndLocateElementByXpath(txt_mastery_achevied).getText();
		System.out.println(msg);
		String MasteryMessage=YamlReader.getYamlValue("MasteryMessage");
		System.out.println(MasteryMessage);
		Assert.assertTrue(msg.equals(MasteryMessage));
		switchToDefaultContent();
	}

public void verifyStudentIsAbleToSeeMasteryAcheivedMessageOnTopHeader()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	Assert.assertTrue(waitAndLocateElementByXpath(txt_header_mastery_message).getText().equals("Mastery achieved !"));
	switchToDefaultContent();
}

public void clickContinueButtonOnMastery()
{
switchToFrameByCss(iframe_Lesson_Center_activity_css);
findElementById(btn_continue_mastery_id).click();	
switchToDefaultContent();
hardWait(4);
}
public void verifyAssessmentUnlockedMessage() {
	
	switchToFrameByCss(iframe_Lesson_Center_activity_css);	
	findElementByCssPath(txt_assessment_availablity_css).getText().contains("Assessment is now unlocked and ready for you to take");
	switchToDefaultContent();
}

public void isAssessmentTabEnabled()
{
	
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	doHoverOverElement(findElementByXpath(txt_Assessment_xpath));
   Assert.assertTrue(findElementByCssPath(Assessment_tab_active_css).getAttribute("class").contains("active"));
	switchToDefaultContent();
}

public void verifyStudentReceiveAdditionalRecomendation()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
    switchToFrameByIndex(0);
Assert.assertTrue(findElementByCssPath(txt_content_mastery_css).isDisplayed());
    switchToDefaultContent();
    
}
public void clickOnAssessmentTab() {
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	hardWait(3);
	try
	{
	doHoverOverElement(findElementByXpath(txt_Assessment_xpath));
	}
	catch(StaleElementReferenceException e)
	{
		switchToDefaultContent();
		switchToFrameByCss(iframe_Lesson_Center_activity_css);
		waitForElementToBePresent(findElementByXpath(btn_Assessment_header));
	}
	  findElementByXpath(btn_Assessment_header).click();
	  switchToDefaultContent();
	
}
public void clickRadioButtonForAssessmentQuestions() {
	
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	//switchToFrameByCss(iframe_nested_activity_css);
	switchToFrameByIndex(0);
	/*activityDynamicXpath = getLocator(radio_btn_assessment_xpath, Integer.toString(i));
	System.out.println(activityDynamicXpath);
	findElementByXpath(activityDynamicXpath).click();*/
	hardWait(3);
	findElementByXpath(radio_btn_assessment_xpath).click();
	switchToDefaultContent();
	
}
public void clickCheckMyWorkButton() {
	hardWait(3);
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	waitForElementToBePresent(findElementByCssPath(btn_check_my_work)).click();
    //findElementByXpath(btn_check_my_work).click();
    switchToDefaultContent();
	
}
public void clickTryAnotherVersionButton() {
	// TODO Auto-generated method stub
	
}
public void clickNextButtonforAssessmentQuestions() {
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	findElementByCssPath(btn_Assessment_Next).click();
	switchToDefaultContent();
	
}

public void isFeedbackShown()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	Assert.assertTrue(waitAndLocateElementByCss(feedback_assessment_css).isDisplayed());
	switchToDefaultContent();
}

public void clickOnReviewAndSubmitButton()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	findElementByCssPath(btn_reviewSubmit_css).click();
	switchToDefaultContent();
}

public void clickIamDoneWithGradingButton()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	waitForElementToBePresent(findElementByCssPath(btn_done_with_Grading_css));
	findElementByCssPath(btn_done_with_Grading_css).click();
	switchToDefaultContent();
}

public void verifyAssessementIsSubmittedOnClickingDoneWithGradingButton()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
String message=	findElementByCssPath(txt_assessment_review).getText();
Assert.assertTrue(message.equals("Assessment is complete and available for review."));
switchToDefaultContent();
	
}

public void isAssessmentScoreDisplayedUnderReviewAndSubmitTag()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	char Score=findElementByCssPath(txt_total_score).getText().charAt(0);
	System.out.println(Score);
	String TotalScore=Character.toString(Score);
	System.out.println(TotalScore);
	String SubmittedScore=findElementByCssPath(submit_score_css).getText();
	System.out.println(SubmittedScore);
	Assert.assertTrue(SubmittedScore.equals(TotalScore));
	switchToDefaultContent();
}

public void isIncludedPrerequisiteDisplayedOnActivity()
{

}

public void isIncludedInstructionMaterialDisplayedOnActivity()
{
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	switchToFrameByIndex(0);
	String InstructionMaterial=findElementByXpath(txt_activity_instruction_material).getText();
	String SavedInstructionMaterial=PropFileHandler.readProperty("InstructionMaterial", YamlReader.getYamlValue("propertyfilepath"));
	Assert.assertTrue(InstructionMaterial.equals(SavedInstructionMaterial));
	switchToDefaultContent();
}
	
public void verifyAssessmentTabIsNotAvailableIfItIsNotIncluded()
{
	
	switchToFrameByCss(iframe_Lesson_Center_activity_css);
	Assert.assertFalse(findElementByXpath(btn_Assessment_header).isDisplayed());
	switchToDefaultContent();
}
}
