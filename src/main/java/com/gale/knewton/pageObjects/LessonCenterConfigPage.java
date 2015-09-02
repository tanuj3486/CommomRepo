package com.gale.knewton.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;
import com.sun.jna.Native.ffi_callback;


public class LessonCenterConfigPage extends BaseWebComponent
{
	private String lnk_lesson_center_xpath = "//h3[contains(text(),'Lesson Center')]";
	private String logo_lesson_center_xpath = "//h3[contains(text(),'Lesson Center')]/../../../preceding-sibling::span/img";
	private String txt_upper_heading_xpath = "//span[contains(text(),'Select Lesson Center')]";
	private String form_panel_css = "#editLessonCenter";
	private String link_activityName_xpath = "//a[contains(.,'${activitytitle}')]";
	private String iframe_activity_create_id = "distinct_activity_create_frame";
	private String txt_panel_heading_xpath = "//h3[contains(text(),'${activityname}')]";
	private String txt_mastery_score_xpath = "//label[contains(text(),'${activityname}')]";
	private String btn_continue_css = "#save";
	private String btn_cancle_css	=".back.weak";
	private String txtbox_lcname = "#name";
	private String txtbox_date = "p>input";
	private String txtbox_lcdescription = "#description";
	private String btn_calender_icon = "#datepicker";
	private String btn_calender_next_icon = "//span[contains(text(),'Next')]";
	private String btn_calender_date = "//td/a[@class='ui-state-default' and contains(text(),'${currentdate}')]";
	private String btn_previous_date = "//span[@class='ui-state-default' and contains(text(),'${datename}')]";
	private String btn_done = "//button[contains(text(),'Done')]";
	private String btn_order_css  = "#order-button>span:nth-child(2)";
	private String option_order_xpath = "//a[contains(text(),'At end (current position)')]";
	private String btn_save_lc_xpath = "//a[contains(text(),'Save')]";
	private String btn_lcPath_lpn_xpath = "//a[contains(text(),'${activityname}')]";
	private String btn_edit_LPN_xpath = "//a[contains(.,'${activitytitle}')]/../../../div[@class='nb_edit']/a[@title='Edit']";
	private String btn_edit_options_css = ".editOptions";
	private String iframe_Edit_css = "#modelOptionsEditFrame";

	private String btn_LPN_couse_css = ".ng-scope.pane-lpn.pane.active";
	private String btn_homeIcon_id = "nb_lpLauncher";
	private String lnk_activity_xpath = "//h3[@class='lpn_name']/a[contains(text(),'${activityname}')]";
	private String frame_activity_page_css = ".form_area.lpn_form.mxui_layout_modal.nb_math";
	private String txtbox_date_activity_page_css = "#endDate";
	private String txtbox_name_activity_page_css = ".formtext";
	private String btn_expand_items_xpath =	"(//i[@class='ng-scope glyphicon glyphicon-menu-right'])[1]";
	private String btn_collapse_items_xpath = "//i[@class='ng-scope glyphicon glyphicon-menu-down']";
	private String checkbox_chapters_xpath = "(//label[@class='tree-chapter ng-scope']/div/input)[1]";
	private String checkbox_all_items = "//div[@class='lcc-lo-checkbox']/input";
	private String btn_items_checkbox_xpath = "(//input[@class='ng-pristine ng-untouched ng-valid'])[3]";
	private String btn_items_checkbox2_xpath = "(//input[@class='ng-pristine ng-untouched ng-valid'])[4]";
	private String btn_prerequisite_checkbox_xpath = "(//label/input)[2]";	
	private String btn_list_xpath = "(//select[@class='form-control input-sm ng-pristine ng-untouched ng-valid'])[2]";
	private String btn_SeeMore_xpath = "(//span[contains(text(),'See More')])[2]";
	private String iframe_lesson_center_css = "iframe[title*='Lesson Center App App']";
	private String txt_error_xpath = "//p[@class='ng-binding']";
	private String txt_error_date = "//p[contains(text(),'Please enter a valid due date.')]";
	private String txtbox_targetScore_css = "#targetScore";
	private String clender_widget_xpath = "//div[@id='ui-datepicker-div']";
	private String dropdown_total_ques_css = "#noQuestions";
	private String tooltip_txt_name = ".lcc-continue-button";
	private String dropdown_total_hours_css = "#noHours";
	public String txt_option_instructionmaterial = "((//select)[2]/option)[2]";
	private String checkbox_assessment = "//input[@id='createAssessment']";
	private String btn_forward_xpath = "//i[@class='glyphicon glyphicon-forward']";
	private String btn_backward_xpath = "//i[@class='glyphicon glyphicon-fast-backward']";
	private String txt_learning_objectives = "//span[@class='treeChapterText ng-binding']";
	private String btn_page_20_xpath = "//a[@class='ad-cursor-pointer ng-binding' and contains(text(),'20')]";
	private String btn_page_10_xpath = "//a[@class='ad-cursor-pointer ng-binding' and contains(text(),'10')]";
	private String txt_visible_prerequisite = "(//label[@ng-show='lo.prereq_names']/span[contains(text(),'prerequisites')])[2]";
	private String txt_visible_prerequisite_checkbox = "(//label[@ng-show='lo.prereq_names']/input)[2]";
	private String txt_visible_inst_material = "(//ul/li[contains(text(),'Initial instructional material to show for this objective:')])[2]";
	private String strerror = "Instructors don’t have access to Student View of the Lesson Center. To edit the Lesson Center for students, click on the pencil and then choose \"Edit Options\". Please contact your local learning consultant for more information.";


	private String product;
	private String activityDynamicXpath;
	Actions action = new Actions(driver); 
	static int count=0;
	static int Lcnumber=0;
	static int days=2;
	int lczero;

	public void SelectLessonCenterFromActivityList() {

		findElementByXpath(lnk_lesson_center_xpath).click();
	}

	public boolean verifyLCConfigPage() {

		boolean flag1= false;
		boolean flag2= false;
		hardWait(5);

		flag1=findElementByXpath(txt_upper_heading_xpath).isDisplayed();
		hardWait(1);
		switchToFrameById(iframe_activity_create_id);
		flag2=findElementByCssPath(form_panel_css).isDisplayed();
		switchToDefaultContent();

		return (flag1&&flag2);
	}


	public boolean verifyTextContentOnLCconfigPage() {

		boolean flag1=false;
		boolean flag2=false;
		boolean flag3=false;
		boolean flag4=false;

		switchToFrameById(iframe_activity_create_id);

		activityDynamicXpath = getLocator(txt_panel_heading_xpath,
				"1. Select Lesson Settings");
		flag1= findElementByXpath(activityDynamicXpath).isDisplayed();

		activityDynamicXpath = getLocator(txt_panel_heading_xpath,
				"2. Select Learning Objectives");
		flag2= findElementByXpath(activityDynamicXpath).isDisplayed();

		activityDynamicXpath = getLocator(txt_panel_heading_xpath,
				"3. Include Assessment");
		try
		{
			flag3= findElementByXpath(activityDynamicXpath).isDisplayed();
		}
		catch(Exception e)
		{
			Assert.assertFalse("Include assessment displayed without selecting learning objective", flag3);
		}
		activityDynamicXpath = getLocator(txt_mastery_score_xpath,
				"Target Mastery");
		flag4= findElementByXpath(activityDynamicXpath).isDisplayed();	
		switchToDefaultContent();

		return (flag1&&flag2&&flag4);
	}

	public void clickContinueButton()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(btn_continue_css).click();
		switchToDefaultContent();

	}
	public void clickCancleButton()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(btn_cancle_css).click();
		switchToDefaultContent();
	}

	public void verifyLCpageIsNotEmpty() {
		switchToFrameById(iframe_activity_create_id);
		System.out.println(findElementByCssPath(txtbox_lcname).getAttribute(
				"required"));

		Assert.assertTrue(findElementByCssPath(txtbox_lcname).getAttribute("required").equalsIgnoreCase("true"));
		switchToDefaultContent();


	}

	public void selectValidDate() {
		days++;
		String TodaysDate= getFutureValidDates(days);
		System.out.println(TodaysDate);
		switchToFrameById(iframe_activity_create_id);
		hardWait(1);
		findElementByXpath(btn_calender_next_icon).click();
		//hardWait(1);
		activityDynamicXpath = getLocator(btn_calender_date,TodaysDate);
		findElementByXpath(activityDynamicXpath).click();
		hardWait(1);
		findElementByXpath(btn_done).click();
		logPassMessage("button clicked");
		switchToDefaultContent();
	}

	public String getFutureValidDates(int futureDays)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar  cal = Calendar.getInstance();
		cal.add(Calendar.DATE, futureDays);    
		System.out.println(dateFormat.format(cal.getTime()));
		String date1=  dateFormat.format(cal.getTime());
		if(date1.startsWith("0"))
		{

			String date2 = Character.toString(date1.charAt(1));
			System.out.println(date2);
			return date2;
		}
		else{
			return date1;
		}
	}
	public String selectCurrentDate()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Date date = new Date();
		String date1= dateFormat.format(date);
		return date1;
	}

	public void enterLessonCenterName(String LcName){

		String LessonName = LcName+"_"+System.currentTimeMillis();
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(txtbox_lcname).click();
		findElementByCssPath(txtbox_lcname).clear();
		findElementByCssPath(txtbox_lcname).sendKeys(LessonName);
		logPassMessage("Lesson Center Name Entered as : " + LessonName);
		System.out.println(LessonName);
		System.out.println(count);
		PropFileHandler.writeToFile(LcName+"Name"+count, LessonName, YamlReader.getYamlValue("propertyfilepath"));
		count++;
		switchToDefaultContent();
	}

	public void enterDescriptionOnLcConfig(String LcDescription) {
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(txtbox_lcdescription).click();
		findElementByCssPath(txtbox_lcdescription).clear();
		findElementByCssPath(txtbox_lcdescription).sendKeys(LcDescription);
		switchToDefaultContent();	
	}

	public void saveLcCenterWithDefaultOptions() {
		hardWait(1);
		findElementByCssPath(btn_order_css).click();
		hardWait(1);
		findElementByXpath(option_order_xpath).click();
		findElementByXpath(btn_save_lc_xpath).click();
		
	}

	public boolean isLPNDisplayedAtInstructors() {
		boolean flag=false;
		flag=findElementByCssPath(btn_LPN_couse_css).isDisplayed();
		return flag;
	}

	public boolean getLessonCenterLPN() {
		boolean flag;
		flag=isLPNDisplayedAtInstructors();
		if(flag)
		{
			return true;
		}
		else
		{
			clickHomeButton();
			return isLPNDisplayedAtInstructors();
		}

	}

	private void clickHomeButton() {
		findElementById(btn_homeIcon_id).click();
		logPassMessage("Home Icon clicked");

	}

	public boolean isLessonCEnterDisplayedAtLPN() {
		boolean flag=false;
		activityDynamicXpath = getLocator(lnk_activity_xpath
				,
				PropFileHandler.readProperty("LessonCenterName"+Lcnumber,
						(YamlReader.getData("propertyfilepath"))));
		System.out.println(activityDynamicXpath+"Lweeeson center name");
		flag = findElementByXpath(activityDynamicXpath).isDisplayed();
		Lcnumber++;
		
		return flag;
	}

	public void verifyMindtapActivityPage() {
		hardWait(1);
		findElementByCssPath(frame_activity_page_css).isDisplayed();
	}

	public void verifyNotEditableFeildsOnActivityPage() {
		System.out.println("lal////"+findElementByCssPath(txtbox_name_activity_page_css)
				.getAttribute("isContentEditable"));
		Assert.assertTrue("Description is Editable",findElementByCssPath(txtbox_lcdescription).getAttribute("disabled").equalsIgnoreCase("true"));
		Assert.assertTrue("Date is not Read-Only", findElementByCssPath(txtbox_date_activity_page_css).getAttribute("readonly").equalsIgnoreCase("true"));
		Assert.assertTrue("LC Name is editable", findElementByCssPath(txtbox_name_activity_page_css).getAttribute("isContentEditable")==null);

	}

	public void selectInstructionMaterialAndPrerequitsiteAndAssessment()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_expand_items_xpath).click();
		logPassMessage("expand item clicked");
		hardWait(1);
		findElementByXpath(btn_items_checkbox_xpath).click();
		findElementByXpath(btn_items_checkbox2_xpath).click();
		logPassMessage("item checkbox clicked");
		hardWait(1);
		findElementByXpath(btn_SeeMore_xpath).click();
		logPassMessage("See more clicked");
		hardWait(1);
		findElementByXpath(btn_prerequisite_checkbox_xpath).click(); // Include Prerequisite

		Assert.assertTrue("prereuisite not seen",findElementByXpath(txt_visible_prerequisite).isDisplayed());  //prerequisite text displayed
		logPassMessage("prerequisite is displayed");
		Assert.assertTrue("prerequisite checkbox not displayed",findElementByXpath(txt_visible_prerequisite_checkbox).isDisplayed());  // prerequisite checkbox displayed
		hardWait(1);
		Assert.assertTrue("Instruction material not seen",findElementByXpath(txt_visible_inst_material).isDisplayed());  // instruction material

		Select sel = new Select(findElementByXpath(btn_list_xpath)); // Include Instruction Material
		sel.selectByIndex(1);
		String txtInstruction = findElementByXpath(txt_option_instructionmaterial).getText();
		System.out.println(txtInstruction+"......text Instruction");
		PropFileHandler.writeToFile("InstructionMaterial", txtInstruction, YamlReader.getYamlValue("propertyfilepath"));
		findElementByXpath(checkbox_assessment).click(); // Include Assessment
		logPassMessage("item selected from the list");
		switchToDefaultContent();
		enterNumberOfQuestions();
	}

	public void expandChapters()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_expand_items_xpath).isDisplayed();
		findElementByXpath(btn_expand_items_xpath).click();
		switchToDefaultContent();
		logPassMessage("expand item clicked");

		logPassMessage("expand button visible");
	}

	public void collapseChapters()
	{
		switchToFrameById(iframe_activity_create_id);
		hardWait(3);
		findElementByXpath(btn_collapse_items_xpath).isDisplayed();
		findElementByXpath(btn_collapse_items_xpath).click();
		switchToDefaultContent();
		logPassMessage("expand item clicked");
		logPassMessage("collapse button visible");
	}

	public void clickChapterCheckbox()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(checkbox_chapters_xpath).click();
		switchToDefaultContent();

	}

	public void verifyAllLearningObjectivesAreSelectedWhenClickingChapterCheckbox()
	{
		switchToFrameById(iframe_activity_create_id);
		for (WebElement element : findElementsByXpath(checkbox_all_items)) {
			Assert.assertTrue(element.isSelected());
		}
		switchToDefaultContent();
	}

	public void IsAllLearningObjectivesDisplayed()
	{
		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue("Learning objectives are not 10",findElementsByXpath(txt_learning_objectives).size()==10);
		switchToDefaultContent();
	}

	public void VerifyMoreLearningObjectivesDisplayedOnClickingForwrdButton()
	{
		int totalSize;
		switchToFrameById(iframe_activity_create_id);
		int firstpageSize=	findElementsByXpath(txt_learning_objectives).size();
		System.out.println("1st"+firstpageSize);

		findElementByXpath(btn_forward_xpath).click();
		hardWait(1);
		int secondpageSize=findElementsByXpath(txt_learning_objectives).size();
		System.out.println("2nd"+secondpageSize);
		totalSize=firstpageSize+secondpageSize;
		Assert.assertTrue("seconds page has no objectives", (totalSize>firstpageSize));
		findElementByXpath(btn_backward_xpath).click();   // click backward button
		switchToDefaultContent();
	}

	public void verifyMax20LearningObjectiveDisplayed()
	{

		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_page_20_xpath).click();
		int secondpageSize=findElementsByXpath(txt_learning_objectives).size();
		System.out.println("2nd.."+secondpageSize);
		Assert.assertTrue("learing objectives are more than 20", (secondpageSize<=20));
		findElementByXpath(btn_page_10_xpath).click();
		switchToDefaultContent();
	}


	public void selectInstructionMaterialAndPrerequitsite()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_expand_items_xpath).click();
		logPassMessage("expand item clicked");
		hardWait(1);
		findElementByXpath(btn_items_checkbox_xpath).click();
		findElementByXpath(btn_items_checkbox2_xpath).click();
		logPassMessage("item checkbox clicked");
		hardWait(1);
		findElementByXpath(btn_SeeMore_xpath).click();
		logPassMessage("See more clicked");
		hardWait(1);
		findElementByXpath(btn_prerequisite_checkbox_xpath).click(); // Include Prerequisite
		logPassMessage("prerequisite is displayed");
		hardWait(1);
		Select sel = new Select(findElementByXpath(btn_list_xpath)); // Include Instruction Material
		sel.selectByIndex(1);
		switchToDefaultContent();
		logPassMessage("item selected from the list");

	}


	public void SelectPrerequisite()
	{

		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_expand_items_xpath).click();
		logPassMessage("expand item clicked");
		hardWait(1);
		findElementByXpath(btn_items_checkbox_xpath).click();
		findElementByXpath(btn_items_checkbox2_xpath).click();
		logPassMessage("item checkbox clicked");
		hardWait(1);
		findElementByXpath(btn_SeeMore_xpath).click();
		logPassMessage("See more clicked");
		hardWait(1);
		findElementByXpath(btn_prerequisite_checkbox_xpath).click(); // Include Prerequisite
		switchToDefaultContent();
		logPassMessage("prerequisite is displayed");
	}

	public void selectInstructionMaterial()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(btn_expand_items_xpath).click();
		logPassMessage("expand item clicked");
		hardWait(1);
		findElementByXpath(btn_items_checkbox_xpath).click();
		findElementByXpath(btn_items_checkbox2_xpath).click();
		logPassMessage("item checkbox clicked");
		hardWait(1);
		findElementByXpath(btn_SeeMore_xpath).click();
		logPassMessage("See more clicked");
		hardWait(1);
		Select sel = new Select(findElementByXpath(btn_list_xpath)); // Include Instruction Material
		sel.selectByIndex(1);
		switchToDefaultContent();
		logPassMessage("item selected from the list");
	}

	public void SelectIncludeAssessment()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByXpath(checkbox_assessment).click();
		hardWait(1);
		Assert.assertTrue(findElementByXpath(checkbox_assessment)
				.isEnabled());
		switchToDefaultContent();
		logPassMessage("Include Assessment Selected");

	}

	public void clickOnLPNLessonCenter()
	{
		activityDynamicXpath = getLocator(btn_lcPath_lpn_xpath,
				PropFileHandler.readProperty("LessonCenterName"+lczero,
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
		
	}
	public void verifyErrorWhileAccessingLessonCenterFromInstEnd()
	{
		switchToFrameByCss(iframe_lesson_center_css);
		System.out.println(findElementByXpath(txt_error_xpath).getText());
		Assert.assertTrue(findElementByXpath(txt_error_xpath).getText().contains(strerror));
		switchToDefaultContent();
	}

	public void verifyErrorMessageIfValidDueDateIsNotEntered() {
		clickContinueButton();
		switchToFrameById(iframe_activity_create_id);
		waitAndLocateElementByXpath(txt_error_date).isDisplayed();
		logPassMessage("Date Error message is Displayed successfully");
		switchToDefaultContent();
	}

	public void clickonDueDateFeild() {
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(btn_calender_icon).click();
		switchToDefaultContent();

	}

	public void verifyCalenderWidget()
	{
		switchToFrameById(iframe_activity_create_id);
		System.out.println(findElementByXpath(clender_widget_xpath)
				.getAttribute("style"));
		Assert.assertTrue(findElementByXpath(clender_widget_xpath)
				.getAttribute("style").contains("display: block"));
		switchToDefaultContent();
	}

	public void EnterTargetScore(String score)
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(txtbox_targetScore_css).click();
		findElementByCssPath(txtbox_targetScore_css).clear();
		findElementByCssPath(txtbox_targetScore_css).sendKeys(score);
		switchToDefaultContent();
	}


	public void verifyTargetMasteryScoreRange() {
		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue("Max value is not 100",findElementByCssPath(txtbox_targetScore_css).getAttribute("max").equalsIgnoreCase("100"));
		logPassMessage("MAX target score value value is 100");
		Assert.assertTrue("MIN target value is not 0",findElementByCssPath(txtbox_targetScore_css).getAttribute("min").equalsIgnoreCase("0"));
		logPassMessage("MIN target score value value is 0");
		switchToDefaultContent();
	}

	public void verifyIncrementDecrementTargetScore() {
		switchToFrameById(iframe_activity_create_id);
		//Verify Incremented SCORE

		String Score1=findElementByCssPath(txtbox_targetScore_css).getAttribute("value");
		findElementByCssPath(txtbox_targetScore_css).sendKeys(Keys.ARROW_UP);
		System.out.println(findElementByCssPath(txtbox_targetScore_css)
				.getAttribute("value"));
		String Score2=findElementByCssPath(txtbox_targetScore_css).getAttribute("value");
		int InitialScore=Integer.parseInt(Score1);
		int FinalIncrementedScore=Integer.parseInt(Score2);
		Assert.assertTrue("score is not incremented", (FinalIncrementedScore>InitialScore));

		//Verify Decremented SCORE
		for(int i=0;i<6;i++)
		{
			findElementByCssPath(txtbox_targetScore_css).sendKeys(Keys.ARROW_DOWN);
		}
		System.out.println(findElementByCssPath(txtbox_targetScore_css)
				.getAttribute("value"));
		String Score4=findElementByCssPath(txtbox_targetScore_css).getAttribute("value");
		int FinalDecrementScore=Integer.parseInt(Score4);
		Assert.assertTrue("score is not incremented", (FinalDecrementScore<InitialScore));

		switchToDefaultContent();

	}

	public void verifyPastDueDatesInvalidity(String Yesterdaydate){
		switchToFrameById(iframe_activity_create_id);

		if(Yesterdaydate.startsWith("0"))
		{

			String date2 = Character.toString(Yesterdaydate.charAt(1));
			System.out.println(date2);
			Yesterdaydate= date2;
		}
		activityDynamicXpath = getLocator(btn_previous_date,
				Yesterdaydate);
		try
		{
		findElementByXpath(activityDynamicXpath).click();
		}
		catch(NoSuchElementException e)
		{
			String Ydate=getYesterdayDateString();
			System.out.println(Ydate);
			logPassMessage("Previous Dates Not Available on !st of the Month");
			
		}
		findElementByXpath(btn_done).click();
		switchToDefaultContent();
	}

	public String getYesterdayDateString() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar  cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);    
		System.out.println(dateFormat.format(cal.getTime()));
		return dateFormat.format(cal.getTime());
	}

	public void enterNumberOfQuestions()
	{
		switchToFrameById(iframe_activity_create_id);
		findElementByCssPath(dropdown_total_ques_css).click();
		findElementByCssPath(dropdown_total_ques_css).clear();
		findElementByCssPath(dropdown_total_ques_css).sendKeys("3");
		switchToDefaultContent();
	}

	public void verifyISeeDisabledFeildsUnderIncludeAssessment()
	{
		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue("No of Question are not disabled",findElementByCssPath(dropdown_total_ques_css).getAttribute("disabled").equalsIgnoreCase("true"));
		Assert.assertTrue("No of Question are not disabled",findElementByCssPath(dropdown_total_hours_css).getAttribute("disabled").equalsIgnoreCase("true"));
		switchToDefaultContent();
	}

	public void verifyDisabledFeildsBecomeEnabledOnClickingCheckbox()
	{
		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue("No of Question are not disabled",findElementByCssPath(dropdown_total_ques_css).getAttribute("disabled")==null);
		Assert.assertTrue("No of Question are not disabled",findElementByCssPath(dropdown_total_hours_css).getAttribute("disabled")==null);
		switchToDefaultContent();
	}

	public void verifyHoverMessage()
	{
		switchToFrameById(iframe_activity_create_id);
		action.moveToElement(findElementByCssPath(dropdown_total_ques_css)).build().perform();
		Assert.assertTrue("tool tip not showed", findElementByCssPath(dropdown_total_ques_css).getAttribute("tooltip").contains("Max Questions Available"));
		hardWait(1);;
		action.moveToElement(findElementByCssPath(dropdown_total_hours_css)).build().perform();
		Assert.assertTrue("tool tip not showed", findElementByCssPath(dropdown_total_hours_css).getAttribute("tooltip").contains("Max Hours Available"));
		switchToDefaultContent();
	}

	public boolean verifyIncludeAssessmentFeild() {
		boolean flag=false;
		switchToFrameById(iframe_activity_create_id);
		activityDynamicXpath = getLocator(txt_panel_heading_xpath,
				"3. Include Assessment");
		flag= findElementByXpath(activityDynamicXpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void IsContinueButtonDisabled() {

		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue(findElementByCssPath(btn_continue_css).getAttribute("disabled").equalsIgnoreCase("true"));
		switchToDefaultContent();

	}

	public void IsContinueButtonEnabled() {
		switchToFrameById(iframe_activity_create_id);
		Assert.assertTrue(findElementByCssPath(btn_continue_css).getAttribute("disabled")==null);
		switchToDefaultContent();

	}

	public void isLessonCenterLOGODisplayed() {

		Assert.assertTrue(findElementByXpath(logo_lesson_center_xpath).getAttribute("src").contains("lesson-center-160.png"));
	}

	public void verifyValidationMessageOnContinueButton() throws AWTException {

		switchToFrameById(iframe_activity_create_id);
		action.moveToElement(findElementByCssPath(btn_continue_css)).build().perform();
		action.moveToElement(findElementByCssPath(btn_continue_css)).build().perform();
		System.out.println(findElementByCssPath(tooltip_txt_name).getAttribute("tooltip"));
		if( findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").contains("name"))
		{
			Assert.assertTrue("tool tip not showed", findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").equalsIgnoreCase("Please enter a lesson center name."));
			logPassMessage("tooltip showed for name not entered");
		}
		else if(findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").contains("date"))
		{
			Assert.assertTrue("tool tip not showed", findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").equalsIgnoreCase("Please enter a valid due date."));
			logPassMessage("tooltip showed for date not entered");
		}
		else if(findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").contains("score"))
		{

			Assert.assertTrue("tool tip not showed", findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").equalsIgnoreCase("Please enter a target mastery score from 0 to 100."));
			logPassMessage("tooltip showed target score not entered");
		}
		else if(findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").contains("objective"))
		{

			Assert.assertTrue("tool tip not showed", findElementByCssPath(tooltip_txt_name).getAttribute("tooltip").equalsIgnoreCase("Please select at least one learning objective."));
			logPassMessage("tooltip showed learning objective not entered ");
		}
		switchToDefaultContent();

	}
	public void navigateToEditOptionsFromLPN()
	{
		hardWait(8);
		switchToDefaultContent();	
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("LessonCenterName0",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		doHoverOverElement(findElementByXpath(activityDynamicXpath));
		hardWait(1);
		activityDynamicXpath = getLocator(btn_edit_LPN_xpath,
				PropFileHandler.readProperty("LessonCenterName0",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		doHoverOverElement(findElementByXpath(activityDynamicXpath));
		findElementByXpath(activityDynamicXpath).click();
		
		findElementByCssPath(btn_edit_options_css).click();
	}

	public void verifyLessonCenterNameIsEditable()
	{
	    hardWait(2);
		switchToFrameByCss(iframe_Edit_css);
		String EarlierName=findElementByCssPath(txtbox_lcname).getAttribute("value");
		String LessonName = "LessonCenter"+"_"+System.currentTimeMillis();
		for(int i=0; i<3;i++)
		{
	    findElementByCssPath(txtbox_lcname).click();
		findElementByCssPath(txtbox_lcname).clear();
		}
		findElementByCssPath(txtbox_lcname).sendKeys(LessonName);
		logPassMessage("Lesson Center Name Entered as : " + LessonName);
		System.out.println(LessonName);
		String NewName=findElementByCssPath(txtbox_lcname).getAttribute("value");
		Assert.assertFalse("Lesson Center name is not Editable", EarlierName.equals(NewName));
		//PropFileHandler.writeToFile("LessonCenter"+"Name"+Lcnumber, LessonName, YamlReader.getYamlValue("propertyfilepath"));
		switchToDefaultContent();
		
	}
	
	public void verifyDescriptionIsEditable()
	{
		switchToFrameByCss(iframe_Edit_css);
		String EarlierDescription=findElementByCssPath(txtbox_lcdescription).getAttribute("value");
		System.out.println(EarlierDescription);
		findElementByCssPath(txtbox_lcdescription).click();
		findElementByCssPath(txtbox_lcdescription).clear();
		findElementByCssPath(txtbox_lcdescription).sendKeys("Edited Description QA");
		hardWait(2);
		findElementByCssPath(txtbox_lcdescription).click();
		String NewDescription=findElementByCssPath(txtbox_lcdescription).getAttribute("value");
		System.out.println("New Description is"+NewDescription);
		Assert.assertFalse("Lesson Center Description is not Editable", EarlierDescription.equals(NewDescription));
		switchToDefaultContent();
	}
	
	public void verifyDueDateIsEditable()
	{
		switchToFrameByCss(iframe_Edit_css);
		String EarlierDate=findElementByCssPath(btn_calender_icon).getAttribute("value");
		findElementByCssPath(btn_calender_icon).click();
		String TodaysDate= getFutureValidDates(2);
		activityDynamicXpath = getLocator(btn_calender_date,TodaysDate);
		findElementByXpath(activityDynamicXpath).click();
		hardWait(1);
		findElementByXpath(btn_done).click();
		hardWait(1);
		String NewDate=findElementByCssPath(btn_calender_icon).getAttribute("value");
		Assert.assertFalse("Lesson Center Due Date is not Editable", EarlierDate.equals(NewDate));
		switchToDefaultContent();
	}
	
	public void verifyTargetMasteryScoreIsEditable()
	{
		switchToFrameByCss(iframe_Edit_css);
		String EarlierScore=findElementByCssPath(txtbox_targetScore_css).getAttribute("value");
		findElementByCssPath(txtbox_targetScore_css).click();
		findElementByCssPath(txtbox_targetScore_css).clear();
		findElementByCssPath(txtbox_targetScore_css).sendKeys("35");
		String NewScore=findElementByCssPath(txtbox_targetScore_css).getAttribute("value");
		Assert.assertFalse("Lesson Center Target Mastery is not Editable", EarlierScore.equals(NewScore));
		switchToDefaultContent();
	}
	
	public void verifyNumberOfHoursAreEditable()
	{
		switchToFrameByCss(iframe_Edit_css);
		String EarlierHours=findElementByCssPath(dropdown_total_hours_css).getAttribute("value");
		for(int i=0;i<3;i++)
		{
			findElementByCssPath(dropdown_total_hours_css).sendKeys(Keys.ARROW_DOWN);
		}
		String NewHours=findElementByCssPath(dropdown_total_hours_css).getAttribute("value");
		Assert.assertFalse("Lesson Center Target Mastery is not Editable", EarlierHours.equals(NewHours));
		switchToDefaultContent();
	}

	public void saveTheEditedFeilds() {
	
		switchToFrameByCss(iframe_Edit_css);
		findElementByCssPath(btn_continue_css).click();
		findElementByXpath(btn_save_lc_xpath).click();
		switchToDefaultContent();
	}
}



