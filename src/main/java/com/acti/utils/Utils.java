package com.acti.utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	public static String captureScreenshot(WebDriver driver)
	{
		
		//upcast Takescreenshot interface to driver interface
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenpath="C:/Users/Usha1.thayyil/.ssh/com.acti.automation/acreports/screenshots/acti.png";
		//Take from selenium
		try {
			FileHandler.copy(src, new File(screenpath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenpath;
	}
	
	public static void fnSleep()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		
}
