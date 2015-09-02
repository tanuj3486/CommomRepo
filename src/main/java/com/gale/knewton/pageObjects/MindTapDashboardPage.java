package com.gale.knewton.pageObjects;

import org.openqa.selenium.interactions.Actions;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.PropFileHandler;
import com.gale.knewton.util.YamlReader;

public class MindTapDashboardPage extends BaseWebComponent {
	private String lbl_dashboard_xpath = "//a[@id='app_toggle']";
	private String lnk_UserMenu_css = ".user-menu-link.tb_item";
	private String lnk_CourseSetting_css = "#manage_users";
	private String icon_expandDashboardLink_xpath = "//div[@id='dashboard-settings']/form/h3/collapse-settings-group/span[1]";
	private String modal_CourseSettings_xpath = ".//*[@id='course_settings' and contains(@style,'block')]";
	private String chk_ToggleDashboard_css = "input[name='dashboardCheckbox']";
	private String btn_Save_id = "dashboard-settings-save-btn";
	private String btn_cancel_xpath = "//img[contains(@src,'bwc_close')]";
	private String btn_lpn_view = "li[title*='Unit View']";
	Actions action =  new Actions(driver);

	public boolean isMindtapDashboardDisplayed() {
		return waitAndLocateElementByXpath(lbl_dashboard_xpath).isDisplayed();
	}

	public void disableDashboard() {
		waitAndLocateElementByCss(lnk_UserMenu_css).click();
		hardWait(1);
		scrollDown(findElementByCssPath(lnk_CourseSetting_css));
		waitAndLocateElementByCss(lnk_CourseSetting_css).click();
		hardWait(1);
		waitAndLocateElementByXpath(modal_CourseSettings_xpath);
		try{
			resetImplicitTimeout(5);
			if(waitForLessTimeAndLocateElementByXpath(icon_expandDashboardLink_xpath).isDisplayed()){
				waitAndLocateElementByXpath(icon_expandDashboardLink_xpath).click();
			}
		}catch(Exception ex){
			logMessage("Expand Dashboard icon did not appear on Course Setting splash screen");
		}
		resetImplicitTimeout(30);
		
		hardWait(1);
		if(waitAndLocateElementByCss(chk_ToggleDashboard_css).isSelected()){
			waitAndLocateElementByCss(chk_ToggleDashboard_css).click();
		}
		
		hardWait(1);
		waitAndLocateElementById(btn_Save_id).click();
		logPassMessage("Dashboard disabled successfully");
	}
	public void showStudentLPN() {
		hardWait(1);
		findElementByCssPath(btn_lpn_view).click();
		hardWait(1);
		action.moveToElement(findElementByCssPath(btn_lpn_view)).click().build().perform();
	}

	public void clickCancelButton() {
		resetImplicitTimeout(2);
		try {
			hardWait(1);
			clickOnElementUsingActionBuilder(waitForLessTimeAndLocateElementByXpath(btn_cancel_xpath));
		} catch (Exception e) {
			System.out.println("Feedback popup not appeared");
		}
	}

	public void showInstructorLPN() {
		hardWait(1);
	findElementByCssPath(btn_lpn_view).click();
	hardWait(1);
	action.moveToElement(findElementByCssPath(btn_lpn_view)).click().perform();
	
	}


}
