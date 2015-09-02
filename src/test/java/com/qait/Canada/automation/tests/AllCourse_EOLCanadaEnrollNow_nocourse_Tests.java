package com.qait.Canada.automation.tests;




/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import org.testng.*;
import com.qait.Canada.automation.util.Utilities;
import com.qait.Canada.automation.fixture.*;

import org.testng.TestListenerAdapter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author QAIT
 */
public class AllCourse_EOLCanadaEnrollNow_nocourse_Tests {

	EOLCanadaEnrollNow_nocourse_Fixture test = new EOLCanadaEnrollNow_nocourse_Fixture();
	
        String preFix;
	static int TotalCources;
	public static String StrName;
	public static int GetSelectedCourse;
	public static int initialCounter;
	public static int ScenarioCounter =1;

    
    @BeforeClass
    public void initialsettings() {
        test.setUpDataFile("testData/integration_testData_Canada.yml");
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
		System.out.println(TotalCources);
		test.stopBrowserSession();
	}
	
	@Test(dependsOnMethods = "getNumberOfCourseAvailable")
    public void Test() throws IOException {
		
		if (Utilities.getYamlValue("CanadaURLEnrollNownocourse.RunType").equalsIgnoreCase("Selected")){
			for (initialCounter=1; initialCounter<=Integer.parseInt(Utilities.getYamlValue("CanadaURLEnrollNownocourse.TotalCource"));initialCounter++)
			{
				System.out.println(initialCounter+" initial counter");
	            TestListenerAdapter tla = new TestListenerAdapter();
	            TestNG testng = new TestNG();
	            testng.setTestClasses(new Class[]{EOLCanadaEnrollNow_nocourse_Test.class});
	            testng.addListener(tla);
	            testng.run();
	            Utilities.lastRunReportSave();
	            ScenarioCounter++;
	            System.out.println("### "+initialCounter+" Selected All test calss");
			}	
		} 
		else{
			if (Utilities.getYamlValue("CanadaURLEnrollNownocourse.RunType").equalsIgnoreCase("AllCources")){
				for (initialCounter=1; initialCounter<=TotalCources;initialCounter++)
//					for (initialCounter=1; initialCounter<=5;initialCounter++)
				{
					System.out.println(initialCounter+" initial counter");
		            TestListenerAdapter tla = new TestListenerAdapter();
		            TestNG testng = new TestNG();
		            testng.setTestClasses(new Class[]{EOLCanadaEnrollNow_nocourse_Test.class});
		            testng.addListener(tla);
		            testng.run();
		            ScenarioCounter++;
		            Utilities.lastRunReportSave();
		            System.out.println("###"+initialCounter+"All Cources All test calss");
		    		Reporter.log(Utilities.logOutputFile(" ########## Start browser session ENDS ###########"));
		    		

				}		
		
			}		
		}	
		Utilities.copyFile();
		Utilities.renameReportFolder();	
	}    
}