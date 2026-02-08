package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.CartPageInterfaceElements;
import com.interfaceelements.DetailsPageInterfaceElements;
import com.pageobjectmanager.PageObjectManager;

public class DetailsPage extends Base_Class implements DetailsPageInterfaceElements {
	@FindBy(id =name_id)
	private WebElement name;
	
	@FindBy(id =country_id)
	private WebElement country;
	
	@FindBy(id =city_id)
	private WebElement city;
	
	@FindBy(id =card_id)
	private WebElement card;
	
	@FindBy(id =month_id)
	private WebElement month;
	
	@FindBy(id =year_id)
	private WebElement year;
	
	@FindBy(xpath =purchase_xpath)
	private WebElement purchase;
	
	@FindBy(xpath =thankyou_xpath)
	private WebElement thankyou;
	
	@FindBy(xpath =details_xpath)
	private WebElement details;
	
	@FindBy(xpath =ok_xpath)
	private WebElement ok;
	
	public DetailsPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void detailsSection() throws IOException {
		waitForVisibility(name,30);
		passInput(name, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("name"));
		passInput(country, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("COUNTRY"));
		passInput(city, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("CITY"));
		passInput(card, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("CARD"));
		passInput(month, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("MONTH"));
		passInput(year, PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("YEAR"));
		elementClick(purchase);
		waitForVisibility(thankyou,30);
		takeScreenshot("2.thankyoupage");
		getText(thankyou);
		getText(details);
		elementClick(ok);

		
		
}}
