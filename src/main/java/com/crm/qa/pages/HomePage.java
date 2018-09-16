package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	@FindBy(xpath="//td[contains(text(),'Naveen K')]")
	WebElement userlabel;
	
	@FindBy(linkText="Contacts")
	WebElement contactslink;
	
	@FindBy(linkText="Deals")
	WebElement dealslink;
	
	@FindBy(linkText="Companies")
	WebElement companieslink;
	
	@FindBy(linkText="New Contact")
	WebElement newcontactlink;
	
	
	public HomePage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateuserlabel()
	{
		return userlabel.isDisplayed();
				
	}
	
	public ContactsPage clickoncontacts() throws IOException
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	public void clickonnewcontact()
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(contactslink).build().perform();
		newcontactlink.click();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	
}
