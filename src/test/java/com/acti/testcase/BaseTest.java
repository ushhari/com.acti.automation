package com.acti.testcase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.acti.base.DriverScript;
import com.acti.pages.EnterTimePage;
import com.acti.pages.LoginPage;
import com.acti.pages.TaskPage;
import com.acti.utils.ExcelLib;
import com.acti.utils.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/*
 * Name: BaseTest
 * Description: This script is a parent script which has the set of pre-requisites steps before executing actual test case
 * Author: Usha
 * Date Modified: 2/11/2022
 */

public class BaseTest extends DriverScript {
	
	LoginPage lp;
	EnterTimePage ep;
	TaskPage tp;
	ExtentReports report;
	ExtentTest logger;
	// to capture logs
	
	
	//create ExtentHtmlReporter, ExtentReports, ExtentReports method. 
	@BeforeClass
	public void setReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("./acreports/actiauto.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeMethod
	public void setUp()
	{
		initApplication();
		lp = new LoginPage();
		ep = new EnterTimePage();
		tp = new TaskPage();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Utils.captureScreenshot(driver)).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		report.flush();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		quitBrowser();
	}
	
	@DataProvider(name="actiData")
	public Object[][] testData()
	{
		ExcelLib excel = new ExcelLib("./actestdata/actidata.xlsx");
		int rows = excel.getRowCount(0);
		
		Object[][] data = new Object[rows][2];
		
		for(int i=0;i<rows;i++)
		{
			data[i][0]=excel.getCellData(0, i, 0);
			data[i][1]=excel.getCellData(0, i, 1);
		}
		
		return data;	
	}

}

