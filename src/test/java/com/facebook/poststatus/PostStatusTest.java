package com.facebook.poststatus;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.TestUtil;
import pages.HomePage;
import pages.LoginPage;

public class PostStatusTest extends TestUtil {
	
	
	
	@Test
	@Parameters({"username", "password"})
	public void loginTest(String username, String password) {
		
		LoginPage loginPage = new  LoginPage(driver, log);
		loginPage.openPage(getPageURL());		
		HomePage homePage = loginPage.loginFB(username, password);
		homePage.postStatus(getStatus());		
		
	}

}