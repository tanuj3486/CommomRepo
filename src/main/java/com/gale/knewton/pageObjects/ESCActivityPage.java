package com.gale.knewton.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ESCActivityPage extends BaseWebComponent {

private String frame_Esc_css = "iframe[title*='Adaptive App App']";

private String EscError_css = "#error p.ng-binding";
private String btn_closeIcon_class = "closeActivity";
private String btn_Next_Css = "input[value='Next']";
private String link_MaterReport_id = "mastery";
private String lbl_EscChapter_xpath = ".//*[@id='masteryList']/ul/span/li/p[1]";
private String lbl_ExamTitle_xpath = ".//*[@id='examTitle']/h2/span";
private String txt_content_xpath = "//div";
private String txt_contentESC_xpath = "//a";
private String instChapter;
private String product;
	
	public boolean isErrorDisplayed(String error){
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		hardWait(2);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(EscError_css)));
		String errorinst = findElementByCssPath(EscError_css).getText();
		System.out.println(errorinst);
		System.out.println("ERROROROR expected: "+error);
		switchToDefaultContent();
		return (error.equalsIgnoreCase(errorinst));
	}
	
	public void closeActivity(){
		hardWait(1);
		logMessage("Click close icon");
		fireOnClickJsEvent(btn_closeIcon_class);
		switchToDefaultContent();	
	}
	
	public boolean isESCActivityDisplayedatStud(){
		boolean flag;
		hardWait(1);
		switchToFrame(findElementByCssPath(frame_Esc_css));
		hardWait(2);
		resetImplicitTimeout(40);
		scrollDown(findElementByCssPath(btn_Next_Css));
		hardWait(1);
		flag=findElementByCssPath(btn_Next_Css).isDisplayed();
		switchToDefaultContent();
		return flag;
	}
	
	public void clickMasteryReport(){
		hardWait(1);
		switchToDefaultContent();
		switchToFrame(findElementByCssPath(frame_Esc_css));
		findElementById(link_MaterReport_id).click();
	}

	public boolean verifyChapterNameOnMasteryReport(){
		String chapter;
		hardWait(2);
		chapter = findElementByXpath(lbl_EscChapter_xpath).getText();
		instChapter = PropFileHandler.readProperty("EscChapterName", YamlReader.getData("propertyfilepath"));
		switchToDefaultContent();
		if(chapter.equals(instChapter))
			return true;
		else 
			return false;
	}
	
	public boolean verifyEscContent()
	{
		return findElementByXpath(txt_contentESC_xpath).isDisplayed();
		
		
	}
}
