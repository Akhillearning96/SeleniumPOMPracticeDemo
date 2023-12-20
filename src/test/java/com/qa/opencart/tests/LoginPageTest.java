package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utilsection.Constants;

public class LoginPageTest extends BaseTest {
	

	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginpage.getLoginPageTitle();
		System.out.println("page title is :"+ actTitle);
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority = 2)  
	public void loginPageUrlTest() {
		String actUrl = loginpage.getLoginPageUrl();
		System.out.println("Actual url is : "+ actUrl);
		Assert.assertTrue(actUrl.contains(Constants.LOGIN_PAGE_URL_FRACTION));
			
	}
	@Test(priority = 3)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginpage.isForgotPwdLinkExist());
	}
	
	@Test(priority = 4)
	public void registerLinkTest() {
		Assert.assertTrue(loginpage.isRegisterLinkExist());
	}
	
	@Test(priority = 5)
	public void loginTest() {
		loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		
		Assert.assertEquals(accountPage.accountPageTitle(), Constants.ACCOUNT_PAGE_TITLE);
		
	}
	
	

}
