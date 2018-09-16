package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	@FindBy(linkText="Sign Up")
	WebElement signUp;

	@FindBy(xpath="//input[@value='Login']")
	WebElement LoginBtn;
	
	public LoginPage() throws IOException
	{
		PageFactory.initElements(driver, this);
	}

	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws IOException
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		LoginBtn.click();
		return new HomePage();
		
	}
	
}
