package com.gale.knewton.pageObjects;

import static org.hamcrest.core.StringStartsWith.startsWith;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;
import com.thoughtworks.selenium.webdriven.commands.GetTitle;

public class UscActivityPage extends BaseWebComponent{
	
	private String lbl_USCheading_xpath = ".//div[contains(text(),'Study Center')]";
	private String btn_closeIcon_class = "closeActivity";
	private String frame_Usc_css = "iframe[title*='Adaptive App App']";
	private String childframe_Usc_css="#easyXDM_activityService_cxp_target_provider";
	private String link_MaterReport_xpath = "//*[text()='Mastery Report']";
	// private String btn_Next_Css = ".buttonWrapper>input";
	private String btn_Next_Css = "//input[@value='Next']";
	private String lbl_questionTitle_css = "#examTitle>h2>span";
	private String lbl_ChapterTitle_xpath = ".//*[@id='examTitle']/h2/span";
	private String firstLO="//*[@id='masteryList']//li[1]/p[1]";
	private String btn_Submit_css=".ci-submit>input";
	private String txt_feedbackAnswer_css=".ci-show-answer.ci-feedback";
	private String txt_feedbackTitle_css=".ci-feedback-title";
	private String iframe_adaptiveApp = ".ereader_iframe[title*='Adaptive App App']";

	public boolean isUSCactivityDisplayed(){
		return findElementByXpath(lbl_USCheading_xpath).isDisplayed();
	}
	
	public boolean isMasteryReportDisplayed(){
		hardWait(1);
		System.out.println("title"+driver.getTitle());
		switchToFrame(findElementByCssPath(frame_Usc_css));
		//clickOnMasteryReportLinkandGetlo();
		return waitAndLocateElementByXpath(link_MaterReport_xpath).isDisplayed();
	}
	public void clickOnMasteryReportLinkandGetlo(){
		waitAndLocateElementByXpath(link_MaterReport_xpath).click();
		String LO=waitAndLocateElementByXpath(firstLO).getText();
		PropFileHandler.writeToFile("firstLOName",LO ,YamlReader.getData("propertyfilepath") );
	}
	
	public void clickOnMasteryReportLink(){
		waitAndLocateElementByXpath(link_MaterReport_xpath).click();
		String LO=waitAndLocateElementByXpath(firstLO).getText();
		PropFileHandler.writeToFile("firstLOName",LO ,YamlReader.getData("propertyfilepath") );
	}
	public void closeUSCActivity(){
		hardWait(1);
		logMessage("Click close icon");
		fireOnClickJsEvent(btn_closeIcon_class);
		switchToDefaultContent();	
	}
	
	public boolean isNextButtondisplayed(){
		boolean f=false;
	try {	switchToFrame(findElementByCssPath(iframe_adaptiveApp));
		System.out.println(driver.getTitle());
		 f=findElementByXpath(btn_Next_Css).isDisplayed();
		switchToDefaultContent();
		return f;
	}catch(NoSuchElementException e) {
		try
		{
		switchToDefaultContent();
		switchToFrame(findElementByCssPath(iframe_adaptiveApp));
		System.out.println(driver.getTitle());
		 f=findElementByXpath(btn_Next_Css).isDisplayed();
		switchToDefaultContent();
		return f;
		}
		catch(Exception e1)
		{
			switchToDefaultContent();
			return true;
		}
			
	}

	}
	
	public void clickNextButton(){	
		try
		{
		switchToFrame(findElementByCssPath(iframe_adaptiveApp));
		findElementByXpath(btn_Next_Css).click();
		switchToDefaultContent();
	}
		catch(Exception e)
		{switchToDefaultContent();
			switchToFrame(findElementByCssPath(frame_Usc_css));
			findElementByXpath(btn_Next_Css).click();
			switchToDefaultContent();
		}
		}
	
	
	public boolean isContentDisplayed(){
		return !findElementByCssPath(lbl_questionTitle_css).getText().isEmpty();
	}
	
	public boolean verifyChapterNumber(){
		int number = 0;
		String product = PropFileHandler.readProperty("Product", YamlReader.getYamlValue("propertyfilepath"));
		String LPNchapter = PropFileHandler.readProperty("USCchapter",
				YamlReader.getYamlValue("propertyfilepath"));
		if(product.equals("Andersen"))	
		number = Integer.parseInt(LPNchapter.split(":")[0].substring(8));
		else
			if(product.equals("Gulati"))
			number = Integer.parseInt(LPNchapter.split(":")[0]);	
		String chNumber = findElementByXpath(lbl_ChapterTitle_xpath).getText();
		int chnumber = Integer.parseInt(chNumber.split(" ")[0].substring(2));
		if(number==chnumber)
			return true;
		else
			return false;
		
	}
	public String getFirstLearningObjectivesOnMasteryReport(){
		System.out.println("first objective=="+ waitAndLocateElementByXpath(firstLO).getText());
		String firstObjective= waitAndLocateElementByXpath(firstLO).getText();
		switchToDefaultContent();
		return firstObjective;
		}
	
	public String submitAnswerAndRecieveFeedback(){
		for(int i=1;i<10;i++){
		try{
			System.out.println("inside try");
			switchToFrame(findElementByCssPath(frame_Usc_css));
			switchToFrame(findElementByCssPath(childframe_Usc_css));
			System.out.println("inside try");
		if(findElementByCssPath(btn_Submit_css).isDisplayed()){
			System.out.println("inside if");
			waitAndLocateElementByCss(btn_Submit_css).click();
			return waitAndLocateElementByCss(txt_feedbackTitle_css).getText();
		}
		}catch(NoSuchElementException e){
			try{
			if(findElementByCssPath(btn_Submit_css).isDisplayed()){
				System.out.println("ok");
			}}
			catch(Exception e1){
				switchToDefaultContent();
				switchToFrame(findElementByCssPath(frame_Usc_css));
				clickNextButton();
			}
			
		}}
		return null;
	
	
		}
	public void clickOnsubmitAnswer(){
		if(isSubmitAnswerButtonPresent())
			waitAndLocateElementByCss(btn_Submit_css).click();
		}
	
	public boolean isSubmitAnswerButtonPresent(){
		for(int i=1;i<10;i++){
		try{
			switchToFrame(findElementByCssPath(frame_Usc_css));
			switchToFrame(findElementByCssPath(childframe_Usc_css));
		if(findElementByCssPath(btn_Submit_css).isDisplayed()){
			return true;
		}
		}catch(NoSuchElementException e){
			

			switchToDefaultContent();
			switchToFrame(findElementByCssPath(frame_Usc_css));
			clickNextButton();
			}
		}
		return false;
		}
	
	public String getAnswerFeedback(){
			 String feedback=waitAndLocateElementByCss(txt_feedbackTitle_css).getText();
			 switchToDefaultContent();
			 return feedback;
		}
		
	
	
}
