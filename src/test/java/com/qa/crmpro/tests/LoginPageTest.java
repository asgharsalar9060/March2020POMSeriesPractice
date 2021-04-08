package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);	
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: "+title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "Login page title does not match...");
	}
	
	@Test(priority=2)
	public void verifyLoginPageLogoImgTest() {
		Assert.assertTrue(loginPage.getLoginPageLogoImg());
	}
	
	@Test(priority=3)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
}
