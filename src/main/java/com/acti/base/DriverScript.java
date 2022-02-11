package com.acti.base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
* Name: DriverScript
* Description: 
* Author: Usha
* Verified and Approved: Shanthosh
* Date Last Modified: 2/1/2022
 */

public class DriverScript {

	public static WebDriver driver;
	Properties Prop;

	// create constructor
	public DriverScript() {

		// load the configproperties file

		try {
			File src = new File("./acconfig/config.properties");
			FileInputStream fis = new FileInputStream(src);
			Prop = new Properties();
			// inbuilt method
			Prop.load(fis);
		} catch (Exception e) {
			System.out.println("properties file now found please check" + e.getMessage());
		}
	}

	public void initApplication() {
		String browser = Prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./acbrowsers/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./acbrowsers/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./acbrowsers/msedgedriver.exe");
			driver = new EdgeDriver();

		} else {
			System.out.println("This browser not supported please check config file");
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// ((Properties) driver).getProperty("qaurl");
		String url = Prop.getProperty("qaurl");
		driver.get(url);
	}
public void quitBrowser()
{
	driver.quit();
}
}
