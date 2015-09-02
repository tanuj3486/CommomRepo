package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class AddActivityPanelPage extends BaseWebComponent {


	private String btn_simpleAssessment_xpath = ".//div[@class='creationTypeLabel ng-binding' and contains(text(),'Simple Assessment')]";
	private String btn_SAA_xpath = "//div[text()='SAA']";
	private String link_gDA_xpath = ".//h3[@class='activityName' and contains(text(),'Assessment')]";
	private String iframe_distinctActivity_id = "distinct_activity_create_frame";
	private String iframe_eastXDM_id = "easyXDM_activityService_cxp_Target_provider";
	private String area_assignOptions_xpath = "//div[contains(@class,'assignmentOptionsGroup')]//div[@class='groupLabel ng-binding' and contains(.,'${nameOfOption}')]";
	
	private String label_practiceOption_xpath = "(//div[@class='options'])[1]";
	private String label_attemptOption_xpath = "(//div[@class='options'])[2]";
	private String label_timedOption_xpath = "(//div[@class='options'])[3]";
	private String label_scoreOption_xpath = "(//div[@class='options'])[4]";
	private String label_quesOption_xpath = "(//div[@class='options'])[5]";
	private String label_feedOption_xpath = "(//div[@class='options'])[6]";
	private String label_practiceBox_xpath = "//label[contains(.,'Practice')]";

	private String link_groveInlineActivity_xpath = "//h3[@class='activityName' and text()='Inline Assessment']";
	private String Link_examStudyCenter_xpath = "//h3[@class='activityName' and text()='Exam Study Center']";
	
	//private String btn_toggle_xpath = "(//button[@class='toggle'])";
	//private String btn_radioBtnPractice_xpath = "(//span[contains(text(),'Practice')])[1]/preceding-sibling::input";
	private String btn_radioBtnSAA_xpath = "(//span[contains(text(),'Knewton Management Assessment')])[1]/preceding-sibling::input";
	//private String btn_radioBtnQuiz_xpath = "(//span[contains(text(),'Quiz')])[1]/preceding-sibling::input";
	private String btn_publish_xpath = "//button[contains(text(),'Publish') and not(@disabled='disabled')]";
	private String btn_cancelOnList_xpath = "(//*[contains(text(),'Cancel')])[1]";
	private String btn_cancelOnActivity_xpath = "(//*[contains(text(),'Cancel')])[2]";
	private String btn_radioBtnVideo_xpath = "(//ul[@class='prebuiltProducts']//span[contains(text(),'Video')])[1]/preceding-sibling::input";
	private String lbl_selectAssessment_css = ".activityType";
	private String btn_cancelButton_css  = ".cancel";
	private String area_creationTypePanel_css = ".creationProcessContainer";
	private String txt_courseName_css = ".productName.ng-binding";
	//private String list_assessmentActivity_css = ".prebuiltProducts ul li .activity.ng-scope";
	private String btn_toggleForSimpleAssessment_xpath = "//span[contains(.,'${product}')]/../../button[contains(.,'Toggle')]";
	private String btn_toggleForSA_2_xpath = "(//button[@class='toggle'])[2]";
	private String btn_previewAssessment_css = "(//button[@class='previewButton'])[2]";
	private String btn_previewSAA = "(//button[@class='previewButton'])[1]";
	private String btn_reviewAndSubmit_css = "#nav-group-submit>button";
	private String btn_checkMyWork_css = ".ci-submit.part-submit>input";
	private String btn_closeButtonOnPreviewPanel_css = ".closePreview";
	private String chkBox_practiceLabel_css= ".field.practice_Practice.ng-valid.ng-valid-required";
	private String lbl_overview_css = ".sel-item.selected-item";
	private String btn_radio_best="(//label[@class='ng-binding']/input[@name='scoreStrategy'])[1]";
	private String btn_radio_last=".//input[@class='field scoreStrategy_3 ng-valid-required']";
	private String btn_save_assesment=".//*[@class='adminButton save']";
	private String txt_assignment_name=".//*[@id='name']";
	private String lnk_user_name=".user-menu-link.tb_item";
	private String btn_logout="logout_link";
	private String txt_practice_xpath = ".//div[@class='checkboxesOptionValue ']//label//input[@name='practice']";
	Actions action = new Actions(driver);
	
	private String product;

	public void selectAssessment() {
		resetImplicitTimeout(10);
		hardWait(2);
		findElementByXpath(link_gDA_xpath).click();
	}

	public void selectInlineAssessment() {
		findElementByXpath(link_groveInlineActivity_xpath).click();
	}
	
	public void selectExamStudyCenter() {
		hardWait(2);
		findElementByXpath(Link_examStudyCenter_xpath).click();
	}

	public String verifySACreationTypeForAssessmentActivity() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		String getSimpleAssessment = waitAndLocateElementByXpath(btn_simpleAssessment_xpath).getText();
		switchToDefaultContent();
		return getSimpleAssessment;
	}
	
	public String verifySAACreationTypeForGDA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		String getSAA = waitAndLocateElementByXpath(btn_SAA_xpath).getText();
		switchToDefaultContent();
		return getSAA;
	}

	public void selectSimpleAssessment() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_simpleAssessment_xpath).click();
		switchToDefaultContent();
		
	}
	
	public void selectSAA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_SAA_xpath).click();
		switchToDefaultContent();
	}

	public void expandAndSelectRadioForSimpleAssessment() {
		product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		System.out.println(product);
		switchToFrame(findElementById(iframe_distinctActivity_id));
		if(product.equals("Andersen")){

			//findElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,"Kendall")).click();
			//System.out.println();
			findElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,"Andersen")).click();

			hardWait(1);
			switchToDefaultContent();
			executeJavaScriptCommand("document.getElementById('distinct_activity_create_frame').contentWindow.document.getElementsByClassName('productContainer ')[0].getElementsByTagName('li')[1].getElementsByTagName('input')[0].click()");
		}else if(product.equals("Gulati")){
			findElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,"Gulati")).click();
			hardWait(1);
			switchToDefaultContent();
			executeJavaScriptCommand("document.getElementById('distinct_activity_create_frame').contentWindow.document.getElementsByClassName('productContainer ')[1].getElementsByTagName('li')[0].getElementsByTagName('input')[0].click()");	
			}
		switchToDefaultContent();
	}
	
	public void expandAndSelectRadioBtnForSAA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		waitAndLocateElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,
				PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath")))).click();
		findElementByXpath(btn_radioBtnSAA_xpath).click();
		switchToDefaultContent();
	}

	public void clickPublish() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		waitAndLocateElementByXpath(btn_publish_xpath).click();
		switchToDefaultContent();
	}
	
	public void clickCancelOnList(){
		findElementByXpath(btn_cancelOnList_xpath).click();
	}
	public void clickCancelOnActivity(){
		findElementByXpath(btn_cancelOnActivity_xpath).click();
	}

	public void expandAndSelectRadioForFirstVideoActivity() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		
		waitAndLocateElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,
				PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath")))).click();
		hardWait(1);
		scrollDown(findElementByXpath(btn_radioBtnVideo_xpath));
		hardWait(1);
		executeJavaScriptCommand("document.getElementsByClassName('productContainer ')[0]."
				+ "getElementsByTagName('li')[2].getElementsByTagName('input')[0].click()");
		
		
		switchToDefaultContent();
		//findElementByXpath(btn_radioBtnVideo_xpath).click();				
	}
	
	public boolean verifySelectAssessmentPanel(){
		return findElementByCssPath(lbl_selectAssessment_css).isDisplayed();
		
	}
	
	public boolean verifyCancelButton(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		boolean flag= findElementByCssPath(btn_cancelButton_css).isDisplayed(); 
		switchToDefaultContent();
		return flag;
	}
	
	public boolean verifyContainerPanelOnSelectAssessmentPage(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		boolean flag = findElementByCssPath(area_creationTypePanel_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean verifyTheCourseOnCreationTypePanel(){
		String product = PropFileHandler.readProperty("Product",YamlReader.getYamlValue("propertyfilepath"));
		switchToFrame(findElementById(iframe_distinctActivity_id));
		String courseName = waitAndLocateElementByCss(txt_courseName_css).getText();
		boolean flag =  courseName.contains(product);
		switchToDefaultContent();
		return flag;
	}
	
	public void clickOnExpandToggleOnCreationTypePanel(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(getLocator(btn_toggleForSimpleAssessment_xpath,PropFileHandler
				.readProperty("Product", YamlReader.getYamlValue("propertyfilepath")))).click();
		switchToDefaultContent();
	}
	
	public boolean verifyAssessmentActivityList(){
		Object length = executeJavaScriptCommandAndReturnValueOfObvjectType("return document.getElementById('distinct_activity_create_frame').contentDocument.getElementsByClassName('activity ').length");
		System.out.println("Lenght:- "+length.toString());
		int sizeOfList = Integer.parseInt(length.toString());
		return sizeOfList>=2;
	}
	
	public boolean verifyPreviewButtonAssociatedWithEachSimpleAssessmentAcitvity(){
		Object length = executeJavaScriptCommandAndReturnValueOfObvjectType("return document.getElementById('distinct_activity_create_frame').contentDocument.getElementsByClassName('previewButton').length");
		System.out.println("Lenght:- "+length.toString());
		int sizeOfList = Integer.parseInt(length.toString());
		return sizeOfList>=2;
	}
	
	public boolean verifyUsedButtonAssociatedWithEachSimpleAssessmentAcitvity(){
		Object length = executeJavaScriptCommandAndReturnValueOfObvjectType("return document.getElementById('distinct_activity_create_frame').contentDocument.getElementsByClassName('check').length");
		System.out.println("Lenght:- "+length.toString());
		int sizeOfList = Integer.parseInt(length.toString());
		return sizeOfList>=2;
	}
	
	public void clickOnPreviewButtonForFirstAssessment(){
		switchToDefaultContent();
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_previewAssessment_css).click();
		switchToDefaultContent();
	
	}
	public void clickOnPreviewButtonForSAAFirstAssessment(){
		switchToDefaultContent();
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_previewSAA).click();
		switchToDefaultContent();
	}
	public boolean verifyReviewAndSubmitButtonOnPreviewAssessmentPanel(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		scrollDown(findElementById(iframe_eastXDM_id));
		switchToFrame(findElementById(iframe_eastXDM_id));
		boolean flag = findElementByCssPath(btn_reviewAndSubmit_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean verifyCheckMyWorkButtonOnPreviewAssessmentPanel(){
		switchToDefaultContent();
		switchToFrame(findElementById(iframe_distinctActivity_id));
		switchToFrame(findElementById(iframe_eastXDM_id));
		boolean flag = findElementByCssPath(btn_checkMyWork_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public boolean verifyCloseButtonverifyOnPreviewAssessmentPanel(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		boolean flag= findElementByCssPath(btn_closeButtonOnPreviewPanel_css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void clickOnCloseButtonOfAssessmentPanel(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByCssPath(btn_closeButtonOnPreviewPanel_css).click();
		switchToDefaultContent();
		hardWait(4);
	}

	public boolean verifyAssignmentGroupOptions(String option1,
			String option2, String option3, String option4, String option5, String option6) {
		switchToFrame(waitAndLocateElementById(iframe_distinctActivity_id));
		boolean flag1 =  validatePracticeOption(option1);
		boolean flag2 =  validateAssignmentOption(option2);
		boolean flag3 =  validateAssignmentOption(option3);
		boolean flag4 =  validateAssignmentOption(option4);
		boolean flag5 =  validateAssignmentOption(option5);
		boolean flag6 =  validateAssignmentOption(option6);
		switchToDefaultContent();
		System.out.println(flag1);
		System.out.println(flag2);
		System.out.println(flag3);
		System.out.println(flag4);
		System.out.println(flag5);
		System.out.println(flag6);
		return (flag1 && flag2 && flag3 && flag4 && flag5 && flag6);
	}
	
	private boolean validatePracticeOption(String labelName) {
		boolean flag1=false;
		boolean flag2=false;
		if(labelName.equals("Practice")){	
			flag1=findElementByXpath(txt_practice_xpath).isDisplayed();
		}
		flag2=	findElementByXpath(label_practiceOption_xpath).isDisplayed();
			
		return flag1&&flag2;
		
		}
		
	

	private boolean validateAssignmentOption(String labelName){
		String dynamicPath = null;
		
		boolean flag1 = false;	
		boolean flag2 = false;	
		 if(labelName.equals("Attempts")){
			flag2= findElementByXpath(label_attemptOption_xpath).isDisplayed();
			dynamicPath = getLocator(area_assignOptions_xpath, "Attempts");
		}else if(labelName.equals("Timed")){
			flag2=	findElementByXpath(label_timedOption_xpath).isDisplayed();
			dynamicPath = getLocator(area_assignOptions_xpath, "Timed");
		}else if(labelName.equals("Scoring")){
			flag2=	findElementByXpath(label_scoreOption_xpath).isDisplayed();
			dynamicPath = getLocator(area_assignOptions_xpath, "Scoring");
		}else if(labelName.equals("Questions")){
			flag2=	findElementByXpath(label_quesOption_xpath).isDisplayed();
			dynamicPath = getLocator(area_assignOptions_xpath, "Questions");
		}else if(labelName.equals("Feedback")){
			flag2=	findElementByXpath(label_feedOption_xpath).isDisplayed();
			dynamicPath = getLocator(area_assignOptions_xpath, "Check My Work");
		}
			
			flag1= waitAndLocateElementByXpath(dynamicPath).isDisplayed();
		
		return flag1&&flag2;
	}

	
	public boolean verifyPresenceOfPracticeLabel(){
	 return findElementByXpath(label_practiceBox_xpath).isDisplayed();
	}
	
	public boolean verifyCheckBoxIsUnChecked(){
	return findElementByCssPath(chkBox_practiceLabel_css).isSelected();
	}
	
	public void clickOnCancelButton(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(btn_cancelOnList_xpath).click();
		switchToDefaultContent();
	}
	
	public boolean verifyPreviewPanelForSAA(){
		switchToFrame(findElementById(iframe_distinctActivity_id));
		switchToFrame(findElementById(iframe_eastXDM_id));
		boolean flag = findElementByCssPath(lbl_overview_css).isDisplayed();
		switchToDefaultContent();
		return flag;
		 
	}

	public void verifyBestOptionIsSelected() {
		switchToFrame(findElementById(iframe_distinctActivity_id));
		try {
            scrollDown(waitAndLocateElementByXpath(btn_radio_best));
			if(findElementByXpath(btn_radio_best).getText().equalsIgnoreCase("Best"))

				findElementByXpath(btn_radio_best).click();
		}

		catch(Exception e){
			System.out.println("?EXEPTION");
		}
switchToDefaultContent();
	}

	public void verifyLastOptionIsSelected() {
		scrollDown(waitAndLocateElementByXpath(btn_radio_last));
		
		if(findElementByXpath(btn_radio_last).getText().equalsIgnoreCase("Last"))
		{
		findElementByXpath(btn_radio_last).click();
		}
			
	}
	public void clickOnSaveButton()
	{
		
		findElementByXpath(btn_save_assesment).click();
	}
	public String getAssignmentname()
	{
		String assignment_name=findElementByXpath(txt_assignment_name).getAttribute("value");
		System.out.println(assignment_name);
		return assignment_name;
	}
	public void logout()
	{
		findElementByCssPath(lnk_user_name).click();
		findElementById(btn_logout).click();
	}
}
