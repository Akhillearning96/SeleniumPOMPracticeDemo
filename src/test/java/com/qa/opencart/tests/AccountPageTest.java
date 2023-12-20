package com.qa.opencart.tests;

import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.utilsection.Constants;

import junit.framework.Assert;

public class AccountPageTest extends BaseTest {
	
	
@BeforeClass
public void accPageSetup() {
	accountPage = loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
}

@Test(priority = 1)
public void accPageTitleTest() {
	String title = accountPage.accountPageTitle();
	System.out.println("Account page Title is : " + title);
	Assert.assertEquals(title, Constants.ACCOUNT_PAGE_TITLE);
}

@Test(priority = 2)
public void accPageUrlTest() {
	String url = accountPage.accountPageUrl();
	System.out.println("Account page url is :" + url);
	Assert.assertEquals(url, Constants.ACCOUNT_PAGE_URL_FRACTION);

}
@Test(priority = 3)
public void accSecHeadingCheckTest() {
	List<String> secHeadings =	accountPage.accSecHeadingsCheck();
	Assert.assertEquals(secHeadings, Constants.ACCOUNT_SECTION_HEADINGS());
}
@DataProvider
public Object[][]productData() {
	return new Object[][] {
			{"macbook pro"},
			{"Apple"},
			{"Samsung"}
	};
			
}

@Test (priority = 4,dataProvider = "productData")
public void doSearchTest(String productName) {
	accountPage.accountPageSearchField(productName);
	
}

@Test (priority =5)
public void searchPageProdAvailTest() {
	int productCount = searchResult.searchItemsDisplay();
	Assert.assertTrue(productCount>0);
	
}
@Test
public void selectProductTest() {
	ProductInfoPage productInfo = searchResult.requiredProductIsDisplayed();
	String productName = productInfo.toString();
	Assert.assertEquals(productName, "Apple Cinema 30");
	
}
}
