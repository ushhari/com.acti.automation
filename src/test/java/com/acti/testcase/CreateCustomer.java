package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateCustomer extends BaseTest {
//logger.pass("m"): logger.fail("m") ; logger.fail - will be taken care in the aftermethod
// for a test case maximum 1 or 2 validation that decides the status should be kept as pass 
// rest of the steps can be considered as info 
	
	@Test
	public void testCreateCustomer() {
		logger=report.createTest("Create Customer");
		lp.enterUsername("admin");
		logger.info("entered username");
		lp.enterPassword("manager");
		logger.info("entered password");
		lp.clickLoginButton();
		logger.pass("Clicked login button");
		ep.clickTasksMenu();
		logger.info("Clicked task menu");
		tp.ClickAddNewButton();
		logger.info("Clicked add new button");
		tp.ClickNewCustomerDropdown();
		logger.info("Clicked new customer dropdown");
		tp.enterCustomerName("Test Customer2");
		logger.info("Entered customer name");
		tp.enterCustomerDescription("Test Customer Desc");
		logger.info("Entered customer description");
		tp.ClickCreateCustomer();
		logger.info("Clicked create customer button");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actual = tp.VerifySuccessMessage();
		Assert.assertTrue(actual.contains("created"));
		logger.pass("Customer created successfully");
		
	}

}
