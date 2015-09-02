package com.gale.knewton.pageObjects;

import org.openqa.selenium.JavascriptExecutor;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.util.YamlReader;

public class CoursePaymentPage extends BaseWebComponent {

	private String btn_takeMeToMyCourse_css =".gracePeriodBtn";
	private String courseUrl;
	private String env;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	private String browser;

	public void clickTakeMeToMyCourse() {
		browser = YamlReader.getYamlValue("browser");
		env = YamlReader.getYamlValue("Environment");
		

			if(browser.equalsIgnoreCase("safari")){
				modifyMindTapURL();
				getUrl(courseUrl);
			}else
				{
				findElementByCssPath(btn_takeMeToMyCourse_css).click();
				changeWindow(1);
				changeWindow(0);
				changeWindow(1);
				}
			hardWait(2);
		}
	
	private void modifyMindTapURL() {
		env = YamlReader.getYamlValue("Environment");
		hardWait(2);
		courseUrl = (String) js.executeScript("return document.getElementById('courseURL').getAttribute('value');");
		if(courseUrl.contains("qaf.")&&(env.equals("qaf"))){
		logMessage("Launching student at QAF environment");	
		}
		else{
			if(env.equals("qad")){
			courseUrl = replaceText(courseUrl, "qaf.", "qad-");	
			}
		}
		}
}
