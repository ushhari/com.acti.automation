package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.acti.base.DriverScript;

/*
* Name: EnterTimePage Script
* Author: Usha
* Verified and Approved: Shanthosh
* Date Last Modified: 2/1/2022
 */

public class EnterTimePage extends DriverScript {
	
	//*************************************PageElements**********************//
	@FindBy(id="logoutLink") WebElement linkLogout;
	@FindBy(xpath="//a[@class='userProfileLink username ']") WebElement textUserLoggedIn;
	@FindBy(id="//div[@id='container_tasks']") WebElement menuTasks;
	
	//*************************************Page Initialization**********************//
	
	public EnterTimePage()
	{
		PageFactory.initElements(driver, this);
	}

	
	//*************************************Page Actions or Methods **********************//
	
	public String verifyUserLoggedIn()
	{
		return textUserLoggedIn.getText();
	}
	
	public void clickLogout()
	{
		linkLogout.click();
	}
	
	public void clickTasksMenu()
	{
		menuTasks.click();
	}
}
