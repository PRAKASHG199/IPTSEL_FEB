package com.pageobjectmanager;

import com.pageobjectmodel.CartPage;
import com.pageobjectmodel.DetailsPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
	private static PageObjectManager PageObjectManager;
    private FileReaderManager fileReader;
    private  LoginPage loginPage;
    private SearchPage searchPage;
    private CartPage cartPage;
    private DetailsPage detailsPage;
    
    public static PageObjectManager getPageObjectManager() {
    	if (PageObjectManager == null) {
    		PageObjectManager = new PageObjectManager(); 	
    	}
    	return PageObjectManager;
    }   
    

public FileReaderManager getFileReader() {
	if(fileReader ==null) {
		fileReader = new FileReaderManager();	
	}
	return fileReader;
}

public LoginPage getLoginPage() {
	if (loginPage == null) {
		loginPage = new LoginPage();
	}
	return loginPage;
}

public SearchPage getSearchPage() {
	if (searchPage == null) {
		searchPage =new SearchPage();
		
	}
	return searchPage;
}

public  CartPage getCartPage() {
	if (cartPage == null) {
		cartPage =new CartPage();
		
	}
	return cartPage;
	

}

public DetailsPage getDetailsPage() {
	if (detailsPage == null) {
		detailsPage =new DetailsPage();
		
	}
	return detailsPage;


}


}


	
