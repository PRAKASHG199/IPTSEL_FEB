package com.utility;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData1 {
	 public static void getAllData() {
		 
		 
		 try {
			 File file = new File ("C:\\Users\\GMS\\Desktop\\DataDriven_IPT5.xlsx");
			 Workbook book = new XSSFWorkbook(file);
			 Sheet sheet = book.getSheet("Sheet1");
			 
			 int lastRowNum = sheet.getLastRowNum();
			 System.out.println("LastRowNum:"+lastRowNum);
			 
			 int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
			 System.out.println("TOTAL  ROWS:"+physicalNumberOfRows);
			 
			 short lastCellNum = sheet.getRow(0).getLastCellNum();
			 System.out.println("TOTAL  COLUMNS:"+lastCellNum); 
			 
			 
			 for (int i = 0; i <physicalNumberOfRows; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j <lastCellNum; j++) {
					Cell cell = row.getCell(j);
					DataFormatter dataformat = new DataFormatter();
					String formatCellValue = dataformat.formatCellValue(cell);
					System.out.println(formatCellValue);
				} 
			}
			 
			 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	public static void main(String[] args) {
		getAllData();
		
	}
	
}
 
 