package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(name="title")
	WebElement titledesig;
	
	@FindBy(name ="first_name")
	WebElement firstname;
	
	@FindBy(name ="surname")
	WebElement surname;
	
	@FindBy(name ="client_lookup")
	WebElement clientlookup;

	@FindBy(xpath="//input[@class='button']")
	WebElement savebutton;
	
	public ContactsPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel()
	{
		return contactslabel.isDisplayed();
	}
	
	public void selectByVisibleText(String name)
	{
		driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]")).click();
	}
	
	public void createnewcontacts(String title, String fname, String lname, String company)
	{
		Select select = new Select(titledesig);
		select.selectByVisibleText(title);
		firstname.sendKeys(fname);
		surname.sendKeys(lname);
		clientlookup.sendKeys(company);
		savebutton.click();
	}
	
}
