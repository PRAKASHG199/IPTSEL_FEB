package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelData {
	public static  void writeExcelDAatas() {
		
		try {
			 File file = new File ("D:\\JAVA SELENIUM NOTES\\test.xlsx");

			FileInputStream fileinput = new  FileInputStream(file);
			 Workbook book = new XSSFWorkbook(fileinput);
			 book.createSheet("IPT1_FEB_2026").createRow(1).createCell(2).setCellValue("JAVA");
			FileOutputStream fileoutput = new FileOutputStream(file);
			book.write(fileoutput);
			System.out.println("xxxxxxxxxx===success==xxxxxxxxxxx");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}}
		
	public static void main(String[] args) throws IOException {
		writeExcelDAatas();
		
	}

}

