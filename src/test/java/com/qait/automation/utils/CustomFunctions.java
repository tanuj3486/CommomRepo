package com.qait.automation.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomFunctions{
	
	static WebDriver driver;
	static String filePathOfDownload=System.getProperty("user.dir")+File.separator+"src"+File.separator+"test"
            +File.separator+"resources"+File.separator+"Downloads"+File.separator;
	
	public CustomFunctions(WebDriver driver) {
		CustomFunctions.driver = driver;
	}

	/*
	 * Takes a String and returns a String appended with current timestamp
	 */
	public static String getStringWithTimestamp(String name) {
		Long timeStamp = System.currentTimeMillis();
		return name  + timeStamp;
	}

	/*
	 * Takes screenshot. Creates Screenshot in path/Screenshots/<Date>
	 * with name <DateTime>_<Testname>.png
	 */
	public String takeScreenshot(String folderName, String testname, String ftpUrl,
			String userid, String password, String uploadImage) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
		Date date = new Date();
		String date_time = dateFormat.format(date);

		File file = new File(System.getProperty("user.dir")+File.separator +folderName + File.separator + "Screenshots"
				+ File.separator + date_time);
		boolean exists = file.exists();
		if (!exists) {
			new File(System.getProperty("user.dir")+File.separator +folderName + File.separator + "Screenshots" + File.separator + testname + 
					File.separator + date_time).mkdir();
		}

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			String saveImgFile = System.getProperty("user.dir")+File.separator +folderName + File.separator + "Screenshots"
					+ File.separator + testname + File.separator + date_time + 
					File.separator + "screenshot.png";
			//System.out.println("Save Image File Path : " + saveImgFile);
			FileUtils.copyFile(scrFile, new File(saveImgFile));
			if (uploadImage.equalsIgnoreCase("true")){
				return uploadScreenshotToServer(ftpUrl, userid, password, testname, saveImgFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void takeScreenshot(String testname) {
    	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_hh_mm_a");
		Date date = new Date();
		String date_time = dateFormat.format(date);
		File file = new File(System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + testname + 
				File.separator + date_time);
		boolean exists = file.exists();
		if (!exists) {
			new File(System.getProperty("user.dir") + File.separator + "Screenshots" + File.separator + testname + 
					File.separator + date_time).mkdir();
		}

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			String saveImgFile = System.getProperty("user.dir") + File.separator + "Screenshots"
					+ File.separator + testname + File.separator + date_time + 
					File.separator + "screenshot.png";
			System.out.println("Save Image File Path : " + saveImgFile);
			FileUtils.copyFile(scrFile, new File(saveImgFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// On Test Failure calls function which takes screenshot 
	public void takeScreenShotOnException(String testname,	ITestResult result, 
			String takeScreenshot) {
		if (result.getStatus() == ITestResult.FAILURE) {
			if (takeScreenshot.equalsIgnoreCase("true")){
				try{
				if (driver != null)
					takeScreenshot(testname);
			}catch(Exception  ex){
				Reporter.log("Driver is null while taking screen shot", true);
			}
		}  
	}
}

	/*
	 * Uploads screenshot to <ftpurl>/selenium/test/resourcepagetest/<datetime>/screenshot.png
	 * and prints the image Url
	 */
	public String uploadScreenshotToServer(String serverUrl, String userid, String password, 
			String imgDir, String imageFilePath) {
		System.out.println("Uploading screenshot to server...");
		FTPClient client = new FTPClient();
        FileInputStream fis = null;
        String imageFileUrl = "ftp://" + serverUrl;
        try {
            client.connect(serverUrl);
            showServerReply(client);
            client.login(userid, password);
            showServerReply(client);
            String workingDirectory = client.printWorkingDirectory();
            System.out.println("Current working directory is: " + client.printWorkingDirectory());
            List<String> dirNames = Arrays.asList("selenium", "test", "resourcepagetest", imgDir);
            for (int i = 0; i < dirNames.size(); i++) {
            	client.makeDirectory(workingDirectory + dirNames.get(i));
            	workingDirectory = workingDirectory + dirNames.get(i) + "/";
            	imageFileUrl = imageFileUrl + "/" + dirNames.get(i);
            }
            client.setFileType(FTPClient.BINARY_FILE_TYPE);
            client.changeWorkingDirectory(workingDirectory);
            File srcFile = new File(imageFilePath); 
            fis = new FileInputStream(srcFile);
            client.storeFile("screenshot.png", fis);
            showServerReply(client);
            client.logout();
            showServerReply(client);
            imageFileUrl = imageFileUrl + "/screenshot.png";
            System.out.println("Screenshot URL : " + imageFileUrl);
            return imageFileUrl;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                client.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
		return "";
	}
	
    private static void showServerReply(FTPClient ftpClient) {
        String[] replies = ftpClient.getReplyStrings();
        if (replies != null && replies.length > 0) {
            for (String aReply : replies) {
                System.out.println("SERVER: " + aReply);
            }
        }
    }
    
    
    private List<String> getListOfSubdirectory(String path) {
    	File pageObjDir = new File(path);
    	File[] listOfFiles = pageObjDir.listFiles();
    	List<String> subdirList = new ArrayList<String>();
    	for (int i = 0; i < listOfFiles.length; i++) {
    		if (listOfFiles[i].isDirectory()) {
    			subdirList.add(listOfFiles[i].getName());
    	    } 
    	}
    	return subdirList;
    }
    
    private List<String> getListOfFiles(String path) {
    	File pageObjDir = new File(path);
    	File[] listOfFiles = pageObjDir.listFiles();
    	List<String> fileList = new ArrayList<String>();
    	for (int i = 0; i < listOfFiles.length; i++) {
    		if (listOfFiles[i].isFile()) {
    			fileList.add(listOfFiles[i].getName());
    	    } 
    	}
    	return fileList;
    }
    
    
    private List<String> getListOfElementNames(String actionFilePath) throws FileNotFoundException {
    	List<String> elemNames = new ArrayList<String>();
    	BufferedReader br = new BufferedReader(new FileReader(actionFilePath));
    	String line;
    	try {
			while ((line = br.readLine()) != null) {
			   List<String> elemNamesInLine = getElementNamesFromLine(line);
			   if (elemNamesInLine != null){
				   for (int i = 0; i < elemNamesInLine.size(); i++) {
				        if (!elemNames.contains(elemNamesInLine.get(i))) {
				        	elemNames.add(elemNamesInLine.get(i));
				        }
				    }
			   }   
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return elemNames;
    }
    
    private List<String> getElementNamesFromLine(String line) {
    	List<String> matches = new ArrayList<String>();
        String pattern = "(isElementDisplayed|element|elements|verifyCheckBoxIsChecked)[(][\"](.*?)[\"]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        while(m.find()){
        	matches.add(m.group(2));
        }
    	return matches;
    }
    
    public void reportPageObjectDescrepancies(String projDir){
    	System.out.println("Reporting any descrepencies in Page Object Files...");
    	String pageObjectDir = projDir + File.separator + "src" + File.separator + "test"
    			+ File.separator + "resources" + File.separator + "PageObjectRepository";
    	String keywordDir = projDir + File.separator + "src" + File.separator + "test"
    			+ File.separator + "java" + File.separator + "com" + File.separator + "qait"
    			+ File.separator + "sam" + File.separator +"keywords";
    	List<String> envList = getListOfSubdirectory(pageObjectDir);
    	List<String> actionFileNames = getListOfFiles(keywordDir);
    	  	
    	String result = "";
    	for (int i = 0; i < actionFileNames.size(); i++) {
    		try {
    			if (actionFileNames.get(i).equals("")) continue;
	    		String actionFilePath = keywordDir + File.separator + actionFileNames.get(i);
	    		String pageObjectFileName = getPageObjectFileName(actionFilePath) + ".txt";
	    		List<String> listOfElemsInActionFile = getListOfElementNames(actionFilePath);
	    		for (int j = 0; j < envList.size(); j++) {
	    			//System.out.println("Action file name : " + actionFileNames.get(i));
	    			//System.out.println("Environment : " + envList.get(j));
	    			String pageObjectFilePath = pageObjectDir + File.separator + envList.get(j) + 
	    					File.separator + pageObjectFileName;
	    			String resultPageObjFile = getDetailsOfMissingDuplicateExtraElements(pageObjectFilePath, listOfElemsInActionFile);
	    			if (!resultPageObjFile.equals("")) {
	    				result += "*****************************************\n";
	    				result += "Page Object File Name : " + pageObjectFileName + "\n";
	    				result += "Environment : " + envList.get(j) + "\n";
	    				result += "*****************************************\n";
	    				result += resultPageObjFile + "\n";
	    			}
	    		}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if (result.equals(""))
    		System.out.println("All Page Object Files have correct Element Names\n");
    	else
    		System.out.println(result);
    }
    
    public void debugPageObjects(String projDir, String debug) {
    	if (debug.equalsIgnoreCase("true")) {
    		reportPageObjectDescrepancies(projDir);
    	}
    }

	private String getDetailsOfMissingDuplicateExtraElements(String pageObjectFilePath,
			List<String> listOfElemsInActionFile) throws FileNotFoundException {
		String returnStr = "";
		for (int i = 0; i < listOfElemsInActionFile.size(); i++) {
			String elem = listOfElemsInActionFile.get(i);
			int occurance = getOccuranceCountOfElement(pageObjectFilePath, elem);
			if (occurance == 0) {
				returnStr += "Element '" + elem + "' is missing\n";
			} else if (occurance > 1) {
				returnStr += "Element '" + elem + "' is present " + occurance + " times\n";
			}
		}
		return returnStr;
	}


	private int getOccuranceCountOfElement(String pageObjectFilePath, String elem) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(pageObjectFilePath));
    	String line;
    	int count = 0;
    	try {
			while ((line = br.readLine()) != null) {
			   if (line.startsWith(elem + ":")) count++;
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return count;
	}

	private String getPageObjectFileName(String actionFilePath) throws FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(actionFilePath));
    	String line;
    	try {
			while ((line = br.readLine()) != null) {
			   String returnVal = getPageObjectFileNameFromLine(line);
			   if (!returnVal.equals("")){
				   br.close();
				   return returnVal;
			   }
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return "";
	}

	private String getPageObjectFileNameFromLine(String line) {
        String pattern = "super[(]driver,\\s?[\"](.*?)[\"][)]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        while(m.find()){
        	return m.group(1);
        }
        return "";
	}
	
	 public static String downloadZipFile(String downloadLink,String folderName){
		 String filepath = filePathOfDownload + folderName+File.separator;
		 HttpClient httpclient = HttpClientBuilder.create().build();
		 HttpGet httpget = new HttpGet(downloadLink); 
		 HttpEntity entity = null;
		 String fileName = null;
		 HttpResponse response = null;
		  try {
				response = httpclient.execute(httpget);
				entity = response.getEntity();
				Header header = response.getFirstHeader("Content-Disposition");
				try{
					fileName = header.getValue().split("=")[1].replace("\"", "");
				}catch(NullPointerException e){
					   Assert.fail("Assertion Failed : There is something wrong in downloading course package. Although link is present in email "
						   		+ " but the response of link is not a zip package");
					   }
		   } catch (ClientProtocolException e) {
				e.printStackTrace();
		   } catch (IOException e) {
				e.printStackTrace();
		   }
		  InputStream instream = null;
		   if (entity != null) {
				try {
			    	 	instream = entity.getContent();
				        BufferedInputStream bis = new BufferedInputStream(instream);
				        File file = new File(filepath+fileName);
				         if(file.exists())
				        	 file.delete();
					      BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
					      int inByte;
					      while ((inByte = bis.read()) != -1 ) {
					             bos.write(inByte);
					       }
					      	
						   bis.close();
						   bos.close();
			     }catch (UnsupportedOperationException e) {
						e.printStackTrace();
			     } catch (IOException e) {
						e.printStackTrace();
			     }
			     catch (RuntimeException ex) {
			         httpget.abort();
			         throw ex;
			     }
				finally {
			         try {
						instream.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			     }
			}
		 
		   return fileName;
	 }
	
	 public static  Boolean verifyLinkIsValid(String link){
		   URL url;
		   boolean flag = false;
		   	try {
		   			url = new URL(link);
		   			final HttpURLConnection uc = (HttpURLConnection) url.openConnection();
		   			uc.setRequestMethod("GET");
		   			int responceCode = uc.getResponseCode();
		   			if(responceCode==200){
		   				flag = true;
		   			}else{
		   				Assert.fail("Assertion Failed : link - "+ link +" is not valid. Getting responce code :"+ responceCode);
		   			}
		   			
		   	} catch (Exception e) {
			e.printStackTrace();
		   	}
		  return flag;
	   }
}
