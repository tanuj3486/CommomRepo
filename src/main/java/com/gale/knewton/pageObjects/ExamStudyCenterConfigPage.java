package com.gale.knewton.pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class ExamStudyCenterConfigPage extends BaseWebComponent {
	
	private String iframe_distinctActivity_id = "distinct_activity_create_frame";
	private String label_examStudyCenter_xpath = "//h3[text()='Exam Study Center - Configuration']";
	private String inp_examDueDate_id = "examDueDate";
	private String chkbox_Chapter_xpath = "(//*[@name='chk'])[1]"; //Specify index for chapter number
	private String lbl_ESCchapterName_xpath = chkbox_Chapter_xpath+"/following-sibling::span";
	private String btn_save_id = "save";
	private String components_config_xpath= "//*[contains(text(),'${component}')]";
	private String heading;
	private String input_field_examTargetScore_css = "#examTargetScore";
	private String li_uncheckedCheckBoxesOnESC_xpath = "//div[@id='chaplist']//input";
	private String input_examTargetScoreSpan_css ="#unit";
	private String checkbox_selectAll_css = "#selectAll";
	private String lnk_esc_xpath="//span[contains(text(),'Exam Study Center')]";
	private String btn_editoptions_css =".editOptions";
	
	public String getExamStudyCenterHead(){
		switchToDefaultContent();
		hardWait(1);
		switchToFrame(findElementById(iframe_distinctActivity_id));
		hardWait(3);
		waitAndLocateElementByXpath(label_examStudyCenter_xpath);
		hardWait(1);
		heading =  findElementByXpath(label_examStudyCenter_xpath).getText();
		switchToDefaultContent();
		return heading;	
	}
	
	public void enterExamDueDate(){
		hardWait(1);
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementById(inp_examDueDate_id).clear();
		hardWait(1);
		findElementById(inp_examDueDate_id).sendKeys(getNextMonthDate());
		switchToDefaultContent();
	}
	
	public void selectChapterCheckbox(){
		hardWait(1);
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementByXpath(chkbox_Chapter_xpath).click();
		String chapterName = findElementByXpath(lbl_ESCchapterName_xpath).getText();
		PropFileHandler.writeToFile("EscChapterName", chapterName, YamlReader.getData("propertyfilepath"));
		logMessage("Chapter Selected-->"+chapterName);
		switchToDefaultContent();
	}
	
	public void clickSave(){
		hardWait(2);
		switchToFrame(findElementById(iframe_distinctActivity_id));
		findElementById(btn_save_id).click();
		switchToDefaultContent();
	}
	
	public String getExamDueDate(){
		return findElementById(inp_examDueDate_id).getAttribute("value");
	}
	
	public boolean verifyESCConfigComponents( String components){
		boolean flag;
		switchToFrame(findElementById(iframe_distinctActivity_id));
		if(components.contains("Save")){
			flag= findElementById(btn_save_id).isDisplayed();
		}
		else{
		flag = waitAndLocateElementByXpath(getLocator(components_config_xpath,components)).isDisplayed();
		}
		switchToDefaultContent();
		return flag;
		
	}
	 
  public boolean verifyExamTargetScore(){
	  switchToFrame(findElementById(iframe_distinctActivity_id));
	  String targetScore= findElementByCssPath(input_field_examTargetScore_css).getAttribute("class");
	  System.out.println(targetScore);
	  boolean flag1=targetScore.contains("ng-valid");
	  String span = findElementByCssPath(input_examTargetScoreSpan_css).getText();
	  boolean flag2= span.contains("%"); 
	  switchToDefaultContent();
	  return flag1 && flag2;
  }
	
  public boolean verifyUnselectedChapterCheckboxes(){
	  switchToDefaultContent();
	  boolean flag=true;
	  switchToFrame(findElementById(iframe_distinctActivity_id));
	  List<WebElement> checkboxes = waitAndLocateElementsByXpath(li_uncheckedCheckBoxesOnESC_xpath);
	  for (WebElement checkbox: checkboxes){
		  flag = checkbox.isSelected();
	  	if(flag){
	  		logMessage("One or more checkboxes is selected by default");
	  		return false;
	  	}
	  }
	  switchToDefaultContent();
	  return flag;
  }

  public boolean verifyClearAllCheckBoxIsUnselected(){
	  switchToFrame(findElementById(iframe_distinctActivity_id));
	  boolean flag1 = findElementByCssPath(checkbox_selectAll_css).isDisplayed();
	  boolean flag2 = !(findElementByCssPath(checkbox_selectAll_css).isSelected()); 
	  switchToDefaultContent();
	  return flag1&&flag2;
  }
  
  public void clickOnSelectAllCheckBox(){
	  hardWait(1);
	  switchToDefaultContent();
	  switchToFrame(findElementById(iframe_distinctActivity_id));
	  findElementByCssPath(checkbox_selectAll_css).click();
	  switchToDefaultContent();
  }
  
  public boolean verifyAllChaptersAreSelected(){
	  boolean flag=false;
	  switchToFrame(findElementById(iframe_distinctActivity_id));
	  List<WebElement> checkboxes = waitAndLocateElementsByXpath(li_uncheckedCheckBoxesOnESC_xpath);
	  for (WebElement checkbox: checkboxes){
		  flag = checkbox.isSelected();
	  	if(flag){
	  		logMessage("One or more checkboxes is selected by default");
	  		return true;
	  	 }
      }
	  switchToDefaultContent();
	  return flag;
  }
	    
  public void hoverOnPreBuiltESC(){
	  doHoverOverElement(findElementByXpath(lnk_esc_xpath));
  }
  
  public void clickOnEditOptionsButtonOnEditPanel(){
	  waitAndLocateElementByCss(btn_editoptions_css).click();
  }
}
