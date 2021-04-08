package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class HomePage extends BasePage{

	WebDriver driver;
	
	//1. By locators -- OR
	By upgradeYourAccountLink = By.xpath("//td[@class='headertext']//child::a[contains(text(),'Upgrade your account')]");
	By header = By.xpath("//td[contains(text(),'CRMPRO')]");
	By LoggedInUser = By.xpath("//td[contains(text(),'User: Asghar Salar')]");
	
	//2. page class constructor:
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions:
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeader() {
		return driver.findElement(header).getText();
	}
	
	public String getHomePageLoggedInUser() {
		return driver.findElement(LoggedInUser).getText();
	}
	
	public boolean getHomePageUpgradeYourAccountLink() {
		return driver.findElement(upgradeYourAccountLink).isDisplayed();
	}
	
	
	
}
