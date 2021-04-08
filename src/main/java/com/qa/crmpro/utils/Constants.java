package com.qa.crmpro.utils;

import com.qa.crmpro.base.BasePage;

public class Constants extends BasePage{
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	
	public static final String LOGIN_PAGE_TITLE = "Free CRM - CRM software for customer relationship management, sales, and support.";
	public static final String HOME_PAGE_TITLE = "CRMPRO";
	public static final String HOME_PAGE_HEADER = "CRMPRO";
	
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
	
	

}
