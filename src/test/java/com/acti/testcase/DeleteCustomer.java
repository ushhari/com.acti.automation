package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteCustomer extends BaseTest {

	@Test
	public void TestDeleteCustomer()
	{
		logger=report.createTest("Delete Customer");
		lp.enterUsername("admin");
		logger.info("entered username");
		lp.enterPassword("manager");
		logger.info("entered password");
		lp.clickLoginButton();
		logger.pass("Clicked login button");
		ep.clickTasksMenu();
		logger.info("Clicked task menu");
		tp.EnterExistingCustomer();
		logger.info("Pick an existing customer");
		tp.SelectCustomerName();
		logger.info("Select customer name");
		tp.ClickSettings();
		logger.info("Clicked settings icon");
		tp.dropdownActions();
		logger.info("Click Actions dropdown");
		tp.buttonDelete();
		logger.info("Clicked delete button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = tp.VerifyDeleteMessage();
		Assert.assertTrue(actual.contains("deleted"));
		logger.pass("Customer deleted successfully");
	}
}
