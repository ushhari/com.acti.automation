package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;


/*
* Name: TaskMenuPage Script
* Author: Usha
* Verified and Approved: Shanthosh
* Date Last Modified: 2/8/2022
 */
public class TaskPage extends DriverScript {

	//*************************************PageElements**********************//
	
	@FindBy (xpath = "//div[@class='title ellipsis']") WebElement btnAddNew;
	@FindBy(xpath="//div[@class='item createNewCustomer']") WebElement dropdownNewCustomer;
	@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]") WebElement textboxCustomerName;
	@FindBy(xpath="//textarea[@placeholder='Enter Customer Description'] ") WebElement textboxDescription;
	@FindBy(xpath="//div[text()='Create Customer'] ") WebElement btnCreateCustomer;
	@FindBy (xpath = "//span[contains(@class,'innerHtml']") WebElement textSuccessMessage;
	
	
	
	//*************************************Page Initialization**********************//
	
	public  TaskPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//*************************************Page Actions or Methods **********************//
	
	public void ClickAddNewButton()
	{
		btnAddNew.click();
	}
	
	public void ClickNewCustomerDropdown()
	{
		dropdownNewCustomer.click();
	}
	
	public void enterCustomerName(String customername)
	{
		textboxCustomerName.sendKeys(customername);
	}
	
	public void enterCustomerDescription(String description)
	{
		textboxDescription.sendKeys(description);
	}
	
	public void ClickCreateCustomer()
	{
		btnCreateCustomer.click();
	}
	
	public void VerifySuccessMessage()
	{
		textSuccessMessage.getText();
		
	}
	
}
