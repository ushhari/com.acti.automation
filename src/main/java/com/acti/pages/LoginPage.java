package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
* Name: LoginPage Script
* Author: Usha
* Verified and Approved: Shanthosh
* Date Last Modified: 2/1/2022
 */

public class LoginPage extends DriverScript {
	// ***************************************************PageElements*****************************************//

	@FindBy(id = "username")WebElement tbUsername;
	@FindBy(name = "pwd")WebElement tbPassword;
	@FindBy(xpath = "//div[text()='Login ']")WebElement btnLogin;
	@FindBy(xpath = "//div[@class='atLogoImg']")WebElement actiLogo;

	// ****************************************************PageInitialization************************************//

	// PageFactory is a class in selenium which is use to initialize current page class elements.

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// ****************************************************Page Actions/Methods************************************//

	public boolean verifyActiLogo() {
		return actiLogo.isDisplayed();
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public void enterUsername(String username) {
		tbUsername.sendKeys(username);
	}

	public void enterPassword(String password)

	{
		tbPassword.sendKeys(password);
	}

	public void clickLoginButton() {
		btnLogin.click();
	}

}
