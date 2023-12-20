package com.qa.opencart.utilsection;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login"; 
	public static final  String LOGIN_PAGE_URL_FRACTION = "route=account/login"; 
	public static  final int PAGE_WAIT_TIME = 5;
	public static final String ACCOUNT_PAGE_TITLE = "My Account";
	
	public static final  String ACCOUNT_PAGE_URL_FRACTION = "route=account/account&language=en-gb&customer_token=5908380c7313209024c70f9b34"; 
	
	
	public static List<String> ACCOUNT_SECTION_HEADINGS() {
		List<String> actualHeadings = new ArrayList<String>();
		actualHeadings.add("My Account");
		actualHeadings.add("My Orders");
		actualHeadings.add("My Affiliate Account");
		actualHeadings.add("Newsletter");
		
		return actualHeadings;
	}
}
