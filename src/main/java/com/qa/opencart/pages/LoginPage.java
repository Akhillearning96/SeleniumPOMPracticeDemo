package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.qa.opencart.utilsection.ElementUtil;

public class LoginPage {
	
	//1.private web driver
	private WebDriver driver;
	
	private ElementUtil eleUtil;
	
	//2.create page constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;	
		eleUtil = new ElementUtil(driver); 
		
		
	}
	
	//3.Encapsulated By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By registerLink = By.xpath("//a[text()='Register' and @class='list-group-item']");
	private By forgotPwd = By.xpath("(//a[text()='Forgotten Password'])[1]");
	private By loginBtn = By.xpath("//button[text()='Login']");
			
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	public String getLoginPageUrl() {
		return driver.getCurrentUrl();
	}
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwd);
	}
	public boolean isRegisterLinkExist() {
		return eleUtil.doIsDisplayed(registerLink);
	}
	public AccountPage doLogin(String un , String pwd) {
		System.out.println("login details are: username :"+ un + ": password :"+ pwd);
		eleUtil.doSendKeys(emailId, un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
	}

}
