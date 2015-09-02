/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.IMS.automation.tests;

import java.io.IOException;
import org.testng.*;
import com.qait.IMS.automation.fixture.*;
import com.qait.Domestic.automation.util.Utilities;
import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author QAIT
 */
public class AllCourse_EOLIMSEnrollNow_nocourse_Tests {

	EOLEnrollNow_nocourse_Fixture test = new EOLEnrollNow_nocourse_Fixture();
	

	static int TotalCources;
	public static String StrName;
	public static int GetSelectedCourse;
	public static int initialCounter;
	public static int ScenarioCounter =1;
    @BeforeClass
    public void initialsettings() {
        test.setUpDataFile("testData/integration_testData_IMS.yml");
        Utilities.createExcel();
    }

	@Test
    public void setup()
    {
        test.startBrowserSession();
        
    }
	
	@Test(dependsOnMethods = "setup")
    public void launchHomePage() throws InterruptedException
    {
		test.launchUrl(test.getYamlVal("appurl"));
		Utilities.hardWait(4);
    }
	
	@Test(dependsOnMethods = "launchHomePage")
	public void homePageactions()
	{		
		test.verifyHomepage();		
	}
	
	@Test(dependsOnMethods = "homePageactions")
	public void getNumberOfCourseAvailable()
	{		
		TotalCources = test.getCourseCount();	
		//System.out.println(TotalCources);
		test.stopBrowserSession();
	}
	
	@Test(dependsOnMethods = "getNumberOfCourseAvailable")
    public void Test() throws IOException {
		
		if (Utilities.getYamlValue("IMSURLEnrollNownocourse.RunType").equalsIgnoreCase("Selected")){
			for (initialCounter=1; initialCounter<=Integer.parseInt(Utilities.getYamlValue("IMSURLEnrollNownocourse.TotalCource"));initialCounter++)
			{
	            TestListenerAdapter tla = new TestListenerAdapter();
	            TestNG testng = new TestNG();
	            
	            System.out.println("Pre: initialCounter : "+initialCounter);
	            testng.setTestClasses(new Class[]{EOLIMSEnrollNow_nocourse_Test.class});
	            System.out.println("Post: initialCounter : "+initialCounter);

	            testng.addListener(tla);
	            testng.run();
	            Utilities.lastRunReportSave();
	            ScenarioCounter++;
			}	
		} 
		else{
			if (Utilities.getYamlValue("IMSURLEnrollNownocourse.RunType").equalsIgnoreCase("AllCources")){
				for (initialCounter=1; initialCounter<=TotalCources;initialCounter++)

				{
		            TestListenerAdapter tla = new TestListenerAdapter();
		            TestNG testng = new TestNG();
		            testng.setTestClasses(new Class[]{EOLIMSEnrollNow_nocourse_Test.class});
		            testng.addListener(tla);
		            testng.run();
		            ScenarioCounter++;
		    		Reporter.log(Utilities.logOutputFile(" ########## Start browser session ENDS ###########"));
		    		

				}		
		
			}		
		}	
		Utilities.copyFile();
		Utilities.renameReportFolder();	
	}    
}