package com.qait.Domestic.automation.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;



/*
 * Constructor initialise file location of excel file.
 * readExcelFile Method : Reads all the contents from excel file  
 * 						  and returns an ArrayList containing list of HSSFCells
 */

public class ReadWriteExcelFile {
	String fileLocation = null;
	HSSFWorkbook workbook;
	ArrayList<List<HSSFCell>> sheetData;
	FileInputStream fis = null;
	
	public ReadWriteExcelFile(String fileLocation){
		this.fileLocation= fileLocation;
        try{
            fis = new FileInputStream(fileLocation);
            workbook = new HSSFWorkbook(fis);
        }catch(IOException e){e.printStackTrace();}
	}
	
	@SuppressWarnings("rawtypes")
	public String[][] readExcelFileWithSpaces(String sheetName) {
		 HSSFSheet sheet = workbook.getSheet(sheetName);
		 Iterator rows = sheet.rowIterator();
		 int numberOfRow = sheet.getLastRowNum()- sheet.getFirstRowNum();
		 String[][] array = new String[numberOfRow+1][12];
		 int i =0;
	     while (rows.hasNext()){
		       HSSFRow row = ((HSSFRow) rows.next());
		       Iterator cells = row.cellIterator();
		       int previousIndex = 0;
		       int currentIndex = 0;
		       int j=0;
		       while(cells.hasNext()){
			          HSSFCell cell = (HSSFCell) cells.next();
			          currentIndex = cell.getColumnIndex();
			          while(previousIndex < currentIndex){
				           array[i][j++] = "";
				           previousIndex++;
			          }
			          array[i][j++]=getStringValueOfCell(cell);
			          previousIndex = currentIndex+1;
		       }
		       i++;
	      }
	     return array;
	 }
	
	/*returns string value of the cell*/
	public String getStringValueOfCell(HSSFCell cell){
		String value;
		if(cell.getCellType() == 0)
	        value = String.valueOf(cell.getNumericCellValue());
	    else if(cell.getCellType() == 1)
	        value = cell.getStringCellValue();
	    else
	        value = "";
		return value;
	}
	
	public void writeColInExcelFile(String sheetName, String value, int rowNum, int colNum){
		
		HSSFSheet sheet = workbook.getSheet(sheetName);
		try{
			value = value.replaceAll("\\r|\\n", "");
			Cell myCell= sheet.getRow(rowNum).createCell(colNum);
			myCell.setCellType(Cell.CELL_TYPE_STRING);
			myCell.setCellValue(value);
		}catch(Exception ex){
			value = value.replaceAll("\\r|\\n", "");
			Cell myCell=  sheet.createRow(rowNum).createCell(colNum);
			myCell.setCellType(Cell.CELL_TYPE_STRING);
			myCell.setCellValue(value);
		}
        try {
        	FileOutputStream fileOut = new FileOutputStream(fileLocation);
            workbook.write(fileOut);
            fileOut.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void writeColInExcelFile(String sheetName, String value, int rowNum, int colNum, short bg){
		HSSFSheet sheet = workbook.getSheet(sheetName);
		try{
			HSSFCell myCell = sheet.getRow(rowNum).createCell(colNum);
			myCell.setCellType(Cell.CELL_TYPE_STRING);
			myCell.setCellValue(value);
			HSSFCellStyle myStyle = workbook.createCellStyle();
			myStyle.setFillBackgroundColor(bg);
			myStyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);
			myStyle.setFillForegroundColor(bg);
			myStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			myCell.setCellStyle(myStyle);
		}catch(Exception ex){
			HSSFCell myCell =sheet.createRow(rowNum).createCell(colNum);
			myCell.setCellType(Cell.CELL_TYPE_STRING);
			myCell.setCellValue(value);
			HSSFCellStyle myStyle = workbook.createCellStyle();
			myStyle.setFillBackgroundColor(bg);
			myStyle.setFillPattern(HSSFCellStyle.BIG_SPOTS);
			myStyle.setFillForegroundColor(bg);
			myStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			myCell.setCellStyle(myStyle);
		}
    	
        try {
        	FileOutputStream fileOut = new FileOutputStream(fileLocation);
            workbook.write(fileOut);
            fileOut.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

		
	}	
	
	
