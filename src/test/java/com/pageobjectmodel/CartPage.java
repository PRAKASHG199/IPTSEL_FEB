package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CartPageInterfaceElements;
import com.interfaceelements.SearchPageInterfaceElements;

public class CartPage extends Base_Class implements CartPageInterfaceElements{
	
	@FindBy(xpath =cartclick_xpath)
	private WebElement cartclick;
	
	@FindBy(xpath =placeorder_xpath)
	private WebElement placeorder;
	
	public CartPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void cartSection() {
		takeScreenshot("2.cartpage");
		elementClick(cartclick);
		elementClick(placeorder);
		
		
	}
	

}
