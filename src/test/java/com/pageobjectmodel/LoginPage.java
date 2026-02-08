package com.pageobjectmodel;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginInterPageFaceElements;
import com.pageobjectmanager.PageObjectManager;

public class LoginPage extends Base_Class implements LoginInterPageFaceElements{
	@FindBy(xpath = Login_xpath)
	private WebElement login;
	
	@FindBy(id =username_id )
	private WebElement username;
	
	@FindBy(css = password_css)
	private WebElement password;
	
	@FindBy(xpath =signin_xpath)
	private WebElement signin;
	
	@FindBy(id = title_id)
	private WebElement title;
	
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	public  void validLogin() throws InterruptedException, IOException {
		elementClick(login);
		waitForVisibility(username,30);
		passInput(username,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("username"));
	passInput(password,PageObjectManager.getPageObjectManager().getFileReader().getDataProperty("password"));
	takeScreenshot("1.login page");
	elementClick(signin);
	waitForVisibility(title,30);
	getText(title);
	
	}

}
