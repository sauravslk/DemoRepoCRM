package com.crm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
	}
	
	@Test
	public void LoginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test
	public void CRMLogoTest()
	{
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	@Test
	public void LoginTest() throws IOException
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	

}
