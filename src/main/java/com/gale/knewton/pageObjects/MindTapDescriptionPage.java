package com.gale.knewton.pageObjects;

import java.io.IOException;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapDescriptionPage extends BaseWebComponent {

	private String btn_save_xpath = "//a[text()='Save']";
	private String modal_publishDetails_xpath = "//div[contains(@class,'lpn_form mxui_layout_modal') and contains(@style,'block')]";
	private String inp_title_id = "name";
	private String div_orderArrow_xpath = "//*[@id='order-button']/span[2]";
	private String option_order_xpath = "//*[@id='order-menu']/li[1]/a";
		
//	public void enterSaaActivityTitle() {
//		saaActivityTitle = "SaaActivity_" + timeStamp;
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(1);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(saaActivityTitle);
//		logPassMessage("Title entered as: " + saaActivityTitle);
//		PropFileHandler.writeToFile("saaActivityTitle", saaActivityTitle, 
//				YamlReader.getYamlValue("propertyfilepath"));
//	}

//	public void enterSimpAssessTitle() {
//		simpAssessActivityTitle = "SimpleAssessment_" + timeStamp;
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(1);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(simpAssessActivityTitle);
//		logPassMessage("Title entered as: " + simpAssessActivityTitle);
//		PropFileHandler.writeToFile("SimpleAssessmentActivityTitle", simpAssessActivityTitle, 
//				YamlReader.getYamlValue("propertyfilepath"));
//	}
	
//	public void enterVideoActivityTitle() {
//		manuallyGradableActivityTitle = "Video_" + timeStamp;
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(1);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(manuallyGradableActivityTitle);
//		logPassMessage("Activity Title entered as: " + manuallyGradableActivityTitle);
//		PropFileHandler.writeToFile("ManualGradingVideoActivityTitle", manuallyGradableActivityTitle, 
//				YamlReader.getYamlValue("propertyfilepath"));
//	}
	
//	public void enterinlineSimpAssessTitle() throws IOException {
//		simpAssessActivityTitle = "SimpleAssessment_" + timeStamp;
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(1);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(simpAssessActivityTitle);
//		logPassMessage("Title entered as: " + simpAssessActivityTitle);
//		PropFileHandler.writeToFile("InlineSimpleAssessmentActivityTitle", 
//				simpAssessActivityTitle, YamlReader.getYamlValue("propertyfilepath"));
//		
//	}

//	public void enterESCTitle(){
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(2);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(escTitle);
//		logPassMessage("Title entered as: " + escTitle);
//		PropFileHandler.writeToFile("ESCTitle", escTitle, YamlReader.getYamlValue("propertyfilepath"));
//	}
//	
	
	
//	public void enterUnitTitle() {
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(2);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(unitTitle);
//		logPassMessage("Title entered as: " + unitTitle);
//		PropFileHandler.writeToFile("UnitTitle", unitTitle, YamlReader.getYamlValue("propertyfilepath"));
//	}
	
	
	public void reorderActivity(){
		findElementByXpath(div_orderArrow_xpath).click();
		hardWait(1);
		findElementByXpath(option_order_xpath).click();
	}

	public void clickSaveButton() {
		hardWait(1);
		findElementByXpath(btn_save_xpath).click();
	}

//	public void enterFolderTitle() {
//		waitAndLocateElementByXpath(modal_publishDetails_xpath);
//		hardWait(2);
//		findElementById(inp_title_id).clear();
//		findElementById(inp_title_id).sendKeys(unitTitle);
//		logPassMessage("Title entered as: " + unitTitle);
//		PropFileHandler.writeToFile("UnitTitle", unitTitle, YamlReader.getYamlValue("propertyfilepath"));
//	}
//	
	public void enterTitleOnDescriptionLPNForm(String activityType){
		waitAndLocateElementByXpath(modal_publishDetails_xpath);
		waitAndLocateElementById(inp_title_id).clear();
		String activityName = activityType+"_"+System.currentTimeMillis();
		waitAndLocateElementById(inp_title_id).sendKeys(activityName);
		logPassMessage("Title entered as: " + activityName);
		PropFileHandler.writeToFile(activityType+"Title", activityName, YamlReader.getYamlValue("propertyfilepath"));
	}

	

}
