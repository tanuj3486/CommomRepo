package com.gale.knewton.pageObjects;

import com.gale.knewton.base.BaseWebComponent;

public class AssessmentActivityInformation extends BaseWebComponent {
	
	private String lbl_ActivityInformationTitle_xpath = "//h2[text()='Assessment Activity Information']";
	private String lbl_RecordedScore_css = "td.attempt_score.recorded_score>div>span";
	private String btn_Review_xpath = "(//input[@type='button' and @value='Review'])[1]";
	private String btn_start_xpath=".//input[@class='tryagain']";
	
	public boolean isUserOnAssessmentActivityPage(){
		hardWait(1);
		return waitAndLocateElementByXpath(lbl_ActivityInformationTitle_xpath).isDisplayed();
	}
	
	public String getRecordedScore(){
		return findElementByCssPath(lbl_RecordedScore_css).getText();
	}
	
	public boolean isReviewButtonDisplayed()
	{
		return findElementByXpath(btn_Review_xpath).isDisplayed();
	}
	
	public void clickReviewButton(){
		findElementByXpath(btn_Review_xpath).click();
	}

	public void clickStartButton() {
        findElementByXpath(btn_start_xpath).click();
		
	}

}
