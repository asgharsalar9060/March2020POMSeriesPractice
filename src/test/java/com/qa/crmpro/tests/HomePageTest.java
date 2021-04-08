package com.qa.crmpro.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.crmpro.base.BasePage;
import com.qa.crmpro.pages.HomePage;
import com.qa.crmpro.pages.LoginPage;
import com.qa.crmpro.utils.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties prop;

	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home page title is: "+ title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE, "Home page title does not match...");
	}
	
	@Test(priority=2)
	public void verifyHomePageHeaderTest() {
		Constants.switchToFrame();
		String header = homePage.getHomePageHeader();
		System.out.println("Home page header is: "+ header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER, "Home page header is not present...");
	}
	
	@Test(priority=3)
	public void verifyHomePageLoggedInUserTest() {
		String loggedInUser = homePage.getHomePageLoggedInUser();
		System.out.println("Home page logged in user is: "+ loggedInUser);
		Assert.assertEquals(loggedInUser, "  User: Asghar Salar");
	}
	
	@Test(priority=4)
	public void verifyHomePageUpgradeYourAccountLinkTest() {
		Assert.assertTrue(homePage.getHomePageUpgradeYourAccountLink());
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
