package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterfaceElements;

public class SearchPage extends Base_Class implements SearchPageInterfaceElements{
	
	@FindBy(linkText = Laptop_linkText)
	private WebElement  laptop;
	
	@FindBy(xpath =Sony_xpath)
	private WebElement sony;
	
	@FindBy(xpath =cart_xpath)
	private WebElement cart;
	
	
	
	public SearchPage() {
		PageFactory.initElements(driver,this);
	}	
		public void searchProduct() throws InterruptedException{
			elementClick(laptop);
			waitForClickable(sony,30);
			elementClick(sony);
			waitForClickable(cart,30);
			elementClick(cart);
			waitAndGetAlertText(50);
			waitAndAcceptAlert(30);
			
		}
	
	
	
	

}
