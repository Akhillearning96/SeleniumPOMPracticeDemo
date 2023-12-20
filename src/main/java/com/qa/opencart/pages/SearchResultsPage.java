package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilsection.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver ;
	private ElementUtil eleUtil;

	
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver ;
		eleUtil = new ElementUtil(driver);
		
	}
	
	By isDisplayed = By.xpath("//div[@id='content']//img");
	
	public int searchItemsDisplay() {
		return eleUtil.getElements(isDisplayed).size();
	
	}
	public ProductInfoPage requiredProductIsDisplayed() {
		List<WebElement> prodList = eleUtil.getElements(isDisplayed);
		
		for(WebElement e : prodList) {
			String text = e.getText();
			if(text.equals("Apple Cinema 30")) {
				e.click();
				break;
			}
			
		}
		return new ProductInfoPage(driver);
	}
}
