package com.acti.testcase;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginPageTests extends BaseTest {

	
	
	@Test
	public void testValidateLoginPageDisplayed() {
		
		String title = lp.getLoginPageTitle();
		Assert.assertTrue(title.contains("Login"));
		
	}

	@Test
	public void testValidateActiLogo() {
		boolean flag = lp.verifyActiLogo();
		Assert.assertTrue(flag);
		

	}

	@Test(dataProvider = "actiData")
	public void testLoginFunction(String username, String password) {
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginButton();
		String actual = ep.verifyUserLoggedIn();
		System.out.println(actual);
		ep.clickLogout();
		
	}
	
	}
	







