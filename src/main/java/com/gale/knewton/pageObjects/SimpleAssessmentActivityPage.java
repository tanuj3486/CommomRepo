package com.gale.knewton.pageObjects;


import java.util.NoSuchElementException;

import org.openqa.selenium.StaleElementReferenceException;
import org.yaml.snakeyaml.Yaml;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class SimpleAssessmentActivityPage extends BaseWebComponent {

	private String practiceVideo_xpath = "//Video";
	private String feedback_xpath = "//div[contains(text(),'Feedback')]";
	private String currentPoint_xpath = "//*[@class='current-points']";
	private String scoreEntry_xpath = "(//*[@class='score-wrapper']/span[1])[1]";
	private String tryAnotherVersion_xpath = "//input[@value='Try Another Version']";
	private String btn_checkmywork_xpath= "//input[contains(@value,'Check My Work')]";
	private String grove_frame_css ="iframe[title='Assessments App']";
	private String frame2_Submit_id ="#easyXDM_activityService_cxp_Target_provider"; 
	private String ereader_frame_css = "iframe[title='Reader App']";
	private String frame2inline_Submit_class = "appFrame";
	private String frame3inline_Submit_id ="easyXDM_activityService_cxp_Target_provider";
	private String btn_startActivitySA_css= "#rhs-start";
	private String answer_optionAnd_xpath = "(//*[@class='q4-choice']//input)[1]";
	private String answer_optionGul_xpath = "(//*[@class='ci-choices']//input)[1]";
	private String lbl_submit_xpath = "//button[text()='Review & Submit']";
	private String btn_submit_xpath = "//button[contains(.,'Grade Assignment Now')]";
	private String icon_close_class = "closeActivity";
	
	private String lnk_closeInlineSA_xpath = "//img[@alt='Close Activity']/parent::a";
	private String div_feedbackContent_xpath = "//div[@class='ci-feedback-body']//div[@class='ci-feedback-category-body']//div";
	private String lnk_continue_xpath = "//a[text()='Continue']";
	private String lnk_takeAgain_xpath = "//a[text()='Take Again']";
	private String radio_answerOne_xpath="(//div[contains(@id,'rhs-part-assessment')][@style='display: block;']//input[@class='ci-input'])[1]";
	private String radio_answer2_xpath="(//div[contains(@id,'rhs-part-assessment')][@style='display: block;']//input[@class='ci-input'])[2]";
	private String radio_answer3_xpath="(//div[contains(@id,'rhs-part-assessment')][@style='display: block;']//input[@class='ci-input'])[3]";
	private String btn_next_xpath="//*[contains(@id,'rhs-part-assessment')][@style='display: block;']//div[@class='ci-submit part-submit']//button[@class='next-button']";
	private String txt_total_score_xpath="(//tr[@class='total']/td)[3]";
	private String btn_i_am_done="//button[@id='rhs-finalsubmit']";
	private String iframe_upper_id="54_NB_Main_IFrame";
	private String activityDynamicXpath;
	private String btn_start_xpath = ".//input[@class='tryagain' and @value='Start']";
	private String inline_activity_xpath = "//div[contains(text(),'${activityname}')]";
	private String frame_1_inline = ".ereader_iframe[title*='Reader App']";
	//div[@class='lpn_thumbTitle']/div[@class='lpn_score']
	
	private String product;
	private boolean flag = false;
	
		
	public boolean isSimpleAssessmentLaunched() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		try
			{
				hardWait(1);
				switchToFrame(findElementByCssPath(grove_frame_css));
				hardWait(1);
				switchToFrame(findElementByCssPath(frame2_Submit_id));
				if(product.equals("Andersen")){
					resetImplicitTimeout(30);
					flag = waitAndLocateElementByXpath(practiceVideo_xpath).isDisplayed();
				}
				else if(product.equals("Gulati")){
					resetImplicitTimeout(20);
					flag = waitAndLocateElementByXpath(btn_checkmywork_xpath).isDisplayed();
					}
				switchToDefaultContent();
			}catch(Exception e1){
				switchToDefaultContent();
				flag = false;
				}
		return flag;
	}
	
	public void relaunchActivity(){
		refresh();
		switchToDefaultContent();
	}
	
	public boolean isInlineSimpleAssessmentLaunched() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		try{
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		if(product.equals("Andersen")){
			resetImplicitTimeout(20);
			flag = waitAndLocateElementByXpath(practiceVideo_xpath).isDisplayed();
			}
			else
				if(product.equals("Gulati"))
				{
					resetImplicitTimeout(20);
					flag = waitAndLocateElementByXpath(btn_checkmywork_xpath).isDisplayed();
				}
		switchToDefaultContent();
		}
			catch(Exception e){
				switchToDefaultContent();
				flag = false;
			}
		return flag;
	}

	public void clickOnStartActivityforSA() {
		logMessage("Click on Start Activity");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		findElementByCssPath(btn_startActivitySA_css).click();
		switchToDefaultContent();
	}

	public void selectOption() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		logMessage("Select answer option");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		hardWait(1);
		if(product.equals("Andersen")){
			findElementByXpath(answer_optionAnd_xpath).click();
			}
		else if(product.equals("Gulati"))
				{
					waitAndLocateElementByXpath(answer_optionGul_xpath).click();
				}
		
		switchToDefaultContent();
	}
	
	public void selectOptionInline() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		logMessage("Select answer option");
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		if(product.equals("Andersen")){
			findElementByXpath(answer_optionAnd_xpath).click();
			}
			else
				if(product.equals("Gulati"))
				{
					findElementByXpath(answer_optionGul_xpath).click();
				}
		switchToDefaultContent();
	}
	
	public void checkMyWork(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		logMessage("Click Check My Work Button");
		findElementByXpath(btn_checkmywork_xpath).click();
		switchToDefaultContent();
			}
	
	public void checkMyWorkInline(){
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		logMessage("Click Check My Work Button");
		scrollDown(findElementByXpath(btn_checkmywork_xpath));
		findElementByXpath(btn_checkmywork_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean isFeedbackDisplayed(){
		boolean flag=false;
		try
		{
		switchToFrameByCss(grove_frame_css);
		hardWait(1);
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		hardWait(1);
		flag= findElementByXpath(feedback_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
		}
		catch(Exception e)
		{
			switchToDefaultContent();
			activityDynamicXpath = getLocator(inline_activity_xpath,
					PropFileHandler.readProperty(
							"SimpleAssessmentActivityTitle",
							(YamlReader.getData("propertyfilepath"))));
			hardWait(1);
			flag=findElementByXpath(activityDynamicXpath).isDisplayed();
			return flag;
		}
		
	}
	public boolean isInlineActivityDisplayed(){
		
		boolean flag=false;
		try{
		switchToFrame(findElementByCssPath(frame_1_inline));
		hardWait(1);
		activityDynamicXpath = getLocator(inline_activity_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		flag=findElementByXpath(activityDynamicXpath).isDisplayed();
		switchToDefaultContent();
		}
		catch(NoSuchElementException e)
		{
			switchToDefaultContent();
			switchToFrameByIndex(0);
			hardWait(1);
			activityDynamicXpath = getLocator(inline_activity_xpath,
					PropFileHandler.readProperty(
							"InlineSimpleAssessmentActivityTitle",
							(YamlReader.getData("propertyfilepath"))));
			hardWait(1);
			try{
			flag=findElementByXpath(activityDynamicXpath).isDisplayed();
			switchToDefaultContent();
			}
			catch(Exception e1)
			{
				switchToDefaultContent();
				System.out.println("Activity Displayed");
			}
			
		}
		return flag;
	}
	public boolean isInlineFeedbackDisplayed(){
		boolean flag;
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		flag = waitAndLocateElementByXpath(feedback_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isTryAnotherVersionbtnDisplayed(){
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		boolean flag= findElementByXpath(tryAnotherVersion_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean isInlineTryAnotherVersionbtnDisplayed(){
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		boolean flag= findElementByXpath(tryAnotherVersion_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void submitSimpleAssessmentActivity() {
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		hardWait(1);
		logMessage("Click Grade Assessment button");
		findElementByXpath(btn_submit_xpath).click();
		switchToDefaultContent();
		
	}
	
	public void clickReviewSubmitGDA(){
		logMessage("Click Review and Submit label");
		switchToFrame(findElementByCssPath(grove_frame_css));
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickReviewSubmitInline(){ 
		logMessage("Click on Review and Submit link");
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(lbl_submit_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean verifyGradesOnTable(){
		hardWait(1);  
		switchToFrame(findElementByCssPath(grove_frame_css));
		hardWait(1);
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		String currentPoints =waitAndLocateElementByXpath(currentPoint_xpath).getText();
		currentPoints.substring(1, 2);
		System.out.println("currentPoints:"+ currentPoints);
		String ScoreEntry = waitAndLocateElementByXpath(scoreEntry_xpath).getText();
		currentPoints.substring(1, 2);
		System.out.println("ScoreEntry:"+ ScoreEntry);
		switchToDefaultContent();
		if (currentPoints.equals(ScoreEntry)) 
				return true;
		else 
				return false;
	}
	
	public void gradeAssignmentButton(){
		logMessage("Click on Grade Assignment Button");
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		findElementByXpath(btn_submit_xpath).click();
		handleAlert();
		switchToDefaultContent();
	}
	
	public void closeSAActivity(){
		fireOnClickJsEvent(icon_close_class);
	}
	
	public boolean closeActivityAndSaveState(){
		waitAndLocateElementByClass(icon_close_class);
		hardWait(1);  
		switchToFrame(findElementByCssPath(grove_frame_css));
		hardWait(1);
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		boolean flag1 = waitAndLocateElementByXpath(div_feedbackContent_xpath).isDisplayed();
		boolean flag2 = findElementByXpath(div_feedbackContent_xpath).getText()!=null;
		PropFileHandler.writeToFile("feedbackContent",findElementByXpath(div_feedbackContent_xpath).getText()
				, YamlReader.getYamlValue("propertyfilepath"));
		switchToDefaultContent();
		fireOnClickJsEvent(icon_close_class);
		return flag1 && flag2;
	}
	
	public boolean verifySavedStateforAnActivity(){
		hardWait(2);
		hardWait(1);  
		switchToFrame(findElementByCssPath(grove_frame_css));
		hardWait(1);
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		boolean flag1 = waitAndLocateElementByXpath(div_feedbackContent_xpath).isDisplayed();
		boolean flag2 = waitAndLocateElementByXpath(div_feedbackContent_xpath).getText().trim().equals(
				PropFileHandler.readProperty("feedbackContent", YamlReader.getYamlValue("propertyfilepath")));
		switchToDefaultContent();
		return flag1 && flag2;
	}
	
	
	public boolean closeInlineActivityAndSaveState(){
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		hardWait(1);
		
		boolean flag1 = waitAndLocateElementByXpath(div_feedbackContent_xpath).isDisplayed();
		boolean flag2 = findElementByXpath(div_feedbackContent_xpath).getText()!=null;
		PropFileHandler.writeToFile("feedbackContent_Inline",findElementByXpath(div_feedbackContent_xpath).getText()
				, YamlReader.getYamlValue("propertyfilepath"));
		switchToDefaultContent();
		switchToFrame(findElementByCssPath(ereader_frame_css));
		hardWait(1);
		waitAndLocateElementByXpath(lnk_closeInlineSA_xpath).click();
		switchToDefaultContent();
		return flag1 && flag2;
	}
	
	public boolean verifyContinueButtonForInlineActivity(){
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		waitAndLocateElementByXpath(lnk_continue_xpath);
		boolean flag1 = findElementByXpath(lnk_continue_xpath).isDisplayed();
		switchToDefaultContent();
		return flag1;
	}
	
	public void continueInlinActivity(){
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		waitAndLocateElementByXpath(lnk_continue_xpath);
		findElementByXpath(lnk_continue_xpath).click();
		switchToDefaultContent();
		
	}
	public void takeAgainInlinActivity(){
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		waitAndLocateElementByXpath(lnk_takeAgain_xpath);
		findElementByXpath(lnk_takeAgain_xpath).click();
		switchToDefaultContent();
		
	}
	
	public boolean verifyResumeStateForInlineActivity(){
		hardWait(1);
		switchToFrame(findElementByCssPath(ereader_frame_css));
		waitAndLocateElementByXpath(lnk_closeInlineSA_xpath);
		switchToFrame(findElementByClass(frame2inline_Submit_class));
		switchToFrame(findElementById(frame3inline_Submit_id));
		hardWait(1);
		
		boolean flag1 = waitAndLocateElementByXpath(div_feedbackContent_xpath).isDisplayed();
		boolean flag2 = waitAndLocateElementByXpath(div_feedbackContent_xpath).getText().trim().equals(
				PropFileHandler.readProperty("feedbackContent_Inline", YamlReader.getYamlValue("propertyfilepath")));
	
		switchToDefaultContent();
		return flag1 && flag2;
	}

	public void clickOnAnswerRadioButton() {
	
		switchToFrameById(iframe_upper_id);
		switchToFrameById(frame3inline_Submit_id);
		int i=0;
	
		try{
			waitAndLocateElementByXpath(radio_answerOne_xpath);
			System.out.println("element one displAyed");
			findElementByXpath(radio_answerOne_xpath).click();
			findElementByXpath(btn_next_xpath).click();
			findElementByXpath(radio_answerOne_xpath).click();
		}
		catch(StaleElementReferenceException e)
		{
			waitAndLocateElementByXpath(radio_answerOne_xpath);
			System.out.println("element one displAyed");
			findElementByXpath(radio_answerOne_xpath).click();
			findElementByXpath(btn_next_xpath).click();
			findElementByXpath(radio_answerOne_xpath).click();
		}
		switchToDefaultContent();
		}
	

	public void saveScoreForBestLast() {
		findElementByXpath(txt_total_score_xpath).getText();
		
		
	}

	public void clickOnIAmDoneGradeAssignment() {
		switchToFrameById(iframe_upper_id);
		switchToFrameById(frame3inline_Submit_id);
		findElementByXpath(btn_i_am_done).click();
		switchToDefaultContent();
		
	}


	public void clickOnAnswerRadioButton2() {
		switchToFrameById(iframe_upper_id);
		switchToFrame(findElementByCssPath(frame2_Submit_id));
		try{
		
			findElementByXpath(radio_answer2_xpath).click();
			findElementByXpath(btn_next_xpath).click();
			findElementByXpath(radio_answer2_xpath).click();
		}
		catch(StaleElementReferenceException e)
		{
			
			findElementByXpath(radio_answer2_xpath).click();
			findElementByXpath(btn_next_xpath).click();
			findElementByXpath(radio_answer2_xpath).click();
		}
		catch(Exception e)
		{
			System.out.println("execption");
		}
		switchToDefaultContent();
		}

	public void clickOnStart() {
		findElementByXpath(btn_start_xpath).click();
		
	}
		
	}

