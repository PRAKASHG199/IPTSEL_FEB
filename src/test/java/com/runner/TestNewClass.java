package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.base.Base_Class;
import com.utility.ReadExcelData;

public class TestNewClass extends Base_Class {
	
	
	public static void main(String[] args) throws InterruptedException {
		launchBrowser("chrome");
		driver.manage().window().maximize();
		/*
		 * launchUrl("https://www.facebook.com/");
		 * 
		 * String username = ReadExcelData.getParticularRowData(1,0);
		 * 
		 * String password = ReadExcelData.getParticularRowData(1,1);
		 * 
		 * WebElement element = driver.findElement(By.id("email")); passInput(element,
		 * username); WebElement element2 = driver.findElement(By.id("pass"));
		 * passInput(element2, password);
		 */
		String username = ReadExcelData.getParticularRowData(1,2);
		launchUrl("https://www.youtube.com/");
		WebElement element = driver.findElement(By.xpath("//input[@name='search_query']"));
		passInput(element, username);
		WebElement element2 = driver.findElement(By.xpath("//button[@title='Search']"));
		elementClick(element2);
		Thread.sleep(3000)	;	;
		takeScreenshot("java youtube");
	
		
	}

}
