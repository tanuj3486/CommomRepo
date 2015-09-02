package com.gale.knewton.base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.commons.configuration.PropertiesConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.gale.knewton.base.BaseWebComponent;
import com.gale.knewton.pageObjects.AddActivityPanelPage;
import com.gale.knewton.pageObjects.AssessmentActivityInformation;
import com.gale.knewton.pageObjects.ConfirmCourseInfoPage;
import com.gale.knewton.pageObjects.CoursePaymentPage;
import com.gale.knewton.pageObjects.CreateCoursePage;
import com.gale.knewton.pageObjects.ESCActivityPage;
import com.gale.knewton.pageObjects.EbookDocumentPage;
import com.gale.knewton.pageObjects.EulaPage;
import com.gale.knewton.pageObjects.ExamStudyCenterConfigPage;
import com.gale.knewton.pageObjects.LessonCenterActivityPage;
import com.gale.knewton.pageObjects.LessonCenterConfigPage;
import com.gale.knewton.pageObjects.LoginPage;
import com.gale.knewton.pageObjects.ManuallyGradableVideoActivityPage;
import com.gale.knewton.pageObjects.MindTapDashboardPage;
import com.gale.knewton.pageObjects.MindTapDescriptionPage;
import com.gale.knewton.pageObjects.MindTapLPNPage;
import com.gale.knewton.pageObjects.ProgressApp;
import com.gale.knewton.pageObjects.SAA_ActivityPage;
import com.gale.knewton.pageObjects.SSOInstructorDashboardPage;
import com.gale.knewton.pageObjects.SSOStudentDashBoardPage;
import com.gale.knewton.pageObjects.SimpleAssessmentActivityPage;
import com.gale.knewton.pageObjects.ThreeLeggedAuthentication;
import com.gale.knewton.pageObjects.UscActivityPage;
import com.gale.knewton.util.Emailer;
import com.gale.knewton.util.YamlReader;

import cucumber.api.java.After;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;

//import cucumber.api.Scenario;
//import cucumber.api.java.After;


public class BaseTest extends BaseWebComponent {
	
	public static String env;
	public static PropertiesConfiguration envProperties;

	private static String browser = null;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	public static void setUp(String environment) {
		
		
		YamlReader.setYamlFilePath();
		if(environment == null || environment.isEmpty() || environment.equals("")){
			env = YamlReader.getYamlValue("Environment");
		}else{
			env = environment;
		}
		
		setBrowser(env);
		initialize_PageObjects();
	}
	
	public static AddActivityPanelPage addActivityPage;
	public static MindTapDescriptionPage mindTapDescriptionPage;
	public static MindTapLPNPage mindTapLPNPage;
	public static ExamStudyCenterConfigPage escConfigPage;
	public static SimpleAssessmentActivityPage simpleAssessmentActivityPage;
	public static EbookDocumentPage eBookDocPage;
	public static ESCActivityPage escPage;
	public static MindTapDescriptionPage mindTapDescPage;
	public static SSOStudentDashBoardPage ssoDashBoardPage;
	public static LoginPage loginPage;
	public static ConfirmCourseInfoPage confirmCourseInfoPage;
	public static CoursePaymentPage coursePaymentPage;
	public static AssessmentActivityInformation activityInfo;
	public static SAA_ActivityPage saaActivity;
	public static ManuallyGradableVideoActivityPage manuallyGradableActivityPage;
	public static ESCActivityPage escActivity;
	public static UscActivityPage uscActivitypage;
	public static ProgressApp progressApp;
	public static SSOInstructorDashboardPage ssoInstDashBoardPage;
	public static EulaPage eulaPage;
	public static MindTapDashboardPage mindTapDashboard;
	public static CreateCoursePage createCoursePage;
	public static ThreeLeggedAuthentication threeLeggedAuthentication;
	public static LessonCenterConfigPage LCconfigPage;
	public static LessonCenterActivityPage LCactivityPage;
	
	public static void initialize_PageObjects(){
		eulaPage = new EulaPage();
		createCoursePage = new CreateCoursePage();
		ssoInstDashBoardPage = new SSOInstructorDashboardPage();
		mindTapDashboard=new MindTapDashboardPage();
		addActivityPage = new AddActivityPanelPage();
		progressApp = new ProgressApp();
		uscActivitypage = new UscActivityPage();
		escActivity = new ESCActivityPage();
		coursePaymentPage = new CoursePaymentPage();
		manuallyGradableActivityPage = new ManuallyGradableVideoActivityPage();
		activityInfo = new AssessmentActivityInformation();
		saaActivity = new SAA_ActivityPage();
		mindTapDescPage = new MindTapDescriptionPage();
		mindTapDescriptionPage = new MindTapDescriptionPage();
		mindTapLPNPage = new MindTapLPNPage();
		escConfigPage = new ExamStudyCenterConfigPage();
		simpleAssessmentActivityPage = new SimpleAssessmentActivityPage();
		eBookDocPage = new EbookDocumentPage();
		escPage = new ESCActivityPage();
		loginPage = new LoginPage();
		ssoDashBoardPage = new SSOStudentDashBoardPage();
		confirmCourseInfoPage =new ConfirmCourseInfoPage();
		threeLeggedAuthentication = new ThreeLeggedAuthentication();
		LCconfigPage = new LessonCenterConfigPage();
		LCactivityPage = new LessonCenterActivityPage();
		
	}
	

	public static void setBrowser(String environment) {
		driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	    driver.get(YamlReader.getYamlValue(environment+".url"));
	}

	public static WebDriver getDriver() {
		browser = System.getProperty("browser", YamlReader.getYamlValue("browser"));
		String server = YamlReader.getYamlValue("seleniumserver");
		if (server.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox")) {
				return getFirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				
				return getChromeDriver(YamlReader.getYamlValue("chromeDriverPath"));
			}else if(browser.equalsIgnoreCase("safari")){
				return getSafariDriver();
			}else if(browser.equalsIgnoreCase("IE"))
				return getIEDriver(YamlReader.getYamlValue("IEDriverPath"));
		}
		if (server.equalsIgnoreCase("remote")) {
			return setRemoteDriver();
		}
		return getFirefoxDriver();

	}

	private static WebDriver setRemoteDriver() {
		DesiredCapabilities cap = null;
		browser = YamlReader.getYamlValue("browser");
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie"))
				|| (browser.equalsIgnoreCase("internetexplorer"))
				|| (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
		}
		String seleniuhubaddress = YamlReader
				.getYamlValue("seleniumserverhost");
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}

	private static WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		capabilities.setJavascriptEnabled(true);
		return new ChromeDriver(capabilities);
	}
	
	private static WebDriver getIEDriver(String driverpath) {
		System.setProperty("webdriver.ie.driver", driverpath);
		capabilities.setJavascriptEnabled(true);
		capabilities.setCapability("ignoreZoomSetting", true);
		return new InternetExplorerDriver(capabilities);
	}
	
	private static WebDriver getSafariDriver(){
		capabilities.setJavascriptEnabled(true);
		return new SafariDriver();
	}

	private static WebDriver getFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.cache.disk.enable", false);
		return new FirefoxDriver(profile);
	}

/*	@Before
	public void printClassName() {
		String className = this.getClass().getCanonicalName();
		System.out.println("Running Test:" + className);
	}

	@Before
	public void printScenarioName(Scenario scenario) {
		System.out.println("Running scenario:" + scenario.getName());
	}*/
//
//	@After
//	public void embedScreenshot(Scenario scenario) {
//		System.out.println("scenario===" + scenario.getName());
//		if (scenario.isFailed()) {
//			System.out.println("embedScreenshot");
//			byte[] screenshot = ((TakesScreenshot) driver)
//					.getScreenshotAs(OutputType.BYTES);
//			File screenshot1 = ((TakesScreenshot) driver)
//					.getScreenshotAs(OutputType.FILE);
//			scenario.embed(screenshot, "image/jpeg");
//
//			Calendar calendar = Calendar.getInstance();
//			SimpleDateFormat formater = new SimpleDateFormat(
//					"dd_MM_yyyy_hh_mm_ss");
//			try {
//				FileUtils
//						.copyFile(
//								screenshot1,
//								new File("screenshots/" + scenario.getName()
//										+ "_"
//										+ formater.format(calendar.getTime())
//										+ ".jpg"));
//			} catch (IOException e1) { 
//				e1.printStackTrace();
//			}
//		}
//	}
	


	public static void tearDown() {
		 driver.quit();
       
	}

	static Map<String, String> productName = new HashMap<String, String>();
	
}