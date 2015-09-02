package com.gale.knewton.pageObjects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.swing.plaf.basic.BasicScrollPaneUI.HSBChangeListener;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ProgressApp extends BaseWebComponent {
	int array[];
	int max;

	private String frame_ProgressApp_class = "appFrame";
	//private String switchToFrameByClass(frame_ProgressApp_class); = "22_NB_Dock_IFrame";
	private String lbl_MyGradesStatus_xpath = "//a[text()='My Grades']/parent::*";
	private String btn_declineFeedback_css = "#fsrOverlay .fsrDeclineButtonContainer>a";
	private String popp_Feeback_css = "#fsrOverlay>.fsrFloatingContainer";
	private String lbl_MyGrade_xpath = "//*[@class='nav nav-tabs']/li[1]/a";
	private String lbl_MasteryReport_xpath = "//*[@class='nav nav-tabs']/li[2]/a";
	private String icon_CloseProgressApp_css = ".hideApp";
	private String area_mainProgressApp_css = "#marketing";

	private String link_Activity_link = "//span[contains(text(),'${activitytitle}')]";
	
	private String simple_Activity_link = "//a[contains(text(),'${activitytitle}')]";
	private String lbl_Score_xpath = "//a[text()='${activitytitle}']/../../td[3]/span/span";
	private String link_Activity_linkAtInst = "//span[text()='${activitytitle}']";
	private String lbl_Score_In_Overview_xpath = "//span[text()='${activitytitle}']/../following-sibling::span[2]";
	private String lbl_PopUpScore_xpath = "//li[@class='activity-table recorded']/div/div[2]/strong[3]";
	private String lbl_score_inst_xpath = "//span[text()='${score}']";
	private String btn_ViewButton_xpath = "//button[text()='View']";
	private String frame_MasteryReport_id = "masteryIFrame";
	private String lbl_EscChapter_xpath = "//label[text()='${activitytitle}']";
	private String lbl_UscChapter_xpath = "//label[text()='${activitytitle}']";
	private String img_Ratings_xpath = "//label[text()='${activitytitle}']/../span/span/i";
	private String lbl_EscChapNameOnLo_id = "chapnames";
	private String table_LO_xpath = "//*[@id='lorow']";

	private String div_summaryActivity_id = "activity_summary_inner";
	private String lnk_studentOnProgressApp_xpath = "(//div[@class='ngCanvas']//span[@class='ng-binding'])[1]";
	private String modal_activityDetailModal_xpath = "//div[contains(@class,'modal-detail')]";
	private String span_pendingWarningMessage_xpath = "//span[contains(@class,'pending-manual-grade')]";
	private String lnk_closeActivityDetailModal_xpath = "//button[@class='close']";

	private String btn_view_xpath = "//button[text()='View']";
	private String txt_scoreAfterGrading_xpath = "//button[text()='View']/parent::div/preceding-sibling::div[contains(@class,'score')]/strong";

	private String loNameInProgressApp = "//label[@id='lolabelnames']";
	private String progressAppHeading = "//h2[text()='Progress']";
	private String Stu_assesment_option = "//div[@class='lpn_thumbTitle']/h3[@class='lpn_name']/a[contains(text(),'${assessmentname}')]";
	private String lnk_student_name = "//a[@class='ngCellText ng-binding ng-scope ngCellElement' and contains(.,'Solanki06, Ritesh06')]";
	private String lnk_Quiz_name = "//a[@class='ng-binding ng-scope' and contains(.,'${activityname}')]";
	private String list_attempts_percentages_css = "ul>li>span>span>div:nth-child(2)";
	private String txt_recorded_score = ".score.ng-scope>strong:nth-child(3)";
    private String icon_home = "#nb_lpLauncher";
	public boolean verifyMyGradeAsDefaultTab() {
		boolean flag;
		switchToFrameByClass(frame_ProgressApp_class);
		flag = findElementByXpath(lbl_MyGradesStatus_xpath).getAttribute(
				"class").contains("active");
		switchToDefaultContent();
		return flag;
	}

	public void declineFeebackPopUpIfAppears() {
		resetImplicitTimeout(5);
		try {
			hardWait(1);
			waitForLessTimeAndLocateElementByCss(popp_Feeback_css);
			waitForLessTimeAndLocateElementByCss(btn_declineFeedback_css)
					.click();
		} catch (Exception ex) {
			logMessage("Feeback Pop up screen was expected but did not appear");
		}
		resetImplicitTimeout(30);
	}

	public String getMyGrade() {
		declineFeebackPopUpIfAppears();
		switchToFrameByClass(frame_ProgressApp_class);
		String s = findElementByXpath(lbl_MyGrade_xpath).getText();
		switchToDefaultContent();
		return s;
	}

	public String getMasteryReport() {
		switchToFrameByClass(frame_ProgressApp_class);
		String s1 = findElementByXpath(lbl_MasteryReport_xpath).getText();
		switchToDefaultContent();
		return s1;
	}

	public void clickMasteryReport() {
		switchToFrameByClass(frame_ProgressApp_class);
		hardWait(1);
		scrollDown(findElementByXpath(lbl_MasteryReport_xpath));
		findElementByXpath(lbl_MasteryReport_xpath).click();
		switchToDefaultContent();
	}

	public boolean isStudentProgressAppDisplayed() {
		boolean flag;
		switchToFrameByClass(frame_ProgressApp_class);
		flag = findElementByXpath(lbl_MyGrade_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public String getSAScore() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(lbl_Score_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String SAscore = waitAndLocateElementByXpath(DynamicXpath).getText();
		switchToDefaultContent();
		return SAscore;
	}

	public String getInlineSAScore() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(lbl_Score_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String inlineSAscore = waitAndLocateElementByXpath(DynamicXpath)
				.getText();
		switchToDefaultContent();
		return inlineSAscore;
	}

	public String getInlineSAScoreAtInstructorEnd() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(lbl_Score_In_Overview_xpath,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String inlineSAscore = waitAndLocateElementByXpath(DynamicXpath)
				.getText().trim();
		switchToDefaultContent();
		return inlineSAscore;
	}

	public String getSAAScore() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(
				lbl_Score_xpath,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		String SAAscore = waitAndLocateElementByXpath(DynamicXpath).getText();
		switchToDefaultContent();
		return SAAscore;
	}

	public String getSAAScoreAtInstructorEnd() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(lbl_Score_In_Overview_xpath,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		System.out.println("dynamic path" + DynamicXpath);
		String SAAscore = waitAndLocateElementByXpath(DynamicXpath).getText()
				.trim();
		System.out.println(SAAscore + "saa score");
		switchToDefaultContent();
		return SAAscore;
	}

	public void clickDistinctSaActivityLink() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(link_Activity_link,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
	}
	public void clickDistinctSimpleActivityLink() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(simple_Activity_link,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
	}
	public void clickDistinctSaActivityLinkAtInstructorEnd() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(link_Activity_linkAtInst,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();

	}

	public void clickInlineSaActivityLink() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(link_Activity_link,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
	}

	public void clickInlineSaActivityLinkAtInstEnd() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(link_Activity_linkAtInst,
				PropFileHandler.readProperty(
						"InlineSimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
	}

	public void clickSaaActivityLink() {
		switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(
				link_Activity_link,
				PropFileHandler.readProperty("saaActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
	}

	public String getPopUpRecordedScore() {
		return findElementByXpath(lbl_PopUpScore_xpath).getText();
	}

	public boolean verifySAScore(String score) {
		boolean flag=false;
		String DynamicXpath = getLocator(lbl_score_inst_xpath, score);
		flag=findElementByXpath(DynamicXpath).isDisplayed();
		return flag;
		
	}

	public void clickOnSAScore(String score) {
		String DynamicXpath = getLocator(lbl_score_inst_xpath, score);
		findElementByXpath(DynamicXpath).click();
	}

	public boolean isViewButtonDisplayed() {
		return findElementByXpath(btn_ViewButton_xpath).isDisplayed();
	}

	public void clickViewButton() {
		findElementByXpath(btn_ViewButton_xpath).click();
		switchToDefaultContent();
	}

	public String getEscChapterName() {
		String ESCchapter = PropFileHandler.readProperty("EscChapterName",
				YamlReader.getData("propertyfilepath"));
		switchToFrameByClass(frame_ProgressApp_class);
		switchToFrameById(frame_MasteryReport_id);
		String DynamicXpath = getLocator(lbl_EscChapter_xpath, ESCchapter);
		return waitAndLocateElementByXpath(DynamicXpath).getText();
	}

	public int getEscChapterRating() {
		int i = 0;
		String DynamicXpath = getLocator(
				img_Ratings_xpath,
				PropFileHandler.readProperty("EscChapterName",
						YamlReader.getData("propertyfilepath")));
		List<WebElement> ratings = waitAndLocateElementsByXpath(DynamicXpath);
		for (WebElement rating : ratings) {
			if (rating.getAttribute("class").equals(
					"glyphicon ng-scope glyphicon-star"))
				i++;
		}
		return i;
	}

	public void clickEscChapterLink() {
		String DynamicXpath = getLocator(
				lbl_EscChapter_xpath,
				PropFileHandler.readProperty("EscChapterName",
						YamlReader.getData("propertyfilepath")));
		findElementByXpath(DynamicXpath).click();
	}

	public String getEscChapterNameOnLoWindow() {
		return waitAndLocateElementById(lbl_EscChapNameOnLo_id).getText();
	}

	public int getLoSizeOfEscChapter() {
		int i = waitAndLocateElementsByXpath(table_LO_xpath).size();
		switchToDefaultContent();
		return i;
	}

	public void closeProgressApp() {

		switchToDefaultContent();
		hardWait(1);
		executeJavaScriptCommand("document.getElementsByClassName('hideApp')[0].click()");
		// waitAndLocateElementByCss(icon_CloseProgressApp_css);
	}

	public String getUscChapterName() {
		String USCchapter = PropFileHandler.readProperty("USCchapter",
				YamlReader.getData("propertyfilepath"));
		switchToFrameByClass(frame_ProgressApp_class);
		switchToFrameById(frame_MasteryReport_id);
		String DynamicXpath = getLocator(lbl_UscChapter_xpath, USCchapter);
		return waitAndLocateElementByXpath(DynamicXpath).getText();
	}

	public int getUscChapterRating() {
		int i = 0;

		String DynamicXpath = getLocator(
				img_Ratings_xpath,
				PropFileHandler.readProperty("USCchapter",
						YamlReader.getData("propertyfilepath")));
		hardWait(20);
		List<WebElement> ratings = waitAndLocateElementsByXpath(DynamicXpath);
		for (WebElement rating : ratings) {

			if (rating.getAttribute("class").equals(
					"glyphicon ng-scope glyphicon-star"))
				i++;
		}
		return i;
	}

	public void clickUscChapterLink() {
		String DynamicXpath = getLocator(
				lbl_UscChapter_xpath,
				PropFileHandler.readProperty("USCchapter",
						YamlReader.getData("propertyfilepath")));
		findElementByXpath(DynamicXpath).click();
	}

	public boolean verifyLOForSelectedChapterInProgressApp() {

		List<WebElement> elements = waitAndLocateElementsByXpath(loNameInProgressApp);
		for (WebElement loName : elements) {
			waitForElementToBePresent(loName);
			String loname = loName.getText();
			// switchToDefaultContent();
			if (loname.equalsIgnoreCase(PropFileHandler.readProperty(
					"firstLOName", YamlReader.getData("propertyfilepath")))) {
				return true;
			}
		}
		return false;

	}

	public String getTabsInProgressAppAtInstructorEnd(String tabName) {
		switchToFrameByClass(frame_ProgressApp_class);
		String tabsName = findElementByXpath(
				"//div[@id='headerTabs']//div[text()='" + tabName + "']")
				.getText();
		switchToDefaultContent();
		return tabsName;
	}

	public void clickOnTabInProgressAppAtInstructorEnd(String tabName) {
	switchToFrameByClass(frame_ProgressApp_class);
		findElementByXpath(
				"//div[@id='headerTabs']//div[text()='" + tabName + "']")
				.click();
		switchToDefaultContent();

	}

	public String getSelectedTabInProgressAppAtInstructorEnd() {
	switchToFrameByClass(frame_ProgressApp_class);
		String selectedTabsName = findElementByXpath(
				"//div[@id='headerTabs']//a[contains(@class,'selected')]/div")
				.getText();
		switchToDefaultContent();
		return selectedTabsName;
	}

	public String verifyProgressAppHeading() {

		String heading = findElementByXpath(progressAppHeading).getText();
		System.out.println("heading name verified");
		return heading;
	}

	public void clickManualGradingActivityOnProgressApp() {
		waitAndLocateElementById(frame_ProgressApp_class);
	switchToFrameByClass(frame_ProgressApp_class);
		String DynamicXpath = getLocator(link_Activity_linkAtInst,
				PropFileHandler.readProperty("ManualGradingVideoActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		findElementByXpath(DynamicXpath).click();
		switchToDefaultContent();

	}

	public boolean verifyActivitySummaryOnProgressApp() {
switchToFrameByClass(frame_ProgressApp_class);
		boolean flag = waitAndLocateElementById(div_summaryActivity_id)
				.isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public void clickOnStudentLink() {
		switchToFrameByClass(frame_ProgressApp_class);
		hardWait(1);
		waitAndLocateElementByXpath(lnk_studentOnProgressApp_xpath).click();
		switchToDefaultContent();
	}

	public boolean verifyActivityDetailModalWindowOpens() {
	switchToFrameByClass(frame_ProgressApp_class);
		boolean flag = waitAndLocateElementByXpath(
				modal_activityDetailModal_xpath).isDisplayed();
		switchToDefaultContent();
		return flag;
	}

	public boolean verifyCorrectMessageForPendingGrading(String yamlValue) {
		switchToFrameByClass(frame_ProgressApp_class);
		boolean flag = waitAndLocateElementByXpath(
				span_pendingWarningMessage_xpath).getText().trim()
				.equals(yamlValue);
		// findElementByXpath(lnk_closeActivityDetailModal_xpath ).click();
		switchToDefaultContent();
		return flag;
	}

	public void clickViewButtonForManualGradingActivity() {
		switchToFrameByClass(frame_ProgressApp_class);
		waitAndLocateElementByXpath(btn_view_xpath).click();
		switchToDefaultContent();
	}

	public boolean verifyManualGradingScoreAfterInstructorDidGrading() {
	switchToFrameByClass(frame_ProgressApp_class);
		boolean flag = waitAndLocateElementByXpath(txt_scoreAfterGrading_xpath)
				.getText()
				.trim()
				.contains(
						PropFileHandler.readProperty(
								"manualGradingPercentageScore",
								YamlReader.getYamlValue("propertyfilepath")));
		switchToDefaultContent();
		return flag;
	}

	public boolean verifyNoStudentOnProgresApp() {
		switchToFrame(waitAndLocateElementByClass(frame_ProgressApp_class));
		boolean flag = waitAndLocateElementByCss(area_mainProgressApp_css).getAttribute("class").contains("noStudents");
		switchToDefaultContent();
		return flag;

	}

	public void studentSelectSimpleAssessment(String assessmentname) {
		String DynamicXpath = getLocator(Stu_assesment_option, assessmentname);
		waitAndLocateElementByXpath(DynamicXpath).click();

	}

	public void clickOnStudentNameOnGradebook() {

		findElementByXpath(lnk_student_name).click();
	}

	public void clickonQuizNameForReview() {
		String DynamicXpath = getLocator(lnk_Quiz_name,
				PropFileHandler.readProperty("SimpleAssessmentActivityTitle",
						(YamlReader.getData("propertyfilepath"))));
		waitAndLocateElementByXpath(DynamicXpath).click();

	}

	public void reviewTheStudentActivityForBestCase() {

		List<Integer> list = new ArrayList<Integer>();
		for (WebElement element : findElementsByCssPath(list_attempts_percentages_css)) {
			list.add(Integer.parseInt(element.getText()));
		}

		Collections.sort(list);
		int size = list.size();
		max = list.get(size);

		Assert.assertEquals(max, Integer.parseInt(findElementByXpath(
				txt_recorded_score).getText()));
		logPassMessage("Intsructor Successfully Reviews the Student for Best Case");
	}

	public void reviewTheStudentActivityForLastCase() {

		List<Integer> list = new ArrayList<Integer>();
		for (WebElement element : findElementsByCssPath(list_attempts_percentages_css)) {
			list.add(Integer.parseInt(element.getText()));
		}
		int size = list.size();
		max = list.get(size);

		Assert.assertEquals(max, Integer.parseInt(findElementByXpath(
				txt_recorded_score).getText()));
		logPassMessage("Intsructor Successfully Reviews the Student for Last Case");
	}

	public void clickHomeIcon() {
		findElementByCssPath(icon_home).click();
		
	}
}
