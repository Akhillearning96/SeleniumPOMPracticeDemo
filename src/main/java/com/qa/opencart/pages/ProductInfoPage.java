package com.qa.opencart.pages;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilsection.ElementUtil;

public class ProductInfoPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String,String> prodInfo;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	private By productHeader = By.xpath("//div[@id='product-info']//h1");
	private By pictures = By.cssSelector(".image.magnific-popup img");
	private By metaData = By.xpath("//div[@class='col-sm']//li");
	
	public boolean productPageHeader() {
		return eleUtil.doIsDisplayed(productHeader);
	}
	public int picPresentOnPage() {
		return eleUtil.getElements(pictures).size();
	}
	public Map<String,String> productInfo(){
		 prodInfo = new HashMap<String,String>();
		 metaProductData();
		 return prodInfo;
		 
	}
	private void metaProductData() {
		List<WebElement> metaList = eleUtil.getElements(metaData);
		for(WebElement e : metaList) {
			String text = e.getText();
			String arr[] = text.split(":");
			String metaKey = arr[0].trim();
			String metaValue = arr[1].trim();
			prodInfo.put(metaKey, metaValue);
		}
		
	 
	
	
	
	
	
	
}
}
