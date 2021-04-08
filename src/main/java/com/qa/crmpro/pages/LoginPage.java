package com.qa.crmpro.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crmpro.base.BasePage;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	
	//1. By locators -- OR
	By username = By.name("username");
	By password = By.name("password");
	By loginButton = By.xpath("//input[@type='submit']");
	By loginLogoImg = By.xpath("//a[@class='navbar-brand']//child::img[@class='img-responsive']");
	
	//2. page class constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. page actions:
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean getLoginPageLogoImg() {
		return driver.findElement(loginLogoImg).isDisplayed();
	}
	
	public HomePage doLogin(String username, String password) {
		driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(loginButton).click();
		
		return new HomePage(driver);
	}

}
