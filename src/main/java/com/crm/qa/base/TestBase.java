package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase
{
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() throws IOException
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\Saurav\\eclipse-workspace\\FreeCRMTest2\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop = new Properties();
		prop.load(fis);
	
	}
	
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Saurav\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	

}
