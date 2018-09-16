package com.crm.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	HomePage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	public HomePageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		homepage = new 	HomePage();
		loginpage = new LoginPage();
		testutil = new TestUtil();
	}

	@Test
	public void HomePageTitleTest()
	{
		String title = homepage.verifyHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test
	public void validateUserLabelTest()
	{
		testutil.switchToFrame();
		boolean flag = homepage.validateuserlabel();
		Assert.assertTrue(flag);
		
	}
	
	@Test
	public void ContactsLinkTest() throws IOException
	{
		testutil.switchToFrame();
		contactspage = homepage.clickoncontacts();
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
}
