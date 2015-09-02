/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qait.Canada.automation.util;

/**
 *
 * @author Jav
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.yaml.snakeyaml.Yaml;



public class Utilities {


    public static String yamlFilePath = "";
    HSSFWorkbook workbook;

    public Utilities() {
    	
    }

    public static String setYamlFilePath(String filePath) {
        yamlFilePath = filePath;
        return filePath;
    }

    @SuppressWarnings({"unchecked"})
    public static String getYamlValue(String yamlToken) {
        Reader reader = null;
        int tokenCount = 0, i = 0;
        Map map = null;

        StringTokenizer st = new java.util.StringTokenizer(yamlToken, ".");
        try {
            reader = new FileReader(yamlFilePath);
            String val = null;
            Yaml yaml = new Yaml();
            map = (Map) yaml.load(reader);
            tokenCount = st.countTokens();
            for (i = 1; i < tokenCount; i++) {
                String token = st.nextToken();
                map = (Map) map.get(token);
            }
            val = map.get(st.nextToken()).toString();
            return val;
        } catch (Exception e) {
            System.out.println("Yaml file not found!!!\n" + e);
            return "";
        }
    }

    public static Map getYamlNodesArray(String yamlToken) {
        Reader reader = null;
        int tokenCount = 0, i = 0;
        Map map = null;

        StringTokenizer st = new java.util.StringTokenizer(yamlToken + ".x", ".");
        try {
            reader = new FileReader(yamlFilePath);
            Yaml yaml = new Yaml();
            map = (Map) yaml.load(reader);
            tokenCount = st.countTokens();
            for (i = 1; i < tokenCount; i++) {
                String token = st.nextToken();
                map = (Map) map.get(token);
            }
            return map;
        } catch (Exception e) {
            System.out.println("Either Yaml file not found or there is problem with token passed!!!\n" + e);
            return null;
        }
    }
    

    public static void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
        }

    }
    
    private static String getCurrentFormatedTime() {
		// TODO Auto-generated method stub
    	  DateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss zzz");
			 Date date = new Date();		 
			return dateFormat.format(date);
	}
    
    public static String logOutputFile(String output) {
        File file = new File(Utilities.getYamlValue("logFilePath") + "/logs.txt");

        output = getCurrentFormatedTime() + " " + output + "\n";
        BufferedWriter output1 = null;
        try {
            output1 = new BufferedWriter(new FileWriter(file, true));
            output1.append(output);
            output1.newLine();
            output1.close();
        } catch (Exception e) {
            System.out.println("Exception in logOutputFile" + e.getStackTrace());
        }

        return output;
    }

//  ########################################################################################################

    public static void createFile() throws IOException{
    	  File f;
		  f=new File("OriginalStudentNameCounter.txt");
		  if(!f.exists()){			  
		  f.createNewFile();
		  System.out.println("New file \"myfile.txt\" has been created to the current directory");
		  } else{
			  f.delete();
			  f.createNewFile();
		  }
		  
		  Writer output = null;
		  String text = "Shivam Test2";
		  File file = new File("OriginalStudentNameCounter.txt");
		  output = new BufferedWriter(new FileWriter(file));
		  output.write(text);
		  output.close();
		  System.out.println("Your file has been written"); 
    }

    public static void writeOriginalStudentCounter(String str) throws IOException{
    	 BufferedWriter out = new BufferedWriter(new FileWriter("OriginalStudentNameCounter.txt", true)); 
    	 out.append("\r\n");
		 out.append(str);  // add variable to write in text file
		 out.close();
    }
    
    
    public static String getLastStudentName() throws IOException{
    	 File file = new File("OriginalStudentNameCounter.txt");
		  InputStreamReader streamReader = new InputStreamReader(new FileInputStream(file));		  
		  BufferedReader br = new BufferedReader(streamReader);
		  String line = new String();		 
		  while (br.ready()) {
		 line = br.readLine();		  
		  }		  
//		  System.out.println(line);
		  return line;
    }
    
    
	public static String getFname() throws IOException {
		  
		  
		String m = getLastStudentName();
		String StrFinal = null;
		char[] charArray = m.toCharArray();
		int i = (int) charArray[1];
		
			if(charArray[1] == 'z')
				{
				
				charArray[1] = 'a';
				int j = (int) charArray[0];
				j++;
				char s = (char)j;
				charArray[0] = s;
				StrFinal = new String(charArray);
				}
			
			else{
				
				if (charArray[2] == 'z')
				
				{
				charArray[2] = 'a';
				int j = (int) charArray[1];
				j++;
				char s = (char)j;
				charArray[1] = s;
				StrFinal = new String(charArray);

				}
				else{
					
				i = (int) charArray[2];
				i++;
				char x = (char) i;	
				charArray[2] = x;
				StrFinal = new String(charArray);
				}
			}

			System.out.println("Student Name Picked: Test "+StrFinal);
			writeOriginalStudentCounter(StrFinal);
			
		return StrFinal;
	}
	
	public static void lastRunReportSave(){
		InputStream inStream = null;
		OutputStream outStream = null;
	 
	    	try{
	    		
	    		File file=new File("LastRunReport");
	    		boolean exists = file.exists();
	    		if(!exists)
	    		{
	    			file.mkdir();
	    			
	    		}
	    		
	    		file=new File("LastRunReport/last");
	    		boolean exists1 = file.exists();
	    		if(!exists1)
	    		{
	    			file.mkdir();
	    		}
	    		
	    		
	    		
	    		String str = getLastStudentName()+".html";
	    	    File afile =new File("test-output/emailable-report.html");
	    	    File bfile =new File("LastRunReport/last/"+str);
	 
	    	    inStream = new FileInputStream(afile);
	    	    outStream = new FileOutputStream(bfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;
	    	    //copy the file content in bytes 
	    	    while ((length = inStream.read(buffer)) > 0){
	 
	    	    	outStream.write(buffer, 0, length);
	 
	    	    }
	 
	    	    inStream.close();
	    	    outStream.close();
	 
	    	    System.out.println("File is copied successful!");
	 
	    	}catch(IOException e){
	    		System.out.println("Fail in Save file");
	    	}


	}
    
	public static void renameReportFolder() throws IOException{
		File sourceLocation = new File("LastRunReport/last"); 
		DateFormat dateFormat = new SimpleDateFormat("EEEdMMMyyyyHHmmzzz");
		 Date date = new Date();		 
		String preFix = dateFormat.format(date);
		File targetLocation=new File("LastRunReport/"+preFix);
		
		targetLocation.mkdir();
			
			copyDirectory(sourceLocation,targetLocation);
			
			File directory = new File("LastRunReport/last"); 
			
			
			File[] files = directory.listFiles();
			for (File file : files)
			{
			   // Delete each file

			   if (!file.delete())
			   {
			       // Failed to delete file

			       System.out.println("Failed to delete "+file);
			   }
			} 
	}

	public static void copyDirectory(File sourceLocation , File targetLocation) throws IOException {
	    if (sourceLocation.isDirectory()) {
	        if (!targetLocation.exists()) {
	            targetLocation.mkdir();
	        }

	        String[] children = sourceLocation.list();
	        for (int i=0; i<children.length; i++) {
	            copyDirectory(new File(sourceLocation, children[i]),
	                    new File(targetLocation, children[i]));
	        }
	    } else {

	        InputStream in = new FileInputStream(sourceLocation);
	        OutputStream out = new FileOutputStream(targetLocation);

	        // Copy the bits from instream to outstream
	        byte[] buf = new byte[1024];
	        int len;
	        while ((len = in.read(buf)) > 0) {
	            out.write(buf, 0, len);
	        }
	        in.close();
	        out.close();
	    }
	}

	 public static HSSFCellStyle getStyle(HSSFWorkbook book) throws Exception
	    {
	        // First of all we have to create the style for this book
	        HSSFCellStyle style= book.createCellStyle();
	        
	        // We establish the background color
	        style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
	        style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
	        
	        // We establish a new font for this book
	        HSSFFont font= book.createFont();
	        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	        style.setFont(font);
	        
	        return style;
	    }
	   public static void createExcel(){
	        
	        try {
	        	File file=new File("LastRunReport/last/Result.xls");
	    		boolean exists1 = file.exists();
	    		if(exists1)
	    		{
	    			file.delete();
	    		}
	    		
	            // We create the book. If we'd like to load a book from a file we should write something like this: new HSSFWorkbook(new FileInputStream(file))
	            HSSFWorkbook book = new HSSFWorkbook();
	            
	            // We create the sheet for this book
	            HSSFSheet sheet= book.createSheet("Result");
	            
	            // We create the first row. It starts in 0.
	            HSSFRow row= sheet.createRow(0);
	            
	            // We create the first cell for the row. It starts in 0.
	            HSSFCell cell= row.createCell(0);
	            cell.setCellValue("Course Selected");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(0, 20*600);
	            
	             cell= row.createCell(1);
	            cell.setCellValue("First Name");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(1, 20*150);
	            
	             cell= row.createCell(2);
	            cell.setCellValue("Last Name");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(2, 20*150);
	            
	             cell= row.createCell(3);
	            cell.setCellValue("Email");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(3, 20*350);
	            
	            cell= row.createCell(4);
	            cell.setCellValue("Phone");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(4, 20*180);
	            
	            cell= row.createCell(5);
	            cell.setCellValue("Address");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(5, 20*180);
	            
	            cell= row.createCell(6);
	            cell.setCellValue("City");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(6, 20*150);
	            
	            cell= row.createCell(7);
	            cell.setCellValue("Zip");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(7, 20*120);
	            
	            cell= row.createCell(8);
	            cell.setCellValue("Mode of Payment (Scenarios)");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(8, 20*256);
	            
	            cell= row.createCell(9);
	            cell.setCellValue("StudentID");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(9, 20*256);
	            
	            cell= row.createCell(10);
	            cell.setCellValue("Comments");
	            cell.setCellStyle(getStyle(book));
	            sheet.setColumnWidth(9, 20*256);
	            
	            
	            // We establish the value for that cell
	            
	            
	            // Optional. We establish the cell style 
//	            cell.setCellStyle(getStyle(book));
//	            sheet.setColumnWidth(0, 20*256);
	            
	            // Optional. We establish the column wide. When I open an excel I don't like to click over the column to see all the information inside the cell :) 
	            
	            
	            // Now it's time to record the data in a file making sure we close the file
	            FileOutputStream output= null;
	            try {
	                output= new FileOutputStream("LastRunReport/last/Result.xls");
	                book.write(output);
	                output.close();
	            } catch (FileNotFoundException e) {
	                e.printStackTrace();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }finally{
	                if (output!=null)
	                    output.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	   public static void copyFile()throws IOException {
		   
		   File sourceFile = new File("LastRunReport/last/Result.xls");
	    	File destFile = new File("LastRunReport/ExcelMail/Result.xls");
	    	
			if (!sourceFile.exists()) {
				return;
			}
			if (!destFile.exists()) {
				destFile.createNewFile();
			}
			FileChannel source = null;
			FileChannel destination = null;
			source = new FileInputStream(sourceFile).getChannel();
			destination = new FileOutputStream(destFile).getChannel();
			if (destination != null && source != null) {
				destination.transferFrom(source, 0, source.size());
			}
			if (source != null) {
				source.close();
			}
			if (destination != null) {
				destination.close();
			}
		
		} 
	   
	   
	   public static String getScenario(int activeCourseCount){
		   
		   int TotalNumberofScenario = Integer.parseInt(getYamlValue("PaymentModeScenarios.NumberofScenario"));
		   
		    	int k = activeCourseCount % TotalNumberofScenario;
		    	if (k==0){
		    		k=TotalNumberofScenario;
				    System.out.println("i%j is " + k);
				    return getYamlValue("PaymentModeScenarios.Scenario"+k);

		    	}else{
			    System.out.println("i%j is " + k);		
			    return getYamlValue("PaymentModeScenarios.Scenario"+k);

		    	}
		  
		   
	   }

	}
    


