package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	public static String getParticularRowData(int rowValue ,int columnValue) {
		String formatdata = null;
		try {
		
		//File file = new File("C:\\Users\\GMS\\Desktop\\DataDriven_IPT5.xlsx");
			File file = new File("D:\\JAVA SELENIUM NOTES\\test.xlsx");

		Workbook book = new XSSFWorkbook(file);
		Sheet sheet = book.getSheet("IPT1_FEB_2026");
		Row row = sheet.getRow(rowValue);
		Cell cell = row.getCell(columnValue);
		//String data = cell.getStringCellValue();		
		//System.out.println(data);
		DataFormatter dataformat = new DataFormatter();
		 formatdata = dataformat.formatCellValue(cell);
		System.out.println(formatdata);
		
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		
		}
		
		return formatdata;
		

	}

			
	
		

	}
	
	
	
	
	
	
	
	
	
	
	//public static void main(String[] args) {
		//String value =getParticularRowData(2,0);
		//System.out.println(value);
	//}
	
	
	
	
	
	
	
	
	


