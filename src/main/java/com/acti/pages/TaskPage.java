package com.acti.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.acti.base.DriverScript;

/*
* Name: TaskMenuPage Script
* Description: Added Delete Customer methods and elements
* Author: Usha
* Verified and Approved: Shanthosh
* Date Last Modified: 2/14/2022
 */
public class TaskPage extends DriverScript {

	// *************************************PageElements**********************//

	@FindBy(xpath = "//div[@class='title ellipsis']")WebElement btnAddNew;
	@FindBy(xpath = "//div[@class='item createNewCustomer']")WebElement dropdownNewCustomer;
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")	WebElement textboxCustomerName;
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description'] ")WebElement textboxDescription;
	@FindBy(xpath = "//div[text()='Create Customer'] ")	WebElement btnCreateCustomer;
	@FindBy(xpath = "//span[@class='innerHtml']")WebElement textSuccessMessage;
	@FindBy(xpath = "//input[@placeholder='Start typing name ...'][1]")	WebElement textboxExistingCustomerName;
	@FindBy(xpath = "//div[@class='title'][contains(.,'Test 1    (archived)')]") WebElement selectCustomer;
	@FindBy(xpath = "(//div[@class='editButton'])[16]")WebElement buttonSettings;
	@FindBy(xpath = "//div[@class='editCustomerPanelHeader']//div[@class='action'][normalize-space()='ACTIONS']") WebElement dropdownActions;
	@FindBy(xpath = "(//div[@class='title'][contains(.,'Delete')])[1]") WebElement buttonDelete;
	@FindBy(xpath = "//span[contains(.,'Delete permanently')]") WebElement confirmationbuttonDelete;
	@FindBy(xpath = "//span[@class='innerHtml']")WebElement textSuccessMessageDelete;

	// *************************************Page Initialization*****************//

	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

	// *************************************Page Actions or Methods
	// **********************//

	public void ClickAddNewButton() {
		btnAddNew.click();
	}

	public void ClickNewCustomerDropdown() {
		dropdownNewCustomer.click();
	}

	public void enterCustomerName(String customername) {
		textboxCustomerName.sendKeys(customername);
	}

	public void enterCustomerDescription(String description) {
		textboxDescription.sendKeys(description);
	}

	public void ClickCreateCustomer() {
		btnCreateCustomer.click();
	}

	public String VerifySuccessMessage() {
		return textSuccessMessage.getText();
	}

	public void EnterExistingCustomer() {
		textboxExistingCustomerName.sendKeys("Test 1");
	}

	public void SelectCustomerName() {
		selectCustomer.click();
	}

	public void ClickSettings() {
		buttonSettings.click();
	}

	public void dropdownActions() {
		dropdownActions.isSelected();
	}
	public void buttonDelete()
	{
		buttonDelete.click();
	}
	public void confirmationbuttonDelet()
	{
		confirmationbuttonDelete.click();
	}
	public String VerifyDeleteMessage()
	{
		return textSuccessMessageDelete.getText();
	}
}
