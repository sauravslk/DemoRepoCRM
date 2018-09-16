package com.crm.qa.test;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname = "Contacts";

	public ContactsPageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		homepage.clickoncontacts();
	}
	@DataProvider
	public  Object[][] getTestData() throws InvalidFormatException, IOException
	{
		 Object[][] data = testutil.getTestData(sheetname);
		return data;
	}
	
	@Test(dataProvider = "getTestData")
	public void clickoncontactslinktest(String title, String fname, String lname, String company) throws IOException
	{
		contactspage = homepage.clickoncontacts();
		contactspage.createnewcontacts(title, fname, lname, company);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
}
