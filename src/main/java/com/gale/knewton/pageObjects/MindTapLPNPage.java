package com.gale.knewton.pageObjects;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapLPNPage extends BaseWebComponent {

	private String arrowImg_xpath = "//img[contains(@src,'arrow_right')]";
	private String btn_LPN_couse_css = ".ng-scope.pane-lpn.pane.active";
	private String div_LPNstud_xpath = ".ng-scope.pane-lpn.pane.active";
	private String btn_add_css = ".course_view_title_container>.lpn_create>a.navLink.menu_trigger";
	private String btn_addActivity_css = "(//li[@class='menu_item activity']/a)[2]";
	private String lnk_AddFolder_xpath = "(//a[contains(text(),'Add Folder')])[2]";
	private String lnk_AddUnit_css = "(//a[contains(text(),'Add Unit')])[2]";
	private String logo_Splash_xpath="//img[@class='splash_logo']";
	private String btn_enter_id = "nb_enter";
	private String btn_closeOverlay_css = "a.close.mxui_layout_positionable";
	private String btn_homeIcon_id = "nb_lpLauncher";
	private String img_back_xpath = "//*[text()='back']";

	private String img_firstUnit_xpath = "(//*[@class='lpn_thumbImage'])[1]/../following-sibling::div[1]//a";
	private String lnk_firstUnit_xpath = "(//*[@class='lpn_thumbImage'])[1]/../following-sibling::div[@class='lpn_thumbTitle']//a";
	private String div_thumbar_xpath = "//div[contains(@title,'Reading')][1]";
	private String img_ChapterFolderGul_xpath = "(//img[@title='Folder']/following-sibling:: div//a[contains(.,'Part')])[1]";
	private String img_expandedFolders_xpath = "//img[@title='Folder' and parent::div[contains(@class,'lpn_group_expanded')]]";
	private String icon_announcementNotice_xpath = "//div[contains(@class,'announcement')]/div/a[contains(@class,'nb_closeIcon')]";

	private String link_activityName_xpath = "//a[contains(.,'${activitytitle}')]";
	private String link_score_xpath = "//a[contains(.,'${activitytitle}')]/../../ul/li[@class='scoreDiv']/a";
	private String div_thumbarForActivityName_xpath = "//a[contains(text(),'${activitytitle}')]/../../preceding-sibling::div";
	private String li_thumbarForActivityName_xpath = "//a[contains(text(),'${activitytitle}')]/../../preceding-sibling::div/parent::div";
	
	private String icon_SimpleAssessmentActivityStatus_xpath = link_activityName_xpath + "/span[2]";
	private String img_SimpleAssessmentlpnScore_xpath = link_activityName_xpath
			+ "/following::div[3]";
	private String link_AttemptedSAA_xpath = "//*[@class='lpn_name' and contains(.,'${activitytitle}')]";
	private String img_InlineSAlpnScore_xpath = "//a[contains(.,'${activitytitle}')]/../../ul/li/a";
	private String img_InlineSAlpnScoreAtInstEnd_xpath = "//a[contains(.,'${activitytitle}')]/../following-sibling::ul/li[1]/strong";
	private String icon_SAAactivityStatus_xpath = "//*[@class='lpn_name' and contains(.,'${activitytitle}')]/span[2]";
	private String img_SAAlpnScore_xpath = "//*[@class='lpn_name' and contains(.,'${activitytitle}')]//following::div[3]";
	private String score_ManuallyGradedActivity_xpath = "//a[contains(text(),'${activitytitle}')]/../following-sibling::ul//li[@class='scoreDiv']/strong";
	private String btn_take_again_xpath = "//a[contains(.,'Take Again')]";
	private String img_expandInline_xpath = link_activityName_xpath
			+ "/ancestor::div[3]/div[@class='lpn_inlineActivities']/a/img";
	private String img_InlneSAactivityStatus_xpath = link_activityName_xpath
			+ "/span[2]";
	private String submittedForInline = "//a[contains(.,'${activitytitle}')]/../following-sibling::ul/li[2]";
	private String activityDynamicXpath;

	private String link_ESCactivity_xpath = "//a[contains(.,'${activitytitle}')]";
	private String ESCactivitydynamicxpath;

	private String div_animationLayer_xpath = "(//div[@class='animation_layer'])[1]";
	
	private String titleLPN_xpath = "//span[@class='lpn_title' and contains(text(),'${lpn_title}')]";
	
	
	private String link_USCactivity_xpath = "//a[contains(.,'Study Center')]";
	private String lbl_USCchapter_class = ".lpn_title:nth-child(2)";

	private String icon_ProgressApp_xpath = "//*[@id='app_gradebook_student']/img";
	private String icon_ProgressAppInstructor_xpath = "//*[@id='app_viewProgress']/img";
	private String icon_ProgressAppInstructor_id="icon_ProgressAppInstructor_id";
	private String product;
	private String txt_scoreOnLPN_xpath = "//a[contains(.,'${scoreOfActivity}')]/../following-sibling::div[contains(@class,'lpn_score')]";
	private String frame_1_inline = ".ereader_iframe[title*='Reader App']";
	
	private String lnk_show_hideActivity_xpath = "//div[@class='nb_edit' and contains(@style,'block')]//a[contains(@class,'clui-hide_show')]";
	private String lnk_deleteActivity_xpath = "//div[@class='nb_edit' and contains(@style,'block')]//a[contains(@class,'clui-delete')]";
	private String li_LPNActivities_xpath = "(//ul[contains(@class,'lpn_stacklist')])[1]/li[contains(@class,'lpn_node')]";
	
	
	////////////// Student LPN //////////////
	private String folder_preLinkedESC_xpath = "(//a[contains(.,'Exam Study Center')])[4]";
	private String lnk_preLinkedESCInsideFolder_xpath = "//div[@class='expandable']//h3[@class='lpn_name']/a[contains(.,'Exam Study Center')]";
	private String area_hiddenLpnActivity_xpath = "//a[contains(text(),'${activityName}')]/../following-sibling::div[@class='hiddenMsg']";
	
	private String img_hiddenActivity_xpath = area_hiddenLpnActivity_xpath+"//img[contains(@src,'images/hide.png')]";
	private String li_hiddenActivity_xpath = "//a[contains(text(),'${activityName}')]/../../../parent::li[contains(@class,'hidden')]";
	private String li_visibleActivity_xpath = "//a[contains(text(),'${activityName}')]/../../../parent::li[not(contains(@class,'hidden'))]";
	private String lnk_show_Activity_xpath = "//a[contains(text(),'${activityName}')]/../../../parent::li[contains(@class,'hidden')]//div[@class='nb_edit']//img[@class='show']/parent::a[contains(@class,'clui-hide_show')]";
	private String lnk_unitUnderFirstPart_css = ".expandable li:nth-child(2)";
	private String btn_closeButton_css = ".nb_closeIcon.nb_closeRight.cancel";
	private String lnk_editActivity_xpath = "//div[@class='nb_edit' and contains(@style,'block')]//a[contains(@class,'clui-edit')]";
	private String msg_SAA_NoAttempts_xpath = "//h3[contains(.,'${activityName}')]/following-sibling::div[@class='nb_notify inline_alert not_available']";
	private String div_activityThumbBar_css = ".lpn_activityList .thumbBar";
	private String txt_lpn_score_xpath = "//div[@class='lpn_thumbTitle']/div[contains(@class,'lpn_score')]";
	private String btn_unity_view_css="ul.nav>li[title*='Unit View']";
	private String btn_view_score_css = "(.//input[@class='attempt_view_button'])[1]";
	
	
	
	private MindTapDashboardPage mindTapDashboard = new MindTapDashboardPage();

	
	public void hoverOnLPNElement(String targetLPNElement){
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(targetLPNElement+"Title",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		doHoverOverElement(findElementByXpath(activityDynamicXpath));
	}
	
	public void hideLPNElement(){
		waitAndLocateElementByXpath(lnk_show_hideActivity_xpath).click();
	}
	public void clickOnActivityThumbbar(){
		waitAndLocateElementByXpath(lnk_deleteActivity_xpath).click();
	}
	public boolean verifyHiddenMessage(String activityName){
		hardWait(2);
		boolean flag1 = waitAndLocateElementByXpath(getLocator(area_hiddenLpnActivity_xpath, 
				PropFileHandler.readProperty(activityName+"Title",
						(YamlReader.getData("propertyfilepath"))))).isDisplayed();
		boolean flag2 = findElementByXpath(getLocator(img_hiddenActivity_xpath, 
				PropFileHandler.readProperty(activityName+"Title",
						(YamlReader.getData("propertyfilepath"))))).isDisplayed();
		boolean flag3 = findElementByXpath(getLocator(li_hiddenActivity_xpath, 
				PropFileHandler.readProperty(activityName+"Title",
						(YamlReader.getData("propertyfilepath"))))).isDisplayed();
		return flag1 && flag2 && flag3;
	}
	
	
	public void showLPNActivity(String activityName){
		findElementByXpath(getLocator(lnk_show_Activity_xpath, PropFileHandler.readProperty(activityName+"Title",
				(YamlReader.getData("propertyfilepath"))))).click();

	}
	
	public boolean verifyHiddenElementNowVisibleOnLPN(String activityName){
		hardWait(2);
		boolean flag1 = waitAndLocateElementByXpath(getLocator(li_visibleActivity_xpath, 
				 PropFileHandler.readProperty(activityName+"Title",
							(YamlReader.getData("propertyfilepath"))))).isDisplayed();
		return flag1;
	}
	
	public void deleteLPNElement(){
		waitAndLocateElementByXpath(lnk_deleteActivity_xpath).click();
		handleAlert();
		hardWait(1);
	}
	
	public void editLPNElement(){
		waitAndLocateElementByXpath(lnk_editActivity_xpath).click();
	}
	
	public boolean verifyActivtyGetsDeleted(String activityName){
		
		try{
			resetImplicitTimeout(10);
			findElementByXpathWithoutDefaultWait(getLocator(link_activityName_xpath, 
					PropFileHandler.readProperty(activityName+"Title",
							(YamlReader.getData("propertyfilepath")))));
			logWarningMessage("Activity still dislayed after deleting it");
			return false;
		}catch(NoSuchElementException ex){
			logPassMessage("Activity deleted successfully from LPN");
			return true;
		}
	}
	
	public void collapseLPNFolders() {
		hardWait(1);
		List<WebElement> folders = driver.findElements(By
				.xpath(img_expandedFolders_xpath));
		for (WebElement folder : folders)
			folder.click();
	}

	public boolean getInstLPNDisplayed() {
		boolean flag;
		flag = isLPNDisplayedAtInstructor();
		if (flag) {
			return true;
		} else {
			mindTapDashboard.showInstructorLPN();
			//openMindTapLPN();
			return isLPNDisplayedAtInstructor();
		}
	}

	public boolean isLPNDisplayedAtStudent() {
		return findElementByCssPath(div_LPNstud_xpath).isDisplayed();
	}

	public boolean isLPNDisplayedAtInstructor() {
		boolean flag=false;
		flag=findElementByCssPath(btn_LPN_couse_css).isDisplayed();
		return flag;
	}

	public void openMindTapLPN() {
		findElementById(btn_homeIcon_id).click();
		logPassMessage("Clicked over MindTap Home button to display LPN");
	}

	public void clickEnter() {
		hardWait(1);
		try {
			waitAndLocateElementByXpath(logo_Splash_xpath);
			waitAndLocateElementById(btn_enter_id);
			executeJavaScriptCommand("document.getElementsByClassName('cancel')[0].click()");
			hardWait(1);
			findElementByCssPath(btn_closeOverlay_css).click();
			logPassMessage("Splash Screen closed successfully");
		} catch (Exception e) {
			System.out.println("*******Exception" + e);
		}
	}

	public void clickAddActivitybutton() {
		hardWait(1);
		findElementByCssPath(btn_add_css).click();
		findElementByXpath(btn_addActivity_css).click();
	}

	public void clickAddUnitlink(){
		Actions action =  new Actions(driver);
		waitAndLocateElementByCss(btn_add_css).click();
		hardWait(1);
		try{
	findElementByXpath(lnk_AddUnit_css).click();
		}
	catch(Exception e)
		{
	action.moveToElement(findElementByXpath(lnk_AddUnit_css)).click().perform();
		}
	}
	
	public void clickAddFolderButton() {
		hardWait(1);
		waitForElementByCSSToDisappear(btn_closeButton_css);
		scrollDown(waitAndLocateElementByCss(btn_add_css));
		waitAndLocateElementByCss(btn_add_css).click();
		hardWait(2);
		scrollDown(waitAndLocateElementByXpath(lnk_AddFolder_xpath));
		waitAndLocateElementByXpath(lnk_AddFolder_xpath).click();
	}
	
	public void closeAnnouncement() {
		try {
			resetImplicitTimeout(3);
			if (findElementByXpath(icon_announcementNotice_xpath).isDisplayed()) {
				findElementByXpath(icon_announcementNotice_xpath).click();
				hardWait(1);
			}

		} catch (Exception e) {
		}

	}

	public void navigateToEBookDocument() {
		product = YamlReader.getYamlValue("title");
		if (product.equals("Andersen")) {
			hardWait(1);
			findElementByXpath(img_firstUnit_xpath).click();
			try
			{
				resetImplicitTimeout(5);
				waitAndLocateElementByXpath(div_animationLayer_xpath);
			}catch(Exception ex){
				// Nothing to do if animation layer doesnt show up on LPN
			}
			resetImplicitTimeout(30);
			hardWait(2);
			logMessage("Navigate to ebook");
			findElementByXpath(div_thumbar_xpath).click();
			logMessage("clicked");
		} else if (product.equals("Gulati")) {
			hardWait(1);
			findElementByXpath(img_ChapterFolderGul_xpath).click();
			hardWait(1);
			findElementByCssPath(lnk_unitUnderFirstPart_css).click();
			resetImplicitTimeout(5);
			try
			{
				waitAndLocateElementByXpath(div_animationLayer_xpath);
			}catch(Exception ex){
				// Nothing to do if animation layer doesn't show up on LPN
			}
			resetImplicitTimeout(30);
			hardWait(1);
			scrollDown(findElementByXpath(div_thumbar_xpath));
			findElementByXpath(div_thumbar_xpath).click();
		}
	}

	
	public boolean verifySavedActivityOnLPN(String activityName){
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(activityName+"Title",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(2);
		return findElementByXpath(activityDynamicXpath).isDisplayed();
	}



	public void clickDistinctSimpleAssessment_Activity() {
		hardWait(2);
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		scrollDown(waitAndLocateElementByXpath(activityDynamicXpath));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}
	

	public void clickManuallyGradableVideo_Activity() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(3);
		findElementByXpath(activityDynamicXpath).click();
	}

	public void clickDistinctSAA_Activity() {
		activityDynamicXpath = getLocator(
				link_activityName_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}


	public void clickESCActivity() {
		
		ESCactivitydynamicxpath = getLocator(
				link_ESCactivity_xpath,
				PropFileHandler.readProperty("ESCTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(60);
		logMessage("Click ESC Activity");
		findElementByXpath(ESCactivitydynamicxpath).click();
	}

	public void navigateToBaseLPN() {
		product = PropFileHandler.readProperty("Product",
				YamlReader.getYamlValue("propertyfilepath"));
		if (product.equals("Andersen")) {
			hardWait(3);
			findElementByXpath(img_back_xpath).click();
		} else if (product.equals("Gulati")) {
			hardWait(3);
			findElementByXpath(img_back_xpath).click();
		}
		
		resetImplicitTimeout(5);
		try{
			waitForLessTimeAndLocateElementByXpath(div_animationLayer_xpath);
		}catch(Exception ex){
			// Nothing to do when animation layer isn't available
		}
		resetImplicitTimeout(60);
		collapseLPNFolders();
	}

	public boolean getStudLPNDisplayed() {
		boolean flag;
		flag = isLPNDisplayedAtStudent();
		if (flag) {
			return true;
		} else {
			mindTapDashboard.showStudentLPN();
			//openMindTapLPN();
			return isLPNDisplayedAtStudent();
		}
	}

	public void clickDistinctSAasStudent() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}

	public String navigateToChapterLPN() {
		String nameOfLinkClicked = null;
		product = PropFileHandler.readProperty("Product",
				YamlReader.getYamlValue("propertyfilepath"));
		if (product.equals("Andersen")) {
			hardWait(2);
			nameOfLinkClicked = findElementByXpath(lnk_firstUnit_xpath).getText();
			waitAndLocateElementByXpath(img_firstUnit_xpath).click();
		} else if (product.equals("Gulati")) {
			hardWait(1);
			waitAndLocateElementByXpath(img_ChapterFolderGul_xpath).click();
			hardWait(1);
			nameOfLinkClicked = findElementByCssPath(lnk_unitUnderFirstPart_css).getText();
			waitAndLocateElementByCss(lnk_unitUnderFirstPart_css).click();
		}
		logMessage("Name of link clicked on LPN for navigating to Unit Study Center:- "+nameOfLinkClicked);
		return nameOfLinkClicked.trim();
	}

	public boolean isUSCLinkDisplayed(String name) {
		resetImplicitTimeout(5);
	
		try{
			findElementByXpath(div_animationLayer_xpath);
		}catch(Exception ex){
			// Nothing to do if animation layer doesn't show up
		}
		resetImplicitTimeout(10);
		
		try{
			findElementByXpath(getLocator(titleLPN_xpath, name));
			logMessage("LPN title correctly verified while navigating to USC");
		}catch(Exception ex){
			// Nothing to do if name parameter is thrown empty
		}
		
		hardWait(2);
		resetImplicitTimeout(60);
		
		return findElementByXpath(link_USCactivity_xpath).isDisplayed();
	}

	public void clickUSCActivity() {
		hardWait(1);
		String usc = findElementByCssPath(lbl_USCchapter_class).getText();
		System.out.println(usc);
		PropFileHandler.writeToFile("USCchapter", usc,
				YamlReader.getYamlValue("propertyfilepath"));
		hardWait(1);
		findElementByXpath(link_USCactivity_xpath).click();
	}

	public void clickProgressApp() {
		logMessage("Click Progress App icon");
		hardWait(1);
		scrollDown(waitAndLocateElementByXpath(icon_ProgressApp_xpath));
		// scrollDown(findElementByXpath(icon_ProgressApp_xpath));
		waitAndLocateElementByXpath(icon_ProgressApp_xpath).click();
		mindTapDashboard.clickCancelButton();
	}

	public void clickInstructorProgressApp() {
		logMessage("Click Progress App icon");
		scrollDown(waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath));
		clickOnElementUsingActionBuilder(waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath));
		//findElementByXpath(icon_ProgressAppInstructor_xpath).click();
		System.out.println("progress app clicked");
		// waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath).click();
	}
	public void clickInstructorProgressApp1() {
		logMessage("Click Progress App icon");
		//scrollDown(waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath));
		//waitAndLocateElementById(icon_ProgressAppInstructor_id).click();
		clickOnElementUsingActionBuilder(waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath));
		//findElementByXpath(icon_ProgressAppInstructor_xpath).click();
		System.out.println("progress app clicked");
		// waitAndLocateElementByXpath(icon_ProgressAppInstructor_xpath).click();
	}


	public boolean isDistinctSAattempted() {
		activityDynamicXpath = getLocator(
				icon_SimpleAssessmentActivityStatus_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		return findElementByXpath(activityDynamicXpath).getText().contains(
				"Submitted");
	}

	public boolean isSAAattempted() {
		activityDynamicXpath = getLocator(
				icon_SAAactivityStatus_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		return findElementByXpath(activityDynamicXpath).getText().contains(
				"Submitted");
	}

	public String getDistinctSimpleAssessmentLpnScore() {
		hardWait(2);
		activityDynamicXpath = getLocator(img_SimpleAssessmentlpnScore_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String score = waitAndLocateElementByXpath(activityDynamicXpath)
				.getText();
		score = score.split(":")[1].substring(1);
		return score;
	}

	public String getInlineSimpleAssessmentLpnScore() {
		activityDynamicXpath = getLocator(img_InlineSAlpnScore_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		return waitAndLocateElementByXpath(activityDynamicXpath).getText();

	}

	public String getInlineSimpleAssessmentLpnScoreAtInstEnd() {
		activityDynamicXpath = getLocator(img_InlineSAlpnScoreAtInstEnd_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		return waitAndLocateElementByXpath(activityDynamicXpath).getText()
				.trim();

	}

	public String getSAALpnScore() {
		hardWait(2);
		activityDynamicXpath = getLocator(
				img_SAAlpnScore_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String score = waitAndLocateElementByXpath(activityDynamicXpath)
				.getText();
		score = score.split(":")[1].substring(1);
		return score;
	}
	
	public String getManuallyGradableVideoActivityScore() {
		hardWait(2);
		activityDynamicXpath = getLocator(
				score_ManuallyGradedActivity_xpath,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String score = waitAndLocateElementByXpath(activityDynamicXpath)
				.getText();
		return score;
	}

	public void clickAttemptedSAAactivity() {
		activityDynamicXpath = getLocator(
				link_AttemptedSAA_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
	}

	public void clickAttemptedInlineSAactivity() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
	}
	public void verifyTakeAgainButtonForInlineAssessment()
	{ hardWait(4);
		switchToFrame(findElementByCssPath(frame_1_inline));
		activityDynamicXpath = getLocator(btn_take_again_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).isDisplayed();
		switchToDefaultContent();
	}
	public void clickScoreOfAttemptedInlineSAactivity() {
		activityDynamicXpath = getLocator(link_score_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(activityDynamicXpath).click();
	}
	public void clickViewButtonforInlineAssessment() {
		hardWait(2);
	findElementByXpath(btn_view_score_css).click();
	}

	public boolean isInlineSAattempted() {
		expandInlineOnLPN();
		hardWait(1);
		activityDynamicXpath = getLocator(img_InlneSAactivityStatus_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		return findElementByXpath(activityDynamicXpath).getText().contains(
				"Submitted");
	}

	public boolean isInlineSAattemptedAtInstructorEnd() {
		expandInlineOnLPNAtInstructorEnd();
		hardWait(2);
		activityDynamicXpath = getLocator(submittedForInline,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		boolean flag = waitAndLocateElementByXpath(activityDynamicXpath)
				.getText().contains("Submitted");
		return flag;
	}

	public void expandInlineOnLPN() {
		hardWait(1);
		activityDynamicXpath = getLocator(img_expandInline_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		if (findElementByXpath(activityDynamicXpath).getAttribute("src").contains("arrow_right")) {
			findElementByXpath(activityDynamicXpath).click();
		}
	}

	public void expandInlineOnLPNAtInstructorEnd() {
		hardWait(1);
		findElementByXpath(arrowImg_xpath).click();
		hardWait(1);
	}

	public boolean verifySavedVideoActivityOnLPN() {
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(3);
		return findElementByXpath(activityDynamicXpath).isDisplayed();

	}
	
	public boolean verifyGeneratedScoreForManualGradingActivityOnLPN(){
		activityDynamicXpath = getLocator(txt_scoreOnLPN_xpath,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		hardWait(1);
		String scoreValueFromLPN = findElementByXpath(activityDynamicXpath).getText().replaceAll(".0%", "").split(":")[1].trim();
		return scoreValueFromLPN.equals(PropFileHandler.
				readProperty("manualGradingPercentageScore",(YamlReader.getData("propertyfilepath"))));

	}

	public void refeshPageBeforeReview() {
		driver.navigate().refresh();
		hardWait(1);
	}
	
	public boolean navigateToPreBuiltESC(){
		scrollDown(waitAndLocateElementByXpath(folder_preLinkedESC_xpath));
		boolean flag1 = findElementByXpath(folder_preLinkedESC_xpath).isDisplayed();
		findElementByXpath(folder_preLinkedESC_xpath).click();
		hardWait(1);
		/*boolean flag2 = waitAndLocateElementByXpath(lnk_preLinkedESCInsideFolder_xpath).isDisplayed();
		waitAndLocateElementByXpath(lnk_preLinkedESCInsideFolder_xpath).click();*/
		return flag1;
		
	}


	public boolean verifyNoScoreIsGeneretedOnLPN(String title) {
		activityDynamicXpath = getLocator(div_thumbarForActivityName_xpath,
				PropFileHandler.readProperty(title+"Title",
						(YamlReader.getData("propertyfilepath"))));
		boolean flag1 = !(waitAndLocateElementByXpath(activityDynamicXpath).getAttribute("class").contains("done"));
		
		activityDynamicXpath = getLocator(li_thumbarForActivityName_xpath,
				PropFileHandler.readProperty(title+"Title",
						(YamlReader.getData("propertyfilepath"))));
		boolean flag2 = !(waitAndLocateElementByXpath(activityDynamicXpath).getAttribute("class").contains("lpn_graded"));
	
		return flag1 && flag2;
	}
	
	public boolean verifyNoMoreAttemptRemainingForActivity(String... messages){
		boolean flag1=false;
		activityDynamicXpath = getLocator(msg_SAA_NoAttempts_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		
		 flag1 = waitAndLocateElementByXpath(activityDynamicXpath).isDisplayed();
		boolean flag2 =false;
		for(String message: messages){
			if(findElementByXpath(activityDynamicXpath).getText().trim().contains(message)){
				flag2 = true;
			}else{
				flag2 = false;
			}
			
			if(!flag2){
				break;
			}
		}
	
		return flag1 && flag2;
	}
	
	public void clickOnUnitChapterLink(){
		waitAndLocateElementByXpath(img_firstUnit_xpath).click();
	}

	public String saveTheLpnScore() {
		//waitAndLocateElementByXpath(txt_lpn_score_xpath);
		switchToDefaultContent();
		hardWait(3);
		try
		{
	 String lpnscore = findElementByXpath(txt_lpn_score_xpath).getText();
	 System.out.println(lpnscore);
	 return lpnscore;
		}
		catch(StaleElementReferenceException e)
		{
			String lpnscore = findElementByXpath(txt_lpn_score_xpath).getText();
			 System.out.println(lpnscore);
			 return lpnscore;
		}
	
		
	}

	public void verifyFortheBestScore(String take1) {
	
		String take2=saveTheLpnScore();
		String take3=(take2.substring(16,17));
		int tak2=Integer.parseInt(take3);
		System.out.println("take 2"+tak2);
		String take4=(take1.substring(16,17));
		int tak1=Integer.parseInt(take4);
		System.out.println("take1"+tak1);
		String score=findElementByXpath(txt_lpn_score_xpath).getText().substring(16,17);
		System.out.println("score"+score);
		int score1=Integer.parseInt(score);
		System.out.println(score1);
		if(tak1>tak2)
		{
			Assert.assertTrue("Best score is not displayed", tak1==score1);
		}
		else
		{
			Assert.assertTrue("Best score is not displayed", tak2==score1);
		}
	}
	public void verifyFortheLastScore() {
		
		String take2=saveTheLpnScore();
		int tak2=Integer.parseInt(take2);
	
			Assert.assertTrue("Last Score is displayed", tak2==Integer.parseInt(findElementByXpath(txt_lpn_score_xpath).getText()));
		
	}

	public void clickLastSimpleAssessment_Activity() {
		
		hardWait(2);
		activityDynamicXpath = getLocator(link_activityName_xpath,
				PropFileHandler.readProperty("LastSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		scrollDown(waitAndLocateElementByXpath(activityDynamicXpath));
		hardWait(1);
		findElementByXpath(activityDynamicXpath).click();
	}

	public void clickOnUnityViewButton() {
		
		Actions action = new Actions(driver);
		hardWait(2);
		action.click();
		findElementByCssPath(btn_unity_view_css).click();
		}


}

