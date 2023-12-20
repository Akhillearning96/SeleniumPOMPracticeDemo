package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilsection.Constants;
import com.qa.opencart.utilsection.ElementUtil;

public class AccountPage {
	//1.Declare driver 
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By header = By.cssSelector(".img-fluid");
	private By accSecHeadings = By.cssSelector("#content h2");
	private By search =By.className("input[name='search']");
	private By searchBtn = By.xpath("(//button[@type='button'])[1]");
	private By logout = By.xpath("(//a[text()='Logout'])[2]");
	
	//2.Constructor creation for initializing driver
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		new ElementUtil(driver);
	}
	//3.Action
	public String accountPageTitle() {
		return driver.getTitle();
	}
	public String accountHeaderTitle() {
		return eleUtil.WaitForTheElementToBeVisible(header, Constants.PAGE_WAIT_TIME).getText();
	}
	public String accountPageUrl() {
		return driver.getCurrentUrl();
	
	}
	public List<String> accSecHeadingsCheck() {
		List<WebElement> accList = eleUtil.WaitForTheAllElementToBeVisible(accSecHeadings, Constants.PAGE_WAIT_TIME);
		List<String> accNameList = new ArrayList<String>();
		 for(WebElement e : accList) {
			String text = e.getText();
			accNameList.add(text);
			 
		 }
		 return accNameList;
     }
	public boolean accountPagelogoutExist() {
		return eleUtil.doIsDisplayed(logout);
	}
	public SearchResultsPage accountPageSearchField(String productName) {
		eleUtil.doSendKeys(search, productName);
		eleUtil.doClick(searchBtn);
		return new SearchResultsPage(driver);
	}
	public boolean accountPageLogoutBtnExist() {
		return eleUtil.doIsDisplayed(logout);
	}
	public void accountPageLogoutClick() {
		eleUtil.doClick(logout);
	}
	
}
