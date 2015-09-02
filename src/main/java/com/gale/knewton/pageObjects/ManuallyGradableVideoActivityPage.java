package com.gale.knewton.pageObjects;


//import org.junit.Assert;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ManuallyGradableVideoActivityPage extends BaseWebComponent {

	private String practiceVideo_xpath = "//Video";
	private String textArea_css = ".ci-essay textarea";
	private String btn_next_css = ".next-button";
	private String btn_gradeNow_css = "#rhs-finalsubmit";
	private String btn_reviewAndSubmit_xpath= "//li[@class='group current']//button[contains(text(),'Review')]";
	private String grove_frame_css ="iframe[title='Assessments App']";
	private String gradingMessage_css = ".explanation";
	private String frame2_Submit_id ="easyXDM_activityService_cxp_Target_provider"; 
	private String gradable_activity_xpath = "//span[contains(text(),'${activityName}')]";
	private String activityDynamicXpath;
	private String student_name_xpath = "//a[contains(text(),'Stu01,')]";
	private String btn_view_xpath ="(//button[contains(text(),'View')])[1]";
	
	/////////// Student End //////////////////////
	
	private String btn_review_xpath = "//input[@value='Review']";
	private String txt_pendingGraded_xpath = "//*[contains(text(),'Pending grading by instructor')]";
	private String txt_selectGradeDetails = "//h4[contains(.,'Selected Question Grade Details')]";
	private String ereader_frame_css = ".ereader_iframe";
	private String appFrame_id = "analyticsFrame";
	private String warning_message_xpath="(//div[contains(@class,'alert-warning')])[1]";
	
	private String frame2inline_Submit_class = "appFrame";
	private String frame3inline_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String btn_startActivitySA_css= "#rhs-start";
	private String answer_optionAnd_xpath = "(//*[@class='q4-choice']//input)[1]";
	private String answer_optionGul_xpath = "(//*[@class='ci-choices']//input)[1]";
	private String lbl_submit_xpath = "//button[text()='Review & Submit']";
	private String btn_submit_xpath = "//button[contains(.,'Grade Assignment Now')]";
	private String icon_close_class = "closeActivity";
	
	
	// Manual Grading Widget
	
	private String txt_takeStructure_xpath = "//h3[contains(text(),'Take Structure')]";
			
	private String lnk_activityInLeftPanel_xpath = "(((//div[@class='panel-body'])[1]//li)[1]//a)[last()]";
	
	private String btn_addScroe_xpath = "//button[contains(.,'Add Score')]";
	private String inp_scoreOnWidget_xpath = "(//div[@class='form-group instructor']//input)[1]";
	private String inp_percentScore_xpath = "(//div[@class='form-group instructor']//input)[2]";
	private String inp_comment_xpath = "//div[@class='form-group instructor']//textarea";
	private String btn_apply_xpath = "//div[@class='form-group instructor']//button[contains(@class,'btn-primary')]";
	private String txt_finalScoreValue_xpath = "//label[contains(text(),'Final Score')]/following-sibling::div//span[contains(@class,'scaled')]";
	private String txt_finalScorePercent_xpath = "//label[contains(text(),'Final Score')]/following-sibling::div//span[contains(@class,'normal')]";
	private String icon_closeActivity_css=".closeActivity";
	private String manualgradableActivity_name = "//a[contains(text(),'${activityName}')]";
	
	
	
	private String product;
	private boolean flag = false;
	
		
	public boolean isVideoActivityOpened() {
		resetImplicitTimeout(40);
		hardWait(1);
		switchToFrame(waitAndLocateElementByCss(grove_frame_css));
		hardWait(1);
		switchToFrame(waitAndLocateElementById(frame2_Submit_id));
		hardWait(1);
		flag = waitAndLocateElementByCss(textArea_css).isDisplayed();
		boolean flag2 = waitAndLocateElementByCss(btn_next_css).isDisplayed();
		
		switchToDefaultContent();

		return flag && flag2;
		
	}
	
	public boolean provideResponseInVideoActivityAndMoveGradingScreen(String textAreaContent){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementById(frame2_Submit_id));
		hardWait(1);
		waitAndLocateElementByCss(textArea_css).sendKeys(textAreaContent);
		waitAndLocateElementByCss(btn_next_css).click();
		return waitAndLocateElementByXpath(btn_reviewAndSubmit_xpath).isDisplayed();
		}
	
	
	public boolean verifyGradingMessage(String textMessage){
		System.out.println("Expected  message :" +textMessage);
		hardWait(2);
		System.out.println("Actual messsage: "+waitAndLocateElementByCss(gradingMessage_css).getText());
		return waitAndLocateElementByCss(gradingMessage_css).getText().trim().equals(textMessage);
	}
	

	public void submitVideoActivity(){
		waitForLessTimeAndLocateElementByCss(btn_gradeNow_css).click();
		switchToDefaultContent();
	}
	
	
	public boolean verifyActivityInfoPage(){
		boolean flag = waitAndLocateElementByXpath(btn_review_xpath).isDisplayed();
		boolean flag2 = waitAndLocateElementByXpath(txt_pendingGraded_xpath).isDisplayed();
		
		return flag && flag2 ;
	}
	
	public void navigateToEditGradeDetailsPage(){
		findElementByXpath(btn_review_xpath).click();
		
	}
	
	public boolean verifyStudentIsOnManulGradeWidgetPage(String correctMessage){
		switchToFrame(findElementByCssPath(ereader_frame_css));
		hardWait(1);
		switchToFrame(findElementById(appFrame_id));
		hardWait(3);
		boolean flag = waitAndLocateElementByXpath(txt_selectGradeDetails).isDisplayed();
		boolean flag2 = findElementByXpath(warning_message_xpath).getText().trim().contains(correctMessage);
		switchToDefaultContent();
		return flag && flag2;
	}
	
	
	
	public void closeSAActivity(){
		fireOnClickJsEvent(icon_close_class);
	}
	
	public boolean isUserOnManualGradingWidgetThroughProgressApp(){
		switchToFrame(waitAndLocateElementByCss(ereader_frame_css));
		hardWait(1);
		switchToFrame(findElementById(appFrame_id));
		hardWait(3);
		waitAndLocateElementByXpath(txt_takeStructure_xpath);
		boolean flag1 = waitAndLocateElementByXpath(lnk_activityInLeftPanel_xpath).isDisplayed();
		switchToDefaultContent();
		return flag1 ;
	}
	
	public boolean instructorGradesActivity(String score, String comment){
		boolean flag1=false;
		System.out.println("score"+score);
		String Score2=score.substring(0, 1);
		System.out.println("score"+Score2);
		switchToFrame(waitAndLocateElementByCss(ereader_frame_css));
		hardWait(1);
		switchToFrame(findElementById(appFrame_id));
		hardWait(3);
		waitAndLocateElementByXpath(lnk_activityInLeftPanel_xpath).click();
		findElementByXpath(btn_addScroe_xpath).click();
		waitAndLocateElementByXpath(inp_scoreOnWidget_xpath).sendKeys(Score2);
		hardWait(2);
		findElementByXpath(inp_comment_xpath).sendKeys(comment);
		hardWait(1);
		
/*		String percentText = executeJavaScriptCommandAndReturnValue("return document.getElementsByClassName('percent')[0].getElementsByTagName('input')[0].value");
		
		System.out.println("Percentage computed:- "+percentText);
		double calculatedScore = 0.0;
		try{
			calculatedScore = Double.parseDouble(score);
			calculatedScore = calculatedScore * 100;
			}catch(NumberFormatException ex){
			// just to catch the exception parseDoube method throws
		}
		int calValue = (int) calculatedScore;
		String calculatedScore_Text = String.valueOf(calValue).trim();
		System.out.println("calculated scrore "+calculatedScore_Text);
		flag1 = percentText.trim().equals(calculatedScore_Text);*/
			PropFileHandler.writeToFile("manualGradingPercentageScore",
					score, YamlReader.getYamlValue("propertyfilepath"));
		
		hardWait(1);
		waitAndLocateElementByXpath(btn_apply_xpath).click();
		System.out.println("flag value"+flag1);
		
		return flag1;
	}
	
	public boolean verifyFinalScoreOnMaunalWidget(String scoreValue){
		hardWait(1);
		boolean flag1 = findElementByXpath(txt_finalScoreValue_xpath).getText().trim().contains(scoreValue);
		System.out.println("second statement:- "+findElementByXpath(txt_finalScorePercent_xpath).getText().trim().replaceAll("%",""));
		boolean flag2 = findElementByXpath(txt_finalScorePercent_xpath).getText().trim().replaceAll("%","").equals(PropFileHandler
				.readProperty("manualGradingPercentageScore", YamlReader.getYamlValue("propertyfilepath")));
		System.out.println("second second:- "+PropFileHandler
				.readProperty("manualGradingPercentageScore", YamlReader.getYamlValue("propertyfilepath")));
		switchToDefaultContent();
		waitAndLocateElementByCss(icon_closeActivity_css).click();
		return flag1 && flag2;
	}


	public void clickOnGradableActivity() {
		switchToFrameByClass(frame2inline_Submit_class);
		activityDynamicXpath = getLocator(manualgradableActivity_name,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
		switchToDefaultContent();
	
	}
	public void clickStudentName() {
		switchToFrameByClass(frame2inline_Submit_class);
		findElementByXpath(student_name_xpath).click();
		switchToDefaultContent();
		
	}

	public void clickViewButtonForGrading() {
		switchToFrameByClass(frame2inline_Submit_class);
		findElementByXpath(btn_view_xpath).click();
		switchToDefaultContent();
	}
	
	
}
